package com.huanxian.vo;

/**
 * 自定义im消息体
 * @author 张晓宇
 * @date 2018年5月10日 下午5:06:38
 */
public class CustomIMBody {

	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * 头像地址
	 */
	private String avatar;
	
	/**
	 * 消息类型 ,1:普通消息
	 */
	private Integer messageType = 1;
	
	/**
	 * 用户类型,1:普通用户
	 */
	private Integer userType = 1;
	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	/**
	 * 消息
	 */
	private String message;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
