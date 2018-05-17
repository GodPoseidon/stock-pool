package com.huanxian.admin.controller.video;

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
import com.huanxian.entity.SpVideoCollegeT;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SpVideoCollegeClassifyTService;
import com.huanxian.service.SpVideoCollegeTService;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 视频学院-视频表 前端控制器
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/video")
public class VideoCollegeController extends BaseController {

	@Autowired
	private SpVideoCollegeTService spVideoCollegeTService;

	@Autowired
	private SpVideoCollegeClassifyTService spVideoCollegeClassifyTService;

	@Autowired
	private SpAccountTService spAccountTService;

	@GetMapping("/list")
	public String list(Model model) {
		List<Map<Long, String>> videoClassifyInfoList = spVideoCollegeClassifyTService.getVideoClassifyInfoList();
		model.addAttribute("classifyList", videoClassifyInfoList);
		return "video/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpVideoCollegeT> listData(String title, Long teacherId, String classifyName, Integer status,
			Integer length, Integer start) {
		EntityWrapper<SpVideoCollegeT> wrapper = new EntityWrapper<SpVideoCollegeT>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (teacherId != null) {
			wrapper.eq("teacher_id", teacherId);
		}
		if (StrUtil.isNotBlank(classifyName)) {
			wrapper.eq("classify_name", classifyName);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.orderBy("modify_time", false);
		PageVo<SpVideoCollegeT> page = spVideoCollegeTService.getPage(length, start / length + 1, wrapper);
		return page;
	}

	@GetMapping("/edit")
	public String get(Long id, Model model) {
		int minute = 0,second = 0;
		SpVideoCollegeT video = spVideoCollegeTService.get(id);
		if (video != null && NumberUtil.isInteger(video.getVideoTime())) {
			String time = video.getVideoTime();
			minute = Integer.valueOf(time) / 60;
			second = Integer.valueOf(time) % 60;
		}
		model.addAttribute("minute", minute);
		model.addAttribute("second", second);
		model.addAttribute("video", video);
		List<Map<Long, String>> videoClassifyInfoList = spVideoCollegeClassifyTService.getVideoClassifyInfoList();
		model.addAttribute("classifyList", videoClassifyInfoList);
		List<Map<Long, String>> teacherList = spAccountTService.getTeacherList();
		model.addAttribute("teacherList", teacherList);
		return "video/edit";
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		ResultModel model = new ResultModel();
		Integer delete = spVideoCollegeTService.delete(id);
		if (delete > 0) {
			model.setSuccess(true);
			model.setCode("0");
		} else {
			model.setSuccess(false);
			model.setCode("500");
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpVideoCollegeT collegeT, String minute, String second) {
		ResultModel model = new ResultModel();
		if (NumberUtil.isNumber(minute) && NumberUtil.isNumber(second)) {
			collegeT.setVideoTime((Integer.valueOf(minute) * 60 + Integer.valueOf(second))+"");
		}
		collegeT.setModifyTime(new Date());
		collegeT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (collegeT.getId() == null) {
			Integer insert = spVideoCollegeTService.insert(collegeT);
			if (insert > 0) {
				model.setCode("0");
				model.setSuccess(true);
			} else {
				model.setCode("500");
				model.setMessage("新增失败！");
				model.setSuccess(false);
			}
		} else {
			Integer update = spVideoCollegeTService.update(collegeT);
			if (update > 0) {
				model.setCode("0");
				model.setSuccess(true);
			} else {
				model.setCode("500");
				model.setMessage("新增失败！");
				model.setSuccess(false);
			}
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		spVideoCollegeTService.batchDel(table_records);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		SpVideoCollegeT collegeT = new SpVideoCollegeT();
		collegeT.setId(id);
		collegeT.setStatus(1);
		collegeT.setModifyTime(new Date());
		collegeT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		spVideoCollegeTService.update(collegeT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SpVideoCollegeT collegeT = new SpVideoCollegeT();
		collegeT.setId(id);
		collegeT.setStatus(2);
		collegeT.setModifyTime(new Date());
		collegeT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		spVideoCollegeTService.update(collegeT);
		return successResult();
	}
}
