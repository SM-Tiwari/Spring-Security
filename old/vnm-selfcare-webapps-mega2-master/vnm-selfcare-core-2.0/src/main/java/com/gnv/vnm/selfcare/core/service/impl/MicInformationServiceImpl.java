package com.gnv.vnm.selfcare.core.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.epos.ws.GetTokenByEposSoap;
import com.gnv.vnm.selfcare.core.epos.ws.UpdateCustomerInforByEposSoap;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.EposTokenModel;
import com.gnv.vnm.selfcare.core.model.MicInformation;
import com.gnv.vnm.selfcare.core.model.MicInformationView;
import com.gnv.vnm.selfcare.core.model.UpdateCustomerInforModel;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.MicInformationService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.Constant;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.MicInformationEntity;
import com.gnv.vnm.selfcare.dao.entity.MicLogEntitiy;
import com.gnv.vnm.selfcare.dao.entity.MicStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QMicInformationEntity;
import com.gnv.vnm.selfcare.dao.entity.QMicStatusEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.repo.MicInformationRepository;
import com.gnv.vnm.selfcare.dao.repo.MicLogRepository;
import com.gnv.vnm.selfcare.dao.repo.MicStatusRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;

import net.coobird.thumbnailator.Thumbnails;



@Service("microInformationService")
public class MicInformationServiceImpl implements MicInformationService {

                static final Logger logger = LoggerFactory.getLogger(MicInformationServiceImpl.class);
                
                String baseDirectory = "D:\\upload_img\\subscriber\\";
                MicInformation micInformation = new MicInformation();
                @Autowired
                MicInformationRepository micinformationRepository;
                @Autowired 
                private ApplicationConfigurationService applicationConfigurationService;
                @Autowired
                private SubscriberRepository subscriberRepository;
                @Autowired
                private MicStatusRepository micStatusRepository;
                @Autowired
                private MicInformationService micInformationService;
                @Autowired
                private MicLogRepository micLogRepository;

                public  String mode=Constant.MODE;
                String host="hanwebslfdb-scan.vietnamobile.net.vn";
                String username = "scuser";
                String password= "Selfcare2017";
                /*private MicInformationView fromMicInformation(MicInformationEntity source){
                                MicInformationView micInformationView = new MicInformationView(source.getFirstNmae(), source.getLastName(), source.getDob(), source.getIdCard(),
                                                                source.getDate_of_issue(), getDecodedStr(source.getPlaceOfIssue()), getDecodedStr(source.getAddress()), getDecodedStr(source.getProvince()), getDecodedStr(source.getDistrict()), source.getCountry(),
                                                                source.getMsisdn(), source.getFirstSideIdcard(), source.getSecondSideIdcard(), source.getCustomerPortrait(), source.getCustomerSignature());
                                
                                return micInformationView;       
                }*/
                
                private MicInformationView fromMicInformation(MicInformationEntity source){
                    MicInformationView micInformationView = new MicInformationView(source.getFirstNmae(), source.getLastName(), source.getDob(), source.getIdCard(),
                                                    source.getDate_of_issue(), source.getPlaceOfIssue(), source.getAddress(), source.getProvince(), source.getDistrict(), source.getCountry(),
                                                    source.getMsisdn(), source.getFirstSideIdcard(), source.getSecondSideIdcard(), source.getCustomerPortrait(), source.getCustomerSignature());
                    
                    return micInformationView;       
    }
              //add new method for gender features by oneclick
                private MicInformationView fromMicInformationWithGender(MicInformationEntity source){
                    MicInformationView micInformationView = new MicInformationView(source.getFirstNmae(), source.getLastName(), source.getDob(), source.getIdCard(),
                                                    source.getDate_of_issue(), source.getPlaceOfIssue(), source.getAddress(), source.getProvince(), source.getDistrict(), source.getCountry(),
                                                    source.getMsisdn(), source.getFirstSideIdcard(), source.getSecondSideIdcard(), source.getCustomerPortrait(), source.getCustomerSignature(), source.getGender());
                    
                    return micInformationView;       
    }
                
