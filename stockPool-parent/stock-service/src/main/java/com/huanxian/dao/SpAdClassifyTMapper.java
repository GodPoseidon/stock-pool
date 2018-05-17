package com.huanxian.dao;

import com.huanxian.entity.SpAdClassifyT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 广告位表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpAdClassifyTMapper extends BaseMapper<SpAdClassifyT> {
	
	/*
	 * 批量删除
	 */
	void deleteByIds(@Param("list")List<Long> list);
}
