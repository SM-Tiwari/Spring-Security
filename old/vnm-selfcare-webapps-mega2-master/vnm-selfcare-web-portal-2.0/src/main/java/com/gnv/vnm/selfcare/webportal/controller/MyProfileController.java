/**
* MyProfileController.java
*/
package com.gnv.vnm.selfcare.webportal.controller;

import java.io.InputStream;
import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.CurrentBalance;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.SmsCallHistoryStatusModel;
import com.gnv.vnm.selfcare.core.model.UserProfilePic;
import com.gnv.vnm.selfcare.core.service.AvatarService;

import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

import org.apache.axiom.util.base64.Base64Utils;
import org.apache.commons.io.IOUtils;

/**
* @author nandipinto
*
*/

@Controller
public class MyProfileController extends WebPortalBaseController {

                private static final Logger logger = LoggerFactory.getLogger(MyProfileController.class);

                @Autowired
                AvatarService avatarService;

                @GetMapping(value = "/secure/profile")
                public String profile(Model model, HttpServletRequest request, Principal authUser, Locale locale) {

                                setSessionData(model, request, getProfile(request, authUser), locale);
                                setActiveTopMenu(model, TopMenu.ACCOUNT);

                                String smsCallHistoryStatus = backEndRequestProcessor.getSmsCallHistoryStatus(authUser.getName());
                                CurrentBalance currentBalance = backEndRequestProcessor.getCurrentBalance(authUser.getName(),
                                                                locale.getLanguage());
                                model.addAttribute("currentBalance", currentBalance);
                                model.addAttribute("subscriptionCount",subscriberManagementService.getSubscribedPackages(authUser.getName(), locale.getLanguage()).size());
                                model.addAttribute("mic_statusprofile", "1");
                                model.addAttribute("smsCallHistoryStatus",smsCallHistoryStatus);
                                return ScreenNames.MYPROFILE;
                }

                @GetMapping(value = "/secure/mysubscriptions")
                public String subscriptions(Model model, HttpServletRequest request, Principal authUser, Locale locale) {

                                setSessionData(model, request, getProfile(request, authUser), locale);
                                setActiveTopMenu(model, TopMenu.ACCOUNT);

                                List<PackageSubscription> subscriptions = subscriberManagementService.getSubscribedPackages(authUser.getName(),
                                                                locale.getLanguage());
                                model.addAttribute("subscriptions", subscriptions);

                                return ScreenNames.SUBSCRIPTIONS;
                }

                /*
                * @PostMapping(value = "/secure/uploadavatar") public ResponseEntity<?>
                * uploadAvatar(@RequestParam MultipartFile avatarFile, Principal auth){
                * LoggingUtil.debug(logger, "#uploadAvatar --- receiving file " +
                * avatarFile.getOriginalFilename()); try {
                * 
                 * 
                 * String imageURL = avatarService.setAvatar(auth.getName(), DEFAULT_AVATAR,
                * FilenameUtils.getBaseName(avatarFile.getOriginalFilename()),
                * avatarFile.getInputStream(),FilenameUtils.getExtension(avatarFile.
                * getOriginalFilename()), 0, 0); // setFilePermissions(imageURL); return
                * new ResponseEntity<>(imageURL, HttpStatus.OK); } catch (Exception e) {
                * logger.
                * error("#uploadAvatar --- error when uploading avatar file for user " +
                * auth.getName(), e); return new ResponseEntity<>(e.getMessage(),
                * HttpStatus.INTERNAL_SERVER_ERROR); }
                * 
                 * }
                */

                @PostMapping(value = "/secure/uploadavatar")
           	 
            	public ResponseEntity<?> uploadAvatarnew(@RequestBody UserProfilePic userProfilePic, HttpServletRequest request, Principal auth) {
            		LoggingUtil.debug(logger, "#uploadAvatar --- receiving file ");

            		// avatarFiledata
            		try {
            			// String
            	
            			String getbase64ImgStr = userProfilePic.getUserImgBase64();	
            			
            			//System.out.println("getbase64ImgStr -----" + getbase64ImgStr);
            			String PortraitImageName = userProfilePic.getUserImgName();
            			String Customer_PortraitImage = getbase64ImgStr.replaceAll("data:image/png;base64", "")
            					.replaceAll("data:image/jpg;base64", "").replaceAll("data:image/PNG;base64", "")
            					.replaceAll("data:image/JPG;base64", "").replaceAll("data:image/jpeg;base64", "")
            					.replaceAll("data:image/JPEG;base64", "");
            			
            			
            			
            			byte[] encoded = Base64.getEncoder().encode(Customer_PortraitImage.getBytes());
            			String imageURL = avatarService.setAvatarnew(Customer_PortraitImage, auth.getName(), DEFAULT_AVATAR,
            					encoded);
            			// String setAvatar(String subscriberId, String category, String t
            			// nitle, String fileExt, byte[] bytes, int scaleX, int scaleY)
            			System.out.println("imageURL -----" + imageURL);
            			return new ResponseEntity<>(imageURL, HttpStatus.OK);
            		} catch (Exception e) {
            			logger.error("#uploadAvatar --- error when uploading avatar file for user " + auth.getName(), e);
            			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            		}

            	}

