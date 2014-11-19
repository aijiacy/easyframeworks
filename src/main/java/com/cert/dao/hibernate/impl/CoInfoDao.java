package com.cert.dao.hibernate.impl;

import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;

import com.cert.dao.hibernate.ICoInfoDao;
import com.cert.entity.CoInfo;
/**
 * @class: CoInfoDao
 * @description : 企业信息管理据操作对象
 * @author Tor
 * @date 2014年5月14日 下午6:13:06
 */
@Repository
public class CoInfoDao extends BaseDaoSupport<CoInfo, Integer> implements ICoInfoDao {

}
