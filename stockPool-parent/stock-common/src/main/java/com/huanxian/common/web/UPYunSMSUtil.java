package com.huanxian.common.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import cn.hutool.http.HttpRequest;

public class UPYunSMSUtil {

	private final static String send_message_url = "https://sms-api.upyun.com/api/messages";

	private static final Logger logger = LoggerFactory.getLogger(UPYunSMSUtil.class);
	/**
	 * 批量发送短信
	 * 
	 * @param telephones
	 * @param templateId
	 * @param templateParams
	 * @param token
	 * @return
	 */
	public static ResponseBody sendMessage(List<String> telephones, String templateId, String[] templateParams,
			String token) {
		Map<String, Object> params = new HashMap<>();
		String mobiles = "";
		for (String t : telephones) {
			if (mobiles.equals("")) {
				mobiles = t;
			} else {
				mobiles = mobiles + "," + t;
			}

		}
		params.put("template_id", templateId);
		params.put("mobile", mobiles);
		String vars = "";
		for (String s : templateParams) {
			if (vars.equals("")) {
				vars = s;
			} else {
				vars = vars + "|" + s;
			}
		}
		params.put("vars", vars);
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", token);
		String body = HttpRequest.post(send_message_url).contentType("application/json").body(JSON.toJSONString(params))
				.addHeaders(headers).timeout(HttpRequest.TIMEOUT_DEFAULT).execute().body();
		ResponseBody responseBodyObject = JSON.parseObject(body, ResponseBody.class);
		return responseBodyObject;
	}

	/**
	 * 发送短信
	 * 
	 * @param telephone
	 *            手机号
	 * @param templateId
	 *            模板id
	 * @param templateParams
	 *            模板参数
	 * @param token
	 *            授权码
	 * @return
	 */
	public static Boolean sendMessage(String telephone, String templateId, String[] templateParams,
			String token) {
		List<String> telephones = new ArrayList<>();
		telephones.add(telephone);
		ResponseBody body = sendMessage(telephones, templateId, templateParams, token);
		if(body.getError_code() == null) {
			if(body.getMessage_ids() != null && body.getMessage_ids().size() > 0) {
				for (MessageResponseBody s : body.getMessage_ids()) {
					if(s.getError_code() != null) {
						logger.error("优盘云短信发送失败!错误码:{},消息id:{},手机号:{},消息内容:{}", s.getError_code(), s.getMessage_id(), s.getMobile(),templateParams.toString());
					}				
				}
			}
		}else {
			logger.error("优盘云短信系统异常!错误码:{},消息内容:{}", body.getError_code(), body.getMessage());
			return false;
		}
		return true;
	}

	public static class ResponseBody {
		
		private String error_code;
		
		private String message;
		
		private List<MessageResponseBody> message_ids;

		public String getError_code() {
			return error_code;
		}

		public void setError_code(String error_code) {
			this.error_code = error_code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public List<MessageResponseBody> getMessage_ids() {
			return message_ids;
		}

		public void setMessage_ids(List<MessageResponseBody> message_ids) {
			this.message_ids = message_ids;
		}

	}

	public static class MessageResponseBody {

		private String error_code;

		private String mobile;

		private String message_id;

		public String getMessage_id() {
			return message_id;
		}

		public void setMessage_id(String message_id) {
			this.message_id = message_id;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getError_code() {
			return error_code;
		}

		public void setError_code(String error_code) {
			this.error_code = error_code;
		}

	}
}
