package com.aikxian.framework.common.TenYun.livecode.model;

import com.alibaba.fastjson.annotation.JSONField;

public abstract class  BaseReqParams {

	/**
	 * 	客户ID
	 */
	private Integer appid;
	
	/**
	 * 接口名称
	 */
	@JSONField(name = "interface")
	private String _interface;
	
	/**
	 * 有效时间
	 */
	@JSONField(name = "t")
	private Integer expire_time;
	
	/**
	 * 安全签名
	 */
	private String sign;

	
	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String get_interface() {
		return _interface;
	}

	public void set_interface(String _interface) {
		this._interface = _interface;
	}


	public Integer getExpire_time() {
		return expire_time;
	}

	public void setExpire_time(Integer expire_time) {
		this.expire_time = expire_time;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
	 
	
}
