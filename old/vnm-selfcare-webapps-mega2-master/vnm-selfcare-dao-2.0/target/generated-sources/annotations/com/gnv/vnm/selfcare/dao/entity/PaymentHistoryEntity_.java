package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PaymentHistoryEntity.class)
public abstract class PaymentHistoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<PaymentHistoryEntity, Double> amount;
	public static volatile SingularAttribute<PaymentHistoryEntity, Double> recharge_amount;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> redirectURL;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> orderId;
	public static volatile SingularAttribute<PaymentHistoryEntity, Date> responseTime;
	public static volatile SingularAttribute<PaymentHistoryEntity, Integer> pgNotificationSent;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> itemCode;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> channel;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> ipAddress;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> checkSumHash;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> trxType;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> clientAppId;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> referenceId;
	public static volatile SingularAttribute<PaymentHistoryEntity, Date> requestTime;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> initialResultMsg;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> finalResultCode;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> commandStatus;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> orderInfo;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> initialResultCode;
	public static volatile SingularAttribute<PaymentHistoryEntity, Integer> id;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> msisdn;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> finalResultMsg;
	public static volatile SingularAttribute<PaymentHistoryEntity, String> extTrxId;
	public static volatile SingularAttribute<PaymentHistoryEntity, Integer> status;

}

