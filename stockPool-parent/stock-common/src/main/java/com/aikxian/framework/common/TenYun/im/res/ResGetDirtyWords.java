package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;
/**
 * <strong>查询自定义脏字应答包</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>含义说明</th>
 *   </tr>
 *   <tr><td>10002</td><td>系统错误，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10003</td><td>请求命令非法，请再次尝试或联系技术客服。</td></tr>
 *   <tr><td>10007</td><td>操作权限不足。请确认操作者是否是APP管理员。</td></tr> 
 * </table>
 * @author 张晓宇
 * @date 2017年6月13日 下午4:39:11
 */
public class ResGetDirtyWords extends BaseResPackage{

	/**
	 * 返回结果是已经设置的自定义脏字。
	 */
	private List<String> DirtyWordsList;

	public List<String> getDirtyWordsList() {
		return DirtyWordsList;
	}

	public void setDirtyWordsList(List<String> dirtyWordsList) {
		DirtyWordsList = dirtyWordsList;
	}
	
}
