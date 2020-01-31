package com.gnv.vnm.selfcare.core.service;

import java.sql.SQLException;
import java.util.List;

import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.MicInformation;
import com.gnv.vnm.selfcare.core.model.MicInformationView;
import com.gnv.vnm.selfcare.dao.entity.MicStatusEntity;
 

public interface MicInformationService {

	MicInformation saveMicDocumentByMobile(String firstNmae, String lastName, String dob, String idCard,
			String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
			String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait, String customerSignature)throws SubscriberNotFoundException;
	
	List<MicInformationView> viewMicDocument(String msisdn);
	
	MicInformation editMicDocumentByMobile(String firstNmae, String lastName, String dob, String idCard,
			String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
			String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait, String customerSignature);
	String getMicStatus(String msisdn) throws SQLException;
	//boolean saveMicStatus(String msisdn,String subscriber_id,String status);
	MicInformation viewwebDocument(String msisdn);

	//add gender features by oneclick
	String saveMicDocument(String firstNmae, String lastName, String dob, String idCard, String date_of_issue,
			String placeOfIssue, String address, String province, String district, String country, String msisdn,
			String firstSideIdcard, String secondSideIdcard, String customerPortrait, String customerSignature, String gender)
			throws SubscriberNotFoundException;
	
	MicStatusEntity saveMicStatusBymobile(String msisdn,String subscriber_id,String status);

	boolean saveMicStatus(String msisdn, String subscriber_id, String status);

	String getDevMicStatus(String msisdn);

	
	//add new method for gender features by oneclick
	MicInformation saveMicDocumentByMobilewithGender(String firstNmae, String lastName, String dob, String idCard,
			String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
			String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
			String customerSignature, String gender) throws SubscriberNotFoundException;
	
}
