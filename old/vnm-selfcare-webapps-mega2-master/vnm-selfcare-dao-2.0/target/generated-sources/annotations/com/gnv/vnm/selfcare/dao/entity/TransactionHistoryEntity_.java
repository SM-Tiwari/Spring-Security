package com.gnv.vnm.selfcare.dao.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TransactionHistoryEntity.class)
public abstract class TransactionHistoryEntity_ extends com.gnv.vnm.selfcare.dao.entity.BaseEntity_ {

	public static volatile SingularAttribute<TransactionHistoryEntity, String> contentCode;
	public static volatile SingularAttribute<TransactionHistoryEntity, SubscriberEntity> subscriber;
	public static volatile SingularAttribute<TransactionHistoryEntity, String> productCode;
	public static volatile SingularAttribute<TransactionHistoryEntity, Integer> productId;
	public static volatile SingularAttribute<TransactionHistoryEntity, Integer> contentId;
	public static volatile SingularAttribute<TransactionHistoryEntity, Integer> paymentMethod;
	public static volatile SingularAttribute<TransactionHistoryEntity, Integer> contentCategoryId;
	public static volatile SingularAttribute<TransactionHistoryEntity, Integer> id;
	public static volatile SingularAttribute<TransactionHistoryEntity, String> clientAppId;
	public static volatile SingularAttribute<TransactionHistoryEntity, Date> trxDate;
	public static volatile SingularAttribute<TransactionHistoryEntity, Integer> status;

}

