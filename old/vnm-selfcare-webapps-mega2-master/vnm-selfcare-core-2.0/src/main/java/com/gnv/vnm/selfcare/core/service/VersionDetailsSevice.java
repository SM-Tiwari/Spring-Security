package com.gnv.vnm.selfcare.core.service;
import com.gnv.vnm.selfcare.dao.entity.Version_DetailsEntity;
/**
 * This interface provides the VersionDetails for Version Details Service.
* @author  kuldeep Singh
* @version 1.0
* @since   2018-12-04
*/
public interface VersionDetailsSevice {
	int getAppFeaturesBasedOnMsisdn(String msisdn);
}
