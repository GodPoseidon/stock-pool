package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 全局禁言请求包
 * @author 张晓宇
 * @date 2017年6月13日 下午4:55:27
 */
public class ReqSetNoSpeaking {

	/**
	 * 设置禁言配置的帐号。
	 */
	private String Set_Account;
	
	/**
	 * 单聊消息禁言时间，秒为单位，非负整数，最大值为4294967295(十六进制0xFFFFFFFF)。等于0代表取消账户禁言；等于最大值4294967295(十六进制0xFFFFFFFF)代表账户永久被设置禁言；其它代表该账户禁言时间。
	 */
	private Integer C2CmsgNospeakingTime;
	/**
	 * 群组消息禁言时间，秒为单位，非负整数，最大值为4294967295(十六进制0xFFFFFFFF)。0代表取消帐号禁言；最大值4294967295(0xFFFFFFFF)代表账户永久禁言；其它代表该账户禁言时间。
	 */
	private Integer GroupmsgNospeakingTime;

	@JSONField(name="Set_Account")
	public String getSet_Account() {
		return Set_Account;
	}

	public void setSet_Account(String set_Account) {
		Set_Account = set_Account;
	}

	@JSONField(name="C2CmsgNospeakingTime")
	public Integer getC2CmsgNospeakingTime() {
		return C2CmsgNospeakingTime;
	}

	public void setC2CmsgNospeakingTime(Integer c2CmsgNospeakingTime) {
		C2CmsgNospeakingTime = c2CmsgNospeakingTime;
	}

	@JSONField(name="GroupmsgNospeakingTime")
	public Integer getGroupmsgNospeakingTime() {
		return GroupmsgNospeakingTime;
	}

	public void setGroupmsgNospeakingTime(Integer groupmsgNospeakingTime) {
		GroupmsgNospeakingTime = groupmsgNospeakingTime;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
