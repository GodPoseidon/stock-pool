package com.huanxian.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpInfoClassifyT;

/**
 * <p>
 * 资讯分类表 服务类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
public interface SpInfoClassifyTService {

	
	PageVo<SpInfoClassifyT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpInfoClassifyT> wrapper);
	
	Integer insert(SpInfoClassifyT spInfoClassifyT);
	
	Integer updateById(SpInfoClassifyT spInfoClassifyT);
	
	SpInfoClassifyT get(Long id);
	
	/*
	 * 批量删除资讯分类
	 */
	void delInfoClassifyByIds (List<Long> ids);
	
	List<SpInfoClassifyT> getClassifyList();
	
}
