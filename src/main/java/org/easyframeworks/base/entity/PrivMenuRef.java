package org.easyframeworks.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;

@Entity
@Table(name="sys_priv_menu", schema="")
public class PrivMenuRef extends IdEntity{

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 9160177412597982234L;
	
	private Privilege privilege;
	private Menu menu;
	private Set<Function> functions = new HashSet<Function>(0);
	/**
	 * 获取权限
	 * @return 权限
	 */
	@ManyToOne(cascade={CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinColumn(name = "privId")
	public Privilege getPrivilege() {
		return privilege;
	}
	/**
	 * 设置权限
	 * @param 权限
	 */
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	/**
	 * 获取菜单
	 * @return 菜单
	 */
	@ManyToOne(cascade={CascadeType.PERSIST}, fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	public Menu getMenu() {
		return menu;
	}
	/**
	 * 设置菜单
	 * @param 菜单
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	/**
	 * 获取功能列表
	 * @return 功能列表
	 */
	@ManyToMany(cascade={ CascadeType.ALL },fetch = FetchType.EAGER)
	@JoinTable(name = "sys_pm_func", 
	joinColumns = { @JoinColumn(name = "PrivMenuId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "FuncId", referencedColumnName = "Id") })
	public Set<Function> getFunctions() {
		return functions;
	}
	/**
	 * 设置功能列表
	 * @param 功能列表
	 */
	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}
}
