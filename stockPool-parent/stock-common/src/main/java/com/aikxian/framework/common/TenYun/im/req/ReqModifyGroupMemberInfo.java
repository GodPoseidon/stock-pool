package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.AppMemberDefinedData;
import com.aikxian.framework.common.TenYun.im.model.Role;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqModifyGroupMemberInfo {

	private String GroupId;

	private String Member_Account;

	private Role Role;

	private String MsgFlag;

	private String NameCard;

	private List<AppMemberDefinedData> AppMemberDefinedData;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "Member_Account")
	public String getMember_Account() {
		return Member_Account;
	}

	public void setMember_Account(String member_Account) {
		Member_Account = member_Account;
	}

	@JSONField(name = "Role")
	public Role getRole() {
		return Role;
	}

	public void setRole(Role role) {
		Role = role;
	}

	@JSONField(name = "MsgFlag")
	public String getMsgFlag() {
		return MsgFlag;
	}

	public void setMsgFlag(String msgFlag) {
		MsgFlag = msgFlag;
	}

	@JSONField(name = "NameCard")
	public String getNameCard() {
		return NameCard;
	}

	public void setNameCard(String nameCard) {
		NameCard = nameCard;
	}

	@JSONField(name = "AppMemberDefinedData")
	public List<AppMemberDefinedData> getAppMemberDefinedData() {
		return AppMemberDefinedData;
	}

	public void setAppMemberDefinedData(List<AppMemberDefinedData> appMemberDefinedData) {
		AppMemberDefinedData = appMemberDefinedData;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
