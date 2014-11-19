package org.easyframeworks.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;

/**
 * @class: Privilege
 * @description : 权限表映射实体
 * @author CaoYong
 * @date 2014年5月11日 下午3:24:01
 */
@Entity
@Table(name="sys_priv", schema="")
public class Privilege extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 3070733127288117453L;

	/**
	 * @field name 权限名称
	 */
	private String name;
	/**
	 * @field desc 权限描述
	 */
	private String desc;
	/**
	 * @field roles 权限隶属的角色
	 */
	private Set<Role> roles = new HashSet<Role>(0);
	/**
	 * @field menus 权限菜单
	 */
	private Set<PrivMenuRef> privMenuRefs = new HashSet<PrivMenuRef>(0);

	/**
	 * 获取权限名称
	 * @return String：权限名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置权限名称
	 * @param String：权限名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取权限描述
	 * @return String：权限描述
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 设置权限描述
	 * @param String：权限描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * 获取隶属的角色
	 * @return Set：隶属的角色
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_role_priv", 
	joinColumns = { @JoinColumn(name = "PrivId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "RoleId", referencedColumnName = "Id") })
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * 设置隶属的角色
	 * @param Set：隶属的角色
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 获取权限下的菜单
	 * @return Set：权限下的菜单
	 */
	@OneToMany(mappedBy="privilege", cascade={ CascadeType.ALL },fetch = FetchType.EAGER)
	public Set<PrivMenuRef> getPrivMenuRefs() {
		return privMenuRefs;
	}

	/**
	 * 设置权限下的菜单
	 * @param Set：权限下的菜单
	 */
	public void setPrivMenuRefs(Set<PrivMenuRef> privMenuRefs) {
		this.privMenuRefs = privMenuRefs;
	}
}
