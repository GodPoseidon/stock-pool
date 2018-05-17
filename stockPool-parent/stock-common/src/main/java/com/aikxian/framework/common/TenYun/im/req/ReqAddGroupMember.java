package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqAddGroupMember {
	
	/**
	 * 操作的群ID。
	 */
	private String GroupId;
	
	/**
	 * 是否静默加人。0：非静默加人；1：静默加人。不填该字段默认为0。
	 */
	private Integer Silence;
	
	/**
	 * 待添加的群成员数组。
	 */
	private List<Member> MemberList;
	
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


	@JSONField(name = "MemberList")
	public List<Member> getMemberList() {
		return MemberList;
	}


	public void setMemberList(List<Member> memberList) {
		MemberList = memberList;
	}


	public class Member{
		
		/**
		 * 待添加的群成员帐号。
		 */
		private String Member_Account;

		@JSONField(name = "Member_Account")
		public String getMember_Account() {
			return Member_Account;
		}

		public void setMember_Account(String member_Account) {
			Member_Account = member_Account;
		}
		
		
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}

}
