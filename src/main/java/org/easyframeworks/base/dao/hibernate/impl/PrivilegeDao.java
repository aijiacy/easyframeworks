package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IPrivilegeDao;
import org.easyframeworks.base.entity.Privilege;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: PrivilegeDao
 * @description : 系统权限数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:11:58
 */
@Repository
public class PrivilegeDao extends BaseDaoSupport<Privilege, Integer> implements IPrivilegeDao {

}
