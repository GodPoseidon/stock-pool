package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.MsgBody;

/**
 * <strong>拉取群漫游消息应答包</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>10002</td><td>系统错误，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10004</td><td>参数非法。请根据应答包中的ErrorInfo字段，检查必填字段是否填充，或者字段的填充是否满足协议要求。</td></tr>
 *   <tr><td>10007</td><td>操作权限不足。请确认操作者是否是APP管理员。</td></tr> 
 *   <tr><td>10010</td><td>群组不存在，或者曾经存在过，但是目前已经被解散。</td></tr>
 *   <tr><td>10015</td><td>群组ID非法，请检查群组ID是否填写正确。</td></tr>
 * </table> 
 * @author 张晓宇
 * @date 2017年6月13日 下午4:30:00
 */
public class ResGroupMsgGetSimple extends BaseResPackage{

	
	private String GroupId;
	
	/**
	 * 是否返回了请求区间的全部消息，当消息长度太长或者区间太大（超过20）导致无法返回全部消息时值为0。
	 */
	private Integer IsFinished;
	
	
	/**
	 * 返回的消息列表。
	 */
	private List<RspMsg> RspMsgList;

	
	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	public Integer getIsFinished() {
		return IsFinished;
	}

	public void setIsFinished(Integer isFinished) {
		IsFinished = isFinished;
	}
	
	
	public List<RspMsg> getRspMsgList() {
		return RspMsgList;
	}

	public void setRspMsgList(List<RspMsg> rspMsgList) {
		RspMsgList = rspMsgList;
	}

	public class RspMsg{
		
		/**
		 * 消息的发送者。
		 */
		private String From_Account;
		
		/**
		 * 是否是空洞消息，当消息被删除或者消息过期后，MsgBody为空，这个字段为1。
		 */
		private Integer IsPlaceMsg;
		
		/**
		 * 消息内容。
		 */
		private MsgBody MsgBody;
		
		/**
		 * 消息随机值，用来对消息去重，有客户端发消息时填写，如果没有填，服务端会自动生成一个。
		 */
		private Integer MsgRandom;
		
		/**
		 * 消息seq，用来标识唯一消息，值越小发送的越早。
		 */
		private Integer MsgSeq;
		
		/**
		 * 消息被发送的时间戳，server的时间。
		 */
		private Integer MsgTimeStamp;

		public Integer getMsgRandom() {
			return MsgRandom;
		}

		public void setMsgRandom(Integer msgRandom) {
			MsgRandom = msgRandom;
		}

		public Integer getMsgSeq() {
			return MsgSeq;
		}

		public void setMsgSeq(Integer msgSeq) {
			MsgSeq = msgSeq;
		}

		public Integer getMsgTimeStamp() {
			return MsgTimeStamp;
		}

		public void setMsgTimeStamp(Integer msgTimeStamp) {
			MsgTimeStamp = msgTimeStamp;
		}

		public String getFrom_Account() {
			return From_Account;
		}

		public void setFrom_Account(String from_Account) {
			From_Account = from_Account;
		}

		public Integer getIsPlaceMsg() {
			return IsPlaceMsg;
		}

		public void setIsPlaceMsg(Integer isPlaceMsg) {
			IsPlaceMsg = isPlaceMsg;
		}

		public MsgBody getMsgBody() {
			return MsgBody;
		}

		public void setMsgBody(MsgBody msgBody) {
			MsgBody = msgBody;
		}
		
	}
}
