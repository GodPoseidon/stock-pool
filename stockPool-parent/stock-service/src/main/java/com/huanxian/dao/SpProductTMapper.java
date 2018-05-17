package com.huanxian.dao;

import com.huanxian.entity.SpProductT;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 产品 Mapper 接口
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-26
 */
public interface SpProductTMapper extends BaseMapper<SpProductT> {

	Integer batchDel(@Param("ids") List<Long> ids);
}
