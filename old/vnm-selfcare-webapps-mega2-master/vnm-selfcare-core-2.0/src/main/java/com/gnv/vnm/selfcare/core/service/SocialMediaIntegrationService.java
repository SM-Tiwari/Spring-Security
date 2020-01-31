package com.gnv.vnm.selfcare.core.service;

import java.sql.SQLException;

import com.gnv.vnm.selfcare.core.model.SocialMediaIntegration;


public interface SocialMediaIntegrationService {
	
	String getShareStatus(String msisdn) throws SQLException;
	
	String getShareCount(String msisdn) throws SQLException;
	
	boolean saveSocialMediaIntegration(String msisdn,String share_os_type,Integer media_count_sucess,Integer media_count_fail,Integer share_product_id,String share_product_deatils, String social_media_name);

}
