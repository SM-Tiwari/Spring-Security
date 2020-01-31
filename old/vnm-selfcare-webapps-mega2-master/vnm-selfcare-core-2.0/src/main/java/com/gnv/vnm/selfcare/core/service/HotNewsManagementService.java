package com.gnv.vnm.selfcare.core.service;


import java.util.List;

import com.gnv.vnm.selfcare.core.model.HotNews;
public interface HotNewsManagementService {
	
	List<HotNews> getHotNewsdata(String langCode);
}
