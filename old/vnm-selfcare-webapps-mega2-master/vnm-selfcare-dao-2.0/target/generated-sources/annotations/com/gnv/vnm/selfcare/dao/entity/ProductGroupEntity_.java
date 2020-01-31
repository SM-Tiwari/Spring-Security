package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductGroupEntity.class)
public abstract class ProductGroupEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<ProductGroupEntity, String> nameVI;
	public static volatile SingularAttribute<ProductGroupEntity, String> descriptionEN;
	public static volatile SetAttribute<ProductGroupEntity, ProductGroupMetaDataEntity> metadata;
	public static volatile SingularAttribute<ProductGroupEntity, String> code;
	public static volatile SingularAttribute<ProductGroupEntity, Integer> visibility;
	public static volatile SingularAttribute<ProductGroupEntity, Integer> displayOrder;
	public static volatile SingularAttribute<ProductGroupEntity, String> nameEN;
	public static volatile SingularAttribute<ProductGroupEntity, String> descriptionVI;
	public static volatile SetAttribute<ProductGroupEntity, ProductEntity> products;
	public static volatile SingularAttribute<ProductGroupEntity, String> defaultBanner;
	public static volatile SingularAttribute<ProductGroupEntity, Integer> id;
	public static volatile SingularAttribute<ProductGroupEntity, ProductCategoryEntity> category;
	public static volatile SingularAttribute<ProductGroupEntity, String> defaultImage;

}

