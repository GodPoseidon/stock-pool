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
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpInfoClassifyT;
import com.huanxian.entity.SpInfoT;
import com.huanxian.service.SpInfoClassifyTService;
import com.huanxian.service.SpInfoTService;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 资讯表 前端控制器
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/info")
public class SpInfoTController extends BaseController {

	@Autowired
	private SpInfoTService spInfoTService;
	
	@Autowired
	private SpInfoClassifyTService spInfoClassifyTService;

	@RequestMapping("/list")
	public String list(Model model) {
		List<SpInfoClassifyT> classifyList = spInfoClassifyTService.getClassifyList();
		model.addAttribute("classifyList", classifyList);
		return "information/info/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpInfoT> listInfo(Integer start, Integer length, String className, String title, Integer infEnable,
			String startDate, String endDate) {
		EntityWrapper<SpInfoT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (StrUtil.isNotBlank(className)) {
			wrapper.like("className", className);
		}
		if (infEnable != null) {
			wrapper.eq("inf_enable", infEnable);
		}
		if (StrUtil.isNotBlank(startDate)) {
			wrapper.gt("create_time", startDate);
		}
		if (StrUtil.isNotBlank(endDate)) {
			wrapper.le("create_time", endDate);
		}
		wrapper.eq("inf_delete", 0);
		wrapper.orderBy("create_time", false);
		PageVo<SpInfoT> page = spInfoTService.getPage(length, start / length + 1, wrapper);
		return page;
	}

	@RequestMapping("/view")
	public String view(Long id, Model model) {
		SpInfoT spInfoT = spInfoTService.get(id);
		model.addAttribute("info", spInfoT);
		return "information/info/view";
	}

	@GetMapping("/edit")
	public String listInfoById(Long id, Model model) {
		SpInfoT spInfoT = spInfoTService.get(id);
		model.addAttribute("info", spInfoT);
		List<SpInfoClassifyT> classifyList = spInfoClassifyTService.getClassifyList();
		model.addAttribute("classifyList", classifyList);
		return "information/info/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel updateInfo(SpInfoT spInfoT) {
		ResultModel model = new ResultModel();
		spInfoT.setCreatTime(new Date());
		if (spInfoT.getId() == null) {
			spInfoTService.insert(spInfoT);
		} else {
			spInfoTService.updateById(spInfoT);
		}
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		List<Long> asList = Arrays.asList(id);
		spInfoTService.delInfoByIds(asList);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel delInfoByIds(Long[] table_records) {
		ResultModel model = new ResultModel();
		List<Long> ids = Arrays.asList(table_records);
		spInfoTService.delInfoByIds(ids);
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpInfoT entity = new SpInfoT();
		entity.setId(id);
		entity.setInfEnable(0);
		Integer result = spInfoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpInfoT entity = new SpInfoT();
		entity.setId(id);
		entity.setInfEnable(1);
		Integer result = spInfoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@RequestMapping("/release")
	public ResultModel release(Long id) {
		ResultModel model = new ResultModel();
		SpInfoT entity = new SpInfoT();
		entity.setId(id);
		entity.setInfRelease(1);
		Integer result = spInfoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@RequestMapping("/unRelease")
	public ResultModel unRelease(Long id) {
		ResultModel model = new ResultModel();
		SpInfoT entity = new SpInfoT();
		entity.setId(id);
		entity.setInfRelease(0);
		Integer result = spInfoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/recommend")
	public ResultModel recommend(Long id) {
		ResultModel model = new ResultModel();
		SpInfoT entity = new SpInfoT();
		entity.setId(id);
		entity.setInfRec(1);
		Integer result = spInfoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@RequestMapping("/unRecommend")
	public ResultModel unRecommend(Long id) {
		ResultModel model = new ResultModel();
		SpInfoT entity = new SpInfoT();
		entity.setId(id);
		entity.setInfRec(0);
		Integer result = spInfoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}
}
