package com.huanxian.service.impl;

import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpProdInfoTMapper;
import com.huanxian.entity.SpProdInfoT;
import com.huanxian.service.SpProdInfoTService;

import cn.hutool.core.util.PageUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品-子项目内容表 服务实现类
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
@Service
public class SpProdInfoTServiceImpl implements SpProdInfoTService {

	
	@Autowired
	private SpProdInfoTMapper infoTMapper;

	@Override
	public Integer batchDel(List<Long> ids) {
		// TODO Auto-generated method stub
		return infoTMapper.batchDel(ids);
	}

	@Override
	public PageVo<SpProdInfoT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpProdInfoT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		List<SpProdInfoT> spProdInfoTList = infoTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpProdInfoT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spProdInfoTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer insert(SpProdInfoT spProdInfoT) {
		// TODO Auto-generated method stub
		return infoTMapper.insert(spProdInfoT);
	}

	@Override
	public Integer updateById(SpProdInfoT spProdInfoT) {
		// TODO Auto-generated method stub
		return infoTMapper.updateById(spProdInfoT);
	}

	@Override
	public SpProdInfoT get(Long id) {
		// TODO Auto-generated method stub
		return infoTMapper.selectById(id);
	}
	
	@Override
	public List<SpProdInfoT> queryList(EntityWrapper<SpProdInfoT> wrapper){
		wrapper.ne("status", 3);
		return infoTMapper.selectList(wrapper);
	}

}
