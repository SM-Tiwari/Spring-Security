package com.gnv.vnm.selfcare.core.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SocialMediaIntegration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6242556566283480633L;
	
	
	private String msisdn;
	
	
	private String share_os_type;
	
	
	private Integer media_count_sucess;
	
	
	private Integer media_count_fail;
	
	
	private Integer share_product_id;
	
	
	private String share_product_deatils;
	
	
	private String social_media_name;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getShare_os_type() {
		return share_os_type;
	}

	public void setShare_os_type(String share_os_type) {
		this.share_os_type = share_os_type;
	}

	public Integer getMedia_count_sucess() {
		return media_count_sucess;
	}

	public void setMedia_count_sucess(Integer media_count_sucess) {
		this.media_count_sucess = media_count_sucess;
	}

	public Integer getMedia_count_fail() {
		return media_count_fail;
	}

	public void setMedia_count_fail(Integer media_count_fail) {
		this.media_count_fail = media_count_fail;
	}

	public Integer getShare_product_id() {
		return share_product_id;
	}

	public void setShare_product_id(Integer share_product_id) {
		this.share_product_id = share_product_id;
	}

	public String getShare_product_deatils() {
		return share_product_deatils;
	}

	public void setShare_product_deatils(String share_product_deatils) {
		this.share_product_deatils = share_product_deatils;
	}

	

	
	public String getSocial_media_name() {
		return social_media_name;
	}

	public void setSocial_media_name(String social_media_name) {
		this.social_media_name = social_media_name;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((media_count_fail == null) ? 0 : media_count_fail.hashCode());
		result = prime * result + ((media_count_sucess == null) ? 0 : media_count_sucess.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((share_os_type == null) ? 0 : share_os_type.hashCode());
		result = prime * result + ((share_product_deatils == null) ? 0 : share_product_deatils.hashCode());
		result = prime * result + ((share_product_id == null) ? 0 : share_product_id.hashCode());
		result = prime * result + ((social_media_name == null) ? 0 : social_media_name.hashCode());
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
		SocialMediaIntegration other = (SocialMediaIntegration) obj;
		if (media_count_fail == null) {
			if (other.media_count_fail != null)
				return false;
		} else if (!media_count_fail.equals(other.media_count_fail))
			return false;
		if (media_count_sucess == null) {
			if (other.media_count_sucess != null)
				return false;
		} else if (!media_count_sucess.equals(other.media_count_sucess))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (share_os_type == null) {
			if (other.share_os_type != null)
				return false;
		} else if (!share_os_type.equals(other.share_os_type))
			return false;
		if (share_product_deatils == null) {
			if (other.share_product_deatils != null)
				return false;
		} else if (!share_product_deatils.equals(other.share_product_deatils))
			return false;
		if (share_product_id == null) {
			if (other.share_product_id != null)
				return false;
		} else if (!share_product_id.equals(other.share_product_id))
			return false;
		if (social_media_name == null) {
			if (other.social_media_name != null)
				return false;
		} else if (!social_media_name.equals(other.social_media_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SocialMediaIntegration [msisdn=" + msisdn + ", share_os_type=" + share_os_type + ", media_count_sucess="
				+ media_count_sucess + ", media_count_fail=" + media_count_fail + ", share_product_id="
				+ share_product_id + ", share_product_deatils=" + share_product_deatils + ", social_media_name="
				+ social_media_name + "]";
	}

	public SocialMediaIntegration() {
		super();
	}

	
	

}
