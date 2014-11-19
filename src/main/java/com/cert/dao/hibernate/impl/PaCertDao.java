package com.cert.dao.hibernate.impl;

import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;

import com.cert.dao.hibernate.IPaCertDao;
import com.cert.entity.PaCert;
/**
 * @class: CoInfoDao
 * @description : 人员资质管理据操作对象
 * @author Tor
 * @date 2014年5月14日 下午6:13:06
 */
@Repository
public class PaCertDao extends BaseDaoSupport<PaCert, Integer> implements IPaCertDao {

}
