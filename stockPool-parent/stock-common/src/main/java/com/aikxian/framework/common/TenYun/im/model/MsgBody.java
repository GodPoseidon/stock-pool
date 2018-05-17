package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 消息体，注意查看腾讯文档后按需使用字段
 * 
 * @see https://www.qcloud.com/document/product/269/2720
 * @author 张晓宇
 *
 */
public class MsgBody {

	/**
	 * (必填)TIM消息对象类型，目前支持的消息对象包括： TIMTextElem(文本消息),TIMFaceElem(表情消息)，
	 * TIMLocationElem(位置消息)，TIMCustomElem(自定义消息)。
	 * 
	 * @see MessageType
	 */
	private MessageType MsgType;

	/**
	 * (必填)对于每种MsgType用不同的MsgContent格式,例：{@link TextContent} {@link CustomContext} {@link FaceContext} {@link LocationContext}
	 */
	private Object MsgContent;

	@JSONField(name = "MsgType")
	public MessageType getMsgType() {
		return MsgType;
	}

	public void setMsgType(MessageType msgType) {
		MsgType = msgType;
	}

	@JSONField(name = "MsgContent")
	public Object getMsgContent() {
		return MsgContent;
	}

	public void setMsgContent(Object msgContent) {
		MsgContent = msgContent;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);
	}

}
