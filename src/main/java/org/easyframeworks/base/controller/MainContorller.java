package org.easyframeworks.base.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.easyframeworks.base.entity.Group;
import org.easyframeworks.base.entity.Menu;
import org.easyframeworks.base.entity.Module;
import org.easyframeworks.base.entity.Role;
import org.easyframeworks.base.entity.User;
import org.easyframeworks.base.service.IGroupService;
import org.easyframeworks.base.service.IMenuService;
import org.easyframeworks.base.service.IModuleService;
import org.easyframeworks.base.service.IRoleService;
import org.easyframeworks.core.web.manager.Client;
import org.easyframeworks.core.web.manager.ClientManager;
import org.easyframeworks.utils.ResourceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * @class: MainContorller
 * @description : (class function information)
 * @author CaoYong
 * @date 2014年5月15日 下午11:34:01
 */
@RestController
@RequestMapping("index")
public class MainContorller {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IGroupService groupService;
	
	@Autowired
	private IModuleService moduleService;
	
	@Autowired
	private IMenuService menuService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public ModelAndView initIndex(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("main/index");
		Client<User> client = (Client<User>) ClientManager.getInstance().getClient(request.getSession().getId());
		mav.addObject("USER", client.getSysUser());
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/left")
	public ModelAndView initLeft(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("main/menus");
		Client<User> client = (Client<User>) ClientManager.getInstance().getClient(request.getSession().getId());
		String superRoleCode = ResourceUtils.getConfigByName("SYS_SUPER_CODE");
		if(client.getSysUser().getUsername().equalsIgnoreCase(superRoleCode)){
			List<Module> modules = moduleService.findAll();
			for(int i = 0; i < modules.size(); i++){
				List<Menu> menus = menuService.findByProperty("moduleId.id", modules.get(i).getId(), "sort", "ASC");
				modules.get(i).getMenus().addAll(menus);
			}
//			TreeSet<Module> treeSet = new TreeSet<Module>(new ModuleComparator());
//			treeSet.addAll(modules);
			mav.addObject("MMENUS", modules);
		}else{
			List<Group> groups = (List<Group>) groupService.findEntitiesByQueryString("select u.groups from User u where u.id=?", new Object[] { client.getSysUser().getId() });
			Set<Role> userRoles = new HashSet<Role>(0);
			for (Group group : groups) {
				List<Role> roles = roleService.findEntitiesByQueryString("select g.roles from Group g where g.id=?", new Object[] { group.getId() });
				userRoles.addAll(roles);
			}
		}
		return mav;
	}
}
