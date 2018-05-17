package com.aikxian.framework.common.TenYun.im.uitl;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UrlFormatUtil {

	/**
	 * 拼接链接参数，参数必须有get方法
	 * @param url
	 * @param parm
	 * @return
	 */
	public static String fullLink(String url, Object parm) {
		String fullurl = url + "?";
		if(parm == null){
			return url;
		}
		try {
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
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}	
		return fullurl;
		
	}

}
