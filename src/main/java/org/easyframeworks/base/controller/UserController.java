package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.User;
import org.easyframeworks.base.service.IUserService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: UserController
 * @description : 系统用户页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:28:37
 */
@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseControlSupport<User, Integer, User> {

	@Autowired
	private IUserService userService;

	@Override
	public IBaseServiceSupport<User, Integer> getBaseServiceSupport() {
		return userService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
