package org.easyframeworks.core.web.manager;

import java.io.Serializable;

public class Client<T extends Serializable> implements Serializable {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户信息
	 */
	private T SysUser;
	/**
	 * 用户IP
	 */
	private java.lang.String ip;
	/**
	 *登录时间
	 */
	private java.util.Date logindatetime;
	
	public java.lang.String getIp() {
		return ip;
	}
	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}
	public java.util.Date getLogindatetime() {
		return logindatetime;
	}
	public void setLogindatetime(java.util.Date logindatetime) {
		this.logindatetime = logindatetime;
	}
	
	public T getSysUser() {
		return SysUser;
	}
	
	public void setSysUser(T sysUser) {
		SysUser = sysUser;
	}
}
