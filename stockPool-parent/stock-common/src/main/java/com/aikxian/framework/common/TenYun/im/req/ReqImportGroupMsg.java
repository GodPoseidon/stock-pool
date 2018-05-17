package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.Msg;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqImportGroupMsg {

	private String GroupId;
	
	private List<Msg> MsgList;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "MsgList")
	public List<Msg> getMsgList() {
		return MsgList;
	}

	public void setMsgList(List<Msg> msgList) {
		MsgList = msgList;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
