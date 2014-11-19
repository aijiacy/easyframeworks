package com.cert.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;
/**
 * @class: CoCert
 * @description : 企业资质
 * @author Tor
 * @date 2014年5月11日 下午4:16:43
 */
@Entity
@Table(name="co_cert", schema="")
public class CoCert extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field co_cret_name 资质名称
	 */
	private String co_cret_name;
	/**
	 * @field qc_cret_code 证书编号
	 */
	private String qc_cret_code;
	/**
	 * @field qc_ser_no 证书序列号
	 */
	private String qc_ser_no;
	/**
	 * @field qc_cret_type 资质类型
	 */
	private String qc_cret_type;
	/**
	 * @field qc_cret_grade 资质等级
	 */
	private String qc_cret_grade;
	/**
	 * @field qc_award_dept 发证机关
	 */
	private String qc_award_dept;
	/**
	 * @field qc_award_date 发证日期
	 */
	private Date qc_award_date;
	/**
	 * @field qc_begin_date资质有效期始
	 */
	private Date qc_begin_date;
	/**
	 * @field qc_end_date 资质有效期终
	 */
	private Date qc_end_date;
	/**
	 * @field qc_remark 备注
	 */
	private String qc_remark;
	/**
	 * @field qci_status 资质状态 -/待审/失效/有效/不通过/*
	 */
	private String qci_status;
	/**
	 * @field image_url图片路径
	 */
	private String image_url;
	/**
	 * @field coinfi_id 所属企业
	 */
	private CoInfo coinfo;

	


	public String getCo_cret_name() {
		return co_cret_name;
	}

	public void setCo_cret_name(String co_cret_name) {
		this.co_cret_name = co_cret_name;
	}

	public String getQc_cret_code() {
		return qc_cret_code;
	}

	public void setQc_cret_code(String qc_cret_code) {
		this.qc_cret_code = qc_cret_code;
	}

	public String getQc_ser_no() {
		return qc_ser_no;
	}

	public void setQc_ser_no(String qc_ser_no) {
		this.qc_ser_no = qc_ser_no;
	}

	public String getQc_cret_type() {
		return qc_cret_type;
	}

	public void setQc_cret_type(String qc_cret_type) {
		this.qc_cret_type = qc_cret_type;
	}

	public String getQc_cret_grade() {
		return qc_cret_grade;
	}

	public void setQc_cret_grade(String qc_cret_grade) {
		this.qc_cret_grade = qc_cret_grade;
	}

	public String getQc_award_dept() {
		return qc_award_dept;
	}

	public void setQc_award_dept(String qc_award_dept) {
		this.qc_award_dept = qc_award_dept;
	}

	public Date getQc_award_date() {
		return qc_award_date;
	}

	public void setQc_award_date(Date qc_award_date) {
		this.qc_award_date = qc_award_date;
	}

	public Date getQc_begin_date() {
		return qc_begin_date;
	}

	public void setQc_begin_date(Date qc_begin_date) {
		this.qc_begin_date = qc_begin_date;
	}

	public Date getQc_end_date() {
		return qc_end_date;
	}

	public void setQc_end_date(Date qc_end_date) {
		this.qc_end_date = qc_end_date;
	}

	public String getQc_remark() {
		return qc_remark;
	}

	public void setQc_remark(String qc_remark) {
		this.qc_remark = qc_remark;
	}

	public String getQci_status() {
		return qci_status;
	}

	public void setQci_status(String qci_status) {
		this.qci_status = qci_status;
	}

	/**
	 * 所属企业
	 * @return coinfo：所属企业
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "coinfo_id")
	public CoInfo getCoinfo() {
		return coinfo;
	}

	public void setCoinfo(CoInfo coinfo) {
		this.coinfo = coinfo;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
}
