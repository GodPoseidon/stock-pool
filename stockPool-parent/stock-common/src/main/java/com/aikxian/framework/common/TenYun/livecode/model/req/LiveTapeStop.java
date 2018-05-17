package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

public class LiveTapeStop extends BaseReqParams{
	
	/**
	 * 直播码
	 */
	@JSONField(name = "Param.s.channel_id")
	private String channel_id;
	
	
	/**
	 * 任务id
	 */
	@JSONField(name = "Param.s.task_id")
	private String task_id;
	
	/**
	 * 	是否开启实时视频录制  默认0，1表示开启小视频录制
	 */
	@JSONField(name = "Param.n.task_sub_type")
	private Integer task_sub_type;

	public LiveTapeStop(Integer appid, Integer extime, String sign, String channel_id, String task_id) {
		super.setAppid(appid);
		super.setExpire_time(extime);
		super.setSign(sign);
		super.set_interface(LiveCodeConstant.LIVE_TAPE_STOP);
		this.channel_id = channel_id;
		this.task_id = task_id;
	}
	
	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public Integer getTask_sub_type() {
		return task_sub_type;
	}

	public void setTask_sub_type(Integer task_sub_type) {
		this.task_sub_type = task_sub_type;
	}
	
	
}
