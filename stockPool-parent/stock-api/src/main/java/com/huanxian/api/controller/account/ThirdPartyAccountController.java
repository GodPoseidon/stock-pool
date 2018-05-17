package com.huanxian.api.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huanxian.api.controller.BaseController;
import com.huanxian.api.vo.ThirdPartyAccountVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.PlThirdpartyAccountT;
import com.huanxian.service.PlThirdpartyAccountTService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping("/thirdPartyAccount")
public class ThirdPartyAccountController extends BaseController{

	@Autowired
	private PlThirdpartyAccountTService plThirdpartyAccountTService;
	
	@ApiOperation(value = "第三方账户插入")
	@PostMapping("/insert")
	public ResultModel insert(ThirdPartyAccountVo thirdPartyAccountVo, String sign, String timeStamp) {
		String key = "83ffdcc4d72e4751ab93c37210606afc";
		Digester md5 = new Digester(DigestAlgorithm.MD5);
		String digestHex = md5.digestHex(key + timeStamp);
		ResultModel model = new ResultModel();
		if(!digestHex.equals(sign)) {
			model.setCode("100");
			model.setMessage("签名错误");
			return model;
		}
		PlThirdpartyAccountT accountT = new PlThirdpartyAccountT();
		BeanUtil.copyProperties(thirdPartyAccountVo, accountT);	
		plThirdpartyAccountTService.insert(accountT);		
		return successResult(null);
	}
	
}
