package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IDictTypeDao;
import org.easyframeworks.base.entity.DictType;
import org.easyframeworks.base.service.IDictTypeService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictTypeService extends BaseServiceSupport<DictType, Integer> implements IDictTypeService {

	@Autowired
	private IDictTypeDao dictTypeDao;
	
	@Override
	public IBaseDaoSupport<DictType, Integer> getBaseDaoSupport() {
		return dictTypeDao;
	}

	@Override
	public <E extends DictType> List<E> findByJdbc(String sql) {
		return null;
	}

}
