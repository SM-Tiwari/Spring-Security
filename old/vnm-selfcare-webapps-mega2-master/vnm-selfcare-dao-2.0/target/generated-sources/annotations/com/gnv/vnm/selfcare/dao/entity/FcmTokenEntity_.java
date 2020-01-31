package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FcmTokenEntity.class)
public abstract class FcmTokenEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<FcmTokenEntity, Date> lastUsed;
	public static volatile SingularAttribute<FcmTokenEntity, String> osType;
	public static volatile SingularAttribute<FcmTokenEntity, Integer> id;
	public static volatile SingularAttribute<FcmTokenEntity, String> msisdn;
	public static volatile SingularAttribute<FcmTokenEntity, String> token;

}

