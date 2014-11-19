package com.cert.service.impl;

import java.util.List;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cert.dao.hibernate.IPaCertDao;
import com.cert.entity.PaCert;
import com.cert.service.IPaCertService;
/**
 * @class: RoleService
 * @description : 人员资质管理业务访问对象
 * @author Tor
 * @date 2014年5月14日 下午6:48:36
 */
@Service
@Transactional
public class PaCertService extends BaseServiceSupport<PaCert, Integer> implements IPaCertService {

	@Autowired
	private IPaCertDao pacertDao;

	@Override
	public IBaseDaoSupport<PaCert, Integer> getBaseDaoSupport() {
		return pacertDao;
	}

	@Override
	public <E extends PaCert> List<E> findByJdbc(String sql) {
		return null;
	}

}
