package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IFunctionDao;
import org.easyframeworks.base.entity.Function;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @class: FunctionDao
 * @description : 系统功能数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:06:27
 */
@Repository
public class FunctionDao extends BaseDaoSupport<Function, Integer> implements IFunctionDao {

}
