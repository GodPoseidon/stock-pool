package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.MsgBody;
import com.aikxian.framework.common.TenYun.im.model.OfflinePushInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 发送消息请求包
 * @author 张晓宇
 *
 */
public class ReqSendMsg {

	/**
	 * (选填)1：把消息同步到From_Account在线终端和漫游上；2：消息不同步至From_Account；若不填写默认情况下会将消息存From_Account漫游
	 */
	private Integer SyncOtherMachine;

	/**
	 * (选填)消息发送方账号。（用于指定发送消息方账号）。
	 */
	private String From_Account;

	/**
	 * (必填)消息接收方账号。
	 */
	private String To_Account;

	/**
	 * (必填)消息随机数,由随机函数产生。（用作消息去重）
	 */
	private Integer MsgRandom;

	/**
	 * (选填)消息时间戳，unix时间戳。
	 */
	private Integer MsgTimeStamp;
	
	/**
	 * (必填)消息内容，具体格式请参考消息格式描述。（注意，一条消息可包括多种消息元素，MsgBody为Array类型）
	 */
	private List<MsgBody> MsgBody;

	/**
	 * (选填)离线推送信息配置
	 */
	private OfflinePushInfo OfflinePushInfo;

	@JSONField(name="SyncOtherMachine")
	public Integer getSyncOtherMachine() {
		return SyncOtherMachine;
	}

	public void setSyncOtherMachine(Integer syncOtherMachine) {
		SyncOtherMachine = syncOtherMachine;
	}

	@JSONField(name="From_Account")
	public String getFrom_Account() {
		return From_Account;
	}

	public void setFrom_Account(String from_Account) {
		From_Account = from_Account;
	}

	@JSONField(name="To_Account")
	public String getTo_Account() {
		return To_Account;
	}

	public void setTo_Account(String to_Account) {
		To_Account = to_Account;
	}

	@JSONField(name="MsgRandom")
	public Integer getMsgRandom() {
		return MsgRandom;
	}

	public void setMsgRandom(Integer msgRandom) {
		MsgRandom = msgRandom;
	}

	@JSONField(name="MsgTimeStamp")
	public Integer getMsgTimeStamp() {
		return MsgTimeStamp;
	}

	public void setMsgTimeStamp(Integer msgTimeStamp) {
		MsgTimeStamp = msgTimeStamp;
	}

	@JSONField(name="MsgBody")
	public List<MsgBody> getMsgBody() {
		return MsgBody;
	}

	public void setMsgBody(List<MsgBody> msgBody) {
		MsgBody = msgBody;
	}

	@JSONField(name="OfflinePushInfo")
	public OfflinePushInfo getOfflinePushInfo() {
		return OfflinePushInfo;
	}

	public void setOfflinePushInfo(OfflinePushInfo offlinePushInfo) {
		OfflinePushInfo = offlinePushInfo;
	}

	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	


	public class AndroidInfo {
		
		private String Sound;

		@JSONField(name="Sound")
		public String getSound() {
			return Sound;
		}

		public void setSound(String sound) {
			Sound = sound;
		}
		
		@Override
		public String toString(){
			return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
		}

	}

	public class ApnsInfo {
		
		private String Sound;

		private Integer BadgeMode;

		@JSONField(name="Sound")
		public String getSound() {
			return Sound;
		}

		public void setSound(String sound) {
			Sound = sound;
		}

		@JSONField(name="BadgeMode")
		public Integer getBadgeMode() {
			return BadgeMode;
		}

		public void setBadgeMode(Integer badgeMode) {
			BadgeMode = badgeMode;
		}
		
		@Override
		public String toString(){
			return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
		}
	}
	
}
