package com.huanxian.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpCoursePackageT;

/**
 * <p>
 * 视频学院-名师战法课程包 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpCoursePackageTService {

	Integer delete(Long id);
	
	Integer insert(SpCoursePackageT coursePackageT);
	
	Integer update(SpCoursePackageT coursePackageT);
	
	SpCoursePackageT get(Long id);
	
	PageVo<SpCoursePackageT> getPage(EntityWrapper<SpCoursePackageT> wrapper,Integer pageSize,Integer pageNum);
	
	/**
	 * 只获取id和title
	 * @return
	 */
	List<Map<Long , String>> getPackageInfoList();
	
}
