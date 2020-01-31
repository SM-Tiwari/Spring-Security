/**
 * Jun 6, 2018 6:42:48 PM
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManErrorMessage;
import com.gnv.vnm.selfcare.core.enums.DisplayOrder;
import com.gnv.vnm.selfcare.core.model.KeyValue;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.model.ProductGroup;
import com.gnv.vnm.selfcare.webportal.config.DefaultWebPortalMessages;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class GroupSharingController extends WebPortalBaseController {
	
	static final String CATEGORY_CODE = "GROUP_SHARING";

	@GetMapping(value = "/shop/group_sharing")
	public String list(Model model, Locale locale, HttpServletRequest request, Principal authUser) {
		
		model.addAttribute("productGroupList", productManagementService.getProductGroupsByCategoryCode(CATEGORY_CODE, locale.getLanguage(), false));
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		return ScreenNames.GROUP_SHARING_PRODUCT_GROUPS;
	}
	
	@GetMapping(value = "/shop/group_sharing/products/{groupId}")
	public String productList(@PathVariable int groupId, Model model, Locale locale, HttpServletRequest request, Principal authUser){

		ProductGroup productGroup = productManagementService.getProductGroupDetails(groupId, locale.getLanguage());
		model.addAttribute("productGroup", productGroup);
		
		List<Product> productList = productManagementService.getProductsByProductGroupId(groupId, DisplayOrder.TITLE_ASC, locale.getLanguage(), false);
		model.addAttribute("productList", productList);
		model.addAttribute("productListSize", productList.size());
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		return ScreenNames.GROUP_SHARING_PRODUCTS;
	}
	
	@GetMapping(value = "/shop/group_sharing/products/dtl/{id}")
	public String productDetails(@PathVariable int id, Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		Product product = productManagementService.getProductDetailsById(id, locale.getLanguage());
		model.addAttribute("product", product);
		
		ProductGroup productGroup = productManagementService.getProductGroupDetails(product.getProductGroupId(), locale.getLanguage());
		model.addAttribute("productGroup", productGroup);

		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		return ScreenNames.GROUP_SHARING_PRODUCT_DETAILS;
	}
	
	@GetMapping(value = "/secure/datasharing/{productCode}")
	public String dataSharing(@PathVariable String productCode, Model model, Locale locale, HttpServletRequest request, Principal authUser) {
		
		Product product = productManagementService.getProductDetailsByCode(productCode, locale.getLanguage());
		model.addAttribute("product", product);
		
		ProductGroup productGroup = productManagementService.getProductGroupDetails(product.getProductGroupId(), locale.getLanguage());
		model.addAttribute("productGroup", productGroup);

		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);
		
		model.addAttribute("phoneNumberRegex", applicationConfigurationService.get("phonenumber.regex", AppDefaultValues.PHONE_NO_REGEX).toString());
		return ScreenNames.REGISTER_DATA_SHARING;
	}
	
	@PostMapping(value = "/secure/datasharing/{productCode}/reg")
	public ResponseEntity<?> registerDataSharing(@PathVariable String productCode, Model model, Locale locale, HttpServletRequest request, Principal authUser) {

		KeyValue keyValue = new KeyValue();
		
		String[] params = ServletRequestUtils.getStringParameters(request, "phoneNumber");
		String message = "";
		if (params != null && params.length > 0) {
			
			List<String> phoneNumbers = Arrays.asList(params);
			
			BackEndAdapterResponse response = backEndRequestProcessor.registerDataSharing(authUser.getName(), productCode, phoneNumbers);
			String respCode = response.getResponseCode();
			keyValue.setKey(respCode);

			if (response.isSuccessful() || respCode.equals(VASManErrorMessage.SUCCESS.code())) {
				message = resolveMessage(messageSource, "Message.DataSharing.RegisterSuccess", null,
						DefaultWebPortalMessages.REGISTER_DATA_SHARING_SUCCESS.message(), locale);
				
			} else if (respCode.equals(VASManErrorMessage.NOT_ENOUGH_MONEY.code())
					|| respCode.equals(VASManErrorMessage.BALANCE_TOO_SMALL.code())) {
				message = resolveMessage(messageSource, "Message.DataSharing.RegisterFailNotEnoughBalance", null,
						"Your account is not sufficient. Please Top Up to register for this package.", locale);

			} else if (respCode.equals(VASManErrorMessage.ALREADY_REGISTERED.code())) {
				message = resolveMessage(messageSource, "Message.DataSharing.RegisterFailAlreadyRegistered", null,
						"The registration has failed. This package is already registered.", locale);

			} else {
				message = resolveMessage(messageSource, "Message.DataSharing.RegisterFail", null,
						"Your registration to package has failed.", locale);
			}

		}
		
		keyValue.setValue(message);
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

//		model.addAttribute("message", message);
		
//		return ScreenNames.REGISTER_DATA_SHARING;
		return new ResponseEntity<>(keyValue, HttpStatus.OK);
	}
}
