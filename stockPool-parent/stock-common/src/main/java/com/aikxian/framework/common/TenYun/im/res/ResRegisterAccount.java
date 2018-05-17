package com.aikxian.framework.common.TenYun.im.res;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 托管模式账号导入响应包
 * @author 张晓宇
 */
public class ResRegisterAccount extends BaseResPackage{

	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
