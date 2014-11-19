package com.cert.service.impl;

import java.util.List;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cert.dao.hibernate.ICoInfoDao;
import com.cert.entity.CoInfo;
import com.cert.service.ICoInfoService;
/**
 * @class: RoleService
 * @description : 企业信息管理业务访问对象
 * @author Tor
 * @date 2014年5月14日 下午6:48:36
 */
@Service
@Transactional
public class CoInfoService extends BaseServiceSupport<CoInfo, Integer> implements ICoInfoService {

	@Autowired
	private ICoInfoDao coinfoDao;

	@Override
	public IBaseDaoSupport<CoInfo, Integer> getBaseDaoSupport() {
		return coinfoDao;
	}

	@Override
	public <E extends CoInfo> List<E> findByJdbc(String sql) {
		return null;
	}

}
