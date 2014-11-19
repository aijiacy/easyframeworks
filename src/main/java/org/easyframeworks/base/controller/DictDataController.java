package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.DictData;
import org.easyframeworks.base.service.IDictDataService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @class: DictDataController
 * @description : 系统字典值页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:31:38
 */
@Controller
@RequestMapping("/admin/dictdata")
public class DictDataController extends BaseControlSupport<DictData, Integer, DictData>  {

	@Autowired
	private IDictDataService dictDataService;
	
	@Override
	public IBaseServiceSupport<DictData, Integer> getBaseServiceSupport() {
		return dictDataService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
