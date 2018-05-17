package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.Role;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqImportGroupMember {

	
	private String GroupId;
	
	private List<Member> MemberList;
	
	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "MemberList")
	public List<Member> getMemberList() {
		return MemberList;
	}

	public void setMemberList(List<Member> memberList) {
		MemberList = memberList;
	}

	public class Member{
		
		private String Member_Account;
		
		private Role Role;
		
		private Integer JoinTime;
		
		private Integer UnreadMsgNum;
		
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

		@JSONField(name = "JoinTime")
		public Integer getJoinTime() {
			return JoinTime;
		}

		public void setJoinTime(Integer joinTime) {
			JoinTime = joinTime;
		}

		@JSONField(name = "UnreadMsgNum")
		public Integer getUnreadMsgNum() {
			return UnreadMsgNum;
		}

		public void setUnreadMsgNum(Integer unreadMsgNum) {
			UnreadMsgNum = unreadMsgNum;
		}
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
