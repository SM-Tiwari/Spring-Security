package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MusicEntity.class)
public abstract class MusicEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<MusicEntity, String> descriptionEN;
	public static volatile SingularAttribute<MusicEntity, String> albumName;
	public static volatile SetAttribute<MusicEntity, MusicMetaDataEntity> metadata;
	public static volatile SingularAttribute<MusicEntity, String> code;
	public static volatile SingularAttribute<MusicEntity, String> previewURL;
	public static volatile SingularAttribute<MusicEntity, Date> releaseDate;
	public static volatile SingularAttribute<MusicEntity, String> format;
	public static volatile SingularAttribute<MusicEntity, String> descriptionVI;
	public static volatile SingularAttribute<MusicEntity, String> displayNameVI;
	public static volatile SingularAttribute<MusicEntity, Integer> quality;
	public static volatile SingularAttribute<MusicEntity, String> sourceURL;
	public static volatile SingularAttribute<MusicEntity, Long> duration;
	public static volatile SingularAttribute<MusicEntity, String> defaultIcon;
	public static volatile SingularAttribute<MusicEntity, BigDecimal> price;
	public static volatile SingularAttribute<MusicEntity, String> productNameVI;
	public static volatile SingularAttribute<MusicEntity, String> defaultBanner;
	public static volatile SingularAttribute<MusicEntity, String> defaultWebBanner;
	public static volatile SingularAttribute<MusicEntity, String> productNameEN;
	public static volatile SingularAttribute<MusicEntity, String> displayNameEN;
	public static volatile SingularAttribute<MusicEntity, String> artistName;
	public static volatile SingularAttribute<MusicEntity, Integer> id;
	public static volatile SingularAttribute<MusicEntity, MusicCategoryEntity> category;
	public static volatile SingularAttribute<MusicEntity, String> defaultImage;
	public static volatile SingularAttribute<MusicEntity, Integer> status;

}

