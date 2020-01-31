package com.gnv.vnm.selfcare.core.service;


import java.util.List;

import com.gnv.vnm.selfcare.core.model.PopupBannner;
public interface PopupBannerManagementService {

	

	List<PopupBannner> getPopupBannerData(String langCode);
}
