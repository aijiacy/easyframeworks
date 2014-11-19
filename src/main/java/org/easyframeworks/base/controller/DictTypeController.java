package org.easyframeworks.base.controller;

import org.easyframeworks.base.entity.DictType;
import org.easyframeworks.base.service.IDictTypeService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class: DictTypeController
 * @description : 系统字典类型页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:30:55
 */
@RestController
@RequestMapping("/admin/dicttype")
public class DictTypeController extends BaseControlSupport<DictType, Integer, DictType> {


	@Autowired
	private IDictTypeService dictTypeService;
	
	@Override
	public IBaseServiceSupport<DictType, Integer> getBaseServiceSupport() {
		return dictTypeService;
	}

	@Override
	public String getBasePath() {
		return "sys";
	}

}
