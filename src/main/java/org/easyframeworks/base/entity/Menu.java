package org.easyframeworks.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @class: Menu
 * @description : 菜单表映射实体
 * @author CaoYong
 * @date 2014年5月11日 下午4:15:05
 */
@Entity
@Table(name="sys_menu", schema="")
@JsonIgnoreProperties(value = {"serialVersionUID", "functions", "privMenuRefs", "moduleId"})
public class Menu extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 8935134370464400977L;

	/**
	 * @field name 菜单名称
	 */
	private String name;
	/**
	 * @field code 菜单编码
	 */
	private String code;
	/**
	 * @field url 菜单链接
	 */
	private String url;
	/**
	 * @field jscript 菜单脚本链接
	 */
	private String jscript;
	/**
	 * @field icon 菜单图标
	 */
	private DictData iconData;
	/**
	 * @field target 菜单窗口
	 */
	private String target;
	/**
	 * @field sort 菜单排序
	 */
	private Integer sort;
	/**
	 * @field functions 菜单所有功能
	 */
	private Set<Function> functions = new HashSet<Function>(0);
	/**
	 * @field moduleId 隶属模块
	 */
	private Module moduleId;
	
	private Set<PrivMenuRef> privMenuRefs = new HashSet<PrivMenuRef>(0);

	/**
	 * 获取菜单名称
	 * @return String：菜单名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置菜单名称
	 * @param String：菜单名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取菜单编码
	 * @return String：菜单编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置菜单编码
	 * @param String：菜单编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取菜单链接
	 * @return String：菜单链接
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置菜单链接
	 * @param String：菜单链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取菜单脚本
	 * @return String：菜单脚本
	 */
	public String getJscript() {
		return jscript;
	}
	
	/**
	 * 设置菜单脚本
	 * @param String：菜单脚本
	 */
	public void setJscript(String jscript) {
		this.jscript = jscript;
	}
	/**
	 * 获取菜单图标
	 * @return String：菜单脚本
	 */
	@ManyToOne(optional = true, cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name="icon")
	public DictData getIconData() {
		return iconData;
	}
	/**
	 * 设置菜单图标
	 * @param String：菜单图标
	 */
	public void setIconData(DictData iconData) {
		this.iconData = iconData;
	}
	
	/**
	 * 获取菜单窗口
	 * @return String：菜单窗口
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * 设置菜单窗口
	 * @param String：菜单窗口
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 获取菜单排序
	 * @return int：菜单排序
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置菜单排序
	 * @param int：菜单排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 获取菜单功能
	 * @return Set：菜单功能
	 */
	@OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
	public Set<Function> getFunctions() {
		return functions;
	}

	/**
	 * 设置菜单功能
	 * @param Set：菜单功能
	 */
	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

	/**
	 * 获取隶属模块
	 * @return Module：隶属模块
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "ModuleId")
	public Module getModuleId() {
		return moduleId;
	}

	/**
	 * 设置隶属模块
	 * @param Module：隶属模块
	 */
	public void setModuleId(Module moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * 获取隶属权限
	 * @return Set：隶属权限
	 */
	@OneToMany(mappedBy="menu", cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	public Set<PrivMenuRef> getPrivMenuRefs() {
		return privMenuRefs;
	}

	/**
	 * 设置隶属权限
	 * @param Set：隶属权限
	 */
	public void setPrivMenuRefs(Set<PrivMenuRef> privMenuRefs) {
		this.privMenuRefs = privMenuRefs;
	}
}
