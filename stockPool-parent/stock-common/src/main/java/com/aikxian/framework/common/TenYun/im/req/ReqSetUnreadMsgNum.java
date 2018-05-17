package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 设置成员未读消息计数
 * @author 张晓宇
 * @date 2017年6月13日 下午2:42:10
 */
public class ReqSetUnreadMsgNum {

	/**
	 * 操作的群ID。必填
	 */
	private String GroupId;
	
	/**
	 * 要操作的群成员。必填
	 */
	private String Member_Account;
	
	/**
	 * 成员未读消息数。必填
	 */
	private Integer UnreadMsgNum;

	
	@JSONField(name="GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name="Member_Account")
	public String getMember_Account() {
		return Member_Account;
	}

	public void setMember_Account(String member_Account) {
		Member_Account = member_Account;
	}

	@JSONField(name="UnreadMsgNum")
	public Integer getUnreadMsgNum() {
		return UnreadMsgNum;
	}

	public void setUnreadMsgNum(Integer unreadMsgNum) {
		UnreadMsgNum = unreadMsgNum;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	 
}
