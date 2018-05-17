package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpInfoClassifyTMapper;
import com.huanxian.entity.SpInfoClassifyT;
import com.huanxian.service.SpInfoClassifyTService;

/**
 * <p>
 * 资讯分类表 服务实现类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
@Service
public class SpInfoClassifyTServiceImpl implements SpInfoClassifyTService {

	@Autowired
	private SpInfoClassifyTMapper spInfoClassifyTMapper;
	

	@Override
	public void delInfoClassifyByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		spInfoClassifyTMapper.delInfoClassifyByIds(ids);
	}


	@Override
	public PageVo<SpInfoClassifyT> getPage(Integer pageSize, Integer pageNumber,
			EntityWrapper<SpInfoClassifyT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		wrapper.eq("infc_delete", 0);
		List<SpInfoClassifyT> spInfoClassifyTList = spInfoClassifyTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpInfoClassifyT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spInfoClassifyTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}


	@Override
	public SpInfoClassifyT get(Long id) {
		// TODO Auto-generated method stub
		return spInfoClassifyTMapper.selectById(id);
	}


	@Override
	public Integer insert(SpInfoClassifyT spInfoClassifyT) {
		// TODO Auto-generated method stub
		return spInfoClassifyTMapper.insert(spInfoClassifyT);
	}


	@Override
	public Integer updateById(SpInfoClassifyT spInfoClassifyT) {
		// TODO Auto-generated method stub
		return spInfoClassifyTMapper.updateById(spInfoClassifyT);
	}


	@Override
	public List<SpInfoClassifyT> getClassifyList() {
		EntityWrapper<SpInfoClassifyT> wrapper = new EntityWrapper<>();
		wrapper.eq("infc_enable", 0);
		wrapper.eq("infc_delete", 0);
		return spInfoClassifyTMapper.selectList(wrapper);
	}


}
