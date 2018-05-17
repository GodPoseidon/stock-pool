package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

public class Msg {

	private String From_Account;

	private Integer SendTime;

	private Integer Random;

	private MsgBody MsgBody;

	@JSONField(name = "From_Account")
	public String getFrom_Account() {
		return From_Account;
	}

	public void setFrom_Account(String from_Account) {
		From_Account = from_Account;
	}

	@JSONField(name = "SendTime")
	public Integer getSendTime() {
		return SendTime;
	}

	public void setSendTime(Integer sendTime) {
		SendTime = sendTime;
	}

	@JSONField(name = "Random")
	public Integer getRandom() {
		return Random;
	}

	public void setRandom(Integer random) {
		Random = random;
	}

	@JSONField(name = "MsgBody")
	public MsgBody getMsgBody() {
		return MsgBody;
	}

	public void setMsgBody(MsgBody msgBody) {
		MsgBody = msgBody;
	}

}
