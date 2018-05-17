package com.huanxian.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpVideoCollegeClassifyT;

/**
 * <p>
 * 视频学员-视频分类表 服务类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
public interface SpVideoCollegeClassifyTService{

	Integer insert(SpVideoCollegeClassifyT classifyT);
	
	Integer delete(Long id);
	
	Integer batchDel(Long[] ids);
	
	Integer update(SpVideoCollegeClassifyT classifyT);
	
	SpVideoCollegeClassifyT get(Long id);
	
	PageVo<SpVideoCollegeClassifyT> getPage(Integer pageSize, Integer pageNumber,EntityWrapper<SpVideoCollegeClassifyT> wrapper);
	
	List<Map<Long, String>> getVideoClassifyInfoList();
	
}
