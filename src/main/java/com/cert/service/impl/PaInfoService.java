package com.cert.service.impl;

import java.util.List;

import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cert.dao.hibernate.IPaInfoDao;
import com.cert.entity.PaInfo;
import com.cert.service.IPaInfoService;
/**
 * @class: RoleService
 * @description : 企业资质管理业务访问对象
 * @author Tor
 * @date 2014年5月14日 下午6:48:36
 */
@Service
@Transactional
public class PaInfoService extends BaseServiceSupport<PaInfo, Integer> implements IPaInfoService {

	@Autowired
	private IPaInfoDao painfoDao;

	@Override
	public IBaseDaoSupport<PaInfo, Integer> getBaseDaoSupport() {
		return painfoDao;
	}

	@Override
	public <E extends PaInfo> List<E> findByJdbc(String sql) {
		return null;
	}

}
