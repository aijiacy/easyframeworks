package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IRoleDao;
import org.easyframeworks.base.entity.Role;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: RoleDao
 * @description : 系统角色数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:13:06
 */
@Repository
public class RoleDao extends BaseDaoSupport<Role, Integer> implements IRoleDao {

}
