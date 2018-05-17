package com.huanxian.common.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

/**
 * 短信发送工具类
 * 
 * @author zhuzhen
 *
 */
public class SMSUtil {

	/**
	 * 发送短信
	 * @param phone 	
	 * @param map	
	 * 			{SMS_ROOT_URL:发短信链接，SMS_PORT：短信接口；SMS_ACCOUNT_SID：主帐号；SMS_AUTH_TOKEN：主帐号令牌；
	 * 				SMS_APP_ID：应用ID；SMS_TEMPLE_REGISTER_ID：模板ID}
	 * @param params
	 * 			{验证码，短信有效时间}
	 * @return
	 */
	public static Boolean sendSMS(String phone, Map<String, String> map, String[] params) {
		HashMap<String, Object> result = null;
		// 初始化SDK
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();

		// 初始化服务器地址和端口
		restAPI.init(map.get("SMS_ROOT_URL"), map.get("SMS_PORT"));

		// *初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN *
		// *参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。 *
		restAPI.setAccount(map.get("SMS_ACCOUNT_SID"), map.get("SMS_AUTH_TOKEN"));
		// *初始化应用ID *
		restAPI.setAppId(map.get("SMS_APP_ID"));
		// *调用发送模板短信的接口发送短信 *
		// *参数顺序说明： *
		// *第一个参数:是要发送的手机号码，可以用逗号分隔，一次最多支持100个手机号 *
		// *第二个参数:是模板ID，在平台上创建的短信模板的ID值；测试的时候可以使用系统的默认模板，id为1。 *
		// *系统默认模板的内容为“【云通讯】您使用的是云通讯短信模板，您的验证码是{1}，请于{2}分钟内正确输入”*
		// *第三个参数是要替换的内容数组。 *

		result = restAPI.sendTemplateSMS(phone, map.get("SMS_TEMPLE_REGISTER_ID"), params);

		System.out.println("SDKTestGetSubAccounts result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			// 正常返回输出data包体信息（map）
			HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for (String key : keySet) {
				Object object = data.get(key);
				System.out.println(key + " = " + object);
			}
			return true;
		} else {
			// 异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
			return false;
		}
	}

	/**
	 * 随机生成6位短信验证码
	 * 
	 * @return
	 */
	public static String createRandomVcode() {
		// 验证码
		String vcode = "";
		for (int i = 0; i < 6; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

}
