package com.cert.dao.hibernate.impl;

import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;

import com.cert.dao.hibernate.IPaInfoDao;
import com.cert.entity.PaInfo;
/**
 * @class: CoInfoDao
 * @description : 人员基本信息管理据操作对象
 * @author Tor
 * @date 2014年5月14日 下午6:13:06
 */
@Repository
public class PaInfoDao extends BaseDaoSupport<PaInfo, Integer> implements IPaInfoDao {

}
