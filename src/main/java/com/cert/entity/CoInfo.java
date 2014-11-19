package com.cert.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;
/**
 * @class: Role
 * @description : 企业信息实体
 * @author Tor
 * @date 2014年5月11日 下午4:16:43
 */
@Entity
@Table(name="co_info", schema="")
public class CoInfo extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field co_name 企业名称
	 */
	private String pe_name;
	/**
	 * @field co_org_name 组织机构代码
	 */
	private String pe_org_code;
	/**
	 * @field co_reg_addr 通讯地址
	 */
	private String pe_addr;
	/**
	 * @field pe_post 邮编
	 */
	private String pe_post;
	/**
	 * @field pe_tele 联系电话
	 */
	private String pe_tele;
	/**
	 * @field pe_fax 传真
	 */
	private String pe_fax;
	/**
	 * @field pe_lic_code 营业执照号
	 */
	private String pe_lic_code;
	/**
	 * @field pe_lic_dis_code 营业执照注册地行政区划代码
	 */
	private String pe_lic_dis_code;
	/**
	 * @field pe_lic_addr 营业执照注册详细地址
	 */
	private String pe_lic_addr;
	/**
	 * @field pe_corp 法人代表
	 */
	private String pe_corp;
	/**
	 * @field pe_ceo 单位负责人
	 */
	private String pe_ceo;
	/**
	 * @field pe_cto 单位技术负责人
	 */
	private String pe_cto;
	/**
	 * @field pe_web 单位网站
	 */
	private String pe_web;
	/**
	 * @field pe_des备注
	 */
	private String pe_des;
	public String getPe_name() {
		return pe_name;
	}
	public void setPe_name(String pe_name) {
		this.pe_name = pe_name;
	}
	public String getPe_org_code() {
		return pe_org_code;
	}
	public void setPe_org_code(String pe_org_code) {
		this.pe_org_code = pe_org_code;
	}
	public String getPe_addr() {
		return pe_addr;
	}
	public void setPe_addr(String pe_addr) {
		this.pe_addr = pe_addr;
	}
	public String getPe_post() {
		return pe_post;
	}
	public void setPe_post(String pe_post) {
		this.pe_post = pe_post;
	}
	public String getPe_tele() {
		return pe_tele;
	}
	public void setPe_tele(String pe_tele) {
		this.pe_tele = pe_tele;
	}
	public String getPe_fax() {
		return pe_fax;
	}
	public void setPe_fax(String pe_fax) {
		this.pe_fax = pe_fax;
	}
	public String getPe_lic_code() {
		return pe_lic_code;
	}
	public void setPe_lic_code(String pe_lic_code) {
		this.pe_lic_code = pe_lic_code;
	}
	public String getPe_lic_dis_code() {
		return pe_lic_dis_code;
	}
	public void setPe_lic_dis_code(String pe_lic_dis_code) {
		this.pe_lic_dis_code = pe_lic_dis_code;
	}
	public String getPe_lic_addr() {
		return pe_lic_addr;
	}
	public void setPe_lic_addr(String pe_lic_addr) {
		this.pe_lic_addr = pe_lic_addr;
	}
	public String getPe_corp() {
		return pe_corp;
	}
	public void setPe_corp(String pe_corp) {
		this.pe_corp = pe_corp;
	}
	public String getPe_ceo() {
		return pe_ceo;
	}
	public void setPe_ceo(String pe_ceo) {
		this.pe_ceo = pe_ceo;
	}
	public String getPe_cto() {
		return pe_cto;
	}
	public void setPe_cto(String pe_cto) {
		this.pe_cto = pe_cto;
	}
	public String getPe_web() {
		return pe_web;
	}
	public void setPe_web(String pe_web) {
		this.pe_web = pe_web;
	}
	public String getPe_des() {
		return pe_des;
	}
	public void setPe_des(String pe_des) {
		this.pe_des = pe_des;
	}


	
	
}
