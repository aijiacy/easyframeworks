package com.cert.dao.hibernate.impl;

import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;

import com.cert.dao.hibernate.IPaCardDao;
import com.cert.entity.PaCard;
/**
 * @class: PaCardDao
 * @description : 个人证件
 * @author Tor
 * @date 2014年5月14日 下午6:13:06
 */
@Repository
public class PaCardDao extends BaseDaoSupport<PaCard, Integer> implements IPaCardDao {

}
