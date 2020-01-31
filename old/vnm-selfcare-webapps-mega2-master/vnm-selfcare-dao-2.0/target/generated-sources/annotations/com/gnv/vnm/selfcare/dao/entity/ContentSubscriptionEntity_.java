package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ContentSubscriptionEntity.class)
public abstract class ContentSubscriptionEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<ContentSubscriptionEntity, Date> unregisterDate;
	public static volatile SingularAttribute<ContentSubscriptionEntity, SubscriberEntity> subscriber;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Date> endDate;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Integer> contentId;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Integer> contentCategoryId;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Integer> id;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Date> startDate;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Date> expDate;
	public static volatile SingularAttribute<ContentSubscriptionEntity, Integer> status;

}

