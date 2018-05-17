package com.huanxian.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huanxian.core.em.BasePropertyPropGroupEnum;
import com.qcloud.cos.exception.AbstractCosException;
import com.qcloud.cos.sign.Credentials;
import com.qcloud.cos.sign.Sign;

import cn.hutool.core.util.StrUtil;

/**
 * 腾讯云对象存储服务签名service
 * 
 * @author zhuzhen
 *
 */
@Service
public class COSSignService {

	private final static Logger logger = LogManager.getLogger();

	@Autowired
	private SysBasePropertyTService basePropertyTService;

	/**
	 * 创建腾讯云证书
	 * 
	 * @return
	 */
	private Credentials createCredentials() {
		Map<String, String> property = new HashMap<String, String>();
		// 加载对象存储服务参数
		property = basePropertyTService.getGroupMap(BasePropertyPropGroupEnum.COS.getEname());
		if (StrUtil.isNotEmpty(property.get("APP_ID")) && StrUtil.isNotEmpty(property.get("SECRET_ID"))
				&& StrUtil.isNotEmpty(property.get("SECRET_KEY"))) {
			// 初始化cosClient
			Credentials cRed = new Credentials(Integer.valueOf(property.get("APP_ID")), property.get("SECRET_ID"),
					property.get("SECRET_KEY"));
			return cRed;
		}
		return null;
	}

	/**
	 * 获取多次签名
	 * 
	 * @param expired
	 *            签名过期时间
	 * @param bucketName
	 * @return
	 * @throws Exception
	 */
	public String appSign(long expired, String bucketName, String cosPath) throws Exception {
		try {
			Credentials cRed = this.createCredentials();
			return Sign.getPeriodEffectiveSign(bucketName, cosPath, cRed, expired);
		} catch (AbstractCosException e) {
			logger.error("获取多次签名失败。" + e.getStackTrace());
			return null;
		}
	}

	/**
	 * 获取单次签名
	 * 
	 * @param bucketName
	 * @param cosPath
	 * @return
	 */
	public String appSignOnce(String bucketName, String cosPath) {
		try {
			Credentials cRed = this.createCredentials();
			return Sign.getOneEffectiveSign(bucketName, cosPath, cRed);
		} catch (AbstractCosException e) {
			logger.error("获取单次签名失败。" + e.getStackTrace());
			return null;
		}
	}
}
