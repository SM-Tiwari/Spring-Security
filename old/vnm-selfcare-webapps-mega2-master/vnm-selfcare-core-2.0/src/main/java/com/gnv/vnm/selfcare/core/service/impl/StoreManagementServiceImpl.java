/**
 * StoreManagementServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gnv.vnm.selfcare.core.model.Store;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.StoreManagementService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.QStoreEntity;
import com.gnv.vnm.selfcare.dao.entity.StoreEntity;
import com.gnv.vnm.selfcare.dao.repo.StoreRepository;

/**
 * @author nandipinto
 *
 */

@Service("storeManagementService")
public class StoreManagementServiceImpl implements StoreManagementService {
	
	private static final Logger logger = LoggerFactory.getLogger(StoreManagementServiceImpl.class);
	
	private static final int MAX_DISTANCE = 5 * 1000;

	@Autowired StoreRepository storeRepository;
	@Autowired ApplicationConfigurationService applicationConfigService;
	
	private Store fromStoreEntity(StoreEntity source){
		String latitude="";
		String longitude="";
		if(source.getLatitude()!=null)latitude=source.getLatitude().replaceAll(",", " ");
		if(source.getLongitude()!=null)longitude=source.getLongitude().replaceAll(",", " ");
			
		Store store = new Store(source.getId(), source.getCode(), source.getName(), source.getAddress(), latitude,
				longitude, source.getDistrict(), source.getProvince());
		
		store.setPhoneNumber(source.getPhoneNumber());
		
		return store;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#getAllStores()
	 */
	@Override
	public List<Store> getAllStores() {
		List<Store> result = new ArrayList<>();
		
		try {
			Iterable<StoreEntity> list = storeRepository.findAll();
			for (StoreEntity se : list){
				result.add(fromStoreEntity(se));
			}
		} catch (Exception e) {
			logger.error("#getAllStores --- error retrieving store list!", e);
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#showAll(org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Store> getAllStores(Pageable page) {
		List<Store> tempList = new ArrayList<>();
		long total = 0;
		try {
			Page<StoreEntity> list = storeRepository.findAll(page);
			if (list != null){
				total = list.getTotalElements();
				List<StoreEntity> stores = list.getContent();
				for (StoreEntity se:stores){
					Store store = fromStoreEntity(se);
					tempList.add(store);
				}
			}
		} catch (Exception e) {
			logger.error("#showAll -- error when getting list of stores", e);
		}
		return new PageImpl<>(tempList, page, total);
	}


	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#searchStores(java.lang.String)
	 */
	@Override
	public Page<Store> searchStores(String searchTerm, Pageable page) {
		LoggingUtil.debug(logger, "#searchStores -- seachTerm= " + searchTerm + ", page= " + page);
		List<Store> tempList = new ArrayList<>();
		long total = 0;
		try {
			Page<StoreEntity> list = storeRepository.findAll(QStoreEntity.storeEntity.code.containsIgnoreCase(searchTerm)
					.or(QStoreEntity.storeEntity.name.containsIgnoreCase(searchTerm))
					.or(QStoreEntity.storeEntity.address.containsIgnoreCase(searchTerm))
					.or(QStoreEntity.storeEntity.district.containsIgnoreCase(searchTerm))
					.or(QStoreEntity.storeEntity.province.containsIgnoreCase(searchTerm)), page);

			if (list != null){
				total = list.getTotalElements();
				List<StoreEntity> stores = list.getContent();
				for (StoreEntity se:stores){
					Store store = fromStoreEntity(se);
					tempList.add(store);
				}
			}
		} catch (Exception e) {
			logger.error("#searchStores -- error when getting list of stores", e);
		}
		return new PageImpl<>(tempList, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#getStoreListByDistrict(java.lang.String)
	 */
	@Override
	public Page<Store> getStoreListByDistrict(String district, Pageable page) {
		
		LoggingUtil.debug(logger, "#getStoreListByDistrict -- seachTerm= " + district);
		
		List<Store> tempList = new ArrayList<>();
		long total = 0;
		try {
			Page<StoreEntity> list = storeRepository.findAll(QStoreEntity.storeEntity.district.containsIgnoreCase(district), page);
			
			if (list != null){
				total = list.getTotalElements();
				for (StoreEntity se:list.getContent()){
					tempList.add(fromStoreEntity(se));
				}
			}
		} catch (Exception e) {
			logger.error("#getStoreListByDistrict -- error when getting list of stores", e);
		}
		return new PageImpl<>(tempList, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#getStoreListByProvince(java.lang.String)
	 */
	@Override
	public Page<Store> getStoreListByProvince(String province, Pageable page) {
		LoggingUtil.debug(logger, "#getStoreListByProvince -- seachTerm= " + province);
		
		List<Store> tempList = new ArrayList<>();
		long total = 0;
		try {
			Page<StoreEntity> list = storeRepository.findAll(QStoreEntity.storeEntity.province.equalsIgnoreCase(province), page);
			
			if (list != null){
				total = list.getTotalElements();
				for (StoreEntity se:list.getContent()){
					tempList.add(fromStoreEntity(se));
				}
			}
		} catch (Exception e) {
			logger.error("#getStoreListByProvince -- error when getting list of stores", e);
		}
		return new PageImpl<>(tempList, page, total);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#findStoreListByProvince(java.lang.String)
	 */
	@Override
	public List<Store> getStoreListByProvince(String province) {
		
		List<Store> result = new ArrayList<>();
		try {
			Iterable<StoreEntity> list = storeRepository.findAll(QStoreEntity.storeEntity.province.containsIgnoreCase(province), QStoreEntity.storeEntity.name.asc());
			if (list != null) {
				for (StoreEntity store : list) {
					result.add(fromStoreEntity(store));
				}
			}
		} catch (Exception e) {
			logger.error("#getStoreListByProvince -- error when getting list of stores", e);
		}
		return result;
	}

	private int getMaxDistance() {
		try {
			return Integer.parseInt(applicationConfigService.get("storelist.maxdistance", "" + MAX_DISTANCE).toString());
		} catch (Exception e) {
			return MAX_DISTANCE;
		}
	}
	
	@Override
	public Page<Store> findNearbyStores(double latitude, double longitude, double maxDistance, Pageable page) {
		List<Store> result = new ArrayList<>();
		
		if (maxDistance <= 0.0) maxDistance = getMaxDistance();
		LoggingUtil.debug(logger, "#findNearbyStores(1) --- lat= " + latitude + ", lon= " + longitude + ", max_dist= " + maxDistance + ", page= " + page);
		try {
			Iterable<StoreEntity> list = storeRepository.findAll();
			for (StoreEntity se : list){
				double lon1 = 0, lat1 = 0;
				try {
					if (se.getLongitude() != null) lon1 = Double.parseDouble(se.getLongitude());
					if (se.getLatitude() != null) lat1 = Double.parseDouble(se.getLatitude());
				} catch (Exception e) {}
				
				double distance = countDistance(latitude, lat1, longitude, lon1, 0, 0);
				if (distance <= maxDistance){
					Store store = fromStoreEntity(se);
					store.setDistance(distance);
					result.add(store);
				}
			}
		} catch (Exception e) {
			logger.error("#findNearbyStores(1) --- error retrieving nearest store list!", e);
		}

		LoggingUtil.debug(logger, "#findNearbyStores(1) --- temp_list size= " + result.size());
		
		int pageSize = page.getPageSize();
		int pageNo = page.getPageNumber();
		int total = result.size();
		
		int startIdx = pageNo * pageSize;
		int max = (pageSize * (pageNo + 1) > total ) ? total : pageSize * (pageNo + 1);
		
		if (startIdx > max) startIdx = 0; //TODO
		
        return new PageImpl<Store>(result.subList(startIdx, max), page, total);		
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#findNearbyStores(double, double, double)
	 */
	@Override
	public List<Store> findNearbyStores(double latitude, double longitude, double maxDistance) {
		List<Store> result = new ArrayList<>();
		
		if (latitude <= 0 && longitude <= 0) return result;
		
		if (maxDistance <= 0) maxDistance = getMaxDistance();
		
		LoggingUtil.debug(logger, "#findNearbyStores(2) --- lat= " + latitude + ", lon= " + longitude + ", max_dist= " + maxDistance);
		try {
			Iterable<StoreEntity> list = storeRepository.findAll();
			for (StoreEntity se : list){
				double lon1 = 0, lat1 = 0;
				try {
					if (se.getLongitude() != null) lon1 = Double.parseDouble(se.getLongitude());
					if (se.getLatitude() != null) lat1 = Double.parseDouble(se.getLatitude());
				} catch (Exception e) {}
				
				double distance = countDistance(latitude, lat1, longitude, lon1, 0, 0);
				if (distance <= maxDistance){
					Store store = fromStoreEntity(se);
					store.setDistance(distance);
					result.add(store);
				}
			}
		} catch (Exception e) {
			logger.error("#findNearbyStores(2) --- error retrieving nearest store list!", e);
		}
		
		return result;
	}

	/**
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	public double countDistance(double lat1, double lat2, double lon1,
	        double lon2, double el1, double el2) {

	    final int EARTH_RADIUS = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = EARTH_RADIUS * c * 1000; // convert to meters

		double height = el1 - el2;

		distance = Math.pow(distance, 2) + Math.pow(height, 2);

		return Math.sqrt(distance);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.StoreManagementService#getAllProvinces()
	 */
	@Override
	public List<String> getAllProvinces() {
		List<String> result = new ArrayList<>();
		
		try {
			Iterable<StoreEntity> list = storeRepository.findAll(QStoreEntity.storeEntity.province.asc());
			for (StoreEntity se : list){
				if (!result.contains(se.getProvince())) result.add(se.getProvince());
			}
		} catch (Exception e) {
			logger.error("#getAllProvinces --- error retrieving province list!", e);
		}
		return result;
	}	
	
	
}
