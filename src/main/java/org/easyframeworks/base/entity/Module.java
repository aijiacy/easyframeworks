package org.easyframeworks.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.easyframeworks.core.entity.IdEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @class: Module
 * @description : 模块表映射实体
 * @author CaoYong
 * @date 2014年5月11日 下午2:57:06
 */
@Entity
@Table(name="sys_module", schema="")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"serialVersionUID", "menus"})
public class Module extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8031852246149611941L;

	/**
	 * @field name 模块名称
	 */
	private String name;
	/**
	 * @field code 模块编码
	 */
	private String code;
	/**
	 * @field sort 模块排序
	 */
	private Integer sort;
	/**
	 * @field menus 模块下菜单
	 */
	private Set<Menu> menus = new HashSet<Menu>(0);
	/**
	 * 获取模块名称
	 * @return String：模块名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置模块名称
	 * @param String：模块名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取模块编码
	 * @return String：模块编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置模块编码
	 * @param String：模块编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取模块排序
	 * @return int：模块排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置模块排序
	 * @param int：模块排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取模块菜单
	 * @return Menu 菜单列表
	 */
	@Transient
	public Set<Menu> getMenus() {
		return menus;
	}
	/**
	 * 设置模块菜单
	 * @param Menu 菜单列表
	 */
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
}
