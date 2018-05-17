package com.aikxian.framework.common.TenYun.im.model;

/**
 * 消息类型
 * @author 张晓宇
 *
 */
public enum MessageType {

	TIMTextElem("文本消息"),
	TIMFaceElem("表情消息"),
	TIMLocationElem("位置消息"),
	TIMCustomElem("自定义消息");
	
	private String intr;
	
	private MessageType(String intr){
		this.intr = intr;
	}

	public String getIntr() {
		return intr;
	}
	
}
