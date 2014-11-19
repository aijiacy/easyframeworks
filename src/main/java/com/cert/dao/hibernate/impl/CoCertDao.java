package com.cert.dao.hibernate.impl;

import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;

import com.cert.dao.hibernate.ICoCertDao;
import com.cert.entity.CoCert;
/**
 * @class: CoInfoDao
 * @description : 企业资质管理据操作对象
 * @author Tor
 * @date 2014年5月14日 下午6:13:06
 */
@Repository
public class CoCertDao extends BaseDaoSupport<CoCert, Integer> implements ICoCertDao {

}
