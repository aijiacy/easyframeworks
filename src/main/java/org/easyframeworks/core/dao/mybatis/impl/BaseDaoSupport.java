package org.easyframeworks.core.dao.mybatis.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.easyframeworks.core.dao.mybatis.IBaseDaoSupport;
import org.easyframeworks.core.defintions.SqlMapDefines;
import org.easyframeworks.utils.GenericsUtils;
import org.easyframeworks.utils.BeanUtils;
import org.easyframeworks.core.exception.EasyWorkRuntimeException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseDaoSupport<T extends Serializable> implements
		IBaseDaoSupport<T> {

	/**
	 * 注入SQL模板
	 */
    // @Autowired(required = true)
	@Resource(name = "sqlSession")
	protected SqlSession sqlSessionTemplate;
	/**
	 * 命名空间路径映射分隔符
	 */
	public static final String SQLNAME_SEPARATOR = ".";
	/**
	 * @fields sqlNamespace SqlMapping默认的命名空间
	 */
	private String sqlNamespace = getDefaultSqlNamespace();

	/**
	 * 获取默认指定的命名空间
	 * 
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:30:09
	 */
	protected String getDefaultSqlNamespace() {
		Class<?> genericClass = GenericsUtils.getSuperClassGenricType(this
				.getClass());
		return genericClass == null ? null : genericClass.getName();
	}

	/**
	 * 获取SqlMapping命名空间路径
	 * 
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:29:36
	 */
	public String getSqlNamespace() {
		return sqlNamespace;
	}

	/**
	 * 设置SQL映射路径，一般情况请慎用。
	 * 
	 * @param sqlNamespace
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:28:59
	 */
	public void setSqlNamespace(String sqlNamespace) {
		this.sqlNamespace = sqlNamespace;
	}

	/**
	 * 组合SQL映射路径
	 * 
	 * @param sqlName
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年4月13日下午3:28:47
	 */
	protected String getSqlName(String sqlName) {
		return sqlNamespace + SQLNAME_SEPARATOR + sqlName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectById(java.lang
	 * .String)
	 */
	@Override
	public <V extends T> V selectById(String id) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT_BY_ID);
		try {
			return sqlSessionTemplate.selectOne(sqlMapStr, id);
		} catch (Exception ex) {
			throw new EasyWorkRuntimeException(String.format(
					"根据ID查询一条数据记录出错,语句：%s", sqlMapStr), ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectByObject(org.
	 * cy.basicframe.core.dao.serial.IdentSerializable)
	 */
	@Override
	public <E extends T> List<E> selectByObject(T obj) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT);
		try {
			Map<String, Object> params = BeanUtils.toMap(obj);
			return sqlSessionTemplate.selectList(sqlMapStr, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EasyWorkRuntimeException(String.format(
					"根据条件查询多条数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectAll()
	 */
	@Override
	public <E extends T> List<E> selectAll() {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT);
		try {
			return sqlSessionTemplate.selectList(sqlMapStr);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"查询所有数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/**
	 * 设置行范围信息
	 * 
	 * @param pageInfo
	 *            分页信息
	 * @return SQL行绑定信息
	 */
	protected RowBounds getRowBounds(Pageable pageable) {
		RowBounds bounds = RowBounds.DEFAULT;
		if (null != pageable) {
			bounds = new RowBounds(pageable.getOffset(), pageable.getPageSize());
		}
		return bounds;
	}

	/**
	 * 处理分页参数
	 * 
	 * @param obj
	 *            条件对象
	 * @param pageInfo
	 *            分页信息
	 * @return Map 参数映射表
	 */
	protected Map<String, Object> getParams(T obj, Pageable pageInfo) {
		Map<String, Object> params = BeanUtils.toMap(obj,
				getRowBounds(pageInfo));
		if (pageInfo != null && pageInfo.getSort() != null) {
			String sorting = pageInfo.getSort().toString();
			params.put("sorting", sorting.replace(":", ""));
		}
		return params;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectList(org.cy.
	 * basicframe.core.dao.serial.IdentSerializable,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public <E extends T> List<E> selectList(T obj, Pageable pageInfo) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT);
		try {
			Map<String, Object> params = this.getParams(obj, pageInfo);
			return sqlSessionTemplate.selectList(sqlMapStr, params);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"分页查询分页数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectPage(org.cy.
	 * basicframe.core.dao.serial.IdentSerializable,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public <E extends T> Page<E> selectPage(T obj, Pageable pageInfo) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT);
		try {
			Map<String, Object> params = this.getParams(obj, pageInfo);
			List<E> contentList = sqlSessionTemplate.selectList(sqlMapStr,
					params);
			return new PageImpl<E>(contentList, pageInfo, this.selectCount(obj));
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"分页查询分页数据记录及分页信息，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectCount()
	 */
	@Override
	public int selectCount() {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT_COUNT);
		try {
			return sqlSessionTemplate.selectOne(sqlMapStr);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"查询数据总记录数出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#selectCount(org.cy.
	 * basicframe.core.dao.serial.IdentSerializable)
	 */
	@Override
	public int selectCount(T obj) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_SELECT_COUNT);
		try {
			Map<String, Object> params = BeanUtils.toMap(obj);
			return sqlSessionTemplate.selectOne(sqlMapStr, params);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"根据条件查询总记录数据出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#insertByObject(org.
	 * cy.basicframe.core.dao.serial.IdentSerializable)
	 */
	@Override
	public int insertByObject(T obj) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_INSERT);
		try {
			Map<String, Object> params = BeanUtils.toMap(obj);
			return sqlSessionTemplate.insert(sqlMapStr, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EasyWorkRuntimeException(String.format(
					"存储一条数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#deleteById(java.lang
	 * .String)
	 */
	@Override
	public int deleteById(String id) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_DELETE_BY_ID);
		try {
			return sqlSessionTemplate.delete(sqlMapStr, id);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"根据ID删除一条数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#deleteByObject(org.
	 * cy.basicframe.core.dao.serial.IdentSerializable)
	 */
	@Override
	public int deleteByObject(T obj) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_DELETE);
		try {
			Map<String, Object> params = BeanUtils.toMap(obj);
			return sqlSessionTemplate.delete(sqlMapStr, params);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"根据条件删除多条数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#updateById(org.cy.
	 * basicframe.core.dao.serial.IdentSerializable)
	 */
	@Override
	public int updateById(T obj) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_UPDATE_BY_ID);
		try {
			Map<String, Object> params = BeanUtils.toMap(obj);
			return sqlSessionTemplate.update(sqlMapStr, params);
		} catch (Exception e) {
			throw new EasyWorkRuntimeException(String.format(
					"根据ID更新一条数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#updateByObject(org.
	 * cy.basicframe.core.dao.serial.IdentSerializable)
	 */
	@Override
	public int updateByObject(T obj) {
		String sqlMapStr = getSqlName(SqlMapDefines.SQL_UPDATE);
		try {
			Map<String, Object> params = BeanUtils.toMap(obj);
			return sqlSessionTemplate.update(sqlMapStr, params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EasyWorkRuntimeException(String.format(
					"根据条件更新多条数据记录出错，语句：%s", sqlMapStr));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#insertInBatch(java.
	 * util.List)
	 */
	@Override
	@Transactional
	public <E extends T> void insertInBatch(List<E> objects) {
		if (objects == null || objects.isEmpty()) {
			return;
		}
		for (T obj : objects) {
			this.insertByObject(obj);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#deleteInBatch(java.
	 * util.List)
	 */
	@Override
	@Transactional
	public void deleteInBatch(List<String> ids) {
		if (ids == null || ids.isEmpty()) {
			return;
		}
		for (String id : ids) {
			this.deleteById(id);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.cy.basicframe.core.dao.mybatis.BaseDaoSupport#updateInBatch(java.
	 * util.List)
	 */
	@Override
	@Transactional
	public <E extends T> void updateInBatch(List<E> objects) {
		if (objects == null || objects.isEmpty()) {
			return;
		}
		for (T obj : objects) {
			this.updateByObject(obj);
		}
	}

}
