package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GameEntity.class)
public abstract class GameEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<GameEntity, String> descriptionEN;
	public static volatile SetAttribute<GameEntity, GameMetaDataEntity> metadata;
	public static volatile SingularAttribute<GameEntity, String> code;
	public static volatile SingularAttribute<GameEntity, String> notesEN;
	public static volatile SingularAttribute<GameEntity, String> previewURL;
	public static volatile SingularAttribute<GameEntity, String> descriptionVI;
	public static volatile SingularAttribute<GameEntity, BigDecimal> price;
	public static volatile SingularAttribute<GameEntity, String> productNameVI;
	public static volatile SingularAttribute<GameEntity, String> productNameEN;
	public static volatile SingularAttribute<GameEntity, String> displayNameEN;
	public static volatile SingularAttribute<GameEntity, Integer> id;
	public static volatile SingularAttribute<GameEntity, String> notesVI;
	public static volatile SingularAttribute<GameEntity, String> defaultImage;
	public static volatile SingularAttribute<GameEntity, Date> releaseDate;
	public static volatile SingularAttribute<GameEntity, String> androidSourceURL;
	public static volatile SingularAttribute<GameEntity, String> version;
	public static volatile SingularAttribute<GameEntity, String> displayNameVI;
	public static volatile SingularAttribute<GameEntity, String> producers;
	public static volatile SingularAttribute<GameEntity, Long> fileSize;
	public static volatile SingularAttribute<GameEntity, String> defaultIcon;
	public static volatile SingularAttribute<GameEntity, String> defaultBanner;
	public static volatile SingularAttribute<GameEntity, String> defaultWebBanner;
	public static volatile SingularAttribute<GameEntity, String> supportedSystems;
	public static volatile SingularAttribute<GameEntity, GameCategoryEntity> category;
	public static volatile SingularAttribute<GameEntity, String> iosSourceURL;
	public static volatile SingularAttribute<GameEntity, Integer> status;

}

