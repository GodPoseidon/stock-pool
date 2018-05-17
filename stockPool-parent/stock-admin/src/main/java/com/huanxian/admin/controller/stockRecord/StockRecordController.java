package com.huanxian.admin.controller.stockRecord;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SpStockRecordT;
import com.huanxian.service.SpStockRecordTService;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * 牛股战绩 前端控制器
 * </p>
 *
 * @author zhuzhen
 * @since 2018-04-23
 */
@Controller
@RequestMapping("/stockRecord")
public class StockRecordController extends BaseController {

	@Autowired
	private SpStockRecordTService recordTService;

	@RequestMapping("/list")
	public String list() {
		return "information/stockRecord/list";
	}

	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpStockRecordT> listData(String name, Integer status, Integer length, Integer start) {
		EntityWrapper<SpStockRecordT> wrapper = new EntityWrapper<SpStockRecordT>();
		if (StrUtil.isNotBlank(name)) {
			wrapper.like("name", name);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.orderBy("modify_time",false);
		PageVo<SpStockRecordT> page = recordTService.getPage(wrapper, length, start / length + 1);
		return page;
	}

	@GetMapping("/edit")
	public String get(Long id,Model model) {
		SpStockRecordT StockRecord = recordTService.get(id);
		model.addAttribute("stock", StockRecord);
		return "information/stockRecord/edit";
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		ResultModel model = new ResultModel();
		SpStockRecordT recordT = new SpStockRecordT();
		recordT.setId(id);
		recordT.setStatus(3);
		Integer delete = recordTService.update(recordT);
		if (delete > 0) {
			model.setSuccess(true);
			model.setCode("0");
		} else {
			model.setSuccess(false);
			model.setCode("404");
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SpStockRecordT recordT) {
		ResultModel model = new ResultModel();
		recordT.setModifyTime(new Date());
		recordT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (recordT.getId() == null) {
			Integer insert = recordTService.insert(recordT);
			if (insert > 0) {
				model.setCode("0");
				model.setSuccess(true);
			} else {
				model.setCode("404");
				model.setMessage("新增失败！");
				model.setSuccess(false);
			}
		} else {
			Integer update = recordTService.update(recordT);
			if (update > 0) {
				model.setCode("0");
				model.setSuccess(true);
			} else {
				model.setCode("404");
				model.setMessage("新增失败！");
				model.setSuccess(false);
			}
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		recordTService.batchDel(table_records);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		SpStockRecordT recordT = new SpStockRecordT();
		recordT.setId(id);
		recordT.setStatus(1);
		recordT.setModifyTime(new Date());
		recordT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		recordTService.update(recordT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SpStockRecordT recordT = new SpStockRecordT();
		recordT.setId(id);
		recordT.setStatus(2);
		recordT.setModifyTime(new Date());
		recordT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		recordTService.update(recordT);
		return successResult();
	}

}
