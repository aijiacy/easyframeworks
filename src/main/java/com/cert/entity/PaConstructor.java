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
 * @description : 人员资质
 * @author Tor
 * @date 2014年5月11日 下午4:16:43 
 */
@Entity
@Table(name="pa_constructor", schema="")
public class PaConstructor extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field painfo所属人员
	 */
	private PaInfo painfo;
	/**
	 * @field pa_con_name 注册专业名称
	 */
	private String pa_con_name;
	/**
	 * @field pa_con_type 资质类型
	 */
	private String pa_con_type;
	/**
	 * @field pa_con_no 资质编号
	 */
	private String pa_con_no;
	/**
	 * @field pa_con_begin_date 注册开始日期
	 */
	private Date pa_con_begin_date;
	/**
	 * @field pa_con_end_date 注册结束日期
	 */
	private Date pa_con_end_date;
	/**
	 * @field pa_con_state 有效/失效/过期
	 */
	private String pa_con_state;
	/**
	 * @field image_url图片路径
	 */
	private String image_url;
	/**
	 * 所属人员
	 * @return coinfo：所属人员
	 */
	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "person_id")
	public PaInfo getPainfo() {
		return painfo;
	}

	public void setPainfo(PaInfo painfo) {
		this.painfo = painfo;
	}

	public String getPa_con_name() {
		return pa_con_name;
	}

	public void setPa_con_name(String pa_con_name) {
		this.pa_con_name = pa_con_name;
	}

	public String getPa_con_type() {
		return pa_con_type;
	}

	public void setPa_con_type(String pa_con_type) {
		this.pa_con_type = pa_con_type;
	}

	public String getPa_con_no() {
		return pa_con_no;
	}

	public void setPa_con_no(String pa_con_no) {
		this.pa_con_no = pa_con_no;
	}

	public Date getPa_con_begin_date() {
		return pa_con_begin_date;
	}

	public void setPa_con_begin_date(Date pa_con_begin_date) {
		this.pa_con_begin_date = pa_con_begin_date;
	}

	public Date getPa_con_end_date() {
		return pa_con_end_date;
	}

	public void setPa_con_end_date(Date pa_con_end_date) {
		this.pa_con_end_date = pa_con_end_date;
	}

	public String getPa_con_state() {
		return pa_con_state;
	}

	public void setPa_con_state(String pa_con_state) {
		this.pa_con_state = pa_con_state;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	
}
