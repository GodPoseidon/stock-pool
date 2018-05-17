package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpProductT;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 产品 服务类
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-26
 */
public interface SpProductTService {

	Integer batchDel(List<Long> ids);
	
	PageVo<SpProductT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpProductT> wrapper);
	
	Integer insert(SpProductT spProductT);
	
	Integer updateById(SpProductT spProductT);
	
	SpProductT get(Long id);

	List<SpProductT> getList(EntityWrapper<SpProductT> wrapper);
	
}
