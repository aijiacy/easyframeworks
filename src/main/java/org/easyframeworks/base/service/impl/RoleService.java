package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IRoleDao;
import org.easyframeworks.base.entity.Role;
import org.easyframeworks.base.service.IRoleService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @class: RoleService
 * @description : 系统角色业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:48:36
 */
@Service
@Transactional
public class RoleService extends BaseServiceSupport<Role, Integer> implements IRoleService {

	@Autowired
	private IRoleDao roleDao;

	@Override
	public IBaseDaoSupport<Role, Integer> getBaseDaoSupport() {
		return roleDao;
	}

	@Override
	public <E extends Role> List<E> findByJdbc(String sql) {
		return null;
	}

}
