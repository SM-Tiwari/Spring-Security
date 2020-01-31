package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppsCategoryEntity.class)
public abstract class AppsCategoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<AppsCategoryEntity, String> nameVI;
	public static volatile SetAttribute<AppsCategoryEntity, AppsCategoryMetaDataEntity> metadata;
	public static volatile SingularAttribute<AppsCategoryEntity, String> code;
	public static volatile SingularAttribute<AppsCategoryEntity, Integer> displayOrder;
	public static volatile SingularAttribute<AppsCategoryEntity, Integer> parentCategoryId;
	public static volatile SingularAttribute<AppsCategoryEntity, Integer> id;
	public static volatile SingularAttribute<AppsCategoryEntity, String> nameEN;

}

