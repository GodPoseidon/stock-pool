package com.huanxian.api.controller.videoCollege;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpCoursePackageT;
import com.huanxian.entity.SpCourseT;
import com.huanxian.entity.SpVideoCollegeT;
import com.huanxian.service.SpCoursePackageTService;
import com.huanxian.service.SpCourseTService;
import com.huanxian.service.SpVideoCollegeTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("视频学院")
@RestController
@RequestMapping("/videoCollege")
public class VideoCollegeController {

	@Autowired
	private SpVideoCollegeTService spVideoCollegeTService;
	
	
	@Autowired
	private SpCourseTService spCourseTService;
	
	@Autowired
	private SpCoursePackageTService spCoursePackageTService;
	
	@ApiOperation(value = "名师战法课程包列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "Integer", required = true),
		@ApiImplicitParam(name = "pageNum", value = "页码,从1开始", paramType = "Integer", required = true) })
	@PostMapping("/queryCourse")
	public ResultModel queryCourse(Integer pageNum,Integer pageSize){
		ResultModel model = new ResultModel();
		
		EntityWrapper<SpCoursePackageT> course = new EntityWrapper<SpCoursePackageT>();
		course.eq("status", 1);
		
		model.setData(spCoursePackageTService.getPage(course, pageSize, pageNum));
		model.setSuccess(true);
		return model;
	}
	
	
	@ApiOperation(value = "课程包视频列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "packageId", value = "课程包Id", paramType = "Long", required = true) })
	@PostMapping("/queryCourseVideo")
	public ResultModel queryCourseVideo (Long packageId){
		ResultModel model = new ResultModel();
		
		EntityWrapper<SpCourseT> course = new EntityWrapper<SpCourseT>();
		course.eq("status", 1);
		course.eq("package_id", packageId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pic", spCoursePackageTService.get(packageId).getPic());
		map.put("courseDate", spCourseTService.getPage(course, 100, 1));
		model.setData(map);
		model.setSuccess(true);
		return model;
	}
	
	
	@ApiOperation(value = "解盘策视频列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "Integer", required = true),
		@ApiImplicitParam(name = "pageNum", value = "页码,从1开始", paramType = "Integer", required = true) })
	@PostMapping("/queryVideoCollege1")
	public ResultModel queryVideoCollege1(Integer pageNum,Integer pageSize){
		ResultModel model = new ResultModel();
		
		EntityWrapper<SpVideoCollegeT> videoCollege = new EntityWrapper<SpVideoCollegeT>();
		videoCollege.eq("status", 1);
		videoCollege.eq("classify_name", "解盘策略");	
		model.setData(spVideoCollegeTService.getPage(pageSize, pageNum,videoCollege));
		model.setSuccess(true);
		return model;
	}
	
	@ApiOperation(value = "泛财经视频列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "每页数量", paramType = "Integer", required = true),
		@ApiImplicitParam(name = "pageNum", value = "页码,从1开始", paramType = "Integer", required = true) })
	@PostMapping("/queryVideoCollege2")
	public ResultModel queryVideoCollege2(Integer pageNum,Integer pageSize){
		ResultModel model = new ResultModel();
		
		EntityWrapper<SpVideoCollegeT> videoCollege = new EntityWrapper<SpVideoCollegeT>();
		videoCollege.eq("status", 1);
		videoCollege.eq("classify_name", "泛财经");	
		model.setData(spVideoCollegeTService.getPage(pageSize, pageNum,videoCollege));
		model.setSuccess(true);
		return model;
	}
}
