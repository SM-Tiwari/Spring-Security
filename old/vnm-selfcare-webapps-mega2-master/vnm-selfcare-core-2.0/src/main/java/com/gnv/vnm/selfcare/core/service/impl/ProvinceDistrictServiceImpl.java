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

import com.gnv.vnm.selfcare.core.model.District;
import com.gnv.vnm.selfcare.core.model.Province;
import com.gnv.vnm.selfcare.core.model.Store;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.ProvinceDistrictService;
import com.gnv.vnm.selfcare.core.service.StoreManagementService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.DistrictEntity;
import com.gnv.vnm.selfcare.dao.entity.ProvinceEntity;
import com.gnv.vnm.selfcare.dao.entity.QDistrictEntity;
import com.gnv.vnm.selfcare.dao.entity.QStoreEntity;
import com.gnv.vnm.selfcare.dao.entity.StoreEntity;
import com.gnv.vnm.selfcare.dao.repo.DistrictRepository;
import com.gnv.vnm.selfcare.dao.repo.ProvinceRepository;
import com.gnv.vnm.selfcare.dao.repo.StoreRepository;

/**
 * @author nandipinto
 *
 */

@Service("provinceDistrictService")
public class ProvinceDistrictServiceImpl implements ProvinceDistrictService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProvinceDistrictServiceImpl.class);
	
	private static final int MAX_DISTANCE = 5 * 1000;

	@Autowired ProvinceRepository provinceRepository;
	@Autowired DistrictRepository districtRepository;
	@Autowired ApplicationConfigurationService applicationConfigService;
	
	private Province fromProvinceEntity(ProvinceEntity source){
		Province province = new Province(source.getProvinceId(), source.getProvince());
		
		return province;
	}
	
	private District fromDistrictEntity(DistrictEntity source){
		District district = new District(source.getDistrictId(),  source.getDistrict(), source.getProvinceId());
		
		return district;
	}
	
	@Override
	public List<Province> getAllProvince() {
			List<Province> result = new ArrayList<>();
		
		try {
			Iterable<ProvinceEntity> list = provinceRepository.findAll();
			for (ProvinceEntity se : list){
				result.add(fromProvinceEntity(se));
			}
		} catch (Exception e) {
			logger.error("#getAllProvince --- error retrieving province list!", e);
		}
		return result;
	}

	@Override
	public List<District> getDistrictByProvince(Integer district) {
		List<District> result = new ArrayList<>();
		try {
			Iterable<DistrictEntity> list = districtRepository.findAll(QDistrictEntity.districtEntity.provinceId.eq(district));
			for (DistrictEntity se : list){
				result.add(fromDistrictEntity(se));
			}
		} catch (Exception e) {
			logger.error("#getDistrictByProvince --- error retrieving district list!", e);
		}
		return result;
	}
	 
	
	
	
}
