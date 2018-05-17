package com.aikxian.framework.common.TenYun.livecode.model.message;

/**
 *  *<strong>推流断流错误码</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *   <th nowrap>错误码</th><th nowrap>错误描述</th><th nowrap>错误原因</th>
 *   </tr>
 *   <tr><td>1</td><td>recv rtmp deleteStream</td><td>主播端主动断流</td></tr>
 *   <tr><td>2</td><td>recv rtmp closeStream</td><td>主播端主动断流</td></tr>
 *   <tr><td>3</td><td>recv() return 0</td><td>主播端主动断开TCP连接</td></tr>
 *   <tr><td>4</td><td>recv() return error</td><td>主播端TCP连接异常</td></tr> 
 *   <tr><td>7</td><td>rtmp message large than 1M</td><td>收到流数据异常</td></tr>
 *   <tr><td>18</td><td>push url maybe invalid</td><td>推流鉴权失败，服务端禁止推流</td></tr>
 *   <tr><td>19</td><td>3rdparty auth failed</td><td>第三方鉴权失败，服务端禁止推流</td></tr>
 * </table>
 * 其他错误码	直播服务内部异常	如需处理请联系腾讯商务人员或者提交工单，联系电话：4009-100-100
 * @author 张晓宇
 *
 */
public class StreamMessage extends BaseCallbackData{

	/**
	 * 推流路径
	 */
	private String appname;
	
	/**
	 * 	推流域名
	 */
	private String app;
	
	
	/**
	 * 消息产生的时间   单位s
	 */
	private Integer update_time;
	
	/**
	 * 消息序列号，标识一次推流活动，一次推流活动会产生相同序列号的推流和断流消息
	 */
	private String sequence;
	
	/**
	 * 	Upload接入点的ip
	 */
	private String node;
	
	/**
	 * 用户推流ip
	 */
	private String user_ip;
	
	/**
	 * 断流错误码
	 */
	private Integer errcode;
	
	/**
	 * 	断流错误信息
	 */
	private String errmsg;
	
	/**
	 *  推流url参数
	 */
	private String stream_param;
	
	/**
	 * 推流时长 单位ms
	 */
	private String push_duration;

	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Integer getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Integer update_time) {
		this.update_time = update_time;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getStream_param() {
		return stream_param;
	}

	public void setStream_param(String stream_param) {
		this.stream_param = stream_param;
	}

	public String getPush_duration() {
		return push_duration;
	}

	public void setPush_duration(String push_duration) {
		this.push_duration = push_duration;
	}
	
	
}
