package com.gnv.vnm.selfcare.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "province", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "PROVINCE_ID")})
@SequenceGenerator(name = "province_seq", sequenceName = "province_seq", allocationSize = 1)
public class ProvinceEntity extends BaseEntity{

	
	private static final long serialVersionUID = -754500817576213551L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "province_seq")
	@Column(name = "PROVINCE_ID")
	private Integer provinceId;
	
	@Column(name = "PROVINCE")
	private String province;

	public ProvinceEntity() {
		 
	}

	public ProvinceEntity(Integer provinceId, String province) {
		super();
	
		this.provinceId = provinceId;
		this.province = province;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((provinceId == null) ? 0 : provinceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProvinceEntity other = (ProvinceEntity) obj;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (provinceId == null) {
			if (other.provinceId != null)
				return false;
		} else if (!provinceId.equals(other.provinceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProvinceEntity [provinceId=" + provinceId + ", province=" + province + "]";
	}

	
	
	
	
	
}
