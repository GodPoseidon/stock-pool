package com.aikxian.framework.common.TenYun.im.res;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 独自账号导入应答实体类
 * @author d
 *
 */
public class ResAccount extends BaseResPackage{

	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
