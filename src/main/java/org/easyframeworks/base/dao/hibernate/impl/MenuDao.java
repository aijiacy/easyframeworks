package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IMenuDao;
import org.easyframeworks.base.entity.Menu;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: MenuDao
 * @description : 菜单数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:05:33
 */
@Repository
public class MenuDao extends BaseDaoSupport<Menu, Integer> implements IMenuDao {

}
