package com.aikxian.framework.common.TenYun.im.model;

/**
 * 申请加群处理方式
 * @author 张晓宇
 * @date 2017年6月13日 下午1:52:18
 */
public enum ApplyJoinOption {

	FreeAccess("自由加入"),
	NeedPermission("需要验证"),
	DisableApply("禁止加群");
	
	private String intr;
	
	private ApplyJoinOption(String intr){
		this.intr = intr;
	}

	public String getIntr() {
		return intr;
	}
}
