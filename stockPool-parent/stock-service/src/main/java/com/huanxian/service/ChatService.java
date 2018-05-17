package com.huanxian.service;

import java.util.concurrent.Future;

public interface ChatService {

	
	public Boolean asynSendChat(Long userId, String groupId, String message);
	
	/**
	 * 获取用户的腾讯云签名
	 * @param userId 腾讯云用户id
	 * @return
	 */
	String getUserSig(String userId, Long time);
	
	/**
	 * 添加用户到腾讯云im
	 * @param userId
	 * @param nick
	 * @param faceUrl
	 * @param type
	 * @return
	 */
	Boolean addIMUser(String userId, String nick, String faceUrl, Integer type);
	
	/**
	 * 异步添加用户到腾讯云im
	 * @param userId
	 * @param nick
	 * @param faceUrl
	 * @param type
	 * @return
	 */
	Future<Boolean> asyncAddIMUser(String userId, String nick, String faceUrl, Integer type);
}
