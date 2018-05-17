package com.aikxian.framework.common.TenYun.im.model;

public enum Role {

	Admin("管理员"),
	Member("普通成员");
	
	private String intr;
	
	private Role(String intr){
		this.intr = intr;
	}
	
	public String getIntr() {
		return intr;
	}

}
