package com.huanxian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huanxian.dao.PlThirdpartyAccountTMapper;
import com.huanxian.entity.PlThirdpartyAccountT;
import com.huanxian.service.PlThirdpartyAccountTService;

/**
 * <p>
 * 第三方客户信息表 服务实现类
 * </p>
 *
 * @author zhuzhen
 * @since 2018-05-04
 */
@Service
public class PlThirdpartyAccountTServiceImpl  implements PlThirdpartyAccountTService {

	@Autowired
	private PlThirdpartyAccountTMapper thirdpartyAccountTMapper;
	
	public Boolean insert(PlThirdpartyAccountT accountT) {
		
		return thirdpartyAccountTMapper.insert(accountT) > 0 ;
	}
}
