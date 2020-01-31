/**
 * StoreListController.java
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gnv.vnm.selfcare.core.model.Store;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.webportal.config.ScreenNames;
import com.gnv.vnm.selfcare.webportal.config.TopMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author nandipinto
 *
 */

@Controller
@RequestMapping(value = "/store")
public class StoreListController extends WebPortalBaseController {
	
	static final Logger logger = LoggerFactory.getLogger(StoreListController.class);
	
	static final String MAX_DISTANCE = "10.0";

	@GetMapping(value = "/all")
	public String allStores(Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		List<String> cities = storeManagementService.getAllProvinces();
		String city = cities != null && cities.size() > 0 ? cities.get(0) : "";
		
		List<Store> storeList = StringUtils.hasText(city) ? storeManagementService.getStoreListByProvince(cities.get(0)) : storeManagementService.getAllStores();
		Collections.sort(storeList, Store.StoreNameAscComparator);
		
		model.addAttribute("storeCount", storeList.size());
		model.addAttribute("storeList", storeList);
		model.addAttribute("currCity", city);
		ArrayList<Store> storeLat=new ArrayList<>();
		if(storeList.size()!=0)
		{
			for(int storeIndex=0;storeIndex<storeList.size();storeIndex++)
			{
				Store store=new Store();
				store.setLatitude(storeList.get(storeIndex).getLatitude());
				store.setLongitude(storeList.get(storeIndex).getLongitude());
				store.setAddress(storeList.get(storeIndex).getAddress());
				storeLat.add(store);
			}
		}
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String JSONObject = gson.toJson(storeLat);
		String storeListforLatLong= JSONObject.replaceAll("\\\\n", "/");
		
		
		
		
		model.addAttribute("storeListLat", storeListforLatLong);
		
		
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.ACCOUNT);

		return ScreenNames.STORE_LIST;
	}

	@RequestMapping(value = "/nearby", method = {RequestMethod.GET, RequestMethod.POST})
	public String showStoresNearMe(@RequestParam(name = "lon", defaultValue = "0.0") String longitude, 
			@RequestParam(name = "lat", defaultValue = "0.0") String latitude,
			Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		
		List<Store> nearbyStores = storeManagementService.findNearbyStores(Double.parseDouble(latitude), Double.parseDouble(longitude), 0);
		
		model.addAttribute("storeCount", nearbyStores.size());
		model.addAttribute("storeList", nearbyStores);
		model.addAttribute("longitude", longitude);
		model.addAttribute("latitude", latitude);
		
		ArrayList<Store> storeLat=new ArrayList<>();
		if(nearbyStores.size()!=0)
		{
			for(int storeIndex=0;storeIndex<nearbyStores.size();storeIndex++)
			{
				Store store=new Store();
				store.setLatitude(nearbyStores.get(storeIndex).getLatitude());
				store.setLongitude(nearbyStores.get(storeIndex).getLongitude());
				store.setAddress(nearbyStores.get(storeIndex).getAddress());
				storeLat.add(store);
			}
		}
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String JSONObject = gson.toJson(storeLat);
		String storeListforLatLong= JSONObject.replaceAll("\\\\n", "/");
		
		
		
		
		model.addAttribute("storeListLat", storeListforLatLong);
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.ACCOUNT);

		return ScreenNames.STORE_LIST;
	}
	
	@ModelAttribute("provinceList")
	public List<String> getProvinceList(){
		return storeManagementService.getAllProvinces();
	}
	
	@RequestMapping(value = "/city", method = {RequestMethod.POST, RequestMethod.GET})
	public String byCity(@RequestParam(name = "city", defaultValue = "") String city, Model model, Locale locale, HttpServletRequest request, Principal authUser){
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) { }

		LoggingUtil.debug(logger, "#byCity --- selected city= " + city);
		
		List<Store> storeList = StringUtils.hasText(city)? storeManagementService.getStoreListByProvince(city) : new ArrayList<Store>();
		Collections.sort(storeList, Store.StoreNameAscComparator);
		
		model.addAttribute("storeCount", storeList.size());
		
		model.addAttribute("storeList", storeList);
		model.addAttribute("currCity", city);
		
		ArrayList<Store> storeLat=new ArrayList<>();
		if(storeList.size()!=0)
		{
			for(int storeIndex=0;storeIndex<storeList.size();storeIndex++)
			{
				Store store=new Store();
				store.setLatitude(storeList.get(storeIndex).getLatitude());
				store.setLongitude(storeList.get(storeIndex).getLongitude());
				store.setAddress(storeList.get(storeIndex).getAddress());
				storeLat.add(store);
			}
		}
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String JSONObject = gson.toJson(storeLat);
		String storeListforLatLong= JSONObject.replaceAll("\\\\n", "/");	
		model.addAttribute("storeListLat", storeListforLatLong);
		
		setSessionData(model, request, getProfile(request, authUser), locale);
		setActiveTopMenu(model, TopMenu.ACCOUNT);

		return ScreenNames.STORE_LIST;
	}
}
