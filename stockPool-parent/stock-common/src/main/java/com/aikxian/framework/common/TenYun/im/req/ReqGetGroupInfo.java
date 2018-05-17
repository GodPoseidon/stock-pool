package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqGetGroupInfo {

	/**
	 * 需要拉取的群组列表。必填
	 */
	private List<String> GroupIdList;

	/**
	 * 包含三个过滤器：GroupBaseInfoFilter，MemberInfoFilter，AppDefinedDataFilter_Group，分别是基础信息字段过滤器，成员信息字段过滤器，群组维度的自定义字段过滤器。选填
	 */
	private ResponseFilter ResponseFilter;
	
	@JSONField(name = "GroupIdList")
	public List<String> getGroupIdList() {
		return GroupIdList;
	}

	public void setGroupIdList(List<String> groupIdList) {
		GroupIdList = groupIdList;
	}

	@JSONField(name = "ResponseFilter")
	public ResponseFilter getResponseFilter() {
		return ResponseFilter;
	}

	public void setResponseFilter(ResponseFilter responseFilter) {
		ResponseFilter = responseFilter;
	}

	public class ResponseFilter {

		/**
		 * 基础信息字段过滤器，指定需要获取的基础信息字段
		 */
		private List<String> GroupBaseInfoFilter;

		/**
		 * 成员信息字段过滤器，指定需要获取的成员信息字段
		 */
		private List<String> MemberInfoFilter;

		/**
		 * 该字段用来群组维度的自定义字段过滤器
		 */
		private List<String> AppDefinedDataFilter_Group;

		/**
		 * 该字段用来群成员维度的自定义字段过滤器
		 */
		private List<String> AppDefinedDataFilter_GroupMember;

		@JSONField(name = "GroupBaseInfoFilter")
		public List<String> getGroupBaseInfoFilter() {
			return GroupBaseInfoFilter;
		}

		public void setGroupBaseInfoFilter(List<String> groupBaseInfoFilter) {
			GroupBaseInfoFilter = groupBaseInfoFilter;
		}

		@JSONField(name = "MemberInfoFilter")
		public List<String> getMemberInfoFilter() {
			return MemberInfoFilter;
		}

		public void setMemberInfoFilter(List<String> memberInfoFilter) {
			MemberInfoFilter = memberInfoFilter;
		}

		@JSONField(name = "AppDefinedDataFilter_Group")
		public List<String> getAppDefinedDataFilter_Group() {
			return AppDefinedDataFilter_Group;
		}

		public void setAppDefinedDataFilter_Group(List<String> appDefinedDataFilter_Group) {
			AppDefinedDataFilter_Group = appDefinedDataFilter_Group;
		}

		@JSONField(name = "AppDefinedDataFilter_GroupMember")
		public List<String> getAppDefinedDataFilter_GroupMember() {
			return AppDefinedDataFilter_GroupMember;
		}

		public void setAppDefinedDataFilter_GroupMember(List<String> appDefinedDataFilter_GroupMember) {
			AppDefinedDataFilter_GroupMember = appDefinedDataFilter_GroupMember;
		}

	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
