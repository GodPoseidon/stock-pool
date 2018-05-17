package com.huanxian.api.controller;

import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huanxian.core.exception.BaseException;
import com.huanxian.core.exception.LoginFailException;
import com.huanxian.core.exception.LogonExpiresException;
import com.huanxian.core.model.ResultModel;

/**
 * 异常处理
 * @author 张晓宇
 * @date 2018年4月19日 下午9:15:05
 */
@ControllerAdvice
public class HandlerExceptionController {

	/**
	 * 自定义异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ BaseException.class })
	@ResponseBody
	public ResultModel handlerBusinessException(BaseException e) {
		ResultModel model = new ResultModel();
		model.setCode(e.getCode());
		model.setMessage(e.getMessage());
		if(e instanceof LogonExpiresException) {
			model.setCode("1002");
			model.setMessage("token过期失效！");
		}
		if(e instanceof LoginFailException) {
			model.setCode("1001");
			model.setMessage("未登录！！！！");
		}
		model.setSuccess(false);
		return model;
	}

	/**
	 * hibernate 校验异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ BindException.class })
	@ResponseBody
	public ResultModel handlerBusinessException(BindException e) {
		BindingResult bindingResult = e.getBindingResult();
		List<FieldError> errors = bindingResult.getFieldErrors();
		ResultModel model = new ResultModel();
		model.setCode("102");
		for (FieldError fieldError : errors) {
			model.setMessage(fieldError.getDefaultMessage());
			break;
		}
		model.setSuccess(false);
		return model;
	}
}
