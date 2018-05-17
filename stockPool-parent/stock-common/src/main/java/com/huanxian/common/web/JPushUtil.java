package com.huanxian.common.web;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

/**
 * 极光推送
 * 
 * @author zhuzhen
 *
 */
public class JPushUtil {

	private final static Logger logger = LogManager.getLogger();

	/**
	 * 极光推送苹果设备、自定义参数
	 * 
	 * @param registrationIds
	 *            用户registrationId数组
	 * @param map
	 *            {MASTERSECRET_IOS;APPKEY_IOS}
	 * @param params
	 *            自定义参数
	 * @return
	 */
	public static PushResult Jpush_Ios_Extra(List<String> registrationIds, String title, String content, Map<String, String> map,
			Map<String, String> params) {
		JPushClient client = new JPushClient(map.get("MASTERSECRET_IOS").trim(), map.get("APPKEY_IOS".trim()),null,ClientConfig.getInstance());
		PushPayload payload = buildPushIOS_with_extra(registrationIds, title, content, params);
		try {
			PushResult result = client.sendPush(payload);
			logger.info("Got result - " + result);
			return result;
			// 如果使用 NettyHttpClient，需要手动调用 close 方法退出进程
			// If uses NettyHttpClient, call close when finished sending request, otherwise
			// process will not exit.
			// jpushClient.close();
		} catch (APIConnectionException e) {
			logger.error("Connection error. Should retry later. ", e);
			logger.error("Sendno: " + payload.getSendno());

		} catch (APIRequestException e) {
			logger.error("Error response from JPush server. Should review and fix it. ", e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
			logger.info("Msg ID: " + e.getMsgId());
			logger.error("Sendno: " + payload.getSendno());
		}
		return null;
	}

	/**
	 * 极光推送苹果设备、自定义参数
	 * 
	 * @param registrationIds
	 *            用户registrationId数组
	 * @param map
	 *            {MASTERSECRET_IOS;APPKEY_IOS}
	 * @param params
	 *            自定义参数
	 * @return
	 */
	public static PushResult Jpush_Android_Extra(List<String> registrationIds, String title, String content, Map<String, String> map,
			Map<String, String> params) {
		JPushClient client = new JPushClient(map.get("MASTERSECRET_ANDROID").trim(), map.get("APPKEY_ANDROID").trim(),null,ClientConfig.getInstance());
		PushPayload payload = buildPushAndroid_with_extra(registrationIds, title, content, params);
		try {
			PushResult result = client.sendPush(payload);
			logger.info("Got result - " + result);
			return result;
			// 如果使用 NettyHttpClient，需要手动调用 close 方法退出进程
			// If uses NettyHttpClient, call close when finished sending request, otherwise
			// process will not exit.
			// jpushClient.close();
		} catch (APIConnectionException e) {
			logger.error("Connection error. Should retry later. ", e);
			logger.error("Sendno: " + payload.getSendno());

		} catch (APIRequestException e) {
			logger.error("Error response from JPush server. Should review and fix it. ", e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
			logger.info("Msg ID: " + e.getMsgId());
			logger.error("Sendno: " + payload.getSendno());
		}
		return null;
	}

	/**
	 * 极光推送所有设备、自定义参数
	 * 
	 * @param registrationIds
	 *            用户registrationId数组
	 * @param map
	 *            {MASTERSECRET_IOS;APPKEY_IOS}
	 * @param params
	 *            自定义参数
	 * @return
	 */
	public static PushResult Jpush_All_Extra(List<String> registrationIds, String title, String content, Map<String, String> map,
			Map<String, String> params) {
		JPushClient client = new JPushClient(map.get("MASTERSECRET_ANDROID").trim(), map.get("APPKEY_ANDROID").trim(),null,ClientConfig.getInstance());
		PushPayload payload = buildPushAll_with_extra(registrationIds, title, content, params);
		try {
			PushResult result = client.sendPush(payload);
			logger.info("Got result - " + result);
			return result;
			// 如果使用 NettyHttpClient，需要手动调用 close 方法退出进程
			// If uses NettyHttpClient, call close when finished sending request, otherwise
			// process will not exit.
			// jpushClient.close();
		} catch (APIConnectionException e) {
			logger.error("Connection error. Should retry later. ", e);
			logger.error("Sendno: " + payload.getSendno());

		} catch (APIRequestException e) {
			logger.error("Error response from JPush server. Should review and fix it. ", e);
			logger.info("HTTP Status: " + e.getStatus());
			logger.info("Error Code: " + e.getErrorCode());
			logger.info("Error Message: " + e.getErrorMessage());
			logger.info("Msg ID: " + e.getMsgId());
			logger.error("Sendno: " + payload.getSendno());
		}
		return null;
	}

	/**
	 * 构建极光推送安卓设备PushPayload对象
	 * 
	 * @param registrationIds
	 *            推送对象数组
	 * @param title
	 *            推送标题
	 * @param content
	 *            推送内容
	 * @param params
	 *            自定义参数
	 * @return
	 */
	public static PushPayload buildPushAndroid_with_extra(List<String> registrationIds, String title, String content,
			Map<String, String> params) {

		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.registrationId(registrationIds))
				.setNotification(Notification.newBuilder().setAlert(content)
						.addPlatformNotification(
								AndroidNotification.newBuilder().setTitle(title).addExtras(params).build())
						.build())
				.build();
	}

	/**
	 * 构建极光推送苹果设备PushPayload对象
	 * 
	 * @param registrationIds
	 *            推送对象数组
	 * @param title
	 *            推送标题
	 * @param content
	 *            推送内容
	 * @param params
	 *            自定义参数
	 * @return
	 */
	public static PushPayload buildPushIOS_with_extra(List<String> registrationIds, String title, String content,
			Map<String, String> params) {

		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.registrationId(registrationIds))
				.setNotification(Notification.newBuilder().setAlert(content)
						.addPlatformNotification(
								AndroidNotification.newBuilder().setTitle(title).addExtras(params).build())
						.build())
				.build();
	}

	/**
	 * 构建极光推送所有设备PushPayload对象
	 * 
	 * @param registrationIds
	 *            推送对象数组
	 * @param title
	 *            推送标题
	 * @param content
	 *            推送内容
	 * @param params
	 *            自定义参数
	 * @return
	 */
	public static PushPayload buildPushAll_with_extra(List<String> registrationIds, String title, String content,
			Map<String, String> params) {

		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.registrationId(registrationIds))
				.setNotification(Notification.newBuilder().setAlert(content)
						.addPlatformNotification(
								AndroidNotification.newBuilder().setTitle(title).addExtras(params).build())
						.build())
				.build();
	}
	
}
