package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.Role;
import org.easyframeworks.base.service.IRoleService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: RoleController
 * @description : 系统角色页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:29:02
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController extends BaseControlSupport<Role, Integer, Role> {

	@Autowired
	private IRoleService roleService;
	
	@Override
	public IBaseServiceSupport<Role, Integer> getBaseServiceSupport() {
		return roleService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
