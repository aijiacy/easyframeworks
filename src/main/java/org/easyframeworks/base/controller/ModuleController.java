package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.Module;
import org.easyframeworks.base.service.IModuleService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: ModuleController
 * @description : 系统模块页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:29:49
 */
@RestController
@RequestMapping("/admin/module")
public class ModuleController extends BaseControlSupport<Module, Integer, Module> {

	@Autowired
	private IModuleService moduleService;
	
	@Override
	public IBaseServiceSupport<Module, Integer> getBaseServiceSupport() {
		return moduleService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