                /*@Override
                public MicInformation saveMicDocumentByMobile(String firstNmae, String lastName, String dob, String idCard,
                                                String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
                                                String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
                                                String customerSignature)throws SubscriberNotFoundException {
                                
                                
                                String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
                                String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
                
                                SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
                                if (subscriber == null) throw new SubscriberNotFoundException();
                                
                                try {
                                                int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
                                                int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());

                                                byte[] decodedFirstIdCard = Base64.decodeBase64(firstSideIdcard.getBytes());
                                                InputStream isFirstIdCard = new ByteArrayInputStream(decodedFirstIdCard);
                                                
                                                byte[] decodedSecondIdCard = Base64.decodeBase64(secondSideIdcard.getBytes());
                                                InputStream isSecondIdCard = new ByteArrayInputStream(decodedSecondIdCard);
                                                
                                                byte[] decodedCustPortrait = Base64.decodeBase64(customerPortrait.getBytes());
                                                InputStream isCustPortrait = new ByteArrayInputStream(decodedCustPortrait);
                                                
                                                byte[] decodedCustSign = Base64.decodeBase64(customerSignature.getBytes());
                                                InputStream isCustSign = new ByteArrayInputStream(decodedCustSign);
                                                
                                                
                                                File avatarFileFirstId = new File(avatarDir, msisdn + "_firstside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                                                File avatarFileSecondId = new File(avatarDir, msisdn + "_secondside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                                                File avatarCustPortrait = new File(avatarDir, msisdn + "_cust_portrait" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                                                File avatarCustSign = new File(avatarDir, msisdn + "_cust_signature" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                                                
                                                int scaleX=0; int scaleY=0;
                                                if (scaleX > 0 && scaleY > 0){
                                                                
                                                                LoggingUtil.debug(logger, "#saveMicDocumentByMobile --- resizing image to " + width + "x" + height);
                                                                File tmpFirstId = new File(avatarDir, avatarFileFirstId.getName() + ".tmp");
                                                                FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(tmpFirstId));
                                                                Thumbnails.of(tmpFirstId).size(scaleX, scaleY).toFile(avatarFileFirstId);
                                                                tmpFirstId.delete();
                                                                
                                                                File tmpSecondId = new File(avatarDir, avatarFileSecondId.getName() + ".tmp");
                                                                FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(tmpSecondId));
                                                                Thumbnails.of(tmpSecondId).size(scaleX, scaleY).toFile(avatarFileSecondId);
                                                                tmpSecondId.delete();
                                                                
                                                                File tmpCustPortrait = new File(avatarDir, avatarCustPortrait.getName() + ".tmp");
                                                                FileCopyUtils.copy(isCustPortrait, new FileOutputStream(tmpCustPortrait));
                                                                Thumbnails.of(tmpCustPortrait).size(scaleX, scaleY).toFile(avatarCustPortrait);
                                                                tmpCustPortrait.delete();
                                                                
                                                                File tmpCustSign = new File(avatarDir, avatarCustSign.getName() + ".tmp");
                                                                FileCopyUtils.copy(isCustSign, new FileOutputStream(tmpCustSign));
                                                                Thumbnails.of(tmpCustSign).size(scaleX, scaleY).toFile(avatarCustSign);
                                                                tmpCustSign.delete();
                                                                
                                                }else{
                                                                FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(avatarFileFirstId));
                                                                FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(avatarFileSecondId));
                                                                FileCopyUtils.copy(isCustPortrait, new FileOutputStream(avatarCustPortrait));
                                                                FileCopyUtils.copy(isCustSign, new FileOutputStream(avatarCustSign));
                                                }
                                                
                                                LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar FirstID " + avatarFileFirstId.getName() + " for subscriber " + msisdn);
                                                LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar SecondID " + avatarFileSecondId.getName() + " for subscriber " + msisdn);
                                                LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustPortrait " + avatarCustPortrait.getName() + " for subscriber " + msisdn);
                                                LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustSignature " + avatarCustSign.getName() + " for subscriber " + msisdn);
                                                
                                                                List<MicInformationEntity> micInfoList = new ArrayList<MicInformationEntity>();
                                                                
                                                                micInformation = new MicInformation();
                                                                MicInformationEntity micInformationEntity= new MicInformationEntity();
                                                                
                                                                micInformationEntity.setFirstNmae(firstNmae);
                                                                micInformationEntity.setLastName(lastName);
                                                                micInformationEntity.setDob(dob);
                                                                micInformationEntity.setIdCard(idCard);
                                                                micInformationEntity.setDate_of_issue(date_of_issue);
                                                                micInformationEntity.setPlaceOfIssue(placeOfIssue);
                                                                micInformationEntity.setAddress(address);
                                                                micInformationEntity.setProvince(province);
                                                                micInformationEntity.setDistrict(district);
                                                                micInformationEntity.setCountry(country);
                                                                micInformationEntity.setMsisdn(msisdn);
                                                                micInformationEntity.setFirstSideIdcard(createImageURL(avatarFileFirstId.getName()));
                                                                micInformationEntity.setSecondSideIdcard(createImageURL(avatarFileSecondId.getName()));
                                                                micInformationEntity.setCustomerPortrait(createImageURL(avatarCustPortrait.getName()));
                                                                micInformationEntity.setCustomerSignature(createImageURL(avatarCustSign.getName()));
                                                                micInformationEntity.setId(0);
                                                                
                                                                micInfoList.add(micInformationEntity);
                                                                micInformationService.saveMicStatus(msisdn, msisdn, "0");
                                                                micinformationRepository.save(micInfoList);
                                                                micInformation.setStatus("1");
                                                                micInformation.setMessage("Successfully Uploaded");
                                                
                                } catch (Exception e) {
                                                logger.error("#saveMicDocumentByMobile(inputStream) -- error occurred when uploading and setting for subscriber ID card , portrait and signature  " + msisdn, e);
                                                micInformation.setStatus("0");
                                                micInformation.setMessage("Not Uploadeded");
                                                e.printStackTrace();
                                }
                                
                                return micInformation;
                }*/
                @Override
    public MicInformation saveMicDocumentByMobile(String firstNmae, String lastName, String dob, String idCard,
                  String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
                  String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
                  String customerSignature)throws SubscriberNotFoundException {
           
                      
                    //micInformation = new MicInformation();
                    List<MicInformationView> micList = new ArrayList<MicInformationView>();
                    
                    try {
                    	 
                           Iterable<MicInformationEntity> micIt = micinformationRepository.findAll(QMicInformationEntity.micInformationEntity.msisdn.eq(msisdn));
                           
                           for (MicInformationEntity se : micIt){
                                 micList.add(fromMicInformation(se));
                           }
                    } catch (Exception e) {
                           logger.error("#saveMicDocumentByMobile --- error get Mic Document!", e);
                    }
                    
                    if(!micList.isEmpty()){
                           micInformation.setStatus("3");
                           micInformation.setMessage("Cannot update your information");
                                 
                    }
                    else{

                
                	 String client_type = "MOBILE";	
                	
                	// byte[] provinceByte = convertStrToBase64(province);
                                //byte[] districtByte = convertStrToBase64(district);
           GetTokenByEposSoap getToken = new GetTokenByEposSoap();
           List<EposTokenModel> eposTokenModelList =  getToken.getToken(msisdn);
           
           String tokenStatus = eposTokenModelList.get(0).getStatus();
           String tokenKey = eposTokenModelList.get(0).getSessionid();
           String tokenMessage = eposTokenModelList.get(0).getMessage();
           
          // System.out.println(tokenStatus + ","+tokenKey +"," +tokenMessage);
          
                	// String tokenStatus = "0";
           if(tokenStatus.equalsIgnoreCase("0")){
                  UpdateCustomerInforByEposSoap updateCustomerInfor = new UpdateCustomerInforByEposSoap();
                
                  List<UpdateCustomerInforModel> updateCustomerInforModelList = updateCustomerInfor.updateMicInEpos(tokenKey,  firstNmae,  lastName,  dob,  idCard,
                               date_of_issue,  placeOfIssue,  address,  province,  district,  country,
                               msisdn,  firstSideIdcard,  secondSideIdcard,  customerPortrait,
                               customerSignature, client_type);
                  
                /*  List<UpdateCustomerInforModel> updateCustomerInforModelList = updateCustomerInfor.updateMicInEpos(tokenKey,  firstNmae,  lastName,  dob,  idCard,
                          date_of_issue,  placeOfIssue,  address,  province,  district,  country,
                          msisdn,  firstSideIdcard,  secondSideIdcard,  customerPortrait,
                          customerSignature, client_type);*/
                  
                  String transId = updateCustomerInforModelList.get(0).getTransId();
                  String updateMicStatus = updateCustomerInforModelList.get(0).getStatus();
                  String updateMicMsg = updateCustomerInforModelList.get(0).getMessage();
                //  String updateMicStatus = "0";
                  if(updateMicStatus.equalsIgnoreCase("0")){
                                  try {  
                        String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
                        String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
                  
                        SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
                        if (subscriber == null) throw new SubscriberNotFoundException();
                        
                        
                               int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
                               int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());

                               byte[] decodedFirstIdCard = Base64.decodeBase64(firstSideIdcard.getBytes());
                               InputStream isFirstIdCard = new ByteArrayInputStream(decodedFirstIdCard);
                               
                               byte[] decodedSecondIdCard = Base64.decodeBase64(secondSideIdcard.getBytes());
                               InputStream isSecondIdCard = new ByteArrayInputStream(decodedSecondIdCard);
                               
                               byte[] decodedCustPortrait = Base64.decodeBase64(customerPortrait.getBytes());
                               InputStream isCustPortrait = new ByteArrayInputStream(decodedCustPortrait);
                               
                               byte[] decodedCustSign = Base64.decodeBase64(customerSignature.getBytes());
                               InputStream isCustSign = new ByteArrayInputStream(decodedCustSign);
                               
                               
                               File avatarFileFirstId = new File(avatarDir, msisdn + "_firstside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                               File avatarFileSecondId = new File(avatarDir, msisdn + "_secondside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                               File avatarCustPortrait = new File(avatarDir, msisdn + "_cust_portrait" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                               File avatarCustSign = new File(avatarDir, msisdn + "_cust_signature" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                               
                               int scaleX=0; int scaleY=0;
                               if (scaleX > 0 && scaleY > 0){
                                      
                                      LoggingUtil.debug(logger, "#saveMicDocumentByMobile --- resizing image to " + width + "x" + height);
                                      File tmpFirstId = new File(avatarDir, avatarFileFirstId.getName() + ".tmp");
                                      FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(tmpFirstId));
                                      Thumbnails.of(tmpFirstId).size(scaleX, scaleY).toFile(avatarFileFirstId);
                                      tmpFirstId.delete();
                                      
                                      File tmpSecondId = new File(avatarDir, avatarFileSecondId.getName() + ".tmp");
                                      FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(tmpSecondId));
                                      Thumbnails.of(tmpSecondId).size(scaleX, scaleY).toFile(avatarFileSecondId);
                                      tmpSecondId.delete();
                                      
                                      File tmpCustPortrait = new File(avatarDir, avatarCustPortrait.getName() + ".tmp");
                                      FileCopyUtils.copy(isCustPortrait, new FileOutputStream(tmpCustPortrait));
                                      Thumbnails.of(tmpCustPortrait).size(scaleX, scaleY).toFile(avatarCustPortrait);
                                      tmpCustPortrait.delete();
                                      
                                      File tmpCustSign = new File(avatarDir, avatarCustSign.getName() + ".tmp");
                                      FileCopyUtils.copy(isCustSign, new FileOutputStream(tmpCustSign));
                                      Thumbnails.of(tmpCustSign).size(scaleX, scaleY).toFile(avatarCustSign);
                                      tmpCustSign.delete();
                                      
                               }else{
                                      FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(avatarFileFirstId));
                                      FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(avatarFileSecondId));
                                      FileCopyUtils.copy(isCustPortrait, new FileOutputStream(avatarCustPortrait));
                                      FileCopyUtils.copy(isCustSign, new FileOutputStream(avatarCustSign));
                                  	setFilePermissions(avatarFileFirstId);
                                	setFilePermissions(avatarFileSecondId);
                                	setFilePermissions(avatarCustPortrait);
                                	setFilePermissions(avatarCustSign);
                               }
                               
                               LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar FirstID " + avatarFileFirstId.getName() + " for subscriber " + msisdn);
                               LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar SecondID " + avatarFileSecondId.getName() + " for subscriber " + msisdn);
                               LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustPortrait " + avatarCustPortrait.getName() + " for subscriber " + msisdn);
                               LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustSignature " + avatarCustSign.getName() + " for subscriber " + msisdn);
                               
                                      List<MicInformationEntity> micInfoList = new ArrayList<MicInformationEntity>();
                                      
                                      
                                      MicInformationEntity micInformationEntity= new MicInformationEntity();
                                      
                                      if(firstNmae==null){
                                    	  firstNmae="NA";
                                      }
                                      if(lastName==null){
                                    	  lastName="NA";
                                      }
                                      if(dob==null){
                                    	  dob="NA";
                                      }
                                      if(idCard==null){
                                    	  idCard="NA";
                                      }
                                      if(placeOfIssue==null){
                                    	  placeOfIssue="NA";
                                      }
                                      if(address==null){
                                    	  address="NA";
                                      }
                                      if(province==null){
                                    	  province="NA";
                                      }
                                      if(district==null){
                                    	  district="NA";
                                      }
                                      
                                      if(country==null){
                                    	  country="NA";
                                      }
                                      if(msisdn==null){
                                    	  msisdn="NA";
                                      }
                                     
                                      
                                      micInformationEntity.setFirstNmae(firstNmae);
                                      micInformationEntity.setLastName(lastName);
                                      micInformationEntity.setDob(dob);
                                      micInformationEntity.setIdCard(idCard);
                                      micInformationEntity.setDate_of_issue(date_of_issue);
                                      micInformationEntity.setPlaceOfIssue(placeOfIssue);
                                      micInformationEntity.setAddress(address);
                                      micInformationEntity.setProvince(province);
                                      micInformationEntity.setDistrict(district);
                                      micInformationEntity.setCountry(country);
                                      micInformationEntity.setMsisdn(msisdn);
                                      micInformationEntity.setFirstSideIdcard(createImageURL(avatarFileFirstId.getName()));
                                      micInformationEntity.setSecondSideIdcard(createImageURL(avatarFileSecondId.getName()));
                                      micInformationEntity.setCustomerPortrait(createImageURL(avatarCustPortrait.getName()));
                                      micInformationEntity.setCustomerSignature(createImageURL(avatarCustSign.getName()));
                                      micInformationEntity.setId(0);
                                      //set N/A for remove null from DB By OneClick 11-07-2018
                                      micInformationEntity.setGender("N/A");
                                      micInfoList.add(micInformationEntity);
                                      

                                      
                                      micinformationRepository.save(micInfoList);
                                    //  micInformationService.saveMicStatusBymobile(msisdn, msisdn, "1");
                                      if(mode.equalsIgnoreCase("test")){
                                          micInformationService.saveMicStatus(msisdn, msisdn, "1");
                                          }
                                      micInformation.setStatus("0");
                                      micInformation.setMessage("Successfully Uploaded");
                                      /*
                                       ***************To main Log******************************* 
                                       */
                                     
                                      

                               
                        } catch (Exception e) {
                               logger.error("#saveMicDocumentByMobile(inputStream) -- error occurred when uploading and setting for subscriber ID card , portrait and signature  " + msisdn, e);
                               micInformation.setStatus("1");
                               micInformation.setMessage("Not Uploadeded");
                               e.printStackTrace();
                        }
                  }else{
                        micInformation.setStatus("1");
                        micInformation.setMessage("Not Uploadeded, Due to internal server error");
                  }
                  
                  //System.out.println(transId + ","+updateMicStatus +"," +updateMicMsg);
           }
           
                    }
           
           return micInformation;
    }



                @Override
                public List<MicInformationView> viewMicDocument(String msisdn) {
                                
                                List<MicInformationView> micInfoList = new ArrayList<MicInformationView>();
                                
                                try {
                                                Iterable<MicInformationEntity> list = micinformationRepository.findAll(QMicInformationEntity.micInformationEntity.msisdn.eq(msisdn));
                                                for (MicInformationEntity se : list){
                                                                micInfoList.add(fromMicInformationWithGender(se));
                                                }
                                } catch (Exception e) {
                                                logger.error("#viewMicDocument --- error retrieving Mic Document!", e);
                                }
                                return micInfoList;
                                
                }

                @Override
                public MicInformation editMicDocumentByMobile(String firstNmae, String lastName, String dob, String idCard,
                                                String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
                                                String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
                                                String customerSignature) {
                                
                                //List<MicInformationEntity> micInfoList = new ArrayList<MicInformationEntity>();
                                micInformation = new MicInformation();

                                MicInformationEntity micInformationEntity= this.micinformationRepository.findOne(QMicInformationEntity.micInformationEntity.msisdn.equalsIgnoreCase(msisdn));
                                micInformationEntity.setFirstNmae(firstNmae);
                                micInformationEntity.setLastName(lastName);
                                micInformationEntity.setDob(dob);
                                
                                micInformationEntity.setIdCard(idCard);
                                micInformationEntity.setDate_of_issue(date_of_issue);
                                micInformationEntity.setPlaceOfIssue(placeOfIssue);
                                micInformationEntity.setAddress(address);
                                
                                //micInformationEntity.setProvince(province);
                                
                                //micInformationEntity.setDistrict(district);
                                micInformationEntity.setCountry(country);
                                micInformationEntity.setMsisdn(msisdn);
                                String firstsidePath = baseDirectory+"subscriber_idcard\\" + msisdn+"_firstside_idcard"+".jpg";
                                String secondsidePath = baseDirectory+"subscriber_idcard\\" + msisdn+"_secondside_idcard"+".jpg";
                                String custPortraitPath = baseDirectory+"subscriber_portrait\\" + msisdn+"_portrait"+".jpg";
                                String custSignaturePath = baseDirectory+"subscriber_signature\\" + msisdn+"_sign"+".jpg";
                                
                                micInformationEntity.setFirstSideIdcard(firstsidePath);
                                micInformationEntity.setSecondSideIdcard(secondsidePath);
                                micInformationEntity.setCustomerPortrait(custPortraitPath);
                                micInformationEntity.setCustomerSignature(custSignaturePath);
                                //micInformationEntity.setId(0);
                                //micInfoList.add(micInformationEntity);
                                
                                try{
                                                
                                                micinformationRepository.save(micInformationEntity);
                                                
                                                /*ImageUtils.decoder(firstSideIdcard,firstsidePath);
                                                ImageUtils.decoder(secondSideIdcard, secondsidePath);
                                                ImageUtils.decoder(customerPortrait, custPortraitPath);
                                                ImageUtils.decoder(customerSignature, custSignaturePath);*/
                                                
                                                micInformation.setStatus("1");
                                                micInformation.setMessage("Successfully Updated");
                                                }catch (Exception e) {
                                                                micInformation.setStatus("0");
                                                                micInformation.setMessage("Not Updated");
                                                                e.printStackTrace();
                                                }
                                
                                return micInformation;
                }

                private String createImageURL(String image){
                                if (!StringUtils.hasText(image)) return "";
                                
                                String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
                                String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
                                String avatarDir = applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();

                                return imageSvr + imageDir + avatarDir + "/" + image;
                }


    
