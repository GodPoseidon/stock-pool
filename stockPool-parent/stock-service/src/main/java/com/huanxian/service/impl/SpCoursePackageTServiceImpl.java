package com.huanxian.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpCoursePackageTMapper;
import com.huanxian.entity.SpCoursePackageT;
import com.huanxian.service.SpCoursePackageTService;

/**
 * <p>
 * 视频学院-名师战法课程包 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@Service
public class SpCoursePackageTServiceImpl implements SpCoursePackageTService {

	@Autowired
	private SpCoursePackageTMapper spCoursePackageTMapper;
	
	@Override
	public Integer delete(Long id) {
		return spCoursePackageTMapper.delete(id);
	}

	@Override
	public Integer insert(SpCoursePackageT coursePackageT) {
		return spCoursePackageTMapper.insert(coursePackageT);
	}

	@Override
	public Integer update(SpCoursePackageT coursePackageT) {
		return spCoursePackageTMapper.updateById(coursePackageT);
	}

	@Override
	public SpCoursePackageT get(Long id) {
		return spCoursePackageTMapper.selectById(id);
	}

	@Override
	public PageVo<SpCoursePackageT> getPage(EntityWrapper<SpCoursePackageT> wrapper, Integer pageSize,
			Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SpCoursePackageT> packageList = spCoursePackageTMapper.selectList(wrapper);
		PageVo<SpCoursePackageT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNum);
		pageVo.setData(packageList);
		pageVo.setPageSize(pageSize);
		Integer totle = Integer.valueOf(PageHelper.freeTotal()+"");
		pageVo.setRecordsTotal(totle);
		return pageVo;
	}

	@Override
	public List<Map<Long, String>> getPackageInfoList() {
		return spCoursePackageTMapper.getPackageInfoList();
	}

}
