package com.huanxian.dao;

import com.huanxian.entity.SpCourseT;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 视频学院-名师战法-课程 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpCourseTMapper extends BaseMapper<SpCourseT> {

	Integer batchDel(@Param("ids") Long[] ids);
}
