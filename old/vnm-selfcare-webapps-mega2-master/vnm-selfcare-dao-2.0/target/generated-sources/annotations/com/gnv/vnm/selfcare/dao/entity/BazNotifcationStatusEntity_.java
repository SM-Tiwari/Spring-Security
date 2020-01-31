package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BazNotifcationStatusEntity.class)
public abstract class BazNotifcationStatusEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<BazNotifcationStatusEntity, Date> read_time;
	public static volatile SingularAttribute<BazNotifcationStatusEntity, String> read_by;
	public static volatile SingularAttribute<BazNotifcationStatusEntity, String> notification_status;
	public static volatile SingularAttribute<BazNotifcationStatusEntity, Integer> id;
	public static volatile SingularAttribute<BazNotifcationStatusEntity, String> msisdn;

}

