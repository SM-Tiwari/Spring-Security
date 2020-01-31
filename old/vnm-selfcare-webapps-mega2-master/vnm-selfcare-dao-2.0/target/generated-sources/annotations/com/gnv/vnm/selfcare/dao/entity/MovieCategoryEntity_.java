package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MovieCategoryEntity.class)
public abstract class MovieCategoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<MovieCategoryEntity, String> nameVI;
	public static volatile SetAttribute<MovieCategoryEntity, MovieCategoryMetaDataEntity> metadata;
	public static volatile SingularAttribute<MovieCategoryEntity, String> code;
	public static volatile SingularAttribute<MovieCategoryEntity, Integer> displayOrder;
	public static volatile SingularAttribute<MovieCategoryEntity, Integer> parentCategoryId;
	public static volatile SingularAttribute<MovieCategoryEntity, Integer> id;
	public static volatile SingularAttribute<MovieCategoryEntity, String> nameEN;

}

