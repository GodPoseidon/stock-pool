package com.huanxian.admin.controller.cos;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.admin.controller.BaseController;
import com.huanxian.core.model.ResultModel;
import com.huanxian.service.COSSignService;

/**
 * 腾讯云COS对象存储服务、获取签名
 * @author zhuzhen
 *
 */
@RestController
@RequestMapping("/system/cos/sign")
public class CosSignController extends BaseController{

	private final static Logger logger = LogManager.getLogger();
	@Resource
	private COSSignService cosSignService;

	/**
	 * 生成多次有效签名函数（用于上传和下载资源，有效期内可重复对不同资源使用）
	 * 
	 * @param int
	 *            $expired 过期时间,unix时间戳
	 * @param string
	 *            $bucketName 文件所在bucket
	 * @return string 签名
	 */
	@PostMapping("/appSign")
	public ResultModel appSign(Long expired, String bucketName, String path) {
		try {
			String appSign = cosSignService.appSign(expired, bucketName, path);
			return successResult(appSign);
		} catch (Exception e) {
			logger.error("cos 加密失败");
			e.printStackTrace();
		}
		return errorResult("500", "获取签名失败!", null);
	}

	/**
	 * 生成单次有效签名函数（用于删除和更新指定fileId资源，使用一次即失效）
	 * 
	 * @param string
	 *            $fileId 文件路径，以 /{$appId}/{$bucketName} 开头
	 * @param string
	 *            $bucketName 文件所在bucket
	 * @return string 签名
	 */
	@PostMapping("/appSignOnce")
	public ResultModel appSignOnce(String bucketName, String path) {
		String appSignOnce = cosSignService.appSignOnce(bucketName, path);
		return successResult(appSignOnce);
	}

}
