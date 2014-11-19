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

/**
 * @class: Function
 * @description : 系统功能
 * @author CaoYong
 * @date 2014年5月11日 下午3:11:21
 */
@Entity
@Table(name = "sys_function", schema = "")
public class Function extends IdEntity {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 8832437363648549483L;
	/**
	 * 功能名称
	 */
	private String name;
	/**
	 * 功能编码
	 */
	private String code;
	/**
	 * 显示类型
	 */
	private DictData showType;
	/**
	 * 功能链接
	 */
	private String url;
	/**
	 * 功能脚本
	 */
	private String script;
	/**
	 * 显示排序
	 */
	private Integer sort;
	/**
	 * 隶属菜单
	 */
	private Menu menu;
	/**
	 * 隶属权限
	 */
	private Set<PrivMenuRef> privMenuRefs = new HashSet<PrivMenuRef>();

	/**
	 * 获取功能名称
	 * 
	 * @return String：功能名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置功能名称
	 * 
	 * @param String
	 *            ：功能名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取功能编码
	 * 
	 * @return String：功能编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置功能编码
	 * 
	 * @param String
	 *            ：功能编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取显示类型
	 * 
	 * @return DictData：显示类型
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name="type")
	public DictData getShowType() {
		return showType;
	}

	/**
	 * 设置显示类型
	 * 
	 * @param DictData
	 *            ：显示类型
	 */
	public void setShowType(DictData showType) {
		this.showType = showType;
	}

	/**
	 * 获取功能链接
	 * 
	 * @return String：功能链接
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置功能链接
	 * 
	 * @param String
	 *            ：功能链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取功能脚本
	 * 
	 * @return String：功能脚本
	 */
	public String getScript() {
		return script;
	}

	/**
	 * 设置功能脚本
	 * 
	 * @param String
	 *            ：功能脚本
	 */
	public void setScript(String script) {
		this.script = script;
	}

	/**
	 * 获取功能排序
	 * 
	 * @return int：功能排序
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置功能排序
	 * 
	 * @param int：功能排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 获取隶属菜单
	 * 
	 * @return Menu：隶属菜单
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch= FetchType.LAZY)
	@JoinColumn(name = "MenuId")
	public Menu getMenu() {
		return menu;
	}

	/**
	 * 设置隶属菜单
	 * 
	 * @param Menu ：隶属菜单
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
	 * 获取隶属权限
	 * @return 隶属权限
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_pm_func", 
	joinColumns = { @JoinColumn(name = "FuncId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "PrivMenuId", referencedColumnName = "Id") })
	public Set<PrivMenuRef> getPrivMenuRefs() {
		return privMenuRefs;
	}

	/**
	 * 设置隶属权限
	 * @param 隶属权限
	 */
	public void setPrivMenuRefs(Set<PrivMenuRef> privMenuRefs) {
		this.privMenuRefs = privMenuRefs;
	}
	
	

}
