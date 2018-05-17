package com.aikxian.framework.common.TenYun.im.service;
import com.aikxian.framework.common.TenYun.im.model.AuthConfig;
import com.aikxian.framework.common.TenYun.im.uitl.SSLClient;
import com.aikxian.framework.common.TenYun.im.uitl.UrlFormatUtil;
import com.alibaba.fastjson.JSON;

public class BaseService {

	/**
	 * 请求腾讯云通讯接口
	 * @param authConfig 鉴权数据
	 * @param url 请求接口的地址
	 * @param data 请求数据模型
	 * @param clazz 返回数据的类型
	 * @return
	 */
	public <T> T reqIMInterface(AuthConfig authConfig, String url, Object data, Class<T> clazz){
		String fullUrl = UrlFormatUtil.fullLink(url, authConfig);
		String reuslt = SSLClient.doPostSSL(fullUrl, data);	
		return JSON.parseObject(reuslt, clazz);	
	}
}
