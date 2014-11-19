package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.Menu;
import org.easyframeworks.base.service.IMenuService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: MenuController
 * @description : 系统菜单页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:30:08
 */
@RestController
@RequestMapping("/admin/menu")
public class MenuController extends BaseControlSupport<Menu, Integer, Menu> {

	@Autowired
	private IMenuService menuService;
	
	@Override
	public IBaseServiceSupport<Menu, Integer> getBaseServiceSupport() {
		return menuService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
