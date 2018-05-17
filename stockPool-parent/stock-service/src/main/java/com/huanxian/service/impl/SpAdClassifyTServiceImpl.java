package com.huanxian.service.impl;

import com.huanxian.entity.SpAdClassifyT;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpAdClassifyTMapper;
import com.huanxian.service.SpAdClassifyTService;

import cn.hutool.core.util.PageUtil;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 广告位表 服务实现类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
@Service
public class SpAdClassifyTServiceImpl extends ServiceImpl<SpAdClassifyTMapper, SpAdClassifyT> implements SpAdClassifyTService {

	@Autowired
	private SpAdClassifyTMapper spAdClassifyTMapper;
	

	@Override
	public SpAdClassifyT queryAdClassify(Long id) {
		// TODO Auto-generated method stub
		return spAdClassifyTMapper.selectById(id);
	}

	@Override
	public void updateSpAdCById(SpAdClassifyT spAdClassifyT) {
		// TODO Auto-generated method stub
	    spAdClassifyTMapper.updateById(spAdClassifyT);
	}

	@Override
	public void addAdClassify(SpAdClassifyT spAdClassifyT) {
		// TODO Auto-generated method stub
		spAdClassifyTMapper.insert(spAdClassifyT);
	}

	@Override
	public void deleteByIds(List<Long> list) {
		// TODO Auto-generated method stub
		spAdClassifyTMapper.deleteByIds(list);
	}

	@Override
	public PageVo<SpAdClassifyT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpAdClassifyT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		List<SpAdClassifyT> spAdClassifyTList = spAdClassifyTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpAdClassifyT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spAdClassifyTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public List<SpAdClassifyT> getList(EntityWrapper<SpAdClassifyT> wrapper){
		return spAdClassifyTMapper.selectList(wrapper);
	}

}
