package com.huanxian.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.core.annotation.LoginValidate;
import com.huanxian.core.model.ResultModel;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping
public class TestController {

	@ApiOperation(value="测试", notes="测试接口")
	@LoginValidate
	@RequestMapping("/test")
	public Object test() {
		return new ResultModel();
	}
}
