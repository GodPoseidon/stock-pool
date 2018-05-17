package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqGetRoleInGroup {

	private String GroupId;
	
	/**
	 * 表示需要查询的用户账号，最多支持500个账号。
	 */
	private List<String> User_Account;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "User_Account")
	public List<String> getUser_Account() {
		return User_Account;
	}

	public void setUser_Account(List<String> user_Account) {
		User_Account = user_Account;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