/*
                @Override
                public String getMicStatus(String msisdn) {
                                // TODO Auto-generated method stub
                                String status_value=null;
                     Iterable<MicStatusEntity> list = micStatusRepository.findAll(QMicStatusEntity.micStatusEntity.msisdn.eq(msisdn));
                     for (MicStatusEntity se : list){
                       status_value=se.getStatus().toString();
                     } 
                     if(status_value==null){
                                return "1"; 
                     }
                     return status_value;

                    }
*/
     @Override
    public String getDevMicStatus(String msisdn) {
           String status_value=null;
     Iterable<MicStatusEntity> list = micStatusRepository.findAll(QMicStatusEntity.micStatusEntity.msisdn.eq(msisdn));
     for (MicStatusEntity se : list){
       status_value=se.getStatus().toString();
     }
     if(status_value  == null){
           status_value = "0";
     }
     return status_value;

    }

     @Override
    public String getMicStatus(String msisdn) throws SQLException {
           String status_value=null;
           Connection connection =null;
           Statement statement=null;
           try{
                  
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                  //String url = "jdbc:oracle:thin:@10.6.16.32:1526:WSCDBP";
                  String url ="jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST ="+host+")(PORT = 1526))(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = WSCDBP)))";
                 
                    connection = DriverManager.getConnection(url,username,password);
                    statement= connection.createStatement(); 
                  String query = "select * from APP_CCW.TB_SUBS_UPDATE_INFO@INET11G where MSISDN ='"+msisdn+"'";
                
                  ResultSet rs = statement.executeQuery(query);
                  
                  if (rs.next()) {
                	  status_value=rs.getString(2).toString();
                } else {
                	status_value="2";
                }
       
                  try{
                 	  List<MicLogEntitiy> micLogList = new ArrayList<MicLogEntitiy>();
                       MicLogEntitiy micLogEntitiy = new MicLogEntitiy();
                       micLogEntitiy.setMsisdn(msisdn);
                       micLogEntitiy.setLogMessage("GET_MIC_STATUS"+" MIC STATUS VALUE"+status_value);
                       micLogEntitiy.setClientType("WEB/API");
                       micLogEntitiy.setLogId(0);
                        micLogList.add(micLogEntitiy);
                       micLogRepository.save(micLogList);
                   }catch (Exception e) {
                	   
						e.printStackTrace();
					}         
           }
           
           catch(Exception exception){
        	   status_value="2";
              	  List<MicLogEntitiy> micLogList = new ArrayList<MicLogEntitiy>();
                    MicLogEntitiy micLogEntitiy = new MicLogEntitiy();
                    micLogEntitiy.setMsisdn(msisdn);
                    micLogEntitiy.setLogMessage("GET_MIC_STATUS"+exception);
                    micLogEntitiy.setClientType("WEB");
                    micLogEntitiy.setLogId(0);
                     micLogList.add(micLogEntitiy);
                    micLogRepository.save(micLogList);
               
        	   
                  exception.printStackTrace();
                  
           }
           finally {
        	    
        	   connection.close();
        	   statement.close();
		}
     return status_value;

    } 


        @Override
        public boolean saveMicStatus(String msisdn, String subscriber_id, String status) {
                        // TODO Auto-generated method stub
        	 List<MicStatusEntity> micInfoList = new ArrayList<MicStatusEntity>();
             MicStatusEntity micStatus=new MicStatusEntity();
             micStatus.setMsisdn(msisdn);
             micStatus.setSubscriberId(subscriber_id);
             micStatus.setStatus(Integer.parseInt(status));
           
             micInfoList.add(micStatus);
             try{
             micStatusRepository.save(micInfoList);
             }catch (Exception e) {
                         e.printStackTrace();
                         return false;
             }
             return true;

            }
                
    @Override
    public MicStatusEntity saveMicStatusBymobile(String msisdn, String subscriber_id, String status) {
     List<MicStatusEntity> micInfoList = new ArrayList<MicStatusEntity>();
     MicStatusEntity micStatus=new MicStatusEntity();
     micStatus.setMsisdn(msisdn);
     micStatus.setSubscriberId(subscriber_id);
     micStatus.setStatus(Integer.parseInt(status));
   
     micInfoList.add(micStatus);

     micStatusRepository.save(micInfoList);
     return null;

    }

     @Override
    public MicInformation viewwebDocument(String msisdn) {
           // TODO Auto-generated method stub
    	 String clienttype="WEB";
           MicInformation micInformation=null;
           List<MicInformationView> micInfoList = new ArrayList<MicInformationView>();
           micInformation= new MicInformation();
           try {
                  Iterable<MicInformationEntity> list = micinformationRepository.findAll(QMicInformationEntity.micInformationEntity.msisdn.eq(msisdn));
                  for (MicInformationEntity se : list){
                        //micInfoList.add(fromMicInformation(se));
                	  
                	  if(se.getCustomerSignature().equalsIgnoreCase("NA")){
                       micInformation.setFirstNmae(getDecodedStr(se.getFirstNmae()));
                       micInformation.setLastName(getDecodedStr(se.getLastName()));
                       micInformation.setAddress(getDecodedStr(se.getAddress()));                      
                       micInformation.setIdCard(getDecodedStr(se.getIdCard()));
                       micInformation.setDate_of_issue(se.getDate_of_issue());
                       micInformation.setPlaceOfIssue(getDecodedStr(se.getPlaceOfIssue()));                       
                       micInformation.setProvince(getDecodedStr(se.getProvince()));                               
                       micInformation.setDistrict(getDecodedStr(se.getDistrict()));
                      // micInformation.setCustomerGender(getDecodedStr(se.getCustomerGender()));
                	  }
                	  else{
                		 micInformation.setFirstNmae(se.getFirstNmae());
                         micInformation.setLastName(se.getLastName());
                         micInformation.setAddress(se.getAddress());                        
                         micInformation.setIdCard(se.getIdCard());
                         micInformation.setDate_of_issue(se.getDate_of_issue());
                         micInformation.setPlaceOfIssue(se.getPlaceOfIssue());                       
                         micInformation.setProvince(se.getProvince());                                 
                         micInformation.setDistrict(se.getDistrict());  
                        
                	  }
                	   micInformation.setDob(se.getDob());
                       micInformation.setCountry(se.getCountry());
                       micInformation.setMsisdn(se.getMsisdn());
                       micInformation.setGender(se.getGender());
                               String firstsidePath = se.getFirstSideIdcard();//baseDirectory+"subscriber_idcard\\" + name+"_firstside_idcard"+".jpg";
                               String secondsidePath = se.getSecondSideIdcard();//baseDirectory+"subscriber_idcard\\" + name+"_secondside_idcard"+".jpg";
                               String custPortraitPath =se.getCustomerPortrait();// baseDirectory+"subscriber_portrait\\" + name+"_portrait"+".jpg";
                               String custSignaturePath = se.getCustomerSignature();//baseDirectory+"subscriber_signature\\" + name+"_sign"+".jpg";
                               
                               
                                /*String firstsidePath = baseDirectory+"subscriber_idcard\\" + name+"_firstside_idcard"+".jpg";
                               String secondsidePath = baseDirectory+"subscriber_idcard\\" + name+"_secondside_idcard"+".jpg";
                               String custPortraitPath = baseDirectory+"subscriber_portrait\\" + name+"_portrait"+".jpg";
                               String custSignaturePath = baseDirectory+"subscriber_signature\\" + name+"_sign"+".jpg";*/
                               
                               micInformation.setFirstSideIdcard(firstsidePath);
                               micInformation.setSecondSideIdcard(secondsidePath);
                               micInformation.setCustomerPortrait(custPortraitPath);
                               micInformation.setCustomerSignature(custSignaturePath);
                               try{
                             	  List<MicLogEntitiy> micLogList = new ArrayList<MicLogEntitiy>();
                                   MicLogEntitiy micLogEntitiy = new MicLogEntitiy();
                                   micLogEntitiy.setMsisdn(msisdn);
                                   micLogEntitiy.setLogMessage("MIC_VIEW_HISTORY"+" MIC VIEW Successfully");
                                   micLogEntitiy.setClientType(clienttype);
                                   micLogEntitiy.setLogId(0);
                                   micLogList.add(micLogEntitiy);
                                   micLogRepository.save(micLogList);
                               }catch (Exception e) {
                            	  
									e.printStackTrace();
								}
                  }
           } catch (Exception e) {
        	   List<MicLogEntitiy> micLogList = new ArrayList<MicLogEntitiy>();
               MicLogEntitiy micLogEntitiy = new MicLogEntitiy();
               micLogEntitiy.setMsisdn(msisdn);
               micLogEntitiy.setLogMessage("MIC_VIEW_HISTORY "+e);
               micLogEntitiy.setClientType(clienttype);
               micLogEntitiy.setLogId(0);
               micLogList.add(micLogEntitiy);
               micLogRepository.save(micLogList);
                  logger.error("#viewMicDocument --- error retrieving Mic Document!", e);
           }
           return micInformation;
           
    }

                
                public byte[] convertStrToBase64(String str){
                                byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
                                
                                return bytesEncoded;
                }
                //Change bool to string by Oneclick
                @Override
                public String saveMicDocument(String firstNmae, String lastName, String dob, String idCard,String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
                     String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
                     String customerSignature,String gender)throws SubscriberNotFoundException {
                	//Change bool to string by Oneclick  ex micstatus = true/false to String(Success)                      
                	String micstatus="Success";
                	customerSignature="Ti9B";
                                           String clienttype="Web";
                                           List<MicInformationEntity> micInfoList = new ArrayList();
                                            String uploadDir = this.applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
                                            String avatarDir = uploadDir + File.separator + this.applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
                                            
                                            GetTokenByEposSoap getToken = new GetTokenByEposSoap();
                                            List<EposTokenModel> eposTokenModelList = getToken.getToken(msisdn);
                                            
                                            String tokenStatus = ((EposTokenModel)eposTokenModelList.get(0)).getStatus();
                                            String tokenKey = ((EposTokenModel)eposTokenModelList.get(0)).getSessionid();
                                            String tokenMessage = ((EposTokenModel)eposTokenModelList.get(0)).getMessage();
                                            
                                            if (tokenStatus.equalsIgnoreCase("0"))
                                            {
                                              UpdateCustomerInforByEposSoap updateCustomerInfor = new UpdateCustomerInforByEposSoap();
                                              List<UpdateCustomerInforModel> updateCustomerInforModelList = updateCustomerInfor.updateMicInEposWithGender(tokenKey, getDecodedStr(firstNmae), getDecodedStr(lastName), dob, getDecodedStr(idCard), 
                                                date_of_issue, getDecodedStr(placeOfIssue), getDecodedStr(address), getDecodedStr(province), getDecodedStr(district), country, 
                                                msisdn, firstSideIdcard, secondSideIdcard, customerPortrait, 
                                                customerSignature,clienttype,gender);
                                              String transId = ((UpdateCustomerInforModel)updateCustomerInforModelList.get(0)).getTransId();
                                              String updateMicStatus = ((UpdateCustomerInforModel)updateCustomerInforModelList.get(0)).getStatus();
                                              String updateMicMsg = ((UpdateCustomerInforModel)updateCustomerInforModelList.get(0)).getMessage();
                                             
                                              if (updateMicStatus.equalsIgnoreCase("0")) {
                                               
                                                  SubscriberEntity subscriber = (SubscriberEntity)this.subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
                                                  if (subscriber == null) {
                                                    throw new SubscriberNotFoundException();
                                                  }
                                                  try{
                                                  int width = Integer.parseInt(this.applicationConfigurationService.get("image.avatar.width", "100").toString());
                                                  int height = Integer.parseInt(this.applicationConfigurationService.get("image.avatar.height", "100").toString());
                                                  
                                                  byte[] decodedFirstIdCard = Base64.decodeBase64(firstSideIdcard.getBytes());
                                                  InputStream isFirstIdCard = new ByteArrayInputStream(decodedFirstIdCard);
                                                  
                                                  byte[] decodedSecondIdCard = Base64.decodeBase64(secondSideIdcard.getBytes());
                                                  InputStream isSecondIdCard = new ByteArrayInputStream(decodedSecondIdCard);
                                                  
                                                  byte[] decodedCustPortrait = Base64.decodeBase64(customerPortrait.getBytes());
                                                  InputStream isCustPortrait = new ByteArrayInputStream(decodedCustPortrait);
                                                  
                                                  File avatarFileFirstId = new File(avatarDir, msisdn + "_firstside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") + "." + "jpg");
                                                  File avatarFileSecondId = new File(avatarDir, msisdn + "_secondside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") + "." + "jpg");
                                                  File avatarCustPortrait = new File(avatarDir, msisdn + "_cust_portrait" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") + "." + "jpg");
                                                  try
                                                  {
                                                  int scaleX = 0;int scaleY = 0;
                                                  if ((scaleX > 0) && (scaleY > 0))
                                                  {
                                                    LoggingUtil.debug(logger, "#saveMicDocumentByMobile --- resizing image to " + width + "x" + height);
                                                    File tmpFirstId = new File(avatarDir, avatarFileFirstId.getName() + ".tmp");
                                                    FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(tmpFirstId));
                                                    Thumbnails.of(new File[] { tmpFirstId }).size(scaleX, scaleY).toFile(avatarFileFirstId);
                                                    tmpFirstId.delete();
                                                    
                                                    File tmpSecondId = new File(avatarDir, avatarFileSecondId.getName() + ".tmp");
                                                    FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(tmpSecondId));
                                                    Thumbnails.of(new File[] { tmpSecondId }).size(scaleX, scaleY).toFile(avatarFileSecondId);
                                                    tmpSecondId.delete();
                                                    
                                                    File tmpCustPortrait = new File(avatarDir, avatarCustPortrait.getName() + ".tmp");
                                                    FileCopyUtils.copy(isCustPortrait, new FileOutputStream(tmpCustPortrait));
                                                    Thumbnails.of(new File[] { tmpCustPortrait }).size(scaleX, scaleY).toFile(avatarCustPortrait);
                                                    tmpCustPortrait.delete();
                                                  }
                                                  else
                                                  {
                                                    FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(avatarFileFirstId));
                                                    FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(avatarFileSecondId));
                                                    FileCopyUtils.copy(isCustPortrait, new FileOutputStream(avatarCustPortrait));
                                                	setFilePermissions(avatarFileFirstId);
                                                	setFilePermissions(avatarFileSecondId);
                                                	setFilePermissions(avatarCustPortrait);
                                                  }
                                                  
                                                  LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar FirstID " + avatarFileFirstId.getName() + " for subscriber " + msisdn);
                                                  LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar SecondID " + avatarFileSecondId.getName() + " for subscriber " + msisdn);
                                                  LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustPortrait " + avatarCustPortrait.getName() + " for subscriber " + msisdn);
                                                  
                                                 
                                                }catch (Exception e) {
            										// TODO: handle exception
                                                	e.printStackTrace();
            									}
                                                  this.micInformation = new MicInformation();
                                                  MicInformationEntity micInformationEntity = new MicInformationEntity();
                                                  
                                                  if(firstNmae==null){
                                                	  firstNmae="NA";
                                                  }
                                                  if(lastName==null){
                                                	  lastName="NA";
                                                  }
                                                  if(dob==null){
                                                	  dob="NA";
                                                  }
                                                  if(idCard==null){
                                                	  idCard="NA";
                                                  }
                                                  if(placeOfIssue==null){
                                                	  placeOfIssue="NA";
                                                  }
                                                  if(address==null){
                                                	  address="NA";
                                                  }
                                                  if(province==null){
                                                	  province="NA";
                                                  }
                                                  if(district==null){
                                                	  district="NA";
                                                  }
                                                  
                                                  if(country==null){
                                                	  country="NA";
                                                  }
                                                  if(msisdn==null){
                                                	  msisdn="NA";
                                                  }
                                                  if(gender==null){
                                                	  gender="N/A";
                                                  }
                                                 
                                                  micInformationEntity.setFirstNmae(firstNmae);
                                                  micInformationEntity.setLastName(lastName);
                                                  micInformationEntity.setDob(dob);
                                                  micInformationEntity.setIdCard(idCard);
                                                  micInformationEntity.setDate_of_issue(date_of_issue);
                                                  micInformationEntity.setPlaceOfIssue(placeOfIssue);
                                                  micInformationEntity.setAddress(address);
                                                  micInformationEntity.setProvince(province);
                                                  micInformationEntity.setDistrict(district);
                                                  micInformationEntity.setCountry(country);
                                                  micInformationEntity.setMsisdn(msisdn);
                                                  micInformationEntity.setFirstSideIdcard(createImageURL(avatarFileFirstId.getName()));
                                                  micInformationEntity.setSecondSideIdcard(createImageURL(avatarFileSecondId.getName()));
                                                  micInformationEntity.setCustomerPortrait(createImageURL(avatarCustPortrait.getName()));
                                                  micInformationEntity.setCustomerSignature("NA");
                                                  micInformationEntity.setId(Integer.valueOf(0));
                                                  micInformationEntity.setGender(gender);
                                                  micInfoList.add(micInformationEntity);
                                                  
                                                  this.micinformationRepository.save(micInfoList);
                                                  if(mode.equalsIgnoreCase("test")){
                                                  micInformationService.saveMicStatus(msisdn, msisdn, "1");
                                                  }
                                                  micstatus="Success";
                                                 
                                                }
                                                catch (Exception e)
                                                {
                                                	micstatus="Unsuccess";
                                                  logger.error("#saveMicDocumentByMobile(inputStream) -- error occurred when uploading and setting for subscriber ID card , portrait and signature  " + msisdn, e);
                                                }
                                              }
                                              else
                                              {
                                            	  micstatus = updateMicMsg;
                                              }
                                            }
                                            else
                                            {
                                            	 micstatus = "Unsuccess";
                                            }
                                            return micstatus;
                                          }
                

                /*@Override
    public void saveMicDocument(String firstNmae, String lastName, String dob, String idCard,String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
         String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
         String customerSignature)throws SubscriberNotFoundException {

           
     String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
     String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();

     SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
     if (subscriber == null) throw new SubscriberNotFoundException();
     
     try {
            int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
            int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());

            byte[] decodedFirstIdCard = Base64.decodeBase64(firstSideIdcard.getBytes());
            InputStream isFirstIdCard = new ByteArrayInputStream(decodedFirstIdCard);
            
            byte[] decodedSecondIdCard = Base64.decodeBase64(secondSideIdcard.getBytes());
            InputStream isSecondIdCard = new ByteArrayInputStream(decodedSecondIdCard);
            
            byte[] decodedCustPortrait = Base64.decodeBase64(customerPortrait.getBytes());
            InputStream isCustPortrait = new ByteArrayInputStream(decodedCustPortrait);
            
            byte[] decodedCustSign = Base64.decodeBase64(customerSignature.getBytes());
            InputStream isCustSign = new ByteArrayInputStream(decodedCustSign);
            
            
            File avatarFileFirstId = new File(avatarDir, msisdn + "_firstside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
            File avatarFileSecondId = new File(avatarDir, msisdn + "_secondside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
            File avatarCustPortrait = new File(avatarDir, msisdn + "_cust_portrait" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
           // File avatarCustSign = new File(avatarDir, msisdn + "_cust_signature" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
            
            int scaleX=0; int scaleY=0;
            if (scaleX > 0 && scaleY > 0){
                  
                  LoggingUtil.debug(logger, "#saveMicDocumentByMobile --- resizing image to " + width + "x" + height);
                  File tmpFirstId = new File(avatarDir, avatarFileFirstId.getName() + ".tmp");
                  FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(tmpFirstId));
                  Thumbnails.of(tmpFirstId).size(scaleX, scaleY).toFile(avatarFileFirstId);
                  tmpFirstId.delete();
                  
                  File tmpSecondId = new File(avatarDir, avatarFileSecondId.getName() + ".tmp");
                  FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(tmpSecondId));
                  Thumbnails.of(tmpSecondId).size(scaleX, scaleY).toFile(avatarFileSecondId);
                  tmpSecondId.delete();
                  
                  File tmpCustPortrait = new File(avatarDir, avatarCustPortrait.getName() + ".tmp");
                  FileCopyUtils.copy(isCustPortrait, new FileOutputStream(tmpCustPortrait));
                  Thumbnails.of(tmpCustPortrait).size(scaleX, scaleY).toFile(avatarCustPortrait);
                  tmpCustPortrait.delete();
                  
                  File tmpCustSign = new File(avatarDir, avatarCustSign.getName() + ".tmp");
                  FileCopyUtils.copy(isCustSign, new FileOutputStream(tmpCustSign));
                  Thumbnails.of(tmpCustSign).size(scaleX, scaleY).toFile(avatarCustSign);
                  tmpCustSign.delete();
                  
            }else{
                  FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(avatarFileFirstId));
                  FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(avatarFileSecondId));
                  FileCopyUtils.copy(isCustPortrait, new FileOutputStream(avatarCustPortrait));
                 // FileCopyUtils.copy(isCustSign, new FileOutputStream(avatarCustSign));
            }
            
            LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar FirstID " + avatarFileFirstId.getName() + " for subscriber " + msisdn);
            LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar SecondID " + avatarFileSecondId.getName() + " for subscriber " + msisdn);
            LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustPortrait " + avatarCustPortrait.getName() + " for subscriber " + msisdn);
           // LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustSignature " + avatarCustSign.getName() + " for subscriber " + msisdn);
            
                  List<MicInformationEntity> micInfoList = new ArrayList<MicInformationEntity>();
                  
                  micInformation = new MicInformation();
                  MicInformationEntity micInformationEntity= new MicInformationEntity();
                  
                  micInformationEntity.setFirstNmae(firstNmae);
                  micInformationEntity.setLastName(lastName);
                  micInformationEntity.setDob(dob);
                  micInformationEntity.setIdCard(idCard);
                  micInformationEntity.setDate_of_issue(date_of_issue);
                  micInformationEntity.setPlaceOfIssue(placeOfIssue);
                  micInformationEntity.setAddress(address);
                  micInformationEntity.setProvince(province);
                  micInformationEntity.setDistrict(district);
                  micInformationEntity.setCountry(country);
                  micInformationEntity.setMsisdn(msisdn);
                   micInformationEntity.setFirstSideIdcard(createImageURL(avatarFileFirstId.getName()));
                   micInformationEntity.setSecondSideIdcard(createImageURL(avatarFileSecondId.getName()));
                   micInformationEntity.setCustomerPortrait(createImageURL(avatarCustPortrait.getName()));
                   micInformationEntity.setCustomerSignature("NA");
                  micInformationEntity.setId(0);
                  
                  micInfoList.add(micInformationEntity);
                  
                  micinformationRepository.save(micInfoList);

     } catch (Exception e) {
         logger.error("#saveMicDocumentByMobile(inputStream) -- error occurred when uploading and setting for subscriber ID card , portrait and signature  " + msisdn, e);
     }
           
    }*/
                
                
                /*public byte[] convertStrToBase64(String str){
                                byte[] bytesEncoded = Base64.encodeBase64(str.getBytes());
                                System.out.println("encoded value is " + new String(bytesEncoded));
                                return bytesEncoded;
                }
                
                public byte[] convertBase64ToStr(byte[] bytesEncoded)
                {
                                // Decode data on other side, by processing encoded data
                                byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
                                System.out.println("Decoded value is " + new String(valueDecoded));
                                return valueDecoded;
                }*/
                
    
          




