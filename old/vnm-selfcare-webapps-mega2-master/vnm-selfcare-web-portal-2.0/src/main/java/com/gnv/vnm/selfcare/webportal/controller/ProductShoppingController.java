/**
 * ProductShoppingController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.adapter.vasman.VASManErrorMessage;
import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.enums.DefaultProductCategory;
import com.gnv.vnm.selfcare.core.enums.DisplayOrder;
import com.gnv.vnm.selfcare.core.model.CallRecord;
import com.gnv.vnm.selfcare.core.model.ProductGroup;
import com.gnv.vnm.selfcare.core.model.ShareProduct;
import com.gnv.vnm.selfcare.core.model.SmsRecord;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class ProductShoppingController extends WebPortalBaseController {

	@GetMapping(value = "/shop/{categoryCode}")
	public String productGroups(@PathVariable String categoryCode, Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		model.addAttribute("productGroupList", productManagementService.getProductGroupsByCategoryCode(categoryCode.toUpperCase(), locale.getLanguage(), false));
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		if (categoryCode.equalsIgnoreCase(DefaultProductCategory.VOICE_N_SMS.name())){
			return ScreenNames.VOICE_AND_SMS;
		}else if (categoryCode.equalsIgnoreCase(DefaultProductCategory.DATA.name())){
			return ScreenNames.DATA;
		}else if (categoryCode.equalsIgnoreCase(DefaultProductCategory.VAS.name())){
			return ScreenNames.VAS;
		}
		return ScreenNames.VOICE_AND_SMS;
	}
	
	@GetMapping(value = "/shop/products/{groupId}")
	public String productList(@PathVariable int groupId, Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		ProductGroup productGroup = productManagementService.getProductGroupDetails(groupId, locale.getLanguage());
		model.addAttribute("productGroup", productGroup);
		model.addAttribute("productList", productManagementService.getProductsByProductGroupId(groupId, DisplayOrder.TITLE_ASC, locale.getLanguage(), false));
		model.addAttribute("selectLanguage", locale.getLanguage());
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.SHOP);

		String categoryCode = productGroup.getCategoryCode();
		if (categoryCode.equalsIgnoreCase(DefaultProductCategory.VOICE_N_SMS.name())){
			return ScreenNames.VOICE_AND_SMS_PRODUCTS;
		}else if (categoryCode.equalsIgnoreCase(DefaultProductCategory.DATA.name())){
			return ScreenNames.DATA_PRODUCTS;
		}else if (categoryCode.equalsIgnoreCase(DefaultProductCategory.VAS.name())){
			return ScreenNames.VAS_PRODUCTS;
		}
		return ScreenNames.VOICE_AND_SMS_PRODUCTS;
	}
	
	
	@GetMapping(value = "/shareproduct/{productId}/{lang}")
	public ModelAndView getUnsecuredUsageHistory(ModelAndView model, @PathVariable("productId") String productId,@PathVariable("lang") String lang){

		
		
		
		ShareProduct shareProduct =productManagementService.getShareDetailsById(Integer.parseInt(productId), lang);
		
		
		model.setViewName(ScreenNames.SHARE_PRODUCT);
		model.addObject("shareProduct", shareProduct);
		
		return model;
	}
	
	
	@GetMapping(value = "/secure/regpkg/{productCode}")
	public ResponseEntity<?> registerProduct(@PathVariable String productCode, Locale locale, HttpServletRequest request, Principal authUser){

		BackEndAdapterResponse result = backEndRequestProcessor.activatePackageSubscription(authUser.getName(), productCode, ClientAppId.WEB_APP);
		String respCode = result.getResponseCode();
		
		String message = "";
		if (respCode.equals(VASManErrorMessage.SUCCESS.code())){
			message = resolveMessage(messageSource, "Message.Shop.RegisterSuccess", null, "You have registered the package successfully.", locale);
			
		} else if (respCode.equals(VASManErrorMessage.NOT_ENOUGH_MONEY.code()) || respCode.equals(VASManErrorMessage.BALANCE_TOO_SMALL.code())){
			message = resolveMessage(messageSource, "Message.Shop.RegisterFailNotEnoughBalance",
					new String[] { (request.getContextPath() + "/vtopup") },
					"Your account is not sufficient. Please Top Up to register for this package. "
							+ "<br>Click <a class=\"alert-link\" href=" + (request.getContextPath() + "/secure/vtopup")
							+ ">here</a> to buy top up.",
					locale);
			
		} else if (respCode.equals(VASManErrorMessage.ALREADY_REGISTERED.code())){
			message = resolveMessage(messageSource, "Message.Shop.RegisterFailAlreadyRegistered", null,
					"The registration has failed. This package is already registered.", locale);
			
		} else{
			message = resolveMessage(messageSource, "Message.Shop.RegisterFail", null, "The registration has failed.", locale);
		}
		return new ResponseEntity<>(respCode + "|" + message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/secure/unregpkg/{productCode}")
	public ResponseEntity<?> unregisterProduct(@PathVariable String productCode, Locale locale, HttpServletRequest request, Principal authUser){
		
		boolean result = backEndRequestProcessor.cancelPackageSubscription(authUser.getName(), productCode);
		return new ResponseEntity<>(result?"1":"0", HttpStatus.OK);
	}
	
}
