package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;
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
 *   <tr><td>10018</td><td>应答包长度超限。因为请求的内容过多，导致应答包超过了最大包长（1MB），请尝试减少单次请求的数据量。</td></tr>
 * </table>
 * @author 张晓宇
 * @date 2017年6月13日 下午4:21:45
 */
public class ResSearchGroup extends BaseResPackage{

	/**
	 * 返回结果为群组信息数组
	 */
	private List<GroupInfo> GroupInfo;
	
	/**
	 * 搜索到的群组总个数，不受分页影响。
	 */
	private Integer TotalRecord;
	

	public List<GroupInfo> getGroupInfo() {
		return GroupInfo;
	}



	public void setGroupInfo(List<GroupInfo> groupInfo) {
		GroupInfo = groupInfo;
	}



	public Integer getTotalRecord() {
		return TotalRecord;
	}



	public void setTotalRecord(Integer totalRecord) {
		TotalRecord = totalRecord;
	}



	public class GroupInfo{
		private String ApplyJoinOption;
		
		private Integer CreateTime;
		
		private Integer ErrorCode;
		
		private String FaceUrl;
		
		private String GroupId;
		
		private String Introduction;
		
		private Integer MaxMemberNum;
		
		private Integer MemberNum;
		
		private String Name;
		
		private Integer OnlineMemberNum;
		
		private String Owner_Account;
		
		private String Type;

		public String getApplyJoinOption() {
			return ApplyJoinOption;
		}

		public void setApplyJoinOption(String applyJoinOption) {
			ApplyJoinOption = applyJoinOption;
		}

		public Integer getCreateTime() {
			return CreateTime;
		}

		public void setCreateTime(Integer createTime) {
			CreateTime = createTime;
		}

		public Integer getErrorCode() {
			return ErrorCode;
		}

		public void setErrorCode(Integer errorCode) {
			ErrorCode = errorCode;
		}

		public String getFaceUrl() {
			return FaceUrl;
		}

		public void setFaceUrl(String faceUrl) {
			FaceUrl = faceUrl;
		}

		public String getGroupId() {
			return GroupId;
		}

		public void setGroupId(String groupId) {
			GroupId = groupId;
		}

		public String getIntroduction() {
			return Introduction;
		}

		public void setIntroduction(String introduction) {
			Introduction = introduction;
		}

		public Integer getMaxMemberNum() {
			return MaxMemberNum;
		}

		public void setMaxMemberNum(Integer maxMemberNum) {
			MaxMemberNum = maxMemberNum;
		}

		public Integer getMemberNum() {
			return MemberNum;
		}

		public void setMemberNum(Integer memberNum) {
			MemberNum = memberNum;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public Integer getOnlineMemberNum() {
			return OnlineMemberNum;
		}

		public void setOnlineMemberNum(Integer onlineMemberNum) {
			OnlineMemberNum = onlineMemberNum;
		}

		public String getOwner_Account() {
			return Owner_Account;
		}

		public void setOwner_Account(String owner_Account) {
			Owner_Account = owner_Account;
		}

		public String getType() {
			return Type;
		}

		public void setType(String type) {
			Type = type;
		}
		
		
	}
}
