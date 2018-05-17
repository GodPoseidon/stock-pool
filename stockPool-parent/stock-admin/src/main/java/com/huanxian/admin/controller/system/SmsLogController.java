package com.huanxian.admin.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysSmsLogT;
import com.huanxian.service.SysSmsLogTService;

import cn.hutool.core.util.StrUtil;

/**
 * 短信日志
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/system/smsLog")
public class SmsLogController {

	@Autowired
	private SysSmsLogTService sysSmsLogTService;

	@RequestMapping("/list")
	public String list() {
		return "system/smsLog/list";
	}

	@ResponseBody
	@RequestMapping("/listData")
	public PageVo<SysSmsLogT> listData(String phone, Integer state, Integer length, Integer start) {
		EntityWrapper<SysSmsLogT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(phone)) {
			wrapper.like("phone", phone);
		}
		if (state != null) {
			wrapper.eq("state", state);
		}
		wrapper.orderBy("send_time",false);
		PageVo<SysSmsLogT> page = sysSmsLogTService.getPage(wrapper, length, (start / length) + 1);
		return page;
	}

}
