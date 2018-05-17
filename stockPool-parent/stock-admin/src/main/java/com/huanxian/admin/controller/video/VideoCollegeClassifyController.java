package com.huanxian.admin.controller.video;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpVideoCollegeClassifyT;
import com.huanxian.service.SpVideoCollegeClassifyTService;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 视频学员-视频分类表 前端控制器
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/video/classify")
public class VideoCollegeClassifyController {

	@Autowired
	SpVideoCollegeClassifyTService spVideoCollegeClassifyTService;

	@RequestMapping("/list")
	public String list() {
		return "video/classify/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpVideoCollegeClassifyT> getDataList(String name, Integer status, Integer start, Integer length) {
		EntityWrapper<SpVideoCollegeClassifyT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(name)) {
			wrapper.like("name", name);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.orderBy("modify_time", false);
		PageVo<SpVideoCollegeClassifyT> page = spVideoCollegeClassifyTService.getPage(length, start / length + 1, wrapper);
		return page;
	}

	@GetMapping("/edit")
	public String getData(Long id,Model model) {
		SpVideoCollegeClassifyT spVideoCollegeClassifyT = spVideoCollegeClassifyTService.get(id);
		model.addAttribute("classify", spVideoCollegeClassifyT);
		return "video/classify/edit.html";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpVideoCollegeClassifyT classifyT) {
		ResultModel model = new ResultModel();
		classifyT.setModifyTime(new Date());
		classifyT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (classifyT.getId() == null) {
			Integer insert = spVideoCollegeClassifyTService.insert(classifyT);
			model.setSuccess(insert > 0);
		} else {
			Integer update = spVideoCollegeClassifyTService.update(classifyT);
			model.setSuccess(update > 0);
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		ResultModel model = new ResultModel();
		Integer delete = spVideoCollegeClassifyTService.delete(id);
		model.setSuccess(delete > 0);
		return model;
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpVideoCollegeClassifyT classifyT = new SpVideoCollegeClassifyT();
		classifyT.setId(id);
		classifyT.setStatus(1);
		classifyT.setModifyTime(new Date());
		classifyT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		Integer delete = spVideoCollegeClassifyTService.update(classifyT);
		model.setSuccess(delete > 0);
		return model;
	}
	
	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpVideoCollegeClassifyT classifyT = new SpVideoCollegeClassifyT();
		classifyT.setId(id);
		classifyT.setStatus(2);
		classifyT.setModifyTime(new Date());
		classifyT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		Integer delete = spVideoCollegeClassifyTService.update(classifyT);
		model.setSuccess(delete > 0);
		return model;
	}

}
