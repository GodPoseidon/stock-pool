package com.aikxian.framework.common.TenYun.im.res;

/**
 * <strong>在群组中发送普通消息应答包</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>10002</td><td>系统错误，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10003</td><td>请求命令非法，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10004</td><td>参数非法。请根据应答包中的ErrorInfo字段，检查必填字段是否填充，或者字段的填充是否满足协议要求。</td></tr>
 *   <tr><td>10007</td><td>操作权限不足。请确认操作者是否是APP管理员。</td></tr> 
 *   <tr><td>10010</td><td>群组不存在，或者曾经存在过，但是目前已经被解散。</td></tr>
 *   <tr><td>10015</td><td>群组ID非法，请检查群组ID是否填写正确。</td></tr>
 *   <tr><td>10016</td><td>该请求触发了到APP后台的“群内发言之前回调”，云通讯后台根据回调结果拒绝下发该消息。</td></tr>
 *   <tr><td>10017</td><td>因被禁言而不能发送消息，请检查发送者是否被设置禁言。</td></tr>
 *   <tr><td>10023</td><td>请求命令非法，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>80001</td><td>文本安全打击。请检查群名称、群公告和群简介等是否有敏感词汇。</td></tr>
 *   <tr><td>80002</td><td>消息内容过长，目前最大支持8000字节的消息，请调整消息长度。</td></tr>
 * </table>
 * @author 张晓宇
 *
 */
public class ResSendGroupMsg extends BaseResPackage{
	
	/**
	 * 消息发送的时间戳，对应后台server时间。
	 */
	private Integer MsgTime;
	
	/**
	 * 消息序列号，唯一标示一条消息。
	 */
	private Integer MsgSeq;

	public Integer getMsgTime() {
		return MsgTime;
	}

	public void setMsgTime(Integer msgTime) {
		MsgTime = msgTime;
	}

	public Integer getMsgSeq() {
		return MsgSeq;
	}

	public void setMsgSeq(Integer msgSeq) {
		MsgSeq = msgSeq;
	}
	
	

}
