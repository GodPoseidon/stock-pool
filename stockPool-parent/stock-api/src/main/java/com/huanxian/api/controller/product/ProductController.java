package com.huanxian.api.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpProductT;
import com.huanxian.service.SpProductTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("未登录产品")
@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private SpProductTService spProductTService;
	
	@ApiOperation(value = "未登录查看产品")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true),
		@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true) 
})
	@PostMapping("/queryProduct")
	public ResultModel queryProduct(Integer pageNum,Integer pageSize){
		ResultModel model = new ResultModel();
		EntityWrapper<SpProductT> wrapper =  new EntityWrapper<SpProductT>();
		wrapper.eq("status", 1);
		model.setData(spProductTService.getPage(pageSize, pageNum,wrapper));
		model.setSuccess(true);
		return model;
	}
}
 