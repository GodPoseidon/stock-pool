package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * 批量禁言和取消禁言
 * @author 张晓宇
 *
 */
public class ReqForbidSendMsg {

	
	private String GroupId;
	
	/**
	 * 需要禁言的用户账号，最多支持500个账号。
	 */
	private List<String> Members_Account;
	
	/**
	 * 需禁言时间，单位为秒，为0时表示取消禁言。
	 */
	private Integer ShutUpTime;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "Members_Account")
	public List<String> getMembers_Account() {
		return Members_Account;
	}

	public void setMembers_Account(List<String> members_Account) {
		Members_Account = members_Account;
	}

	@JSONField(name = "ShutUpTime")
	public Integer getShutUpTime() {
		return ShutUpTime;
	}

	public void setShutUpTime(Integer shutUpTime) {
		ShutUpTime = shutUpTime;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
