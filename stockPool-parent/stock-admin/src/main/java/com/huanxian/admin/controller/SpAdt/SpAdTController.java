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
import com.huanxian.entity.SysUserT;
import com.huanxian.service.SpAdClassifyTService;
import com.huanxian.service.SpAdTService;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 * 广告表 前端控制器
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/spAdT")
public class SpAdTController extends BaseController{

	@Autowired
	private SpAdTService spAdTService;
	
	@Autowired
	private SpAdClassifyTService spAdClassifyTService;
	
	@GetMapping("/page")
	public String list() {
		return "system/spAdt/adtlist";
	}
	
	@ResponseBody
	@PostMapping("/list")
	public PageVo<SpAdT> list(Integer status, Integer length, Integer start,String name){
		EntityWrapper<SpAdT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(name)) {
			wrapper.like("name", name);
		}
		if (status != null) {
			wrapper.eq("ad_enable", status);
		}
		PageVo<SpAdT> page = spAdTService.getPage(length, (start / length) + 1, wrapper);
		return page;
	}
	
	@GetMapping("/edit")
	public String edit(Long id,Model model){
		if (id != null) {
			SpAdT spAdT = spAdTService.get(id);
			model.addAttribute("spAdT", spAdT);
		}
		EntityWrapper<SpAdClassifyT> wrapper = new EntityWrapper<>();
		wrapper.eq("adc_delete", 0);
		model.addAttribute("classInfo",spAdClassifyTService.getList(wrapper));
		return "system/spAdt/adtedit";
	}
	
	/**
	 * 更新广告（添加、修改、删除、启/禁用）
	 * @param spAdT
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpAdT spAdT){
		spAdT.setCreateTime(new Date());
		spAdT.setFounder(ShiroUtil.getCurrentUser().getName());
		if(spAdT.getId() == null){
			spAdTService.insert(spAdT);
		}else{
			spAdTService.updateById(spAdT);
		}
		return successResult();
	}
	
	/**
	 * 批量启/禁用
	 * @param ids
	 * @param adEnable
	 * @return
	 */
	@ResponseBody
	@PostMapping("/enbAdtByIds")
	public ResultModel enbAdtByIds(Long[] ids,String adEnable){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("adEnable", adEnable);
		map.put("ids", Arrays.asList(ids));
		spAdTService.enbAdtByIds(map);
		return successResult();
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@PostMapping("/delAdtByIds")
	public ResultModel delAdtByIds(Long[] arrayId){
		List<Long> ids = Arrays.asList(arrayId);
		spAdTService.delAdtByIds(ids);
		return successResult();
	}
	
	
	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enanle(Long id) {
		SpAdT spAdT = new SpAdT();
		spAdT.setId(id);
		spAdT.setAdEnable(0);
		spAdTService.updateById(spAdT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SpAdT spAdT = new SpAdT();
		spAdT.setId(id);
		spAdT.setAdEnable(1);
		spAdTService.updateById(spAdT);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		SpAdT spAdT = new SpAdT();
		spAdT.setId(id);
		spAdT.setAdDelete(1);
		spAdTService.updateById(spAdT);
		return successResult();
	}
}

