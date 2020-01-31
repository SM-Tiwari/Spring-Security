package com.gnv.vnm.selfcare.webapi.test;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.httpclient.Header;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.vnm.selfcare.core.utils.HttpResponseWrapper;
import com.gnv.vnm.selfcare.core.utils.HttpSessionManager;
import com.gnv.vnm.selfcare.webapi.fcm.FcmMessage;
import com.gnv.vnm.selfcare.webapi.fcm.FcmNotification;
import com.gnv.vnm.selfcare.webapi.fcm.FcmResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class FcmClientTest {

	static final String SERVICE_ACCOUNT_FILE = "myvietnamobile-563a0-firebase-adminsdk-9vr6l-49a3fc1b85.json"; 
	static final String[] SCOPES = new String[] { "https://www.googleapis.com/auth/firebase.messaging" };
	
//	static final String token = "f0lvxLKK2Mo:APA91bFs95fO0FA0BypenlHikQYCYgSO_VHEEC6nka4CVV0onrp-FbVExkaQ3oVLyfdlNjRV51_mSs80oz_XY98YoVoZUxvOCMeARyU2H-O7fG5VbhDzRiiJoYecw_Qefp1NdoRlX506";
	//eKibFNP9j0g:APA91bFIW7QqKXI3AF4CF9SvbZHQ2XyknVMDofGmrzyF-WmdeDi-F-gBTPB4CCEdZG-l7QR-0-_AkoqapLjb_Zq_XfMqi-1SnsLa4hTB1AYSUCqI1pzmyg2yGRSm49WzmOYR6wJSZNxc
	//cagEIj1D4pk:APA91bFKgGa4XdCntzQtJ8oHYYHlneOZr7KN3m4wCZYdO2AboPbE_Kx_QzFXygC1SAynxXM-qqufjcFU3fnMcbJXOweCW8lOIxQeYL5qcE5rwCGdZChDIZC3MEN2WY68zPGlc1tAaNk8
	static final String token = "cagEIj1D4pk:APA91bFKgGa4XdCntzQtJ8oHYYHlneOZr7KN3m4wCZYdO2AboPbE_Kx_QzFXygC1SAynxXM-qqufjcFU3fnMcbJXOweCW8lOIxQeYL5qcE5rwCGdZChDIZC3MEN2WY68zPGlc1tAaNk8";
	
	//dhcJxIOgf6c:APA91bEcfIgTDc5oemTzo517A6bpf10Vss6Akw--zNrNkFkLhLWtY1MdaUimWL1QCSlDOFxdo6ogCJcpm-uM9zWGwa2PW6ARr2L27fz1_VH31YN_tVmbd7Lwv68L92949uqbOC50Je5b
	
	static final String projectId = "myvietnamobile-563a0";
	static final String serverKey = "AAAA-V9ZWow:APA91bGxEZ6UaAfdQmJ9C2p4Bf9A9MZTbZ9AJ-nj8y6T135VXdPZBkluj7R3TEI6kM5MBhnx5j6FKueaetrOC5WHD7_m8a3wPzF27i-khBpZ7-8sJ2prBQRyW1bypX2qo9RzKM6Ftz6s";
	
//	private static String _ENDPOINT = "https://fcm.googleapis.com/fcm/send"; 
	private static String _ENDPOINT = "https://fcm.googleapis.com/v1/projects/" + projectId + "/messages:send";
	private static String SEND_BADGE_ENDPOINT = "https://fcm.googleapis.com/fcm/send";
	
	private static Header[] pushMessageHeaders = null;
	
	public static void main(String[] args) {


//		FcmNotification notification = new FcmNotification("Test Notif", "This is a test notification");
//		FcmNotificationWrapper wrapper = new FcmNotificationWrapper();
//		wrapper.setNotification(notification);
//		wrapper.setToken(token);
//		FcmMessage message = new FcmMessage();
//		message.setMessage(wrapper);
		
		FcmNotification notification = new FcmNotification("Test Notif 99", "This is a test notification 99");
		notification.setBadge("2");
		
		FcmMessage message = new FcmMessage(notification, token);

		HttpSessionManager mgr = HttpSessionManager.getInstance(10000, 10000, 1, true);
		try {
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(message);
			System.out.println(json);
			
			Header headers[] = new Header[] {
					new Header("Content-Type", "application/json"),
					new Header("Authorization", "Bearer " + getAccessToken())
//					new Header("Authorization", "key=" + serverKey)
			};
			
			//cagEIj1D4pk:APA91bFKgGa4XdCntzQtJ8oHYYHlneOZr7KN3m4wCZYdO2AboPbE_Kx_QzFXygC1SAynxXM-qqufjcFU3fnMcbJXOweCW8lOIxQeYL5qcE5rwCGdZChDIZC3MEN2WY68zPGlc1tAaNk8
			String json1 = "{\n" + 
					"    \"message\": {\n" + 
					"        \"token\": \"dhcJxIOgf6c:APA91bEcfIgTDc5oemTzo517A6bpf10Vss6Akw--zNrNkFkLhLWtY1MdaUimWL1QCSlDOFxdo6ogCJcpm-uM9zWGwa2PW6ARr2L27fz1_VH31YN_tVmbd7Lwv68L92949uqbOC50Je5b\",\n" + 
					"        \"notification\": {\n" + 
					"            \"title\": \"Test Notif 123\",\n" + 
					"            \"body\": \"This is a test notification 123\"\n" + 
					"        },\n" + 
					"        \"data\":{\n" + 
					"            \"badge\": \"99\"\n" + 
					"        }\n" + 
					"        \n" + 
					"    }\n" + 
					"}";
			HttpResponseWrapper resp = mgr.post(_ENDPOINT, json1, "application/json", headers);
			System.out.println(resp);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		try {
			String input = "{ \"multicast_id\": 8001484337473437177, \"success\": 0, \"failure\": 2, \"canonical_ids\": 0, \"results\": [{\"error\": \"NotRegistered\"},{\"error\": \"NotRegistered\"}] }";
			ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			FcmResponse f = om.readValue(input, FcmResponse.class);
			System.out.println(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Header[] getPushMessageHeaders() throws Exception {
		if (pushMessageHeaders == null) {
			pushMessageHeaders = new Header[] {
					new Header("Content-Type", "application/json"),
					new Header("Authorization", "Bearer " + getAccessToken())
			};
		}
		return pushMessageHeaders;
	}

	private static String getAccessToken() throws IOException {
		GoogleCredential googleCredential = GoogleCredential.fromStream(FcmClientTest.class.getClassLoader().getResourceAsStream(SERVICE_ACCOUNT_FILE))
				.createScoped(Arrays.asList(SCOPES));
		googleCredential.refreshToken();
		return googleCredential.getAccessToken();
	}


}
