package org.easyframeworks.base.dao.hibernate.impl;

import org.easyframeworks.base.dao.hibernate.IDictDataDao;
import org.easyframeworks.base.entity.DictData;
import org.easyframeworks.core.dao.hibernate.impl.BaseDaoSupport;
import org.springframework.stereotype.Repository;
/**
 * @class: DictDataDao
 * @description : 字典键值数据操作对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:07:27
 */
@Repository
public class DictDataDao extends BaseDaoSupport<DictData, Integer> implements IDictDataDao {
}
