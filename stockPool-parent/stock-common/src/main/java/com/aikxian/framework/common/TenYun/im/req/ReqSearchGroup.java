package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ReqSearchGroup {

	/**
	 * 关键字
	 */
	private String Content;
	
	/**
	 * 选填 从第几页开始搜索。
	 */
	private Integer PageNum;
	/**
	 * 每页有多少个群。
	 */
	private Integer GroupPerPage;
	
	/**
	 * 基础公开信息字段过滤器，指定需要获取的基础信息字段，基础信息字段详情参见：群基础资料。暂时还不支持所有字段。 现在支持的公开信息有群ID、群名称、群组类型、群创建时间、群创建者、成员个数、群成员最大个数、群简介、群头像、申请加群选项、最后一条消息以及在线成员。
	 */
	private ResponseFilter ResponseFilter;
	
	@JSONField(name="Content")
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@JSONField(name="PageNum")
	public Integer getPageNum() {
		return PageNum;
	}

	public void setPageNum(Integer pageNum) {
		PageNum = pageNum;
	}

	@JSONField(name="GroupPerPage")
	public Integer getGroupPerPage() {
		return GroupPerPage;
	}

	public void setGroupPerPage(Integer groupPerPage) {
		GroupPerPage = groupPerPage;
	}

	@JSONField(name="ResponseFilter")
	public ResponseFilter getResponseFilter() {
		return ResponseFilter;
	}

	public void setResponseFilter(ResponseFilter responseFilter) {
		ResponseFilter = responseFilter;
	}

	public class ResponseFilter{
		
		private List<String> GroupBasePublicInfoFilter;

		@JSONField(name="GroupBasePublicInfoFilter")
		public List<String> getGroupBasePublicInfoFilter() {
			return GroupBasePublicInfoFilter;
		}

		public void setGroupBasePublicInfoFilter(List<String> groupBasePublicInfoFilter) {
			GroupBasePublicInfoFilter = groupBasePublicInfoFilter;
		}
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