private void setFilePermissions(File file) {
	if (file == null) return;
	
	try {
		Path path = Paths.get(file.getAbsolutePath());
        if (!Files.exists(path)) Files.createFile(path);
        
        Set<PosixFilePermission> perms = Files.readAttributes(path,PosixFileAttributes.class).permissions();

        System.out.format("Permissions before: %s%n",  PosixFilePermissions.toString(perms));

        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.OTHERS_READ);

        Files.setPosixFilePermissions(path, perms);
        
	} catch (Exception e) {
		logger.error("#setFilePermissions --- error setting file permissions for file " + file.getName(), e);
	}
}
     
/*
//public String base64ToImg_ImgToBase64(String base64String, String formatName) throws FileNotFoundException, IOException
public String base64ToImg_ImgToBase64(String base64String) throws FileNotFoundException, IOException
{
    System.out.println("Image Format Change == 1");
   // String outputImagePath = "D:\\Pic312.PNG";
    logger.error("#viewMicDocument --- Image transferred 11111");
    
    String uploadDir = this.applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
    System.out.println("uploadDir 11111"+uploadDir);
    String avatarDir = uploadDir + File.separator + this.applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
    String  tmpFirstId = avatarDir+"/micdoc.png";
    System.out.println("uploadDir 11111"+avatarDir);
  //  formatName ="JPG";
    
    //if(formatName.equalsIgnoreCase("JPG") || formatName.equalsIgnoreCase("JPEG") || formatName.equalsIgnoreCase("BMP"))
    {
        System.out.println("Image Format Change == 2");
        FileOutputStream outputStream = new FileOutputStream(tmpFirstId);
    
       // base64String="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AAAAAAAJAAAAAAAAAAABADhCSU0nEAAAAAAACgABAAAAAAAAAAI4QklNA/UAAAAAAEgAL2ZmAAEAbGZmAAYAAAAAAAEAL2ZmAAEAoZmaAAYAAAAAAAEAMgAAAAEAWgAAAAYAAAAAAAEANQAAAAEALQAAAAYAAAAAAAE4QklNA/gAAAAAAHAAAP////////////////////////////8D6AAAAAD/////////////////////////////A+gAAAAA/////////////////////////////wPoAAAAAP////////////////////////////8D6AAAOEJJTQQIAAAAAAAQAAAAAQAAAkAAAAJAAAAAADhCSU0EHgAAAAAABAAAAAA4QklNBBoAAAAAA0sAAAAGAAAAAAAAAAAAAAAuAAAAoAAAAAsAcAAwADEAMQA0ADEALgBqAHAAZQBnAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAACgAAAALgAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAABAAAAABAAAAAAAAbnVsbAAAAAIAAAAGYm91bmRzT2JqYwAAAAEAAAAAAABSY3QxAAAABAAAAABUb3AgbG9uZwAAAAAAAAAATGVmdGxvbmcAAAAAAAAAAEJ0b21sb25nAAAALgAAAABSZ2h0bG9uZwAAAKAAAAAGc2xpY2VzVmxMcwAAAAFPYmpjAAAAAQAAAAAABXNsaWNlAAAAEgAAAAdzbGljZUlEbG9uZwAAAAAAAAAHZ3JvdXBJRGxvbmcAAAAAAAAABm9yaWdpbmVudW0AAAAMRVNsaWNlT3JpZ2luAAAADWF1dG9HZW5lcmF0ZWQAAAAAVHlwZWVudW0AAAAKRVNsaWNlVHlwZQAAAABJbWcgAAAABmJvdW5kc09iamMAAAABAAAAAAAAUmN0MQAAAAQAAAAAVG9wIGxvbmcAAAAAAAAAAExlZnRsb25nAAAAAAAAAABCdG9tbG9uZwAAAC4AAAAAUmdodGxvbmcAAACgAAAAA3VybFRFWFQAAAABAAAAAAAAbnVsbFRFWFQAAAABAAAAAAAATXNnZVRFWFQAAAABAAAAAAAGYWx0VGFnVEVYVAAAAAEAAAAAAA5jZWxsVGV4dElzSFRNTGJvb2wBAAAACGNlbGxU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FhlW4u2zOrtXKHUXi1lFdfvccil0DsGva9zv+isluJVu0z7CP+Lf/wCRWj0iqit9m2919p4LmubA/k7wEFP/2ThCSU0EIQAAAAAAWQAAAAEBAAAADwBBAGQAbwBiAGUAIABQAGgAbwB0AG8AcwBoAG8AcAAAABUAQQBkAG8AYgBlACAAUABoAG8AdABvAHMAaABvAHAAIABDAFMANQAuADEAAAABADhCSU0EBgAAAAAABwAIAAAAAQEA/+ENGGh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8APD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS4wLWMwNjEgNjQuMTQwOTQ5LCAyMDEwLzEyLzA3LTEwOjU3OjAxICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczpjcnM9Imh0dHA6Ly9ucy5hZG9iZS5jb20vY2FtZXJhLXJhdy1zZXR0aW5ncy8xLjAvIiB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgY3JzOkFscmVhZHlBcHBsaWVkPSJUcnVlIiBwaG90b3Nob3A6Q29sb3JNb2RlPSIzIiB4bXA6Q3JlYXRlRGF0ZT0iMjAxNS0wOC0xMlQxMjozMDoxOSswNTozMCIgeG1wOk1vZGlmeURhdGU9IjIwMTUtMDgtMTJUMTU6MTY6MjMrMDU6MzAiIHhtcDpNZXRhZGF0YURhdGU9IjIwMTUtMDgtMTJUMTU6MTY6MjMrMDU6MzAiIGRjOmZvcm1hdD0iaW1hZ2UvanBlZyIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCMjlGOENFQUQ2NDBFNTExQUFEMEI2NDQ2NjA1MUVFQyIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCMjlGOENFQUQ2NDBFNTExQUFEMEI2NDQ2NjA1MUVFQyIgeG1wTU06T3JpZ2luYWxEb2N1bWVudElEPSJ4bXAuZGlkOkIyOUY4Q0VBRDY0MEU1MTFBQUQwQjY0NDY2MDUxRUVDIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6QjI5RjhDRUFENjQwRTUxMUFBRDBCNjQ0NjYwNTFFRUMiIHN0RXZ0OndoZW49IjIwMTUtMDgtMTJUMTU6MTY6MjMrMDU6MzAiIHN0RXZ0OnNvZnR3YXJlQWdlbnQ9IkFkb2JlIFBob3Rvc2hvcCBDUzUuMSBXaW5kb3dzIiBzdEV2dDpjaGFuZ2VkPSIvIi8+IDwvcmRmOlNlcT4gPC94bXBNTTpIaXN0b3J5PiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICA8P3hwYWNrZXQgZW5kPSJ3Ij8+/+4ADkFkb2JlAGRAAAAAAf/bAIQAAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB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";// = "ddsddasd";
       // base64String = "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";
        byte[] decodedString = java.util.Base64.getDecoder().decode(base64String);
        InputStream in = new ByteArrayInputStream(decodedString);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        boolean result = ImageIO.write(bImageFromConvert, "PNG", outputStream);
    
        if (result) 
        {
            System.out.println("Image converted successfully.");
            File tempFile = new File(tmpFirstId);
            byte[] array = Files.readAllBytes(tempFile.toPath());
            	tempFile.delete();
            //BASE64Encoder encoder = new BASE64Encoder();
            	String value=Base64.encodeBase64String(array);
            	 System.out.println("Image converted successfully. 222  = "+value);
            return  value;
        
        }
        return base64String;
       
    }
   // else
    //	return base64String;
    
}*/

