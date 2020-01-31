/**
 * StoreManagementService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gnv.vnm.selfcare.core.model.District;
import com.gnv.vnm.selfcare.core.model.Province;
import com.gnv.vnm.selfcare.core.model.Store;

/**
 * @author nandipinto
 *
 */
public interface ProvinceDistrictService {

	List<Province> getAllProvince();
	
	List<District> getDistrictByProvince(Integer district);
	
	
	
}
