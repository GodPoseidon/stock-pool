package com.huanxian.api.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.auth0.jwt.interfaces.Claim;
import com.huanxian.core.constant.Constant;
import com.huanxian.core.model.LoginUserInfo;
import com.huanxian.core.model.ResultModel;

public class BaseController {

	protected ResultModel successResult(Object data) {
		ResultModel model = new ResultModel("0", "成功！", true);
		model.setData(data);
		return model;
	}
	
	protected ResultModel result(String code, String message, Boolean success, Object data) {
		ResultModel model = new ResultModel(code, message, true);
		model.setData(data);
		return model;
	}

	@SuppressWarnings("unchecked")
	protected LoginUserInfo getCurrentUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		Object o = request.getAttribute(Constant.CURRENT_USER_INFO);
		if(o == null) {
			return null;
		}
		Map<String, Claim> user =  (Map<String, Claim>) o;
		LoginUserInfo info = new LoginUserInfo();
		info.setAccount(user.get("username").asString());
		info.setId(Long.valueOf(user.get("userId").asString()));
		return info;
	}
}
