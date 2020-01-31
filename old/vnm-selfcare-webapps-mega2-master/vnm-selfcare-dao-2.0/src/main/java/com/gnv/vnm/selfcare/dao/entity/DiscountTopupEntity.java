package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "discounttopup")
@SequenceGenerator(name = "user_generator", sequenceName = "discounttopup_seq", allocationSize = 1)
public class DiscountTopupEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3795823603035656659L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "discounttopup_seq", allocationSize = 1)
    @Column(name = "ID")
    Integer discounttopupId;

    @Column(name = "CODE", unique = true)
    String discounttopupCode;
    
    @Column(name = "Rechage_Amount", unique = true)
    String rechageAmount;
    
    @Column(name = "Rechage_Discount")
    String rechageDiscount;
    
	@Column(name = "VALID_FROM_DATE")
    Date discountValidFromDate;

    @Column(name = "VALID_TO_DATE")
    Date discountValidToDate;

    @Column(name = "DESCRIPTION_EN")
    String discountDescEN;

    @Column(name = "DESCRIPTION_VI")
    String discountDescVI;

    @Column(name = "DETAILS_EN")
    String discountDetailEN;

    @Column(name = "DETAILS_VI")
    String discountDetailVI;

    @Column(name = "NAME_EN")
    String discountNameEN;

    @Column(name = "NAME_VI")
    String discountNameVI;   

    @Column(name = "STATUS")
    Integer discountStatus;
    
    @Column(name = "CREATE_TIMESTAMP")
    Date discountCreateTime;

    @Column(name = "CREATED_BY")
    String discountCreatedBy;

    @Column(name = "LAST_MODIFIED_BY")
    String discountModifiedBy;

    @Column(name = "LAST_MODIFIED_TIMESTAMP")
    Date discountLastModifiedTime;

	public Integer getDiscounttopupId() {
		return discounttopupId;
	}

	public void setDiscounttopupId(Integer discounttopupId) {
		this.discounttopupId = discounttopupId;
	}

	public String getDiscounttopupCode() {
		return discounttopupCode;
	}

	public void setDiscounttopupCode(String discounttopupCode) {
		this.discounttopupCode = discounttopupCode;
	}

	public String getRechageAmount() {
		return rechageAmount;
	}

	public void setRechageAmount(String rechageAmount) {
		this.rechageAmount = rechageAmount;
	}

	public String getRechageDiscount() {
		return rechageDiscount;
	}

	public void setRechageDiscount(String rechageDiscount) {
		this.rechageDiscount = rechageDiscount;
	}

	public Date getDiscountValidFromDate() {
		return discountValidFromDate;
	}

	public void setDiscountValidFromDate(Date discountValidFromDate) {
		this.discountValidFromDate = discountValidFromDate;
	}

	public Date getDiscountValidToDate() {
		return discountValidToDate;
	}

	public void setDiscountValidToDate(Date discountValidToDate) {
		this.discountValidToDate = discountValidToDate;
	}

	public String getDiscountDescEN() {
		return discountDescEN;
	}

	public void setDiscountDescEN(String discountDescEN) {
		this.discountDescEN = discountDescEN;
	}

	public String getDiscountDescVI() {
		return discountDescVI;
	}

	public void setDiscountDescVI(String discountDescVI) {
		this.discountDescVI = discountDescVI;
	}

	public String getDiscountDetailEN() {
		return discountDetailEN;
	}

	public void setDiscountDetailEN(String discountDetailEN) {
		this.discountDetailEN = discountDetailEN;
	}

	public String getDiscountDetailVI() {
		return discountDetailVI;
	}

	public void setDiscountDetailVI(String discountDetailVI) {
		this.discountDetailVI = discountDetailVI;
	}

	public String getDiscountNameEN() {
		return discountNameEN;
	}

	public void setDiscountNameEN(String discountNameEN) {
		this.discountNameEN = discountNameEN;
	}

	public String getDiscountNameVI() {
		return discountNameVI;
	}

	public void setDiscountNameVI(String discountNameVI) {
		this.discountNameVI = discountNameVI;
	}

	public Integer getDiscountStatus() {
		return discountStatus;
	}

	public void setDiscountStatus(Integer discountStatus) {
		this.discountStatus = discountStatus;
	}

	public Date getDiscountCreateTime() {
		return discountCreateTime;
	}

	public void setDiscountCreateTime(Date discountCreateTime) {
		this.discountCreateTime = discountCreateTime;
	}

	public String getDiscountCreatedBy() {
		return discountCreatedBy;
	}

	public void setDiscountCreatedBy(String discountCreatedBy) {
		this.discountCreatedBy = discountCreatedBy;
	}

	public String getDiscountModifiedBy() {
		return discountModifiedBy;
	}

	public void setDiscountModifiedBy(String discountModifiedBy) {
		this.discountModifiedBy = discountModifiedBy;
	}

	public Date getDiscountLastModifiedTime() {
		return discountLastModifiedTime;
	}

	public void setDiscountLastModifiedTime(Date discountLastModifiedTime) {
		this.discountLastModifiedTime = discountLastModifiedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountCreateTime == null) ? 0 : discountCreateTime.hashCode());
		result = prime * result + ((discountCreatedBy == null) ? 0 : discountCreatedBy.hashCode());
		result = prime * result + ((discountDescEN == null) ? 0 : discountDescEN.hashCode());
		result = prime * result + ((discountDescVI == null) ? 0 : discountDescVI.hashCode());
		result = prime * result + ((discountDetailEN == null) ? 0 : discountDetailEN.hashCode());
		result = prime * result + ((discountDetailVI == null) ? 0 : discountDetailVI.hashCode());
		result = prime * result + ((discountLastModifiedTime == null) ? 0 : discountLastModifiedTime.hashCode());
		result = prime * result + ((discountModifiedBy == null) ? 0 : discountModifiedBy.hashCode());
		result = prime * result + ((discountNameEN == null) ? 0 : discountNameEN.hashCode());
		result = prime * result + ((discountNameVI == null) ? 0 : discountNameVI.hashCode());
		result = prime * result + ((discountStatus == null) ? 0 : discountStatus.hashCode());
		result = prime * result + ((discountValidFromDate == null) ? 0 : discountValidFromDate.hashCode());
		result = prime * result + ((discountValidToDate == null) ? 0 : discountValidToDate.hashCode());
		result = prime * result + ((discounttopupCode == null) ? 0 : discounttopupCode.hashCode());
		result = prime * result + ((discounttopupId == null) ? 0 : discounttopupId.hashCode());
		result = prime * result + ((rechageAmount == null) ? 0 : rechageAmount.hashCode());
		result = prime * result + ((rechageDiscount == null) ? 0 : rechageDiscount.hashCode());
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
		DiscountTopupEntity other = (DiscountTopupEntity) obj;
		if (discountCreateTime == null) {
			if (other.discountCreateTime != null)
				return false;
		} else if (!discountCreateTime.equals(other.discountCreateTime))
			return false;
		if (discountCreatedBy == null) {
			if (other.discountCreatedBy != null)
				return false;
		} else if (!discountCreatedBy.equals(other.discountCreatedBy))
			return false;
		if (discountDescEN == null) {
			if (other.discountDescEN != null)
				return false;
		} else if (!discountDescEN.equals(other.discountDescEN))
			return false;
		if (discountDescVI == null) {
			if (other.discountDescVI != null)
				return false;
		} else if (!discountDescVI.equals(other.discountDescVI))
			return false;
		if (discountDetailEN == null) {
			if (other.discountDetailEN != null)
				return false;
		} else if (!discountDetailEN.equals(other.discountDetailEN))
			return false;
		if (discountDetailVI == null) {
			if (other.discountDetailVI != null)
				return false;
		} else if (!discountDetailVI.equals(other.discountDetailVI))
			return false;
		if (discountLastModifiedTime == null) {
			if (other.discountLastModifiedTime != null)
				return false;
		} else if (!discountLastModifiedTime.equals(other.discountLastModifiedTime))
			return false;
		if (discountModifiedBy == null) {
			if (other.discountModifiedBy != null)
				return false;
		} else if (!discountModifiedBy.equals(other.discountModifiedBy))
			return false;
		if (discountNameEN == null) {
			if (other.discountNameEN != null)
				return false;
		} else if (!discountNameEN.equals(other.discountNameEN))
			return false;
		if (discountNameVI == null) {
			if (other.discountNameVI != null)
				return false;
		} else if (!discountNameVI.equals(other.discountNameVI))
			return false;
		if (discountStatus == null) {
			if (other.discountStatus != null)
				return false;
		} else if (!discountStatus.equals(other.discountStatus))
			return false;
		if (discountValidFromDate == null) {
			if (other.discountValidFromDate != null)
				return false;
		} else if (!discountValidFromDate.equals(other.discountValidFromDate))
			return false;
		if (discountValidToDate == null) {
			if (other.discountValidToDate != null)
				return false;
		} else if (!discountValidToDate.equals(other.discountValidToDate))
			return false;
		if (discounttopupCode == null) {
			if (other.discounttopupCode != null)
				return false;
		} else if (!discounttopupCode.equals(other.discounttopupCode))
			return false;
		if (discounttopupId == null) {
			if (other.discounttopupId != null)
				return false;
		} else if (!discounttopupId.equals(other.discounttopupId))
			return false;
		if (rechageAmount == null) {
			if (other.rechageAmount != null)
				return false;
		} else if (!rechageAmount.equals(other.rechageAmount))
			return false;
		if (rechageDiscount == null) {
			if (other.rechageDiscount != null)
				return false;
		} else if (!rechageDiscount.equals(other.rechageDiscount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiscountTopupEntity [discounttopupId=" + discounttopupId + ", discounttopupCode=" + discounttopupCode
				+ ", rechageAmount=" + rechageAmount + ", rechageDiscount=" + rechageDiscount
				+ ", discountValidFromDate=" + discountValidFromDate + ", discountValidToDate=" + discountValidToDate
				+ ", discountDescEN=" + discountDescEN + ", discountDescVI=" + discountDescVI + ", discountDetailEN="
				+ discountDetailEN + ", discountDetailVI=" + discountDetailVI + ", discountNameEN=" + discountNameEN
				+ ", discountNameVI=" + discountNameVI + ", discountStatus=" + discountStatus + ", discountCreateTime="
				+ discountCreateTime + ", discountCreatedBy=" + discountCreatedBy + ", discountModifiedBy="
				+ discountModifiedBy + ", discountLastModifiedTime=" + discountLastModifiedTime + "]";
	}

	public DiscountTopupEntity() {
		super();
	}
    
    
    
}
