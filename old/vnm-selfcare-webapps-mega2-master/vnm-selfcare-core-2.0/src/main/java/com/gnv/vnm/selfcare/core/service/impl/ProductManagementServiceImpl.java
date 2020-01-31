/**
 * ProductManagementServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.DataStatus;
import com.gnv.vnm.selfcare.core.enums.DisplayOrder;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.SupportedLanguage;
import com.gnv.vnm.selfcare.core.metadata.DefaultProductMetadata;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.model.ProductCategory;
import com.gnv.vnm.selfcare.core.model.ProductGroup;
import com.gnv.vnm.selfcare.core.model.ShareProduct;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.service.ProductManagementService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.MetaDataEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductChangeMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductGroupEntity;
import com.gnv.vnm.selfcare.dao.entity.ProductMetaDataEntity;
import com.gnv.vnm.selfcare.dao.entity.PromotedProductEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductCategoryEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductChangeMappingEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductGroupEntity;
import com.gnv.vnm.selfcare.dao.entity.QProductMetaDataEntity;
import com.gnv.vnm.selfcare.dao.entity.QPromotedProductEntity;
import com.gnv.vnm.selfcare.dao.repo.ProductCategoryRepository;
import com.gnv.vnm.selfcare.dao.repo.ProductGroupRepository;
import com.gnv.vnm.selfcare.dao.repo.ProductMetadataRepository;
import com.gnv.vnm.selfcare.dao.repo.ProductPurchaseMappingRepository;
import com.gnv.vnm.selfcare.dao.repo.ProductRepository;
import com.gnv.vnm.selfcare.dao.repo.PromotedProductRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author nandipinto
 *
 */

