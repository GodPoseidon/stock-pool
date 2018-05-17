package com.huanxian.admin.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huanxian.admin.controller.BaseController;
import com.huanxian.admin.model.Menu;
import com.huanxian.admin.shiro.ShiroUtil;
import com.huanxian.common.web.WebUtil;
import com.huanxian.core.model.ResultModel;
import com.huanxian.entity.SysResourceT;
import com.huanxian.service.SysResourcesTService;

/**
 * 首页
 * 
 * @author zhuzhen
 *
 */
@Controller
public class IndexController extends BaseController {

	@Autowired
	private SysResourcesTService sysResourcesTService;

	private static Map<String, String> icons;

	static {
		icons = new HashMap<String, String>();
		icons.put("启动页", "fa-welcome");
		icons.put("工作台", "fa-dashboard");
		icons.put("系统配置", "fa fa-windows");
		icons.put("会员管理", "fa fa-users");
		icons.put("资讯", "fa fa-newspaper-o");
		icons.put("直播间管理", "fa fa-video-camera");
		icons.put("课程学院", "fa fa-film");
		icons.put("产品管理", "fa fa-cloud");
		icons.put("推送管理", "fa fa-paper-plane-o");
	}

	@GetMapping("/login")
	public String login(HttpServletRequest request) {	
		if(WebUtil.isAjax(request)){
			return "forward:unauthorized";
		}
		return "login";
	}
	
	@ResponseBody
	@GetMapping("/unauthorized")
	public ResultModel unauthorized() {
		return errorResult("1002", "登陆失效！！", null);
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/")
	public String aa() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(Map<String, Object> modelMap) {
		List<Menu> menus = new ArrayList<Menu>();
		List<SysResourceT> all = new ArrayList<SysResourceT>();
		List<Long> parentIds = sysResourcesTService.getGroupByParentId();
		if (parentIds != null) {
			Map<String, Object> menuMap = new HashMap<String, Object>();
			for (Long id : parentIds) {
				List<SysResourceT> list = sysResourcesTService
						.getResourcesMenuByLoginId(ShiroUtil.getCurrentUser().getId(), id);
				if (list != null && list.size() > 0) {
					String key = "name" + id;
					menuMap.put(key, list);
				}
			}
			for (String key : menuMap.keySet()) {
				Object menu = menuMap.get(key);
				List<SysResourceT> list = (List) menu;
				all.addAll(list);
			}
			for (int i = 0; i < all.size(); i++) {
				SysResourceT p = all.get(i);
				if (p.getParentId().longValue() == 0L) {
					if (exist(menus, p.getId())) {
						continue;
					}
					Menu m = new Menu();
					m.setId(p.getId() + "");
					m.setName(p.getCnName());
					m.setUrl(p.getUrl());
					m.setNum(p.getNum());
					m.setIcon(icons.get(p.getCnName()));
					List<Menu> sons = new ArrayList<Menu>();
					for (int j = 0; j < all.size(); j++) {
						SysResourceT s = all.get(j);
						if (s.getParentId().longValue() == p.getId().longValue()) {
							Menu son = new Menu();
							son.setId(s.getId() + "");
							son.setName(s.getCnName());
							son.setUrl(s.getUrl());
							son.setNum(s.getNum());
							List<Menu> sonss = new ArrayList<Menu>();
							for (int z = 0; z < all.size(); z++) {
								SysResourceT ss = all.get(z);
								if (ss.getParentId().longValue() == s.getId().longValue()) {
									Menu smallMenu = new Menu();
									smallMenu.setId(ss.getId() + "");
									smallMenu.setName(ss.getCnName());
									smallMenu.setUrl(ss.getUrl());
									smallMenu.setNum(ss.getNum());
									sonss.add(smallMenu);
								}
							}
							son.setSons(sonss);
							sons.add(son);
						}
					}
					m.setSons(sons);
					menus.add(m);
				}
			}
			modelMap.put("user", ShiroUtil.getCurrentUser());
			modelMap.put("menus", menus);
		}
		return "index";
	}

	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		if (ShiroUtil.getCurrentUser() != null) {
			ShiroUtil.logout();
		}
		return "login";
	}

	private boolean exist(List<Menu> menus, Long id) {
		for (Menu menu : menus) {
			if (menu.getId().equals(id + "")) {
				return true;
			}
		}
		return false;
	}
}
