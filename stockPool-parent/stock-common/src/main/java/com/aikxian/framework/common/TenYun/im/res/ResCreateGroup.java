package com.aikxian.framework.common.TenYun.im.res;

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
 *   <tr><td>10016</td><td>该请求触发了到APP后台的“拉人入群之前回调”，云通讯后台根据回调结果拒绝增加该成员。</td></tr>
 *   <tr><td>10021</td><td>群组ID已被使用，请选择其他的群组ID。</td></tr>
 *   <tr><td>80001</td><td>文本安全打击。请检查群名称、群公告和群简介等是否有敏感词汇。</td></tr>
 * </table>
 * @author 张晓宇
 */
public class ResCreateGroup extends BaseResPackage{
	
	/**
	 * 创建成功之后的群ID，由IM云后台分配。
	 */
	private String GroupId;

	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	@Override
	public String toString() {
		super.toString();
		return "ResCreateGroup [GroupId=" + GroupId + "]";
	}

	
}
