package com.aikxian.framework.common.TenYun.livecode;

/**
 * 直播码模式常量
 * @author 张晓宇
 *
 */
public class LiveCodeConstant {
	
	/**
	 * 统计信息请求地址
	 */
	public static final String STATCGI_REQUEST_URL = "http://statcgi.video.qcloud.com/common_access";
	
	/**
	 * 查询指定直播流的推流和播放信息
	 */
	public static final String GET_LIVE_STAT = "Get_LiveStat";
	
	/**
	 * 仅返回推流统计信息以提高查询效率
	 */
	public static final String GET_LIVE_PUSH_STAT = "Get_LivePushStat";
	
	/**
	 * 仅返回播放统计信息以提高查询效率
	 */
	public static final String GET_LIVE_PLAY_STAT = "Get_LivePlayStat";
	
	/**
	 * 获取播放统计历史信息
	 */
	public static final String GET_LIVE_PLAY_STAT_HISTORY = "Get_LivePlayStatHistory";
	
	
	/**
	 * 获取推流历史信息
	 */
	public static final String GET_LIVE_PUSH_STAT_HISTORY = "Get_LivePushStatHistory";
	
	
/*<---------------------------------------------------------------------------------------------------------------------------->*/
	/**
	 * 查询直播状态请求地址
	 */
	public static final String FCGI_REQUEST_URL = "http://fcgi.video.qcloud.com/common_access";
	
	/**
	 * 用于查询某条流是否处于正在直播的状态
	 */
	public static final String LIVE_CHANNEL_GET_STATUS = "Live_Channel_GetStatus";
	
	/**
	 * 用于查询某条直播流某段时间内生成的录制文件。
	 */
	public static final String LIVE_CHANNEL_GET_FILELIST = "Live_Tape_GetFilelist";
	
	
	/**
	 * 查询直播中的频道新产生的截图文件。
	 */
	public static final String LIVE_QUEUE_GET = "Live_Queue_Get";
	
	
	/**
	 * 查询频道列表。
	 */
	public static final String LIVE_CHANNEL_GET_CHANNEL_LIST = "Live_Channel_GetChannelList";
	
	
	/**
	 * 查询频道列表
	 */
	public static final String LIVE_CHANNEL_GET_LIVE_CHANNEL_LIST = "Live_Channel_GetLiveChannelList";
	
	/**
	 * 对一条直播流执行禁用、断流和允许推流操作。禁用，表示不能再继续使用该流id推流；如果正在推流，则推流会被中断，中断后不可再次推流。断流表示中断正在推的流，断流后可以再次推流。允许推流表示启用该流id，允许用该流id推流。
	 */
	public static final String LIVE_CHANNEL_SET_STATUS = "Live_Channel_SetStatus";
	
	
	/**
	 * 混流接口
	 */
	public static final String MIX_STREAM = "Mix_Stream";
	
	
	/**
	 * 创建录制任务
	 */
	public static final String LIVE_TAPE_START = "Live_Tape_Start";
	
	
	/**
	 * 结束录制任务
	 */
	public static final String LIVE_TAPE_STOP = "Live_Tape_Stop";
	
	
	/**
	 * 暂停推流并延迟恢复接口
	 */
	public static final String CHANNEL_MANAGER = "channel_manager";
	

	
/*<---------------------------------------------------------------------------------------------------------------------------->*/
	

	
	
	
}
