/**
 * PushedCampaignController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.enums.NotificationStatus;
import com.gnv.vnm.selfcare.core.model.PushedCampaign;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.dao.entity.BazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QBazNotifcationStatusEntity;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.fcm.FCMClient;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.GetUnreadNotifCountResponse;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignDTO;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignRequest;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignResponse;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping (value = "/pushedcampaign")
public class PushedCampaignController extends BaseRestController {
	
//	private static final Logger logger = LoggerFactory.getLogger(PushedCampaignController.class);
	
	static final String DATE_FORMAT = "dd/MM/yyyy";
	
	@Autowired
	private FCMClient fcmClient;

	@PostMapping(value = "/submit")
	public ResponseEntity<?> pushedCampaign(@RequestBody PushedCampaignRequest request){
		if (request == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Date startDate = null;
		Date endDate = null;
		
		List<PushedCampaign> list = new ArrayList<>();

		try {
			for (PushedCampaignDTO req:request.getData()) {
				
				startDate = AppUtils.stringToDate(req.getStartDate(), DATE_FORMAT);
				endDate = AppUtils.stringToDate(req.getEndDate(), DATE_FORMAT);
				PushedCampaign campaign = new PushedCampaign(req.getTitleEN(), req.getDescriptionEN(),
						req.getDescriptionVI(), req.getTitleVI(), req.getDescriptionVI(), req.getDetailsVI(),
						req.getTargetedUser(), startDate, endDate);
				
				list.add(campaign);
			}
			
			pushedCampaignService.createCampaigns(list);
			return new ResponseEntity<>(
					new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message()),
					HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiResponse(true, DefaultApiResponse.INTERNAL_APP_ERROR.code(),
					DefaultApiResponse.INTERNAL_APP_ERROR.message()), HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/get/{msisdn}")
	public ResponseEntity<?> getPushedCampaigns(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		PushedCampaignResponse response = new PushedCampaignResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		
		List<PushedCampaignDTO> data = new ArrayList<>();
		//TODO filter only unread notif
		List<PushedCampaign> list = pushedCampaignService.getCampaigns(msisdn, null, new NotificationStatus[] { NotificationStatus.UNREAD }, null, 0);
		if (list != null) {
			for (PushedCampaign pc : list) {
				PushedCampaignDTO dto = new PushedCampaignDTO(pc.getTitleEN(), pc.getDescriptionEN(), pc.getDetailsEN(),
						pc.getTitleVI(), pc.getDescriptionVI(), pc.getDetailsVI(), pc.getTargetedUser(),
						AppUtils.dateToString(pc.getStartDate(), DATE_FORMAT),
						AppUtils.dateToString(pc.getEndDate(), DATE_FORMAT));
				dto.setId(pc.getId());
				
				data.add(dto);
			}
		}
		response.setData(data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/getbazstatus/{msisdn}/{readstatus}")
	public ResponseEntity<?> getBazStatus(@PathVariable("msisdn") String msisdn,@PathVariable("readstatus") String readstatus){
		ApiResponse response = null;
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		boolean  version_details=backEndRequestProcessor.savebaznotificationDetails(msisdn,readstatus,"MOBILE_APP");
		 
	  //BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
	 if(version_details==true)
	 {
		  response = new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
	 }
	 else{
		   response = new ApiResponse(true, DefaultApiResponse.FAIL.code(), DefaultApiResponse.FAIL.message());
	 }
		return ResponseEntity.ok(response);
	}*/
	@GetMapping(value = "/getbazstatus/{msisdn}/{readstatus}/{readcount}")
	public ResponseEntity<?> getBazStatus(@PathVariable("msisdn") String msisdn,
			@PathVariable("readstatus") String readstatus,@PathVariable("readcount") String readcount) {
		ApiResponse response = null;
		/*if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}*/
		boolean version_details = backEndRequestProcessor.savebaznotificationDetails(msisdn, readstatus,readcount, "MOBILE_APP");

		// BazNotifcationStatusEntity recipient =
		// this.bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
		if (version_details == true) {
			response = new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		} else {
			response = new ApiResponse(true, DefaultApiResponse.FAIL.code(), DefaultApiResponse.FAIL.message());
		}
		return ResponseEntity.ok(response);
	}


	
	@GetMapping(value = "/getcount/{msisdn}")
	public ResponseEntity<?> getPushedCampaignStatus(@PathVariable String msisdn){
		
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		
		PushedCampaignResponse response = new PushedCampaignResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		
		List<PushedCampaignDTO> data = new ArrayList<>();
		//TODO filter only unread notif
		List<PushedCampaign> list = pushedCampaignService.getCampaigns(msisdn, null, new NotificationStatus[] { NotificationStatus.UNREAD }, null, 0);
		if (list != null) {
			for (PushedCampaign pc : list) {
				PushedCampaignDTO dto = new PushedCampaignDTO(pc.getTitleEN(), pc.getDescriptionEN(), pc.getDetailsEN(),
						pc.getTitleVI(), pc.getDescriptionVI(), pc.getDetailsVI(), pc.getTargetedUser(),
						AppUtils.dateToString(pc.getStartDate(), DATE_FORMAT),
						AppUtils.dateToString(pc.getEndDate(), DATE_FORMAT));
				dto.setId(pc.getId());
				
				data.add(dto);
			}
		}
		response.setData(data);
		//BazNotifcationStatusEntity bazNotifcationStatusEntity = bazNotifcationStatusRepository.findOne(QPushedCampaignEntity.pushedCampaignEntity.createTimestamp.desc());
		BazNotifcationStatusEntity recipient = this.bazNotifcationStatusRepository.findOne(QBazNotifcationStatusEntity.bazNotifcationStatusEntity.msisdn.eq(msisdn));
		if(recipient!=null){
		String datamsisdn=recipient.getNotification_status();
		response.setReadstatus(Integer.parseInt(datamsisdn));
		}else{
			response.setReadstatus(0);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping(value = "/get")
	public ResponseEntity<?> getAllPushedCampaigns(){
		
		PushedCampaignResponse response = new PushedCampaignResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());

		List<PushedCampaignDTO> data = new ArrayList<>();
		List<PushedCampaign> list = pushedCampaignService.getCampaigns(null, null, null, 0);
		if (list != null) {
			for (PushedCampaign pc : list) {
				PushedCampaignDTO dto = new PushedCampaignDTO(pc.getTitleEN(), pc.getDescriptionEN(), pc.getDetailsEN(),
						pc.getTitleVI(), pc.getDescriptionVI(), pc.getDetailsVI(), pc.getTargetedUser(),
						AppUtils.dateToString(pc.getStartDate(), DATE_FORMAT),
						AppUtils.dateToString(pc.getEndDate(), DATE_FORMAT));
				dto.setId(pc.getId());
				
				data.add(dto);
			}
		}
		response.setData(data);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/unreadcount/{msisdn}")
	public ResponseEntity<?> getUnreadNotifCount(@PathVariable String msisdn){
		
		/*
		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
				    DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}
		*/
		
		GetUnreadNotifCountResponse response = new GetUnreadNotifCountResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		response.setCount(pushedCampaignService.getUnreadCampaignCount(msisdn));
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/setreadall/{msisdn}")
	public ResponseEntity<?> setAllReadAll(@PathVariable String msisdn){
		pushedCampaignService.setCampaignStatus(msisdn, NotificationStatus.READ.ordinal());
		ApiResponse response = new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		return ResponseEntity.ok(response);
	}
	
	//TODO remove this API when going live
	@GetMapping(value = "/sendmsg/{msisdn}")
	public ResponseEntity<?> pushMessageToDevice(@PathVariable String msisdn,
			@RequestParam (defaultValue = "") String title,
			@RequestParam (defaultValue = "") String message,
			@RequestParam (defaultValue = "") String badge){
		
		int count = fcmClient.pushInstantMessage(msisdn, title, message, badge);
		ApiResponse response = null;
		if (count > 0) {
			response = new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		} else {
			response = new ApiResponse(false, DefaultApiResponse.NO_MESSAGE_TO_SEND.code(), DefaultApiResponse.NO_MESSAGE_TO_SEND.message());
		}
		return ResponseEntity.ok(response);
	}
}
