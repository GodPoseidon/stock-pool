package com.huanxian.admin.controller.prodInfoT;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpAccountProT;
import com.huanxian.entity.SpProdClassifyT;
import com.huanxian.entity.SpProdInfoT;
import com.huanxian.entity.SpProductT;
import com.huanxian.entity.SysMessageT;
import com.huanxian.service.SpAccountProTService;
import com.huanxian.service.SpProdClassifyTService;
import com.huanxian.service.SpProdInfoTService;
import com.huanxian.service.SpProductTService;
import com.huanxian.service.SysMessageTService;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 * <p>
 * 产品-子项目内容表 前端控制器
 * </p>
 *
 * @author wuzeng
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/spProdInfoT")
public class SpProdInfoTController extends BaseController{

	@Autowired
	private SpProdInfoTService infoTService;

	
	@Autowired
	private SpProductTService spProductTService;
	
	@Autowired
	private SpProdClassifyTService spProdClassifyTService;
	
	@Autowired
	private SpAccountProTService spAccountProTService;
	
	@Autowired
	private SysMessageTService sysMessageTService;
	
	@GetMapping("/page")
	public String list(Model model) {
		EntityWrapper<SpProdClassifyT> wrapper = new EntityWrapper<>();
		wrapper.ne("status", 3);
		wrapper.groupBy("name");
		model.addAttribute("classifyList", spProdClassifyTService.getList(wrapper));
		return "information/prodInfo/infolist";
	}
	
	
	@ResponseBody
	@PostMapping("/list")
	public PageVo<SpProdInfoT> queryProdInfo(Integer start,Integer length,String title,Integer status,String prodName,String classifyName){
		EntityWrapper<SpProdInfoT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status==null) {
			wrapper.ne("status", 3);
		}else{
			wrapper.eq("status", status);
		}
		if (StrUtil.isNotBlank(prodName)) {
			wrapper.like("prod_name", prodName);
		}
		if (StrUtil.isNotBlank(classifyName)) {
			wrapper.like("classify_name", classifyName);
		}
		PageVo<SpProdInfoT> page = infoTService.getPage(length, (start / length) + 1, wrapper);
		return page;
	}
	
	
	@RequestMapping("/view")
	public String view(Long id, Model model) {
		SpProdInfoT spProdInfoT = infoTService.get(id);
		model.addAttribute("spProdInfoT", spProdInfoT);
		return "information/prodInfo/infoview";
	}
	
	@GetMapping("/edit")
	public String listInfoById(Long id, Model model) {
		SpProdInfoT spProdInfoT = infoTService.get(id);
		model.addAttribute("spProdInfoT", spProdInfoT);
		EntityWrapper<SpProductT> wrapper = new EntityWrapper<>();
		wrapper.ne("status", 3);
		List<SpProductT> prodList = spProductTService.getList(wrapper);
		model.addAttribute("prodList", prodList);
		EntityWrapper<SpProdClassifyT> wrapper1 = new EntityWrapper<>();
		wrapper1.ne("status", 3);
		List<SpProdClassifyT> prodClassList = spProdClassifyTService.getList(wrapper1);
		model.addAttribute("prodClassList", prodClassList);
		return "information/prodInfo/infoedit";
	}
	
	@ResponseBody
	@PostMapping("/save")
	public ResultModel updateInfo(SpProdInfoT spProdInfoT) {
		ResultModel model = new ResultModel();
		spProdInfoT.setModifyTime(new Date());
		spProdInfoT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (spProdInfoT.getId() == null) {
			infoTService.insert(spProdInfoT);
		} else {
			infoTService.updateById(spProdInfoT);
		}
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
	
	@ResponseBody
	@RequestMapping("/release")
	public ResultModel release(Long id) {
		ResultModel model = new ResultModel();
		SpProdInfoT entity = infoTService.get(id);
		entity.setStatus(1);
		Integer result = infoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@RequestMapping("/unRelease")
	public ResultModel unRelease(Long id) {
		ResultModel model = new ResultModel();
		SpProdInfoT entity = new SpProdInfoT();
		entity.setId(id);
		entity.setStatus(2);
		Integer result = infoTService.updateById(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		List<Long> asList = Arrays.asList(id);
		infoTService.batchDel(asList);
		return successResult();
	}
	
	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records){
		ResultModel model = new ResultModel();
		List<Long> ids = Arrays.asList(table_records);
		infoTService.batchDel(ids);
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
	
	@ResponseBody
	@PostMapping("/sendMs")
	public ResultModel sendMs(Long id){
		ResultModel model = new ResultModel();
		EntityWrapper<SpAccountProT> wrapper = new EntityWrapper<SpAccountProT>();
		SpProdInfoT entity = infoTService.get(id);
		wrapper.eq("prodId", entity.getProdId());
		wrapper.gt("endTime", new Date());
		List<SpAccountProT> list = spAccountProTService.getList(wrapper);
		for(SpAccountProT spAccountProT : list){
			SysMessageT sysMessageT = new SysMessageT();
			sysMessageT.setAccountId(spAccountProT.getAccountId());
			sysMessageT.setTitle(entity.getTitle());
			sysMessageT.setContent(entity.getContent());
			sysMessageT.setMsgType("PROD");
			sysMessageT.setLink(entity.getId().toString());
			sysMessageT.setMsread(0);
			sysMessageT.setCreateTime(new Date());
			sysMessageT.setCreateUser(ShiroUtil.getCurrentUser().getAccount());
			sysMessageTService.insert(sysMessageT);
		}
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
}

