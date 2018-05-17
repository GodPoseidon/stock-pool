package com.huanxian.service.impl;

import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpAccountProTMapper;
import com.huanxian.entity.SpAccountProT;
import com.huanxian.entity.SpAdT;
import com.huanxian.service.SpAccountProTService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-产品表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-08
 */
@Service
public class SpAccountProTServiceImpl implements SpAccountProTService {

	@Autowired
	SpAccountProTMapper spAccountProTMapper;
	
	@Override
	public PageVo<SpAccountProT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpAccountProT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		List<SpAccountProT> spAccountProTList = spAccountProTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpAccountProT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spAccountProTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer insert(SpAccountProT spAccountProT) {
		// TODO Auto-generated method stub
		return spAccountProTMapper.insert(spAccountProT);
	}

	@Override
	public Integer updateById(SpAccountProT spAccountProT) {
		// TODO Auto-generated method stub
		return spAccountProTMapper.updateById(spAccountProT);
	}

	@Override
	public SpAccountProT get(Long id) {
		// TODO Auto-generated method stub
		return spAccountProTMapper.selectById(id);
	}

	@Override
	public void delInfoClassifyByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<SpAccountProT> getList(EntityWrapper<SpAccountProT> wrapper){
		List<SpAccountProT> spAccountProTList = spAccountProTMapper.selectList(wrapper);
		return spAccountProTList;
	}

	@Override
	public List<Map<String, Object>> queryPro(Long accountId) {
		// TODO Auto-generated method stub
		return spAccountProTMapper.queryPro(accountId);
	}

	@Override
	public PageVo<Map<String, Object>> queryByPro(Integer pageSize, Integer pageNumber, String search, String status) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("search", search);
		map.put("status", status);
		List<Map<String,Object>> byProList = spAccountProTMapper.queryBypro(map);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<Map<String,Object>> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(byProList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

}
