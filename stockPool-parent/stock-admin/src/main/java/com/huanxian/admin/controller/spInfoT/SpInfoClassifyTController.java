package com.huanxian.admin.controller.spInfoT;

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
import com.huanxian.entity.SpInfoClassifyT;
import com.huanxian.service.SpInfoClassifyTService;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 资讯分类表 前端控制器
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/info/classify")
public class SpInfoClassifyTController extends BaseController {

	@Autowired
	private SpInfoClassifyTService classifyTService;

	@RequestMapping("/list")
	public String list() {
		return "information/infoClassify/list";
	}
	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpInfoClassifyT> listInfoClassify(String name, Integer start, Integer length, Integer infcEnable) {
		EntityWrapper<SpInfoClassifyT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(name)) {
			wrapper.eq("name", name);
		}
		if (infcEnable != null) {
			wrapper.eq("infc_enable", infcEnable);
		}
		wrapper.orderBy("create_time", false);
		PageVo<SpInfoClassifyT> page = classifyTService.getPage(length, start / length + 1, wrapper);
		return page;
	}

	@GetMapping("/edit")
	public String listInfoClassifyById(Long id,Model model) {
		SpInfoClassifyT spInfoClassifyT = classifyTService.get(id);
		model.addAttribute("classify", spInfoClassifyT);
		return "information/infoClassify/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel updateInfoClassify(SpInfoClassifyT spInfoClassifyT) {
		ResultModel model = new ResultModel();
		spInfoClassifyT.setCreateTime(new Date());
		spInfoClassifyT.setFounder(ShiroUtil.getCurrentUser().getName());
		if (spInfoClassifyT.getId() == null) {
			classifyTService.insert(spInfoClassifyT);
		} else {
			classifyTService.updateById(spInfoClassifyT);
		}
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delItem(Long id) {
		List<Long> asList = Arrays.asList(id);
		classifyTService.delInfoClassifyByIds(asList);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel delInfoClassifyByIds(Long[] table_records) {
		ResultModel model = new ResultModel();
		List<Long> ids = Arrays.asList(table_records);
		classifyTService.delInfoClassifyByIds(ids);
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
	
	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpInfoClassifyT spInfoClassifyT = new SpInfoClassifyT();
		spInfoClassifyT.setId(id);
		spInfoClassifyT.setInfcEnable(0);
		Integer result = classifyTService.updateById(spInfoClassifyT);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpInfoClassifyT entity = new SpInfoClassifyT();
		entity.setId(id);
		entity.setInfcEnable(1);
		Integer result = classifyTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}
}
