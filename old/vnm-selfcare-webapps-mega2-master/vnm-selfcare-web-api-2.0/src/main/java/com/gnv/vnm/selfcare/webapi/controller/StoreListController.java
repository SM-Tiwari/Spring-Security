/**
 * StoreListController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.model.Store;
import com.gnv.vnm.selfcare.webapi.model.NearbyStoreListRequest;
import com.gnv.vnm.selfcare.webapi.model.StoreListRequest;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping("/store")
public class StoreListController extends BaseRestController {

	static final String[] SORTABLE_ATTRS = {"code", "name", "address", "latitude", "longitude", "district", "province", "distance"};
	
	
	@PostMapping(value = "/showAll")
	public ResponseEntity<?> showAll(@RequestBody StoreListRequest request){
		
		int page = request.getPageNo();
		String sort = request.getSortBy();
		
		if (!isValidSortAttr(sort)) sort = SORTABLE_ATTRS[1];//name
		if (page > 0) page = page - 1;
		
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Store> storeList = storeManagementService.getAllStores(pageRequest);

		return new ResponseEntity<>(storeList, HttpStatus.OK);
	}
	
	@PostMapping(value = "/search")
	public ResponseEntity<?> searchStores(@RequestBody StoreListRequest request){
		
		int page = request.getPageNo();
		String sort = request.getSortBy();
		String searchTerm = request.getSearchTerm();
		
		if (!isValidSortAttr(sort)) sort = SORTABLE_ATTRS[1];//name
		if (page > 0) page = page - 1;
		
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Store> storeList = storeManagementService.searchStores(searchTerm, pageRequest);

		return new ResponseEntity<>(storeList, HttpStatus.OK);
	}

	@PostMapping(value = "/listbydistrict")
	public ResponseEntity<?> storeListByDistrict(@RequestBody StoreListRequest request){
		
		int page = request.getPageNo();
		String sort = request.getSortBy();
		String district = request.getSearchTerm();
		
		if (!isValidSortAttr(sort)) sort = SORTABLE_ATTRS[1];//name
		if (page > 0) page = page - 1;
		
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Store> storeList = storeManagementService.getStoreListByDistrict(district, pageRequest);

		return new ResponseEntity<>(storeList, HttpStatus.OK);
	}

	@PostMapping(value = "/listbyprovince")
	public ResponseEntity<?> storeListByProvince(@RequestBody StoreListRequest request){
		
		int page = request.getPageNo();
		String sort = request.getSortBy();
		String province = request.getSearchTerm();
		
		if (!isValidSortAttr(sort)) sort = SORTABLE_ATTRS[1];//name
		if (page > 0) page = page - 1;
		
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Store> storeList = storeManagementService.getStoreListByProvince(province, pageRequest);

		return new ResponseEntity<>(storeList, HttpStatus.OK);
	}

	@GetMapping(value = "/nearest/{latitude}/{longitude}/{maxDistance}")
	public ResponseEntity<?> findNearestStores(@PathVariable String longitude, @PathVariable String latitude, @PathVariable String maxDistance){
		double lon = 0, lat = 0, maxDist = 0;
		try {
			lon = Double.parseDouble(longitude);
			lat = Double.parseDouble(latitude);
			maxDist = Double.parseDouble(maxDistance);
		} catch (Exception e) { }
		
		
		return new ResponseEntity<>(storeManagementService.findNearbyStores(lat, lon, maxDist * 1000), HttpStatus.OK);
	}
	
	@PostMapping(value = "/nearest")
	public ResponseEntity<?> findNearestStores(@RequestBody NearbyStoreListRequest request){
		
		double lon = 0, lat = 0, maxDist = 1;
		try {
			lon = Double.parseDouble(request.getLongitude());
			lat = Double.parseDouble(request.getLatitude());
			maxDist = Double.parseDouble(request.getMaxDistance());
		} catch (Exception e) { }
		
		int page = request.getPageNo();
		if (page > 0) page = page - 1;
		
		String sort = request.getSortBy();
		if (!isValidSortAttr(sort)) sort = SORTABLE_ATTRS[1];//name
		
		PageRequest pageRequest = new PageRequest(page, getPageSize(), new Sort(sort));
		Page<Store> storeList = storeManagementService.findNearbyStores(lat, lon, maxDist * 1000, pageRequest);
		
		return new ResponseEntity<>(storeList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/provincelist")
	public ResponseEntity<?> getProvinceList(){
		return new ResponseEntity<>(storeManagementService.getAllProvinces(), HttpStatus.OK);
	}
	
	private boolean isValidSortAttr(String attr){
		for (String s:SORTABLE_ATTRS){
			if (attr.equals(s)) return true;
		}
		return false;
	}
	
	private int getPageSize(){
		return Integer.parseInt(applicationConfigurationService.get("pagedlist.itemsperpage.all", AppDefaultValues.PAGED_LIST_SIZE + "").toString());
	}
}
