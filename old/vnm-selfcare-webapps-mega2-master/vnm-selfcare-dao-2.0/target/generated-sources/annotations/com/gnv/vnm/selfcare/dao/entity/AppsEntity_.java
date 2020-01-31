package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppsEntity.class)
public abstract class AppsEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<AppsEntity, String> descriptionEN;
	public static volatile SetAttribute<AppsEntity, AppsMetaDataEntity> metadata;
	public static volatile SingularAttribute<AppsEntity, String> code;
	public static volatile SingularAttribute<AppsEntity, String> notesEN;
	public static volatile SingularAttribute<AppsEntity, String> previewURL;
	public static volatile SingularAttribute<AppsEntity, String> descriptionVI;
	public static volatile SingularAttribute<AppsEntity, BigDecimal> price;
	public static volatile SingularAttribute<AppsEntity, String> productNameVI;
	public static volatile SingularAttribute<AppsEntity, String> productNameEN;
	public static volatile SingularAttribute<AppsEntity, String> displayNameEN;
	public static volatile SingularAttribute<AppsEntity, Integer> id;
	public static volatile SingularAttribute<AppsEntity, String> notesVI;
	public static volatile SingularAttribute<AppsEntity, String> defaultImage;
	public static volatile SingularAttribute<AppsEntity, Date> releaseDate;
	public static volatile SingularAttribute<AppsEntity, String> androidSourceURL;
	public static volatile SingularAttribute<AppsEntity, String> version;
	public static volatile SingularAttribute<AppsEntity, String> displayNameVI;
	public static volatile SingularAttribute<AppsEntity, String> producers;
	public static volatile SingularAttribute<AppsEntity, Long> fileSize;
	public static volatile SingularAttribute<AppsEntity, String> defaultIcon;
	public static volatile SingularAttribute<AppsEntity, String> defaultBanner;
	public static volatile SingularAttribute<AppsEntity, String> defaultWebBanner;
	public static volatile SingularAttribute<AppsEntity, String> supportedSystems;
	public static volatile SingularAttribute<AppsEntity, AppsCategoryEntity> category;
	public static volatile SingularAttribute<AppsEntity, String> iosSourceURL;
	public static volatile SingularAttribute<AppsEntity, Integer> status;

}

