package com.huanxian.admin.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.MenuData;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SysResourceT;
import com.huanxian.entity.SysRoleResourceT;
import com.huanxian.service.SysResourcesTService;
import com.huanxian.service.SysRoleResourceTService;

import cn.hutool.core.util.StrUtil;

/**
 * 菜单资源
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/system/menu")
public class ResourcesController extends BaseController {

	@Autowired
	private SysResourcesTService sysResourcesTService;

	@Autowired
	private SysRoleResourceTService sysRoleResourceTService;

	@GetMapping("/page")
	public String list() {
		return "system/menu/list";
	}

	@ResponseBody
	@PostMapping("/list")
	public PageVo<SysResourceT> list(String name, Integer length, Integer start) {
		EntityWrapper<SysResourceT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(name)) {
			wrapper.like("cn_name", name);
		}
		wrapper.ne("status", 3);
		PageVo<SysResourceT> page = sysResourcesTService.getPage(wrapper, length, (start / length) + 1);
		return page;
	}

	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		if (id != null) {
			SysResourceT sysResourceT = sysResourcesTService.get(id);
			model.addAttribute("resource", sysResourceT);
		}
		return "system/menu/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SysResourceT resourceT) {
		String url = resourceT.getUrl();
		String enName = url.replaceAll("/", "->");
		resourceT.setEnName(enName);
		if (resourceT.getId() == null) {
			resourceT.setCreateTime(new Date());
			resourceT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			resourceT.setModifyTime(new Date());
			sysResourcesTService.add(resourceT);
		} else {
			resourceT.setModifyTime(new Date());
			resourceT.setModifyUser(ShiroUtil.getCurrentUser().getName());
			sysResourcesTService.update(resourceT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		sysResourcesTService.delete(id);
		return successResult();
	}

	@ResponseBody
	@RequestMapping("/getMenuData")
	public List<MenuData> getMenuData(Long roleId) {
		Map<Long, String> map = null;
		List<SysResourceT> resourceList = sysResourcesTService.getResourceList();
		if (roleId != null && roleId > 0) {
			map = new HashMap<Long, String>();
			List<SysRoleResourceT> roleResourceList = sysRoleResourceTService.getRoleResourceByRoleId(roleId);
			for (SysRoleResourceT sysRoleResourceT : roleResourceList) {
				map.put(sysRoleResourceT.getResourceId(), "1");
			}
		}
		List<MenuData> result = new ArrayList<MenuData>();
		for (SysResourceT v : resourceList) {
			if (roleId != null && StrUtil.isNotBlank(map.get(v.getId()))) {
				result.add(new MenuData(v.getId(), v.getCnName(), v.getParentId(), true, true));
			} else {
				result.add(new MenuData(v.getId(), v.getCnName(), v.getParentId(), true, false));
			}
		}
		return result;
	}
}
