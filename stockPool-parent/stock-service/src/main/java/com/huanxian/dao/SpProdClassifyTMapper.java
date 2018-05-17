package com.huanxian.dao;

import com.huanxian.entity.SpProdClassifyT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 产品-子项目分类表 Mapper 接口
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
public interface SpProdClassifyTMapper extends BaseMapper<SpProdClassifyT> {

	Integer batchDel(@Param("ids") List<Long> ids);
	
	String queryRoom(@Param("prodId") Long prodId);
	
}
