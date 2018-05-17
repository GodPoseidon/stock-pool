package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

/**
 * <strong>添加群组成员</strong>
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
 *   <tr><td>10016</td><td>该请求触发了到APP后台的“拉人入群之前回调”，云通讯后台根据回调结果拒绝增加该成员。</td></tr>
 *   <tr><td>10019</td><td>被添加用户的帐号不存在，请检查用户帐号是否正确。</td></tr>
 * </table>
 * @author 张晓宇
 *
 */
public class ResAddGroupMember extends BaseResPackage{
	
	private List<Member> MemberList;
	
	public class Member{
		
		/**
		 *  	返回的群成员帐号。
		 */
		private String Member_Account;
		
		/**
		 * 加人结果：0-失败；1-成功；2-已经是群成员；3-等待被邀请者确认。
		 */
		private Integer Result; 
		
		public String getMember_Account() {
			return Member_Account;
		}

		public void setMember_Account(String member_Account) {
			Member_Account = member_Account;
		}

		public Integer getResult() {
			return Result;
		}

		public void setResult(Integer result) {
			Result = result;
		}
		
	}

	public List<Member> getMemberList() {
		return MemberList;
	}

	public void setMemberList(List<Member> memberList) {
		MemberList = memberList;
	}

}
