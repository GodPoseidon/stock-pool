package com.huanxian.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysPushLogT;

/**
 * <p>
 * 推送日志表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
public interface SysPushLogTService {

	PageVo<SysPushLogT> getPage(EntityWrapper<SysPushLogT> wrapper, Integer pageSize, Integer pageNum);
	
	Integer insert(SysPushLogT logT);
	
	SysPushLogT get(Long id);
	
	Integer update(SysPushLogT logT);

}
