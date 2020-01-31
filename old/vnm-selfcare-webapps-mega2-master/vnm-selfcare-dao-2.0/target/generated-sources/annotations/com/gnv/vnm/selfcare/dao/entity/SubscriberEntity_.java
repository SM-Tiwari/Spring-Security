package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SubscriberEntity.class)
public abstract class SubscriberEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<SubscriberEntity, String> registerFrom;
	public static volatile SingularAttribute<SubscriberEntity, String> imsi;
	public static volatile SingularAttribute<SubscriberEntity, Integer> type;
	public static volatile SingularAttribute<SubscriberEntity, String> languageCode;
	public static volatile SetAttribute<SubscriberEntity, ContentSubscriptionEntity> subscribedContents;
	public static volatile SingularAttribute<SubscriberEntity, String> emailAddress;
	public static volatile SingularAttribute<SubscriberEntity, Integer> avatarId;
	public static volatile SingularAttribute<SubscriberEntity, String> credential;
	public static volatile SingularAttribute<SubscriberEntity, String> imei;
	public static volatile SingularAttribute<SubscriberEntity, SubscriberDetailEntity> details;
	public static volatile SingularAttribute<SubscriberEntity, Integer> id;
	public static volatile SingularAttribute<SubscriberEntity, String> msisdn;
	public static volatile SingularAttribute<SubscriberEntity, Integer> status;

}

