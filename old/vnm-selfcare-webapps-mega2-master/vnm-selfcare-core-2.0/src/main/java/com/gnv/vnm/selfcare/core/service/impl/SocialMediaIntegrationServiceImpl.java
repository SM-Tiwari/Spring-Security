package com.gnv.vnm.selfcare.core.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnv.vnm.selfcare.core.model.SocialMediaIntegration;
import com.gnv.vnm.selfcare.core.service.SocialMediaIntegrationService;
import com.gnv.vnm.selfcare.dao.entity.QSocialMediaIntegrationEntity;
import com.gnv.vnm.selfcare.dao.entity.SocialMediaIntegrationEntity;
import com.gnv.vnm.selfcare.dao.repo.SocialMediaIntegrationRepositry;

@Service("socialMediaIntegrationService")
public class SocialMediaIntegrationServiceImpl implements SocialMediaIntegrationService{

	@Autowired
	private SocialMediaIntegrationRepositry socialMediaIntegrationRepositry;

	@Override
	public String getShareStatus(String msisdn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getShareCount(String msisdn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveSocialMediaIntegration(String msisdn, String share_os_type,
			Integer media_count_sucess, Integer media_count_fail, Integer share_product_id,
			String share_product_deatils, String social_media_name) {
		boolean status=false;
		
		
		List<SocialMediaIntegrationEntity> socialMediaIntegrationEntities = new ArrayList<SocialMediaIntegrationEntity>();
		
		SocialMediaIntegrationEntity sEntity = new SocialMediaIntegrationEntity();
		sEntity.setMsisdn(msisdn);
		sEntity.setShare_os_type(share_os_type);
		sEntity.setMedia_count_sucess(media_count_sucess);
		sEntity.setMedia_count_fail(media_count_fail);
		sEntity.setShare_product_id(share_product_id);
		sEntity.setShare_product_deatils(share_product_deatils);
		sEntity.setSocial_media_name(social_media_name);
		sEntity.setCreatedBy("Admin");
		sEntity.setLastModifiedTime(new Date());
		sEntity.setCreateTimestamp(new Date());
		sEntity.setLastModifiedBy("Admin");
		
		socialMediaIntegrationEntities.add(sEntity);
		
		try
		{
		socialMediaIntegrationRepositry.save(socialMediaIntegrationEntities);
		status=true;
		
		}
		catch (Exception e) {
			status=false;
			e.printStackTrace();
			
		}
		
		return status;
	}

	
}
