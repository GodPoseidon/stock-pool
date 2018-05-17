package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

import com.aikxian.framework.common.TenYun.im.model.Role;

/**
 * <strong>创建群组应答包</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>10002</td><td>系统错误，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10003</td><td>请求命令非法，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10004</td><td>参数非法。请根据应答包中的ErrorInfo字段，检查必填字段是否填充，或者字段的填充是否满足协议要求。</td></tr>
 *   <tr><td>10018</td><td>应答包长度超限。因为请求的内容过多，导致应答包超过了最大包长（1MB），请尝试减少单次请求的数据量。</td></tr>
 * </table>
 * @author 张晓宇
 *
 */
public class ResGetJoinedGroupList extends BaseResPackage{

	private Integer TotalCount;
	
	private List<Group> GroupIdList;
		
	public Integer getTotalCount() {
		return TotalCount;
	}

	public void setTotalCount(Integer totalCount) {
		TotalCount = totalCount;
	}

	public List<Group> getGroupIdList() {
		return GroupIdList;
	}

	public void setGroupIdList(List<Group> groupIdList) {
		GroupIdList = groupIdList;
	}

	public class Group {
		
		private String GroupId;

		private String Type;
		
		private Integer LastMsgTime;
		
		private Integer MemberCount;
		
		private SelfInfo SelfInfo;
		
		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}

		public Integer getLastMsgTime() {
			return LastMsgTime;
		}

		public void setLastMsgTime(Integer lastMsgTime) {
			LastMsgTime = lastMsgTime;
		}

		public Integer getMemberCount() {
			return MemberCount;
		}

		public void setMemberCount(Integer memberCount) {
			MemberCount = memberCount;
		}

		public SelfInfo getSelfInfo() {
			return SelfInfo;
		}

		public void setSelfInfo(SelfInfo selfInfo) {
			SelfInfo = selfInfo;
		}

		public String getGroupId() {
			return GroupId;
		}

		public void setGroupId(String groupId) {
			GroupId = groupId;
		}
			
	}
	
	public class SelfInfo {
		
		private Role Role;
		
		private String MsgFlag;
		
		private Integer UnreadMsgNum;

		public Role getRole() {
			return Role;
		}

		public void setRole(Role role) {
			Role = role;
		}

		public String getMsgFlag() {
			return MsgFlag;
		}

		public void setMsgFlag(String msgFlag) {
			MsgFlag = msgFlag;
		}

		public Integer getUnreadMsgNum() {
			return UnreadMsgNum;
		}

		public void setUnreadMsgNum(Integer unreadMsgNum) {
			UnreadMsgNum = unreadMsgNum;
		}
		
		
	}
}
