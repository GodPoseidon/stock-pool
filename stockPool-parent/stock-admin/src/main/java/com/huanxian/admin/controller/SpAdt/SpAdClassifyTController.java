package com.huanxian.admin.controller.SpAdt;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpAdClassifyT;
import com.huanxian.entity.SpAdT;
import com.huanxian.service.SpAdClassifyTService;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


/**
 * <p>
 * 广告位表 前端控制器
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/spAdClassifyT")
public class SpAdClassifyTController extends BaseController{

	@Autowired
	private SpAdClassifyTService spAdClassifyTService;
	
	
	@GetMapping("/page")
	public String list() {
		return "system/spAdt/list";
	}
	
	/**
	 * 广告位列表
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@PostMapping("/list")
	public PageVo<SpAdClassifyT> list(Integer length, Integer start,String name){
		EntityWrapper<SpAdClassifyT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(name)) {
			wrapper.like("name", name);
		}
		wrapper.eq("adc_delete", 0);
		PageVo<SpAdClassifyT> page = spAdClassifyTService.getPage(length, (start / length) + 1, wrapper);
		return page;
	}
	
	@GetMapping("/edit")
	public String edit(Long id,Model model){
		if (id != null) {
			SpAdClassifyT spAdClassifyT = spAdClassifyTService.queryAdClassify(id);
			model.addAttribute("spAdClassifyT", spAdClassifyT);
		}
		return "system/spAdt/edit";
	}
	
	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpAdClassifyT spAdClassifyT){
		spAdClassifyT.setCreatTime(new Date());
		spAdClassifyT.setFounder(ShiroUtil.getCurrentUser().getName());
		if(spAdClassifyT.getId() == null){
			spAdClassifyTService.addAdClassify(spAdClassifyT);
		}else{
			spAdClassifyTService.updateSpAdCById(spAdClassifyT);
		}
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/deleteByIds")
	public ResultModel deleteByIds(Long[] arrayId){
		List<Long> ids = Arrays.asList(arrayId);
		spAdClassifyTService.deleteByIds(ids);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		SpAdClassifyT spAdClassifyT = new SpAdClassifyT();
		spAdClassifyT.setId(id);
		spAdClassifyT.setAdcDelete(1);;
		spAdClassifyTService.updateById(spAdClassifyT);
		return successResult();
	}
}

