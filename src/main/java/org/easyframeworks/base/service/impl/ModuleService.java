package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IModuleDao;
import org.easyframeworks.base.entity.Module;
import org.easyframeworks.base.service.IModuleService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @class: ModuleService
 * @description : 系统模块业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:44:03
 */
@Service
@Transactional
public class ModuleService extends BaseServiceSupport<Module, Integer> implements IModuleService {

	@Autowired
	private IModuleDao moduleDao;

	@Override
	public IBaseDaoSupport<Module, Integer> getBaseDaoSupport() {
		return moduleDao;
	}

	@Override
	public <E extends Module> List<E> findByJdbc(String sql) {
		return null;
	}

}