private String getDecodedStr(String strEncoded)
{
       
       byte[] byteName = Base64.decodeBase64(strEncoded.getBytes());                            
       String strName = new String(byteName);                        
       return strName;

}
@Override
//add new method for gender features by oneclick
public MicInformation saveMicDocumentByMobilewithGender(String firstNmae, String lastName, String dob, String idCard,
              String date_of_issue, String placeOfIssue, String address, String province, String district, String country,
              String msisdn, String firstSideIdcard, String secondSideIdcard, String customerPortrait,
              String customerSignature, String gender)throws SubscriberNotFoundException {
       
                  
                //micInformation = new MicInformation();
                List<MicInformationView> micList = new ArrayList<MicInformationView>();
                
                try {
                	 
                       Iterable<MicInformationEntity> micIt = micinformationRepository.findAll(QMicInformationEntity.micInformationEntity.msisdn.eq(msisdn));
                       
                       for (MicInformationEntity se : micIt){
                             micList.add(fromMicInformationWithGender(se));
                       }
                } catch (Exception e) {
                       logger.error("#saveMicDocumentByMobilewithGender --- error get Mic Document!", e);
                }
                
                if(!micList.isEmpty()){
                       micInformation.setStatus("3");
                       micInformation.setMessage("Cannot update your information");
                             
                }
                else{

            
            	 String client_type = "MOBILE";	
            	
            	// byte[] provinceByte = convertStrToBase64(province);
                            //byte[] districtByte = convertStrToBase64(district);
       GetTokenByEposSoap getToken = new GetTokenByEposSoap();
       List<EposTokenModel> eposTokenModelList =  getToken.getToken(msisdn);
       
       String tokenStatus = eposTokenModelList.get(0).getStatus();
       String tokenKey = eposTokenModelList.get(0).getSessionid();
       String tokenMessage = eposTokenModelList.get(0).getMessage();
       
      // System.out.println(tokenStatus + ","+tokenKey +"," +tokenMessage);
      
            	// String tokenStatus = "0";
       if(tokenStatus.equalsIgnoreCase("0")){
              UpdateCustomerInforByEposSoap updateCustomerInfor = new UpdateCustomerInforByEposSoap();
            
              List<UpdateCustomerInforModel> updateCustomerInforModelList = updateCustomerInfor.updateMicInEposWithGender(tokenKey,  firstNmae,  lastName,  dob,  idCard,
                           date_of_issue,  placeOfIssue,  address,  province,  district,  country,
                           msisdn,  firstSideIdcard,  secondSideIdcard,  customerPortrait,
                           customerSignature, client_type,gender);
              
            /*  List<UpdateCustomerInforModel> updateCustomerInforModelList = updateCustomerInfor.updateMicInEpos(tokenKey,  firstNmae,  lastName,  dob,  idCard,
                      date_of_issue,  placeOfIssue,  address,  province,  district,  country,
                      msisdn,  firstSideIdcard,  secondSideIdcard,  customerPortrait,
                      customerSignature, client_type);*/
              
              String transId = updateCustomerInforModelList.get(0).getTransId();
              String updateMicStatus = updateCustomerInforModelList.get(0).getStatus();
              String updateMicMsg = updateCustomerInforModelList.get(0).getMessage();
            //  String updateMicStatus = "0";
              if(updateMicStatus.equalsIgnoreCase("0")){
                              try {  
                    String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
                    String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
              
                    SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn));
                    if (subscriber == null) throw new SubscriberNotFoundException();
                    
                    
                           int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
                           int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());

                           byte[] decodedFirstIdCard = Base64.decodeBase64(firstSideIdcard.getBytes());
                           InputStream isFirstIdCard = new ByteArrayInputStream(decodedFirstIdCard);
                           
                           byte[] decodedSecondIdCard = Base64.decodeBase64(secondSideIdcard.getBytes());
                           InputStream isSecondIdCard = new ByteArrayInputStream(decodedSecondIdCard);
                           
                           byte[] decodedCustPortrait = Base64.decodeBase64(customerPortrait.getBytes());
                           InputStream isCustPortrait = new ByteArrayInputStream(decodedCustPortrait);
                           
                           byte[] decodedCustSign = Base64.decodeBase64(customerSignature.getBytes());
                           InputStream isCustSign = new ByteArrayInputStream(decodedCustSign);
                           
                           
                           File avatarFileFirstId = new File(avatarDir, msisdn + "_firstside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                           File avatarFileSecondId = new File(avatarDir, msisdn + "_secondside_idcard" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                           File avatarCustPortrait = new File(avatarDir, msisdn + "_cust_portrait" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                           File avatarCustSign = new File(avatarDir, msisdn + "_cust_signature" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + AppDefaultValues.AVATAR_IMG_FILE_EXT);
                           
                           int scaleX=0; int scaleY=0;
                           if (scaleX > 0 && scaleY > 0){
                                  
                                  LoggingUtil.debug(logger, "#saveMicDocumentByMobilewithGender --- resizing image to " + width + "x" + height);
                                  File tmpFirstId = new File(avatarDir, avatarFileFirstId.getName() + ".tmp");
                                  FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(tmpFirstId));
                                  Thumbnails.of(tmpFirstId).size(scaleX, scaleY).toFile(avatarFileFirstId);
                                  tmpFirstId.delete();
                                  
                                  File tmpSecondId = new File(avatarDir, avatarFileSecondId.getName() + ".tmp");
                                  FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(tmpSecondId));
                                  Thumbnails.of(tmpSecondId).size(scaleX, scaleY).toFile(avatarFileSecondId);
                                  tmpSecondId.delete();
                                  
                                  File tmpCustPortrait = new File(avatarDir, avatarCustPortrait.getName() + ".tmp");
                                  FileCopyUtils.copy(isCustPortrait, new FileOutputStream(tmpCustPortrait));
                                  Thumbnails.of(tmpCustPortrait).size(scaleX, scaleY).toFile(avatarCustPortrait);
                                  tmpCustPortrait.delete();
                                  
                                  File tmpCustSign = new File(avatarDir, avatarCustSign.getName() + ".tmp");
                                  FileCopyUtils.copy(isCustSign, new FileOutputStream(tmpCustSign));
                                  Thumbnails.of(tmpCustSign).size(scaleX, scaleY).toFile(avatarCustSign);
                                  tmpCustSign.delete();
                                  
                           }else{
                                  FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(avatarFileFirstId));
                                  FileCopyUtils.copy(isSecondIdCard, new FileOutputStream(avatarFileSecondId));
                                  FileCopyUtils.copy(isCustPortrait, new FileOutputStream(avatarCustPortrait));
                                  FileCopyUtils.copy(isCustSign, new FileOutputStream(avatarCustSign));
                              	setFilePermissions(avatarFileFirstId);
                            	setFilePermissions(avatarFileSecondId);
                            	setFilePermissions(avatarCustPortrait);
                            	setFilePermissions(avatarCustSign);
                           }
                           
                           LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar FirstID " + avatarFileFirstId.getName() + " for subscriber " + msisdn);
                           LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar SecondID " + avatarFileSecondId.getName() + " for subscriber " + msisdn);
                           LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustPortrait " + avatarCustPortrait.getName() + " for subscriber " + msisdn);
                           LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar CustSignature " + avatarCustSign.getName() + " for subscriber " + msisdn);
                           
                                  List<MicInformationEntity> micInfoList = new ArrayList<MicInformationEntity>();
                                  
                                  
                                  MicInformationEntity micInformationEntity= new MicInformationEntity();
                                  
                                  if(firstNmae==null){
                                	  firstNmae="NA";
                                  }
                                  if(lastName==null){
                                	  lastName="NA";
                                  }
                                  if(dob==null){
                                	  dob="NA";
                                  }
                                  if(idCard==null){
                                	  idCard="NA";
                                  }
                                  if(placeOfIssue==null){
                                	  placeOfIssue="NA";
                                  }
                                  if(address==null){
                                	  address="NA";
                                  }
                                  if(province==null){
                                	  province="NA";
                                  }
                                  if(district==null){
                                	  district="NA";
                                  }
                                  
                                  if(country==null){
                                	  country="NA";
                                  }
                                  if(msisdn==null){
                                	  msisdn="NA";
                                  }
                                 
                                  
                                  micInformationEntity.setFirstNmae(firstNmae);
                                  micInformationEntity.setLastName(lastName);
                                  micInformationEntity.setDob(dob);
                                  micInformationEntity.setIdCard(idCard);
                                  micInformationEntity.setDate_of_issue(date_of_issue);
                                  micInformationEntity.setPlaceOfIssue(placeOfIssue);
                                  micInformationEntity.setAddress(address);
                                  micInformationEntity.setProvince(province);
                                  micInformationEntity.setDistrict(district);
                                  micInformationEntity.setCountry(country);
                                  micInformationEntity.setMsisdn(msisdn);
                                  micInformationEntity.setFirstSideIdcard(createImageURL(avatarFileFirstId.getName()));
                                  micInformationEntity.setSecondSideIdcard(createImageURL(avatarFileSecondId.getName()));
                                  micInformationEntity.setCustomerPortrait(createImageURL(avatarCustPortrait.getName()));
                                  micInformationEntity.setCustomerSignature(createImageURL(avatarCustSign.getName()));
                                  micInformationEntity.setId(0);
                                  micInformationEntity.setGender(gender);
                                  
                                  micInfoList.add(micInformationEntity);
                                  

                                  
                                  micinformationRepository.save(micInfoList);
                                  if(mode.equalsIgnoreCase("test")){
                                      micInformationService.saveMicStatus(msisdn, msisdn, "1");
                                      }
                                  micInformation.setStatus("0");
                                  micInformation.setMessage("Successfully Uploaded");
                                  /*
                                   ***************To main Log******************************* 
                                   */
                                 
                                  

                           
                    } catch (Exception e) {
                           logger.error("#saveMicDocumentByMobilewithGender(inputStream) -- error occurred when uploading and setting for subscriber ID card , portrait and signature  " + msisdn, e);
                           micInformation.setStatus("1");
                           micInformation.setMessage("Not Uploadeded");
                           e.printStackTrace();
                    }
              }else{// check and send response 4 for only that message by oneclick
            	  if(updateMicMsg.equals("Bạn đang sở hữu quá 03 thuê bao, vui lòng ghé cửa hàng Vietnamobile gần nhất để thực giao kết hợp đồng theo quy định"))
            	  {
            		  micInformation.setStatus("4");
                      micInformation.setMessage("Bạn đang sở hữu quá 03 thuê bao, vui lòng ghé cửa hàng Vietnamobile gần nhất để thực giao kết hợp đồng theo quy định");
            	  }
            	  else
            	  {
            		  micInformation.setStatus("1");
                      micInformation.setMessage("Not Uploadeded, Due to internal server error");
            	  }
            	  //Bạn đang sở hữu quá 03 thuê bao, vui lòng ghé cửa hàng Vietnamobile gần nhất để thực giao kết hợp đồng theo quy định
                   
              }
              
              //System.out.println(transId + ","+updateMicStatus +"," +updateMicMsg);
       }
       
                }
       
       return micInformation;
}

                
}

