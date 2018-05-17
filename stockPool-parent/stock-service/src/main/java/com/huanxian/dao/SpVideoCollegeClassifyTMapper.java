package com.huanxian.dao;

import com.huanxian.entity.SpVideoCollegeClassifyT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 视频学员-视频分类表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
public interface SpVideoCollegeClassifyTMapper extends BaseMapper<SpVideoCollegeClassifyT> {

	Integer delete(Long id);
	
	Integer batchDel(@Param("ids") Long[] ids);
	
	List<Map<Long, String>> getVideoClassifyInfoList();

}
