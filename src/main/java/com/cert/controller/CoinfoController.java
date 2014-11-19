package com.cert.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyframeworks.base.entity.Group;
import org.easyframeworks.base.entity.User;
import org.easyframeworks.base.service.IDictDataService;
import org.easyframeworks.base.service.IGroupService;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.manager.Client;
import org.easyframeworks.core.web.manager.ClientManager;
import org.easyframeworks.core.web.spring.controller.BaseControlSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cert.entity.CoInfo;
import com.cert.service.ICoInfoService;

/**
 * @class: CoinfoController
 * @description : 企业信息管理控制
 * @author tor
 * @date 2014年5月14日 下午7:29:02
 */
@RestController
@RequestMapping("/coinfo")
public class CoinfoController extends BaseControlSupport<CoInfo, Integer, CoInfo> {

	@Autowired
	private ICoInfoService coinfoService;
	@Autowired
	private IDictDataService dictDataService;
	@Autowired
	private IGroupService groupService;
	@Override
	public IBaseServiceSupport<CoInfo, Integer> getBaseServiceSupport() {
		return coinfoService;
	}

	@Override
	public String getBasePath() {
		// TODO Auto-generated method stub
		return "cert";
	}
	
	@Override
	public void indexBefore(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
		Client<User> client = (Client<User>) ClientManager.getInstance().getClient(request.getSession().getId());
		
		CoInfo coinfo=coinfoService.findById(client.getSysUser().getRefId());
		mav.addObject("coinfo");
		//List<DictData> dictDatas = dictDataService.findByProperty("dictType.code", "sexTypes", "id", "ASC");
		//mav.addObject("SEXTYPES", dictDatas);
	}
}
