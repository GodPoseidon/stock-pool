package com.huanxian.service;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpStockRecordT;

/**
 * <p>
 * 牛股战绩 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
public interface SpStockRecordTService {

	Integer insert(SpStockRecordT recordT);

	Integer batchDel(Long[] id);

	Integer update(SpStockRecordT recordT);

	SpStockRecordT get(Long id);

	PageVo<SpStockRecordT> getPage(EntityWrapper<SpStockRecordT> wrapper, Integer pageSize, Integer pageNum);
	
	List<SpStockRecordT> getList(Integer pageSize,Integer pageNum);
	
}
