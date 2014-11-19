package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.Privilege;
import org.easyframeworks.base.service.IPrivilegeService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: PrivilegeController
 * @description : 系统权限页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:29:29
 */
@RestController
@RequestMapping("/admin/privilege")
public class PrivilegeController extends BaseControlSupport<Privilege, Integer, Privilege> {

	@Autowired
	private IPrivilegeService privilegeService;
	
	@Override
	public IBaseServiceSupport<Privilege, Integer> getBaseServiceSupport() {
		return privilegeService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
