package org.easyframeworks.core.web.spring.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easyframeworks.core.web.constants.BasePager;
import org.easyframeworks.core.web.constants.ResultMsg;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.servlet.ModelAndView;

public interface IBaseControlSupport<T,PK extends Serializable, Q extends T> {
	
	public void indexBefore(ModelAndView mav, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 初始化页面
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午10:58:04
	 */
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response);
	
	public void goAddBefore(ModelAndView mav);
	/**
	 * 跳转至增加页面
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:04:39
	 */
	public ModelAndView goAdd();
	/**
	 * 增加数据记录，刷新页面
	 * @param entity
	 * @return 跳转至列表页面
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:04:54
	 */
	public ModelAndView doAddByEntity(T entity, HttpServletRequest request);
	/**
	 * 增加数据记录，不刷新页面
	 * @param entity
	 * @return 返回JSON	
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:05:25
	 */
	public ResultMsg doAddByJson(T entity, HttpServletRequest request);

	/**
	 * 列表删除一条记录，通过AJAX
	 * @param id
	 * @return 返回JSON结果
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:06:58
	 */
	public ResultMsg doDelById(PK id);
	
	/**
	 * 列表删除多条记录，通过AJAX
	 * @param ids
	 * @return 返回JSON结果
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:07:21
	 */
	public ResultMsg doDelByIds(PK[] ids);
	
	public void goUpdateBefore(ModelAndView mav,T entity);
	/**
	 * 跳转至更新页面
	 * @param id
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:10:38
	 */
	public ModelAndView goUpdate(PK id);
	
	/**
	 * 更新一条记录，刷新页面
	 * @param entity
	 * @return 跳转至列表页面
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:16:26
	 */
	public ModelAndView doUpdateByEntity(T entity, HttpServletRequest request);
	
	/**
	 * 更新一条记录，通过AJAX
	 * @param entity
	 * @return 返回JSON结果
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:17:06
	 */
	public ResultMsg doUpdateByJson(T entity, HttpServletRequest request);
	
	/**
	 * 跳转至无分页的列表页面
	 * @param query
	 * @return 跳转到页面并初始化列表数据对象
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:17:53
	 */
	public ModelAndView doList(Q query);
	
	/**
	 * 跳转至无分页的列表页面
	 * @param query
	 * @return 跳转到页面并初始化返回列表数据JSON对象
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:18:38
	 */
	public <E extends T> List<E> doJsonList(Q query);
	/**
	 * 跳转至分页列表页面
	 * @param query
	 * @param pageRequest
	 * @return 跳转至列表页面 并初始化分页数据对象到页面
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:19:19
	 */
	public ModelAndView doPageList(Q query, @PageableDefault Pageable pageRequest);
	
	/**
	 * 跳转至分页列表页面
	 * @param query
	 * @param pageRequest
	 * @return 跳转至列表页面 并初始化返回分页数据JSON对象到页面
	 * 
	 * @author CaoYong
	 * @date 2014年5月6日下午11:20:05
	 */
	public BasePager<T> doJsonPageList(Q query, @PageableDefault Pageable pageRequest);
}
