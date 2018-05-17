package com.aikxian.framework.common.TenYun.im.req;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 独立模式账号导入接口请求实体类
 * @author 张晓宇
 *
 */
public class ReqAccount {

	/**
	 * (必填)用户名，长度不超过 32 字节
	 */
	private String Identifier;

	/**
	 * (选填)用户昵称
	 */
	private String Nick;

	/**
	 * (选填)用户头像URL。
	 */
	private String FaceUrl;

	/**
	 * (选填)帐号类型，开发者默认无需填写，值0表示普通帐号，1表示机器人帐号。
	 */
	private Integer Type = 0;

	@JSONField(name = "Identifier")
	public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}

	@JSONField(name = "Nick")
	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}

	@JSONField(name = "FaceUrl")
	public String getFaceUrl() {
		return FaceUrl;
	}

	public void setFaceUrl(String faceUrl) {
		FaceUrl = faceUrl;
	}

	@JSONField(name = "Type")
	public Integer getType() {
		return Type;
	}

	public void setType(Integer type) {
		Type = type;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this, SerializerFeature.NotWriteDefaultValue);	
	}
	
}
