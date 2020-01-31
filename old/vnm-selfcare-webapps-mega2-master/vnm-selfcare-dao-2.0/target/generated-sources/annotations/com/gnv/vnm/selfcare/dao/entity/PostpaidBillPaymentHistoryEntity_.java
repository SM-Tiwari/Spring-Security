package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PostpaidBillPaymentHistoryEntity.class)
public abstract class PostpaidBillPaymentHistoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, Date> timeStamp;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, Double> amount;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> trxType;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, Integer> id;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> msisdn;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> invoiceNo;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> refTrxId;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> clientAppId;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> voucherCode;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, String> channelId;
	public static volatile SingularAttribute<PostpaidBillPaymentHistoryEntity, Integer> status;

}

