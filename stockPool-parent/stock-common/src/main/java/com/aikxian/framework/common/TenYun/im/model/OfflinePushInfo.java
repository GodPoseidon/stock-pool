package com.aikxian.framework.common.TenYun.im.model;

import com.aikxian.framework.common.TenYun.im.req.ReqSendMsg.AndroidInfo;
import com.aikxian.framework.common.TenYun.im.req.ReqSendMsg.ApnsInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 离线推送信息配置
 * @author 张晓宇
 * @date 2017年6月13日 下午2:01:57
 */
public class OfflinePushInfo {

	private Integer PushFlag;
	
	private String Desc;
	
	private String Ext;
	
	private AndroidInfo AndroidInfo;
	
	private ApnsInfo ApnsInfo;

	@JSONField(name="PushFlag")
	public Integer getPushFlag() {
		return PushFlag;
	}

	public void setPushFlag(Integer pushFlag) {
		PushFlag = pushFlag;
	}

	@JSONField(name="Desc")
	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	@JSONField(name="Ext")
	public String getExt() {
		return Ext;
	}

	public void setExt(String ext) {
		Ext = ext;
	}

	@JSONField(name="AndroidInfo")
	public AndroidInfo getAndroidInfo() {
		return AndroidInfo;
	}

	public void setAndroidInfo(AndroidInfo androidInfo) {
		AndroidInfo = androidInfo;
	}

	@JSONField(name="ApnsInfo")
	public ApnsInfo getApnsInfo() {
		return ApnsInfo;
	}

	public void setApnsInfo(ApnsInfo apnsInfo) {
		ApnsInfo = apnsInfo;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
