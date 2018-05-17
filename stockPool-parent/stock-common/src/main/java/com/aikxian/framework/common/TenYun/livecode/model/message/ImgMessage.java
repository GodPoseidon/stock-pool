package com.aikxian.framework.common.TenYun.livecode.model.message;

public class ImgMessage extends BaseCallbackData{

	/**
	 * 图片地址  不带域名的路径
	 */
	private String pic_url;
	
	/**
	 * 截图时间戳  截图时间戳（unix时间戳，由于I帧干扰，暂时不能精确到秒级）
	 */
	private Integer create_time;
	
	/**
	 * 截图全路径  需要带上域名
	 */
	private String pic_full_url;

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public Integer getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}

	public String getPic_full_url() {
		return pic_full_url;
	}

	public void setPic_full_url(String pic_full_url) {
		this.pic_full_url = pic_full_url;
	}
	
	
}
