package com.gnv.vnm.selfcare.core.service;

import java.util.List;

import com.gnv.vnm.selfcare.core.model.DiscountTopUp;

public interface DiscountTopupService {
	
	List<DiscountTopUp> getDiscountTopupData(String langCode);

}
