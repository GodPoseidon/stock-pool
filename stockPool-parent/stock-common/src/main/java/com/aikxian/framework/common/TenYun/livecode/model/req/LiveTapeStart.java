package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

public class LiveTapeStart extends BaseReqParams {

	/**
	 * 频道ID
	 */
	@JSONField(name = "Param.s.channel_id")
	private String channel_id;
	
	/**
	 * 	任务开始时间  标准的date_time，需要urlencode，如2017-01-01%2010:10:01。
	 */
	@JSONField(name = "Param.s.start_time")
	private String start_time;
	
	/**
	 * 任务结束时间  标准的date_time，需要urlencode，如2017-01-01%2010:10:01
	 */
	@JSONField(name = "Param.s.end_time")
	private String end_time;
	
	/**
	 * 是否开启实时视频录制   	默认0，1表示开启实时视频录制。
（1）若开启实时视频录制，调用接口则同步开始录制，此时如果传入任务开始时间参数，任务开始时间参数无效。
（2）开启实时视频录制的同时如果传入了任务结束时间，则按照任务结束时间结束录制。
	 */
	@JSONField(name = "Param.n.task_sub_type")
	private String task_sub_type;
	
	/**
	 * 录制文件格式  默认flv；可取值flv、hls、mp4、aac
	 */
	@JSONField(name = "Param.s.file_format")
	private String file_format;
	
	/**
	 * 录制文件类型  默认video
当record_type取值“video”时，file_format 可以取值 “flv”,"hls", "mp4"
当record_type取值“audio”时，file_format 可以取值 "aac", “flv”,"hls", "mp4"
	 */
	@JSONField(name = "Param.s.record_type")
	private String record_type;

	public LiveTapeStart(Integer appid, Integer extime, String sign, String channel_id, String startTime, String endTime) {
		super.setAppid(appid);
		super.setExpire_time(extime);
		super.setSign(sign);
		super.set_interface(LiveCodeConstant.LIVE_TAPE_START);
		this.start_time = startTime;
		this.end_time = endTime;
		this.channel_id = channel_id;
	}
	
	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getTask_sub_type() {
		return task_sub_type;
	}

	public void setTask_sub_type(String task_sub_type) {
		this.task_sub_type = task_sub_type;
	}

	public String getFile_format() {
		return file_format;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public void setFile_format(String file_format) {
		this.file_format = file_format;
	}

	public String getRecord_type() {
		return record_type;
	}

	public void setRecord_type(String record_type) {
		this.record_type = record_type;
	}
	
	

}
