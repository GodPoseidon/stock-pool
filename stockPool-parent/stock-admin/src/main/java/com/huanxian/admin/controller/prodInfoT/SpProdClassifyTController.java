package com.huanxian.admin.controller.prodInfoT;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpProdClassifyT;
import com.huanxian.entity.SpProductT;
import com.huanxian.service.SpProdClassifyTService;
import com.huanxian.service.SpProductTService;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 产品-子项目分类表 前端控制器
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/spProdClassifyT")
public class SpProdClassifyTController extends BaseController{

	
	@Autowired
	private SpProdClassifyTService spProdClassifyTService;
	
	
	@Autowired
	private SpProductTService spProductTService;
	
	
	@GetMapping("/page")
	public String list() {
		return "product/classlist";
	}
	
	
	
	/**
	 * 产品分类查询
	 * @param pageNumber
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@PostMapping("/list")
	public PageVo<SpProdClassifyT> listProdClassifyT(Integer start,Integer length,String name){
		EntityWrapper<SpProdClassifyT> wrapper = new EntityWrapper<SpProdClassifyT>();
		
		if (StrUtil.isNotBlank(name)) {
			wrapper.like("name", name);
		}
		PageVo<SpProdClassifyT> page = spProdClassifyTService.getPage(length, (start / length) + 1, wrapper);
		return page;
	}
	
	
	@GetMapping("/edit")
	public String edit(Long id,Model model){
		if (id != null) {
			SpProdClassifyT spProdClassifyT = spProdClassifyTService.get(id);
			model.addAttribute("spProdClassifyT", spProdClassifyT);
		}
		EntityWrapper<SpProductT> wrapper = new EntityWrapper<>();
		wrapper.ne("status", 3);
		model.addAttribute("prodList",spProductTService.getList(wrapper));
		return "product/classedit";
	}
	
	@GetMapping("/edit2")
	public String edit2(Long id,Long prodId,Model model){
		
		if (id == null && prodId != null) {
			SpProdClassifyT spProdClassifyT = new SpProdClassifyT();
			spProdClassifyT.setProdId(prodId);
			model.addAttribute("spProdClassifyT", spProdClassifyT);
		}
		if (id != null) {
			SpProdClassifyT spProdClassifyT = spProdClassifyTService.get(id);
			EntityWrapper<SpProductT> wrapper = new EntityWrapper<>();
			wrapper.ne("status", 3);
			model.addAttribute("prodList",spProductTService.getList(wrapper));
			model.addAttribute("spProdClassifyT", spProdClassifyT);
		}
		return "product/classedit2";
	}
	
	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpProdClassifyT spProdClassifyT,Long prodId){
		spProdClassifyT.setProdId(prodId);
		spProdClassifyT.setModifyTime(new Date());
		spProdClassifyT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		spProdClassifyT.setStatus(1);
		if(spProdClassifyT.getId() == null && prodId != null){
			
			spProdClassifyTService.insert(spProdClassifyT);
		}else{
			spProdClassifyTService.updateById(spProdClassifyT);
		}
		return successResult();
	}
	
	@PostMapping("/updateById")
	public ResultModel updateById(SpProdClassifyT prodClassifyT){
		ResultModel model = new ResultModel();
		if(prodClassifyT.getId() == null){
			spProdClassifyTService.insert(prodClassifyT);
		}else{
			spProdClassifyTService.updateById(prodClassifyT);
		}
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
	
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		List<Long> asList = Arrays.asList(id);
		spProdClassifyTService.batchDel(asList);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records){
		ResultModel model = new ResultModel();
		List<Long> ids = Arrays.asList(table_records);
		spProdClassifyTService.batchDel(ids);
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
}

