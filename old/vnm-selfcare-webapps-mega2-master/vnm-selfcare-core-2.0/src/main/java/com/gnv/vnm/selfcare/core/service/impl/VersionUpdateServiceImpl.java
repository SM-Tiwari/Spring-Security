package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gnv.vnm.selfcare.core.model.MicInformationView;
import com.gnv.vnm.selfcare.core.model.VersionUpdate;
import com.gnv.vnm.selfcare.core.service.VersionDetailsSevice;
import com.gnv.vnm.selfcare.core.service.VersionUpdateService;
import com.gnv.vnm.selfcare.dao.entity.AppFeaturesEntity;
import com.gnv.vnm.selfcare.dao.entity.MicInformationEntity;
import com.gnv.vnm.selfcare.dao.entity.QAppFeaturesEntity;
import com.gnv.vnm.selfcare.dao.entity.QMicInformationEntity;
import com.gnv.vnm.selfcare.dao.entity.QVersionUpdateEntity;
import com.gnv.vnm.selfcare.dao.entity.VersionUpdateEntity;
import com.gnv.vnm.selfcare.dao.repo.AppFeaturesRepository;
import com.gnv.vnm.selfcare.dao.repo.MicInformationRepository;
import com.gnv.vnm.selfcare.dao.repo.VersionUpdateRepository;


@Service("versionUpdateService")
public class VersionUpdateServiceImpl implements VersionUpdateService {

	 static final Logger logger = LoggerFactory.getLogger(VersionUpdateServiceImpl.class);
	   @Autowired
       VersionUpdateRepository versionUpdateRepository;
	   
	   
	   
	   @Autowired
	   AppFeaturesRepository appFeaturesRepository;
	
	@Override
	public List<VersionUpdate> viewVersionUpdate(String appVersion, String os) {
	      List<VersionUpdate> versionList = new ArrayList<VersionUpdate>();
          
          try {
                          Iterable<VersionUpdateEntity> list = versionUpdateRepository.findAll(QVersionUpdateEntity.versionUpdateEntity.osType.eq(os));
                          for (VersionUpdateEntity se : list){
                        	  versionList.add(fromVersionUpdate(se));
                          }
          } catch (Exception e) {
                          logger.error("#viewVersionUpdate --- error retrieving Update Version!", e);
          }
          return versionList;
		
	}
	
	
	   private VersionUpdate fromVersionUpdate(VersionUpdateEntity source){
			int status=0;
		   AppFeaturesEntity appfeature=appFeaturesRepository.findOne(QAppFeaturesEntity.appFeaturesEntity.featureName.eq("entertainment"));
			if((source.getOsType()!=null)&&source.getOsType().equalsIgnoreCase("ios") && (appfeature!=null))
			{
				status=appfeature.getStatusForIos();
			}
			if((source.getOsType()!=null)&&source.getOsType().equalsIgnoreCase("android") && (appfeature!=null))
			{
				status=appfeature.getStatusForAndroid();
			}
		   VersionUpdate versionUpdate = new VersionUpdate(source.getBundleIdentifier(), source.getCurrentVersion(), source.getUpdateVersion(), source.getIsUpdate(),
                                           source.getIsMandatory(), source.getOsType(), source.getAppUpdateURL(),status);
           
           return versionUpdate;       
}


	

}