@Service("productManagementService")
public class ProductManagementServiceImpl implements ProductManagementService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductManagementServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	@Autowired
	private ProductGroupRepository productGroupRepository;
	@Autowired
	private PromotedProductRepository promotedProductRepository;
	@Autowired
	private ProductMetadataRepository productMetadataRepository;
	@Autowired
	private ProductPurchaseMappingRepository productPurchaseMappingRepository;
	@Autowired 
	private ApplicationConfigurationService applicationConfigurationService;
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductCategories()
	 */
	@Override
	public List<ProductCategory> getProductCategories(String langCode) {
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<ProductCategory> categories = new ArrayList<>();
		
		Iterable<ProductCategoryEntity> list = productCategoryRepository.findAll(
				QProductCategoryEntity.productCategoryEntity.parentCategoryId.isNull(),
				QProductCategoryEntity.productCategoryEntity.id.asc());
		
		if (list != null){

			for (ProductCategoryEntity pce:list){
				
				ProductCategory category = new ProductCategory();
				category.setCode(pce.getCode());
				category.setId(pce.getId());
				category.setParentCategoryId(pce.getParentCategoryId());
				
				if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
					category.setName(pce.getNameEN());
					category.setDescription(pce.getDescriptionEN());
					
				}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
					category.setName(pce.getNameVI());
					category.setDescription(pce.getDescriptionVI());
				}
							
				Iterable<ProductCategoryEntity> sublist = productCategoryRepository.findAll(
						QProductCategoryEntity.productCategoryEntity.parentCategoryId.eq(pce.getId()), 
						QProductCategoryEntity.productCategoryEntity.code.asc());
				
				if (sublist != null){
					for (ProductCategoryEntity sc:sublist){
						
						ProductCategory subCategory = new ProductCategory();
						subCategory.setCode(sc.getCode());
						subCategory.setId(sc.getId());
						subCategory.setParentCategoryId(pce.getId());
						subCategory.setParentCategoryName(category.getName());
						
						if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
							subCategory.setName(sc.getNameEN());
							subCategory.setDescription(sc.getDescriptionEN());
						}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
							subCategory.setName(sc.getNameVI());
							subCategory.setDescription(sc.getDescriptionVI());
						}
						
						category.getSubCategories().add(subCategory);
					}
				}
				categories.add(category);
			}
		}
		return categories;
	}

	private Map<String, String> metaDataAsMap(Set<?> metadata){
		
		Map<String, String> map = new HashMap<>();
		if (metadata != null){
			Iterator<?> it = metadata.iterator();
			while (it.hasNext()){
				MetaDataEntity mde = (MetaDataEntity)it.next();
				if (mde.getValue() != null){
					if (mde.getName().startsWith(METADATA_NAME_ICON) || mde.getName().startsWith(METADATA_NAME_IMAGE)){
						map.put(mde.getName(), createImageURL(mde.getValue()));
					}else{
						map.put(mde.getName(), mde.getValue());
					}
				}
			}
		}
		return map;
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductGroupsByCategoryId(java.lang.Integer)
	 */
	@Override
	public List<ProductGroup> getProductGroupsByCategoryId(Integer categoryId, String langCode, boolean includeHiddenGroups) {
		
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<ProductGroup> productGroups = new ArrayList<>();
		
		BooleanExpression expr = QProductGroupEntity.productGroupEntity.category().isNotNull().and(
				QProductGroupEntity.productGroupEntity.category().id.eq(categoryId));
		
		if (!includeHiddenGroups){
			expr = expr.and(QProductGroupEntity.productGroupEntity.visibility.isNotNull().and(QProductGroupEntity.productGroupEntity.visibility.eq(1)));
		}
		
		Iterable<ProductGroupEntity> list = productGroupRepository.findAll(expr, QProductGroupEntity.productGroupEntity.displayOrder.asc());
		if (list != null){
			String image = "", banner = "";
			for (ProductGroupEntity pge:list){
				
				ProductCategoryEntity category = pge.getCategory();
				ProductGroup pgroup = new ProductGroup();
				
				pgroup.setId(pge.getId());
				pgroup.setCode(pge.getCode());
				pgroup.setCategoryId(category != null ? category.getId() : null);
				pgroup.setCategoryCode(category != null ? category.getCode() : null);
				pgroup.setDisplayOrder(pge.getDisplayOrder());

				pgroup.setMetadata(metaDataAsMap(pge.getMetadata()));
				
				if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
					pgroup.setName(pge.getNameEN());
					pgroup.setDescription(pge.getDescriptionEN());
					pgroup.setCategoryName(category != null ? category.getNameEN() : null);
					
				}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
					pgroup.setName(pge.getNameVI());
					pgroup.setDescription(pge.getDescriptionVI());
					pgroup.setCategoryName(category != null ? category.getNameVI() : null);
				}
				
				image = createImageURL(pge.getDefaultImage());
				banner = createImageURL(pge.getDefaultBanner());
				
				pgroup.setSmallImage(image);
				pgroup.setMediumImage(image);
				pgroup.setLargeImage(image);
				pgroup.setXlargeImage(banner);
				pgroup.setDefaultBanner(banner);
				pgroup.setDefaultImage(image);

				productGroups.add(pgroup);
			}
		}
		return productGroups;
 	}

	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductGroupsByCategoryCode(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public List<ProductGroup> getProductGroupsByCategoryCode(String categoryCode, String langCode,
			boolean includeHiddenGroups) {

		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<ProductGroup> productGroups = new ArrayList<>();
		
		BooleanExpression expr = QProductGroupEntity.productGroupEntity.category().isNotNull().and(
				QProductGroupEntity.productGroupEntity.category().code.equalsIgnoreCase(categoryCode));
		
		if (!includeHiddenGroups){
			expr = expr.and(QProductGroupEntity.productGroupEntity.visibility.isNotNull().and(QProductGroupEntity.productGroupEntity.visibility.eq(1)));
		}
		
		Iterable<ProductGroupEntity> list = productGroupRepository.findAll(expr, QProductGroupEntity.productGroupEntity.displayOrder.asc());
		if (list != null){
			String image = "", banner = "";
			for (ProductGroupEntity pge:list){
				
				ProductCategoryEntity category = pge.getCategory();

				ProductGroup pgroup = new ProductGroup();
				
				pgroup.setId(pge.getId());
				pgroup.setCode(pge.getCode());
				pgroup.setCategoryId(category != null ? category.getId() : null);
				pgroup.setCategoryCode(categoryCode);
				pgroup.setDisplayOrder(pge.getDisplayOrder());

				pgroup.setMetadata(metaDataAsMap(pge.getMetadata()));
				
				if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
					pgroup.setName(pge.getNameEN());
					pgroup.setDescription(pge.getDescriptionEN());
					pgroup.setCategoryName(category != null ? category.getNameEN() : null);
					
				}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
					pgroup.setName(pge.getNameVI());
					pgroup.setDescription(pge.getDescriptionVI());
					pgroup.setCategoryName(category != null ? category.getNameVI() : null);
				}
				
				image = createImageURL(pge.getDefaultImage());
				banner = createImageURL(pge.getDefaultBanner());
				
				pgroup.setSmallImage(image);
				pgroup.setMediumImage(image);
				pgroup.setLargeImage(image);
				pgroup.setXlargeImage(banner);
				pgroup.setDefaultBanner(banner);
				pgroup.setDefaultImage(image);

				productGroups.add(pgroup);
			}
		}
		return productGroups;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductGroupDetails(java.lang.Integer, java.lang.String)
	 */
	@Override
	public ProductGroup getProductGroupDetails(Integer productGroupId, String langCode) {
		
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		ProductGroup pgroup = new ProductGroup();
		
		try {
			ProductGroupEntity pge = productGroupRepository.findOne(productGroupId);
			if (pge != null){
				Integer categoryId = null;
				String categoryCode = "", categoryName = "";
				ProductCategoryEntity category = pge.getCategory();
				if (category != null){
					categoryId = category.getId();
					categoryCode = category.getCode();
					
					if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
						categoryName = category.getNameEN();
					}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
						categoryName = category.getNameVI();
					}
				}
				
				Map<String, String> metadata = metaDataAsMap(pge.getMetadata());
				
				pgroup.setId(pge.getId());
				pgroup.setCode(pge.getCode());
				pgroup.setCategoryId(categoryId);
				pgroup.setCategoryCode(categoryCode);
				pgroup.setCategoryName(categoryName);
				pgroup.setDisplayOrder(pge.getDisplayOrder());
				pgroup.setDefaultBanner(pge.getDefaultBanner());
				pgroup.setDefaultImage(pge.getDefaultImage());
				pgroup.setMetadata(metadata);
				
				if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
					pgroup.setName(pge.getNameEN());
					pgroup.setDescription(pge.getDescriptionEN());
					
				}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
					pgroup.setName(pge.getNameVI());
					pgroup.setDescription(pge.getDescriptionVI());
				}
			}
		} catch (Exception e) {
			logger.error("#getProductGroupDetails --- error getting product group details!", e);
		}
		return pgroup;
	}

	private Product fromProductEntity(ProductEntity source, String langCode){
		if (source == null) return null;
		
		Product product = new Product();
		product.setId(source.getId());
		product.setCode(source.getCode());
		product.setStatus(source.getStatus() != null ? DataStatus.valueOf(source.getStatus()) : DataStatus.ACTIVE);
		product.setPrice(source.getPrice() != null ? source.getPrice().doubleValue() : 0);
		
		if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
			product.setName(source.getNameEN());
			product.setDescription(source.getDescriptionEN());
			product.setDetails(source.getDetailsEN());
			product.setHowToRegister(source.getHowToRegEN());
			product.setHowToUnregister(source.getHowToUnregEN());
			
		}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
			product.setName(source.getNameVI());
			product.setDescription(source.getDescriptionVI());
			product.setDetails(source.getDetailsVI());
			product.setHowToRegister(source.getHowToRegVI());
			product.setHowToUnregister(source.getHowToUnregVI());
		}
		
		if (StringUtils.hasText(source.getExtProductName())){
			product.setAlias(source.getExtProductName());
		}else{
			product.setAlias(source.getCode());
		}
		
		Map<String, String> metadata = metaDataAsMap(source.getMetadata());

		product.setMetadata(metadata);

		product.setValidFromDate(source.getValidFromDate());
		product.setValidToDate(source.getValidToDate());
		
		String image = "", banner = "";
		ProductGroupEntity group = source.getProductGroup();
		if (group != null){
			product.setProductGroupId(group.getId());
			
			if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
				product.setProductGroupName(group.getNameEN());
				
			}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
				product.setProductGroupName(group.getNameVI());
			}
			
			if (group.getCategory() != null) {
				product.setCategoryId(group.getCategory().getId());
				product.setCategoryCode(group.getCategory().getCode());
			}
		}

		product.setSmallIcon(metadata.get(DefaultProductMetadata.ICON_SMALL.name()));
		product.setMediumIcon(metadata.get(DefaultProductMetadata.ICON_MEDIUM.name()));
		product.setLargeIcon(metadata.get(DefaultProductMetadata.ICON_LARGE.name()));
		product.setXlargeIcon(metadata.get(DefaultProductMetadata.ICON_XLARGE.name()));

		if (StringUtils.hasText(source.getDefaultImage())){
			image = createImageURL(source.getDefaultImage());
		}else{
			if (group != null) image = createImageURL(group.getDefaultImage());
		}
		
		product.setDefaultImage(image);
		product.setSmallImage(image);
		product.setMediumImage(image);
		product.setLargeImage(image);
		product.setXlargeImage(image);
		
		if (StringUtils.hasText(source.getDefaultBanner())){
			banner = createImageURL(source.getDefaultBanner());
		}else{
			if (group != null) banner = createImageURL(group.getDefaultBanner());
		}

		product.setXlargeImage(banner);
		product.setDefaultBanner(banner);
		
		if (metadata.get(DefaultProductMetadata.QUOTA.name()) != null){
			product.setQuota(metadata.get(DefaultProductMetadata.QUOTA.name()).toString());
		} else {
			product.setQuota(source.getQuotaInfo());
		}
		
