package com.huanxian.admin.controller.product;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.model.AccountProVo;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpAccountProT;
import com.huanxian.entity.SpAccountT;
import com.huanxian.entity.SpProdClassifyT;
import com.huanxian.entity.SpProductT;
import com.huanxian.service.SpAccountProTService;
import com.huanxian.service.SpAccountTService;
import com.huanxian.service.SpProdClassifyTService;
import com.huanxian.service.SpProductTService;

import cn.hutool.core.util.StrUtil;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{

	@Autowired
	private SpProductTService productTService;
	
	@Autowired
	private SpProdClassifyTService spProdClassifyTService;
	
	@Autowired
	private SpAccountProTService spAccountProTService;
	
	@Autowired
	private SpAccountTService spAccountTService;
	
	@GetMapping("/page")
	public String list() {
		return "product/list";
	}
	
	
	/**
	 * 产品列表
	 * @param pageNumber
	 * @param pageSize
	 * @param title
	 * @param status
	 * @return
	 */
	@ResponseBody
	@PostMapping("/list")
	public PageVo<SpProductT> listProductT(Integer start,Integer length,String title,Integer status){
		EntityWrapper<SpProductT> wrapper = new EntityWrapper<SpProductT>();
		
		if (StrUtil.isNotBlank(title)) {
			wrapper.like("title", title);
		}
		if (status==null) {
			wrapper.ne("status", 3);
		}else{
			wrapper.eq("status", status);
		}
		PageVo<SpProductT> page = productTService.getPage(length, (start / length) + 1, wrapper);
		return page;
	}
	
	
	@GetMapping("/classPage")
	public String classPage(Long prodId, Model model) {
		model.addAttribute("prodId", prodId);
		return "product/classlist2";
	}
		
	
	/**
	 * 产品分类
	 * @param start
	 * @param length
	 * @param prodId
	 * @return
	 */
	@ResponseBody
	@PostMapping("/classList")
	public PageVo<SpProdClassifyT> classList(Integer start,Integer length,Long prodId){
		EntityWrapper<SpProdClassifyT> wrapper = new EntityWrapper<SpProdClassifyT>();
		wrapper.ne("status", 3);
		wrapper.eq("prodId", prodId);
		PageVo<SpProdClassifyT> page = spProdClassifyTService.getPage(length, (start / length) + 1,wrapper);
		return page;
	}
	
	
	@GetMapping("/edit")
	public String edit(Long id,Model model){
		if (id != null) {
			SpProductT sProductT = productTService.get(id);
			model.addAttribute("sProductT", sProductT);
		}
		return "product/edit";
	}
	
	/**
	 * 产品更新
	 * @param productT
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpProductT productT){
		
		if(productT.getId() == null){
			productT.setModifyTime(new Date());
			productT.setModifyUser(ShiroUtil.getCurrentUser().getName());
			productTService.insert(productT);
		}else{
			productTService.updateById(productT);
		}
		return successResult();
	}
	
	
	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpProductT spProductT = new SpProductT();
		spProductT.setId(id);
		spProductT.setStatus(1);
		Integer result = productTService.updateById(spProductT);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpProductT spProductT = new SpProductT();
		spProductT.setId(id);
		spProductT.setStatus(2);
		Integer result = productTService.updateById(spProductT);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}
	
	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delItem(Long id) {
		List<Long> asList = Arrays.asList(id);
		productTService.batchDel(asList);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		ResultModel model = new ResultModel();
		List<Long> ids = Arrays.asList(table_records);
		productTService.batchDel(ids);
		model.setSuccess(true);
		model.setMessage("成功");
		return model;
	}
	
	
	@GetMapping("/byprolist")
	public String byprolist() {
		return "product/byProlist";
	}
	
	@ResponseBody
	@PostMapping("/queryByPro")
	public PageVo<Map<String,Object>> queryByPro(Integer start,Integer length,String name,String status){
		PageVo<Map<String,Object>> page = spAccountProTService.queryByPro(length, (start / length) + 1, name,status);
		return page;
	}
	
	@GetMapping("/byProedit")
	public String byProedit(Long id,Model model){
		if (id != null) {
			SpAccountProT spAccountProT = spAccountProTService.get(id);
			AccountProVo accountProVo = new AccountProVo();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			accountProVo.setId(spAccountProT.getId());
			accountProVo.setAccountId(spAccountProT.getAccountId());
			accountProVo.setProductId(spAccountProT.getProductId());
			accountProVo.setStartTime(sdf.format(spAccountProT.getStartTime()));
			accountProVo.setEndTime(sdf.format(spAccountProT.getEndTime()));
			model.addAttribute("spAccountProT", accountProVo);
		}
		EntityWrapper<SpProductT> wrapper = new EntityWrapper<>();
		wrapper.ne("status", 3);
		List<SpProductT> proList = productTService.getList(wrapper);
		model.addAttribute("proList", proList);
		EntityWrapper<SpAccountT> wrapper1 = new EntityWrapper<>();
		wrapper1.eq("member", 1);
		wrapper1.ne("status", 3);
		List<SpAccountT> acList = spAccountTService.getWrapper(wrapper1);
		model.addAttribute("acList", acList);
		return "product/byProedit";
	}
	
	@ResponseBody
	@PostMapping("/byProSave")
	public ResultModel byProSave(AccountProVo accountProVo) throws Exception{
		SpAccountProT spAccountProT = new SpAccountProT();
		spAccountProT.setId(accountProVo.getId());
		spAccountProT.setAccountId(accountProVo.getAccountId());
		spAccountProT.setProductId(accountProVo.getProductId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		spAccountProT.setStartTime(sdf.parse(accountProVo.getStartTime()));
		spAccountProT.setEndTime(sdf.parse(accountProVo.getEndTime()));
		if(spAccountProT.getId() == null){
			spAccountProTService.insert(spAccountProT);
		}else{
			spAccountProTService.updateById(spAccountProT);
		}
		return successResult();
	}
	
	
	@ResponseBody
	@PostMapping("/byProenable")
	public ResultModel byProenable(Long id) {
		ResultModel model = new ResultModel();
		SpAccountProT spAccountProT = new SpAccountProT();
		spAccountProT.setId(id);
		spAccountProT.setStatus(0);
		Integer result = spAccountProTService.updateById(spAccountProT);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/byProunEnable")
	public ResultModel byProunEnable(Long id) {
		ResultModel model = new ResultModel();
		SpAccountProT spAccountProT = new SpAccountProT();
		spAccountProT.setId(id);
		spAccountProT.setStatus(1);
		Integer result = spAccountProTService.updateById(spAccountProT);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}
}
