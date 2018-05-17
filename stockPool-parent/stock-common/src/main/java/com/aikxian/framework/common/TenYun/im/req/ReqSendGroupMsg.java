package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.MsgBody;
import com.aikxian.framework.common.TenYun.im.model.OfflinePushInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 请求命令非法，请再次尝试或联系技术客服。
 * 
 * @author 张晓宇
 *
 */
public class ReqSendGroupMsg {

	/**
	 * 向哪个群组发送消息。
	 */
	private String GroupId;

	/**
	 * 32位随机数。如果5分钟内两条消息的随机值相同，后一条消息将被当做重复消息而丢弃
	 */
	private Integer Random;

	/**
	 * 消息来源帐号，选填。如果不填写该字段，则默认消息的发送者为调用该接口时使用的APP管理员帐号。除此之外，APP亦可通过该字段“伪造”消息的发送者，从而实现一些特殊的功能需求。需要注意的是，如果指定该字段，必须要确保字段中的帐号是存在的。
	 */
	private String From_Account;

	/**
	 * 消息的优先级。
	 */
	private String MsgPriority;

	/**
	 * 消息回调禁止开关，只对单条消息有效，ForbidBeforeSendMsgCallback表示禁止发消息前回调，ForbidAfterSendMsgCallback表示禁止发消息后回调。
	 */
	private List<String> ForbidCallbackControl;

	/**
	 * 离线推送信息配置，
	 */
	private OfflinePushInfo OfflinePushInfo;

	/**
	 * 消息体
	 */
	private List<MsgBody> MsgBody;

	/**
	 * 表示只在线下发(只有在线群成员才能收到)，不存离线及漫游
	 */
	private Integer OnlineOnlyFlag;

	@JSONField(name = "GroupId")
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@JSONField(name = "Random")
	public Integer getRandom() {
		return Random;
	}

	public void setRandom(Integer random) {
		Random = random;
	}

	@JSONField(name = "From_Account")
	public String getFrom_Account() {
		return From_Account;
	}

	public void setFrom_Account(String from_Account) {
		From_Account = from_Account;
	}

	@JSONField(name = "MsgPriority")
	public String getMsgPriority() {
		return MsgPriority;
	}

	public void setMsgPriority(String msgPriority) {
		MsgPriority = msgPriority;
	}

	@JSONField(name = "ForbidCallbackControl")
	public List<String> getForbidCallbackControl() {
		return ForbidCallbackControl;
	}

	public void setForbidCallbackControl(List<String> forbidCallbackControl) {
		ForbidCallbackControl = forbidCallbackControl;
	}

	@JSONField(name = "OfflinePushInfo")
	public OfflinePushInfo getOfflinePushInfo() {
		return OfflinePushInfo;
	}

	public void setOfflinePushInfo(OfflinePushInfo offlinePushInfo) {
		OfflinePushInfo = offlinePushInfo;
	}

	@JSONField(name = "MsgBody")
	public List<MsgBody> getMsgBody() {
		return MsgBody;
	}

	public void setMsgBody(List<MsgBody> msgBody) {
		MsgBody = msgBody;
	}

	@JSONField(name = "OnlineOnlyFlag")
	public Integer getOnlineOnlyFlag() {
		return OnlineOnlyFlag;
	}

	public void setOnlineOnlyFlag(Integer onlineOnlyFlag) {
		OnlineOnlyFlag = onlineOnlyFlag;
	}

	public class AndroidInfo {

		private String Sound;

		@JSONField(name = "Sound")
		public String getSound() {
			return Sound;
		}

		public void setSound(String sound) {
			Sound = sound;
		}
	}

	public class ApnsInfo {

		private String Sound;

		private Integer BadgeMode;

		@JSONField(name = "Sound")
		public String getSound() {
			return Sound;
		}

		public void setSound(String sound) {
			Sound = sound;
		}

		@JSONField(name = "BadgeMode")
		public Integer getBadgeMode() {
			return BadgeMode;
		}

		public void setBadgeMode(Integer badgeMode) {
			BadgeMode = badgeMode;
		}

	}

	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
