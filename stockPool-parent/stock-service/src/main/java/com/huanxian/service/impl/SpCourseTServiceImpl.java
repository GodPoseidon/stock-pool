package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpCourseTMapper;
import com.huanxian.entity.SpCourseT;
import com.huanxian.service.SpCourseTService;

/**
 * <p>
 * 视频学院-名师战法-课程 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
@Service
public class SpCourseTServiceImpl implements SpCourseTService {

	@Autowired
	private SpCourseTMapper spCourseTMapper;

	@Override
	public Integer delete(Long id) {
		SpCourseT courseT = new SpCourseT();
		courseT.setId(id);
		courseT.setStatus(3);
		return spCourseTMapper.updateById(courseT);
	}

	@Override
	public Integer insert(SpCourseT courseT) {
		return spCourseTMapper.insert(courseT);
	}

	@Override
	public Integer update(SpCourseT courseT) {
		return spCourseTMapper.updateById(courseT);
	}

	@Override
	public SpCourseT get(Long id) {
		return spCourseTMapper.selectById(id);
	}

	@Override
	public PageVo<SpCourseT> getPage(EntityWrapper<SpCourseT> wrapper, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		List<SpCourseT> courseList = spCourseTMapper.selectList(wrapper);
		PageVo<SpCourseT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNum);
		pageVo.setData(courseList);
		pageVo.setPageSize(pageSize);
		Integer total = Integer.valueOf(PageHelper.freeTotal()+"");
		pageVo.setRecordsTotal(total);
		return pageVo;
	}

	@Override
	public Integer batchDel(Long[] ids) {
		return spCourseTMapper.batchDel(ids);
	}

}
