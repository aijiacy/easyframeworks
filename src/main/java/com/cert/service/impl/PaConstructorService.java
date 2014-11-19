package com.cert.service.impl;

import java.util.List;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cert.dao.hibernate.IPaConstructorDao;
import com.cert.entity.PaConstructor;
import com.cert.service.IPaConstructorService;
/**
 * @class: RoleService
 * @description : 人员注册资质管理业务访问对象
 * @author Tor
 * @date 2014年5月14日 下午6:48:36
 */
@Service
@Transactional
public class PaConstructorService extends BaseServiceSupport<PaConstructor, Integer> implements IPaConstructorService {

	@Autowired
	private IPaConstructorDao paconstructorDao;

	@Override
	public IBaseDaoSupport<PaConstructor, Integer> getBaseDaoSupport() {
		return paconstructorDao;
	}

	@Override
	public <E extends PaConstructor> List<E> findByJdbc(String sql) {
		return null;
	}

}
