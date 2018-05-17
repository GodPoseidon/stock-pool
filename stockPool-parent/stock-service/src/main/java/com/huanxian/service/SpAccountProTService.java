package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpAccountProT;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 用户-产品表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-08
 */
public interface SpAccountProTService {

	
	PageVo<SpAccountProT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpAccountProT> wrapper);
	
	Integer insert(SpAccountProT spAccountProT);
	
	Integer updateById(SpAccountProT spAccountProT);
	
	SpAccountProT get(Long id);
	
	/*
	 * 批量删除资讯分类
	 */
	void delInfoClassifyByIds (List<Long> ids);

	List<SpAccountProT> getList(EntityWrapper<SpAccountProT> wrapper);
	
	List<Map<String,Object>> queryPro(Long accountId);

	PageVo<Map<String,Object>> queryByPro(Integer pageSize, Integer pageNumber,String search,String status);
}