                @RequestMapping(value = "/secure/uploadAvatarFile", method = RequestMethod.POST, produces = { "application/json" })
                public @ResponseBody HashMap<String, Object> uploadAvatarFile(MultipartHttpServletRequest request, Principal auth)
                                                throws Exception {

                                LoggingUtil.debug(logger, "#uploadAvatar --- receiving file ");

                                HashMap<String, Object> map = new HashMap<String, Object>();
                                try {

                                                MultipartFile multipartFile = request.getFile("avatarFile");
                                                Long size = multipartFile.getSize();
                                                String contentType = multipartFile.getContentType();
                                                InputStream stream = multipartFile.getInputStream();
                                                byte[] bytes = IOUtils.toByteArray(stream);

                                                
                                /*            map.put("fileoriginalsize", size);
                                                map.put("contenttype", contentType);
                                                map.put("base64", new String(Base64Utils.encode(bytes)));*/

                                                String baseMap = new String(Base64Utils.encode(bytes));

                                                baseMap = baseMap.replaceAll("data:image/png;base64", "").replaceAll("data:image/jpg;base64", "")
                                                                                .replaceAll("data:image/PNG;base64", "").replaceAll("data:image/JPG;base64", "")
                                                                                .replaceAll("data:image/jpeg;base64", "").replaceAll("data:image/JPEG;base64", "");

                                                byte[] encoded = Base64.getEncoder().encode(baseMap.getBytes());
                                                String imageURL = avatarService.setAvatarnew(baseMap, auth.getName(), DEFAULT_AVATAR, encoded);

                                                

                                } catch (Exception e) {
                                                logger.error("#uploadAvatar --- error when uploading avatar file for user " + auth.getName(), e);
                                                //return null;
                                }
                                
                                return null;

                }

                /*
                * @PostMapping("/secure/submit") public String informationsubmit(Model
                * model, HttpServletRequest request, HttpServletResponse response,
                * Principal authUser, Locale locale) throws UnsupportedEncodingException{
                * 
                 * }
                */

                
        	    /*@RequestMapping(value = "/secure/getPasswordforHistory", method = RequestMethod.POST)
        	    public String saveAppConfigCms(@RequestParam(value = "myData", required = false) String requiredPassword,HttpServletRequest request,Principal authUser, Locale locale) {
							
                	String passW = requiredPassword;
                	String msisdnW = authUser.getName();
                	return ""+passW;
                	
                }*/
        	    
        	    @RequestMapping(value = "/secure/getValidationforHistory", method = RequestMethod.POST)
                public ResponseEntity<?> checkHistorycredential(Model model,@RequestParam(value = "myData", required = false) String requiredPassword,HttpServletRequest request,Principal authUser, Locale locale) {
                   SmsCallHistoryStatusModel smStatusModel = null ;
                   String credential = requiredPassword;
                   String msisdn = authUser.getName();
                   
                   
                   try {
                                      smStatusModel = backEndRequestProcessor.checkSmsCallHistorycredential(msisdn, credential);
                                       model.addAttribute("statusValue", smStatusModel.getStatus());
                                       //System.out.println("smStatusModel.getStatus() "+ smStatusModel.getStatus());
                                } catch (SubscriberNotFoundException e) {
                                      // TODO Auto-generated catch block
                                      e.printStackTrace();
                                }
                   
                   if(smStatusModel.getStatus().equalsIgnoreCase("0"))
                   {
                         return new ResponseEntity<>("OK", HttpStatus.OK);
                   }
                   else if(smStatusModel.getStatus().equalsIgnoreCase("1"))
                   {
                         return new ResponseEntity<>("OK", HttpStatus.OK);
                   }
                   else if(smStatusModel.getStatus().equalsIgnoreCase("2"))
                   {
                         return new ResponseEntity<>("PASSWORDMISMATCH", HttpStatus.OK);
                   }
                   else
                   {
                         return new ResponseEntity<>("NOTOK", HttpStatus.OK);
                   }
                   
                   
               }
               
               
               @RequestMapping(value = "/secure/getPasswordforHistory", method = RequestMethod.POST)
                public ResponseEntity<?> secureHistorywithPassword(Model model,@RequestParam(value = "myData", required = false) String requiredPassword,@RequestParam(value = "currentStatus", required = false) String requiredStatus,HttpServletRequest request,Principal authUser, Locale locale) {
                   SmsCallHistoryStatusModel smStatusModel = null ;
                   String credential = requiredPassword;
                   String msisdn = authUser.getName();
                   //String smsCallHistoryStatus = backEndRequestProcessor.getSmsCallHistoryStatus(msisdn);
                   String smsCallHistoryStatus = requiredStatus;
                   
                   try {
                                       smStatusModel = backEndRequestProcessor.updateSmsCallHistoryStatus(msisdn, credential, smsCallHistoryStatus);
                                       model.addAttribute("statusValue", smStatusModel.getStatus());
                                       //System.out.println("smStatusModel.getStatus() "+ smStatusModel.getStatus());
                                } catch (Exception e) {
                                      // TODO Auto-generated catch block
                                      e.printStackTrace();
                                }
                   
                   if(smStatusModel.getStatus().equalsIgnoreCase("0"))
                   {
                         return new ResponseEntity<>("OK", HttpStatus.OK);
                   }
                   else if(smStatusModel.getStatus().equalsIgnoreCase("1"))
                   {
                         return new ResponseEntity<>("OK", HttpStatus.OK);
                   }
                   else
                   {
                         return new ResponseEntity<>("PASSWORDMISMATCH", HttpStatus.OK);
                   }
                   //return new ResponseEntity<>("OK", HttpStatus.OK);
                   //return new ResponseEntity<>(smStatusModel.getStatus().toString(), HttpStatus.OK);
                   
               }

}
