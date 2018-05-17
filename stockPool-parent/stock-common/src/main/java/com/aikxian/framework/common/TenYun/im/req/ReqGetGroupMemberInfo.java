package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqGetGroupMemberInfo {

	/**
	 * 需要拉取成员信息的群组的ID。必选
	 */
	private String GroupId;
	
	/**
	 * 一次最多获取多少个成员的资料，不得超过10000。如果不填，则获取群内全部成员的信息。选填
	 */
	private Integer Limit;
	
	/**
	 * 从第几个成员开始获取，如果不填则默认为0，表示从第一个成员开始获取.选填
	 */
	private Integer Offset;
	
	/**
	 * 需要获取哪些信息， 如果没有该字段则为群成员全部资料.选填
	 */
	private List<String> MemberInfoFilter;
	
	/**
	 * 拉取指定身份的群成员资料。如没有填写该字段，默认为所有身份成员资料，成员身份可以为：“Owner”，“Admin”，“Member”。选填
	 */
	private List<String> MemberRoleFilter;
	
	/**
	 * 默认情况是没有的。该字段用来群成员维度的自定义字段过滤器，指定需要获取的群成员维度的自定义字段.选填
	 */
	private List<String> AppDefinedDataFilter_GroupMember;
	

	@JSONField(name = "Limit")
	public Integer getLimit() {
		return Limit;
	}

	public void setLimit(Integer limit) {
		Limit = limit;
	}

	@JSONField(name = "Offset")
	public Integer getOffset() {
		return Offset;
	}

	public void setOffset(Integer offset) {
		Offset = offset;
	}

	@JSONField(name = "MemberInfoFilter")
	public List<String> getMemberInfoFilter() {
		return MemberInfoFilter;
	}

	public void setMemberInfoFilter(List<String> memberInfoFilter) {
		MemberInfoFilter = memberInfoFilter;
	}

	@JSONField(name = "MemberRoleFilter")
	public List<String> getMemberRoleFilter() {
		return MemberRoleFilter;
	}

	public void setMemberRoleFilter(List<String> memberRoleFilter) {
		MemberRoleFilter = memberRoleFilter;
	}

	@JSONField(name = "AppDefinedDataFilter_GroupMember")
	public List<String> getAppDefinedDataFilter_GroupMember() {
		return AppDefinedDataFilter_GroupMember;
	}

	public void setAppDefinedDataFilter_GroupMember(List<String> appDefinedDataFilter_GroupMember) {
		AppDefinedDataFilter_GroupMember = appDefinedDataFilter_GroupMember;
	}

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
