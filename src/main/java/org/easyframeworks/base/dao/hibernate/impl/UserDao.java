package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IUserDao;
import org.easyframeworks.base.entity.User;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: UserDao
 * @description : 系统用户数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:14:15
 */
@Repository
public class UserDao extends BaseDaoSupport<User, Integer> implements IUserDao {
}
