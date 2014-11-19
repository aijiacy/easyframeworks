package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IMenuDao;
import org.easyframeworks.base.entity.Menu;
import org.easyframeworks.base.service.IMenuService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @class: MenuService
 * @description : 系统菜单业务访问对象
 * @author CaoYong
 * @date 2014年5月11日 下午6:42:23
 */
@Service
@Transactional
public class MenuService extends BaseServiceSupport<Menu, Integer> implements IMenuService {

	@Autowired
	private IMenuDao menuDao;

	@Override
	public IBaseDaoSupport<Menu, Integer> getBaseDaoSupport() {
		return menuDao;
	}

	@Override
	public <E extends Menu> List<E> findByJdbc(String sql) {
		return null;
	}

}
