package com.huanxian.service;

import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpAccountT;
import com.huanxian.entity.SpInfoT;
import com.huanxian.entity.SpProdInfoT;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 产品-子项目内容表 服务类
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
public interface SpProdInfoTService {

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	Integer batchDel(List<Long> ids);
	
	
	PageVo<SpProdInfoT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpProdInfoT> wrapper);
	
	Integer insert(SpProdInfoT spProdInfoT);
	
	Integer updateById(SpProdInfoT spProdInfoT);
	
	SpProdInfoT get(Long id);

	List<SpProdInfoT> queryList(EntityWrapper<SpProdInfoT> wrapper);
	
}
