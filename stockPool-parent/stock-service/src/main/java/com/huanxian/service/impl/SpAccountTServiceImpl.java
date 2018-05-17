package com.huanxian.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpAccountTMapper;
import com.huanxian.entity.SpAccountT;
import com.huanxian.service.SpAccountTService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
@Service
public class SpAccountTServiceImpl implements SpAccountTService {

	@Autowired
	private SpAccountTMapper spAccountTMapper;

	@Override
	public Integer batchDel(Long[] id) {
		return spAccountTMapper.batchDel(id);
	}

	@Override
	public PageVo<SpAccountT> getPage(Integer pageSize, Integer pageNumber, EntityWrapper<SpAccountT> wrapper) {
		PageHelper.startPage(pageNumber, pageSize);
		List<SpAccountT> accountList = spAccountTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpAccountT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(accountList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer delete(Long id) {
		return spAccountTMapper.delete(id);
	}

	@Override
	public SpAccountT get(Long id) {
		return spAccountTMapper.selectById(id);
	}

	@Override
	public Integer update(SpAccountT accountT) {
		return spAccountTMapper.updateById(accountT);
	}

	@Override
	public Integer insert(SpAccountT accountT) {
		return spAccountTMapper.insert(accountT);
	}

	@Override
	public List<String> getRegistrationIdList(String device) {
		return spAccountTMapper.getRegistrationIdList(device);
	}

	@Override
	public List<String> getRegistrationIdListByPushStatus(String device) {
		return spAccountTMapper.getRegistrationIdListByPushStatus(device);
	}

	@Override
	public SpAccountT getByPhone(String phone, Integer state) {
		SpAccountT param = new SpAccountT();
		param.setPhone(phone);
		param.setStatus(state);
		SpAccountT data = spAccountTMapper.selectOne(param);
		return data;
	}
	
	@Override
	public List<SpAccountT> getWrapper(EntityWrapper<SpAccountT> wrapper) {
		// TODO Auto-generated method stub
		return spAccountTMapper.selectList(wrapper);
	}

	@Override
	public List<Map<Long, String>> getTeacherList() {
		return spAccountTMapper.getTeacherList();
	}

}
