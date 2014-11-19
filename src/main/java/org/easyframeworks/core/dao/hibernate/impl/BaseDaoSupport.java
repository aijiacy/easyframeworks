package org.easyframeworks.core.dao.hibernate.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.exception.EasyDaoException;
import org.easyframeworks.utils.LoggerUtils;
import org.easyframeworks.utils.ReflectHelper;
import org.easyframeworks.utils.StringExUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.util.Assert;

@SuppressWarnings("unchecked")
public abstract class BaseDaoSupport<T, PK extends Serializable> implements IBaseDaoSupport<T, PK> {

	@Autowired(required = true)
	@Resource(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate;

	@Autowired(required = true)
	@Resource(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate;

	@Override
	public HibernateTemplate getHibernateTemplate() {
		try {
			return this.hibernateTemplate;
		} catch (Exception ex) {
			LoggerUtils.error("通过Spring注入(sessionFactory)方式,获取 Hibernate 连接会话失败！", ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public JdbcTemplate getJdbcTemplate() {
		try {
			return this.jdbcTemplate;
		} catch (Exception ex) {
			LoggerUtils.error("通过Spring注入(dataSource)方式,获取 JDBC 连接失败！", ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#saveEntity(java
	 * .lang. Class)
	 */
	@Override
	public PK saveEntity(T entityClass) {
		try {
			PK id = (PK) this.getHibernateTemplate().save(entityClass);
			this.getHibernateTemplate().flush();
			return id;
		} catch (Exception ex) {
			LoggerUtils.error(String.format("保存 %s 对象失败！", entityClass.getClass().getName()), ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#saveEntities(java
	 * .util.List)
	 */
	@Override
	public <E extends T> void saveEntities(List<E> entityClasses) {
		try {
			for (int i = 0; i < entityClasses.size(); i++) {
				E entityClass = entityClasses.get(i);
				this.getHibernateTemplate().save(entityClass);
				if (i % 20 == 0) {
					this.getHibernateTemplate().flush();
					this.getHibernateTemplate().clear();
				}
			}
			this.getHibernateTemplate().flush();
			this.getHibernateTemplate().clear();
		} catch (Exception ex) {
			LoggerUtils.error("批量保存 %s 对象失败！", ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#deleteEntity(java
	 * .lang .Class)
	 */
	@Override
	public void deleteEntity(T entityClass) {
		try {
			this.getHibernateTemplate().delete(entityClass);
			this.getHibernateTemplate().flush();
		} catch (Exception ex) {
			LoggerUtils.error(String.format("删除 %s ID为 %s 的对象失败！", entityClass.getClass().getName(), new ReflectHelper(entityClass).getMethodValue("id")), ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#deleteEntities(
	 * java.lang .Class, java.io.Serializable)
	 */
	@Override
	public void deleteEntity(Class<T> entityClass, PK id) {
		try {
			T entity = this.getHibernateTemplate().load(entityClass, id);
			this.getHibernateTemplate().delete(entity);
			this.getHibernateTemplate().flush();
		} catch (Exception ex) {
			LoggerUtils.error(String.format("删除 %s ID为：%s 的对象失败！", entityClass.getName(), id), ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#deleteEntities(java
	 * .util.List)
	 */
	@Override
	public <E extends T> void deleteEntities(List<E> entityClasses) {
		try {
			for (int i = 0; i < entityClasses.size(); i++) {
				E entityClass = entityClasses.get(i);
				this.getHibernateTemplate().delete(entityClass);
				if (i % 20 == 0) {
					this.getHibernateTemplate().flush();
					this.getHibernateTemplate().clear();
				}
			}
			this.getHibernateTemplate().flush();
			this.getHibernateTemplate().clear();
		} catch (Exception ex) {
			LoggerUtils.error("批量删除对象失败！", ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#updateEntity(java
	 * .lang .Class)
	 */
	@Override
	public void updateEntity(T entityClass) {
		try {
			this.getHibernateTemplate().update(entityClass);
			this.getHibernateTemplate().flush();
		} catch (Exception ex) {
			LoggerUtils.error(String.format("更新 %s ID为：%s 的对象失败！", entityClass.getClass().getName(), new ReflectHelper(entityClass).getMethodValue("id")), ex);
			throw new EasyDaoException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#updateEntities(java
	 * .util.List)
	 */
	@Override
	public <E extends T> void updateEntities(List<E> entityClasses) {
		try {
			for (int i = 0; i < entityClasses.size(); i++) {
				E entityClass = entityClasses.get(i);
				this.getHibernateTemplate().update(entityClass);
				if (i % 20 == 0) {
					this.getHibernateTemplate().flush();
					this.getHibernateTemplate().clear();
				}
			}
			this.getHibernateTemplate().flush();
			this.getHibernateTemplate().clear();
		} catch (Exception ex) {
			LoggerUtils.error("批量更新对象失败！", ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public T getById(Class<T> entityClass, PK id) {
		try {
			T entity = (T) this.getHibernateTemplate().get(entityClass, id);
			if (null != entity) {
				this.getHibernateTemplate().flush();
			}
			return entity;
		} catch (Exception ex) {
			LoggerUtils.error(String.format("查询 %s ID为 %s 的对象失败！", entityClass.getName(), id), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public T getById(String entityName, PK id) {
		try {
			T entity = (T) this.getHibernateTemplate().get(entityName, id);
			if (null != entity) {
				this.getHibernateTemplate().flush();
			}
			return entity;
		} catch (Exception ex) {
			LoggerUtils.error(String.format("查询 %s ID为 %s 的对象失败！", entityName, id), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public <E extends T> List<E> getByProperty(Class<T> entityClass, String propertyName, Object propertyValue, String sortProperty, String sort) {
		try {
			Assert.hasText(propertyName);
			DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
			criteria.add(Restrictions.eq(propertyName, propertyValue));
			if (!StringExUtils.isEmpty(sortProperty)) {
				if (StringExUtils.isEmpty(sort)) {
					criteria.addOrder(Order.asc(sortProperty));
				} else {
					if ("ASC".equals(sort.toUpperCase())) {
						criteria.addOrder(Order.asc(sortProperty));
					} else {
						criteria.addOrder(Order.desc(sortProperty));
					}
				}
			}
			return (List<E>) this.getHibernateTemplate().findByCriteria(criteria);
		} catch (Exception ex) {
			LoggerUtils.error(String.format("查询 %s 条件为 %s=%s 的对象失败！", entityClass.getName(), propertyName, propertyValue), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public <E extends T> List<E> getByLikeProperty(Class<T> entityClass, String propertyName, Object propertyValue, String sortProperty, String sort) {
		try {
			Assert.hasText(propertyName);
			DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
			criteria.add(Restrictions.like(propertyName, propertyValue.toString(), MatchMode.ANYWHERE));
			if (!StringExUtils.isEmpty(sortProperty)) {
				if (StringExUtils.isEmpty(sort)) {
					criteria.addOrder(Order.asc(sortProperty));
				} else {
					if ("ASC".equals(sort.toUpperCase())) {
						criteria.addOrder(Order.asc(sortProperty));
					} else {
						criteria.addOrder(Order.desc(sortProperty));
					}
				}
			}
			return (List<E>) this.getHibernateTemplate().findByCriteria(criteria);
		} catch (Exception ex) {
			LoggerUtils.error(String.format("查询 %s 条件为 %s=%s 的对象失败！", entityClass.getName(), propertyName, propertyValue), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public <E extends T> List<E> getByRange(Class<T> entityClass, String propertyName, Object minValue, Object maxValue, String sortProperty, String sort) {
		try {
			Assert.hasText(propertyName);
			DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
			criteria.add(Restrictions.between(propertyName, minValue, maxValue));
			if (!StringExUtils.isEmpty(sortProperty)) {
				if (StringExUtils.isEmpty(sort)) {
					criteria.addOrder(Order.asc(sortProperty));
				} else {
					if ("ASC".equals(sort.toUpperCase())) {
						criteria.addOrder(Order.asc(sortProperty));
					} else {
						criteria.addOrder(Order.desc(sortProperty));
					}
				}
			}
			return (List<E>) this.getHibernateTemplate().findByCriteria(criteria);
		} catch (Exception ex) {
			LoggerUtils.error(String.format("查询 %s 条件为 %s 在 %s 到 %s 的对象失败！", entityClass.getName(), propertyName, minValue, maxValue), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public <E extends T> List<E> getAll(Class<T> entityClass) {
		try {
			return (List<E>) this.getHibernateTemplate().loadAll(entityClass);
		} catch (Exception ex) {
			LoggerUtils.error(String.format("查询所有 %s 的对象失败！", entityClass.getName()), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public T getEntityByQueryString(String queryString, Object... params) {
		try {
			List<T> lst = (List<T>) this.getHibernateTemplate().find(queryString, params);
			if (lst == null || lst.isEmpty()) {
				return null;
			}
			return lst.iterator().next();
		} catch (Exception ex) {
			LoggerUtils.error(String.format("HQL:%s 执行失败！", queryString), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public <E extends T> List<E> getEntitiesByQueryString(String queryString, Object... params) {
		try {
			return (List<E>) this.getHibernateTemplate().find(queryString, params);
		} catch (Exception ex) {
			LoggerUtils.error(String.format("HQL:%s 执行失败！", queryString), ex);
			throw new EasyDaoException(ex);
		}
	}

	@Override
	public Page<T> getPageEntities(final Pageable pager, final DetachedCriteria detachedCriteria) {
		return (Page<T>) this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Page<T>>() {
			@Override
			public Page<T> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				CriteriaImpl impl = (CriteriaImpl) criteria;
				Projection projection = impl.getProjection();// 取出projection
				List<Order> orderEntries = new ArrayList<Order>();// 用来存放排序字段
				Field field = null;
				Integer totalCount = new Integer(0);
				try {
					field = CriteriaImpl.class.getDeclaredField("orderEntries");
					field.setAccessible(true);
					orderEntries = (List<Order>) field.get(impl);// 将对象中的排序字段存入数组中
					field.set(criteria, new ArrayList<Order>());// 将排序字段设置为空
					totalCount = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
					criteria.setProjection(projection);// 重新设置回projection
					if (projection == null) {
						criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
					}
					field.set(criteria, orderEntries);// 重新设置回排序字段
					List<T> items = criteria.setFirstResult(pager.getOffset()).setMaxResults(pager.getPageSize()).list();
					return new PageImpl<T>(items, pager, totalCount);
				} catch (Exception e) {
					return new PageImpl<T>(new ArrayList<T>(0), pager, totalCount);
				}
			}
		});
	}

	@Override
	public <E extends T> List<E> getByCriteria(DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return (List<E>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.dao.hibernate.IBaseDaoSupport#getForJdbc(java
	 * .lang.String)
	 */
	@Override
	public List<Map<String, Object>> getForJdbc(String sql, List<Object> params) {
		try {
			return this.getJdbcTemplate().queryForList(sql, params);
		} catch (Exception ex) {
			LoggerUtils.error(String.format("SQL:%s 执行失败！", sql), ex);
			throw new EasyDaoException(ex);
		}
	}
}
