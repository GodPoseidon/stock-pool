package com.aikxian.framework.common.TenYun.im.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 地址位置内容格式
 * @author 张晓宇
 * @date 2017年6月13日 下午6:43:49
 */
public class LocationContext {

	/**
	 * 地理位置描述信息。
	 */
	private String Desc;
	
	/**
	 * 纬度
	 */
	private Number Latitude;
	
	/**
	 * 经度
	 */
	private Number Longitude;

	@JSONField(name = "Desc")
	public String getDesc() {
		return Desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}

	@JSONField(name = "Latitude")
	public Number getLatitude() {
		return Latitude;
	}

	public void setLatitude(Number latitude) {
		Latitude = latitude;
	}

	@JSONField(name = "Longitude")
	public Number getLongitude() {
		return Longitude;
	}

	public void setLongitude(Number longitude) {
		Longitude = longitude;
	}
	
	
}
