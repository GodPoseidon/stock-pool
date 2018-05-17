package com.aikxian.framework.common.TenYun.livecode.tool;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Map;

import com.aikxian.framework.common.TenYun.livecode.LiveCodeConstant;
import com.aikxian.framework.common.TenYun.livecode.model.req.ChannelManager;
import com.alibaba.fastjson.JSON;

public class LiveCodeUtil {

	private static final char[] DIGITS_LOWER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	/**
	 * 获取安全签名
	 * 
	 * @param key
	 *            api接口秘钥
	 * @param exTime
	 *            过期时间戳, 单位:秒
	 * @return
	 */
	public static String safeSign(String key, long exTime) {
		String sign = key + exTime;
		String txSecret = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			txSecret = byteArrayToHexString(messageDigest.digest(sign.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return txSecret;
	}

	private static String byteArrayToHexString(byte[] data) {
		char[] out = new char[data.length << 1];

		for (int i = 0, j = 0; i < data.length; i++) {
			out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS_LOWER[0x0F & data[i]];
		}
		return new String(out);
	}

	/**
	 * 拼接链接参数
	 * 
	 * @param url
	 * @param parm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getFullLink(String url, Object parm) {
		String fullurl = url + "?";
		if (parm == null) {
			return url;
		}
		try {
			if (parm instanceof Map) {
				Map<Object, Object> map = (Map<Object, Object>) parm;
				int i = 1;
				for (Map.Entry<Object, Object> entry : map.entrySet()) {
					if (entry.getValue() != null) {
						if (map.entrySet().size() == i) {
							fullurl = fullurl + entry.getKey() + "=" + entry.getValue();
						} else {
							fullurl = fullurl + entry.getKey() + "=" + entry.getValue() + "&";
						}
					}
					i++;
				}
				return fullurl;
			}
			BeanInfo beanInfo = Introspector.getBeanInfo(parm.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			int i = 1;
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(parm);
					if (propertyDescriptors.length - i != 0) {
						fullurl = fullurl + key + "=" + value + "&";
					} else {
						fullurl = fullurl + key + "=" + value;
					}
				}
				i++;
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return fullurl;
	}

	public static void main(String[] args) {
		ChannelManager parm = new ChannelManager(123, 123456, "1231231", "123", 13132132, "resume");
		Object a = JSON.toJSON(parm);
		System.out.println(getFullLink(LiveCodeConstant.FCGI_REQUEST_URL, a));
	}
}
