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
@Table(name="pa_cert", schema="")
public class PaCert extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field painfo所属人员
	 */
	private PaInfo painfo;
	/**
	 * @field pa_cret_name 资格名称
	 */
	private String pa_cret_name;

	/**
	 * @field pa_cret_no 资质编号
	 */
	private String pa_cret_no;
	/**
	 * @field pa_cret_date 发证日期
	 */
	private Date pa_cret_date;
	/**
	 * @field pa_cret_unit发证单位
	 */
	private Date pa_cret_unit;
	/**
	 * @field pa_effect_date 有效期
	 */
	private Date pa_effect_date;
	
	/**
	 * @field pa_cret_state 资质状态  有效、注销、暂扣、过期
	 */
	private String pa_cret_state;
	/**
	 * @field image_url图片路径
	 */
	private String image_url;
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

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

	public String getPa_cret_name() {
		return pa_cret_name;
	}

	public void setPa_cret_name(String pa_cret_name) {
		this.pa_cret_name = pa_cret_name;
	}

	public String getPa_cret_no() {
		return pa_cret_no;
	}

	public void setPa_cret_no(String pa_cret_no) {
		this.pa_cret_no = pa_cret_no;
	}

	public Date getPa_cret_date() {
		return pa_cret_date;
	}

	public void setPa_cret_date(Date pa_cret_date) {
		this.pa_cret_date = pa_cret_date;
	}

	public Date getPa_cret_unit() {
		return pa_cret_unit;
	}

	public void setPa_cret_unit(Date pa_cret_unit) {
		this.pa_cret_unit = pa_cret_unit;
	}

	public Date getPa_effect_date() {
		return pa_effect_date;
	}

	public void setPa_effect_date(Date pa_effect_date) {
		this.pa_effect_date = pa_effect_date;
	}

	public String getPa_cret_state() {
		return pa_cret_state;
	}

	public void setPa_cret_state(String pa_cret_state) {
		this.pa_cret_state = pa_cret_state;
	}

	
	
	
}
