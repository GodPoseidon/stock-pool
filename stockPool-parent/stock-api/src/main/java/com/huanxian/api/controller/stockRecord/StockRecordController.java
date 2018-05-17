package com.huanxian.api.controller.stockRecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpStockRecordT;
import com.huanxian.service.SpStockRecordTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 牛股战绩
 * 
 * @author zhuzhen
 *
 */
@Api(value = "牛股战绩接口")
@RestController
@RequestMapping("/stockRecord")
public class StockRecordController {

	@Autowired
	private SpStockRecordTService recordTService;

	@ApiOperation(value = "获取牛股战绩列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "Integer", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页码,从1开始", paramType = "Integer", required = true) })
	@GetMapping("/list")
	public ResultModel list(Integer pageSize, Integer pageNum) {
		ResultModel model = new ResultModel();
		Integer size = 3, num = 1;
		if (pageSize <= 10 && pageSize > 0) {
			size = pageSize;
		}
		if (pageNum >= 1) {
			num = pageNum;
		}
		List<SpStockRecordT> list = recordTService.getList(size, num);
		model.setData(list);
		model.setSuccess(true);
		model.setCode("0");
		return model;
	}

}
