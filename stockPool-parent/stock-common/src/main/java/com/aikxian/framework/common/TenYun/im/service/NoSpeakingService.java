package com.aikxian.framework.common.TenYun.im.service;

import com.aikxian.framework.common.TenYun.im.IMConfig;
import com.aikxian.framework.common.TenYun.im.IMInterface;
import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.req.ReqGetNoSpeaking;
import com.aikxian.framework.common.TenYun.im.req.ReqSetNoSpeaking;
import com.aikxian.framework.common.TenYun.im.res.ResGetNoSpeaking;
import com.aikxian.framework.common.TenYun.im.res.ResSetNoSpeaking;
/**
 * 全局禁言接口
 * @author 张晓宇
 * @date 2017年6月13日 下午5:06:02
 */
public class NoSpeakingService extends BaseService{

	public NoSpeakingService(AuthConfig authConfig){
		this.authConfig = authConfig;	
	}
	private AuthConfig authConfig;
	
	/**
	 * 设置全局禁言
	 * @param noSpeaking
	 * @return
	 */
	public ResSetNoSpeaking setNoSpeaking(ReqSetNoSpeaking noSpeaking){
		String reqUrl = IMConfig.REQURL + IMInterface.SEARCH_GROUP;
		return reqIMInterface(authConfig, reqUrl, noSpeaking, ResSetNoSpeaking.class);
	}
	
	
	/**
	 * 查询全局禁言
	 * @param getNoSpeaking
	 * @return
	 */
	public ResGetNoSpeaking getNoSpeaking(ReqGetNoSpeaking getNoSpeaking){
		String reqUrl = IMConfig.REQURL + IMInterface.SEARCH_GROUP;
		return reqIMInterface(authConfig, reqUrl, getNoSpeaking, ResGetNoSpeaking.class);
	}
	
	
}
