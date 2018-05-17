package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

public class LiveChannelGetStatus extends BaseReqParams{

	@JSONField(name = "Param.s.channel_id")
	private String channel_id;

	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
	
	
}
