package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IFunctionDao;
import org.easyframeworks.base.entity.Function;
import org.easyframeworks.base.service.IFunctionService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @class: FunctionService
 * @description : 系统功能业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:37:19
 */
@Service
@Transactional
public class FunctionService extends BaseServiceSupport<Function, Integer> implements IFunctionService {

	@Autowired
	private IFunctionDao functionDao;
	
	@Override
	public IBaseDaoSupport<Function, Integer> getBaseDaoSupport() {
		return functionDao;
	}

	@Override
	public <E extends Function> List<E> findByJdbc(String sql) {
		return null;
	}

}
