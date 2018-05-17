package com.huanxian.admin.controller.live;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpLiveReplayT;
import com.huanxian.service.SpLiveReplayTService;

import cn.hutool.core.util.StrUtil;

/**
 * 直播回放
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/live/replay")
public class ReplayController extends BaseController {

	@Autowired
	private SpLiveReplayTService liveReplayTService;
	
	@RequestMapping("/list")
	public String list(Long roomId, Model model) {
		model.addAttribute("roomId", roomId);
		return "live/replay/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpLiveReplayT> listData(Long roomId, String title, Integer status, Integer length, Integer start) {
		EntityWrapper<SpLiveReplayT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status != null) {
			wrapper.eq("status", status);
		} else {
			wrapper.ne("status", 3);
		}
		wrapper.eq("room_id", roomId);
		wrapper.orderBy("modify_time", false);
		PageVo<SpLiveReplayT> page = liveReplayTService.getPage(wrapper, length, start / length + 1);
		return page;
	}

	@GetMapping("/edit")
	public String get(Long id,Long roomId,Model model) {
		SpLiveReplayT spLiveReplayT = liveReplayTService.get(id);
		if (roomId != null) {
			spLiveReplayT = new SpLiveReplayT();
			spLiveReplayT.setRoomId(roomId);
		}
		model.addAttribute("replay", spLiveReplayT);
		return "live/replay/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpLiveReplayT liveReplayT) {
		liveReplayT.setModifyTime(new Date());
		liveReplayT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (liveReplayT.getId() == null) {
			liveReplayT.setCreateTime(new Date());
			liveReplayT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			liveReplayTService.insert(liveReplayT);
		} else {
			liveReplayTService.update(liveReplayT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		SpLiveReplayT entity = new SpLiveReplayT();
		entity.setId(id);
		entity.setStatus(1);
		entity.setModifyTime(new Date());
		liveReplayTService.update(entity);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SpLiveReplayT entity = new SpLiveReplayT();
		entity.setId(id);
		entity.setStatus(2);
		entity.setModifyTime(new Date());
		liveReplayTService.update(entity);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		liveReplayTService.delete(id);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		liveReplayTService.batchDel(table_records);
		return successResult();
	}
}
