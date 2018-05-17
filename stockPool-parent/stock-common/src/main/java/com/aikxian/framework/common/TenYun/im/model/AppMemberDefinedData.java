package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

public class AppMemberDefinedData {

	private String Key;

	private String Value;

	@JSONField(name = "Key")
	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	@JSONField(name = "Value")
	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
}
