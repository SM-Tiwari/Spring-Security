package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BackEndRequestLogEntity.class)
public abstract class BackEndRequestLogEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<BackEndRequestLogEntity, String> statusDesc;
	public static volatile SingularAttribute<BackEndRequestLogEntity, Date> startTime;
	public static volatile SingularAttribute<BackEndRequestLogEntity, Integer> id;
	public static volatile SingularAttribute<BackEndRequestLogEntity, String> adapterName;
	public static volatile SingularAttribute<BackEndRequestLogEntity, Date> endTime;
	public static volatile SingularAttribute<BackEndRequestLogEntity, String> trxId;
	public static volatile SingularAttribute<BackEndRequestLogEntity, String> reqPayload;
	public static volatile SingularAttribute<BackEndRequestLogEntity, Integer> status;
	public static volatile SingularAttribute<BackEndRequestLogEntity, String> statusCode;

}

