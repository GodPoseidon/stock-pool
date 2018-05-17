package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

public class LiveChannelSetStatus extends BaseReqParams{

	/**
	 * 直播码
	 */
	@JSONField(name = "Param.s.channel_id")
	private String channel_id;
	
	/**
	 * 	开关状态 0表示禁用； 1表示允许推流；2表示断流
	 */
	@JSONField(name = "Param.n.status")
	private Integer status;

	public LiveChannelSetStatus(Integer appid, Integer extime, String sign, String channel_id, Integer status) {
		super.setAppid(appid);
		super.setExpire_time(extime);
		super.setSign(sign);
		super.set_interface(LiveCodeConstant.LIVE_CHANNEL_SET_STATUS);
		this.channel_id = channel_id;
		this.status = status;
	}
	
	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
