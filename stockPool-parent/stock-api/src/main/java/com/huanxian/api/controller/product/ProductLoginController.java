package com.huanxian.api.controller.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.api.controller.BaseController;
import com.huanxian.core.annotation.LoginValidate;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpAccountProT;
import com.huanxian.entity.SpInfoT;
import com.huanxian.entity.SpProdInfoT;
import com.huanxian.entity.SpProductT;
import com.huanxian.service.SpAccountProTService;
import com.huanxian.service.SpProdClassifyTService;
import com.huanxian.service.SpProdInfoTService;
import com.huanxian.service.SpProductTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("产品资讯")
@RestController
@RequestMapping("/prodLogin")
public class ProductLoginController extends BaseController{
	
	
	@Autowired
	private SpProdInfoTService spProdInfoTService;
	
	
	@Autowired
	private SpAccountProTService spAccountProTService;

	
	@Autowired
	private SpProductTService spProductTService;
	
	@Autowired
	private SpProdClassifyTService spProdClassifyTService;
	
	
	@ApiOperation(value = "精品资讯列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true) ,
			@ApiImplicitParam(name = "classifyId", value = "产品分类ID", dataType = "Long", required = true) 
	})
	@PostMapping("/prodInfo")
	@LoginValidate
	public ResultModel prodInfo(Integer pageNum,Integer pageSize,Long classifyId){
		
		EntityWrapper<SpAccountProT> prods =  new EntityWrapper<SpAccountProT>();
		prods.eq("accountId", getCurrentUser().getId());
		prods.eq("status", 0);
		prods.gt("endTime", new Date());
		List<SpAccountProT> spAccountProTList = spAccountProTService.getList(prods);
		if(spAccountProTList.size() == 0||spAccountProTList == null){
			return result("3001", "暂无数据", true, null);
		}
		List<Long> prodIds = new ArrayList<Long>();
		for (SpAccountProT spAccountProT : spAccountProTList) {
			prodIds.add(spAccountProT.getProductId());
		}
		EntityWrapper<SpProductT> wrapper = new EntityWrapper<SpProductT>();
		wrapper.in("id", prodIds);
		wrapper.eq("status", 1);
		List<SpProductT> splist = spProductTService.getList(wrapper);
		
		Collections.sort(splist, new Comparator<SpProductT>() {  
		    @Override  
		    public int compare(SpProductT f1, SpProductT f2) {  
		    	 if(Integer.parseInt(f1.getPrice())<Integer.parseInt(f2.getPrice())) {  
		             return 1;  
		         }  
		         return -1;  
		    }  
		}); 
		
		if(classifyId == 2){	
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("roomId", (splist.size()!=0&&splist!=null)?spProdClassifyTService.queryRoom(splist.get(0).getId()):"");
			return successResult(map);
		}
		EntityWrapper<SpProdInfoT> wrapper1 = new EntityWrapper<>();
		wrapper1.eq("prod_id", (splist.size()!=0&&splist!=null)?splist.get(0).getId():"");
		wrapper1.eq("status", 1);
		wrapper1.eq("classify_id",classifyId);
		wrapper1.orderBy("modify_time",false);
		return successResult(spProdInfoTService.getPage(pageSize, pageNum, wrapper1));
	}
	
	@ApiOperation(value = "精品资讯详情")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "所属分类id", dataType = "Long", required = true) 
	})
	@PostMapping("/infoDetails")
	@LoginValidate
	public ResultModel infoDetails(Long id){
		SpProdInfoT prodInfoT =spProdInfoTService.get(id);
		prodInfoT.setReadNum(prodInfoT.getReadNum()+1);
		spProdInfoTService.updateById(prodInfoT);
		return successResult(spProdInfoTService.get(id));
	}
	
	@ApiOperation(value = "指定产品内容查看")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true),
		@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true) ,
		@ApiImplicitParam(name = "classifyId", value = "产品分类ID", dataType = "Long", required = true) ,
		@ApiImplicitParam(name = "prodId", value = "产品ID", dataType = "Long", required = true) 
	})
	@PostMapping("/prodInfoById")
	@LoginValidate
	public ResultModel prodInfoById(Integer pageNum,Integer pageSize,Long classifyId,Long prodId){
		if(classifyId == 2){	
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("roomId", spProdClassifyTService.queryRoom(prodId));
			return successResult(map);
		}
		EntityWrapper<SpProdInfoT> wrapper = new EntityWrapper<>();
		wrapper.eq("prod_id", prodId);
		wrapper.eq("status", 1);
		wrapper.eq("classify_id",classifyId);
		return successResult(spProdInfoTService.getPage(pageSize, pageNum, wrapper));
	}
}
