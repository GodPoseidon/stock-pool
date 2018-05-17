package com.aikxian.framework.common.TenYun.im.res;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 账号登陆失效应答包
 * @author d
 *
 */
public class ResKickAccount extends BaseResPackage{

	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
