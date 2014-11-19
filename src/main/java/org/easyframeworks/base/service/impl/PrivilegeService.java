package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IPrivilegeDao;
import org.easyframeworks.base.entity.Privilege;
import org.easyframeworks.base.service.IPrivilegeService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @class: PrivilegeService
 * @description : 系统权限业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:46:47
 */
@Service
@Transactional
public class PrivilegeService extends BaseServiceSupport<Privilege, Integer> implements IPrivilegeService {

	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	public IBaseDaoSupport<Privilege, Integer> getBaseDaoSupport() {
		return privilegeDao;
	}

	@Override
	public <E extends Privilege> List<E> findByJdbc(String sql) {
		return null;
	}

}
