package com.huanxian.admin.shiro;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = ShiroProperties.SHIRO_PREFIX)
public class ShiroProperties {

	public static final String SHIRO_PREFIX = "shiro";
	/**
	 * 登录地址
	 */
	private String loginUrl = "login";

	/**
	 * 成功登录跳转地址
	 */
	private String successUrl = "index";

	/**
	 * 无权限时跳转地址
	 */
	private String unauthorizedUrl = "403";
	
	/**
	 * 记住密码时长时间
	 */
	private Integer rememberTime = 30;
	
	/**
	 *是否开启shiro，defult:true
	 */
	private Boolean enable = true;
	
	
	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	public String getUnauthorizedUrl() {
		return unauthorizedUrl;
	}

	public void setUnauthorizedUrl(String unauthorizedUrl) {
		this.unauthorizedUrl = unauthorizedUrl;
	}

	public Integer getRememberTime() {
		return rememberTime;
	}

	public void setRememberTime(Integer rememberTime) {
		this.rememberTime = rememberTime;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	

}
