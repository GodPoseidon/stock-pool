package com.huanxian.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huanxian.entity.SpProdInfoT;

/**
 * <p>
 * 产品-子项目内容表 Mapper 接口
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
public interface SpProdInfoTMapper extends BaseMapper<SpProdInfoT> {
	
	Integer batchDel(@Param("ids") List<Long> ids);
	
}
