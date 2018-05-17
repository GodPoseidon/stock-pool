package com.huanxian.admin.controller.system;

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
import com.huanxian.core.util.SecurityUtil;
import com.huanxian.entity.SysUserT;
import com.huanxian.service.SysUserService;

import cn.hutool.core.util.StrUtil;

/**
 * 系统用户
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/system/account")
public class UserController extends BaseController {

	@Autowired
	SysUserService sysUserService;

	@GetMapping("/list")
	public String list() {
		return "system/account/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SysUserT> list(String account, String phone, Integer status, Integer length, Integer start) {
		EntityWrapper<SysUserT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(account)) {
			wrapper.like("account", account);
		}
		if (StrUtil.isNotBlank(phone)) {
			wrapper.like("phone", phone);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		PageVo<SysUserT> page = sysUserService.getPage(wrapper, length, (start / length) + 1);
		return page;
	}

	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		if (id != null) {
			SysUserT userT = sysUserService.get(id);
			model.addAttribute("user", userT);
		}
		return "system/account/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SysUserT userT,String newPassword) {
		userT.setModifyTime(new Date());
		userT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		userT.setPassword(SecurityUtil.encryptPassword(userT.getPassword()));
		if (StrUtil.isNotBlank(newPassword)) {
			userT.setPassword(SecurityUtil.encryptPassword(newPassword));
		}
		if (userT.getId() == null) {
			userT.setCreateTime(new Date());
			userT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			sysUserService.add(userT);
		} else {
			sysUserService.update(userT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		SysUserT userT = new SysUserT();
		userT.setId(id);
		userT.setStatus(3);
		sysUserService.update(userT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enanle(Long id) {
		SysUserT userT = new SysUserT();
		userT.setId(id);
		userT.setStatus(1);
		sysUserService.update(userT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SysUserT userT = new SysUserT();
		userT.setId(id);
		userT.setStatus(2);
		sysUserService.update(userT);
		return successResult();
	}
	
	@GetMapping("/changePwd")
	public String changePwd(Model model) {
		if (ShiroUtil.getCurrentUser() != null) {
			model.addAttribute("user", ShiroUtil.getCurrentUser());
			return "system/account/changePwd";
		}else {
			return "login";
		}
		
	}
}
