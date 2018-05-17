package com.aikxian.framework.common.TenYun.livecode.model.message;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseCallbackData {

	/**
	 * 有效时间 UNIX时间戳(十进制)
	 */
	@JSONField(name = "t")
	private String ex_time;
	
	/**
	 * 	安全签名  MD5(KEY+t)
	 */
	private String sign;
	
	/**
	 * 	事件类型   目前可能值为： 0、1、100、200

	 */
	private Integer event_type;
	
	
	/**
	 * 	直播码 标示事件源于哪一条直播流
	 */
	private String stream_id;
	
	/**
	 * 	直播码 同stream_id
	 */
	private String channel_id;

	public String getEx_time() {
		return ex_time;
	}

	public void setEx_time(String ex_time) {
		this.ex_time = ex_time;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getEvent_type() {
		return event_type;
	}

	public void setEvent_type(Integer event_type) {
		this.event_type = event_type;
	}

	public String getStream_id() {
		return stream_id;
	}

	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	
	
	
}
