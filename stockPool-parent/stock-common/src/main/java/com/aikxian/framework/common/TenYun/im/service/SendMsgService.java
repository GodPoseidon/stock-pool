package com.aikxian.framework.common.TenYun.im.service;

import com.aikxian.framework.common.TenYun.im.IMConfig;
import com.aikxian.framework.common.TenYun.im.IMInterface;
import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.req.ReqSendMsg;
import com.aikxian.framework.common.TenYun.im.res.ResSendMsg;

public class SendMsgService extends BaseService{

	public SendMsgService(AuthConfig authConfig){
		this.authConfig = authConfig;
	}
	
	private AuthConfig authConfig;
	
	/**
	 * 单发单聊消息
	 * @return
	 */
	public ResSendMsg sendAdminToUser(ReqSendMsg sendMsg){
		String reqUrl = IMConfig.REQURL + IMInterface.SEND_MSG;
		return reqIMInterface(authConfig, reqUrl, sendMsg, ResSendMsg.class);
	}
	
	/**
	 * 批量发单聊消息
	 * @return
	 */
	public ResSendMsg sendBatchAdminToUser(ReqSendMsg sendMsg){
		String reqUrl = IMConfig.REQURL + IMInterface.BATCH_SEND_MSG;
		return reqIMInterface(authConfig, reqUrl, sendMsg, ResSendMsg.class);	
	}
	
	/**
	 * 导入单聊消息
	 * @return
	 */
	public ResSendMsg importMsg(ReqSendMsg sendMsg){
		String reqUrl = IMConfig.REQURL + IMInterface.IMPORT_MSG;
		return reqIMInterface(authConfig, reqUrl, sendMsg, ResSendMsg.class);		
	}
}
