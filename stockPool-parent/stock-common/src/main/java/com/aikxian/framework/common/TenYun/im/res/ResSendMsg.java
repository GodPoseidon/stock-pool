package com.aikxian.framework.common.TenYun.im.res;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 发送消息应答包
 * @author 张晓宇
 */
public class ResSendMsg extends BaseResPackage{
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}  
   