package org.easyframeworks.core.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaseServiceSupport<T,PK extends Serializable> {
	/**
	 * 保存实体对象
	 * @param entity
	 * @return 返回新增的主键
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:54:17
	 */
	public PK storeEntity(T entity);
	
	/**
	 * 批量保存实体
	 * @param entities
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:54:43
	 */
	public <E extends T> void storeEntities(List<E> entities);
	
	/**
	 * 删除实体对象，根据主键
	 * @param id
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:55:04
	 */
	public void removeEntity(PK id);
	/**
	 * 批量删除实体对象
	 * @param entities
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:55:37
	 */
	public <E extends T> void removeEntities(PK[] ids);
	/**
	 * 更新实体对象
	 * @param entity
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:55:48
	 */
	public void modifyEntity(T entity);
	
	/**
	 * 批量更新实体对象
	 * @param entities
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:56:00
	 */
	public <E extends T> void modifyEntities(List<E> entities);
	
	/**
	 * 根据主键，获取实体对象
	 * @param id
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:56:17
	 */
	public T findById(PK id);
	/**
	 * 获取所有实体对象
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:56:33
	 */
	public <E extends T> List<E> findAll();
	/**
	 * 根据属性值条件获取唯一对象
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:56:55
	 */
	public <E extends T> List<E> findByProperty(String propertyName, Object propertyValue, String sortProperty, String sort);
	/**
	 * 根据属性值条件获取对象列表
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:57:22
	 */
	public <E extends T> List<E> findByLikeProperty(String propertyName, Object propertyValue, String sortProperty, String sort);
	/**
	 * 根据属性值区间条件获取对象列表
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:57:22
	 */
	public <E extends T> List<E> findByRange(String propertyName, Object minValue, Object maxValue, String sortProperty, String sort);
	
	/**
	 * 根据条件参数获取对象
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:57:48
	 */
	public T findEntityByQuery(Map<String,Object> whereCause);
	/**
	 * 根据条件参数获取所有对象
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:58:06
	 */
	public <E extends T> List<E> findEntitiesByQuery(Map<String,Object> whereCause);
	
	/**
	 * 根据条件参数获取对象
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:57:48
	 */
	public T findEntityByQueryString(String queryString, Object...params);
	/**
	 * 根据条件参数获取所有对象
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:58:06
	 */
	public <E extends T> List<E> findEntitiesByQueryString(String queryString, Object...params);
	/**
	 * 获取分页信息
	 * @param pager
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:58:22
	 */
	public Page<T> findPageList(Pageable pager, Map<String,Object> whereCause, String sort);
	

	/**
	 * 获取数据访问层操作对象
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午8:53:52
	 */
	public abstract IBaseDaoSupport<T,PK> getBaseDaoSupport();
	
	/**
	 * 通过数据库原始SQL进行查询
	 * @param sql
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月3日下午11:59:16
	 */
	public abstract <E extends T> List<E> findByJdbc(String sql);
	/**
	 * 获取泛型实体类型
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月4日上午12:06:27
	 */
	public Class<T> getEntityClass();
}
