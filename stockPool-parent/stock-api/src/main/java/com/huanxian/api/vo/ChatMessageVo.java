package com.huanxian.api.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChatMessageVo {

	/**
	 * 直播室id
	 */
	@NotNull(message = "直播室ID不能为空！")
	private Long liveId;
	
	/**
	 * 消息
	 */
	@NotBlank(message = "聊天信息为空！")
	private String message;

	public Long getLiveId() {
		return liveId;
	}

	public void setLiveId(Long liveId) {
		this.liveId = liveId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
