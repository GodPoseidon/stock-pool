package com.aikxian.framework.common.TenYun.im.res;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 独立模式账号批量导入应答实体类
 * @author d
 *
 */
public class ResMultiAccount extends BaseResPackage{

	/**
	 * 导入失败的帐号列表
	 */
	private List<String> FailAccounts;

	@JSONField(name = "FailAccounts")
	public List<String> getFailAccounts() {
		return FailAccounts;
	}

	public void setFailAccounts(List<String> failAccounts) {
		FailAccounts = failAccounts;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
