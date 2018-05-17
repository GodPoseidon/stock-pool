package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

public class MemberAccount {

	
	/**
	 * 群成员ID
	 */
	private String Member_Account;
	
	/**
	 * 群内身份
	 */
	private String Role;
	
	/**
	 * 入群时间
	 */
	private Integer JoinTime;
	
	/**
	 * 该成员当前已读消息Seq
	 */
	private Integer MsgSeq;
	
	/**
	 * 消息接收选项
	 */
	private String MsgFlag;
	
	/**
	 * 最后发送消息的时间
	 */
	private Integer LastSendMsgTime;
	
	/**
	 * 群名片
	 */
	private String NameCard;

	@JSONField(name = "Member_Account")
	public String getMember_Account() {
		return Member_Account;
	}

	public void setMember_Account(String member_Account) {
		Member_Account = member_Account;
	}

	@JSONField(name = "Role")
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@JSONField(name = "JoinTime")
	public Integer getJoinTime() {
		return JoinTime;
	}

	public void setJoinTime(Integer joinTime) {
		JoinTime = joinTime;
	}

	@JSONField(name = "MsgSeq")
	public Integer getMsgSeq() {
		return MsgSeq;
	}

	public void setMsgSeq(Integer msgSeq) {
		MsgSeq = msgSeq;
	}

	@JSONField(name = "MsgFlag")
	public String getMsgFlag() {
		return MsgFlag;
	}

	public void setMsgFlag(String msgFlag) {
		MsgFlag = msgFlag;
	}

	@JSONField(name = "LastSendMsgTime")
	public Integer getLastSendMsgTime() {
		return LastSendMsgTime;
	}

	public void setLastSendMsgTime(Integer lastSendMsgTime) {
		LastSendMsgTime = lastSendMsgTime;
	}

	@JSONField(name = "NameCard")
	public String getNameCard() {
		return NameCard;
	}

	public void setNameCard(String nameCard) {
		NameCard = nameCard;
	}
	
}
