package com.huanxian.core.jwt;

import java.util.Calendar;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {

	/**
	 * 自动义盐值
	 */
	private String saltValue = "stock-salt-token";
	
	/**
	 * 开启jwt登录验证   默认:false
	 */
	private Boolean loginVaildate = false;
	
	/**
	 * token存活时间，默认：30
	 */
	private Integer tokenExpires = 30;
	/**
	 * 有效时间单位，默认：分钟      参考{@link #Calendar}
	 */
	private Integer timeField = Calendar.MINUTE;

	public Integer getTokenExpires() {
		return tokenExpires;
	}

	public void setTokenExpires(Integer tokenExpires) {
		this.tokenExpires = tokenExpires;
	}

	public Integer getTimeField() {
		return timeField;
	}

	public void setTimeField(Integer timeField) {
		this.timeField = timeField;
	}

	public String getSaltValue() {
		return saltValue;
	}

	public void setSaltValue(String saltValue) {
		this.saltValue = saltValue;
	}

	public Boolean getLoginVaildate() {
		return loginVaildate;
	}

	public void setLoginVaildate(Boolean loginVaildate) {
		this.loginVaildate = loginVaildate;
	}
	
	
}
