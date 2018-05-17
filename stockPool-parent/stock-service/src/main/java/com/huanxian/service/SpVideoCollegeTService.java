package com.huanxian.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpVideoCollegeT;

/**
 * <p>
 * 视频学院-视频表 服务类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
public interface SpVideoCollegeTService{

	Integer insert(SpVideoCollegeT collegeT);
	
	Integer delete(Long id);
	
	Integer batchDel(Long[] ids);
	
	Integer update(SpVideoCollegeT collegeT);
	
	SpVideoCollegeT get(Long id);
	
	PageVo<SpVideoCollegeT> getPage(Integer pageSize,Integer pageNumber,EntityWrapper<SpVideoCollegeT> wrapper);
}
