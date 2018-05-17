package com.huanxian.api.controller.Information;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.api.controller.BaseController;
import com.huanxian.api.vo.InformationVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpInfoT;
import com.huanxian.service.SpInfoTService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("information")
public class InformationController extends BaseController{

	@Autowired
	private SpInfoTService spInfoTService;
	
	@ApiOperation(value = "资讯列表")
	@RequestMapping("/import")
	public ResultModel InfoImport(String sign, String timeStamp, InformationVo vo) {
		String key = "83ffdcc4d72e4751ab93c37210606afc";
		Digester md5 = new Digester(DigestAlgorithm.MD5);
		String digestHex = md5.digestHex(key + timeStamp);
		ResultModel model = new ResultModel();
		if(!digestHex.equals(sign)) {
			model.setCode("100");
			model.setMessage("签名错误");
			return model;
		}
		SpInfoT spInfoT = new SpInfoT();
		BeanUtil.copyProperties(vo, spInfoT);
		spInfoT.setCreatTime(new Date());
		if(spInfoTService.insert(spInfoT) == 1) {
			return successResult(null);
		}else {
			return result("2", "插入失败！！", false, null);
		}
	}
}
