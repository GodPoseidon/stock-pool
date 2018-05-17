package com.aikxian.framework.common.TenYun.im.model;

import com.aikxian.framework.common.TenYun.im.uitl.Tls_sigature;

/**
 * 鉴权配置
 * @author 张晓宇
 *
 */
public class AuthConfig {

	/**
	 * 应用id
	 */
	private String sdkappid;
	
	/**
	 * 管理员账号
	 */
	private String identifier;
	
	/**
	 * 签名
	 * 私钥签名{@link Tls_sigature}
	 */
	private String usersig;
	/**
	 * 随机数
	 */
	private Integer random;
	
	/**
	 * 内容格式，默认json
	 */
	private String contenttype = "json";

	public String getSdkappid() {
		return sdkappid;
	}

	public void setSdkappid(String sdkappid) {
		this.sdkappid = sdkappid;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getUsersig() {
		return usersig;
	}

	public void setUsersig(String usersig) {
		this.usersig = usersig;
	}

	public Integer getRandom() {
		return random;
	}

	public void setRandom(Integer random) {
		this.random = random;
	}

	public String getContenttype() {
		return contenttype;
	}

	public void setContenttype(String contenttype) {
		this.contenttype = contenttype;
	}
	
	
}
