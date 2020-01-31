package com.gnv.vnm.selfcare.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.DataStatus;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;
import com.gnv.vnm.selfcare.core.model.DiscountTopUp;
import com.gnv.vnm.selfcare.core.service.DiscountTopupService;
import com.gnv.vnm.selfcare.dao.entity.DiscountTopupEntity;
import com.gnv.vnm.selfcare.dao.entity.QDiscountTopupEntity;
import com.gnv.vnm.selfcare.dao.repo.DiscountTopupRepositry;

@Service("discountTopupService")
public class DiscountTopupServiceImpl implements DiscountTopupService{

	@Autowired
	private DiscountTopupRepositry discountTopupRepositry;
	
	@Override
	public List<DiscountTopUp> getDiscountTopupData(String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<DiscountTopUp> dicounttopup = new ArrayList<>();
		
		try
		{
			Iterable<DiscountTopupEntity> dte = discountTopupRepositry.findAll(QDiscountTopupEntity.discountTopupEntity.discountStatus.eq(DataStatus.ACTIVE.ordinal()));
			if(dte != null)
			{
				for(DiscountTopupEntity et :dte){
					dicounttopup.add(fromDiscounttopupEntity(et,langCode));
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return dicounttopup;
	}

private DiscountTopUp fromDiscounttopupEntity(DiscountTopupEntity source, String langCode) {
		
		
		DiscountTopUp discountTopUp = new DiscountTopUp();
		discountTopUp.setId(source.getDiscounttopupId());
		discountTopUp.setCode(source.getDiscounttopupCode());	
		
		if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
			discountTopUp.setName(source.getDiscountNameEN());
			discountTopUp.setDescription(source.getDiscountDescEN());
			discountTopUp.setDetails(source.getDiscountDetailEN());
			
			
		}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
			discountTopUp.setName(source.getDiscountNameVI());
			discountTopUp.setDescription(source.getDiscountDescVI());
			discountTopUp.setDetails(source.getDiscountDetailVI());
			
		}
		
		discountTopUp.setRechage_amount(source.getRechageAmount());	
		discountTopUp.setRechage_dicount(source.getRechageDiscount());	
		
				
		return discountTopUp;
	}
	
}
