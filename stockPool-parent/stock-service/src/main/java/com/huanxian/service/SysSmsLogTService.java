package com.huanxian.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.core.model.PageVo;
import com.huanxian.entity.SysSmsLogT;

/**
 * <p>
 * 短信日志表 服务类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-07
 */
public interface SysSmsLogTService{

	PageVo<SysSmsLogT> getPage(EntityWrapper<SysSmsLogT> wrapper,Integer pageSize,Integer pageNum);
}
