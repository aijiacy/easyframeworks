package org.easyframeworks.base.service;

import org.easyframeworks.base.entity.User;
import org.easyframeworks.core.service.IBaseServiceSupport;

public interface IUserService extends IBaseServiceSupport<User, Integer> {
	/**
	 * 用户名是否存在
	 * @param username
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月11日下午6:15:57
	 */
	public boolean isExist(String username);
	/**
	 * 检测用户是否能够登陆
	 * @param user
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月11日下午6:16:09
	 */
	public User checkUser(User user);
}
