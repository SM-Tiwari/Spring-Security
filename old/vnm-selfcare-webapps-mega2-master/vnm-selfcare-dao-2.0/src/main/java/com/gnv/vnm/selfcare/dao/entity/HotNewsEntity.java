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
@Table(name = "Hot_News") 
@SequenceGenerator(name = "user_generator", sequenceName = "hotnews_seq", allocationSize = 1)
public class HotNewsEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -678805551771447224L;

	
	@Id
	@Column(name = "id")
	@SequenceGenerator(name="hotnews_seq", sequenceName="hotnews_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotnews_seq")		
	private Integer hotnewsId;	
	
	/*
	 * @Column(name="user_id", nullable=false)	
	@SequenceGenerator(name="my_seq", sequenceName="account_user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="my_seq")
	private Integer userId;
	 * 
	 * 
	 */

	@Column(name = "CODE")
	private String hotnewsCode;
    
	@Column(name = "HOT_NEWS_LINK")
	private String detail_url;
	
    public String getDetail_url() {
		return detail_url;
	}





	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}





	@Column(name = "VALID_FROM_DATE")
    private Date hotnewsValidFromDate;

    @Column(name = "VALID_TO_DATE")
    private Date hotnewsValidToDate;

    
	@Column(name = "EXT_CODE")
	private String hotnewsExtCode;

    @Column(name = "DESCRIPTION_EN")
    private String hotnewsDescEN;

    @Column(name = "DESCRIPTION_VI")
    private String hotnewsDescVI;

    @Column(name = "DETAILS_EN")
    private String hotnewsDetailEN;

    @Column(name = "DETAILS_VI")
    private String hotnewsDetailVI;

    @Column(name = "NAME_EN")
    private String hotnewsNameEN;

    @Column(name = "NAME_VI")
    private String hotnewsNameVI;

    @Column(name = "SHORT_DESC_EN")
    private String hotnewsShortDescEN;

    @Column(name = "SHORT_DESC_VI")
    private String hotnewsShortDescVI;    

    @Column(name = "DEFAULT_BANNER")
    private String hotnewsDefaultBanner;

    @Column(name = "DEFAULT_IMAGE")
    private String hotnewsDefaultImage;

    @Column(name = "DISPLAY_ORDER")
    private Integer hotnewsDisplayOrder;

    @Column(name = "SHORT_NAME")
    private String hotnewsShortName;

    @Column(name = "IS_VISIBLE")
    private Integer hotnewsIsVisible;
    
    @Column(name = "MYSELECT_LINK")
    String myselectLink;

    @Column(name = "STATUS")
    private Integer hotnewsStatus;

    @Column(name = "CREATE_TIMESTAMP")
    private Date hotnewsCreateTime;

    @Column(name = "CREATED_BY")
    private String hotnewsCreatedBy;

    @Column(name = "LAST_MODIFIED_BY")
    private String hotnewsModifiedBy;

    @Column(name = "LAST_MODIFIED_TIMESTAMP")
    private Date hotnewsLastModifiedTime;

	

	

	public HotNewsEntity() {
		super();
	}





	public Integer getHotnewsId() {
		return hotnewsId;
	}





	public void setHotnewsId(Integer hotnewsId) {
		this.hotnewsId = hotnewsId;
	}





	public String getHotnewsCode() {
		return hotnewsCode;
	}





	public void setHotnewsCode(String hotnewsCode) {
		this.hotnewsCode = hotnewsCode;
	}





	public Date getHotnewsValidFromDate() {
		return hotnewsValidFromDate;
	}





	public void setHotnewsValidFromDate(Date hotnewsValidFromDate) {
		this.hotnewsValidFromDate = hotnewsValidFromDate;
	}





	public Date getHotnewsValidToDate() {
		return hotnewsValidToDate;
	}





	public void setHotnewsValidToDate(Date hotnewsValidToDate) {
		this.hotnewsValidToDate = hotnewsValidToDate;
	}





	public String getHotnewsExtCode() {
		return hotnewsExtCode;
	}





	public void setHotnewsExtCode(String hotnewsExtCode) {
		this.hotnewsExtCode = hotnewsExtCode;
	}





	public String getHotnewsDescEN() {
		return hotnewsDescEN;
	}





	public void setHotnewsDescEN(String hotnewsDescEN) {
		this.hotnewsDescEN = hotnewsDescEN;
	}





	public String getHotnewsDescVI() {
		return hotnewsDescVI;
	}





	public void setHotnewsDescVI(String hotnewsDescVI) {
		this.hotnewsDescVI = hotnewsDescVI;
	}





	public String getHotnewsDetailEN() {
		return hotnewsDetailEN;
	}





	public void setHotnewsDetailEN(String hotnewsDetailEN) {
		this.hotnewsDetailEN = hotnewsDetailEN;
	}





	public String getHotnewsDetailVI() {
		return hotnewsDetailVI;
	}





	public void setHotnewsDetailVI(String hotnewsDetailVI) {
		this.hotnewsDetailVI = hotnewsDetailVI;
	}





	public String getHotnewsNameEN() {
		return hotnewsNameEN;
	}





	public void setHotnewsNameEN(String hotnewsNameEN) {
		this.hotnewsNameEN = hotnewsNameEN;
	}





	public String getHotnewsNameVI() {
		return hotnewsNameVI;
	}





	public void setHotnewsNameVI(String hotnewsNameVI) {
		this.hotnewsNameVI = hotnewsNameVI;
	}





	public String getHotnewsShortDescEN() {
		return hotnewsShortDescEN;
	}





	public void setHotnewsShortDescEN(String hotnewsShortDescEN) {
		this.hotnewsShortDescEN = hotnewsShortDescEN;
	}





	public String getHotnewsShortDescVI() {
		return hotnewsShortDescVI;
	}





	public void setHotnewsShortDescVI(String hotnewsShortDescVI) {
		this.hotnewsShortDescVI = hotnewsShortDescVI;
	}





	public String getHotnewsDefaultBanner() {
		return hotnewsDefaultBanner;
	}





	public void setHotnewsDefaultBanner(String hotnewsDefaultBanner) {
		this.hotnewsDefaultBanner = hotnewsDefaultBanner;
	}





	public String getHotnewsDefaultImage() {
		return hotnewsDefaultImage;
	}





	public void setHotnewsDefaultImage(String hotnewsDefaultImage) {
		this.hotnewsDefaultImage = hotnewsDefaultImage;
	}





	public Integer getHotnewsDisplayOrder() {
		return hotnewsDisplayOrder;
	}





	public void setHotnewsDisplayOrder(Integer hotnewsDisplayOrder) {
		this.hotnewsDisplayOrder = hotnewsDisplayOrder;
	}





	public String getHotnewsShortName() {
		return hotnewsShortName;
	}





	public void setHotnewsShortName(String hotnewsShortName) {
		this.hotnewsShortName = hotnewsShortName;
	}





	public Integer getHotnewsIsVisible() {
		return hotnewsIsVisible;
	}





	public void setHotnewsIsVisible(Integer hotnewsIsVisible) {
		this.hotnewsIsVisible = hotnewsIsVisible;
	}





	public String getMyselectLink() {
		return myselectLink;
	}





	public void setMyselectLink(String myselectLink) {
		this.myselectLink = myselectLink;
	}





	public Integer getHotnewsStatus() {
		return hotnewsStatus;
	}





	public void setHotnewsStatus(Integer hotnewsStatus) {
		this.hotnewsStatus = hotnewsStatus;
	}





	public Date getHotnewsCreateTime() {
		return hotnewsCreateTime;
	}





	public void setHotnewsCreateTime(Date hotnewsCreateTime) {
		this.hotnewsCreateTime = hotnewsCreateTime;
	}





	public String getHotnewsCreatedBy() {
		return hotnewsCreatedBy;
	}





	public void setHotnewsCreatedBy(String hotnewsCreatedBy) {
		this.hotnewsCreatedBy = hotnewsCreatedBy;
	}





	public String getHotnewsModifiedBy() {
		return hotnewsModifiedBy;
	}





	public void setHotnewsModifiedBy(String hotnewsModifiedBy) {
		this.hotnewsModifiedBy = hotnewsModifiedBy;
	}





	public Date getHotnewsLastModifiedTime() {
		return hotnewsLastModifiedTime;
	}





	public void setHotnewsLastModifiedTime(Date hotnewsLastModifiedTime) {
		this.hotnewsLastModifiedTime = hotnewsLastModifiedTime;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((detail_url == null) ? 0 : detail_url.hashCode());
		result = prime * result + ((hotnewsCode == null) ? 0 : hotnewsCode.hashCode());
		result = prime * result + ((hotnewsCreateTime == null) ? 0 : hotnewsCreateTime.hashCode());
		result = prime * result + ((hotnewsCreatedBy == null) ? 0 : hotnewsCreatedBy.hashCode());
		result = prime * result + ((hotnewsDefaultBanner == null) ? 0 : hotnewsDefaultBanner.hashCode());
		result = prime * result + ((hotnewsDefaultImage == null) ? 0 : hotnewsDefaultImage.hashCode());
		result = prime * result + ((hotnewsDescEN == null) ? 0 : hotnewsDescEN.hashCode());
		result = prime * result + ((hotnewsDescVI == null) ? 0 : hotnewsDescVI.hashCode());
		result = prime * result + ((hotnewsDetailEN == null) ? 0 : hotnewsDetailEN.hashCode());
		result = prime * result + ((hotnewsDetailVI == null) ? 0 : hotnewsDetailVI.hashCode());
		result = prime * result + ((hotnewsDisplayOrder == null) ? 0 : hotnewsDisplayOrder.hashCode());
		result = prime * result + ((hotnewsExtCode == null) ? 0 : hotnewsExtCode.hashCode());
		result = prime * result + ((hotnewsId == null) ? 0 : hotnewsId.hashCode());
		result = prime * result + ((hotnewsIsVisible == null) ? 0 : hotnewsIsVisible.hashCode());
		result = prime * result + ((hotnewsLastModifiedTime == null) ? 0 : hotnewsLastModifiedTime.hashCode());
		result = prime * result + ((hotnewsModifiedBy == null) ? 0 : hotnewsModifiedBy.hashCode());
		result = prime * result + ((hotnewsNameEN == null) ? 0 : hotnewsNameEN.hashCode());
		result = prime * result + ((hotnewsNameVI == null) ? 0 : hotnewsNameVI.hashCode());
		result = prime * result + ((hotnewsShortDescEN == null) ? 0 : hotnewsShortDescEN.hashCode());
		result = prime * result + ((hotnewsShortDescVI == null) ? 0 : hotnewsShortDescVI.hashCode());
		result = prime * result + ((hotnewsShortName == null) ? 0 : hotnewsShortName.hashCode());
		result = prime * result + ((hotnewsStatus == null) ? 0 : hotnewsStatus.hashCode());
		result = prime * result + ((hotnewsValidFromDate == null) ? 0 : hotnewsValidFromDate.hashCode());
		result = prime * result + ((hotnewsValidToDate == null) ? 0 : hotnewsValidToDate.hashCode());
		result = prime * result + ((myselectLink == null) ? 0 : myselectLink.hashCode());
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
		HotNewsEntity other = (HotNewsEntity) obj;
		if (detail_url == null) {
			if (other.detail_url != null)
				return false;
		} else if (!detail_url.equals(other.detail_url))
			return false;
		if (hotnewsCode == null) {
			if (other.hotnewsCode != null)
				return false;
		} else if (!hotnewsCode.equals(other.hotnewsCode))
			return false;
		if (hotnewsCreateTime == null) {
			if (other.hotnewsCreateTime != null)
				return false;
		} else if (!hotnewsCreateTime.equals(other.hotnewsCreateTime))
			return false;
		if (hotnewsCreatedBy == null) {
			if (other.hotnewsCreatedBy != null)
				return false;
		} else if (!hotnewsCreatedBy.equals(other.hotnewsCreatedBy))
			return false;
		if (hotnewsDefaultBanner == null) {
			if (other.hotnewsDefaultBanner != null)
				return false;
		} else if (!hotnewsDefaultBanner.equals(other.hotnewsDefaultBanner))
			return false;
		if (hotnewsDefaultImage == null) {
			if (other.hotnewsDefaultImage != null)
				return false;
		} else if (!hotnewsDefaultImage.equals(other.hotnewsDefaultImage))
			return false;
		if (hotnewsDescEN == null) {
			if (other.hotnewsDescEN != null)
				return false;
		} else if (!hotnewsDescEN.equals(other.hotnewsDescEN))
			return false;
		if (hotnewsDescVI == null) {
			if (other.hotnewsDescVI != null)
				return false;
		} else if (!hotnewsDescVI.equals(other.hotnewsDescVI))
			return false;
		if (hotnewsDetailEN == null) {
			if (other.hotnewsDetailEN != null)
				return false;
		} else if (!hotnewsDetailEN.equals(other.hotnewsDetailEN))
			return false;
		if (hotnewsDetailVI == null) {
			if (other.hotnewsDetailVI != null)
				return false;
		} else if (!hotnewsDetailVI.equals(other.hotnewsDetailVI))
			return false;
		if (hotnewsDisplayOrder == null) {
			if (other.hotnewsDisplayOrder != null)
				return false;
		} else if (!hotnewsDisplayOrder.equals(other.hotnewsDisplayOrder))
			return false;
		if (hotnewsExtCode == null) {
			if (other.hotnewsExtCode != null)
				return false;
		} else if (!hotnewsExtCode.equals(other.hotnewsExtCode))
			return false;
		if (hotnewsId == null) {
			if (other.hotnewsId != null)
				return false;
		} else if (!hotnewsId.equals(other.hotnewsId))
			return false;
		if (hotnewsIsVisible == null) {
			if (other.hotnewsIsVisible != null)
				return false;
		} else if (!hotnewsIsVisible.equals(other.hotnewsIsVisible))
			return false;
		if (hotnewsLastModifiedTime == null) {
			if (other.hotnewsLastModifiedTime != null)
				return false;
		} else if (!hotnewsLastModifiedTime.equals(other.hotnewsLastModifiedTime))
			return false;
		if (hotnewsModifiedBy == null) {
			if (other.hotnewsModifiedBy != null)
				return false;
		} else if (!hotnewsModifiedBy.equals(other.hotnewsModifiedBy))
			return false;
		if (hotnewsNameEN == null) {
			if (other.hotnewsNameEN != null)
				return false;
		} else if (!hotnewsNameEN.equals(other.hotnewsNameEN))
			return false;
		if (hotnewsNameVI == null) {
			if (other.hotnewsNameVI != null)
				return false;
		} else if (!hotnewsNameVI.equals(other.hotnewsNameVI))
			return false;
		if (hotnewsShortDescEN == null) {
			if (other.hotnewsShortDescEN != null)
				return false;
		} else if (!hotnewsShortDescEN.equals(other.hotnewsShortDescEN))
			return false;
		if (hotnewsShortDescVI == null) {
			if (other.hotnewsShortDescVI != null)
				return false;
		} else if (!hotnewsShortDescVI.equals(other.hotnewsShortDescVI))
			return false;
		if (hotnewsShortName == null) {
			if (other.hotnewsShortName != null)
				return false;
		} else if (!hotnewsShortName.equals(other.hotnewsShortName))
			return false;
		if (hotnewsStatus == null) {
			if (other.hotnewsStatus != null)
				return false;
		} else if (!hotnewsStatus.equals(other.hotnewsStatus))
			return false;
		if (hotnewsValidFromDate == null) {
			if (other.hotnewsValidFromDate != null)
				return false;
		} else if (!hotnewsValidFromDate.equals(other.hotnewsValidFromDate))
			return false;
		if (hotnewsValidToDate == null) {
			if (other.hotnewsValidToDate != null)
				return false;
		} else if (!hotnewsValidToDate.equals(other.hotnewsValidToDate))
			return false;
		if (myselectLink == null) {
			if (other.myselectLink != null)
				return false;
		} else if (!myselectLink.equals(other.myselectLink))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "HotNewsEntity [hotnewsId=" + hotnewsId + ", hotnewsCode=" + hotnewsCode + ", detail_url=" + detail_url
				+ ", hotnewsValidFromDate=" + hotnewsValidFromDate + ", hotnewsValidToDate=" + hotnewsValidToDate
				+ ", hotnewsExtCode=" + hotnewsExtCode + ", hotnewsDescEN=" + hotnewsDescEN + ", hotnewsDescVI="
				+ hotnewsDescVI + ", hotnewsDetailEN=" + hotnewsDetailEN + ", hotnewsDetailVI=" + hotnewsDetailVI
				+ ", hotnewsNameEN=" + hotnewsNameEN + ", hotnewsNameVI=" + hotnewsNameVI + ", hotnewsShortDescEN="
				+ hotnewsShortDescEN + ", hotnewsShortDescVI=" + hotnewsShortDescVI + ", hotnewsDefaultBanner="
				+ hotnewsDefaultBanner + ", hotnewsDefaultImage=" + hotnewsDefaultImage + ", hotnewsDisplayOrder="
				+ hotnewsDisplayOrder + ", hotnewsShortName=" + hotnewsShortName + ", hotnewsIsVisible="
				+ hotnewsIsVisible + ", myselectLink=" + myselectLink + ", hotnewsStatus=" + hotnewsStatus
				+ ", hotnewsCreateTime=" + hotnewsCreateTime + ", hotnewsCreatedBy=" + hotnewsCreatedBy
				+ ", hotnewsModifiedBy=" + hotnewsModifiedBy + ", hotnewsLastModifiedTime=" + hotnewsLastModifiedTime
				+ "]";
	}







	

	
    
    
}
