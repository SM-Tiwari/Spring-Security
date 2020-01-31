package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SmsCallHistoryStatusEntity.class)
public abstract class SmsCallHistoryStatusEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<SmsCallHistoryStatusEntity, Integer> id;
	public static volatile SingularAttribute<SmsCallHistoryStatusEntity, String> msisdn;
	public static volatile SingularAttribute<SmsCallHistoryStatusEntity, String> status;

}

