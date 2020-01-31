package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoginHistoryEntity.class)
public abstract class LoginHistoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<LoginHistoryEntity, Date> lastLoginTime;
	public static volatile SingularAttribute<LoginHistoryEntity, Date> logoutTime;
	public static volatile SingularAttribute<LoginHistoryEntity, String> lastLoginFrom;
	public static volatile SingularAttribute<LoginHistoryEntity, Integer> id;
	public static volatile SingularAttribute<LoginHistoryEntity, String> msisdn;
	public static volatile SingularAttribute<LoginHistoryEntity, String> clientAppId;

}

