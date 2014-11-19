package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IGroupDao;
import org.easyframeworks.base.entity.Group;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: GroupDao
 * @description : 分组数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:06:05
 */
@Repository
public class GroupDao extends BaseDaoSupport<Group, Integer> implements IGroupDao {

}
