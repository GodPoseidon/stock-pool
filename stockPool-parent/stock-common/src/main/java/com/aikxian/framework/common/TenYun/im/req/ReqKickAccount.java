package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 账号登陆失效请求包
 * @author 张晓宇
 *
 */
public class ReqKickAccount {

	/**
	 * (必填)用户名
	 */
	private String Identifier;

	@JSONField(name = "Identifier")
	public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
