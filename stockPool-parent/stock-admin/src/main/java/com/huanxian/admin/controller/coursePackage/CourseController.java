package com.huanxian.admin.controller.coursePackage;

import java.util.Date;

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
import com.huanxian.entity.SpCourseT;
import com.huanxian.service.SpCourseTService;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 视频学院-名师战法课程包-课程
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {

	@Autowired
	private SpCourseTService courseTService;

	@GetMapping("/list")
	public String list(Long packageId, Model model) {
		model.addAttribute("packageId", packageId);
		return "course/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpCourseT> list(Long packageId, String title, Integer status, Integer length, Integer start) {
		EntityWrapper<SpCourseT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.eq("package_id", packageId);
		wrapper.orderBy("sort", true);
		wrapper.orderBy("modify_time", false);
		PageVo<SpCourseT> page = courseTService.getPage(wrapper, length, start / length + 1);
		return page;
	}

	@GetMapping("/edit")
	public String get(Long id, Long packageId, Model model) {
		SpCourseT spCourseT = courseTService.get(id);
		int minute = 0, second = 0;
		if (spCourseT == null && packageId != null) {
			spCourseT = new SpCourseT();
			spCourseT.setPackageId(packageId);
		}
		if (spCourseT != null) {
			String videoTime = spCourseT.getVideoTime();
			if (NumberUtil.isInteger(videoTime)) {
				minute = Integer.valueOf(videoTime) / 60;
				second = Integer.valueOf(videoTime) % 60;
			}
		}
		model.addAttribute("course", spCourseT);
		model.addAttribute("minute", minute);
		model.addAttribute("second", second);
		return "course/edit";
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		courseTService.delete(id);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		courseTService.batchDel(table_records);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpCourseT courseT, String minute, String second) {
		if (NumberUtil.isNumber(minute) && NumberUtil.isNumber(second)) {
			courseT.setVideoTime((Integer.valueOf(minute) * 60 + Integer.valueOf(second)) + "");
		}
		courseT.setModifyTime(new Date());
		courseT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (courseT.getId() == null) {
			courseTService.insert(courseT);
		} else {
			courseTService.update(courseT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpCourseT entity = new SpCourseT();
		entity.setId(id);
		entity.setStatus(1);
		entity.setModifyTime(new Date());
		entity.setModifyUser(ShiroUtil.getCurrentUser().getName());
		Integer delete = courseTService.update(entity);
		model.setSuccess(delete > 0);
		return model;
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpCourseT entity = new SpCourseT();
		entity.setId(id);
		entity.setStatus(2);
		entity.setModifyTime(new Date());
		entity.setModifyUser(ShiroUtil.getCurrentUser().getName());
		Integer delete = courseTService.update(entity);
		model.setSuccess(delete > 0);
		return model;
	}

}
