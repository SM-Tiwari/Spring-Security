package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TopUpHistoryEntity.class)
public abstract class TopUpHistoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<TopUpHistoryEntity, Date> timeStamp;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> referrer;
	public static volatile SingularAttribute<TopUpHistoryEntity, Double> amount;
	public static volatile SingularAttribute<TopUpHistoryEntity, Double> recharge_amount;
	public static volatile SingularAttribute<TopUpHistoryEntity, Integer> id;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> sessionId;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> msisdn;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> refTrxId;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> clientAppId;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> voucherCode;
	public static volatile SingularAttribute<TopUpHistoryEntity, String> channelId;
	public static volatile SingularAttribute<TopUpHistoryEntity, Integer> status;

}

