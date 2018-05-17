package com.huanxian.api.controller.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.api.controller.BaseController;
import com.huanxian.api.vo.InformationVo;
import com.huanxian.api.vo.ProdInfoVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpProdClassifyT;
import com.huanxian.entity.SpProdInfoT;
import com.huanxian.service.SpProdClassifyTService;
import com.huanxian.service.SpProdInfoTService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("精品资讯")
@RestController
@RequestMapping("/prodInfo")
public class ProdInfoController extends BaseController {

	@Autowired
	private SpProdInfoTService spProdInfoTService;

	@Autowired
	private SpProdClassifyTService classifyTService;

	@ApiOperation(value = "精品资讯列表")
	@ApiImplicitParams({ @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "Integer", required = true),
			@ApiImplicitParam(name = "classify_id", value = "产品子项目id", dataType = "Long", required = true) })
	@PostMapping("/prodInfoMain")
	public ResultModel prodInfoMain(Integer pageSize, Integer pageNum, Long classify_id) {
		ResultModel model = new ResultModel();
		EntityWrapper<SpProdInfoT> wrapper = new EntityWrapper<SpProdInfoT>();
		wrapper.eq("classify_id", classify_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prodInfoClassData", classifyTService.getPage(8, 0, new EntityWrapper<SpProdClassifyT>()));
		map.put("prodInfoData", spProdInfoTService.getPage(pageSize, pageNum, wrapper));

		model.setData(map);
		model.setSuccess(true);
		return model;
	}

	@ApiOperation(value = "提供给第三方的产品资讯导入接口")
	@PostMapping("/import")
	public ResultModel InfoImport(String sign, String timeStamp, ProdInfoVo vo) {
		String key = "83ffdcc4d72e4751ab93c37210606afc";
		Digester md5 = new Digester(DigestAlgorithm.MD5);
		String digestHex = md5.digestHex(key + timeStamp);
		ResultModel model = new ResultModel();
		if (!digestHex.equals(sign)) {
			model.setCode("100");
			model.setMessage("签名错误");
			return model;
		}
		SpProdInfoT spProdInfoT = new SpProdInfoT();
		BeanUtil.copyProperties(vo, spProdInfoT);
		if (spProdInfoTService.insert(spProdInfoT) == 1) {
			return successResult(null);
		} else {
			return result("2", "插入失败！！", false, null);
		}
	}
}
