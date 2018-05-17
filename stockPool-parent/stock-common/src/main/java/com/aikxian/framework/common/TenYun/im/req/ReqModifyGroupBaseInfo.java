package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.AppDefinedData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqModifyGroupBaseInfo {

	
	/**
	 * 需要修改基础信息的群组的ID。
	 */
	private String GroupId;
	
	/**
	 * 选填  群名称，最长30字节。
	 */
	private String Name;
	
	/**
	 * 选填 群简介，最长240字节。
	 */
	private String Introduction;
	
	/**
	 * 选填  群公告，最长300字节。
	 */
	private String Notification;
	
	/**
	 * 选填  群头像URL，最长100字节。
	 */
	private String FaceUrl;
	
	/**
	 * 选填  最大群成员数量，最大为10000。
	 */
	private Integer MaxMemberNum;
	
	/**
	 * 申请加群处理方式。包含FreeAccess（自由加入），NeedPermission（需要验证），DisableApply（禁止加群）
	 */
	private String ApplyJoinOption;
	
	/**
	 * 默认情况是没有的
	 */
	private List<AppDefinedData> AppDefinedData;
	
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

	@JSONField(name = "MaxMemberNum")
	public Integer getMaxMemberNum() {
		return MaxMemberNum;
	}

	public void setMaxMemberNum(Integer maxMemberNum) {
		MaxMemberNum = maxMemberNum;
	}

	@JSONField(name = "ApplyJoinOption")
	public String getApplyJoinOption() {
		return ApplyJoinOption;
	}

	public void setApplyJoinOption(String applyJoinOption) {
		ApplyJoinOption = applyJoinOption;
	}
	
	@JSONField(name = "AppDefinedData")
	public List<AppDefinedData> getAppDefinedData() {
		return AppDefinedData;
	}

	public void setAppDefinedData(List<AppDefinedData> appDefinedData) {
		AppDefinedData = appDefinedData;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}


}
