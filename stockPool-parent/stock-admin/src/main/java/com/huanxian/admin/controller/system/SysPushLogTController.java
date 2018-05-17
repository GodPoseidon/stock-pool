package com.huanxian.admin.controller.system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
import com.huanxian.common.web.JPushUtil;
import com.huanxian.core.em.BasePropertyPropGroupEnum;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SysPushLogT;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SysBasePropertyTService;
import com.huanxian.service.SysPushLogTService;

import cn.hutool.core.util.StrUtil;
import cn.jiguang.common.DeviceType;
import cn.jpush.api.push.PushResult;

/**
 * <p>
 * 推送日志表 前端控制器
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/pushLog")
public class SysPushLogTController extends BaseController {

	@Autowired
	private SysPushLogTService logTService;

	@Autowired
	private SpAccountTService spAccountTService;

	@Autowired
	private SysBasePropertyTService sysBasePropertyTService;

	@RequestMapping("/list")
	public String list() {
		return "pushLog/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SysPushLogT> listData(String title, Integer status, Integer length, Integer start) {
		EntityWrapper<SysPushLogT> wrapper = new EntityWrapper<SysPushLogT>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.orderBy("create_time", false);
		PageVo<SysPushLogT> page = logTService.getPage(wrapper, length, start / length + 1);
		return page;
	}

	@GetMapping("/add")
	public String get() {
		return "pushLog/add";
	}

	@RequestMapping("/view")
	public String view(Long id, Model model) {
		SysPushLogT logT = logTService.get(id);
		model.addAttribute("log", logT);
		return "/pushLog/view";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SysPushLogT logT) {
		ResultModel model = new ResultModel();
		logT.setCreateTime(new Date());
		logT.setCreateUser(ShiroUtil.getCurrentUser().getName());
		Integer insert = logTService.insert(logT);
		if (insert > 0) {
			model.setCode("0");
			model.setMessage("新增成功！");
			model.setSuccess(true);
		} else {
			model.setCode("404");
			model.setMessage("新增失败！");
			model.setSuccess(false);
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/push")
	public ResultModel push(Long id) {
		ResultModel model = new ResultModel();
		SysPushLogT logT = logTService.get(id);
		if (logT == null) {
			model.setCode("500");
			model.setSuccess(false);
			model.setMessage("该记录不存在！");
		} else {
			// IOS设备
			if (DeviceType.IOS.name().toUpperCase().equals(logT.getPlatform())) {
				Boolean result = push_message_of_ios(logT);
				if (result) {
					logT.setStatus(1);
					logTService.update(logT);
					model.setCode("0");
					model.setMessage("发布成功");
					model.setSuccess(true);
				} else {
					logT.setStatus(0);
					logTService.update(logT);
					model.setCode("500");
					model.setMessage("发布失败");
					model.setSuccess(false);
				}

			}
			// 安卓设备
			if (DeviceType.Android.name().toUpperCase().equals(logT.getPlatform())) {
				Boolean result = push_message_of_android(logT);
				if (result) {
					logT.setStatus(1);
					logTService.update(logT);
					model.setCode("0");
					model.setMessage("发布成功");
					model.setSuccess(true);
				} else {
					logT.setStatus(0);
					logTService.update(logT);
					model.setCode("500");
					model.setMessage("发布失败");
					model.setSuccess(false);
				}

			}
			// 所有设备
			if ("ALL".equals(logT.getPlatform())) {
				Boolean android = push_message_of_android(logT);
				Boolean ios = push_message_of_ios(logT);
				if (android && ios) {
					logT.setStatus(1);
					logTService.update(logT);
					model.setCode("0");
					model.setMessage("发布成功");
					model.setSuccess(true);
				} else {
					logT.setStatus(0);
					logTService.update(logT);
					model.setCode("500");
					model.setMessage("发布失败");
					model.setSuccess(false);
				}
			}
		}
		return model;
	}

	/**
	 * 安卓极光推送
	 * 
	 * @param logT
	 * @return
	 */
	public Boolean push_message_of_android(SysPushLogT logT) {
		Map<String, String> groupMap = sysBasePropertyTService.getGroupMap(BasePropertyPropGroupEnum.JPUSH.getEname());
		List<String> registrationIdList = spAccountTService.getRegistrationIdList(DeviceType.Android.name());
		List<String> RegistrationIdListByPushStatus = null;
		LocalDateTime dateTime = LocalDateTime.now();
		int hour = dateTime.getHour();
		if (hour > 7 && hour < 21) {
			RegistrationIdListByPushStatus = spAccountTService
					.getRegistrationIdListByPushStatus(DeviceType.Android.name());
		}
		registrationIdList.addAll(RegistrationIdListByPushStatus);
		HashSet<String> hashSet = new HashSet<>(registrationIdList);
		registrationIdList.clear();
		registrationIdList.addAll(hashSet);
		if (registrationIdList != null && registrationIdList.size() > 0) {
			// 极光推送一次只能推送1000条
			List<List<String>> pushIdList = splitList(registrationIdList, 1000);
			PushResult jpush_Android_Extra = null;
			for (List<String> list : pushIdList) {
				jpush_Android_Extra = JPushUtil.Jpush_Android_Extra(list, logT.getTitle(), logT.getContent(), groupMap,
						null);
			}
			return jpush_Android_Extra.isResultOK();
		}
		return false;
	}

	/**
	 * IOS极光推送
	 * 
	 * @param logT
	 * @return
	 */
	public Boolean push_message_of_ios(SysPushLogT logT) {
		Map<String, String> groupMap = sysBasePropertyTService.getGroupMap(BasePropertyPropGroupEnum.JPUSH.getEname());
		List<String> registrationIdList = spAccountTService.getRegistrationIdList(DeviceType.IOS.name());
		List<String> registrationIdListByPushStatus = null;
		LocalDateTime dateTime = LocalDateTime.now();
		int hour = dateTime.getHour();
		if (hour > 7 && hour < 21) {
			registrationIdListByPushStatus = spAccountTService.getRegistrationIdListByPushStatus(DeviceType.IOS.name());
		}
		registrationIdList.addAll(registrationIdListByPushStatus);
		HashSet<String> hashSet = new HashSet<>(registrationIdList);
		registrationIdList.clear();
		registrationIdList.addAll(hashSet);
		if (registrationIdList != null && registrationIdList.size() > 0) {
			// 极光推送一次只能推送1000条
			List<List<String>> pushIdList = splitList(registrationIdList, 1000);
			PushResult jpush_ios_Extra = null;
			for (List<String> list : pushIdList) {
				jpush_ios_Extra = JPushUtil.Jpush_Ios_Extra(list, logT.getTitle(), logT.getContent(), groupMap, null);
			}
			return jpush_ios_Extra.isResultOK();
		}
		return false;
	}

	/**
	 * 按指定大小，分隔集合，将集合按规定个数分为n个部分
	 * 
	 * @param list
	 * @param len
	 * @return
	 */
	public static <T> List<List<T>> splitList(List<T> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}

		List<List<T>> result = new ArrayList<List<T>>();

		int size = list.size();
		int count = (size + len - 1) / len;

		for (int i = 0; i < count; i++) {
			List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}
}
