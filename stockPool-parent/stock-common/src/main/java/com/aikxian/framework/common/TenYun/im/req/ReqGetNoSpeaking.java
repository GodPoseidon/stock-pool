package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 查询全局禁言
 * @author 张晓宇
 * @date 2017年6月13日 下午5:01:31
 */
public class ReqGetNoSpeaking {

	/**
	 * 查询禁言信息的帐号。
	 */
	private String Get_Account;

	@JSONField(name = "Get_Account")
	public String getGet_Account() {
		return Get_Account;
	}

	public void setGet_Account(String get_Account) {
		Get_Account = get_Account;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
