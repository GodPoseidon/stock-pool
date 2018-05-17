package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

public class GetLivePlayStat extends BaseReqParams{


	/**
	 * 	分页页码 从1开始，默认为1
	 */
	@JSONField(name = "Param.n.page_no")
	private Integer page_no;
	
	
	/**
	 * 分页大小  1~300，默认为300
	 */
	@JSONField(name = "Param.n.page_size")
	private Integer page_size;
	
	
	/**
	 * 直播码  	如不设置stream_id：查询所有正在直播中的流
	 */
	@JSONField(name = "Param.s.stream_id")
	private String stream_id;
	
	/**
	 * 即播放域名，如果不填则返回所有域名的播放数据
	 */
	@JSONField(name = "Param.s.pull_domain")
	private String pull_domain;

	public GetLivePlayStat(Integer appid, Integer extime, String sign) {
		super.setAppid(appid);
		super.setExpire_time(extime);
		super.setSign(sign);
		super.set_interface(LiveCodeConstant.GET_LIVE_PLAY_STAT);
	}
	
	public Integer getPage_no() {
		return page_no;
	}

	public void setPage_no(Integer page_no) {
		this.page_no = page_no;
	}

	public Integer getPage_size() {
		return page_size;
	}

	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}

	public String getStream_id() {
		return stream_id;
	}

	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}

	public String getPull_domain() {
		return pull_domain;
	}

	public void setPull_domain(String pull_domain) {
		this.pull_domain = pull_domain;
	}
	
}
