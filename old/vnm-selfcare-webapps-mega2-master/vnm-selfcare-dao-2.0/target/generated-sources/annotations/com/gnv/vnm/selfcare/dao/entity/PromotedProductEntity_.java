package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PromotedProductEntity.class)
public abstract class PromotedProductEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<PromotedProductEntity, ProductEntity> product;
	public static volatile SingularAttribute<PromotedProductEntity, Date> endDate;
	public static volatile SingularAttribute<PromotedProductEntity, Integer> id;
	public static volatile SingularAttribute<PromotedProductEntity, Date> startDate;
	public static volatile SingularAttribute<PromotedProductEntity, Integer> status;

}

