package com.huanxian.service.impl;

import com.huanxian.entity.SpProdClassifyT;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpProdClassifyTMapper;
import com.huanxian.service.SpProdClassifyTService;

import cn.hutool.core.util.PageUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品-子项目分类表 服务实现类
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
@Service
public class SpProdClassifyTServiceImpl implements SpProdClassifyTService {

	@Autowired
	private SpProdClassifyTMapper spProdClassifyTMapper;
	
	@Override
	public Integer batchDel(List<Long> ids) {
		// TODO Auto-generated method stub
		return spProdClassifyTMapper.batchDel(ids);
	}

	@Override
	public PageVo<SpProdClassifyT> getPage(Integer pageSize, Integer pageNumber,
			EntityWrapper<SpProdClassifyT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		wrapper.ne("status", 3);
		List<SpProdClassifyT> spProdClassifyTList = spProdClassifyTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpProdClassifyT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spProdClassifyTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer insert(SpProdClassifyT spProdInfoT) {
		// TODO Auto-generated method stub
		return spProdClassifyTMapper.insert(spProdInfoT);
	}

	@Override
	public Integer updateById(SpProdClassifyT spProdInfoT) {
		// TODO Auto-generated method stub
		return spProdClassifyTMapper.updateById(spProdInfoT);
	}

	@Override
	public SpProdClassifyT get(Long id) {
		// TODO Auto-generated method stub
		return spProdClassifyTMapper.selectById(id);
	}

	@Override
	public String queryRoom(Long prodId) {
		// TODO Auto-generated method stub
		return spProdClassifyTMapper.queryRoom(prodId);
	}

	@Override
	public List<SpProdClassifyT> getList(EntityWrapper<SpProdClassifyT> wrapper) {
		// TODO Auto-generated method stub
		return spProdClassifyTMapper.selectList(wrapper);
	}

	
}
