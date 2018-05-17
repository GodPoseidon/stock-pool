package com.huanxian.dao;

import com.huanxian.entity.SpAccountProT;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户-产品表 Mapper 接口
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-08
 */
public interface SpAccountProTMapper extends BaseMapper<SpAccountProT> {
	
	public List<Map<String,Object>> queryPro(@Param("accountId") Long accountId);
	
	public List<Map<String,Object>> queryBypro(Map<String,Object> map);

}
