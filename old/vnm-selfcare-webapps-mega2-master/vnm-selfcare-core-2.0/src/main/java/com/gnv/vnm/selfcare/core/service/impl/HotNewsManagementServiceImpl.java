package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.DataStatus;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;
import com.gnv.vnm.selfcare.core.model.HotNews;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.HotNewsManagementService;
import com.gnv.vnm.selfcare.dao.entity.HotNewsEntity;
import com.gnv.vnm.selfcare.dao.entity.QHotNewsEntity;
import com.gnv.vnm.selfcare.dao.repo.HotNewsRepositry;
import com.querydsl.core.types.OrderSpecifier;

@Service("hotnewsManagementService")
public class HotNewsManagementServiceImpl implements HotNewsManagementService {

	
	@Autowired
	public HotNewsRepositry hotNewsRepositry;
	
	@Autowired 
	private ApplicationConfigurationService applicationConfigurationService;

	@Override
	public List<HotNews> getHotNewsdata(String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<HotNews> hotNews = new ArrayList<>();
		try
		{
			OrderSpecifier<Integer> sortOrder = QHotNewsEntity.hotNewsEntity.hotnewsDisplayOrder.asc();
			Iterable<HotNewsEntity> ht = hotNewsRepositry.findAll(QHotNewsEntity.hotNewsEntity.hotnewsStatus.eq(DataStatus.ACTIVE.ordinal()),sortOrder);
			if(ht != null)
			{
				for(HotNewsEntity et :ht){
					 hotNews.add(fromHotNewsEntity(et,langCode));
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return hotNews;
	}

	private HotNews fromHotNewsEntity(HotNewsEntity source, String langCode) {
		
		//System.out.println("hell " + source.getHotnewsId());
		HotNews hotnews = new HotNews();
		hotnews.setId(source.getHotnewsId());
		hotnews.setCode(source.getHotnewsCode());	
		hotnews.setDetail_url(source.getDetail_url());
		if(source.getMyselectLink().equalsIgnoreCase("select"))
		{
			hotnews.setMyselectLink("0");
		}else{
			hotnews.setMyselectLink(source.getMyselectLink());
		}
		
		if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
			hotnews.setName(source.getHotnewsNameEN());
			hotnews.setDescription(source.getHotnewsDescEN());
			hotnews.setDetails(source.getHotnewsDetailEN());
			
			
		}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
			hotnews.setName(source.getHotnewsNameVI());
			hotnews.setDescription(source.getHotnewsDescVI());
			hotnews.setDetails(source.getHotnewsDetailVI());
			
		}
		
		hotnews.setDefaultImage(createImageURL(source.getHotnewsDefaultBanner()));
		hotnews.setSmallImage(createImageURL(source.getHotnewsDefaultBanner()));
		hotnews.setMediumImage(createImageURL(source.getHotnewsDefaultBanner()));
		hotnews.setLargeImage(createImageURL(source.getHotnewsDefaultBanner()));
		hotnews.setXlargeImage(createImageURL(source.getHotnewsDefaultBanner()));
		
				
		return hotnews;
	}
	private String createImageURL(String productImg){
		if (!StringUtils.hasText(productImg)) return "";
		
		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		
		if (!imageDir.endsWith("/")) imageDir = imageDir + "/";
		
		return imageSvr + imageDir + productImg;
	}
}
