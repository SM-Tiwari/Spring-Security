/**
 * AvatarService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.io.File;
import java.io.InputStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gnv.vnm.selfcare.core.fault.AvatarNotFoundException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.Avatar;

/**
 * @author nandipinto
 *
 */
public interface AvatarService {

	long getTotalAvailableAvatars();
	
	Page<Avatar> getAllAvatars(Pageable page);
	
	Page<Avatar> getAvatarsByCategory(String category, Pageable page);
	
	Page<Avatar> searchAvatars(String searchTerm, Pageable page);
	
	Avatar getSubscriberAvatar(String subscriberId) throws SubscriberNotFoundException;
	
	void setAvatar(String subscriberId, Integer avatarId) throws SubscriberNotFoundException, AvatarNotFoundException;
	
	String setAvatar(String subscriberId, String category, String title, String fileExt, byte[] bytes, int scaleX, int scaleY) throws SubscriberNotFoundException;
	
	String setAvatar(String subscriberId, String category, String title, InputStream inputStream, String fileExt, int scaleX, int scaleY) throws SubscriberNotFoundException;
	
	String setAvatar(String subscriberId, String category, String title, File file, int scaleX, int scaleY) throws SubscriberNotFoundException;

	String setAvatarnew(String customer_PortraitImage, String name, String defaultAvatar, byte[] encoded);

}
