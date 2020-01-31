/**
 * SubscriberProfileController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.DefaultAvatarCategory;
import com.gnv.vnm.selfcare.core.fault.AvatarNotFoundException;
import com.gnv.vnm.selfcare.core.fault.SubscriberNotFoundException;
import com.gnv.vnm.selfcare.core.model.Avatar;
import com.gnv.vnm.selfcare.core.utils.CheckImageValidation;
import com.gnv.vnm.selfcare.webapi.DefaultApiResponse;
import com.gnv.vnm.selfcare.webapi.model.ApiResponse;
import com.gnv.vnm.selfcare.webapi.model.UploadAvatarRequest;
import com.gnv.vnm.selfcare.webapi.model.UploadAvatarResponse;

/**
 * @author nandipinto
 *
 */
@RestController
public class AvatarController extends BaseRestController {

	static final int AVATAR_LIST_PAGE_SIZE = 9;

	@GetMapping(value = "/avatar/categories")
	public ResponseEntity<?> getAvatarCategories() {
		return new ResponseEntity<>(DefaultAvatarCategory.values(), HttpStatus.OK);
	}

	@GetMapping(value = "/avatar/listall/{page}/{sort}")
	public ResponseEntity<?> getAvatarList(@PathVariable int page, @PathVariable String sort) {
		if (page > 0)
			page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Avatar> avatarList = avatarService.getAllAvatars(pageRequest);

		return new ResponseEntity<>(avatarList, HttpStatus.OK);
	}

	@GetMapping(value = "/avatar/list/{category}/{page}/{sort}")
	public ResponseEntity<?> getAvatarListByCategory(@PathVariable String category, @PathVariable int page,
			@PathVariable String sort) {
		if (page > 0)
			page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Avatar> avatarList = avatarService.getAvatarsByCategory(category, pageRequest);

		return new ResponseEntity<>(avatarList, HttpStatus.OK);
	}

	@GetMapping(value = "/avatar/search/{searchTerm}/{page}/{sort}")
	public ResponseEntity<?> searchAvatar(@PathVariable String searchTerm, @PathVariable int page,
			@PathVariable String sort) {
		if (page > 0)
			page = page - 1;
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Avatar> avatarList = avatarService.searchAvatars(searchTerm, pageRequest);

		return new ResponseEntity<>(avatarList, HttpStatus.OK);
	}

	@PutMapping(value = "/subscriber/setavatar/{msisdn}/{avatarId}")
	public ResponseEntity<?> setAvatar(@PathVariable String msisdn, @PathVariable int avatarId) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(DefaultApiResponse.UNAUTHORIZED.message(), HttpStatus.OK);
		}
		try {
			avatarService.setAvatar(msisdn, avatarId);
		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		} catch (AvatarNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.AVATAR_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/subscriber/avatar/{msisdn}")
	public ResponseEntity<?> getAvatar(@PathVariable String msisdn) {

		if (!msisdn.equals(getCurrentUserName())) {
			return new ResponseEntity<>(DefaultApiResponse.UNAUTHORIZED.message(), HttpStatus.OK);
		}

		Avatar avatar;
		try {
			avatar = avatarService.getSubscriberAvatar(msisdn);
			return new ResponseEntity<>(avatar, HttpStatus.OK);

		} catch (SubscriberNotFoundException e) {
			return new ResponseEntity<>(String.format(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message(), msisdn),
					HttpStatus.OK);
		}
	}

	@PostMapping(value = "/avatar/upload")
	public ResponseEntity<?> uploadAvatar(@RequestBody UploadAvatarRequest request) {
		if (request == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (!request.getMsisdn().equals(getCurrentUserName())) {
			return new ResponseEntity<>(new ApiResponse(false, DefaultApiResponse.UNAUTHORIZED.code(),
					DefaultApiResponse.UNAUTHORIZED.message()), HttpStatus.UNAUTHORIZED);
		}

		UploadAvatarResponse response = new UploadAvatarResponse();

		String imageBase64 = request.getEncodedImage().toString();
		String imageDataBytes = imageBase64.substring(imageBase64.indexOf(",") + 1);
		byte[] bytes = Base64.decodeBase64(imageDataBytes);
		CheckImageValidation checkImageValidation = new CheckImageValidation();
		String imageType = checkImageValidation.getImageType(bytes);

		String[] imge = { "PNG", "JPEG", "JPG" };
		// System.out.println(" imageType " + imageType);
		String imageFormat = request.getImageFormat().toUpperCase().trim();
		if (Arrays.asList(imge).contains(imageFormat)) {

		} else {
			System.out.println("If block ----");
			response.setCode(DefaultApiResponse.INVALIDIMAGE.code());
			response.setMessage(String.format(DefaultApiResponse.INVALIDIMAGE.message(), "encodedImage"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		if (imageType.equalsIgnoreCase("Unknown")) {
			/*
			 * return new ResponseEntity<>(new ApiResponse(true,
			 * DefaultApiResponse.INVALIDIMAGE.code(),
			 * DefaultApiResponse.INVALIDIMAGE.message()),
			 * HttpStatus.UNAUTHORIZED);
			 */
			response.setCode(DefaultApiResponse.INVALIDIMAGE.code());
			response.setMessage(String.format(DefaultApiResponse.INVALIDIMAGE.message(), "encodedImage"));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		String imageURL = null;
		if (request.getEncodedImage() != null) {
			try {
				imageURL = avatarService.setAvatar(request.getMsisdn(), null, null, request.getImageFormat(),
						Base64.decodeBase64(request.getEncodedImage()), 0, 0);
				response.setSuccessful(imageURL != null ? true : false);
				response.setCode(imageURL != null ? DefaultApiResponse.SUCCESS.code()
						: DefaultApiResponse.INVALID_PARAMETER_VALUE.code());
				response.setMessage(imageURL != null ? DefaultApiResponse.SUCCESS.message()
						: String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "encodedImage"));
				response.setImageURL(imageURL);

			} catch (SubscriberNotFoundException e) {
				response.setCode(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.code());
				response.setMessage(DefaultApiResponse.SUBSCRIBER_NOT_FOUND.message());
			}
		} else {
			response.setCode(DefaultApiResponse.INVALID_PARAMETER_VALUE.code());
			response.setMessage(String.format(DefaultApiResponse.INVALID_PARAMETER_VALUE.message(), "encodedImage"));
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private int getPageSize() {
		return Integer.parseInt(applicationConfigurationService
				.get("pagedlist.itemsperpage.avatar", AppDefaultValues.PAGED_LIST_SIZE + "").toString());
	}
}
