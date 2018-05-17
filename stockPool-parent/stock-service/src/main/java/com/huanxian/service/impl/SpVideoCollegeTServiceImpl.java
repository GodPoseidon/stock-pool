package com.huanxian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.huanxian.core.model.PageVo;
import com.huanxian.dao.SpVideoCollegeTMapper;
import com.huanxian.entity.SpVideoCollegeT;
import com.huanxian.service.SpVideoCollegeTService;

/**
 * <p>
 * 视频学院-视频表 服务实现类
 * </p>
 *
 * @author 张晓宇
 * @since 2018-04-23
 */
@Service
public class SpVideoCollegeTServiceImpl implements SpVideoCollegeTService {

	@Autowired
	private SpVideoCollegeTMapper spVideoCollegeTMapper;
	
	@Override
	public Integer insert(SpVideoCollegeT collegeT) {
		return spVideoCollegeTMapper.insert(collegeT);
	}

	@Override
	public Integer delete(Long id) {
		return spVideoCollegeTMapper.delete(id);
	}

	@Override
	public Integer update(SpVideoCollegeT collegeT) {
		return spVideoCollegeTMapper.updateById(collegeT);
	}

	@Override
	public SpVideoCollegeT get(Long id) {
		return spVideoCollegeTMapper.selectById(id);
	}

	@Override
	public PageVo<SpVideoCollegeT> getPage(Integer pageSize, Integer pageNumber,
			EntityWrapper<SpVideoCollegeT> wrapper) {
		PageHelper.startPage(pageNumber, pageSize);
		List<SpVideoCollegeT> videoList = spVideoCollegeTMapper.selectList(wrapper);
		Integer totalCount = Integer.parseInt(PageHelper.freeTotal()+"");
		PageVo<SpVideoCollegeT> pageVo = new PageVo<>();
		pageVo.setPageNumber(pageNumber);
		pageVo.setData(videoList);
		pageVo.setPageSize(pageSize);
		pageVo.setRecordsTotal(totalCount);
		return pageVo;
	}

	@Override
	public Integer batchDel(Long[] ids) {
		return spVideoCollegeTMapper.batchDel(ids);
	}

}
