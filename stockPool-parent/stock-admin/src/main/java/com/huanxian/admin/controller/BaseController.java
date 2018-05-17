package com.huanxian.admin.controller;

import com.huanxian.core.model.ResultModel;

public class BaseController {

	public static ResultModel successResult() {
		return new ResultModel("0", null, true);
	}

	public static ResultModel successResult(Object data) {
		return new ResultModel("0", null, true, data);
	}

	public static ResultModel errorResult(String code, String message, Object data) {
		return new ResultModel(code, message, false, data);
	}

}
