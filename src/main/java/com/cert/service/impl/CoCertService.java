package com.cert.service.impl;

import java.util.List;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cert.dao.hibernate.ICoCertDao;
import com.cert.entity.CoCert;
import com.cert.service.ICoCertService;
/**
 * @class: RoleService
 * @description : 企业资质管理业务访问对象
 * @author Tor
 * @date 2014年5月14日 下午6:48:36
 */
@Service
@Transactional
public class CoCertService extends BaseServiceSupport<CoCert, Integer> implements ICoCertService {

	@Autowired
	private ICoCertDao cocertDao;

	@Override
	public IBaseDaoSupport<CoCert, Integer> getBaseDaoSupport() {
		return cocertDao;
	}

	@Override
	public <E extends CoCert> List<E> findByJdbc(String sql) {
		return null;
	}

}
