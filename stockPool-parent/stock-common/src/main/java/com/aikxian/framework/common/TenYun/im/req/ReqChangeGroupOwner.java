package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 转让群主
 * @author 张晓宇
 * @date 2017年6月13日 下午1:30:35
 */
public class ReqChangeGroupOwner {

	
	private String GroupId;
	
	/**
	 * 必填 新群主ID。
	 */
	private String NewOwner_Account;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "NewOwner_Account")
	public String getNewOwner_Account() {
		return NewOwner_Account;
	}

	public void setNewOwner_Account(String newOwner_Account) {
		NewOwner_Account = newOwner_Account;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
