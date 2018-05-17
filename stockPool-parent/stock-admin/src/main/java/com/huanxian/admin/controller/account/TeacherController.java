package com.huanxian.admin.controller.account;

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
import com.huanxian.core.util.SecurityUtil;
import com.huanxian.entity.SpAccountT;
import com.huanxian.service.SpAccountTService;

import cn.hutool.core.util.StrUtil;

/**
 * 讲师管理
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController {
	
	@Autowired
	private SpAccountTService accountTService;

	@GetMapping("/list")
	public String list() {
		return "teacher/list";
	}
	
	/**
	 * 获取账号分页列表
	 * 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/listData")
	public PageVo<SpAccountT> getDataList(Long id, String nick, String phone, Integer status,
			Integer start, Integer length) {
		EntityWrapper<SpAccountT> wrapper = new EntityWrapper<>();
		if (id != null) {
			wrapper.eq("id", id);
		}
		if (StrUtil.isNotBlank(nick)) {
			wrapper.like("nick", nick);
		}
		if (StrUtil.isNotBlank(phone)) {
			wrapper.like("phone", phone);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		wrapper.eq("teacher", 1);
		wrapper.orderBy("create_time",false);
		PageVo<SpAccountT> page = accountTService.getPage(length, start / length + 1, wrapper);
		return page;
	}

	@GetMapping("/view")
	public String view(Long id,Model model) {
		SpAccountT account = accountTService.get(id);
		model.addAttribute("account", account);
		return "teacher/view";
	}
	
	@GetMapping("/add")
	public String add() {
		return "teacher/add";
	}
	
	@GetMapping("/edit")
	public String getAccountById(Long id,Model model) {
		SpAccountT account = accountTService.get(id);
		model.addAttribute("account", account);
		return "teacher/edit";
	}

	/**
	 * 保存
	 * 
	 * @param accountT
	 * @return
	 */
	@ResponseBody
	@PostMapping("/save")
	public ResultModel add(SpAccountT accountT) {
		ResultModel model = new ResultModel();
		accountT.setMember(0);
		accountT.setTeacher(1);
		accountT.setModifyTime(new Date());
		accountT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (accountT.getId() == null) {
			SpAccountT byPhone = accountTService.getByPhone(accountT.getPhone(),null);
			if (byPhone != null) {
				return errorResult("1005", "改手机号已存在！", null);
			}
			accountT.setCreateTime(new Date());
			accountT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			accountT.setPassword(SecurityUtil.encryptPassword(accountT.getPassword()));
			Integer insert = accountTService.insert(accountT);
			if (insert > 0) {
				model.setCode("0");
				model.setSuccess(true);
			} else {
				model.setSuccess(false);
				model.setMessage("保存失败！");
			}
		} else {
			Integer update = accountTService.update(accountT);
			if (update > 0) {
				model.setCode("0");
				model.setSuccess(true);
			} else {
				model.setSuccess(false);
				model.setMessage("保存失败！");
			}
		}
		return model;
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		ResultModel model = new ResultModel();
		Integer result = accountTService.delete(id);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/batchDel")
	public ResultModel batchDel(Long[] table_records) {
		ResultModel model = new ResultModel();
		Integer deleteById = accountTService.batchDel(table_records);
		model.setSuccess(deleteById > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enable(Long id) {
		ResultModel model = new ResultModel();
		SpAccountT entity = new SpAccountT();
		entity.setId(id);
		entity.setStatus(1);
		Integer result = accountTService.update(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		ResultModel model = new ResultModel();
		SpAccountT entity = new SpAccountT();
		entity.setId(id);
		entity.setStatus(2);
		Integer result = accountTService.update(entity);
		model.setSuccess(result > 0);
		model.setCode("0");
		return model;
	}

	
}