//		LoggingUtil.debug(logger, "#fromProductEntity --- (" + product.getCode() + ", " + product.getName() + ", image= " + image + ")");

		if (!StringUtils.hasText(product.getCode()) || product.getCode().trim().startsWith("-") || product.getCode().equals("0")) {
			product.setPurchaseEnabled(false);
		}
		return product;
	}

	
	private ShareProduct fromProductShareEntity(ProductEntity source, String langCode){

		if (source == null) return null;
		
		ShareProduct product = new ShareProduct();
		product.setId(source.getId());
		product.setCode(source.getCode());
		product.setShareLink(craeteShareLInk(source.getId(),langCode));
		product.setStatus(source.getStatus() != null ? DataStatus.valueOf(source.getStatus()) : DataStatus.ACTIVE);
		
		
		if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
			product.setName(source.getNameEN());
			product.setDescription(source.getDescriptionEN());
			product.setDetails(source.getDetailsEN());
			
			
		}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
			product.setName(source.getNameVI());
			product.setDescription(source.getDescriptionVI());
			product.setDetails(source.getDetailsVI());
			
		}
		
		
		
		Map<String, String> metadata = metaDataAsMap(source.getMetadata());

		
		
		String image = "", banner = "";
		ProductGroupEntity group = source.getProductGroup();
		if (group != null){
			product.setProductGroupId(group.getId());
			
			if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_ENGLISH)){
				product.setProductGroupName(group.getNameEN());
				
			}else if (langCode.equalsIgnoreCase(AppDefaultValues.LANGUAGE_VIETNAMESE)){
				product.setProductGroupName(group.getNameVI());
			}
			
			if (group.getCategory() != null) {
				product.setCategoryId(group.getCategory().getId());
				product.setCategoryCode(group.getCategory().getCode());
			}
		}

		product.setSmallIcon(metadata.get(DefaultProductMetadata.ICON_SMALL.name()));
		product.setMediumIcon(metadata.get(DefaultProductMetadata.ICON_MEDIUM.name()));
		product.setLargeIcon(metadata.get(DefaultProductMetadata.ICON_LARGE.name()));
		product.setXlargeIcon(metadata.get(DefaultProductMetadata.ICON_XLARGE.name()));

		if (StringUtils.hasText(source.getDefaultImage())){
			image = createImageURL(source.getDefaultImage());
		}else{
			if (group != null) image = createImageURL(group.getDefaultImage());
		}
		
		product.setDefaultImage(image);
		product.setSmallImage(image);
		product.setMediumImage(image);
		product.setLargeImage(image);
		product.setXlargeImage(image);
		
		if (StringUtils.hasText(source.getDefaultBanner())){
			banner = createImageURL(source.getDefaultBanner());
		}else{
			if (group != null) banner = createImageURL(group.getDefaultBanner());
		}

		product.setXlargeImage(banner);
		product.setDefaultBanner(banner);
		
		if (metadata.get(DefaultProductMetadata.QUOTA.name()) != null){
			product.setQuota(metadata.get(DefaultProductMetadata.QUOTA.name()).toString());
		} else {
			product.setQuota(source.getQuotaInfo());
		}
		
