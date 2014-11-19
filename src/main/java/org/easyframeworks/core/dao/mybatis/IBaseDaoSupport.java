package org.easyframeworks.core.dao.mybatis;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 基础数据访问接口
 * 
 * @author CaoYong
 * @date 2014年4月6日上午12:39:46
 * @param <T>
 */
public interface IBaseDaoSupport<T extends Serializable> {

	/**
	 * 获取对象数据，根据ID
	 * @param id
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:16:37
	 */
	public <V extends T> V selectById(String id);

	/**
	 * 获取对象数据列表，根据条件
	 * @param obj
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:16:06
	 */
	public <E extends T> List<E> selectByObject(T obj);

	/**
	 * 获取所有对象数据
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:15:51
	 */
	public <E extends T> List<E> selectAll();

	/**
	 * <pre>
	 * 查询对象列表，注意：在给定非null的分页对象时该方法自动设置分页总记录数,如果query和pageInfo同时为null则查询所有
	 * </pre>
	 * 
	 * @param obj
	 *            查询参数
	 * @param pageInfo
	 *            分页对象
	 * @return List 根据分页对象查询的分页结果列表
	 * 
	 * @author CaoYong
	 * @date 2014年4月7日下午11:59:38
	 */
	public <E extends T> List<E> selectList(T obj, Pageable pageInfo);

	/**
	 * <pre>
	 * 查询对象列表，注意：在给定非null的分页对象时该方法自动设置分页总记录数,如果query和pageable同时为null则查询所有
	 * </pre>
	 * 
	 * @param query
	 *            查询参数
	 * @param pageInfo
	 *            分页对象
	 * @return Page 信息方便前台显示
	 * 
	 * @author CaoYong
	 * @date 2014年4月7日下午11:55:29
	 */
	public <E extends T> Page<E> selectPage(T obj, Pageable pageInfo);

	/**
	 * 获取总行数
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:15:30
	 */
	public int selectCount();

	/**
	 * 获取行数，根据条件
	 * @param obj
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:15:05
	 */
	public int selectCount(T obj);

	/**
	 * 插入对象
	 * 
	 * @param obj
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月6日上午12:04:30
	 */
	public int insertByObject(T obj);

	/**
	 * 删除对象，根据主键ID
	 * @param id
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:14:34
	 */
	public int deleteById(String id);

	/**
	 * 删除对象，根据业务条件
	 * @param obj
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:14:15
	 */
	public int deleteByObject(T obj);

	/**
	 * 更新对象，根据主键
	 * 
	 * @param obj
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月7日下午11:11:54
	 */
	public int updateById(T obj);

	/**
	 * 更新对象，根据业务条件
	 * @param obj
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:14:05
	 */
	public int updateByObject(T obj);

	/**
	 * 批量删除根据主键列表
	 * 
	 * @param ids
	 *            主键列表
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:09:30
	 */
	public void deleteInBatch(List<String> ids);

	/**
	 * 批量更新，根据主键条件更新
	 * @param objects 对象列表
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:11:42
	 */
	public <E extends T> void updateInBatch(List<E> objects);

	/**
	 * 批量插入对象
	 * @param objects 对象列表
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:12:27
	 */
	public <E extends T> void insertInBatch(List<E> objects);
}
