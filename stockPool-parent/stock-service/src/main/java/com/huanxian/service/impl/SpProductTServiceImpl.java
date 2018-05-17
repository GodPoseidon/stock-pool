package com.huanxian.service.impl;

import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpProductTMapper;
import com.huanxian.entity.SpProductT;
import com.huanxian.service.SpProductTService;

import cn.hutool.core.util.PageUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-26
 */
@Service
public class SpProductTServiceImpl implements SpProductTService {

	@Autowired
	private SpProductTMapper spProductTMapper;
	
	@Override
	public Integer batchDel(List<Long> ids) {
		// TODO Auto-generated method stub
		return spProductTMapper.batchDel(ids);
	}

	@Override
	public PageVo<SpProductT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpProductT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		List<SpProductT> spProductTTList = spProductTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpProductT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spProductTTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer insert(SpProductT spProductT) {
		// TODO Auto-generated method stub
		return spProductTMapper.insert(spProductT);
	}

	@Override
	public Integer updateById(SpProductT spProductT) {
		// TODO Auto-generated method stub
		return spProductTMapper.updateById(spProductT);
	}

	@Override
	public SpProductT get(Long id) {
		// TODO Auto-generated method stub
		return spProductTMapper.selectById(id);
	}

	@Override
	public List<SpProductT> getList(EntityWrapper<SpProductT> wrapper) {
		// TODO Auto-generated method stub
		return spProductTMapper.selectList(wrapper);
	}

}
