package com.huanxian.service.impl;

import com.huanxian.entity.SpAdT;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpAdTMapper;
import com.huanxian.service.SpAdTService;

import cn.hutool.core.util.PageUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告表 服务实现类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
@Service
public class SpAdTServiceImpl implements SpAdTService {

	@Autowired
	private SpAdTMapper spAdTMapper;
	
	

	@Override
	public void enbAdtByIds(Map<String, Object> map) {
		// TODO Auto-generated method stub
		spAdTMapper.enbAdtByIds(map);
		
	}

	@Override
	public void delAdtByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		spAdTMapper.delAdtByIds(ids);
	}

	@Override
	public Integer insert(SpAdT entity) {
		// TODO Auto-generated method stub
		return spAdTMapper.insert(entity);
	}

	@Override
	public PageVo<SpAdT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpAdT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		wrapper.eq("ad_delete", 0);
		List<SpAdT> spAdTList = spAdTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpAdT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spAdTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer updateById(SpAdT spAdT) {
		// TODO Auto-generated method stub
		return spAdTMapper.updateById(spAdT);
	}

	@Override
	public SpAdT get(Long id) {
		// TODO Auto-generated method stub
		return spAdTMapper.selectById(id);
	}


}
