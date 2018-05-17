package com.huanxian.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpInfoTMapper;
import com.huanxian.entity.SpInfoT;
import com.huanxian.service.SpInfoTService;

/**
 * <p>
 * 资讯表 服务实现类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-21
 */
@Service
public class SpInfoTServiceImpl implements SpInfoTService {

	@Autowired
	private SpInfoTMapper spInfoTMapper;
	
	

	@Override
	public void delInfoByIds(List<Long> ids) {
		// TODO Auto-generated method stub
		spInfoTMapper.delInfoByIds(ids);
	}



	@Override
	public PageVo<SpInfoT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpInfoT> wrapper) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		wrapper.eq("inf_delete", 0);
		List<SpInfoT> spInfoTList = spInfoTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpInfoT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(spInfoTList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}



	@Override
	public Integer insert(SpInfoT spInfoT) {
		// TODO Auto-generated method stub
		return spInfoTMapper.insert(spInfoT);
	}



	@Override
	public Integer updateById(SpInfoT spInfoT) {
		// TODO Auto-generated method stub
		return spInfoTMapper.updateById(spInfoT);
	}



	@Override
	public SpInfoT get(Long id) {
		// TODO Auto-generated method stub
		return spInfoTMapper.selectById(id);
	}

	@Override
	public List<Map<String, Object>>  listBaseByType(Integer pageNumber, Integer pageSize, Long type){
		List<Map<String, Object>> list = null;
		try {
			SpInfoT spInfoT = new SpInfoT();
			spInfoT.setClassId(type);
			spInfoT.setInfDelete(0);
			spInfoT.setInfRelease(1);
			EntityWrapper<SpInfoT> wrapper = new EntityWrapper<>(spInfoT);
			wrapper.orderBy("create_time", false);
			wrapper.setSqlSelect("id", "classId", "className", "title", "outline", "cover", "create_time", "readsum", "url");
			PageHelper.startPage(pageNumber, pageSize);
			list = spInfoTMapper.selectMaps(wrapper);		
		}finally {
			PageHelper.remove();
		}
		return list;
	}
}
