package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.DataStatus;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;

import com.gnv.vnm.selfcare.core.model.PopupBannner;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.PopupBannerManagementService;
import com.gnv.vnm.selfcare.dao.entity.PopupBannerEntity;

import com.gnv.vnm.selfcare.dao.entity.QPopupBannerEntity;
import com.gnv.vnm.selfcare.dao.repo.PopupBannerRepositry;
import com.querydsl.core.types.OrderSpecifier;

@Service("popupBannerManagementService")
public class PopupBannerManagementServiceImpl implements PopupBannerManagementService{

	@Autowired
	public PopupBannerRepositry popupBannerRepositry;
	
	@Autowired 
	private ApplicationConfigurationService applicationConfigurationService;
	
	@Override
	public List<PopupBannner> getPopupBannerData(String langCode)
	{	
		
		if(!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toLowerCase();
		List<PopupBannner> popupBannner = new ArrayList<>();
		try
		{
			OrderSpecifier<Integer> sortOrder = QPopupBannerEntity.popupBannerEntity.popupbannerDisplayOrder.asc();
			Iterable<PopupBannerEntity> pt = popupBannerRepositry.findAll(QPopupBannerEntity.popupBannerEntity.popupbannerStatus.eq(DataStatus.ACTIVE.ordinal()),sortOrder);
			if(pt !=null)
			{
				for (PopupBannerEntity pbe : pt)
				{
					popupBannner.add(fromPopbannerEntity(pbe,langCode));
					
				}
				/*
				 * for(HotNewsEntity et :ht){
					 hotNews.add(fromHotNewsEntity(et,langCode));
				}
				 * --------*/
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return popupBannner;
		
	}

	private PopupBannner fromPopbannerEntity(PopupBannerEntity source, String langCode) {
		
		PopupBannner popupBannner = new PopupBannner();
		popupBannner.setId(source.getPopupBannerId());
		popupBannner.setCode(source.getPopupBannerCode());	
		popupBannner.setDetail_url(source.getPopupBannerLink());
		if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
			popupBannner.setName(source.getPopupbannerNameEN());
			popupBannner.setDescription(source.getPopupbannerDescEN());
			popupBannner.setDetails(source.getPopupbannerDetailEN());
			
			
		}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
			popupBannner.setName(source.getPopupbannerNameVI());
			popupBannner.setDescription(source.getPopupbannerDescVI());
			popupBannner.setDetails(source.getPopupbannerDetailVI());
			
		}
		if(source.getPopupbannerDisplayOrder()!=null)popupBannner.setPopbannerorder(source.getPopupbannerDisplayOrder());
		popupBannner.setDefaultImage(createImageURL(source.getPopupbannerDefaultBanner()));
		popupBannner.setSmallImage(createImageURL(source.getPopupbannerDefaultBanner()));
		popupBannner.setMediumImage(createImageURL(source.getPopupbannerDefaultBanner()));
		popupBannner.setLargeImage(createImageURL(source.getPopupbannerDefaultBanner()));
		popupBannner.setXlargeImage(createImageURL(source.getPopupbannerDefaultBanner()));
		return popupBannner;
	}
	
	private String createImageURL(String productImg){
		if (!StringUtils.hasText(productImg)) return "";
		
		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		
		if (!imageDir.endsWith("/")) imageDir = imageDir + "/";
		
		return imageSvr + imageDir + productImg;
	}
}

