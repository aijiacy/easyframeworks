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
 * @class: User
 * @description : 系统用户表映射实体
 * @author CaoYong
 * @date 2014年5月11日 下午4:29:37
 */
@Entity
@Table(name = "sys_user", schema = "")
public class User extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 1286796069475072042L;

	/**
	 * @field username 用户名
	 */
	private String username;
	/**
	 * @field password 密码
	 */
	private String password;
	/**
	 * @field nickName 昵称
	 */
	private String nickName;
	/**
	 * @field telephone 联系电话
	 */
	private String telephone;
	/**
	 * @field email 邮箱地址
	 */
	private String email;
	/*
	 * @field typeId 用户类型
	 */
	private DictData userType;
	/**
	 * @field refId 信息扩展ID
	 */
	private Integer refId;

	/**
	 * @field groups 用户分组
	 */
	private Set<Group> groups = new HashSet<Group>(0);

	/**
	 * 获取用户名
	 * @return String 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * @param String 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取密码
	 * @return String 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * @param String 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取昵称
	 * @return String 昵称
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 设置昵称
	 * @param String 昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 设置联系电话
	 * @return String 联系电话
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * 设置联系电话
	 * @param String 联系电话
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * 获取邮箱
	 * @return String 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮箱
	 * @param String 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取用户类型
	 * @return DictData 用户类型
	 */
	@ManyToOne(optional = true, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="TypeId")
	public DictData getUserType() {
		return userType;
	}

	/**
	 * 设置用户类型
	 * @param DictData 用户类型
	 */
	public void setUserType(DictData userType) {
		this.userType = userType;
	}

	/**
	 * 获取扩展信息标识
	 * @return Integer 扩展信息标识
	 */
	public Integer getRefId() {
		return refId;
	}

	/**
	 * 设置扩展信息标识
	 * @param int 扩展信息标识
	 */
	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	/**
	 * 获取用户分组
	 * @return Set 用户分组列表
	 */
	@ManyToMany(cascade={ CascadeType.REFRESH },fetch = FetchType.LAZY)
	@JoinTable(name = "sys_group_user", 
	joinColumns = { @JoinColumn(name = "UserId", referencedColumnName = "Id") }, 
	inverseJoinColumns = { @JoinColumn(name = "GroupId", referencedColumnName = "Id") })
	public Set<Group> getGroups() {
		return groups;
	}

	/**
	 * 设置用户分组
	 * @param Set 用户分组列表
	 */
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

}
