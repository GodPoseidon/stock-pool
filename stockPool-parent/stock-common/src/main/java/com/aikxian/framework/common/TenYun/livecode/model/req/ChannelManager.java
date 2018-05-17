package com.aikxian.framework.common.TenYun.livecode.model.req;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.BaseReqParams;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 暂停并延迟恢复请求参数
 * @author 张晓宇
 *
 */
public class ChannelManager extends BaseReqParams{

	/**
	 * 直播码
	 */
	@JSONField(name = "Param.s.channel_id")
	private String channel_id;
	
	/**
	 * 恢复的绝对时间戳  允许推流的绝对时间， 请填写UNIX时间戳(十进制)
	 */
	@JSONField(name = "Param.n.abstime_end")
	private int abstime_end;
	
	/**
	 * 动作   断流：forbid；恢复推流：resume
	 */
	@JSONField(name = "Param.s.action")
	private String action;

	/**
	 * 
	 * @param appid 客户id
	 * @param extime 有效时间 
	 * @param sign 签名
	 * @param channel_id 直播码
	 * @param abstime_end 恢复的绝对时间戳
	 * @param action 动作
	 */
	public ChannelManager(Integer appid, Integer extime, String sign, String channel_id, Integer abstime_end, String action){
		super.setAppid(appid);
		super.setExpire_time(extime);
		super.setSign(sign);
		super.set_interface(LiveCodeConstant.CHANNEL_MANAGER);
		this.channel_id = channel_id;
		this.abstime_end = abstime_end;
		this.action = action;		
	}
	
	public String getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}

	public int getAbstime_end() {
		return abstime_end;
	}

	public void setAbstime_end(int abstime_end) {
		this.abstime_end = abstime_end;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	
}
