package org.easyframeworks.base.service.impl;

import java.util.List;

import org.easyframeworks.base.dao.hibernate.IUserDao;
import org.easyframeworks.base.entity.User;
import org.easyframeworks.base.service.IUserService;
import org.easyframeworks.core.dao.hibernate.IBaseDaoSupport;
import org.easyframeworks.core.exception.EasyWorkRuntimeException;
import org.easyframeworks.core.service.impl.BaseServiceSupport;
import org.easyframeworks.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BaseServiceSupport<User, Integer> implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public IBaseDaoSupport<User, Integer> getBaseDaoSupport() {
		// TODO Auto-generated method stub
		return userDao;
	}

	@Override
	public boolean isExist(String username) {
		List<User> lst = this.getBaseDaoSupport().getByProperty(User.class, "username", username, "id", "ASC");
		if(lst == null || lst.isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public User checkUser(User user) {
		try{
			String md5Pass = PasswordUtil.encrypt(user.getUsername(), user.getPassword(), PasswordUtil.getStaticSalt());
			return (User) this.getBaseDaoSupport().getEntityByQueryString("from User u where u.username=? and u.password=?", new Object[]{user.getUsername(),md5Pass});
		}catch(Exception ex){
			throw new EasyWorkRuntimeException(ex);
		}
	}

	@Override
	public <E extends User> List<E> findByJdbc(String sql) {
		// TODO Auto-generated method stub
		return null;
	}
}
