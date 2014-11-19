package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IModuleDao;
import org.easyframeworks.base.entity.Module;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: ModuleDao
 * @description : 系统模块数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:10:26
 */
@Repository
public class ModuleDao extends BaseDaoSupport<Module, Integer> implements IModuleDao {

}
