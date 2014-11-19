package org.easyframeworks.core.service.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.easyframeworks.core.service.IBaseServiceSupport;
import org.easyframeworks.utils.GenericsUtils;
import org.easyframeworks.utils.StringExUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public abstract class BaseServiceSupport<T, PK extends Serializable> implements IBaseServiceSupport<T, PK> {

	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		Class<?> clazz = GenericsUtils.getSuperClassGenricType(this.getClass());
		return (Class<T>) clazz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.service.IBaseServiceSupport#storeEntity(java.
	 * lang.Object)
	 */
	@Override
	public PK storeEntity(T entity) {
		return this.getBaseDaoSupport().saveEntity(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.service.IBaseServiceSupport#storeEntities(java
	 * .util.List)
	 */
	@Override
	public <E extends T> void storeEntities(List<E> entities) {
		this.getBaseDaoSupport().saveEntities(entities);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.service.IBaseServiceSupport#removeEntity(java
	 * .io.Serializable)
	 */
	@Override
	public void removeEntity(PK id) {
		this.getBaseDaoSupport().deleteEntity(this.getEntityClass(), id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.easyframeworks.core.service.IBaseServiceSupport#removeEntities(java
	 * .util.List)
	 */
	@Override
	public <E extends T> void removeEntities(PK[] ids) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
		criteria.add(Restrictions.in("id", ids));
		List<E> entities = this.getBaseDaoSupport().getByCriteria(criteria);
		this.getBaseDaoSupport().deleteEntities(entities);
	}

	@Override
	public void modifyEntity(T entity) {
		this.getBaseDaoSupport().updateEntity(entity);
	}

	@Override
	public <E extends T> void modifyEntities(List<E> entities) {
		this.getBaseDaoSupport().updateEntities(entities);
	}

	@Override
	public T findById(PK id) {
		return this.getBaseDaoSupport().getById(getEntityClass(), id);
	}

	@Override
	public <E extends T> List<E> findAll() {
		return this.getBaseDaoSupport().getAll(getEntityClass());
	}

	@Override
	public <E extends T> List<E> findByProperty(String propertyName, Object propertyValue, String sortProperty, String sort) {
		return this.getBaseDaoSupport().getByProperty(getEntityClass(), propertyName, propertyValue, sortProperty, sort);
	}

	@Override
	public <E extends T> List<E> findByLikeProperty(String propertyName, Object propertyValue, String sortProperty, String sort) {
		return this.getBaseDaoSupport().getByLikeProperty(getEntityClass(), propertyName, propertyValue, sortProperty, sort);
	}

	@Override
	public <E extends T> List<E> findByRange(String propertyName, Object minValue, Object maxValue, String sortProperty, String sort) {
		return this.getBaseDaoSupport().getByRange(getEntityClass(), propertyName, minValue, maxValue, sortProperty, sort);
	}

	@Override
	public T findEntityByQuery(Map<String, Object> whereCause) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
		Iterator<String> itKeys = whereCause.keySet().iterator();
		for (; itKeys.hasNext();) {
			String key = itKeys.next();
			criteria.add(Restrictions.eq(key, whereCause.get(key)));
		}
		return this.getBaseDaoSupport().getByCriteria(criteria).iterator().next();
	}

	@Override
	public <E extends T> List<E> findEntitiesByQuery(Map<String, Object> whereCause) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
		Iterator<String> itKeys = whereCause.keySet().iterator();
		for (; itKeys.hasNext();) {
			String key = itKeys.next();
			criteria.add(Restrictions.eq(key, whereCause.get(key)));
		}
		return this.getBaseDaoSupport().getByCriteria(criteria);
	}

	@Override
	public T findEntityByQueryString(String queryString, Object... params) {
		return this.getBaseDaoSupport().getEntityByQueryString(queryString, params);
	}

	@Override
	public <E extends T> List<E> findEntitiesByQueryString(String queryString, Object... params) {
		return this.getBaseDaoSupport().getEntitiesByQueryString(queryString, params);
	}

	@Override
	public Page<T> findPageList(Pageable pager, Map<String, Object> whereCause, String sort) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
		Iterator<String> itKeys = whereCause.keySet().iterator();
		for (; itKeys.hasNext();) {
			String key = itKeys.next();
			Object valueObject = whereCause.get(key);
			if (valueObject instanceof String) {
				criteria.add(Restrictions.like(key, whereCause.get(key).toString(), MatchMode.ANYWHERE));
			}else {
				criteria.add(Restrictions.eq(key, whereCause.get(key)));
			}
		}
		if (StringExUtils.isNotEmpty(sort)) {
			criteria.addOrder(Order.asc(sort));
		}
		return this.getBaseDaoSupport().getPageEntities(pager, criteria);
	}
}
