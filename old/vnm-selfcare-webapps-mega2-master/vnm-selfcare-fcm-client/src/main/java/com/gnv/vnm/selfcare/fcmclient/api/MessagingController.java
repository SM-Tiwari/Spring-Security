/**
 * Jun 12, 2018 11:19:47 AM
 */
package com.gnv.vnm.selfcare.fcmclient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.fcmclient.FcmNotificationSender;

/**
 * @author nandipinto
 *
 */

@RestController
public class MessagingController {

	@Autowired
	private FcmNotificationSender fcmNotificationSender;
	
	@GetMapping(value = "/sendmsg/{msisdn}")
	public ResponseEntity<?> pushMessageToDevice(@PathVariable String msisdn,
			@RequestParam (defaultValue = "") String title,
			@RequestParam (defaultValue = "") String message,
			@RequestParam (defaultValue = "") String badge){
		
		int count = fcmNotificationSender.pushInstantMessage(msisdn, title, message, badge);
		ApiResponse response = null;
		if (count > 0) {
			response = new ApiResponse(true, DefaultApiResponse.SUCCESS.code(), DefaultApiResponse.SUCCESS.message());
		} else {
			response = new ApiResponse(false, DefaultApiResponse.ERROR.code(), DefaultApiResponse.ERROR.message());
		}
		return ResponseEntity.ok(response);
	}
	
}
