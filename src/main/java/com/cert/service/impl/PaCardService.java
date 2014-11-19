package com.cert.service.impl;

import java.util.List;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cert.dao.hibernate.IPaCardDao;
import com.cert.entity.PaCard;
import com.cert.service.IPaCardService;
/**
 * @class: PaCardService
 * @description :个人证书
 * @author Tor
 * @date 2014年5月14日 下午6:48:36
 */
@Service
@Transactional
public class PaCardService extends BaseServiceSupport<PaCard, Integer> implements IPaCardService {

	@Autowired
	private IPaCardDao cpacardDao;

	@Override
	public IBaseDaoSupport<PaCard, Integer> getBaseDaoSupport() {
		return cpacardDao;
	}

	@Override
	public <E extends PaCard> List<E> findByJdbc(String sql) {
		return null;
	}

}
