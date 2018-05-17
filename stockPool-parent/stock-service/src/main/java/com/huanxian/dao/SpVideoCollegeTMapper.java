package com.huanxian.dao;

import com.huanxian.entity.SpVideoCollegeT;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 视频学院-视频表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
public interface SpVideoCollegeTMapper extends BaseMapper<SpVideoCollegeT> {

	Integer delete(Long id);
	
	Integer batchDel(@Param("ids") Long[] ids);
}
