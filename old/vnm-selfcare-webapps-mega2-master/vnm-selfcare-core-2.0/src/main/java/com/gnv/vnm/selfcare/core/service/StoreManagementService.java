/**
 * StoreManagementService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gnv.vnm.selfcare.core.model.Store;

/**
 * @author nandipinto
 *
 */
public interface StoreManagementService {

	List<Store> getAllStores();
	
	Page<Store> getAllStores(Pageable page);
	
	Page<Store> searchStores(String searchTerm, Pageable page);
	
	Page<Store> getStoreListByDistrict(String district, Pageable page);
	
	Page<Store> getStoreListByProvince(String province, Pageable page);
	
	Page<Store> findNearbyStores(double latitude, double longitude, double maxDistance, Pageable page);
	
	List<Store> findNearbyStores(double latitude, double longitude, double maxDistance);
	
	List<Store> getStoreListByProvince(String province);
	
	List<String> getAllProvinces();
	
}
