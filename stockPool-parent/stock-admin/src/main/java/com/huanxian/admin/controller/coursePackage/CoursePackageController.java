package com.huanxian.admin.controller.coursePackage;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.huanxian.entity.SpCoursePackageT;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SpCoursePackageTService;

import cn.hutool.core.util.StrUtil;

/**
 * 视频学院-名师战法课程包
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/coursePackage")
public class CoursePackageController extends BaseController {

	@Autowired
	private SpCoursePackageTService coursePackageTService;
	
	@Autowired
	private SpAccountTService spAccountTService;

	@GetMapping("/list")
	public String list() {
		return "coursePackage/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpCoursePackageT> listData(String title, Integer status, Integer length, Integer start) {
		EntityWrapper<SpCoursePackageT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.orderBy("sort", true);
		wrapper.orderBy("modify_time", false);
		PageVo<SpCoursePackageT> page = coursePackageTService.getPage(wrapper, length, start / length + 1);
		return page;
	}

	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		SpCoursePackageT spCoursePackageT = coursePackageTService.get(id);
		model.addAttribute("package", spCoursePackageT);
		List<Map<Long,String>> teacherList = spAccountTService.getTeacherList();
		model.addAttribute("teacherList", teacherList);
		return "coursePackage/edit";
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		coursePackageTService.delete(id);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpCoursePackageT coursePackageT) {
		coursePackageT.setModifyTime(new Date());
		coursePackageT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (coursePackageT.getId() == null) {
			coursePackageTService.insert(coursePackageT);
		} else {
			coursePackageTService.update(coursePackageT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpCoursePackageT entity = new SpCoursePackageT();
		entity.setId(id);
		entity.setStatus(1);
		entity.setModifyTime(new Date());
		entity.setModifyUser(ShiroUtil.getCurrentUser().getName());
		Integer delete = coursePackageTService.update(entity);
		model.setSuccess(delete > 0);
		return model;
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpCoursePackageT entity = new SpCoursePackageT();
		entity.setId(id);
		entity.setStatus(2);
		entity.setModifyTime(new Date());
		entity.setModifyUser(ShiroUtil.getCurrentUser().getName());
		Integer delete = coursePackageTService.update(entity);
		model.setSuccess(delete > 0);
		return model;
	}

}
