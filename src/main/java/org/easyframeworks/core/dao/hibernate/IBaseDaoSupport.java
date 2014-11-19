package org.easyframeworks.core.dao.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * @class: IBaseDaoSupport
 * @description : 数据层泛型基类接口
 * @author CaoYong
 * @date 2014年5月1日 下午8:01:35
 * @param <T>
 */
public interface IBaseDaoSupport<T,PK extends Serializable> {

	/**
	 * 获取 Hibernate 连接会话
	 * 
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午9:04:42
	 */
	public HibernateTemplate getHibernateTemplate();

	/**
	 * 获取JDBC 连接
	 * 
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月2日上午12:31:49
	 */
	public JdbcTemplate getJdbcTemplate();

	/**
	 * 保存对象
	 * 
	 * @param entityClass
	 * @return 返回保存后的实体对象
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:19:06
	 */
	public PK saveEntity(T entityClass);

	/**
	 * 批量保存对象
	 * 
	 * @param entityClasses
	 *            对象列表
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:19:22
	 */
	public <E extends T> void saveEntities(List<E> entityClasses);

	/**
	 * 删除指定的实体对象
	 * 
	 * @param entityClass
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:39:27
	 */
	public void deleteEntity(T entityClass);

	/**
	 * 根据主键删除实体对象
	 * 
	 * @param entityName
	 * @param id
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:39:45
	 */
	public void deleteEntity(Class<T> entityClass, PK id);

	/**
	 * 删除一个实体对象列表
	 * 
	 * @param entityClasses
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:40:14
	 */
	public <E extends T> void deleteEntities(List<E> entityClasses);

	/**
	 * 更新实体对象
	 * 
	 * @param entityClass
	 *            实体对象
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:42:00
	 */
	public void updateEntity(T entityClass);

	/**
	 * 批量更新实体对象
	 * 
	 * @param entityClasses
	 *            实体对象列表
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:45:01
	 */
	public <E extends T> void updateEntities(List<E> entityClasses);

	/**
	 * 根据实体类型和主键ID 获取唯一对象
	 * 
	 * @param entityClass
	 *            实体对象类
	 * @param id
	 *            主键
	 * @return 返回实体对象
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:29:00
	 */
	public T getById(Class<T> entityClass, PK id);

	/**
	 * 根据实体名称和主键ID 获取唯一对象
	 * 
	 * @param entityName
	 *            实体名称
	 * @param id
	 *            主键
	 * @return 返回实体对象
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:29:37
	 */
	public T getById(String entityName, PK id);

	/**
	 * 加载全部实体对象
	 * 
	 * @param entityClass
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:30:26
	 */
	public <E extends T> List<E> getAll(final Class<T> entityClass);

	/**
	 * 根据实体对象和属性名+属性值，获取对象列表
	 * 
	 * @param entityClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:31:24
	 */
	public <E extends T> List<E> getByProperty(Class<T> entityClass, String propertyName, Object propertyValue, String sortProperty, String sort);
	
	/**
	 * 根据实体对象和属性名+属性值，获取对象列表
	 * 
	 * @param entityClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:31:24
	 */
	public <E extends T> List<E> getByLikeProperty(Class<T> entityClass, String propertyName, Object propertyValue, String sortProperty, String sort);
	
	/**
	 * 根据实体对象和属性名+属性值，获取对象列表
	 * 
	 * @param entityClass
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:31:24
	 */
	public <E extends T> List<E> getByRange(Class<T> entityClass, String propertyName, Object minValue, Object maxValue, String sortProperty, String sort);

	/**
	 * 根据HQL语句查询实体对象
	 * 
	 * @param queryString
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:51:05
	 */
	public T getEntityByQueryString(String queryString, Object...params);

	/**
	 * 根据HQL语句查询实体对象列表
	 * 
	 * @param queryString
	 * @param params
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:51:31
	 */
	public <E extends T> List<E> getEntitiesByQueryString(String queryString, Object...params);

	/**
	 * 根据页码、HQL 获取页实体对象
	 * 
	 * @param pageNo
	 * @param countHql
	 * @param queryString
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午8:51:52
	 */
	public Page<T> getPageEntities(final Pageable pager, final DetachedCriteria detachedCriteria);

	public <E extends T> List<E> getByCriteria(DetachedCriteria criteria);
	/*
	 * **************************************************************************
	 * 下面为JDBC声明方法，必须由自主实现，无特别需求可不实现
	 * ********************************************
	 * ******************************
	 */

	/**
	 * JDBC 方式 获取实体对象
	 * 
	 * @param sql
	 *            语句
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日下午9:00:51
	 */
	public List<Map<String, Object>> getForJdbc(String sql, List<Object> params);
}
