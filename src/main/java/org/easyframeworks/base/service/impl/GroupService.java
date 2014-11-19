package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IGroupDao;
import org.easyframeworks.base.entity.Group;
import org.easyframeworks.base.service.IGroupService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @class: GroupService
 * @description : 系统分组业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:40:26
 */
@Service
@Transactional
public class GroupService extends BaseServiceSupport<Group, Integer> implements IGroupService {

	@Autowired
	private IGroupDao groupDao;

	@Override
	public IBaseDaoSupport<Group, Integer> getBaseDaoSupport() {
		return groupDao;
	}

	@Override
	public <E extends Group> List<E> findByJdbc(String sql) {
		return null;
	}

}
