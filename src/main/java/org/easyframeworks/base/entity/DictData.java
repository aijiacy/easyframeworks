package org.easyframeworks.base.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sys_dict_data", schema = "")
@JsonIgnoreProperties(ignoreUnknown=true, value={"dictType"})
public class DictData extends IdEntity {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 3797041995013795484L;
	private String name;
	private String value;
	private DictType dictType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @ManyToOne：多对一关联 cascade：级联,它可以有有五个值可选,分别是： CascadeType.PERSIST：级联新建
	 *                  CascadeType.REMOVE : 级联删除 CascadeType.REFRESH：级联刷新
	 *                  CascadeType.MERGE ：级联更新 CascadeType.ALL ：以上全部四项
	 * @JoinColumn:主表外键字段 typeId：DictData所映射的表中的一个字段
	 */
	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "typeId")
	public DictType getDictType() {
		return dictType;
	}

	public void setDictType(DictType dictType) {
		this.dictType = dictType;
	}

}
