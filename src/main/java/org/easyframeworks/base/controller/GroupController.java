package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.Group;
import org.easyframeworks.base.service.IGroupService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: GroupController
 * @description : 系统分组页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:17:51
 */
@RestController
@RequestMapping("/admin/group")
public class GroupController extends BaseControlSupport<Group, Integer, Group> {

	@Autowired
	private IGroupService groupService;

	@Override
	public IBaseServiceSupport<Group, Integer> getBaseServiceSupport() {
		return groupService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
