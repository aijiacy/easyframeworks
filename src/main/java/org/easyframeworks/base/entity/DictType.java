package org.easyframeworks.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.easyframeworks.core.entity.IdEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @class: DictGroup
 * @description : 字典类型实体
 * @author CaoYong
 * @date 2014年5月2日 下午8:37:27
 */
@Entity
@Table(name = "sys_dict_type", schema = "")
@JsonIgnoreProperties(ignoreUnknown=true, value={"dictDatas"})
public class DictType extends IdEntity {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -7575065718728048362L;

	private String name;
	private String code;
	private Set<DictData> dictDatas = new HashSet<DictData>(0);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(mappedBy = "dictType", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public Set<DictData> getDictDatas() {
		return dictDatas;
	}

	public void setDictDatas(Set<DictData> dictDatas) {
		this.dictDatas = dictDatas;
	}
}
