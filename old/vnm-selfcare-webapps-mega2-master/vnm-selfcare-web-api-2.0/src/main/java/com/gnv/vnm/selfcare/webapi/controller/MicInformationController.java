package com.gnv.vnm.selfcare.webapi.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.MicInformation;
import com.gnv.vnm.selfcare.core.model.MicInformationView;
import com.gnv.vnm.selfcare.core.utils.CheckImageValidation;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.MicInformationRequest;
 

@RestController
public class MicInformationController extends BaseRestController {
	
	//private static final Logger logger = LoggerFactory.getLogger(MicInformationController.class);
	
	/*
	 *  To upload MIC doc 
	 */
	@PostMapping(value = "/micupload")
	public ResponseEntity<?> micUploadSubscriber(@RequestBody MicInformationRequest micInformationRequest, HttpServletRequest request) throws SubscriberNotFoundException, UnsupportedEncodingException {
		
		MicInformation micInformation=new MicInformation();
		/*String firstName = getEncodedStr(micInformationRequest.getFirstNmae());
		String lastName = getEncodedStr(micInformationRequest.getLastName());
		String dob = micInformationRequest.getDob();
		String idcard = getEncodedStr(micInformationRequest.getIdCard());
		String date_of_issue = micInformationRequest.getDate_of_issue();
		String place_of_issue = getEncodedStr(micInformationRequest.getPlaceOfIssue());
		String address = getEncodedStr(micInformationRequest.getAddress());
		String province = getEncodedStr(micInformationRequest.getProvince());
		String district = getEncodedStr(micInformationRequest.getDistrict());
		String country = micInformationRequest.getCountry();
		String msisdn = micInformationRequest.getMsisdn();
		String firstIdCard = micInformationRequest.getFirstSideIdcard();
		String secondIdCard = micInformationRequest.getSecondSideIdcard();
		String custPortarit = micInformationRequest.getCustomerPortrait();
		String custSignature = micInformationRequest.getCustomerSignature();*/
		
		
		String firstName = micInformationRequest.getFirstNmae();
		String lastName = micInformationRequest.getLastName();
		String dob = micInformationRequest.getDob();
		String idcard = micInformationRequest.getIdCard();
		String date_of_issue = micInformationRequest.getDate_of_issue();
		String place_of_issue = micInformationRequest.getPlaceOfIssue();
		String address = micInformationRequest.getAddress();
		String province = micInformationRequest.getProvince();
		String district = micInformationRequest.getDistrict();
		String country = micInformationRequest.getCountry();
		String msisdn = micInformationRequest.getMsisdn();
		String firstIdCard ="";
		if(micInformationRequest.getFirstSideIdcard()!=null)
		{
			firstIdCard = micInformationRequest.getFirstSideIdcard();
			String imageBase64 = firstIdCard;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	        System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		String secondIdCard ="";
		if(micInformationRequest.getSecondSideIdcard()!=null)
		{
			secondIdCard = micInformationRequest.getSecondSideIdcard();
			String imageBase64 = secondIdCard;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	        System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		String custPortarit = "";
		if(micInformationRequest.getCustomerPortrait()!=null)
		{
			custPortarit = micInformationRequest.getCustomerPortrait();
			String imageBase64 = custPortarit;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	        System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		String custSignature = "";
		if(micInformationRequest.getCustomerSignature()!=null)
		{
			custSignature = micInformationRequest.getCustomerSignature();
			String imageBase64 = custSignature;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	        //System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		      micInformation = micInformationService.saveMicDocumentByMobile(firstName ,lastName, dob, idcard, date_of_issue, place_of_issue, address, province, district, country, msisdn, firstIdCard, secondIdCard, custPortarit, custSignature);
	
		return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
	}
	
	/*
	 *  To upload MIC doc 
	 */
	@PostMapping(value = "/newmicupload")
	public ResponseEntity<?> micUploadSubscriberGenderUpdate(@RequestBody MicInformationRequest micInformationRequest, HttpServletRequest request) throws SubscriberNotFoundException, UnsupportedEncodingException {
		
		MicInformation micInformation=new MicInformation();
		String firstName = micInformationRequest.getFirstNmae();
		String lastName = micInformationRequest.getLastName();
		String dob = micInformationRequest.getDob();
		String idcard = micInformationRequest.getIdCard();
		String date_of_issue = micInformationRequest.getDate_of_issue();
		String place_of_issue = micInformationRequest.getPlaceOfIssue();
		String address = micInformationRequest.getAddress();
		String province = micInformationRequest.getProvince();
		String district = micInformationRequest.getDistrict();
		String country = micInformationRequest.getCountry();
		String msisdn = micInformationRequest.getMsisdn();
		String firstIdCard ="";
		if(micInformationRequest.getFirstSideIdcard()!=null)
		{
			firstIdCard = micInformationRequest.getFirstSideIdcard();
			String imageBase64 = firstIdCard;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	       // System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		String secondIdCard ="";
		if(micInformationRequest.getSecondSideIdcard()!=null)
		{
			secondIdCard = micInformationRequest.getSecondSideIdcard();
			String imageBase64 = secondIdCard;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	       //System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		String custPortarit = "";
		if(micInformationRequest.getCustomerPortrait()!=null)
		{
			custPortarit = micInformationRequest.getCustomerPortrait();
			String imageBase64 = custPortarit;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	       //System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		String custSignature = "";
		if(micInformationRequest.getCustomerSignature()!=null)
		{
			custSignature = micInformationRequest.getCustomerSignature();
			String imageBase64 = custSignature;
	        String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
	        byte[] bytes = Base64.decodeBase64(imageDataBytes);
	        CheckImageValidation checkImageValidation = new CheckImageValidation();
	        String imageType = checkImageValidation.getImageType(bytes);
	       //System.out.println(" imageType " + imageType);
			  if(imageType.equalsIgnoreCase("Unknown"))
			  {
				  micInformation.setStatus(DefaultApiResponse.INVALIDIMAGE.code());
				  micInformation.setMessage(DefaultApiResponse.INVALIDIMAGE.message());
				  return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
			  }
		}
		
		String gender = micInformationRequest.getGender();

		 micInformation = micInformationService.saveMicDocumentByMobilewithGender(firstName ,lastName, dob, idcard, date_of_issue, place_of_issue, address, province, district, country, msisdn, firstIdCard, secondIdCard, custPortarit, custSignature,gender);
	
		return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
	}
	
	/*
	 *  To View MIC doc 
	 */ 
	@GetMapping(value = "/viewMicUpload/{msisdn}")
	public ResponseEntity<?> viewMicUploadSubscriber(@PathVariable String msisdn) {

		//MicInformation micInformation = micInformationService.saveMicDocumentByMobile(micInformationRequest.getFirstNmae(), micInformationRequest.getLastName(), micInformationRequest.getDob(), micInformationRequest.getIdCard(), micInformationRequest.getDate_of_issue(), micInformationRequest.getPlaceOfIssue(), micInformationRequest.getAddress(), micInformationRequest.getProvince(), micInformationRequest.getDistrict() , micInformationRequest.getCountry(), micInformationRequest.getMsisdn(), micInformationRequest.getFirstSideIdcard(), micInformationRequest.getSecondSideIdcard(), micInformationRequest.getCustomerPortrait(), micInformationRequest.getCustomerSignature());
		if(!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
			DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
			}
		List<MicInformationView> micInformationView = micInformationService.viewMicDocument(msisdn);
		return new ResponseEntity<>(micInformationView, HttpStatus.OK);
		
		}
	/*
	 *  To Update/Edit MIC doc 
	 */
	@PostMapping(value = "/editMicupload")
	public ResponseEntity<?> editMicUploadSubscriber(@RequestBody MicInformationRequest micInformationRequest, HttpServletRequest request) {

		MicInformation micInformation = micInformationService.editMicDocumentByMobile(micInformationRequest.getFirstNmae(), micInformationRequest.getLastName(), micInformationRequest.getDob(), micInformationRequest.getIdCard(), micInformationRequest.getDate_of_issue(), micInformationRequest.getPlaceOfIssue(), micInformationRequest.getAddress(), micInformationRequest.getProvince(), micInformationRequest.getDistrict() , micInformationRequest.getCountry(), micInformationRequest.getMsisdn(), micInformationRequest.getFirstSideIdcard(), micInformationRequest.getSecondSideIdcard(), micInformationRequest.getCustomerPortrait(), micInformationRequest.getCustomerSignature());
	
		return new ResponseEntity<MicInformation>(micInformation, HttpStatus.OK);
	}
	
	/*private String getEncodedStr(String str) throws UnsupportedEncodingException
    {
           String rawForm = new String (str.getBytes ("iso-8859-1"), "UTF-8"); 
           byte[] rawByte = Base64.encode(rawForm.getBytes());
           
           String encodedStr = new String(rawByte);
         return encodedStr;
    }*/
}
