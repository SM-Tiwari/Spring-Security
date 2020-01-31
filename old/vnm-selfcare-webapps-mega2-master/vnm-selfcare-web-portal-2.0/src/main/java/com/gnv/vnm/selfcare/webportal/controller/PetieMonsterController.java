/**
 * May 31, 2018 9:21:29 AM
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gnv.vnm.selfcare.core.adapter.BackEndAdapterResponse;
import com.gnv.vnm.selfcare.core.enums.LmsConfigNames;
import com.gnv.vnm.selfcare.core.model.SubscriberProfile;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;

/**
 * @author nandipinto
 *
 */

@Controller
public class PetieMonsterController extends WebPortalBaseController {
	
	static final String KEYWORD_SMS = "SMS";
	static final String KEYWORD_VOICE = "VOICE";
	static final String KEYWORD_DATA = "DATA";
	static final String KEYWORD_CASHBACK = "CASHBACK";

	@RequestMapping(value = "/secure/petie")
	public String petieMonster(Model model, Principal authUser, Locale locale, HttpServletRequest request){

		SubscriberProfile profile = getProfile(request, authUser);
		setSessionData(model, request, profile, locale);
		setActiveTopMenu(model, TopMenu.HOME);
		
		int minRedeemPoint = Integer.parseInt(getLmsConfigs().getOrDefault(LmsConfigNames.MIN_REDEEM_POINT.name(), "" + MIN_REDEEM_POINT).toString());
		int lmsPoint = backEndRequestProcessor.getLmsPoint(authUser.getName());
		
		int fattyMonsterWeight = getMonsterWeight(lmsPoint);
		int totalGift = lmsPoint > 0 ? (lmsPoint - minRedeemPoint) / minRedeemPoint : 0;
				
		String fattyMonsterImg = getMonsterImageName(lmsPoint);
		
		model.addAttribute("petieMonsterWeight", fattyMonsterWeight);
		model.addAttribute("petieMonsterImg", fattyMonsterImg);
		model.addAttribute("tatalGift", totalGift);
		model.addAttribute("petieLevel", getPetieLevel(lmsPoint));
		model.addAttribute("remainingPointToLevelUp", getRemainingPointToLevelUp(lmsPoint));
		
		return ScreenNames.PETIE_MONSTER;
	}
	
	@PostMapping(value = "/secure/petie/redeem")
	public ResponseEntity<?> redeem(Principal authUser, 
			@RequestParam (name = "CASHBACK", defaultValue = "0") int cashback,
			@RequestParam (name = "SMS", defaultValue = "0") int sms,
			@RequestParam (name = "VOICE", defaultValue = "0") int voice,
			@RequestParam (name = "DATA", defaultValue = "0") int data){
		
		int success = 0;
		
		BackEndAdapterResponse resp = backEndRequestProcessor.redeemLmsPoint(authUser.getName(), KEYWORD_CASHBACK, cashback);
		if (resp != null && resp.isSuccessful()) success++;
		resp = backEndRequestProcessor.redeemLmsPoint(authUser.getName(), KEYWORD_SMS, sms);
		if (resp != null && resp.isSuccessful()) success++;
		resp = backEndRequestProcessor.redeemLmsPoint(authUser.getName(), KEYWORD_VOICE, voice);
		if (resp != null && resp.isSuccessful()) success++;
		resp = backEndRequestProcessor.redeemLmsPoint(authUser.getName(), KEYWORD_DATA, data);
		if (resp != null && resp.isSuccessful()) success++;
		
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
	
	@ModelAttribute("MAX_MONSTER_WEIGHT")
	public int maxMonsterWeight() {
		return Integer.parseInt(
				getLmsConfigs().getOrDefault(LmsConfigNames.MAX_MONSTER_WEIGHT, "" + MAX_MONSTER_WEIGHT).toString());
	}
	
	@ModelAttribute("MIN_MONSTER_WEIGHT")
	public int minMonsterWeight() {
		return Integer.parseInt(
				getLmsConfigs().getOrDefault(LmsConfigNames.MIN_MONSTER_WEIGHT, "" + MIN_MONSTER_WEIGHT).toString());
	}

	@ModelAttribute("KEYWORD_MAPPINGS")
	Map<String, Integer> getLmsKeywordMappings(){
		return backEndRequestProcessor.getLmsKeywordMappings();
	}
	
	private static int getRemainingPointToLevelUp(int point) {
		if (point >= 1000)
			return 0;

		int pointTreshold = 0;

		if (point >= 100) {
			pointTreshold = 1000;
		} else if (point >= 40) {
			pointTreshold = 100;
		} else if (point >= 20) {
			pointTreshold = 40;
		} else if (point >= 10) {
			pointTreshold = 20;
		} else {
			pointTreshold = 10;
		}

		return pointTreshold - point;
	}
}
