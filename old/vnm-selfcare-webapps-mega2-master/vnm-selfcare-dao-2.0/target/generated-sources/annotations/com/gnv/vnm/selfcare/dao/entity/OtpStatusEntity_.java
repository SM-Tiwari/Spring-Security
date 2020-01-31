package com.gnv.vnm.selfcare.dao.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OtpStatusEntity.class)
public abstract class OtpStatusEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<OtpStatusEntity, String> timeStamp;
	public static volatile SingularAttribute<OtpStatusEntity, Integer> failCount;
	public static volatile SingularAttribute<OtpStatusEntity, Integer> count;
	public static volatile SingularAttribute<OtpStatusEntity, Integer> id;
	public static volatile SingularAttribute<OtpStatusEntity, String> msisdn;
	public static volatile SingularAttribute<OtpStatusEntity, String> status;

}

