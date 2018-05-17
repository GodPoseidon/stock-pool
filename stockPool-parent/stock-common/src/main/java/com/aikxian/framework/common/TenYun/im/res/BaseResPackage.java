package com.aikxian.framework.common.TenYun.im.res;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 基础应答包
 * @author 张晓宇
 *
 */
public abstract class BaseResPackage {

	/**
	 * 请求处理的结果，OK表示处理成功，FAIL表示失败。
	 */
	private String ActionStatus;

	/**
	 * 错误信息。
	 */
	private String ErrorInfo;

	/**
	 * 错误码。
	 */
	private Integer ErrorCode;

	@JSONField(name = "ActionStatus") 
	public String getActionStatus() {
		return ActionStatus;
	}

	public void setActionStatus(String actionStatus) {
		ActionStatus = actionStatus;
	}

	@JSONField(name = "ErrorInfo") 
	public String getErrorInfo() {
		return ErrorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		ErrorInfo = errorInfo;
	}

	@JSONField(name = "ErrorCode") 
	public Integer getErrorCode() {
		return ErrorCode;
	}

	public void setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
	}

	@Override
	public String toString() {
		return "BaseResPackage [ActionStatus=" + ActionStatus + ", ErrorInfo=" + ErrorInfo + ", ErrorCode=" + ErrorCode
				+ "]";
	}
}
