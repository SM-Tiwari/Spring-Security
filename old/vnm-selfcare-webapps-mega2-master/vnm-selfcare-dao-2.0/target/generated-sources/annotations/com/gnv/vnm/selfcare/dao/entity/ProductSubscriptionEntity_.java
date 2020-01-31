package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductSubscriptionEntity.class)
public abstract class ProductSubscriptionEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<ProductSubscriptionEntity, Date> unregisterDate;
	public static volatile SingularAttribute<ProductSubscriptionEntity, ProductEntity> product;
	public static volatile SingularAttribute<ProductSubscriptionEntity, SubscriberEntity> subscriber;
	public static volatile SingularAttribute<ProductSubscriptionEntity, Date> endDate;
	public static volatile SingularAttribute<ProductSubscriptionEntity, Integer> id;
	public static volatile SingularAttribute<ProductSubscriptionEntity, Date> startDate;
	public static volatile SingularAttribute<ProductSubscriptionEntity, Date> expDate;
	public static volatile SingularAttribute<ProductSubscriptionEntity, Integer> status;

}

