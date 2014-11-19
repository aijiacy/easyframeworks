package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IDictDataDao;
import org.easyframeworks.base.entity.DictData;
import org.easyframeworks.base.service.IDictDataService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @class: DictDataService
 * @description : 字典键值业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:38:39
 */
@Service
@Transactional
public class DictDataService extends BaseServiceSupport<DictData, Integer> implements IDictDataService {

	@Autowired
	private IDictDataDao dictDataDao;
	
	@Override
	public IBaseDaoSupport<DictData, Integer> getBaseDaoSupport() {
		return dictDataDao;
	}

	@Override
	public <E extends DictData> List<E> findByJdbc(String sql) {
		return null;
	}

}
