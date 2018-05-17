package com.huanxian.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回数据统一封装结果类
 * 
 * @author 张晓宇
 * @date 2018年4月19日 下午7:50:07
 */
@ApiModel(value = "结果模型", description = "结果模型")
public class ResultModel {

	public ResultModel() {

	}

	public ResultModel(String code, String message, Boolean success) {
		this.code = code;
		this.message = message;
		this.success = success;
	}

	public ResultModel(String code, String message, Boolean success, Object data) {
		this.code = code;
		this.message = message;
		this.success = success;
		this.data = data;
	}

	/**
	 * 业务返回码
	 */
	@ApiModelProperty(value = "状态码", name = "code", example = "0")
	private String code;
	/**
	 * 消息
	 */
	@ApiModelProperty(value = "消息", name = "message", example = "成功！！")
	private String message;

	/**
	 * 是否成功
	 */
	@ApiModelProperty(value = "是否成功", name = "success", example = "true")
	private Boolean success;

	/**
	 * 返回数据
	 */
	@ApiModelProperty(value = "数据", name = "data")
	@JsonInclude(value = Include.NON_NULL)
	private Object data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
