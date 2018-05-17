package com.aikxian.framework.common.TenYun.im.res;

/**
 * <strong>查询全局禁言应答包</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>130001</td><td>Json格式解析失败,请检查请求包是否符合JSON规范。</td></tr>
 *   <tr><td>130002</td><td>Json格式请求包中没有Get_Account字段。</td></tr>
 *   <tr><td>130003</td><td>Json格式请求包中没有Get_Account字段不是String类型。</td></tr>
 * </table>
 * @author 张晓宇
 * @date 2017年6月13日 下午5:03:03
 */
public class ResGetNoSpeaking extends BaseResPackage{

	
	/**
	 * 单聊消息禁言时长，秒为单位，非负整数。等于0代表没有被设置禁言；等于最大值4294967295(十六进制0xFFFFFFFF)代表被永久设置禁言；其它代表该账户禁言时长，如果等于3600表示账户被禁言一小时。
	 */
	private Integer C2CmsgNospeakingTime;
	
	/**
	 * 群组消息禁言时长，秒为单位，非负整数。等着0代表没有被设置禁言；等于最大值4294967295(十六进制0xFFFFFFFF)代表被永久设置禁言；其它代表该账户禁言时长，如果等于3600表示账户被禁言一小时。
	 */
	private Integer GroupmsgNospeakingTime;

	public Integer getC2CmsgNospeakingTime() {
		return C2CmsgNospeakingTime;
	}

	public void setC2CmsgNospeakingTime(Integer c2CmsgNospeakingTime) {
		C2CmsgNospeakingTime = c2CmsgNospeakingTime;
	}

	public Integer getGroupmsgNospeakingTime() {
		return GroupmsgNospeakingTime;
	}

	public void setGroupmsgNospeakingTime(Integer groupmsgNospeakingTime) {
		GroupmsgNospeakingTime = groupmsgNospeakingTime;
	}
	
}
