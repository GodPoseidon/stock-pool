package com.aikxian.framework.common.TenYun.livecode.model;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseResData {

	/**
	 * 返回码   	0:成功；其他值:失败
	 */
	@JSONField(name = "ret")
	private Integer code;
	
	/**
	 * 	错误信息
	 */
	private String message;
	
	private String errmsg;


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getErrmsg() {
		return errmsg;
	}


	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}


	
	
	
}
