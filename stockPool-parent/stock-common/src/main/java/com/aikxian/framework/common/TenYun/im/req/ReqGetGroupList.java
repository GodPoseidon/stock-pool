package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqGetGroupList {

	/**
	 * 本次获取的群组ID数量的上限，不得超过10000。如果不填，默认为最大值10000。
	 */
	private Integer Limit;
	
	/**
	 * 群太多时分页拉取标志，第一次填0，以后填上一次返回的值，返回的Next为0代表拉完了。
	 */
	private Integer Next;
	
	/**
	 * 如果仅需要返回特定群组形态的群组，可以通过GroupType进行过滤，但此时返回的TotalCount的含义就变成了APP中属于该群组形态的群组总数。不填为获取所有类型的群组。群组形态包括Public（公开群），Private（私密群），ChatRoom（聊天室），AVChatRoom（互动直播聊天室）和BChatRoom（在线成员广播大群）。
	 */
	private String GroupType;

	@JSONField(name = "Limit")
	public Integer getLimit() {
		return Limit;
	}

	public void setLimit(Integer limit) {
		Limit = limit;
	}

	@JSONField(name = "Next")
	public Integer getNext() {
		return Next;
	}

	public void setNext(Integer next) {
		Next = next;
	}

	@JSONField(name = "GroupType")
	public String getGroupType() {
		return GroupType;
	}

	public void setGroupType(String groupType) {
		GroupType = groupType;
	}
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
