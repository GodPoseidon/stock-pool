package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 托管模式账号导入请求包
 * @author 张晓宇
 *
 */
public class ReqRegisterAccount {

	/**
	 * (必填)为用户申请同步的帐号，长度为4-24个字符。
	 */
	private String Identifier;
	
	/**
	 * (必填)Identifier的类型，1:手机号(国家码-手机号) 2:邮箱 3:字符串帐号
	 */
	private Integer IdentifierType;
	
	/**
	 * (必填)Identifier的密码，长度为8-16个字符。
	 */
	private String Password;

	@JSONField(name="Identifier")
	public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}

	@JSONField(name="IdentifierType")
	public Integer getIdentifierType() {
		return IdentifierType;
	}

	public void setIdentifierType(Integer identifierType) {
		IdentifierType = identifierType;
	}

	@JSONField(name="Password")
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
