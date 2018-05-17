package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 拉取群漫游消息
 * @author 张晓宇
 * @date 2017年6月13日 下午4:25:51
 */
public class ReqGroupMsgGetSimple {

	private String GroupId;
	
	/**
	 *拉取消息的最大seq。
	 */
	private Integer ReqMsgSeq;
	
	/**
	 * 拉取的漫游消息的条数，目前一次请求最多返回20条漫游消息，所以这里最好小于等于20。
	 */
	private Integer ReqMsgNumber;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "ReqMsgSeq")
	public Integer getReqMsgSeq() {
		return ReqMsgSeq;
	}

	public void setReqMsgSeq(Integer reqMsgSeq) {
		ReqMsgSeq = reqMsgSeq;
	}

	@JSONField(name = "ReqMsgNumber")
	public Integer getReqMsgNumber() {
		return ReqMsgNumber;
	}

	public void setReqMsgNumber(Integer reqMsgNumber) {
		ReqMsgNumber = reqMsgNumber;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
