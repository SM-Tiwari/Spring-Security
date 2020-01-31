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
@Table(name = "district", uniqueConstraints = {/*@UniqueConstraint(columnNames = "id"), */ @UniqueConstraint(columnNames = "DISTRICT_ID")})
@SequenceGenerator(name = "district_seq", sequenceName = "district_seq", allocationSize = 1)
public class DistrictEntity extends BaseEntity{

	
	private static final long serialVersionUID = -754500817576213551L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "district_seq")
	@Column(name = "DISTRICT_ID")
	private Integer districtId;
	
	@Column(name = "PROVINCE_ID")
	private Integer provinceId;
	
	@Column(name = "DISTRICT")
	private String district;

	public DistrictEntity() {
		 
	}

	
	public DistrictEntity(Integer districtId, Integer provinceId, String district) {
		super();
		this.districtId = districtId;
		this.provinceId = provinceId;
		this.district = district;
	}


	public Integer getDistrictId() {
		return districtId;
	}


	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((districtId == null) ? 0 : districtId.hashCode());
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
		DistrictEntity other = (DistrictEntity) obj;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (districtId == null) {
			if (other.districtId != null)
				return false;
		} else if (!districtId.equals(other.districtId))
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
		return "DistrictEntity [districtId=" + districtId + ", provinceId=" + provinceId + ", district=" + district
				+ "]";
	}

	 

	
	
	
	
	
	
}
