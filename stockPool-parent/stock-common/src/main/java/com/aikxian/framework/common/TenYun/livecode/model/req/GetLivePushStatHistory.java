package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取推流历史信息。
 * @author 张晓宇
 *
 */
public class GetLivePushStatHistory extends BaseReqParams{

	/**
	 * 查询起始时间  3天内的数据时间戳
	 */
	@JSONField(name = "Param.n.start_time")
	private Integer start_time;
	
	/**
	 * 查询终止时间  建议查询跨度不大于2小时时间戳
	 */
	@JSONField(name = "Param.n.end_time")
	private Integer end_time;
	
	/**
	 * 流ID
	 */
	@JSONField(name = "Param.s.stream_id")
	private String stream_id;

	/**
	 * 
	 * @param appid
	 * @param extime
	 * @param sign
	 * @param start_time 开始时间 时间戳（秒）
	 * @param end_time 开始时间结束戳（秒）
	 * @param stream_id 流id
	 */
	public GetLivePushStatHistory(Integer appid, Integer extime, String sign, Integer start_time, Integer end_time, String stream_id) {
		super.setAppid(appid);
		super.setExpire_time(extime);
		super.setSign(sign);
		super.set_interface(LiveCodeConstant.GET_LIVE_PUSH_STAT_HISTORY);
		this.start_time = start_time;
		this.end_time = end_time;
		this.stream_id = stream_id;
	}
	public Integer getStart_time() {
		return start_time;
	}

	public void setStart_time(Integer start_time) {
		this.start_time = start_time;
	}

	public Integer getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Integer end_time) {
		this.end_time = end_time;
	}

	public String getStream_id() {
		return stream_id;
	}

	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}
	
	
}
