package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;
/**
 *<strong>获取app中所有的群组</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>10002</td><td>系统错误，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10003</td><td>请求命令非法，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10004</td><td>参数非法。请根据应答包中的ErrorInfo字段，检查必填字段是否填充，或者字段的填充是否满足协议要求。</td></tr>
 *   <tr><td>10007</td><td>操作权限不足。请确认操作者是否是APP管理员。</td></tr> 
 *   <tr><td>10018</td><td>应答包长度超限。因为请求的内容过多，导致应答包超过了最大包长（1MB），请尝试减少单次请求的数据量。</td></tr>
 * </table>
 * @author 张晓宇
 *
 */
public class ResGetGroupList extends BaseResPackage{

	/**
	 * APP当前的群组总数。如果仅需要返回特定群组形态的群组，可以通过GroupType进行过滤，但此时返回的TotalCount的含义就变成了APP中该群组形态的群组总数。例如：假设APP旗下总共50000个群组，其中有20000个为公开群组，如果将请求包体中的GroupType设置为Public，那么不论Limit和Offset怎样设置，应答包体中的TotalCount都为20000，且GroupIdList中的群组全部为公开群组。
	 */
	private Integer TotalCount;
	
	/**
	 * 获取到的群组ID的集合。
	 */
	private List<GroupIdList> GroupIdList;
	
	/**
	 * 分页拉取的标志。
	 */
	private Integer Next;
	
	
	public Integer getTotalCount() {
		return TotalCount;
	}



	public void setTotalCount(Integer totalCount) {
		TotalCount = totalCount;
	}



	public List<GroupIdList> getGroupIdList() {
		return GroupIdList;
	}


	public void setGroupIdList(List<GroupIdList> groupIdList) {
		GroupIdList = groupIdList;
	}




	public Integer getNext() {
		return Next;
	}



	public void setNext(Integer next) {
		Next = next;
	}



	public class GroupIdList {
		
		
		private String GroupId;

		public String getGroupId() {
			return GroupId;
		}

		public void setGroupId(String groupId) {
			GroupId = groupId;
		}
		
	}
	
}
