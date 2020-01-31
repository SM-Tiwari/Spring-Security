package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gnv.vnm.selfcare.core.enums.DataStatus;

public class PopupBannner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6513467105664727126L;
	
	private Integer id = -1;
	private String code = "";
	@JsonIgnore
	private String alias = "";
	private String name = "";
	private String description = "";
	private String details = "";	
	private DataStatus status = DataStatus.INACTIVE;	
	@JsonIgnore
	private String smallIcon = "";
	@JsonIgnore
	private String mediumIcon = "";
	@JsonIgnore
	private String largeIcon = "";
	@JsonIgnore
	private String xlargeIcon = "";
	private String smallImage = "";
	private String mediumImage = "";
	private String largeImage = "";
	private String xlargeImage = "";
	private String defaultImage = "";
	private String detail_url = "";
	private int popbannerorder;
	public int getPopbannerorder() {
		return popbannerorder;
	}
	public void setPopbannerorder(int popbannerorder) {
		this.popbannerorder = popbannerorder;
	}
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
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
	public DataStatus getStatus() {
		return status;
	}
	public void setStatus(DataStatus status) {
		this.status = status;
	}
	public String getSmallIcon() {
		return smallIcon;
	}
	public void setSmallIcon(String smallIcon) {
		this.smallIcon = smallIcon;
	}
	public String getMediumIcon() {
		return mediumIcon;
	}
	public void setMediumIcon(String mediumIcon) {
		this.mediumIcon = mediumIcon;
	}
	public String getLargeIcon() {
		return largeIcon;
	}
	public void setLargeIcon(String largeIcon) {
		this.largeIcon = largeIcon;
	}
	public String getXlargeIcon() {
		return xlargeIcon;
	}
	public void setXlargeIcon(String xlargeIcon) {
		this.xlargeIcon = xlargeIcon;
	}
	public String getSmallImage() {
		return smallImage;
	}
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}
	public String getMediumImage() {
		return mediumImage;
	}
	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}
	public String getLargeImage() {
		return largeImage;
	}
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	public String getXlargeImage() {
		return xlargeImage;
	}
	public void setXlargeImage(String xlargeImage) {
		this.xlargeImage = xlargeImage;
	}
	public String getDefaultImage() {
		return defaultImage;
	}
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage;
	}
	
	
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((defaultImage == null) ? 0 : defaultImage.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((detail_url == null) ? 0 : detail_url.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((largeIcon == null) ? 0 : largeIcon.hashCode());
		result = prime * result + ((largeImage == null) ? 0 : largeImage.hashCode());
		result = prime * result + ((mediumIcon == null) ? 0 : mediumIcon.hashCode());
		result = prime * result + ((mediumImage == null) ? 0 : mediumImage.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((smallIcon == null) ? 0 : smallIcon.hashCode());
		result = prime * result + ((smallImage == null) ? 0 : smallImage.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((xlargeIcon == null) ? 0 : xlargeIcon.hashCode());
		result = prime * result + ((xlargeImage == null) ? 0 : xlargeImage.hashCode());
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
		PopupBannner other = (PopupBannner) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (defaultImage == null) {
			if (other.defaultImage != null)
				return false;
		} else if (!defaultImage.equals(other.defaultImage))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (detail_url == null) {
			if (other.detail_url != null)
				return false;
		} else if (!detail_url.equals(other.detail_url))
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
		if (largeIcon == null) {
			if (other.largeIcon != null)
				return false;
		} else if (!largeIcon.equals(other.largeIcon))
			return false;
		if (largeImage == null) {
			if (other.largeImage != null)
				return false;
		} else if (!largeImage.equals(other.largeImage))
			return false;
		if (mediumIcon == null) {
			if (other.mediumIcon != null)
				return false;
		} else if (!mediumIcon.equals(other.mediumIcon))
			return false;
		if (mediumImage == null) {
			if (other.mediumImage != null)
				return false;
		} else if (!mediumImage.equals(other.mediumImage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (smallIcon == null) {
			if (other.smallIcon != null)
				return false;
		} else if (!smallIcon.equals(other.smallIcon))
			return false;
		if (smallImage == null) {
			if (other.smallImage != null)
				return false;
		} else if (!smallImage.equals(other.smallImage))
			return false;
		if (status != other.status)
			return false;
		if (xlargeIcon == null) {
			if (other.xlargeIcon != null)
				return false;
		} else if (!xlargeIcon.equals(other.xlargeIcon))
			return false;
		if (xlargeImage == null) {
			if (other.xlargeImage != null)
				return false;
		} else if (!xlargeImage.equals(other.xlargeImage))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "PopupBannner [id=" + id + ", code=" + code + ", alias=" + alias + ", name=" + name + ", description="
				+ description + ", details=" + details + ", status=" + status + ", smallIcon=" + smallIcon
				+ ", mediumIcon=" + mediumIcon + ", largeIcon=" + largeIcon + ", xlargeIcon=" + xlargeIcon
				+ ", smallImage=" + smallImage + ", mediumImage=" + mediumImage + ", largeImage=" + largeImage
				+ ", xlargeImage=" + xlargeImage + ", defaultImage=" + defaultImage + ", detail_url=" + detail_url
				+ "]";
	}
	public PopupBannner() {
		super();
	}
	
	public PopupBannner(Integer id, String code, String name, String description, String details, DataStatus status) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.details = details;
		this.status = status;
		
	}
	
	
	
}
