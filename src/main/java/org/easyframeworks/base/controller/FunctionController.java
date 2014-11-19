package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.Function;
import org.easyframeworks.base.service.IFunctionService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: FunctionController
 * @description : 系统功能页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:30:34
 */
@RestController
@RequestMapping("/admin/function")
public class FunctionController extends BaseControlSupport<Function, Integer, Function> {

	@Autowired
	private IFunctionService functionService;
	
	@Override
	public IBaseServiceSupport<Function, Integer> getBaseServiceSupport() {
		return functionService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
