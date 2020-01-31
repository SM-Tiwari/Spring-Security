package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductCategoryEntity.class)
public abstract class ProductCategoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<ProductCategoryEntity, String> nameVI;
	public static volatile SingularAttribute<ProductCategoryEntity, String> descriptionEN;
	public static volatile SetAttribute<ProductCategoryEntity, ProductCategoryMetaDataEntity> metadata;
	public static volatile SingularAttribute<ProductCategoryEntity, String> code;
	public static volatile SingularAttribute<ProductCategoryEntity, String> defaultIcon;
	public static volatile SingularAttribute<ProductCategoryEntity, String> defaultBanner;
	public static volatile SingularAttribute<ProductCategoryEntity, Integer> parentCategoryId;
	public static volatile SingularAttribute<ProductCategoryEntity, Integer> id;
	public static volatile SingularAttribute<ProductCategoryEntity, String> nameEN;
	public static volatile SingularAttribute<ProductCategoryEntity, String> descriptionVI;
	public static volatile SingularAttribute<ProductCategoryEntity, String> defaultImage;

}

