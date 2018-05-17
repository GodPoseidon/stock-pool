package com.huanxian.dao;

import com.huanxian.entity.SpInfoClassifyT;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 资讯分类表 Mapper 接口
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpInfoClassifyTMapper extends BaseMapper<SpInfoClassifyT> {
	
	/*
	 * 批量删除资讯分类
	 */
	void delInfoClassifyByIds (@Param("ids") List<Long> ids);
	
	
}
