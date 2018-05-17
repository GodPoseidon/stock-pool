package com.huanxian.admin.controller.live;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.req.ReqCreateGroup;
import com.aikxian.framework.common.TenYun.im.res.ResCreateGroup;
import com.aikxian.framework.common.TenYun.im.service.GroupService;
import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature;
import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature.GenTLSSignatureResult;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.em.BasePropertyPropGroupEnum;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpLiveRoomT;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SpLiveRoomTService;
import com.huanxian.service.SpPreviewLiveTService;
import com.huanxian.service.SysBasePropertyTService;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 直播间
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/liveRoom")
public class LiveRoomController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LiveRoomController.class);

	@Autowired
	private SpLiveRoomTService liveRoomTService;

	@Autowired
	private SysBasePropertyTService sysBasePropertyTService;
	
	@Autowired
	private SpAccountTService spAccountTService;
	
	@Autowired
	private SpPreviewLiveTService spPreviewLiveTService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<Map<Long,String>> teacherList = spAccountTService.getTeacherList();
		model.addAttribute("teacherList", teacherList);
		return "live/liveRoom/list.html";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpLiveRoomT> listData(Long id, String title, Long teacherId, Integer status, Integer length,
			Integer start) {
		EntityWrapper<SpLiveRoomT> wrapper = new EntityWrapper<SpLiveRoomT>();
		if (id != null) {
			wrapper.eq("id", id);
		}
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (teacherId != null) {
			wrapper.eq("teacher_id", teacherId);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.orderBy("modify_time", false);
		PageVo<SpLiveRoomT> page = liveRoomTService.getPage(wrapper, length, start / length + 1);
		return page;
	}

	@GetMapping("/view")
	public String view(Long id, Model model) {
		SpLiveRoomT spLiveRoomT = liveRoomTService.get(id);
		model.addAttribute("live", spLiveRoomT);
		return "/live/liveRoom/view";
	}
	
	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		SpLiveRoomT spLiveRoomT = liveRoomTService.get(id);
		model.addAttribute("live", spLiveRoomT);
		List<Map<Long,String>> teacherList = spAccountTService.getTeacherList();
		model.addAttribute("teacherList", teacherList);
		return "/live/liveRoom/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpLiveRoomT liveRoomT) {
		liveRoomT.setModifyTime(new Date());
		liveRoomT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (liveRoomT.getId() == null) {
			liveRoomT.setCreateTime(new Date());
			liveRoomT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			String groupId = createGroupId(liveRoomT.getTeacherId(), liveRoomT.getTitle());
			liveRoomT.setGroupId(groupId);
			liveRoomTService.insert(liveRoomT);
		} else {
			liveRoomTService.update(liveRoomT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		liveRoomTService.delete(id);
		spPreviewLiveTService.delByRoomId(id);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		liveRoomTService.batchDel(table_records);
		spPreviewLiveTService.batchDelByRoomId(table_records);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		SpLiveRoomT liveRoomT = new SpLiveRoomT();
		liveRoomT.setId(id);
		liveRoomT.setStatus(1);
		liveRoomT.setModifyTime(new Date());
		liveRoomTService.update(liveRoomT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SpLiveRoomT liveRoomT = new SpLiveRoomT();
		liveRoomT.setId(id);
		liveRoomT.setStatus(2);
		liveRoomTService.update(liveRoomT);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/startLive")
	public ResultModel startLive(Long id) {
		SpLiveRoomT liveRoomT = new SpLiveRoomT();
		liveRoomT.setId(id);
		liveRoomT.setLiveStatus(2);
		liveRoomT.setModifyTime(new Date());
		liveRoomT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		liveRoomTService.update(liveRoomT);
		return successResult();
	}

	/**
	 * 关闭直播并断流
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("/endLive")
	public ResultModel endLive(Long id) {
		SpLiveRoomT liveRoomT = new SpLiveRoomT();
		liveRoomT.setId(id);
		liveRoomT.setLiveStatus(1);
		liveRoomT.setModifyTime(new Date());
		liveRoomT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		liveRoomTService.update(liveRoomT);
		forbid(id);
		return successResult();
	}
	
	/**
	 * 获取推流地址
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping("/getPushUrl")
	public ResultModel getPushUrl(Long id) {
		String pushUrl = liveRoomTService.getPushUrl(id);
		return successResult(pushUrl);
		
	}
	
	/**
	 * 断流
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/forbidStream")
	public ResultModel forbid(Long id) {
		ResultModel model = new ResultModel();
		boolean result = liveRoomTService.forbidStream(id);
		if (result) {
			model.setCode("0");
			model.setSuccess(true);
			model.setMessage("断流成功！");
			return model;
		} else {
			model.setCode("0");
			model.setSuccess(false);
			model.setMessage("断流失败！");
			return model;
		}

	}

	public String createGroupId(Long owner_Account, String groupName) {
		Map<String, String> imMap = sysBasePropertyTService.getGroupMap(BasePropertyPropGroupEnum.IM.getEname());
		Map<String, String> sigMap = sysBasePropertyTService.getGroupMap(BasePropertyPropGroupEnum.SIG.getEname());
		AuthConfig authConfig = new AuthConfig();
		String sdkappid = imMap.get("IMSDKAPPID");
		String identifier = imMap.get("IM_MANAGER");
		String privStr = sigMap.get("PRIVATE");
		Long expire = Long.valueOf(sigMap.get("EXPIRE"));
		Long random = System.currentTimeMillis() / Long.valueOf(1 + RandomUtil.randomInt(100000));
		authConfig.setIdentifier(identifier);
		authConfig.setRandom(random.intValue());
		authConfig.setSdkappid(sdkappid);
		GenTLSSignatureResult result = new GenTLSSignatureResult();
		try {
			result = Tls_sigature.GenTLSSignatureEx(Long.valueOf(sdkappid), identifier, privStr, expire);
			if (result.urlSig.length() == 0) {
				LOGGER.error("获取腾讯云签名失败！失败消息:{}", result.errMessage);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		authConfig.setUsersig(result.urlSig);
		GroupService groupService = new GroupService(authConfig);
		ReqCreateGroup createGroup = new ReqCreateGroup();
		createGroup.setName(groupName);
//		createGroup.setOwner_Account(owner_Account.toString());
		createGroup.setType("AVChatRoom");
		createGroup.setApplyJoinOption("FreeAccess");
		ResCreateGroup resCreateGroup = groupService.createGroup(createGroup);
		if (resCreateGroup.getGroupId() == null) {
			LOGGER.error("创建群组ID失败，{}",resCreateGroup.toString());
		}
		return resCreateGroup.getGroupId();
	}

}
