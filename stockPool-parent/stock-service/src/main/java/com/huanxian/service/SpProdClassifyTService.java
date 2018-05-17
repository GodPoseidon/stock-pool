package com.huanxian.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpProdClassifyT;

/**
 * <p>
 * 产品-子项目分类表 服务类
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
public interface SpProdClassifyTService {

	Integer batchDel(List<Long> ids);
	
	PageVo<SpProdClassifyT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpProdClassifyT> wrapper);
	
	Integer insert(SpProdClassifyT spProdInfoT);
	
	Integer updateById(SpProdClassifyT spProdInfoT);
	
	SpProdClassifyT get(Long id);
	
	String queryRoom(Long prodId); 
	
	List<SpProdClassifyT> getList(EntityWrapper<SpProdClassifyT> wrapper);
	
}
