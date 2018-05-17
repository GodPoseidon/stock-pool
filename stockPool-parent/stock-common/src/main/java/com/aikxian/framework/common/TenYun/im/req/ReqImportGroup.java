package com.aikxian.framework.common.TenYun.im.req;

import com.aikxian.framework.common.TenYun.im.model.AppDefinedData;
import com.aikxian.framework.common.TenYun.im.model.ApplyJoinOption;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 导入群基础资料
 * @author 张晓宇
 * @date 2017年6月13日 下午1:58:16
 */
public class ReqImportGroup {
	
	/**
	 *  	群主id，自动添加到群成员中。如果不填，群没有群主。
	 */
	private String Owner_Account;
	
	/**
	 * 群组形态，包括Public（公开群），Private（私密群）， ChatRoom（聊天室）。
	 */
	private String Type;
	
	/**
	 * 为了使得群组ID更加简单，便于记忆传播，腾讯云支持APP在通过REST API创建群组时自定义群组ID
	 */
	private String GroupId;
	
	/**
	 * 群名称，最长30字节。
	 */
	private String Name;
	
	/**
	 * 群简介，最长240字节。
	 */
	private String Introduction;
	
	/**
	 * 群公告，最长300字节。
	 */
	private String Notification;
	
	/**
	 * 群头像URL，最长100字节。
	 */
	private String FaceUrl;
	
	/**
	 * 最大群成员数量，最大为10000，不填默认为2000个
	 */
	private Integer MaxMemberCount;
	
	/**
	 * 申请加群处理方式。包含FreeAccess（自由加入），NeedPermission（需要验证），DisableApply（禁止加群），不填默认为NeedPermission（需要验证）。
	 */
	private ApplyJoinOption ApplyJoinOption;
	
	/**
	 * 群组维度的自定义字段，默认情况是没有的，需要开通
	 */
	private Integer CreateTime;
	
	/**
	 * 群组的创建时间。
	 */
	private AppDefinedData AppDefinedData;

	@JSONField(name = "Owner_Account")
	public String getOwner_Account() {
		return Owner_Account;
	}

	public void setOwner_Account(String owner_Account) {
		Owner_Account = owner_Account;
	}

	@JSONField(name = "Type")
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "Name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@JSONField(name = "Introduction")
	public String getIntroduction() {
		return Introduction;
	}

	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}

	@JSONField(name = "Notification")
	public String getNotification() {
		return Notification;
	}

	public void setNotification(String notification) {
		Notification = notification;
	}

	@JSONField(name = "FaceUrl")
	public String getFaceUrl() {
		return FaceUrl;
	}

	public void setFaceUrl(String faceUrl) {
		FaceUrl = faceUrl;
	}

	@JSONField(name = "MaxMemberCount")
	public Integer getMaxMemberCount() {
		return MaxMemberCount;
	}

	public void setMaxMemberCount(Integer maxMemberCount) {
		MaxMemberCount = maxMemberCount;
	}

	@JSONField(name = "ApplyJoinOption")
	public ApplyJoinOption getApplyJoinOption() {
		return ApplyJoinOption;
	}

	public void setApplyJoinOption(ApplyJoinOption applyJoinOption) {
		ApplyJoinOption = applyJoinOption;
	}

	@JSONField(name = "CreateTime")
	public Integer getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Integer createTime) {
		CreateTime = createTime;
	}

	@JSONField(name = "AppDefinedData")
	public AppDefinedData getAppDefinedData() {
		return AppDefinedData;
	}

	public void setAppDefinedData(AppDefinedData appDefinedData) {
		AppDefinedData = appDefinedData;
	}
	
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
