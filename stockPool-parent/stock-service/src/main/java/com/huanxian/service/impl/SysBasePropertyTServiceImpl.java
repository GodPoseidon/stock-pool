package com.huanxian.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SysBasePropertyTMapper;
import com.huanxian.entity.SysBasePropertyT;
import com.huanxian.service.SysBasePropertyTService;

/**
 * <p>
 * 系统管理-系统参数配置表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-21
 */
@Service
public class SysBasePropertyTServiceImpl implements SysBasePropertyTService {

	@Autowired
	private SysBasePropertyTMapper sysBasePropertyTMapper;

	@Override
	@Caching(evict = { @CacheEvict(value = { "spring_cache:BaseProperty:PropGroupMap:k" }),
			@CacheEvict(value = { "spring_cache:BaseProperty:PropGroup:k" })})
	public Integer insertBaseProperty(SysBasePropertyT basePropertyT) {
		return sysBasePropertyTMapper.insert(basePropertyT);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = { "spring_cache:BaseProperty:PropGroupMap:k" }),
			@CacheEvict(value = { "spring_cache:BaseProperty:PropGroup:k" }) })
	public Integer updateBaseProperty(SysBasePropertyT basePropertyT) {
		return sysBasePropertyTMapper.updateById(basePropertyT);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = { "spring_cache:BaseProperty:PropGroupMap:k" }),
			@CacheEvict(value = { "spring_cache:BaseProperty:PropGroup:k" })})
	public Integer deleteBaseProperty(Long id) {
		return sysBasePropertyTMapper.deleteById(id);
	}

	@Override
	public String getValue(String group, String key) {
		return sysBasePropertyTMapper.getValue(group, key);
	}

	@Override
	@Caching(cacheable = { @Cacheable(value = {
			"spring_cache:BaseProperty:PropGroup:k" }, key = "#group") })
	public List<SysBasePropertyT> getBasePropertyVoByGroup(String group) {
		return sysBasePropertyTMapper.getBasePropertyVoByGroup(group);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = { "spring_cache:BaseProperty:PropGroupMap:k" }),
			@CacheEvict(value = { "spring_cache:BaseProperty:PropGroup:k" }) })
	public Integer updateValueAll(SysBasePropertyT propertyT) {
		return sysBasePropertyTMapper.updateById(propertyT);
	}

	@Override
	@Caching(cacheable = { @Cacheable(value = {
			"spring_cache:BaseProperty:PropGroupMap:k" }, key = "#group") })
	public Map<String, String> getGroupMap(String group) {
		List<SysBasePropertyT> list = sysBasePropertyTMapper.getBasePropertyVoByGroup(group);
		Map<String, String> resultMap = new HashMap<String, String>();
		for (SysBasePropertyT propertyT : list) {
			resultMap.put(propertyT.getPropCode(), propertyT.getPropValue());
		}
		return resultMap;
	}

	@Override
	public List<SysBasePropertyT> getAll() {
		return sysBasePropertyTMapper.getAll();
	}

	@Override
	public PageVo<SysBasePropertyT> getPage(EntityWrapper<SysBasePropertyT> wrapper, Integer pageSize,
			Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SysBasePropertyT> selectList = sysBasePropertyTMapper.selectList(wrapper);
		PageVo<SysBasePropertyT> vo = new PageVo<>();
		vo.setData(selectList);
		vo.setPageNumber(pageNum);
		vo.setPageSize(pageSize);
		vo.setRecordsTotal(Integer.valueOf(PageHelper.freeTotal() + ""));
		return vo;
	}

	@Override
	public SysBasePropertyT get(Long id) {
		return sysBasePropertyTMapper.selectById(id);
	}

}
