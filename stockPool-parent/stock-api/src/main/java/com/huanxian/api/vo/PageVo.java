package com.huanxian.api.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PageVo {
	@NotNull(message = "页数为空！")
	@Min(value = 1, message = "页数不能小于{value}!")
	@Max(value = 20, message = "页数不能大于{value}!")
	private Integer pageNum;
	
	@NotNull(message = "每页大小为空！")
	@Min(value = 1, message = "每页大小小于{value}!")
	@Max(value = 20, message = "每页大小超过{value}!")
	private Integer pageSize;
	
	@NotNull(message = "类型为空！")
	private Long type;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
	
}
