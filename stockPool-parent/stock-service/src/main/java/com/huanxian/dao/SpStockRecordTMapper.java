package com.huanxian.dao;

import com.huanxian.entity.SpStockRecordT;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 牛股战绩 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
public interface SpStockRecordTMapper extends BaseMapper<SpStockRecordT> {

	Integer batchDel(@Param("ids") Long[] id);
	
	List<SpStockRecordT> getList(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);
}
