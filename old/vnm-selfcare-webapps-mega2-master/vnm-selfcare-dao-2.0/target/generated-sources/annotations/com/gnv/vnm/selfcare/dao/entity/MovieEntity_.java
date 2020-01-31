package com.gnv.vnm.selfcare.dao.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MovieEntity.class)
public abstract class MovieEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<MovieEntity, String> descriptionEN;
	public static volatile SingularAttribute<MovieEntity, String> storyLineEN;
	public static volatile SetAttribute<MovieEntity, MovieMetaDataEntity> metadata;
	public static volatile SingularAttribute<MovieEntity, String> code;
	public static volatile SingularAttribute<MovieEntity, String> previewURL;
	public static volatile SingularAttribute<MovieEntity, String> directors;
	public static volatile SingularAttribute<MovieEntity, String> descriptionVI;
	public static volatile SingularAttribute<MovieEntity, String> storyLineVI;
	public static volatile SingularAttribute<MovieEntity, String> sourceURL;
	public static volatile SingularAttribute<MovieEntity, Long> duration;
	public static volatile SingularAttribute<MovieEntity, BigDecimal> price;
	public static volatile SingularAttribute<MovieEntity, String> productNameVI;
	public static volatile SingularAttribute<MovieEntity, String> productNameEN;
	public static volatile SingularAttribute<MovieEntity, String> displayNameEN;
	public static volatile SingularAttribute<MovieEntity, Integer> id;
	public static volatile SingularAttribute<MovieEntity, String> defaultImage;
	public static volatile SingularAttribute<MovieEntity, Date> releaseDate;
	public static volatile SingularAttribute<MovieEntity, String> writers;
	public static volatile SingularAttribute<MovieEntity, String> displayNameVI;
	public static volatile SingularAttribute<MovieEntity, String> producers;
	public static volatile SingularAttribute<MovieEntity, String> actors;
	public static volatile SingularAttribute<MovieEntity, String> defaultIcon;
	public static volatile SingularAttribute<MovieEntity, String> defaultBanner;
	public static volatile SingularAttribute<MovieEntity, String> defaultWebBanner;
	public static volatile SingularAttribute<MovieEntity, MovieCategoryEntity> category;
	public static volatile SingularAttribute<MovieEntity, Integer> status;

}