//		LoggingUtil.debug(logger, "#fromProductEntity --- (" + product.getCode() + ", " + product.getName() + ", image= " + image + ")");

		if (!StringUtils.hasText(product.getCode()) || product.getCode().trim().startsWith("-") || product.getCode().equals("0")) {
			product.setPurchaseEnabled(false);
		}
		return product;
	}
	
	private String craeteShareLInk(Integer id, String languageEnglish) {
		String shareLink ="";
		 shareLink = applicationConfigurationService.get("share.url", "").toString()+"shareproduct/"+id+"/"+languageEnglish;
		return shareLink;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductsByProductGroupId(java.lang.Integer)
	 */
	@Override
	public List<Product> getProductsByProductGroupId(Integer productGroupId, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts) {
		
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<Product> products = new ArrayList<>();
		
		BooleanExpression expr = QProductEntity.productEntity.productGroup().isNotNull().and(
				QProductEntity.productEntity.productGroup().id.eq(productGroupId).and(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal())));
		
		if (!includeHiddenProducts){
			expr = expr.and(QProductEntity.productEntity.visibility.isNotNull().and(QProductEntity.productEntity.visibility.eq(1)));
		}
		Iterable<ProductEntity> list = null;
		
		/*
		switch(orderBy){
		case DATE_ASC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.asc());
			break;
		case DATE_DESC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.desc());
			break;
		case PRICE_ASC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.price.asc());
			break;
		case PRICE_DESC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.price.desc());
			break;
		case NAME_ASC:
		case TITLE_ASC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameEN.asc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameVI.asc());
			}
			break;
		case NAME_DESC:
		case TITLE_DESC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameEN.desc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameVI.desc());
			}
			break;
		case DESCRIPTION_ASC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionEN.asc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionVI.asc());
			}
			break;
		case DESCRIPTION_DESC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionEN.desc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionVI.desc());
			}
			break;
			
		default:
			list = productRepository.findAll(expr, QProductEntity.productEntity.code.desc());
		}
		*/
		
		//changed on Oct 02, 2017
		list = productRepository.findAll(expr, QProductEntity.productEntity.displayOrder.asc());
		if (list != null){
			for (ProductEntity pe:list){
				products.add(fromProductEntity(pe, langCode));
			}
		}
		return products;
	}

	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductsByProductGroupCode(java.lang.String, com.gnv.vnm.selfcare.core.enums.DisplayOrder, java.lang.String)
	 */
	@Override
	public List<Product> getProductsByProductGroupCode(String productGroupCode, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts) {
		if (!StringUtils.hasText(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<Product> products = new ArrayList<>();
		
		BooleanExpression expr = QProductEntity.productEntity.productGroup().isNotNull().and(
				QProductEntity.productEntity.productGroup().code.eq(productGroupCode).and(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal())));
		
		if (!includeHiddenProducts){
			expr = expr.and(QProductEntity.productEntity.visibility.isNotNull().and(QProductEntity.productEntity.visibility.eq(1)));
		}
		
		Iterable<ProductEntity> list = null;
		/*
		switch(orderBy){
		case DATE_ASC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.asc());
			break;
		case DATE_DESC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.desc());
			break;
		case PRICE_ASC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.price.asc());
			break;
		case PRICE_DESC:
			list = productRepository.findAll(expr, QProductEntity.productEntity.price.desc());
			break;
		case NAME_ASC:
		case TITLE_ASC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameEN.asc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameVI.asc());
			}
			break;
		case NAME_DESC:
		case TITLE_DESC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameEN.desc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.nameVI.desc());
			}
			break;
		case DESCRIPTION_ASC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionEN.asc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionVI.asc());
			}
			break;
		case DESCRIPTION_DESC:
			if (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionEN.desc());
			}else {
				list = productRepository.findAll(expr, QProductEntity.productEntity.descriptionVI.desc());
			}
			break;
			
		default:
			list = productRepository.findAll(expr, QProductEntity.productEntity.code.desc());
		}
		*/
		
		//changed on Oct 02, 2017
		list = productRepository.findAll(expr, QProductEntity.productEntity.displayOrder.asc()); 
		if (list != null){
			for (ProductEntity pe:list){
				products.add(fromProductEntity(pe, langCode));
			}
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#createProduct(com.gnv.vnm.selfcare.core.model.Product)
	 */
	@Override
	public Integer createProduct(Product product) {
		
		Integer productId = null;
		try {
			ProductEntity prd = new ProductEntity(product.getCode(), new BigDecimal(product.getPrice()));
			prd.setValidFromDate(product.getValidFromDate());
			prd.setValidToDate(product.getValidToDate());
			
			if (product.getProductGroupId() != null){
				prd.setProductGroup(productGroupRepository.findOne(product.getProductGroupId()));
			}
			
			if (product.getMetadata() != null){
				Set<ProductMetaDataEntity> metadata = new HashSet<>();
				
				Map<String, String> maps = product.getMetadata();
				Set<String> keys = maps.keySet();
				int ctr = 0;
				for (String key:keys){
					ProductMetaDataEntity pme = new ProductMetaDataEntity(key, maps.get(key), ctr);
					pme.setProduct(prd);
					metadata.add(pme);
					ctr++;
				}
				
				prd.setMetadata(metadata);
			}
			
			productId = productRepository.saveAndFlush(prd).getId();
			
		} catch (Exception e) {
			logger.error("#createProduct -- error occured when trying to create Product " + product.getCode(), e);
		}
		return productId;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#updateProduct(com.gnv.vnm.selfcare.core.model.Product)
	 */
	@Override
	public void updateProduct(Product product) {
		try {
			ProductEntity prd = null;
			if (product.getId() > 0){
				prd = productRepository.findOne(product.getId());
			}else{
				prd = productRepository.findOne(QProductEntity.productEntity.code.equalsIgnoreCase(product.getCode()));
			}
			if (prd != null){
				prd.setCode(product.getCode());
				prd.setPrice(new BigDecimal(product.getPrice()));
				prd.setValidFromDate(product.getValidFromDate());
				prd.setValidToDate(product.getValidToDate());
				
				if (product.getMetadata() != null){
					Set<ProductMetaDataEntity> metadata = new HashSet<>();
					
					Map<String, String> maps = product.getMetadata();
					Set<String> keys = maps.keySet();
					int ctr = 0;
					for (String key:keys){
						ProductMetaDataEntity pme = new ProductMetaDataEntity(key, maps.get(key), ctr);
						pme.setProduct(prd);
						metadata.add(pme);
						ctr++;
					}
					
					prd.setMetadata(metadata);
				}
			}
		} catch (Exception e) {
			logger.error(String.format("#updateProduct -- error occured when updating product %s", product.getCode()), e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#deleteProduct(java.lang.Integer)
	 */
	@Override
	public void deleteProduct(Integer id) {
		try {
			productRepository.delete(id);
		} catch (Exception e) {
			logger.error("#deleteProduct -- error when deleting product with id= " + id, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductDetailsById(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Product getProductDetailsById(Integer id, String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		Product product = null;
		try {
			ProductEntity pe = productRepository.findOne(id);
			product = fromProductEntity(pe, langCode);
		} catch (Exception e) {
			logger.error("#getProductDetailsById -- error occured when retrieving product details, product_id= " + id, e);
		}
		return product;
	}
	
	
	@Override
	public ShareProduct getShareDetailsById(Integer id, String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		ShareProduct product = null;
		try {
			ProductEntity pe = productRepository.findOne(id);
			product = fromProductShareEntity(pe, langCode);
		} catch (Exception e) {
			logger.error("#getProductDetailsById -- error occured when retrieving product details, product_id= " + id, e);
		}
		return product;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductDetailsByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public Product getProductDetailsByCode(String code, String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		Product product = null;
		
		try {
			ProductEntity pe = productRepository.findOne(QProductEntity.productEntity.code.equalsIgnoreCase(code));
			product = fromProductEntity(pe, langCode);
		} catch (Exception e) {
			logger.error("#getProductDetailsById -- error occured when retrieving product details, product_code= " + code, e);
		}
		return product;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductMetadata(java.lang.Integer, java.lang.String)
	 */
	@Override
	public Hashtable<String, String> getProductMetadata(Integer productId, String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		Hashtable<String, String> metadata = new Hashtable<>();
		Iterable<ProductMetaDataEntity> list = productMetadataRepository.findAll(
				QProductMetaDataEntity.productMetaDataEntity.product().isNotNull()
						.and(QProductMetaDataEntity.productMetaDataEntity.product().id.eq(productId)));
		
		if (list != null && list.iterator().hasNext()){
			for (ProductMetaDataEntity pme:list){
				if (pme.getName().startsWith(METADATA_NAME_ICON) || pme.getName().startsWith(METADATA_NAME_IMAGE)){
					metadata.put(pme.getName(), createImageURL(pme.getValue()));
				}else{
					metadata.put(pme.getName(), pme.getValue());
				}
			}
		}
		return metadata;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts(String langCode, boolean includeHiddenProducts) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<Product> products = new ArrayList<>();
		try {
			Iterable<ProductEntity> it = productRepository.findAll(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal()),
							QProductEntity.productEntity.code.asc());
			if (it != null){
				for (ProductEntity pe:it){
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getAllProducts -- error occured when retrieving product list", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductsByCategory(java.lang.Integer, com.gnv.vnm.selfcare.core.enums.DisplayOrder)
	 */
	@Override
	public List<Product> getProductsByCategoryId(Integer categoryId, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts) {
		
		LoggingUtil.debug(logger, "#getProductsByCategory -- categoryId= " + categoryId + ", order_by= " + orderBy);
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		List<Product> products = new ArrayList<>();
		try {
			Iterable<ProductEntity> it = null;
			BooleanExpression expr = QProductEntity.productEntity.productGroup().isNotNull()
					.and(QProductEntity.productEntity.productGroup().category().isNotNull())
					.and(QProductEntity.productEntity.productGroup().category().id.eq(categoryId))
					.and(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal()));
			
			if (!includeHiddenProducts){
				expr = expr.and(QProductEntity.productEntity.visibility.isNotNull().and(QProductEntity.productEntity.visibility.eq(1)));
			}
			
			switch(orderBy){
			case DATE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.asc());
				break;
			case DATE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.desc());
				break;
			case PRICE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.price.asc());
				break;
			case PRICE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.price.desc());
				break;
			default:
				it = productRepository.findAll(expr, QProductEntity.productEntity.code.desc());
			}
			
			if (it != null){
				for (ProductEntity pe:it){
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getProductsByCategory -- error occured when retrieving product list", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductsByCategoryCode(java.lang.String, com.gnv.vnm.selfcare.core.enums.DisplayOrder)
	 */
	@Override
	public List<Product> getProductsByCategoryCode(String categoryCode, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts) {
		
		ProductCategoryEntity category = productCategoryRepository.findOne(QProductCategoryEntity.productCategoryEntity.code.equalsIgnoreCase(categoryCode));
		if (category != null){
			return getProductsByCategoryId(category.getId(), orderBy, langCode, false);
		}
		return new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#searchProducts(java.lang.String, com.gnv.vnm.selfcare.core.enums.DisplayOrder)
	 */
	@Override
	public List<Product> searchProducts(String searchTerm, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts) {
		LoggingUtil.debug(logger, "#searchProducts -- searchTerm= " + searchTerm + ", order_by= " + orderBy);
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		List<Product> products = new ArrayList<>();
		try {
			Iterable<ProductEntity> it = null;
			BooleanExpression expr = (QProductEntity.productEntity.metadata.any().value.containsIgnoreCase(searchTerm)
					.and(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal())));
			
			if (!includeHiddenProducts){
				expr = expr.and(QProductEntity.productEntity.visibility.isNotNull().and(QProductEntity.productEntity.visibility.eq(1)));
			}

			switch(orderBy){
			case DATE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.asc());
				break;
			case DATE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.desc());
				break;
			case PRICE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.price.asc());
				break;
			case PRICE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.price.desc());
				break;
			case CODE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.code.asc());
			case CODE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.code.desc());
			default: 
				it = productRepository.findAll(expr, QProductEntity.productEntity.displayOrder.desc());
			}
			
			if (it != null){
				for (ProductEntity pe:it){
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#searchProducts -- error occured when retrieving product list", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#searchProducts(java.lang.Integer, java.lang.String, com.gnv.vnm.selfcare.core.enums.DisplayOrder)
	 */
	@Override
	public List<Product> searchProducts(Integer categoryId, String searchTerm, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts) {

		LoggingUtil.debug(logger, "#searchProducts -- category_id= " + categoryId + ", searchTerm= " + searchTerm + ", order_by= " + orderBy);
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		List<Product> products = new ArrayList<>();
		try {
			Iterable<ProductEntity> it = null;
			BooleanExpression expr = QProductEntity.productEntity.productGroup().isNotNull()
					.and(QProductEntity.productEntity.productGroup().category().isNotNull())
					.and(QProductEntity.productEntity.productGroup().category().id.eq(categoryId))
					.and(QProductEntity.productEntity.metadata.any().value.containsIgnoreCase(searchTerm))
					.and(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal()));
			
			if (!includeHiddenProducts){
				expr = expr.and(QProductEntity.productEntity.visibility.isNotNull().and(QProductEntity.productEntity.visibility.eq(1)));
			}
			
			switch(orderBy){
			case DATE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.asc());
				break;
			case DATE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.lastModifiedTime.desc());
				break;
			case PRICE_ASC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.price.asc());
				break;
			case PRICE_DESC:
				it = productRepository.findAll(expr, QProductEntity.productEntity.price.desc());
				break;
			default:
				it = productRepository.findAll(expr, QProductEntity.productEntity.code.desc());
			}
			
			if (it != null){
				for (ProductEntity pe:it){
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#searchProducts -- error occured when retrieving product list", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getRecommendedProducts()
	 */
	@Override
	public List<Product> getRecommendedProducts(String langCode) {
		
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		// TODO select random products from database -- this should be done based on some predefined rules, e.g: most subscribed, most viewed
		List<Product> products = new ArrayList<>();
		try {
			//remove end
			Iterable<PromotedProductEntity> it = promotedProductRepository.findAll(
					QPromotedProductEntity.promotedProductEntity.status.eq(DataStatus.ACTIVE.ordinal()),
					QPromotedProductEntity.promotedProductEntity.lastModifiedTime.desc());
//					QPromotedProductEntity.promotedProductEntity.product().id.desc());
			
			if (it != null){
				for (PromotedProductEntity promotedProd:it){
					ProductEntity pe = promotedProd.getProduct();
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getRecommendedProducts -- error retrieving recommended products list", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getRecommendedProducts(java.lang.Integer)
	 */
	@Override
	public List<Product> getRecommendedProducts(Integer categoryId, String langCode) {
		
		LoggingUtil.debug(logger, "#getRecommendedProducts -- categoryId= " + categoryId);
		
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		// TODO implement logic
		List<Product> products = new ArrayList<>();
		try {
			
			/*
			Iterable<PromotedProductEntity> it = promotedProductRepository.findAll(
					QPromotedProductEntity.promotedProductEntity.endDate.goe(new Date())
					.and(QPromotedProductEntity.promotedProductEntity.status.eq(DataStatus.ACTIVE.ordinal()))
					.and(QPromotedProductEntity.promotedProductEntity.product().productGroup().category().isNotNull())
					.and(QPromotedProductEntity.promotedProductEntity.product().productGroup().category().id.eq(categoryId)), 
					QPromotedProductEntity.promotedProductEntity.product().id.desc());
			*/
			Iterable<PromotedProductEntity> it = promotedProductRepository.findAll(QPromotedProductEntity.promotedProductEntity.status.eq(DataStatus.ACTIVE.ordinal())
					.and(QPromotedProductEntity.promotedProductEntity.product().productGroup().category().isNotNull())
					.and(QPromotedProductEntity.promotedProductEntity.product().productGroup().category().id.eq(categoryId)), 
					QPromotedProductEntity.promotedProductEntity.product().lastModifiedTime.desc());
			
			if (it != null){
				for (PromotedProductEntity promotedProd:it){
					ProductEntity pe = promotedProd.getProduct();
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getRecommendedProducts -- error retrieving recommended products list", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getRecommendedProductsForSubscriber(java.lang.String)
	 */
	@Override
	public List<Product> getRecommendedProductsForSubscriber(String subscriberId, String langCode) {
		// TODO implement logic
		return getRecommendedProducts(null, langCode);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getRecommendedProductsForSubscriber(java.lang.String, java.lang.Integer)
	 */
	@Override
	public List<Product> getRecommendedProductsForSubscriber(String subscriberId, Integer categoryId, String langCode) {
		// TODO implement logic
		return getRecommendedProducts(categoryId, langCode);
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#promoteProduct(com.gnv.vnm.selfcare.core.model.Product, java.util.Date, java.util.Date)
	 */
	@Override
	public void promoteProduct(Integer productId, Date startDate, Date endDate) {
		try {
			ProductEntity product = productRepository.findOne(productId);
			if (product != null){
				promotedProductRepository.saveAndFlush(new PromotedProductEntity(product, startDate, endDate, DataStatus.ACTIVE.ordinal()));
			}else{
				logger.error("#promoteProduct -- could not find product with id= " + productId);
			}
		} catch (Exception e) {
			logger.error("#promoteProduct -- error occured when creating product promotion, product_id= " + productId, e);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#promoteProduct(java.lang.String, java.util.Date, java.util.Date)
	 */
	@Override
	public void promoteProduct(String productCode, Date startDate, Date endDate) {

		try {
			ProductEntity product = productRepository.findOne(QProductEntity.productEntity.code.equalsIgnoreCase(productCode));
			if (product != null){
				promotedProductRepository.saveAndFlush(new PromotedProductEntity(product, startDate, endDate, DataStatus.ACTIVE.ordinal()));
				
			}else{
				logger.error("#promoteProduct -- could not find product with code= " + productCode);
			}
		} catch (Exception e) {
			logger.error("#promoteProduct -- error occured when creating product promotion, product_code= " + productCode, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getPromotedProducts(java.util.Date, java.util.Date)
	 */
	@Override
	public List<Product> getPromotedProducts(Date startDate, Date endDate, String langCode) {
		LoggingUtil.debug(logger, "#getPromotedProducts --- start_date= " + startDate + ", end_date= " + endDate);

		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		List<Product> products = new ArrayList<>();
		try {
			Iterable<PromotedProductEntity> it = promotedProductRepository.findAll(
					QPromotedProductEntity.promotedProductEntity.status.eq(DataStatus.ACTIVE.ordinal())
							.and(QPromotedProductEntity.promotedProductEntity.startDate.goe(startDate)
									.and(QPromotedProductEntity.promotedProductEntity.endDate.loe(endDate))),
					QPromotedProductEntity.promotedProductEntity.product().lastModifiedTime.desc());
			
			if (it != null ){
				for (PromotedProductEntity ppe:it){
					ProductEntity pe = ppe.getProduct();
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getPromotedProducts -- error occured when retrieving promoted products", e);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getPromotedProducts()
	 */
	@Override
	public List<Product> getPromotedProducts(String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();
		
		List<Product> products = new ArrayList<>();
		try {
			Iterable<PromotedProductEntity> it = promotedProductRepository.findAll(
					QPromotedProductEntity.promotedProductEntity.status.eq(DataStatus.ACTIVE.ordinal()),
					QPromotedProductEntity.promotedProductEntity.product().lastModifiedTime.desc());
			
			if (it != null ){
				for (PromotedProductEntity ppe:it){
					ProductEntity pe = ppe.getProduct();
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getPromotedProducts -- error occured when retrieving promoted products", e);
		}
		return products;
	}
	
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getPurchaseAbleProducts(java.lang.String)
	 */
	@Override
	public List<Product> getProductListForChangePackage(String sourceProductCode, String langCode) {
		if (!StringUtils.hasLength(langCode)) langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		List<Product> result = new ArrayList<>();
		try {
			Iterable<ProductChangeMappingEntity> list = productPurchaseMappingRepository
					.findAll(QProductChangeMappingEntity.productChangeMappingEntity.productCode.eq(sourceProductCode)
							.and(QProductChangeMappingEntity.productChangeMappingEntity.buyableProductCode
									.ne(sourceProductCode)));
			
			if (list != null){
				for (ProductChangeMappingEntity ppme:list){
					ProductEntity pe = productRepository.findOne(QProductEntity.productEntity.code.eq(ppme.getBuyableProductCode()));
					if (pe != null){
						result.add(fromProductEntity(pe, langCode));
					}
				}
			}
		} catch (Exception e) {
			logger.error("#getPurchaseAbleProducts -- error occured when retrieving purchaseable product list", e);
		}
		return result;
	}

	private String createImageURL(String productImg){
		if (!StringUtils.hasText(productImg)) return "";
		
		String imageSvr = applicationConfigurationService.get("imageserver.url", "").toString();
		String imageDir = applicationConfigurationService.get("imageserver.imgdir", "").toString();
		
		if (!imageDir.endsWith("/")) imageDir = imageDir + "/";
		
		return imageSvr + imageDir + productImg;
	}
	
	/**
	 * Add Post Pad Migration 
	 * */
	
	/* (non-Javadoc)
	* @see com.gnv.vnm.selfcare.core.service.ProductManagementService#getProductsByProductGroupCode(java.lang.String, com.gnv.vnm.selfcare.core.enums.DisplayOrder, java.lang.String)
	*/
	@Override
	public List<Product> getProductsByProductGroupCode(String productGroupCode, DisplayOrder orderBy, String langCode,
			boolean includeHiddenProducts, SubscriberType subscriberType) {
		if (!StringUtils.hasText(langCode))
			langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		List<Product> products = new ArrayList<>();

		BooleanExpression expr = QProductEntity.productEntity.productGroup().isNotNull()
				.and(QProductEntity.productEntity.productGroup().code.eq(productGroupCode)
						.and(QProductEntity.productEntity.status.eq(DataStatus.ACTIVE.ordinal())));

		if (subscriberType != null) {
			expr = expr.and(QProductEntity.productEntity.subscriberType.isNull()
					.or(QProductEntity.productEntity.subscriberType.eq(subscriberType.ordinal())));
		}

		if (!includeHiddenProducts) {
			expr = expr.and(QProductEntity.productEntity.visibility.isNotNull()
					.and(QProductEntity.productEntity.visibility.eq(1)));
		}

		Iterable<ProductEntity> list = null;
		/*
		 * switch(orderBy){ case DATE_ASC: list =
		 * productRepository.findAll(expr,
		 * QProductEntity.productEntity.lastModifiedTime.asc()); break; case
		 * DATE_DESC: list = productRepository.findAll(expr,
		 * QProductEntity.productEntity.lastModifiedTime.desc()); break; case
		 * PRICE_ASC: list = productRepository.findAll(expr,
		 * QProductEntity.productEntity.price.asc()); break; case PRICE_DESC:
		 * list = productRepository.findAll(expr,
		 * QProductEntity.productEntity.price.desc()); break; case NAME_ASC:
		 * case TITLE_ASC: if
		 * (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) { list
		 * = productRepository.findAll(expr,
		 * QProductEntity.productEntity.nameEN.asc()); }else { list =
		 * productRepository.findAll(expr,
		 * QProductEntity.productEntity.nameVI.asc()); } break; case NAME_DESC:
		 * case TITLE_DESC: if
		 * (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) { list
		 * = productRepository.findAll(expr,
		 * QProductEntity.productEntity.nameEN.desc()); }else { list =
		 * productRepository.findAll(expr,
		 * QProductEntity.productEntity.nameVI.desc()); } break; case
		 * DESCRIPTION_ASC: if
		 * (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) { list
		 * = productRepository.findAll(expr,
		 * QProductEntity.productEntity.descriptionEN.asc()); }else { list =
		 * productRepository.findAll(expr,
		 * QProductEntity.productEntity.descriptionVI.asc()); } break; case
		 * DESCRIPTION_DESC: if
		 * (langCode.equalsIgnoreCase(SupportedLanguage.ENGLISH.code())) { list
		 * = productRepository.findAll(expr,
		 * QProductEntity.productEntity.descriptionEN.desc()); }else { list =
		 * productRepository.findAll(expr,
		 * QProductEntity.productEntity.descriptionVI.desc()); } break;
		 * 
		 * default: list = productRepository.findAll(expr,
		 * QProductEntity.productEntity.code.desc()); }
		 */

		// changed on Oct 02, 2017
		list = productRepository.findAll(expr, QProductEntity.productEntity.displayOrder.asc());
		if (list != null) {
			for (ProductEntity pe : list) {
				products.add(fromProductEntity(pe, langCode));
			}
		}
		return products;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gnv.vnm.selfcare.core.service.ProductManagementService#
	 * getRecommendedProducts()
	 */
	@Override
	public List<Product> getRecommendedProducts(String langCode, SubscriberType subscriberType) {

		if (!StringUtils.hasLength(langCode))
			langCode = SupportedLanguage.ENGLISH.code();
		langCode = langCode.toUpperCase();

		// TODO select random products from database -- this should be done
		// based on some predefined rules, e.g: most subscribed, most viewed
		List<Product> products = new ArrayList<>();
		try {

			BooleanExpression expr = QPromotedProductEntity.promotedProductEntity.status
					.eq(DataStatus.ACTIVE.ordinal());
			if (subscriberType != null) {
				expr = expr.and(QPromotedProductEntity.promotedProductEntity.product().subscriberType.isNull()
						.or(QPromotedProductEntity.promotedProductEntity.product().subscriberType
								.eq(subscriberType.ordinal())));
			}

			Iterable<PromotedProductEntity> it = promotedProductRepository.findAll(expr,
					QPromotedProductEntity.promotedProductEntity.lastModifiedTime.desc());

			if (it != null) {
				for (PromotedProductEntity promotedProd : it) {
					ProductEntity pe = promotedProd.getProduct();
					products.add(fromProductEntity(pe, langCode));
				}
			}
		} catch (Exception e) {
			logger.error("#getRecommendedProducts -- error retrieving recommended products list", e);
		}
		return products;
	}
	

}
