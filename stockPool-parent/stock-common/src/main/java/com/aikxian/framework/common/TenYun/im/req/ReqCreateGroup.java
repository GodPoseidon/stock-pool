package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.AppDefinedData;
import com.aikxian.framework.common.TenYun.im.model.AppMemberDefinedData;
import com.aikxian.framework.common.TenYun.im.model.Role;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqCreateGroup {

	/**
	 * 群主id，自动添加到群成员中。如果不填，群没有群主。选填
	 */
	private String Owner_Account;

	/**
	 * 群组形态，包括Public（公开群），Private（私密群），ChatRoom（聊天室），AVChatRoom（互动直播聊天室），BChatRoom（在线成员广播大群）.必填
	 */
	private String Type;

	/**
	 * 为了使得群组ID更加简单，便于记忆传播，腾讯云支持APP在通过REST API创建群组时自定义群组ID.选填
	 */
	private String GroupId;
	/**
	 * 群名称，最长30字节。必填
	 */
	private String Name;

	/**
	 * 群简介，最长240字节。选填
	 */
	private String Introduction;

	/**
	 * 群公告，最长300字节。选填
	 */
	private String Notification;

	/**
	 * 群头像URL，最长100字节。选填
	 */
	private String FaceUrl;

	/**
	 * 最大群成员数量，缺省时的默认值：私有群是200，公开群是2000，聊天室是10000，互动直播聊天室和在线成员广播大群无限制。选填
	 */
	private Integer MaxMemberCount;

	/**
	 * 申请加群处理方式。包含FreeAccess（自由加入），NeedPermission（需要验证），DisableApply（禁止加群），不填默认为NeedPermission（需要验证）。选填
	 */
	private String ApplyJoinOption;

	/**
	 * 群组维度的自定义字段，默认情况是没有的，需要开通，选填
	 */
	private List<AppDefinedData> AppDefinedData;
	
	/**
	 * 初始群成员列表，最多500个。选填
	 */
	private List<MemberList> MemberList;
	
	/**
	 * 群成员维度的自定义字段，默认情况是没有的，需要开通。选填
	 */
	private List<AppMemberDefinedData> AppMemberDefinedData;	
	

	@JSONField(name = "MemberList")
	public List<MemberList> getMemberList() {
		return MemberList;
	}

	public void setMemberList(List<MemberList> memberList) {
		MemberList = memberList;
	}

	@JSONField(name = "AppMemberDefinedData")
	public List<AppMemberDefinedData> getAppMemberDefinedData() {
		return AppMemberDefinedData;
	}

	
	public void setAppMemberDefinedData(List<AppMemberDefinedData> appMemberDefinedData) {
		AppMemberDefinedData = appMemberDefinedData;
	}
	
	@JSONField(name = "Owner_Account")
	public String getOwner_Account() {
		return Owner_Account;
	}

	public void setOwner_Account(String owner_Account) {
		Owner_Account = owner_Account;
	}

	@JSONField(name = "Type")
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@JSONField(name = "Name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@JSONField(name = "Introduction")
	public String getIntroduction() {
		return Introduction;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	@JSONField(name = "Notification")
	public String getNotification() {
		return Notification;
	}

	public void setNotification(String notification) {
		Notification = notification;
	}

	@JSONField(name = "FaceUrl")
	public String getFaceUrl() {
		return FaceUrl;
	}

	public void setFaceUrl(String faceUrl) {
		FaceUrl = faceUrl;
	}

	@JSONField(name = "MaxMemberCount")
	public Integer getMaxMemberCount() {
		return MaxMemberCount;
	}

	public void setMaxMemberCount(Integer maxMemberCount) {
		MaxMemberCount = maxMemberCount;
	}

	@JSONField(name = "ApplyJoinOption")
	public String getApplyJoinOption() {
		return ApplyJoinOption;
	}

	public void setApplyJoinOption(String applyJoinOption) {
		ApplyJoinOption = applyJoinOption;
	}

	@JSONField(name = "AppDefinedData")
	public List<AppDefinedData> getAppDefinedData() {
		return AppDefinedData;
	}

	public void setAppDefinedData(List<AppDefinedData> appDefinedData) {
		AppDefinedData = appDefinedData;
	}
	
	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}


	public class MemberList {

		private String Account;

		private Role Role;

		private List<AppMemberDefinedData> AppMemberDefinedData;

		@JSONField(name = "Account")
		public String getAccount() {
			return Account;
		}

		public void setAccount(String account) {
			Account = account;
		}

		@JSONField(name = "Role")
		public Role getRole() {
			return Role;
		}

		public void setRole(Role role) {
			Role = role;
		}

		public List<AppMemberDefinedData> getAppMemberDefinedData() {
			return AppMemberDefinedData;
		}

		public void setAppMemberDefinedData(List<AppMemberDefinedData> appMemberDefinedData) {
			AppMemberDefinedData = appMemberDefinedData;
		}

	}
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
