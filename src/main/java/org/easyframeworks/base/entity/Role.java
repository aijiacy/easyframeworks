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
 * @class: Role
 * @description : 角色表映射实体
 * @author CaoYong
 * @date 2014年5月11日 下午4:16:43
 */
@Entity
@Table(name="sys_role", schema="")
public class Role extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field name 角色名称
	 */
	private String name;
	/**
	 * @field desc 角色描述
	 */
	private String desc;
	/**
	 * @field privileges 角色权限
	 */
	private Set<Privilege> privileges = new HashSet<Privilege>(0);
	/**
	 * @field groups 角色组
	 */
	private Set<Group> groups = new HashSet<Group>(0);

	/**
	 * 获取角色名称
	 * @return String：角色名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置角色名称
	 * @param String：角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取角色描述
	 * @return String：角色描述
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 设置角色描述
	 * @param String：角色描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 获取角色权限
	 * @return Set：角色权限
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_role_priv", 
	joinColumns = { @JoinColumn(name = "RoleId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "PrivId", referencedColumnName = "Id") })
	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	/**
	 * 设置角色权限
	 * @param Set：角色权限
	 */
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	/**
	 * 获取角色组
	 * @return Set：角色组
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_group_role", 
	joinColumns = { @JoinColumn(name = "RoleId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "GroupId", referencedColumnName = "Id") })
	public Set<Group> getGroups() {
		return groups;
	}

	/**
	 * 设置角色组
	 * @param Set：角色组
	 */
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
}
