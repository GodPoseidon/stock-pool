package com.huanxian.api.controller.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpCoursePackageT;
import com.huanxian.entity.SpInfoT;
import com.huanxian.entity.SpVideoCollegeT;
import com.huanxian.service.SpCoursePackageTService;
import com.huanxian.service.SpInfoTService;
import com.huanxian.service.SpVideoCollegeTService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("免费资讯")
@RestController
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private SpInfoTService infoTService;
	
	@Autowired
	private SpVideoCollegeTService spVideoCollegeTService;
	
	@Autowired
	private SpCoursePackageTService spCoursePackageTService;
	
	
	
	@ApiOperation(value = "资讯列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true) ,
			@ApiImplicitParam(name = "classId", value = "所属分类id", dataType = "Long", required = true) 
	})
	@PostMapping("/infoMain")
	public ResultModel queryInfo(Integer pageSize,Integer pageNum,Long classId){
		ResultModel model = new ResultModel();
		if(classId == 3){
			model = videoMain();
		}else{	
			EntityWrapper<SpInfoT> wrapper = new EntityWrapper<SpInfoT>();
			wrapper.eq("classId", classId);
			wrapper.orderBy("create_time", false);
			model.setData(infoTService.getPage(pageSize, pageNum, wrapper));
			model.setSuccess(true);
		}
		return model;
	}
	
	
	
	@ApiOperation(value = "资讯详情")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "id", value = "所属分类id", dataType = "Long", required = true) 
	})
	@PostMapping("/infoDetails")
	public ResultModel infoDetails(Long id){
		ResultModel model = new ResultModel();
		SpInfoT spInfoT = infoTService.get(id);
		spInfoT.setReadsum(spInfoT.getReadsum()+1);
		infoTService.updateById(spInfoT);
		EntityWrapper<SpInfoT> wrapper = new EntityWrapper<SpInfoT>();
		wrapper.eq("inf_rec", 1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("details", infoTService.get(id));
		map.put("resInfo", infoTService.getPage(5, 1, wrapper));
		//map.put(key, value);
		model.setData(map);
		model.setSuccess(true);
		return model;
	}
	
	
	/**
	 * 视频学院
	 * @return
	 */
	private ResultModel videoMain(){
		ResultModel model = new ResultModel();
		Map<String,Object> map = new HashMap<String,Object>();
		EntityWrapper<SpCoursePackageT> coursePackage = new EntityWrapper<SpCoursePackageT>();
		coursePackage.eq("status", 1);
		map.put("courseData", spCoursePackageTService.getPage(coursePackage, 4, 1));
		
		
		EntityWrapper<SpVideoCollegeT> videoCollege = new EntityWrapper<SpVideoCollegeT>();
		videoCollege.eq("status", 1);
		videoCollege.eq("classify_name", "解盘策略");
		map.put("videoCollege1", spVideoCollegeTService.getPage(4, 1, videoCollege));
		
		
		EntityWrapper<SpVideoCollegeT> videoCollege1 = new EntityWrapper<SpVideoCollegeT>();
		videoCollege1.eq("status", 1);
		videoCollege1.eq("classify_name", "泛财经");
		map.put("videoCollege2", spVideoCollegeTService.getPage(4, 1, videoCollege1));
		
		
		model.setData(map);
		model.setSuccess(true);
		return model;
	}
}
