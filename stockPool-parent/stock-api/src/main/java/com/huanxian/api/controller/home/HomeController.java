package com.huanxian.api.controller.home;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpAdT;
import com.huanxian.entity.SpInfoClassifyT;
import com.huanxian.entity.SpInfoT;
import com.huanxian.entity.SpStockRecordT;
import com.huanxian.service.SpAdTService;
import com.huanxian.service.SpInfoClassifyTService;
import com.huanxian.service.SpInfoTService;
import com.huanxian.service.SpStockRecordTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "首页接口")
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private SpAdTService spAdTService;
	
	@Autowired
	private SpInfoClassifyTService spInfoClassifyTService;
	
	@Autowired
	private SpStockRecordTService recordTService;
	
	@Autowired
	private SpInfoTService infoTService;
	
	@ApiOperation(value = "获取首页数据")
	@PostMapping("/bodyMain")
	public ResultModel queryHome(){
		ResultModel model = new ResultModel();
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		EntityWrapper<SpAdT> wrapper = new EntityWrapper<>();
		wrapper.eq("ad_enable", 0);
		map.put("spAdTData", spAdTService.getPage(4, 1,wrapper));
			
		
		EntityWrapper<SpInfoClassifyT> wrapper3 = new EntityWrapper<SpInfoClassifyT>();
		wrapper3.eq("infc_enable", 0);
		map.put("spInfoClassifyTData", spInfoClassifyTService.getPage(8, 1, wrapper3));
		
		/**
		 * 牛股战绩
		 */
		EntityWrapper<SpStockRecordT> wrapper1 = new EntityWrapper<SpStockRecordT>();
		wrapper1.eq("status", 1);
		map.put("recordTData",recordTService.getPage(wrapper1, 3, 0));
		
		/**
		 * 精品资讯(PS：资讯分类id暂未确定)
		 */
		EntityWrapper<SpInfoT> wrapper2 = new EntityWrapper<SpInfoT>();
		wrapper2.eq("classId", 11);
		wrapper2.eq("inf_enable", 0);
		wrapper2.eq("inf_release", 1);
		map.put("infoTData",infoTService.getPage(6, 1, wrapper2));
		
		model.setData(map);
		model.setSuccess(true);
		return model;
	}
}
