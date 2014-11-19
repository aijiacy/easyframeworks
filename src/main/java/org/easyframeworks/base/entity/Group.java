package org.easyframeworks.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;
/**
 * @class: Group
 * @description : 分组表映射实体
 * @author CaoYong
 * @date 2014年5月11日 下午4:14:08
 */
@Entity
@Table(name="sys_group", schema="")
public class Group extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -4436516728465483039L;

	/**
	 * @field name 分组名称
	 */
	private String name;
	/**
	 * @field desc 分组编码
	 */
	private String code;
	/**
	 * @field desc 分组描述
	 */
	private String desc;
	/**
	 * @field roles 分组角色
	 */
	private Set<Role> roles = new HashSet<Role>(0);
	/**
	 * @field users 分组用户
	 */
	private Set<User> users = new HashSet<User>(0);
	/**
	 * 获取分组名称
	 * @return String：分组名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置分组名称
	 * @param String：分组名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取分组编码
	 * @return String：分组编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置分组编码
	 * @param String：分组编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取分组描述
	 * @return String：分组描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置分组描述
	 * @param String：分组描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取分组角色
	 * @return Set：分组角色
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_group_role", 
	joinColumns = { @JoinColumn(name = "GroupId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "RoleId", referencedColumnName = "Id") })
	public Set<Role> getRoles() {
		return roles;
	}
	/**
	 * 设置分组角色
	 * @param Set：分组角色
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	/**
	 * 获取分组用户
	 * @return Set：分组用户
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_group_user", 
	joinColumns = { @JoinColumn(name = "GroupId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "UserId", referencedColumnName = "Id") })
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * 设置用户分组
	 * @param Set：用户分组
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
