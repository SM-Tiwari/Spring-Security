package com.gnv.vnm.selfcare.webapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.DataSharingRequest;
import com.gnv.vnm.selfcare.webapi.model.GetLmsPointResponse;
import com.gnv.vnm.selfcare.webapi.model.InviteMemberRequest;
import com.gnv.vnm.selfcare.webapi.model.LmsParam;
import com.gnv.vnm.selfcare.webapi.model.NearbyStoreListRequest;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignDTO;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignRequest;
import com.gnv.vnm.selfcare.webapi.model.PushedCampaignStatus;
import com.gnv.vnm.selfcare.webapi.model.RedeemLmsPointRequest;
import com.gnv.vnm.selfcare.webapi.model.RegisterSubscriberRequest;
import com.gnv.vnm.selfcare.webapi.model.SelfPackageBalance;
import com.gnv.vnm.selfcare.webapi.model.SelfPackageRequest;
import com.gnv.vnm.selfcare.webapi.model.UpdatePushedCampaignStatusRequest;
import com.gnv.vnm.selfcare.webapi.model.UploadAvatarResponse;
import com.gnv.vnm.selfcare.webapi.model.ValidateNumberRequest;

public class DummyTest {
	
	
	public static String stripCountryCode(String msisdn){
		String countryCode = "84";
		
		if (msisdn.startsWith(countryCode)){
			return "0" + msisdn.substring(msisdn.indexOf(countryCode) + countryCode.length());
		}
		return msisdn.startsWith("0") ? msisdn : "0" + msisdn;
	}

	public static void main(String[] args) {
		
		System.out.println(Double.parseDouble("123.544"));
		System.out.println("123,456.78".replaceAll(",", ""));
		
//		String regex = "((?=.*\\\\d)(?=.*[a-zA-Z]).{8,})";
//		System.out.println(Pattern.matches(regex, null));
		
		System.exit(0);
		
//		String reqString = "{\"requestId\":null,\"requestType\":\"UPDATE\",\"timeStamp\":1496376534135,\"langCode\":\"vi\",\"msisdn\":\"0922000512\",\"monsters\":[{\"itemID\":\"402003\",\"num\":\"1\"}],\"trxId\":\"1496376534136\"}";
//		System.out.println(pass.matches(regex));
		
		String ds = "{\n" + 
				"	\"msisdn\": \"01888044003\",\n" + 
				"	\"packageId\": \"103\",\n" + 
				"	\"members\": [\n" + 
				"		\"01888044021\",\n" + 
				"		\"01888044002\",\n" + 
				"        \"01882939765\"\n" + 
				"		]\n" + 
				"}";
		
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
		
		
//		try {
//			DataSharingRequest dsr1 = om.readValue(ds.getBytes(), DataSharingRequest.class);
//			System.out.println(dsr1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.exit(0);
		
		InviteMemberRequest obj1 = new InviteMemberRequest();
		obj1.setMsisdn("01888044003");
		obj1.getInvitedNumbers().add("09200000123");
		obj1.getInvitedNumbers().add("09200000456");
		
		UploadAvatarResponse obj2 = new UploadAvatarResponse(true, "0", "SUCCESS", "http://bit.ly/w3eGh");
		RegisterSubscriberRequest obj3 = new RegisterSubscriberRequest("09200000123", "abcd1234", "1234");
		
		UploadAvatarResponse apiResp = new UploadAvatarResponse(true, "0", "SUCCESS");
		apiResp.setImageURL("images/xxx.png");
		
		RedeemLmsPointRequest rq = new RedeemLmsPointRequest();
		rq.setMsisdn("018880440003");
		rq.getPoints().add(new LmsParam("SMS", 2));
		rq.getPoints().add(new LmsParam("VOICE", 1));
		rq.getPoints().add(new LmsParam("DATA", 1));
		rq.getPoints().add(new LmsParam("CASHBACK", 2));
		
		
		ArrayList<String> members = new ArrayList<>();
		members.add("01888044001");
		members.add("01888044002");
		
		DataSharingRequest dsr = new DataSharingRequest("01888044003", "12345", members);
		
		SelfPackageRequest spr = new SelfPackageRequest();
		spr.setMsisdn("01888044003");
		spr.setDescription("Test Self Pkg");
		spr.setPackageId("12345");
		
		List<SelfPackageBalance> balances = new ArrayList<>();
		balances.add(new SelfPackageBalance("DATA", 100));
		balances.add(new SelfPackageBalance("DYNAMIC_OFFNET_VOICE", 10));
		balances.add(new SelfPackageBalance("DYNAMIC_OFFNET_SMS", 25));
		
		spr.getBalanceList().addAll(balances);
		
		GetLmsPointResponse lpr = new GetLmsPointResponse(true, "0", "SUCCESS", "01888044003", 150);
		
		
		NearbyStoreListRequest nsr = new NearbyStoreListRequest("x", 1, "name");
		nsr.setLatitude("23.1000");
		nsr.setLongitude("201.000");
		nsr.setMaxDistance("5");
		nsr.setPageNo(1);
		nsr.setSearchTerm("");
		nsr.setSortBy("name");

		
		ApiResponse apir = new ApiResponse(true, "0", "SUCCESS");
		
		ValidateNumberRequest vnr = new ValidateNumberRequest();
		vnr.getNumbers().add("0188820202020");
		vnr.getNumbers().add("0199902020200");
		
		PushedCampaignDTO pcr = new PushedCampaignDTO();
		pcr.setDescriptionEN("This is a test campaign");
		pcr.setDescriptionVI("This is a test campaign (vn)");
		pcr.setDetailsEN(pcr.getDescriptionEN());
		pcr.setDetailsVI(pcr.getDescriptionVI());
		pcr.setEndDate("31/10/2017");
		pcr.setStartDate("01/10/2017");
		pcr.setTitleEN("Test Campaign 01");
		pcr.setTitleVI(pcr.getTitleEN());

		PushedCampaignDTO pcr2 = new PushedCampaignDTO();
		pcr2.setDescriptionEN("This is another test campaign");
		pcr2.setDescriptionVI("This is another test campaign (vn)");
		pcr2.setDetailsEN(pcr.getDescriptionEN());
		pcr2.setDetailsVI(pcr.getDescriptionVI());
		pcr2.setEndDate("31/10/2017");
		pcr2.setStartDate("01/10/2017");
		pcr2.setTitleEN("Test Campaign 02");
		pcr2.setTitleVI(pcr.getTitleEN());

		
		PushedCampaignRequest pcreq = new PushedCampaignRequest();
		List<PushedCampaignDTO> data = new ArrayList<>();
		data.add(pcr);
		data.add(pcr2);
		pcreq.setData(data);
		
		
		UpdatePushedCampaignStatusRequest upcsr = new UpdatePushedCampaignStatusRequest();
		PushedCampaignStatus pcs1 = new PushedCampaignStatus();
		pcs1.setCampaignId(1);
		pcs1.setMsisdn("01888044003");
		upcsr.getData().add(pcs1);
		
		
		try {
//			System.out.println(om.writeValueAsString(obj1));
//			
//			System.out.println(om.writeValueAsString(obj2));
//			
//			System.out.println(om.writeValueAsString(obj3));
			
//			System.out.println(om.writeValueAsString(rq));
//			System.out.println(om.writeValueAsString(dsr));
//			System.out.println(om.writeValueAsString(pcr));
//			System.out.println("----------");
			System.out.println(om.writeValueAsString(nsr));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
