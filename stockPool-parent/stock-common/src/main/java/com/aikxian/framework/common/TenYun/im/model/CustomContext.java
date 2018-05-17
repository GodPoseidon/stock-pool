package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 自定义消息数据格式
 * @author 张晓宇
 * @date 2017年6月13日 下午6:47:04
 */
public class CustomContext {

	/**
	 * 自定义消息数据。 不作为APNS的payload中字段下发，故从payload中无法获取Data字段。
	 */
	private String Data;
	
	/**
	 * 自定义消息描述信息；当接收方为iPhone后台在线时，做iOS离线Push时文本展示。
	 */
	private String Desc;
	
	/**
	 * 扩展字段；当接收方为iOS系统且应用处在后台时，此字段作为APNS请求包Payloads中的ext键值下发，Ext的协议格式由业务方确定，APNS只做透传。
	 */
	private String Ext;
	
	/**
	 * 自定义APNS推送铃音。
	 */
	private String Sound;

	@JSONField(name = "Data")
	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	@JSONField(name = "Desc")
	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	@JSONField(name = "Ext")
	public String getExt() {
		return Ext;
	}

	public void setExt(String ext) {
		Ext = ext;
	}

	@JSONField(name = "Sound")
	public String getSound() {
		return Sound;
	}

	public void setSound(String sound) {
		Sound = sound;
	}
	
}
