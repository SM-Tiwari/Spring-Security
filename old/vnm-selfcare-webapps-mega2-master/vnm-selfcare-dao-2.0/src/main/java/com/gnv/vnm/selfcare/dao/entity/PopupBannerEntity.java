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
@Table(name="POPUP_BANNER")
@SequenceGenerator(name = "POPUP_BANNER_SEQ", sequenceName = "POPUP_BANNER_SEQ", allocationSize = 1)
public class PopupBannerEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8471768042950589713L;

	/**
	 * 
	 */
	

	@Id	
	@SequenceGenerator(name="POPUP_BANNER_SEQ", sequenceName="POPUP_BANNER_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POPUP_BANNER_SEQ")  
	@Column(name = "id")
    private Integer popupBannerId;	
	
	/*------------------
	 * 
	 * @Column(name = "id")
	@SequenceGenerator(name="hotnews_seq", sequenceName="hotnews_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotnews_seq")	
	 * */
	
	
	
	@Column(name = "CODE")
	private String popupBannerCode;
	
	@Column(name = "POPUP_BANNER_LINK")
	 String popupBannerLink;

	@Column(name = "VALID_FROM_DATE")
	private Date popupbannerValidFromDate;

    @Column(name = "VALID_TO_DATE")
    private Date popupbannerValidToDate;

    @Column(name = "DESCRIPTION_EN")
    private String popupbannerDescEN;

    @Column(name = "DESCRIPTION_VI")
    private String popupbannerDescVI;

    @Column(name = "DETAILS_EN")
    private String popupbannerDetailEN;

    @Column(name = "DETAILS_VI")
    private String popupbannerDetailVI;

    @Column(name = "NAME_EN")
    private String popupbannerNameEN;

    @Column(name = "NAME_VI")
    private String popupbannerNameVI;

    @Column(name = "SHORT_DESC_EN")
    private String popupbannerShortDescEN;

    @Column(name = "SHORT_DESC_VI")
    private String popupbannerShortDescVI;    

    @Column(name = "DEFAULT_BANNER")
    private String popupbannerDefaultBanner;

    @Column(name = "DISPLAY_ORDER")
    private Integer popupbannerDisplayOrder;

    @Column(name = "SHORT_NAME")
    private String popupbannerShortName;

    @Column(name = "IS_VISIBLE")
    private Integer popupbannerIsVisible;

    @Column(name = "STATUS")
    private Integer popupbannerStatus;

    @Column(name = "CREATE_TIMESTAMP")
    private Date popupbannerCreateTime;

    @Column(name = "CREATED_BY")
    private String popupbannerCreatedBy;

    @Column(name = "LAST_MODIFIED_BY")
    private String popupbannerModifiedBy;

    @Column(name = "LAST_MODIFIED_TIMESTAMP")
    private Date popupbannerLastModifiedTime;

	public Integer getPopupBannerId() {
		return popupBannerId;
	}

	public void setPopupBannerId(Integer popupBannerId) {
		this.popupBannerId = popupBannerId;
	}

	
	
	public String getPopupBannerLink() {
		return popupBannerLink;
	}

	public void setPopupBannerLink(String popupBannerLink) {
		this.popupBannerLink = popupBannerLink;
	}

	public String getPopupBannerCode() {
		return popupBannerCode;
	}

	public void setPopupBannerCode(String popupBannerCode) {
		this.popupBannerCode = popupBannerCode;
	}

	public Date getPopupbannerValidFromDate() {
		return popupbannerValidFromDate;
	}

	public void setPopupbannerValidFromDate(Date popupbannerValidFromDate) {
		this.popupbannerValidFromDate = popupbannerValidFromDate;
	}

	public Date getPopupbannerValidToDate() {
		return popupbannerValidToDate;
	}

	public void setPopupbannerValidToDate(Date popupbannerValidToDate) {
		this.popupbannerValidToDate = popupbannerValidToDate;
	}

	public String getPopupbannerDescEN() {
		return popupbannerDescEN;
	}

	public void setPopupbannerDescEN(String popupbannerDescEN) {
		this.popupbannerDescEN = popupbannerDescEN;
	}

	public String getPopupbannerDescVI() {
		return popupbannerDescVI;
	}

	public void setPopupbannerDescVI(String popupbannerDescVI) {
		this.popupbannerDescVI = popupbannerDescVI;
	}

	public String getPopupbannerDetailEN() {
		return popupbannerDetailEN;
	}

	public void setPopupbannerDetailEN(String popupbannerDetailEN) {
		this.popupbannerDetailEN = popupbannerDetailEN;
	}

	public String getPopupbannerDetailVI() {
		return popupbannerDetailVI;
	}

	public void setPopupbannerDetailVI(String popupbannerDetailVI) {
		this.popupbannerDetailVI = popupbannerDetailVI;
	}

	public String getPopupbannerNameEN() {
		return popupbannerNameEN;
	}

	public void setPopupbannerNameEN(String popupbannerNameEN) {
		this.popupbannerNameEN = popupbannerNameEN;
	}

	public String getPopupbannerNameVI() {
		return popupbannerNameVI;
	}

	public void setPopupbannerNameVI(String popupbannerNameVI) {
		this.popupbannerNameVI = popupbannerNameVI;
	}

	public String getPopupbannerShortDescEN() {
		return popupbannerShortDescEN;
	}

	public void setPopupbannerShortDescEN(String popupbannerShortDescEN) {
		this.popupbannerShortDescEN = popupbannerShortDescEN;
	}

	public String getPopupbannerShortDescVI() {
		return popupbannerShortDescVI;
	}

	public void setPopupbannerShortDescVI(String popupbannerShortDescVI) {
		this.popupbannerShortDescVI = popupbannerShortDescVI;
	}

	public String getPopupbannerDefaultBanner() {
		return popupbannerDefaultBanner;
	}

	public void setPopupbannerDefaultBanner(String popupbannerDefaultBanner) {
		this.popupbannerDefaultBanner = popupbannerDefaultBanner;
	}

	public Integer getPopupbannerDisplayOrder() {
		return popupbannerDisplayOrder;
	}

	public void setPopupbannerDisplayOrder(Integer popupbannerDisplayOrder) {
		this.popupbannerDisplayOrder = popupbannerDisplayOrder;
	}

	public String getPopupbannerShortName() {
		return popupbannerShortName;
	}

	public void setPopupbannerShortName(String popupbannerShortName) {
		this.popupbannerShortName = popupbannerShortName;
	}

	public Integer getPopupbannerIsVisible() {
		return popupbannerIsVisible;
	}

	public void setPopupbannerIsVisible(Integer popupbannerIsVisible) {
		this.popupbannerIsVisible = popupbannerIsVisible;
	}

	public Integer getPopupbannerStatus() {
		return popupbannerStatus;
	}

	public void setPopupbannerStatus(Integer popupbannerStatus) {
		this.popupbannerStatus = popupbannerStatus;
	}

	public Date getPopupbannerCreateTime() {
		return popupbannerCreateTime;
	}

	public void setPopupbannerCreateTime(Date popupbannerCreateTime) {
		this.popupbannerCreateTime = popupbannerCreateTime;
	}

	public String getPopupbannerCreatedBy() {
		return popupbannerCreatedBy;
	}

	public void setPopupbannerCreatedBy(String popupbannerCreatedBy) {
		this.popupbannerCreatedBy = popupbannerCreatedBy;
	}

	public String getPopupbannerModifiedBy() {
		return popupbannerModifiedBy;
	}

	public void setPopupbannerModifiedBy(String popupbannerModifiedBy) {
		this.popupbannerModifiedBy = popupbannerModifiedBy;
	}

	public Date getPopupbannerLastModifiedTime() {
		return popupbannerLastModifiedTime;
	}

	public void setPopupbannerLastModifiedTime(Date popupbannerLastModifiedTime) {
		this.popupbannerLastModifiedTime = popupbannerLastModifiedTime;
	}

	

	public PopupBannerEntity() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((popupBannerCode == null) ? 0 : popupBannerCode.hashCode());
		result = prime * result + ((popupBannerId == null) ? 0 : popupBannerId.hashCode());
		result = prime * result + ((popupBannerLink == null) ? 0 : popupBannerLink.hashCode());
		result = prime * result + ((popupbannerCreateTime == null) ? 0 : popupbannerCreateTime.hashCode());
		result = prime * result + ((popupbannerCreatedBy == null) ? 0 : popupbannerCreatedBy.hashCode());
		result = prime * result + ((popupbannerDefaultBanner == null) ? 0 : popupbannerDefaultBanner.hashCode());
		result = prime * result + ((popupbannerDescEN == null) ? 0 : popupbannerDescEN.hashCode());
		result = prime * result + ((popupbannerDescVI == null) ? 0 : popupbannerDescVI.hashCode());
		result = prime * result + ((popupbannerDetailEN == null) ? 0 : popupbannerDetailEN.hashCode());
		result = prime * result + ((popupbannerDetailVI == null) ? 0 : popupbannerDetailVI.hashCode());
		result = prime * result + ((popupbannerDisplayOrder == null) ? 0 : popupbannerDisplayOrder.hashCode());
		result = prime * result + ((popupbannerIsVisible == null) ? 0 : popupbannerIsVisible.hashCode());
		result = prime * result + ((popupbannerLastModifiedTime == null) ? 0 : popupbannerLastModifiedTime.hashCode());
		result = prime * result + ((popupbannerModifiedBy == null) ? 0 : popupbannerModifiedBy.hashCode());
		result = prime * result + ((popupbannerNameEN == null) ? 0 : popupbannerNameEN.hashCode());
		result = prime * result + ((popupbannerNameVI == null) ? 0 : popupbannerNameVI.hashCode());
		result = prime * result + ((popupbannerShortDescEN == null) ? 0 : popupbannerShortDescEN.hashCode());
		result = prime * result + ((popupbannerShortDescVI == null) ? 0 : popupbannerShortDescVI.hashCode());
		result = prime * result + ((popupbannerShortName == null) ? 0 : popupbannerShortName.hashCode());
		result = prime * result + ((popupbannerStatus == null) ? 0 : popupbannerStatus.hashCode());
		result = prime * result + ((popupbannerValidFromDate == null) ? 0 : popupbannerValidFromDate.hashCode());
		result = prime * result + ((popupbannerValidToDate == null) ? 0 : popupbannerValidToDate.hashCode());
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
		PopupBannerEntity other = (PopupBannerEntity) obj;
		if (popupBannerCode == null) {
			if (other.popupBannerCode != null)
				return false;
		} else if (!popupBannerCode.equals(other.popupBannerCode))
			return false;
		if (popupBannerId == null) {
			if (other.popupBannerId != null)
				return false;
		} else if (!popupBannerId.equals(other.popupBannerId))
			return false;
		if (popupBannerLink == null) {
			if (other.popupBannerLink != null)
				return false;
		} else if (!popupBannerLink.equals(other.popupBannerLink))
			return false;
		if (popupbannerCreateTime == null) {
			if (other.popupbannerCreateTime != null)
				return false;
		} else if (!popupbannerCreateTime.equals(other.popupbannerCreateTime))
			return false;
		if (popupbannerCreatedBy == null) {
			if (other.popupbannerCreatedBy != null)
				return false;
		} else if (!popupbannerCreatedBy.equals(other.popupbannerCreatedBy))
			return false;
		if (popupbannerDefaultBanner == null) {
			if (other.popupbannerDefaultBanner != null)
				return false;
		} else if (!popupbannerDefaultBanner.equals(other.popupbannerDefaultBanner))
			return false;
		if (popupbannerDescEN == null) {
			if (other.popupbannerDescEN != null)
				return false;
		} else if (!popupbannerDescEN.equals(other.popupbannerDescEN))
			return false;
		if (popupbannerDescVI == null) {
			if (other.popupbannerDescVI != null)
				return false;
		} else if (!popupbannerDescVI.equals(other.popupbannerDescVI))
			return false;
		if (popupbannerDetailEN == null) {
			if (other.popupbannerDetailEN != null)
				return false;
		} else if (!popupbannerDetailEN.equals(other.popupbannerDetailEN))
			return false;
		if (popupbannerDetailVI == null) {
			if (other.popupbannerDetailVI != null)
				return false;
		} else if (!popupbannerDetailVI.equals(other.popupbannerDetailVI))
			return false;
		if (popupbannerDisplayOrder == null) {
			if (other.popupbannerDisplayOrder != null)
				return false;
		} else if (!popupbannerDisplayOrder.equals(other.popupbannerDisplayOrder))
			return false;
		if (popupbannerIsVisible == null) {
			if (other.popupbannerIsVisible != null)
				return false;
		} else if (!popupbannerIsVisible.equals(other.popupbannerIsVisible))
			return false;
		if (popupbannerLastModifiedTime == null) {
			if (other.popupbannerLastModifiedTime != null)
				return false;
		} else if (!popupbannerLastModifiedTime.equals(other.popupbannerLastModifiedTime))
			return false;
		if (popupbannerModifiedBy == null) {
			if (other.popupbannerModifiedBy != null)
				return false;
		} else if (!popupbannerModifiedBy.equals(other.popupbannerModifiedBy))
			return false;
		if (popupbannerNameEN == null) {
			if (other.popupbannerNameEN != null)
				return false;
		} else if (!popupbannerNameEN.equals(other.popupbannerNameEN))
			return false;
		if (popupbannerNameVI == null) {
			if (other.popupbannerNameVI != null)
				return false;
		} else if (!popupbannerNameVI.equals(other.popupbannerNameVI))
			return false;
		if (popupbannerShortDescEN == null) {
			if (other.popupbannerShortDescEN != null)
				return false;
		} else if (!popupbannerShortDescEN.equals(other.popupbannerShortDescEN))
			return false;
		if (popupbannerShortDescVI == null) {
			if (other.popupbannerShortDescVI != null)
				return false;
		} else if (!popupbannerShortDescVI.equals(other.popupbannerShortDescVI))
			return false;
		if (popupbannerShortName == null) {
			if (other.popupbannerShortName != null)
				return false;
		} else if (!popupbannerShortName.equals(other.popupbannerShortName))
			return false;
		if (popupbannerStatus == null) {
			if (other.popupbannerStatus != null)
				return false;
		} else if (!popupbannerStatus.equals(other.popupbannerStatus))
			return false;
		if (popupbannerValidFromDate == null) {
			if (other.popupbannerValidFromDate != null)
				return false;
		} else if (!popupbannerValidFromDate.equals(other.popupbannerValidFromDate))
			return false;
		if (popupbannerValidToDate == null) {
			if (other.popupbannerValidToDate != null)
				return false;
		} else if (!popupbannerValidToDate.equals(other.popupbannerValidToDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PopupBannerEntity [popupBannerId=" + popupBannerId + ", popupBannerCode=" + popupBannerCode
				+ ", popupBannerLink=" + popupBannerLink + ", popupbannerValidFromDate=" + popupbannerValidFromDate
				+ ", popupbannerValidToDate=" + popupbannerValidToDate + ", popupbannerDescEN=" + popupbannerDescEN
				+ ", popupbannerDescVI=" + popupbannerDescVI + ", popupbannerDetailEN=" + popupbannerDetailEN
				+ ", popupbannerDetailVI=" + popupbannerDetailVI + ", popupbannerNameEN=" + popupbannerNameEN
				+ ", popupbannerNameVI=" + popupbannerNameVI + ", popupbannerShortDescEN=" + popupbannerShortDescEN
				+ ", popupbannerShortDescVI=" + popupbannerShortDescVI + ", popupbannerDefaultBanner="
				+ popupbannerDefaultBanner + ", popupbannerDisplayOrder=" + popupbannerDisplayOrder
				+ ", popupbannerShortName=" + popupbannerShortName + ", popupbannerIsVisible=" + popupbannerIsVisible
				+ ", popupbannerStatus=" + popupbannerStatus + ", popupbannerCreateTime=" + popupbannerCreateTime
				+ ", popupbannerCreatedBy=" + popupbannerCreatedBy + ", popupbannerModifiedBy=" + popupbannerModifiedBy
				+ ", popupbannerLastModifiedTime=" + popupbannerLastModifiedTime + "]";
	}
    
    
}
