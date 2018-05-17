package com.aikxian.framework.common.TenYun.livecode.service;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.req.GetLivePlayStat;
import com.aikxian.framework.common.TenYun.livecode.model.req.GetLivePushStatHistory;
import com.aikxian.framework.common.TenYun.livecode.model.req.LiveChannelSetStatus;
import com.aikxian.framework.common.TenYun.livecode.model.req.LiveTapeStart;
import com.aikxian.framework.common.TenYun.livecode.model.req.LiveTapeStop;
import com.aikxian.framework.common.TenYun.livecode.model.res.ResGetLivePlayStat;
import com.aikxian.framework.common.TenYun.livecode.model.res.ResGetLivePushStatHistory;
import com.aikxian.framework.common.TenYun.livecode.model.res.ResLiveChannelSetStatus;
import com.aikxian.framework.common.TenYun.livecode.model.res.ResLiveTapeStart;
import com.aikxian.framework.common.TenYun.livecode.model.res.ResLiveTapeStop;
import com.aikxian.framework.common.TenYun.livecode.tool.HttpClientUtil;
import com.aikxian.framework.common.TenYun.livecode.tool.LiveCodeUtil;
import com.alibaba.fastjson.JSON;

/**
 * 提供腾讯云直播码服务功能
 * 
 * @author 张晓宇
 *
 */
public class LiveCodeService {

	/**
	 * 对一条直播流执行禁用、断流和允许推流操作
	 * 
	 * @param channelSetStatus
	 * @return
	 */
	public static ResLiveChannelSetStatus liveChannelSetStatus(LiveChannelSetStatus channelSetStatus) {
		String url = createUrl(channelSetStatus, LiveCodeConstant.FCGI_REQUEST_URL);
		String result = HttpClientUtil.doGet(url);
		return JSON.parseObject(result, ResLiveChannelSetStatus.class);
	}

	/**
	 * 创建录制任务
	 * 
	 * @param liveTapeStart
	 * @return
	 */
	public static ResLiveTapeStart liveTapeStart(LiveTapeStart liveTapeStart) {
		String url = createUrl(liveTapeStart, LiveCodeConstant.FCGI_REQUEST_URL);
		String result = HttpClientUtil.doGet(url);
		return JSON.parseObject(result, ResLiveTapeStart.class);
	}

	/**
	 * 结束录制任务
	 * 
	 * @param liveTapeStop
	 * @return
	 */
	public static ResLiveTapeStop liveTapeStop(LiveTapeStop liveTapeStop) {
		String url = createUrl(liveTapeStop, LiveCodeConstant.FCGI_REQUEST_URL);
		String result = HttpClientUtil.doGet(url);
		return JSON.parseObject(result, ResLiveTapeStop.class);
	}

	/**
	 * 获取推流历史信息。
	 * 
	 * @param getLivePushStatHistory
	 * @return
	 */
	public static ResGetLivePushStatHistory getLivePushStatHistory(GetLivePushStatHistory getLivePushStatHistory) {
		String url = createUrl(getLivePushStatHistory, LiveCodeConstant.STATCGI_REQUEST_URL);
		String result = HttpClientUtil.doGet(url);
		return JSON.parseObject(result, ResGetLivePushStatHistory.class);
	}
	
	/**
	 * 获取推流历史信息。
	 * 
	 * @param getLivePushStatHistory
	 * @return
	 */
	public static ResGetLivePlayStat getLivePlayStat(GetLivePlayStat livePlayStat) {
		String url = createUrl(livePlayStat, LiveCodeConstant.STATCGI_REQUEST_URL);
		String result = HttpClientUtil.doGet(url);
		return JSON.parseObject(result, ResGetLivePlayStat.class);
	}

	
	private static String createUrl(Object parms, String url) {
		Object p = JSON.toJSON(parms);
		return LiveCodeUtil.getFullLink(url, p);
	}
	

}
