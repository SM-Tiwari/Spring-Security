/**
 * AvatarServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.DefaultAvatarCategory;
import com.gnv.vnm.selfcare.core.fault.AvatarNotFoundException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.Avatar;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.AvatarService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.AvatarEntity;
import com.gnv.vnm.selfcare.dao.entity.QAvatarEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.repo.AvatarEntityRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.binary.Base64;
/**
 * @author nandipinto
 *
 */

@Service("avatarService")
public class AvatarServiceImpl implements AvatarService {
	private static final Logger logger = LoggerFactory.getLogger(AvatarServiceImpl.class);

	@Autowired
	private SubscriberRepository subscriberRepository;
	@Autowired
	private AvatarEntityRepository avatarRepository;
	
	@Autowired 
	private ApplicationConfigurationService applicationConfigurationService;

	
	private Avatar fromAvatarEntity(AvatarEntity source){
		if (source == null) return null;
		
		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		String avatarDir = applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();

		Avatar avatar = new Avatar(source.getId(), source.getCategory(), source.getTitle(), source.getFileName());
		avatar.setImageURL(imageSvr + imageDir + avatarDir + "/" + source.getFileName());
		
		return avatar;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#getTotalAvailableAvatars()
	 */
	@Override
	public long getTotalAvailableAvatars() {
		return avatarRepository.count();
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#getAllAvatars(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Avatar> getAllAvatars(Pageable page) {
		
		Page<AvatarEntity> list = avatarRepository.findAll(page);
		List<Avatar> tempList = new ArrayList<>();
		for (AvatarEntity ae:list.getContent()){
			tempList.add(fromAvatarEntity(ae));
		}
		
		return new PageImpl<>(tempList, page, list.getTotalElements());
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#getAvatarsByCategory(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Avatar> getAvatarsByCategory(String category, Pageable page) {
		
		Page<AvatarEntity> list = avatarRepository.findAll(QAvatarEntity.avatarEntity.category.containsIgnoreCase(category), page);
		List<Avatar> tempList = new ArrayList<>();
		for (AvatarEntity ae:list.getContent()){
			tempList.add(fromAvatarEntity(ae));
		}
		
		return new PageImpl<>(tempList, page, list.getTotalElements());
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#searchAvatars(java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Avatar> searchAvatars(String searchTerm, Pageable page) {
		
		Page<AvatarEntity> list = avatarRepository.findAll(
				QAvatarEntity.avatarEntity.category.containsIgnoreCase(searchTerm).or(QAvatarEntity.avatarEntity.title.containsIgnoreCase(searchTerm)), 
				page);
		List<Avatar> tempList = new ArrayList<>();
		for (AvatarEntity ae:list.getContent()){
			tempList.add(fromAvatarEntity(ae));
		}
		
		return new PageImpl<>(tempList, page, list.getTotalElements());
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#getSubscriberAvatar(java.lang.String)
	 */
	@Override
	public Avatar getSubscriberAvatar(String subscriberId) throws SubscriberNotFoundException {
		try {
			SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (subscriber != null){
				Integer avatarId = subscriber.getAvatarId();
				if (avatarId != null){
					AvatarEntity avatar = avatarRepository.findOne(avatarId);
					return fromAvatarEntity(avatar);
				}
			}else{
				throw new SubscriberNotFoundException();
			}
		} catch (Exception e) {
			logger.error("#getSubscriberAvatar -- error retrieving Avatar info for subscriber " + subscriberId, e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#setAvatar(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void setAvatar(String subscriberId, Integer avatarId) throws SubscriberNotFoundException, AvatarNotFoundException {
		try {
			long count = avatarRepository.count(QAvatarEntity.avatarEntity.id.eq(avatarId));
			if (count == 0) throw new AvatarNotFoundException();
			
			SubscriberEntity sub = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
			if (sub != null){
				sub.setAvatarId(avatarId);
				subscriberRepository.saveAndFlush(sub);
			}else{
				throw new SubscriberNotFoundException();
			}
			
		} catch (Exception e) {
			logger.error("#setAvatar(String, Integer) -- error occured when setting Avatar for subscriber= " + subscriberId, e);
		}
	}

	private void setFilePermissions(File file) {
		if (file == null) return;
		
		try {
			Path path = Paths.get(file.getAbsolutePath());
	        if (!Files.exists(path)) Files.createFile(path);
	        
	        Set<PosixFilePermission> perms = Files.readAttributes(path,PosixFileAttributes.class).permissions();

//	        System.out.format("Permissions before: %s%n",  PosixFilePermissions.toString(perms));

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
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#setAvatar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, byte[])
	 */
	@Override
	public String setAvatar(String subscriberId, String category, String title, String fileExt, byte[] bytes, int scaleX, int scaleY)  throws SubscriberNotFoundException{
		String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
		String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
		
		SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null) throw new SubscriberNotFoundException();
		try {
			if (!StringUtils.hasText(fileExt)) fileExt = AppDefaultValues.AVATAR_IMG_FILE_EXT;
			ImageInputStream iis = ImageIO.createImageInputStream(new ByteArrayInputStream(bytes)); //ImageIO.createImageInputStream(avatarFile);
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				logger.error("Invalid file type received from subscriber= " + subscriberId);
				return null;
			}

			File avatarFile = new File(avatarDir, subscriberId + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + fileExt);
			FileCopyUtils.copy(bytes, avatarFile);
			setFilePermissions(avatarFile);
			
			int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
			int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());
			if (scaleX > 0 && scaleY > 0){
				//ImageUtils.resizeImage(tmp, BufferedImage.TYPE_INT_ARGB, avatarFile, fileExt, width, height);

				LoggingUtil.debug(logger, "#setAvatar --- resizing image to " + width + "x" + height);
				File tmp = new File(avatarDir, avatarFile.getName() + ".tmp");
				FileCopyUtils.copy(bytes, tmp);
				Thumbnails.of(tmp).size(scaleX, scaleY).toFile(avatarFile);
				tmp.delete();
				
			}

			if (!StringUtils.hasText(category)) category = DefaultAvatarCategory.GENERAL.name();
			if (!StringUtils.hasText(title)) title = avatarFile.getName();
			
			AvatarEntity avatar = new AvatarEntity(category, title, avatarFile.getName(), height, width);
			avatar.setContent(bytes);
			
			Integer avatarId = avatarRepository.saveAndFlush(avatar).getId();
			
			LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar " + avatarFile.getName() + " for subscriber " + subscriberId);

			subscriber.setAvatarId(avatarId);
			subscriberRepository.saveAndFlush(subscriber);
			
			return createImageURL(avatarFile.getName());
		} catch (Exception e) {
			logger.error("#setAvatar(byte[]) -- error occurred when uploading and setting user Avatar for subscriber " + subscriberId, e);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#setAvatar(java.lang.String, java.lang.String, java.lang.String, java.io.InputStream, java.lang.String)
	 */
	@Override
	public String setAvatar(String subscriberId, String category, String title, InputStream inputStream, String fileExt, int scaleX, int scaleY) throws SubscriberNotFoundException{
		String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
		String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
	
		SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null) throw new SubscriberNotFoundException();

		try {
			if (!StringUtils.hasText(fileExt)) fileExt = AppDefaultValues.AVATAR_IMG_FILE_EXT;

			/*
			ImageInputStream iis = ImageIO.createImageInputStream(inputStream);
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				logger.error("Invalid file type received, file_ext= " + fileExt + ", subscriberId= " + subscriberId);
				return null;
			}
			*/
			
			int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
			int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());

			File avatarFile = new File(avatarDir, subscriberId + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + fileExt);

			if (scaleX > 0 && scaleY > 0){
				LoggingUtil.debug(logger, "#setAvatar --- resizing image to " + width + "x" + height);
				File tmp = new File(avatarDir, avatarFile.getName() + ".tmp");
				FileCopyUtils.copy(inputStream, new FileOutputStream(tmp));
				Thumbnails.of(tmp).size(scaleX, scaleY).toFile(avatarFile);
				tmp.delete();
				
			}else{
				FileCopyUtils.copy(inputStream, new FileOutputStream(avatarFile));
			}
			
			ImageInputStream iis = ImageIO.createImageInputStream(new FileInputStream(avatarFile));
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				logger.error("Invalid file type received, file_ext= " + fileExt + ", subscriberId= " + subscriberId);
				avatarFile.delete();
				return null;
			}

			setFilePermissions(avatarFile);

			
			LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar " + avatarFile.getName() + " for subscriber " + subscriberId);
			
			if (!StringUtils.hasText(category)) category = DefaultAvatarCategory.GENERAL.name();
			if (!StringUtils.hasText(title)) title = avatarFile.getName();

			AvatarEntity avatar = new AvatarEntity(category, title, avatarFile.getName(), height, width);
			avatar.setContent(FileCopyUtils.copyToByteArray(avatarFile));
			
			Integer avatarId = avatarRepository.saveAndFlush(avatar).getId();
			subscriber.setAvatarId(avatarId);
			subscriberRepository.saveAndFlush(subscriber);
			
			return createImageURL(avatarFile.getName());
		} catch (Exception e) {
			logger.error("#setAvatar(inputStream) -- error occurred when uploading and setting user Avatar for subscriber " + subscriberId, e);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.AvatarService#setAvatar(java.lang.String, java.lang.String, java.lang.String, java.io.File)
	 */
	@Override
	public String setAvatar(String subscriberId, String category, String title, File file, int scaleX, int scaleY) throws SubscriberNotFoundException {
		if (!file.exists() || file.isDirectory()) return null;
		
		String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
		String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
		SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(subscriberId));
		if (subscriber == null) throw new SubscriberNotFoundException();

		try {
			//first store file into avatar dir
			LoggingUtil.debug(logger, "#setAvatar --- uploading Avatar for subscriber " + subscriberId + ", input file= " + file.getName());
			
			String fileExt = FilenameUtils.getBaseName(file.getName());
			if (!StringUtils.hasText(fileExt)) fileExt = AppDefaultValues.AVATAR_IMG_FILE_EXT;
			
			File avatarFile = new File(avatarDir, subscriberId + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  "." + fileExt);
			
			ImageInputStream iis = new FileImageInputStream(file); //ImageIO.createImageInputStream(file);
			Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
			if (!iter.hasNext()) {
				logger.error("Invalid file type received, file_ext= " + fileExt + ", subscriberId= " + subscriberId);
				file.delete();
				return null;
			}
			
			int width = Integer.parseInt(applicationConfigurationService.get("image.avatar.width", "100").toString());
			int height = Integer.parseInt(applicationConfigurationService.get("image.avatar.height", "100").toString());

			if (scaleX > 0 && scaleY > 0){
				//ImageUtils.resizeImage(tmp, BufferedImage.TYPE_INT_ARGB, avatarFile, fileExt, width, height);

				LoggingUtil.debug(logger, "#setAvatar --- resizing image to " + width + "x" + height);
				Thumbnails.of(file).size(scaleX, scaleY).toFile(avatarFile);
				file.delete();
				
			}else{
				FileCopyUtils.copy(new FileInputStream(file), new FileOutputStream(avatarFile));
			}
			
			setFilePermissions(avatarFile);
			
			LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar " + avatarFile.getName() + " for subscriber " + subscriberId);
			
			if (!StringUtils.hasText(category)) category = DefaultAvatarCategory.GENERAL.name();
			if (!StringUtils.hasText(title)) title = file.getName();

			AvatarEntity avatar = new AvatarEntity(category, title, avatarFile.getName(), scaleY, scaleX);
			avatar.setContent(FileCopyUtils.copyToByteArray(file));
			
			Integer avatarId = avatarRepository.saveAndFlush(avatar).getId();
			subscriber.setAvatarId(avatarId);
			subscriberRepository.saveAndFlush(subscriber);
			
			return createImageURL(avatarFile.getName());
		} catch (Exception e) {
			logger.error("#setAvatar(file) -- error occurred when uploading and setting user Avatar for subscriber " + subscriberId, e);
		}
		return null;
	}

	private String createImageURL(String image){
		if (!StringUtils.hasText(image)) return "";
		
		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		String avatarDir = applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();

		return imageSvr + imageDir + avatarDir + "/" + image;
	}
	
	  @Override
      public String setAvatarnew(String base64String,String Subscriberid,String category,byte[] encoded){
                    
                      String uploadDir = applicationConfigurationService.get("imageserver.upload.dir", "/app/images").toString();
                      String avatarDir = uploadDir + File.separator + applicationConfigurationService.get("imageserver.imgdir.avatar", "/avatar").toString();
                      SubscriberEntity subscriber = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(Subscriberid));
                      int width = Integer.parseInt(this.applicationConfigurationService.get("image.avatar.width", "100").toString());
int height = Integer.parseInt(this.applicationConfigurationService.get("image.avatar.height", "100").toString());

byte[] decodedFirstIdCard = Base64.decodeBase64(base64String.getBytes());
InputStream isFirstIdCard = new ByteArrayInputStream(decodedFirstIdCard);
File avatarFile = new File(avatarDir, Subscriberid + "_" + AppUtils.dateToString(new Date(), "yyyyMMddHHmmss") +  ".jpg");
try
{
   int scaleX = 0;int scaleY = 0;
   if ((scaleX > 0) && (scaleY > 0))
   {
     LoggingUtil.debug(logger, "#saveMicDocumentByMobile --- resizing image to " + width + "x" + height);
     File tmpFirstId = new File(avatarDir, avatarFile.getName() + ".tmp");
     FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(tmpFirstId));
     Thumbnails.of(new File[] { tmpFirstId }).size(scaleX, scaleY).toFile(avatarFile);
     tmpFirstId.delete();
     
   }
   else
   {
     FileCopyUtils.copy(isFirstIdCard, new FileOutputStream(avatarFile));
     setFilePermissions(avatarFile);

   }
   System.out.println("#setAvatar --- setting up Avatar FirstID  -----"+avatarFile.getName()+" for subscriber " + Subscriberid);
   LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar FirstID " + avatarFile.getName() + " for subscriber " + Subscriberid);
   
  if (!StringUtils.hasText(category)) category = DefaultAvatarCategory.GENERAL.name();
                                     //if (!StringUtils.hasText("")) title = avatarFile.getName();
                                     
                                      AvatarEntity avatar = new AvatarEntity(category, avatarFile.getName(), avatarFile.getName(), height, width);
                                     //byte[] decodedBytes = Base64.decodeBase64(base64String);
                                     avatar.setContent(decodedFirstIdCard);
                                     
                                      Integer avatarId = avatarRepository.saveAndFlush(avatar).getId();
                                     
                                      LoggingUtil.debug(logger, "#setAvatar --- setting up Avatar " + avatarFile.getName() + " for subscriber " + Subscriberid);

                                     subscriber.setAvatarId(avatarId);
                                      System.out.println("#setAvatar --- setting up Avatar avatarId  -----"+avatarId+" for Content " + decodedFirstIdCard);
                                     subscriberRepository.saveAndFlush(subscriber);
                                     
                                      return createImageURL(avatarFile.getName());
   
  
 }catch (Exception e) {
                                                      // TODO: handle exception
      e.printStackTrace();
                                      }
                      
                      return avatarFile.toString();
                      
      }
}
