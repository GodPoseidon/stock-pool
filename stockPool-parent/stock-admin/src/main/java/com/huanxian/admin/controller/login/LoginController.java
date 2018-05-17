package com.huanxian.admin.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huanxian.common.web.WebUtil;
import com.huanxian.core.exception.LoginFailException;
import com.huanxian.core.model.ResultModel;

@Controller
public class LoginController {

	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResultModel login(String username, String password, HttpServletRequest request) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, WebUtil.getHost(request));
		Subject subject = SecurityUtils.getSubject();		
		try {
			subject.login(token);
		} catch (LockedAccountException e) {
			throw new LoginFailException("1003", "账号被锁定！请联系管理员！！");
		} catch (DisabledAccountException e) {
			throw new LoginFailException("1004", "账号不存在！！");
		} catch (ExpiredCredentialsException e) {
			throw new LoginFailException("1002", "登录失效！！");
		} catch (Exception e) {
			throw new LoginFailException("1001", "登录失败！！");
		}
		ResultModel resultModel = new ResultModel();
		resultModel.setCode("0");
		resultModel.setMessage("登录成功！");
		resultModel.setSuccess(true);
		return resultModel;
	}
}
