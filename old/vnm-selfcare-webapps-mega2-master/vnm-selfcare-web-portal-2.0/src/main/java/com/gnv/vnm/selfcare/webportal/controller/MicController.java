package com.gnv.vnm.selfcare.webportal.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.District;
import com.gnv.vnm.selfcare.core.model.MicInformation;
import com.gnv.vnm.selfcare.core.model.MicInformationView;
import com.gnv.vnm.selfcare.core.model.Province;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.core.utils.Constant;
import com.gnv.vnm.selfcare.dao.entity.MicInformationEntity;
import com.gnv.vnm.selfcare.dao.entity.QMicInformationEntity;
import com.gnv.vnm.selfcare.dao.repo.MicInformationRepository;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

@Controller
public class MicController extends WebPortalBaseController{
	 @Autowired
     MicInformationRepository micinformationRepository;
	public  String mode=Constant.MODE;
	@GetMapping("/secure/information")
	public String dashboard(Model model, HttpServletRequest request, HttpServletResponse response, Principal authUser, Locale locale){
		SubscriberProfile profile = getProfile(request, authUser);
		setSessionData(model, request, profile, locale);
		setActiveTopMenu(model, TopMenu.HOME);
		//check the status for updation
		 String value=null;
		 
				if(mode.equalsIgnoreCase("test")){
			      //for test
		         value=micInformationService.getDevMicStatus(authUser.getName());
				}else{
		       //for  prod
		      try {
					value=micInformationService.getMicStatus(authUser.getName());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		 if(value.equals("0"))
		 {
		List<Province> provincelist = provinceDistrictService.getAllProvince();
		model.addAttribute("provincelist", provincelist);
		model.addAttribute("authUser", authUser.getName());
		model.addAttribute("mic_statusalredyexist", "1");
		return ScreenNames.MIC_INFORMATION;
		 }
		else if(value.equals("1"))
		{
			MicInformation micinformation= micInformationService.viewwebDocument(authUser.getName());
			
			List<Province> provincelist = provinceDistrictService.getAllProvince();
			model.addAttribute("provincelist", provincelist);
			model.addAttribute("authUser", authUser.getName());
			model.addAttribute("micinformation", micinformation);
			return ScreenNames.MICViewINFORMATION;
		}
		else {
			model.addAttribute("mic_statusprofile", "2");
			return ScreenNames.MYPROFILE;
		}
		
		 
		
	}
	
	
	
	@PostMapping("/secure/submit")
	public String informationsubmit(Model model, HttpServletRequest request, HttpServletResponse response, Principal authUser, Locale locale) throws UnsupportedEncodingException{
		 SubscriberProfile profile = getProfile(request, authUser);
		 
		 try {
	            request.setCharacterEncoding("UTF-8");
	     } catch (UnsupportedEncodingException e) { }


		 setSessionData(model, request, profile, locale);
		 setActiveTopMenu(model, TopMenu.HOME);
		 
		 //change for debug local
		 String msisdn=authUser.getName();
		 
		 //for prod/dev server
	     //String msisdn=profile.getMsisdn();
	     String firstname=getEncodedStr(request.getParameter("firstname"));
	     String lastname=getEncodedStr(request.getParameter("lastname"));
	      
	     String dob=request.getParameter("Dateofbirth");
	     String idcard=getEncodedStr(request.getParameter("idcard"));
	     String dateofissue=request.getParameter("dateofissue"); 
	     String country="vietnam";
	     
	     String provinceName=getEncodedStr(request.getParameter("provinceName"));
         String districtName=getEncodedStr(request.getParameter("districtName"));
	     String adress=getEncodedStr(request.getParameter("adress"));
	     String placeofissue=getEncodedStr(request.getParameter("placeofIssueId"));
	     System.out.println("firstname===" + firstname+"lastname=="+ lastname+"districtName=="+ districtName +"provinceName==="+provinceName);
	
	     String Customer_PortraitImage=request.getParameter("Customer_PortraitImage").replaceAll("data:image/png;base64", "").replaceAll("data:image/jpg;base64", "").replaceAll("data:image/PNG;base64", "").replaceAll("data:image/JPG;base64", "").replaceAll("data:image/jpeg;base64", "").replaceAll("data:image/JPEG;base64", "");
         String ID_FrontImage=request.getParameter("ID_FrontImage").replaceAll("data:image/png;base64", "").replaceAll("data:image/jpg;base64", "").replaceAll("data:image/PNG;base64", "").replaceAll("data:image/JPG;base64", "").replaceAll("data:image/jpeg;base64,", "").replaceAll("data:image/JPEG;base64", "");
         String ID_backImage=request.getParameter("ID_backImage").replaceAll("data:image/png;base64", "").replaceAll("data:image/jpg;base64", "").replaceAll("data:image/PNG;base64", "").replaceAll("data:image/JPG;base64", "").replaceAll("data:image/jpeg;base64,", "").replaceAll("data:image/JPEG;base64", "");
         //add gender features by oneclick
         String gender = request.getParameter("genderId");
	     
         ///alredy exist or not
         //micInformation = new MicInformation();
         List<MicInformationView> micList = new ArrayList<MicInformationView>();
         
         try {
         	 
                Iterable<MicInformationEntity> micIt = micinformationRepository.findAll(QMicInformationEntity.micInformationEntity.msisdn.eq(msisdn));
                
                for (MicInformationEntity se : micIt){
                	MicInformationView micInformationView= new MicInformationView();
                	micInformationView.setDistrict(se.getDistrict());
                    micList.add(micInformationView);
                }
         } catch (Exception e) {
                System.out.println("#informationsubmit --- error:::"+e);
         }
         
         if(!micList.isEmpty()){
        	 //existing in db
        		List<Province> provincelist = provinceDistrictService.getAllProvince();
        		model.addAttribute("provincelist", provincelist);
        		model.addAttribute("authUser", authUser.getName());
        	    model.addAttribute("mic_statusalredyexist", "3");
        	 return ScreenNames.MIC_INFORMATION;
                      
         }
         else{
        	 // not existing in db
         
	    // System.out.println("Customer_PortraitImage ===" +Customer_PortraitImage);
	     try {
	    	//Change bool to string by Oneclick micBool(bool to String)
			String micBool = micInformationService.saveMicDocument(firstname, lastname, dob, idcard, dateofissue, placeofissue,
					adress, provinceName, districtName , country, msisdn, ID_FrontImage, ID_backImage,Customer_PortraitImage,"NA",gender);
			if(micBool=="Success"){
				 // redirectAttributes.addFlashAttribute("successMic", "3");
				model.addAttribute("successMic", "2");
			}else if(micBool =="Bạn đang sở hữu quá 03 thuê bao, vui lòng ghé cửa hàng Vietnamobile gần nhất để thực giao kết hợp đồng theo quy định") {
				 // redirectAttributes.addFlashAttribute("successMic", "2");
				model.addAttribute("successMic", "7");
			}
			else
			{
				model.addAttribute("successMic", "3");
			}
			 
		} catch (SubscriberNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	   

	    // return "redirect:/secure/dashboard";
	     return ScreenNames.DASHBOARD;
         }
	   
		
		 
		
	}
	@GetMapping("/allprovince")
	public List<Province> province(){ 
		List<Province> allprovince = provinceDistrictService.getAllProvince();
		return allprovince;
		 
		
	}
 
	@GetMapping("/secure/district/{value}")
	public  ResponseEntity<?> district(@PathVariable String value){ 
		List<District> district=null;
		try{
			district = provinceDistrictService.getDistrictByProvince(Integer.parseInt(value));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(district, HttpStatus.OK);
		 
		
	}
	
	private String getEncodedStr(String str) throws UnsupportedEncodingException
    {
           String rawForm = new String (str.getBytes ("iso-8859-1"), "UTF-8"); 
         byte[] rawByte = Base64.encode(rawForm.getBytes());
           
           String encodedStr = new String(rawByte);
         return encodedStr;
    }

}
