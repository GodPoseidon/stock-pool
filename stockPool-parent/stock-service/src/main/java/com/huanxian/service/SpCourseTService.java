package com.huanxian.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SpCourseT;

/**
 * <p>
 * 视频学院-名师战法-课程 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-24
 */
public interface SpCourseTService {

	Integer delete(Long id);
	
	Integer batchDel(Long[] ids);

	Integer insert(SpCourseT courseT);

	Integer update(SpCourseT courseT);

	SpCourseT get(Long id);

	PageVo<SpCourseT> getPage(EntityWrapper<SpCourseT> wrapper, Integer pageSize, Integer pageNum);
}
