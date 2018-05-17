package com.aikxian.framework.common.TenYun.im.req;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 独立模式账号批量导入请求实体类
 * @author 张晓宇
 *
 */
public class ReqMultiAccount {

	/**
	 * (必填)用户名，单个用户名长度不超过 32 字节，单次最多导入100个用户名
	 */
	private List<String> Account;

	@JSONField(name = "Account")
	public List<String> getAccount() {
		return Account;
	}

	public void setAccount(List<String> account) {
		Account = account;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
}
