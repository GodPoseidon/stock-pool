package com.huanxian.admin.controller.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.core.model.PageVo;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SysRoleResourceT;
import com.huanxian.entity.SysRoleT;
import com.huanxian.entity.SysUserRoleT;
import com.huanxian.entity.SysUserT;
import com.huanxian.service.SysRoleResourceTService;
import com.huanxian.service.SysRoleTService;
import com.huanxian.service.SysUserRoleTService;
import com.huanxian.service.SysUserService;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;

/**
 * 角色管理
 * 
 * @author zhuzhen
 *
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {

	@Autowired
	private SysRoleTService roleTService;

	@Autowired
	private SysRoleResourceTService sysRoleResourceTService;

	@Autowired
	private SysUserRoleTService sysUserRoleTService;

	@Autowired
	private SysUserService sysUserService;

	@GetMapping("/page")
	public String list() {
		return "system/role/list";
	}

	@ResponseBody
	@PostMapping("/list")
	public PageVo<SysRoleT> list(String roleName, Integer status, Integer length, Integer start) {
		EntityWrapper<SysRoleT> wrapper = new EntityWrapper<>();
		if (StrUtil.isNotBlank(roleName)) {
			wrapper.like("name", roleName);
		}
		if (status == null) {
			wrapper.ne("status", 3);
		} else {
			wrapper.eq("status", status);
		}
		PageVo<SysRoleT> page = roleTService.getPage(wrapper, length, (start / length) + 1);
		return page;
	}

	@GetMapping("/edit")
	public String edit(Long id, Model model) {
		if (id != null) {
			SysRoleT roleT = roleTService.get(id);
			model.addAttribute("role", roleT);
		}
		return "system/role/edit";
	}

	@ResponseBody
	@PostMapping("/save")
	public ResultModel save(SysRoleT roleT) {
		roleT.setModifyTime(new Date());
		roleT.setModifyUser(ShiroUtil.getCurrentUser().getName());
		if (roleT.getId() == null) {
			roleT.setCreateTime(new Date());
			roleT.setCreateUser(ShiroUtil.getCurrentUser().getName());
			roleTService.add(roleT);
		} else {
			roleTService.update(roleT);
		}
		return successResult();
	}

	@ResponseBody
	@PostMapping("/delItem")
	public ResultModel delete(Long id) {
		SysRoleT roleT = new SysRoleT();
		roleT.setId(id);
		roleT.setStatus(3);
		roleTService.update(roleT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/enable")
	public ResultModel enanle(Long id) {
		SysRoleT roleT = new SysRoleT();
		roleT.setId(id);
		roleT.setStatus(1);
		roleTService.update(roleT);
		return successResult();
	}

	@ResponseBody
	@PostMapping("/unEnable")
	public ResultModel unEnable(Long id) {
		SysRoleT roleT = new SysRoleT();
		roleT.setId(id);
		roleT.setStatus(2);
		roleTService.update(roleT);
		return successResult();
	}

	@RequestMapping("/getResourceList")
	public String getResourceList(Long id, Model model) {
		model.addAttribute("roleId", id);
		return "system/role/role_resource_tree";
	}

	@ResponseBody
	@PostMapping("/saveRoleResource")
	public ResultModel saveRoleResource(String resourceId, Long roleId) {
		String[] resourceIds = resourceId.substring(0, resourceId.length() - 1).split(",");
		List<SysRoleResourceT> roleResourceList = sysRoleResourceTService.getRoleResourceByRoleId(roleId);
		if (roleResourceList != null && roleResourceList.size() > 0) {
			sysRoleResourceTService.deleteByRoleId(roleId);
		}
		for (int i = 0; i < resourceIds.length; i++) {
			SysRoleResourceT resourceT = new SysRoleResourceT();
			resourceT.setResourceId(Long.parseLong(resourceIds[i]));
			resourceT.setRoleId(roleId);
			resourceT.setStatus(1);
			sysRoleResourceTService.addRoleResource(resourceT);
		}
		return successResult();
	}

	@RequestMapping("/getUserList")
	public String getUserList(Long id, Model model) {
		SysRoleT role = roleTService.get(id);
		model.addAttribute("role", role);
		String checkedIds = "";
		List<SysUserRoleT> checked = sysUserRoleTService.getUserRoleVoByRoleId(id);
		if (checked != null && checked.size() > 0) {
			for (SysUserRoleT vo : checked) {
				checkedIds += vo.getUserId() + ",";
			}
		}
		List<SysUserT> userList = sysUserService.getUserList();
		model.addAttribute("allotUser", JSONUtil.toJsonStr(userList));
		model.addAttribute("checkedUser",
				checkedIds.equals("") ? "" : checkedIds.substring(0, checkedIds.length() - 1));

		return "system/role/role_relevance_user";
	}

	/**
	 * 关联用户保存
	 * 
	 * @param id
	 * @param modelMap
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/allotSave", method = RequestMethod.POST)
	public ResultModel allotSave(Long roleId, String userId) {
		sysUserRoleTService.deleteByRoleId(roleId);
		String[] uid = userId.split(",");
		for (int i = 0; i < uid.length; i++) {
			SysUserRoleT vo = new SysUserRoleT();
			vo.setRoleId(roleId);
			vo.setUserId(Long.parseLong(uid[i]));
			vo.setStatus(1);
			sysUserRoleTService.add(vo);
		}
		return successResult();
	}

}
