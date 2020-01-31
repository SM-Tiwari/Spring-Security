package com.gnv.vnm.selfcare.core.service.impl;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gnv.vnm.selfcare.core.service.VersionDetailsSevice;
import com.gnv.vnm.selfcare.dao.entity.AppFeaturesEntity;
import com.gnv.vnm.selfcare.dao.entity.LoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QAppFeaturesEntity;
import com.gnv.vnm.selfcare.dao.entity.QLoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QVersion_DetailsEntity;
import com.gnv.vnm.selfcare.dao.entity.Version_DetailsEntity;
import com.gnv.vnm.selfcare.dao.repo.AppFeaturesRepository;
import com.gnv.vnm.selfcare.dao.repo.VersionUpdateRepository;
import com.gnv.vnm.selfcare.dao.repo.Version_DetailsRepository;
/**
 * This Class used for get version details etc..
* @author  kuldeep Singh
* @version 1.0
* @since   2018-12-04
*/
@Service("versionDeatilsService")
public class VersionDetailsImpl implements VersionDetailsSevice {

  static final Logger logger = LoggerFactory.getLogger(VersionDetailsImpl.class);
  
  @Autowired
  Version_DetailsRepository versionDetailsRepository;
  
  @Autowired
  AppFeaturesRepository appFeaturesRepository;
	@Override
	public int getAppFeaturesBasedOnMsisdn(String msisdn) {
		// TODO Auto-generated method stub
		int status=0;
		try
		{
			logger.info("Inside VersionDetailsImpl in getLatestVersionBasedOnMsisdn method :::::");
            
			Version_DetailsEntity version_DetailsEntity = versionDetailsRepository
					.findOne((QVersion_DetailsEntity.version_DetailsEntity.loginId.eq(msisdn)));
			if(version_DetailsEntity!=null)
			{
				AppFeaturesEntity appfeature=appFeaturesRepository.findOne(QAppFeaturesEntity.appFeaturesEntity.featureName.eq("entertainment"));
				if(version_DetailsEntity.getApp_os().equalsIgnoreCase("ios") && (appfeature!=null))
				{
					status=appfeature.getStatusForIos();
					return status;
				}
				if(version_DetailsEntity.getApp_os().equalsIgnoreCase("android") && (appfeature!=null))
				{
					status=appfeature.getStatusForAndroid();
					return status;
				}
			}	
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("#VersionDetailsImpl --- error retrieving get latest version based on msisdn!", e);
		}
		return status;
	}

}
