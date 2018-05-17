package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpStockRecordTMapper;
import com.huanxian.entity.SpStockRecordT;
import com.huanxian.service.SpStockRecordTService;

import cn.hutool.core.util.PageUtil;

/**
 * <p>
 * 牛股战绩 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
@Service
public class SpStockRecordTServiceImpl implements SpStockRecordTService {

	@Autowired
	private SpStockRecordTMapper spStockRecordTMapper;

	@Override
	public Integer insert(SpStockRecordT recordT) {
		return spStockRecordTMapper.insert(recordT);
	}

	@Override
	public Integer batchDel(Long[] id) {
		return spStockRecordTMapper.batchDel(id);
	}

	@Override
	public Integer update(SpStockRecordT recordT) {
		return spStockRecordTMapper.updateById(recordT);
	}

	@Override
	public SpStockRecordT get(Long id) {
		return spStockRecordTMapper.selectById(id);
	}

	@Override
	public PageVo<SpStockRecordT> getPage(EntityWrapper<SpStockRecordT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SpStockRecordT> stockList = spStockRecordTMapper.selectList(wrapper);
		PageVo<SpStockRecordT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNum);
		pageVo.setData(stockList);
		pageVo.setPageSize(pageSize);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal() + "");
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public List<SpStockRecordT> getList(Integer pageSize, Integer pageNum) {
		return spStockRecordTMapper.getList(pageSize * (pageNum - 1), pageSize);
	}

}
