package com.huanxian.admin.controller.system;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.em.BasePropertyPropGroupEnum;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SysBasePropertyT;
import com.huanxian.service.SysBasePropertyTService;

import cn.hutool.core.util.StrUtil;

/**
 * 系统参数页面
 * 
 * @author zhuzhen
 *
 */
@Controller
public class BasePropertyController extends BaseController {

	@Autowired
	private SysBasePropertyTService basePropertyTService;

	@RequestMapping("/system/property/list")
	public String list() {
		return "system/property/list";
	}

	@ResponseBody
	@RequestMapping(value = "/system/property/listData", method = RequestMethod.POST)
	public PageVo<SysBasePropertyT> index(String propGroup, Integer length, Integer start) {
		EntityWrapper<SysBasePropertyT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(propGroup)) {
			wrapper.like("prop_group", propGroup);
		}
		PageVo<SysBasePropertyT> page = basePropertyTService.getPage(wrapper, length, (start / length) + 1);
		return page;
	}

	@ResponseBody
	@PostMapping("/system/property/delItem")
	public ResultModel delete(Long id) {
		basePropertyTService.deleteBaseProperty(id);
		return successResult();
	}

	@RequestMapping("/system/property/edit")
	public String edit(Long id, Model model) {
		SysBasePropertyT sysBasePropertyT = basePropertyTService.get(id);
		model.addAttribute("property", sysBasePropertyT);
		return "system/property/edit";
	}

	@ResponseBody
	@RequestMapping(value = "/system/property/save", method = RequestMethod.POST)
	public ResultModel save(SysBasePropertyT propertyT) {
		ResultModel result = new ResultModel();
		propertyT.setModifyTime(new Date());
		propertyT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		propertyT.setPropType("TEXT");
		if (propertyT.getId() == null) {
			propertyT.setCreateTime(new Date());
			propertyT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			Integer res = basePropertyTService.insertBaseProperty(propertyT);
			if (res == null || res == 0) {
				result.setSuccess(false);
				result.setMessage("没有数据被保存");
			} else {
				result.setSuccess(true);
			}
			
		} else {
			Integer res = basePropertyTService.updateValueAll(propertyT);
			if (res == null || res == 0) {
				result.setMessage("没有数据被保存");
			} else {
				result.setSuccess(true);
			}
		}

		return result;
	}

	/**
	 * 获取腾讯云对象存储服务(COS)的上传目录
	 * 
	 * @param flag
	 *            image:图片目录；video：视频目录
	 * @return
	 */
	@ResponseBody	
	@PostMapping("/system/cos/findFolder")
	public ResultModel findFolder(String flag) {
		Map<String, String> property = new HashMap<String, String>();
		property = basePropertyTService.getGroupMap(BasePropertyPropGroupEnum.COS.getEname());
		String value = null;
		if (flag.equals("IMAGE")) {
			value = property.get("IMAGE_FOLDER");
		} else if (flag.equals("VIDEO")) {
			value = property.get("VIDEO_FOLDER");
		} else {
			value = property.get("OTHER_FOLDER");
		}
		return successResult(value);
	}
}
