package com.huanxian.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpVideoCollegeClassifyTMapper;
import com.huanxian.entity.SpVideoCollegeClassifyT;
import com.huanxian.service.SpVideoCollegeClassifyTService;

/**
 * <p>
 * 视频学员-视频分类表 服务实现类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Service
public class SpVideoCollegeClassifyTServiceImpl implements SpVideoCollegeClassifyTService {

	@Autowired

	private SpVideoCollegeClassifyTMapper spVideoCollegeClassifyTMapper;

	@Override
	public Integer insert(SpVideoCollegeClassifyT classifyT) {
		return spVideoCollegeClassifyTMapper.insert(classifyT);
	}

	@Override
	public Integer delete(Long id) {
		return spVideoCollegeClassifyTMapper.delete(id);
	}

	@Override
	public Integer update(SpVideoCollegeClassifyT classifyT) {
		return spVideoCollegeClassifyTMapper.updateById(classifyT);
	}

	@Override
	public SpVideoCollegeClassifyT get(Long id) {
		return spVideoCollegeClassifyTMapper.selectById(id);
	}

	@Override
	public PageVo<SpVideoCollegeClassifyT> getPage(Integer pageSize, Integer pageNumber,
			EntityWrapper<SpVideoCollegeClassifyT> wrapper) {
		PageHelper.startPage(pageNumber, pageSize);
		List<SpVideoCollegeClassifyT> classifyList = spVideoCollegeClassifyTMapper.selectList(wrapper);

		Integer totalCount = Integer.parseInt(PageHelper.freeTotal() + "");
		PageVo<SpVideoCollegeClassifyT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(classifyList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public List<Map<Long, String>> getVideoClassifyInfoList() {
		return spVideoCollegeClassifyTMapper.getVideoClassifyInfoList();
	}

	@Override
	public Integer batchDel(Long[] ids) {
		return spVideoCollegeClassifyTMapper.batchDel(ids);
	}

}
