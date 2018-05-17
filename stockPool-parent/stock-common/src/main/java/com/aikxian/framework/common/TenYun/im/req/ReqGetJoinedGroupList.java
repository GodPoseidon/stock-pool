package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqGetJoinedGroupList {

	private String Member_Account;

	/**
	 * 单次拉取的群组数量，如果不填代表所有群组，
	 */
	private Integer Limit;

	/**
	 * 从第多少个群组开始拉取，
	 */
	private Integer Offset;

	/**
	 * 例如Private，Public，ChatRoom或AVChatRoom，不填为拉取所有
	 */
	private String GroupType;

	/**
	 * 分别包含GroupBaseInfoFilter和SelfInfoFilter两个过滤器；
	 * GroupBaseInfoFilter表示需要拉取哪些基础信息字段，具体参见群基础资料；SelfInfoFilter表示需要拉取用户在每个群组中的哪些个人资料，具体请参见群成员资料。
	 */
	private ResponseFilter ResponseFilter;

	public class ResponseFilter {

		private List<String> GroupBaseInfoFilter;

		private List<String> SelfInfoFilter;

		@JSONField(name = "SelfInfoFilter")
		public List<String> getSelfInfoFilter() {
			return SelfInfoFilter;
		}

		public void setSelfInfoFilter(List<String> selfInfoFilter) {
			SelfInfoFilter = selfInfoFilter;
		}

		@JSONField(name = "GroupBaseInfoFilter")
		public List<String> getGroupBaseInfoFilter() {
			return GroupBaseInfoFilter;
		}

		public void setGroupBaseInfoFilter(List<String> groupBaseInfoFilter) {
			GroupBaseInfoFilter = groupBaseInfoFilter;
		}
	}

	@JSONField(name = "Member_Account")
	public String getMember_Account() {
		return Member_Account;
	}

	public void setMember_Account(String member_Account) {
		Member_Account = member_Account;
	}

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

	@JSONField(name = "GroupType")
	public String getGroupType() {
		return GroupType;
	}

	public void setGroupType(String groupType) {
		GroupType = groupType;
	}

	@JSONField(name = "ResponseFilter")
	public ResponseFilter getResponseFilter() {
		return ResponseFilter;
	}

	public void setResponseFilter(ResponseFilter responseFilter) {
		ResponseFilter = responseFilter;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
