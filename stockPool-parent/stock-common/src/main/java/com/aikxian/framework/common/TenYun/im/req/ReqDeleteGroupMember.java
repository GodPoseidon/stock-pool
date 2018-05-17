package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 删除群组成员请求包
 * @author 张晓宇
 *
 */
public class ReqDeleteGroupMember {
	
	private String GroupId;
	
	/**
	 * 是否静默删人。0：非静默删人；1：静默删人。不填该字段默认为0。
	 */
	private Integer Silence;
	
	/**
	 * 踢出用户原因。
	 */
	private String Reason;
	
	/**
	 * 待删除的群成员。
	 */
	private List<String> MemberToDel_Account;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "Silence")
	public Integer getSilence() {
		return Silence;
	}

	public void setSilence(Integer silence) {
		Silence = silence;
	}

	@JSONField(name = "Reason")
	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	@JSONField(name = "MemberToDel_Account")
	public List<String> getMemberToDel_Account() {
		return MemberToDel_Account;
	}

	public void setMemberToDel_Account(List<String> memberToDel_Account) {
		MemberToDel_Account = memberToDel_Account;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
