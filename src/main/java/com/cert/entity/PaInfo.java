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
 * @description : 人员基本信息
 * @author Tor
 * @date 2014年5月11日 下午4:16:43
 */
@Entity
@Table(name="pa_info", schema="")
public class PaInfo extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field pa_name 姓名
	 */
	private String pa_name;
	/**
	 * @field pa_sex 性别
	 */
	private String pa_sex;
	/**
	 * @field pa_card_type证件类型
	 */
	private String pa_card_type;
	/**
	 * @field pa_card_no证件号码
	 */
	private String pa_card_no;
	/**
	 * @field pa_nation 民族
	 */
	private String pa_nation;
	/**
	 * @field pa_education 学历
	 */
	private String pa_education;
	/**
	 * @field pa_degree 学位
	 */
	private String pa_degree;
	/**
	 * @field pa_school 毕业学校
	 */
	private String pa_school;
	/**
	 * @field pa_subject 所学专业
	 */
	private String pa_subject;
	/**
	 * @field pa_graduate_date毕业时间
	 */
	private Date pa_graduate_date;
	/**
	 * @field pa_phone联系电话
	 */
	private Date pa_phone;
	/**
	 * @field coinfo_id 所属企业
	 */
	private CoInfo coinfo;
	
	
	
	public String getPa_name() {
		return pa_name;
	}
	public void setPa_name(String pa_name) {
		this.pa_name = pa_name;
	}
	public String getPa_sex() {
		return pa_sex;
	}
	public void setPa_sex(String pa_sex) {
		this.pa_sex = pa_sex;
	}
	public String getPa_card_type() {
		return pa_card_type;
	}
	public void setPa_card_type(String pa_card_type) {
		this.pa_card_type = pa_card_type;
	}
	public String getPa_card_no() {
		return pa_card_no;
	}
	public void setPa_card_no(String pa_card_no) {
		this.pa_card_no = pa_card_no;
	}
	public String getPa_nation() {
		return pa_nation;
	}
	public void setPa_nation(String pa_nation) {
		this.pa_nation = pa_nation;
	}
	public String getPa_education() {
		return pa_education;
	}
	public void setPa_education(String pa_education) {
		this.pa_education = pa_education;
	}
	public String getPa_degree() {
		return pa_degree;
	}
	public void setPa_degree(String pa_degree) {
		this.pa_degree = pa_degree;
	}
	public String getPa_school() {
		return pa_school;
	}
	public void setPa_school(String pa_school) {
		this.pa_school = pa_school;
	}
	public String getPa_subject() {
		return pa_subject;
	}
	public void setPa_subject(String pa_subject) {
		this.pa_subject = pa_subject;
	}
	public Date getPa_graduate_date() {
		return pa_graduate_date;
	}
	public void setPa_graduate_date(Date pa_graduate_date) {
		this.pa_graduate_date = pa_graduate_date;
	}
	public Date getPa_phone() {
		return pa_phone;
	}
	public void setPa_phone(Date pa_phone) {
		this.pa_phone = pa_phone;
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
	
	
	
	
}
