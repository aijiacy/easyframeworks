package org.easyframeworks.core.web.spring.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyframeworks.core.entity.FillUpEntity;
import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.core.web.constants.BasePager;
import org.easyframeworks.core.web.constants.PathController;
import org.easyframeworks.core.web.constants.ResultMsg;
import org.easyframeworks.utils.BeanUtils;
import org.easyframeworks.utils.JSONExUtils;
import org.easyframeworks.utils.LoggerUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public abstract class BaseControlSupport<T,PK extends Serializable, Q extends T> implements IBaseControlSupport<T, PK, Q> {

	/**
	 * @fields path 页面路径信息
	 */
	protected PathController path = new PathController(this.getClass(), this.getBasePath());
	protected JSONExUtils jsonUtils = new JSONExUtils();

	public abstract IBaseServiceSupport<T, PK> getBaseServiceSupport();
	
	public abstract String getBasePath();
	
	@Override
	public void indexBefore(ModelAndView mav, HttpServletRequest request, HttpServletResponse response){
		
	}
	
	@Override
	@RequestMapping(value = "/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(path.getInitViewPath());
		this.indexBefore(mav, request, response);
		return mav;
	}
	
	@Override
	public void goAddBefore(ModelAndView mav){
		
	}

	@Override
	@RequestMapping(value = "/add")
	public ModelAndView goAdd() {
		ModelAndView mav = new ModelAndView(path.getAddViewPath());
		this.goAddBefore(mav);
		return mav;
	}

	@Override
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView doAddByEntity(T entity, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		ResultMsg resultMsg = new ResultMsg();
		try {
			FillUpEntity<T> fillUpEntity = new FillUpEntity<T>();
			fillUpEntity.fillUp(entity, request.getSession());
			PK id = this.getBaseServiceSupport().storeEntity(entity);
			if(Integer.parseInt(id.toString()) > 0){
				mav.setViewName(path.getRedirectListPath());
				resultMsg.pushOK("保存成功");
			}else{
				mav.setViewName(path.getAddViewPath());
				resultMsg.pushError("保存失败");
			}
		} catch (Exception e) {
			resultMsg.pushError("保存失败:" + e.getMessage());
			LoggerUtils.error("保存失败", e);
		}
		mav.addObject("RESULTMSG", resultMsg);
		return mav;
	}

	@Override
	@RequestMapping(value = "/jsave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResultMsg doAddByJson(T entity, HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		try {
			FillUpEntity<T> fillUpEntity = new FillUpEntity<T>();
			fillUpEntity.fillUp(entity, request.getSession());
			PK id = this.getBaseServiceSupport().storeEntity(entity);
			if(Integer.parseInt(id.toString()) > 0){
				resultMsg.pushOK("保存成功");
			}else{
				resultMsg.pushError("保存失败");
			}
		} catch (Exception e) {
			resultMsg.pushError("保存失败:" + e.getMessage());
			LoggerUtils.error("保存失败", e);
		}
		return resultMsg;
	}

	@Override
	@RequestMapping(value = "/jdel/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResultMsg doDelById(@PathVariable("id") PK id) {
		ResultMsg resultMsg = new ResultMsg();
		try{
			this.getBaseServiceSupport().removeEntity(id);
			resultMsg.pushOK("删除成功");
		}catch(Exception ex){
			resultMsg.pushOK("删除失败：" + ex);
			LoggerUtils.error("删除记录发生异常，异常信息：", ex);
		}
		return resultMsg;
	}

	@Override
	@RequestMapping(value = "/jdels", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResultMsg doDelByIds(PK[] ids) {
		ResultMsg resultMsg = new ResultMsg();
		try{
			this.getBaseServiceSupport().removeEntities(ids);
			resultMsg.pushOK("删除成功");
		}catch(Exception ex){
			resultMsg.pushOK("删除失败：" + ex);
			LoggerUtils.error("删除记录发生异常，异常信息：", ex);
		}
		return resultMsg;
	}
	
	public void goUpdateBefore(ModelAndView mav,T entity){
		
	}
	
	@Override
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView goUpdate(@PathVariable("id") PK id) {
		T entity = this.getBaseServiceSupport().findById(id);
		ModelAndView mav = new ModelAndView(path.getEditViewPath());
		mav.addObject(path.getEntityName().toUpperCase(), entity);
		this.goUpdateBefore(mav, entity);
		return mav;
	}

	@Override
	@RequestMapping(value = "/upd", method = RequestMethod.PUT)
	public ModelAndView doUpdateByEntity(T entity, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(path.getRedirectListPath());
		ResultMsg resultMsg = new ResultMsg();
		try{
			FillUpEntity<T> fillUpEntity = new FillUpEntity<T>();
			fillUpEntity.fillUp(entity, request.getSession());
			this.getBaseServiceSupport().modifyEntity(entity);
			resultMsg.pushOK("更新成功");
		}catch(Exception ex){
			resultMsg.pushError("更新失败");
			LoggerUtils.error("更新数据记录失败:", ex);
		}
		mav.addObject("RESULTMSG", resultMsg);
		return mav;
	}

	@Override
	@ResponseBody
	@RequestMapping(value = "/jupd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResultMsg doUpdateByJson(T entity, HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		try{
			FillUpEntity<T> fillUpEntity = new FillUpEntity<T>();
			fillUpEntity.fillUp(entity, request.getSession());
			this.getBaseServiceSupport().modifyEntity(entity);
			resultMsg.pushOK("更新成功");
		}catch(Exception ex){
			resultMsg.pushError("更新失败");
			LoggerUtils.error("更新数据记录失败:", ex);
		}
		return resultMsg;
	}

	@Override
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public ModelAndView doList(Q query) {
		ModelAndView mav = new ModelAndView(path.getListViewPath());
		Map<String,Object> whereCause = BeanUtils.toMap(query);
		List<T> lst = this.getBaseServiceSupport().findEntitiesByQuery(whereCause);
		if(null != lst && !lst.isEmpty()){
			mav.addObject("LISTITEMS", lst);
		}else{
			mav.addObject("LISTITEMS", null);
		}
		return mav;
	}

	@Override
	@ResponseBody
	@RequestMapping(value= "/jlist",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public <E extends T> List<E> doJsonList(Q query) {
		List<E> lst = new ArrayList<E>();
		try{
			Map<String,Object> whereCause = BeanUtils.toMap(query);
			lst = this.getBaseServiceSupport().findEntitiesByQuery(whereCause);
		}catch(Exception ex){
			LoggerUtils.error("查询列表数据失败", ex);
		}
		return lst;
	}

	@Override
	@RequestMapping(value= "/page", method = RequestMethod.GET)
	public ModelAndView doPageList(Q query,@PageableDefault Pageable pageRequest) {
		ModelAndView mav = new ModelAndView(path.getListViewPath());
		Map<String,Object> whereCause = BeanUtils.toMap(query);
		int pageNo = pageRequest.getPageNumber() > 0 ? pageRequest.getPageNumber() - 1 : pageRequest.getPageNumber();
		PageRequest webPageRequest = new PageRequest(pageNo, pageRequest.getPageSize(), pageRequest.getSort());
		Page<T> page = this.getBaseServiceSupport().findPageList(webPageRequest, whereCause, "id");
		BasePager<T> resultPager = new BasePager<T>(page, pageRequest);
		mav.addObject("PAGE", resultPager);
		return mav;
	}

	@Override
	@RequestMapping(value= "/jpage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BasePager<T> doJsonPageList(Q query,@PageableDefault Pageable pageRequest) {
		Map<String,Object> whereCause = BeanUtils.toMap(query);
		int pageNo = pageRequest.getPageNumber() > 0 ? pageRequest.getPageNumber() - 1 : pageRequest.getPageNumber();
		PageRequest webPageRequest = new PageRequest(pageNo, pageRequest.getPageSize(), pageRequest.getSort());
		Page<T> page = this.getBaseServiceSupport().findPageList(webPageRequest, whereCause, "id");
		BasePager<T> resultPager = new BasePager<T>(page, pageRequest);
		return resultPager;
	}
}
