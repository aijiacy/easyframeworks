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
@Table(name="pa_card_person", schema="")
public class PaCard extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -8823898801577919426L;
	/**
	 * @field painfo所属人员
	 */
	private PaInfo painfo;
	/**
	 * @field pa_card_name 证件名称
	 */
	private String pa_card_name;

	/**
	 * @field pa_card_no 证件号码
	 */
	private String pa_card_no;
	/**
	 * @field pa_card_date 发证日期
	 */
	private Date pa_card_date;
	/**
	 * @field pa_cret_unit发证单位
	 */
	private Date pa_card_unit;
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

	public String getPa_card_name() {
		return pa_card_name;
	}

	public void setPa_card_name(String pa_card_name) {
		this.pa_card_name = pa_card_name;
	}

	public String getPa_card_no() {
		return pa_card_no;
	}

	public void setPa_card_no(String pa_card_no) {
		this.pa_card_no = pa_card_no;
	}

	public Date getPa_card_date() {
		return pa_card_date;
	}

	public void setPa_card_date(Date pa_card_date) {
		this.pa_card_date = pa_card_date;
	}

	public Date getPa_card_unit() {
		return pa_card_unit;
	}

	public void setPa_card_unit(Date pa_card_unit) {
		this.pa_card_unit = pa_card_unit;
	}


	
	
	
}
