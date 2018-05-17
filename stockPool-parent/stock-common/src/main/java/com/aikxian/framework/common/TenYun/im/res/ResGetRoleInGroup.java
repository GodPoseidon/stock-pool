package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.Role;

/**
 * <strong>查询用户在群组中的身份应答包</strong>
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
 * </table>
 * @author 张晓宇
 *
 */
public class ResGetRoleInGroup extends BaseResPackage{

	
	private List<UserId> UserIdList;
	
	
	
	public class UserId {
		
		private String Member_Account;
		
		private Role Role;

		public String getMember_Account() {
			return Member_Account;
		}

		public void setMember_Account(String member_Account) {
			Member_Account = member_Account;
		}

		public Role getRole() {
			return Role;
		}

		public void setRole(Role role) {
			Role = role;
		}
		
		
		
	}



	public List<UserId> getUserIdList() {
		return UserIdList;
	}



	public void setUserIdList(List<UserId> userIdList) {
		UserIdList = userIdList;
	}
	
}
