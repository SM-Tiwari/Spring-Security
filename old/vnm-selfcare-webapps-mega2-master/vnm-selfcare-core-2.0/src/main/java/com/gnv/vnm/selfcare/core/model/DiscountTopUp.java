package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

import com.gnv.vnm.selfcare.core.enums.DataStatus;

public class DiscountTopUp implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4967332531570266690L;
	private Integer id = -1;
	private String code = "";	
	private String name = "";
	private String description = "";
	private String details = "";	
	private String rechage_amount="";
	private String rechage_dicount="";
	private DataStatus status = DataStatus.INACTIVE;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getRechage_amount() {
		return rechage_amount;
	}
	public void setRechage_amount(String rechage_amount) {
		this.rechage_amount = rechage_amount;
	}
	public String getRechage_dicount() {
		return rechage_dicount;
	}
	public void setRechage_dicount(String rechage_dicount) {
		this.rechage_dicount = rechage_dicount;
	}
	public DataStatus getStatus() {
		return status;
	}
	public void setStatus(DataStatus status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rechage_amount == null) ? 0 : rechage_amount.hashCode());
		result = prime * result + ((rechage_dicount == null) ? 0 : rechage_dicount.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscountTopUp other = (DiscountTopUp) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rechage_amount == null) {
			if (other.rechage_amount != null)
				return false;
		} else if (!rechage_amount.equals(other.rechage_amount))
			return false;
		if (rechage_dicount == null) {
			if (other.rechage_dicount != null)
				return false;
		} else if (!rechage_dicount.equals(other.rechage_dicount))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DiscountTopUp [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", details=" + details + ", rechage_amount=" + rechage_amount + ", rechage_dicount=" + rechage_dicount
				+ ", status=" + status + "]";
	}
	public DiscountTopUp() {
		super();
	}
	
	
	
}
