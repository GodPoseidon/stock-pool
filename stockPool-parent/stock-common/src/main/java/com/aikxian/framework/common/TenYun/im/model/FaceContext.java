package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 表情消息内容格式
 * @author 张晓宇
 * @date 2017年6月13日 下午6:45:48
 */
public class FaceContext {

	/**
	 * 表情索引，用户自定义。
	 */
	private Number Index;
	
	/**
	 * 额外数据
	 */
	private String Data;

	@JSONField(name = "Index")
	public Number getIndex() {
		return Index;
	}

	public void setIndex(Number index) {
		Index = index;
	}

	@JSONField(name = "Data")
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}
	
	
}
