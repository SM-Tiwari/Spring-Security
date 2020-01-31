package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductEntity.class)
public abstract class ProductEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<ProductEntity, String> nameVI;
	public static volatile SingularAttribute<ProductEntity, String> descriptionEN;
	public static volatile SetAttribute<ProductEntity, ProductMetaDataEntity> metadata;
	public static volatile SingularAttribute<ProductEntity, String> code;
	public static volatile SingularAttribute<ProductEntity, String> howToRegEN;
	public static volatile SingularAttribute<ProductEntity, String> howToUnregVI;
	public static volatile SingularAttribute<ProductEntity, Integer> displayOrder;
	public static volatile SingularAttribute<ProductEntity, String> howToRegVI;
	public static volatile SingularAttribute<ProductEntity, String> nameEN;
	public static volatile SingularAttribute<ProductEntity, String> descriptionVI;
	public static volatile SingularAttribute<ProductEntity, String> shortDescriptionEN;
	public static volatile SingularAttribute<ProductEntity, String> detailsEN;
	public static volatile SingularAttribute<ProductEntity, String> detailsVI;
	public static volatile SingularAttribute<ProductEntity, String> extProductName;
	public static volatile SingularAttribute<ProductEntity, String> shortDescriptionVI;
	public static volatile SingularAttribute<ProductEntity, BigDecimal> price;
	public static volatile SingularAttribute<ProductEntity, String> quotaInfo;
	public static volatile SingularAttribute<ProductEntity, Integer> id;
	public static volatile SingularAttribute<ProductEntity, Date> validToDate;
	public static volatile SingularAttribute<ProductEntity, String> defaultImage;
	public static volatile SingularAttribute<ProductEntity, String> shortNameVI;
	public static volatile SingularAttribute<ProductEntity, Integer> visibility;
	public static volatile SingularAttribute<ProductEntity, Integer> dashboardVisibility;
	public static volatile SingularAttribute<ProductEntity, String> shortNameEN;
	public static volatile SingularAttribute<ProductEntity, String> howToUnregEN;
	public static volatile SingularAttribute<ProductEntity, String> extCode;
	public static volatile SingularAttribute<ProductEntity, Integer> balanceDisplayOption;
	public static volatile SingularAttribute<ProductEntity, ProductGroupEntity> productGroup;
	public static volatile SingularAttribute<ProductEntity, String> defaultBanner;
	public static volatile SingularAttribute<ProductEntity, Date> validFromDate;
	public static volatile SingularAttribute<ProductEntity, Integer> status;

}

