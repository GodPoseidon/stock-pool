package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 在群组中发送系统通知
 * @author 张晓宇
 * @date 2017年6月13日 上午11:37:51
 */
public class ReqSendGroupSystemNotification {

	/**
	 * 向哪个群组发送系统通知。
	 */
	private String GroupId;
	
	/**
	 * 接收者群成员列表，不填或为空表示全员下发。
	 */
	private List<String> ToMembers_Account;
	
	/**
	 * 系统通知的内容。
	 */
	private String Content;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "ToMembers_Account")
	public List<String> getToMembers_Account() {
		return ToMembers_Account;
	}

	public void setToMembers_Account(List<String> toMembers_Account) {
		ToMembers_Account = toMembers_Account;
	}

	@JSONField(name = "Content")
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
