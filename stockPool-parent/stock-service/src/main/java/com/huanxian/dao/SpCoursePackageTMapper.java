package com.huanxian.dao;

import com.huanxian.entity.SpCoursePackageT;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 视频学院-名师战法课程包 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpCoursePackageTMapper extends BaseMapper<SpCoursePackageT> {

	Integer delete(Long id);
	
	/**
	 * 只获取id和title
	 * @return
	 */
	List<Map<Long , String>> getPackageInfoList();
}
