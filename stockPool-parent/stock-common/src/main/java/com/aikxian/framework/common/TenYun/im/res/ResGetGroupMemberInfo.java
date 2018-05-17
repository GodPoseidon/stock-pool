package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.AppMemberDefinedData;
import com.aikxian.framework.common.TenYun.im.model.Role;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * <strong>创建群组应答包</strong>
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
 *   <tr><td>10018</td><td>应答包长度超限。因为请求的内容过多，导致应答包超过了最大包长（1MB），请尝试减少单次请求的数据量。</td></tr>
 * </table>
 * @author 张晓宇
 *
 */
public class ResGetGroupMemberInfo extends BaseResPackage {

	/**
	 * 本群组的群成员总数。
	 */
	private Integer MemberNum;

	private List<Member> MemberList;

	public class Member {

		/**
		 * 群成员ID
		 */
		private String Member_Account;

		/**
		 * 群内身份
		 */
		private Role Role;

		/**
		 * 入群时间
		 */
		private Integer JoinTime;

		/**
		 * 该成员当前已读消息Seq
		 */
		private Integer MsgSeq;

		/**
		 * 消息接收选项
		 */
		private String MsgFlag;

		/**
		 * 最后发送消息的时间
		 */
		private Integer LastSendMsgTime;

		/**
		 * 0表示未被禁言，否则为禁言的截止时间
		 */
		private Integer ShutUpUntil;

		/**
		 * 群成员自定义字段
		 */
		private List<AppMemberDefinedData> AppMemberDefinedData;

		@JSONField(name = "ShutUpUntil")
		public Integer getShutUpUntil() {
			return ShutUpUntil;
		}

		public void setShutUpUntil(Integer shutUpUntil) {
			ShutUpUntil = shutUpUntil;
		}

		@JSONField(name = "AppMemberDefinedData")
		public List<AppMemberDefinedData> getAppMemberDefinedData() {
			return AppMemberDefinedData;
		}

		public void setAppMemberDefinedData(List<AppMemberDefinedData> appMemberDefinedData) {
			AppMemberDefinedData = appMemberDefinedData;
		}

		@JSONField(name = "Member_Account")
		public String getMember_Account() {
			return Member_Account;
		}

		public void setMember_Account(String member_Account) {
			Member_Account = member_Account;
		}

		@JSONField(name = "Role")
		public Role getRole() {
			return Role;
		}

		public void setRole(Role role) {
			Role = role;
		}

		@JSONField(name = "JoinTime")
		public Integer getJoinTime() {
			return JoinTime;
		}

		public void setJoinTime(Integer joinTime) {
			JoinTime = joinTime;
		}

		@JSONField(name = "MsgSeq")
		public Integer getMsgSeq() {
			return MsgSeq;
		}

		public void setMsgSeq(Integer msgSeq) {
			MsgSeq = msgSeq;
		}

		@JSONField(name = "MsgFlag")
		public String getMsgFlag() {
			return MsgFlag;
		}

		public void setMsgFlag(String msgFlag) {
			MsgFlag = msgFlag;
		}

		@JSONField(name = "LastSendMsgTime")
		public Integer getLastSendMsgTime() {
			return LastSendMsgTime;
		}

		public void setLastSendMsgTime(Integer lastSendMsgTime) {
			LastSendMsgTime = lastSendMsgTime;
		}

	}


	@JSONField(name = "MemberNum")
	public Integer getMemberNum() {
		return MemberNum;
	}

	public void setMemberNum(Integer memberNum) {
		MemberNum = memberNum;
	}

	@JSONField(name = "MemberList")
	public List<Member> getMemberList() {
		return MemberList;
	}

	public void setMemberList(List<Member> memberList) {
		MemberList = memberList;
	}
}
