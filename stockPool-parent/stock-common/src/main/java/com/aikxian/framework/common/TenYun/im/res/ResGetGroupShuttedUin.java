package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

/**
 * <strong>获取群组被禁言用户列表应答包</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>10002</td><td>系统错误，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10003</td><td>请求命令非法，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10004</td><td>参数非法。请根据应答包中的ErrorInfo字段，检查必填字段是否填充，或者字段的填充是否满足协议要求。</td></tr>
 *   <tr><td>10005</td><td>请求包体中携带的用户数量过多（超过了 500 个成员），请减少一次请求的用户数量。</td></tr>
 *   <tr><td>10007</td><td>操作权限不足。请确认操作者是否是APP管理员。</td></tr> 
 *   <tr><td>10010</td><td>群组不存在，或者曾经存在过，但是目前已经被解散。</td></tr>
 *   <tr><td>10015</td><td>群组ID非法，请检查群组ID是否填写正确。</td></tr>
 * </table>
 * @author 张晓宇
 *
 */
public class ResGetGroupShuttedUin extends BaseResPackage{

	private String GroupId;
	
	/**
	 * 返回结果为禁言用户信息数组，内容包括被禁言的成员ID，及其被禁言到的时间（使用UTC时间，即世界协调时间）。
	 */
	private List<ShuttedUin> ShuttedUinList;
	
	
	public String getGroupId() {
		return GroupId;
	}


	public void setGroupId(String groupId) {
		GroupId = groupId;
	}


	public List<ShuttedUin> getShuttedUinList() {
		return ShuttedUinList;
	}


	public void setShuttedUinList(List<ShuttedUin> shuttedUinList) {
		ShuttedUinList = shuttedUinList;
	}


	public class ShuttedUin{
		
		private String Member_Account;
		
		private Integer ShuttedUntil;

		public String getMember_Account() {
			return Member_Account;
		}

		public void setMember_Account(String member_Account) {
			Member_Account = member_Account;
		}

		public Integer getShuttedUntil() {
			return ShuttedUntil;
		}

		public void setShuttedUntil(Integer shuttedUntil) {
			ShuttedUntil = shuttedUntil;
		}
		
	}
}
