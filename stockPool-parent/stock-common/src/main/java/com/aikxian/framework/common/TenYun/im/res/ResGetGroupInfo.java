package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.AppDefinedData;
import com.aikxian.framework.common.TenYun.im.model.AppMemberDefinedData;
import com.aikxian.framework.common.TenYun.im.model.Role;

/**
 * <strong>获取群组信息应答包</strong>
 * <p>
 * <table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1
 * #666;padding:3px;">
 * <tr style="background-color:#ddd;Text-align:Left;">
 * <th nowrap>错误码</th><th nowrap>含义说明</th>
 * </tr>
 * <tr>
 * <td>10002</td>
 * <td>系统错误，请再次尝试或联系技术客服。</td>
 * </tr>
 * <tr>
 * <td>10003</td>
 * <td>请求命令非法，请再次尝试或联系技术客服。</td>
 * </tr>
 * <tr>
 * <td>10004</td>
 * <td>参数非法。请根据应答包中的ErrorInfo字段，检查必填字段是否填充，或者字段的填充是否满足协议要求。</td>
 * </tr>
 * <tr>
 * <td>10007</td>
 * <td>操作权限不足。请确认操作者是否是APP管理员。</td>
 * </tr>
 * <tr>
 * <td>10010</td>
 * <td>群组不存在，或者曾经存在过，但是目前已经被解散。</td>
 * </tr>
 * <tr>
 * <td>10015</td>
 * <td>群组ID非法，请检查群组ID是否填写正确。</td>
 * </tr>
 * <tr>
 * <td>10018</td>
 * <td>应答包长度超限。因为请求的内容过多，导致应答包超过了最大包长（1MB），请尝试减少单次请求的数据量。</td>
 * </tr>
 * </table>
 * 
 * @author 张晓宇
 *
 */
public class ResGetGroupInfo extends BaseResPackage {

	private List<GroupInfo> GroupInfo;

	public List<GroupInfo> getGroupInfo() {
		return GroupInfo;
	}

	public void setGroupInfo(List<GroupInfo> groupInfo) {
		GroupInfo = groupInfo;
	}

	public class GroupInfo {

		private String GroupId;

		private Integer ErrorCode;

		private String ErrorInfo;

		private String Type;

		private String Name;

		private String Introduction;

		private String Notification;

		private String FaceUrl;

		private String Owner_Account;

		private Integer CreateTime;

		private Integer LastInfoTime;

		private Integer LastMsgTime;

		private Integer NextMsgSeq;

		private Integer MemberNum;

		private Integer MaxMemberNum;

		private String ApplyJoinOption;

		private List<AppDefinedData> AppDefinedData;

		public String getGroupId() {
			return GroupId;
		}

		public void setGroupId(String groupId) {
			GroupId = groupId;
		}

		public Integer getErrorCode() {
			return ErrorCode;
		}

		public void setErrorCode(Integer errorCode) {
			ErrorCode = errorCode;
		}

		public String getErrorInfo() {
			return ErrorInfo;
		}

		public void setErrorInfo(String errorInfo) {
			ErrorInfo = errorInfo;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getIntroduction() {
			return Introduction;
		}

		public void setIntroduction(String introduction) {
			Introduction = introduction;
		}

		public String getNotification() {
			return Notification;
		}

		public void setNotification(String notification) {
			Notification = notification;
		}

		public String getFaceUrl() {
			return FaceUrl;
		}

		public void setFaceUrl(String faceUrl) {
			FaceUrl = faceUrl;
		}

		public String getOwner_Account() {
			return Owner_Account;
		}

		public void setOwner_Account(String owner_Account) {
			Owner_Account = owner_Account;
		}

		public Integer getCreateTime() {
			return CreateTime;
		}

		public void setCreateTime(Integer createTime) {
			CreateTime = createTime;
		}

		public Integer getLastInfoTime() {
			return LastInfoTime;
		}

		public void setLastInfoTime(Integer lastInfoTime) {
			LastInfoTime = lastInfoTime;
		}

		public Integer getLastMsgTime() {
			return LastMsgTime;
		}

		public void setLastMsgTime(Integer lastMsgTime) {
			LastMsgTime = lastMsgTime;
		}

		public Integer getNextMsgSeq() {
			return NextMsgSeq;
		}

		public void setNextMsgSeq(Integer nextMsgSeq) {
			NextMsgSeq = nextMsgSeq;
		}

		public Integer getMemberNum() {
			return MemberNum;
		}

		public void setMemberNum(Integer memberNum) {
			MemberNum = memberNum;
		}

		public Integer getMaxMemberNum() {
			return MaxMemberNum;
		}

		public void setMaxMemberNum(Integer maxMemberNum) {
			MaxMemberNum = maxMemberNum;
		}

		public String getApplyJoinOption() {
			return ApplyJoinOption;
		}

		public void setApplyJoinOption(String applyJoinOption) {
			ApplyJoinOption = applyJoinOption;
		}

		public List<AppDefinedData> getAppDefinedData() {
			return AppDefinedData;
		}

		public void setAppDefinedData(List<AppDefinedData> appDefinedData) {
			AppDefinedData = appDefinedData;
		}

	}

	public class member {
		private String Member_Account;

		private Role Role;

		private Integer JoinTime;

		private Integer MsgSeq;

		private String MsgFlag;

		private Integer LastSendMsgTime;

		private Integer ShutUpUntil;

		private List<AppMemberDefinedData> AppMemberDefinedData;

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

		public Integer getJoinTime() {
			return JoinTime;
		}

		public void setJoinTime(Integer joinTime) {
			JoinTime = joinTime;
		}

		public Integer getMsgSeq() {
			return MsgSeq;
		}

		public void setMsgSeq(Integer msgSeq) {
			MsgSeq = msgSeq;
		}

		public String getMsgFlag() {
			return MsgFlag;
		}

		public void setMsgFlag(String msgFlag) {
			MsgFlag = msgFlag;
		}

		public Integer getLastSendMsgTime() {
			return LastSendMsgTime;
		}

		public void setLastSendMsgTime(Integer lastSendMsgTime) {
			LastSendMsgTime = lastSendMsgTime;
		}

		public Integer getShutUpUntil() {
			return ShutUpUntil;
		}

		public void setShutUpUntil(Integer shutUpUntil) {
			ShutUpUntil = shutUpUntil;
		}

		public List<AppMemberDefinedData> getAppMemberDefinedData() {
			return AppMemberDefinedData;
		}

		public void setAppMemberDefinedData(List<AppMemberDefinedData> appMemberDefinedData) {
			AppMemberDefinedData = appMemberDefinedData;
		}

	}

}
