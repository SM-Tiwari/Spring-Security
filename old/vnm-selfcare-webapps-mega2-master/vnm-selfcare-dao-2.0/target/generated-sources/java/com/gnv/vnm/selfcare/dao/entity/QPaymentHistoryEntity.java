package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentHistoryEntity is a Querydsl query type for PaymentHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentHistoryEntity extends EntityPathBase<PaymentHistoryEntity> {

    private static final long serialVersionUID = 1307325844L;

    public static final QPaymentHistoryEntity paymentHistoryEntity = new QPaymentHistoryEntity("paymentHistoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final StringPath channel = createString("channel");

    public final StringPath checkSumHash = createString("checkSumHash");

    public final StringPath clientAppId = createString("clientAppId");

    public final StringPath commandStatus = createString("commandStatus");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath extTrxId = createString("extTrxId");

    public final StringPath finalResultCode = createString("finalResultCode");

    public final StringPath finalResultMsg = createString("finalResultMsg");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath initialResultCode = createString("initialResultCode");

    public final StringPath initialResultMsg = createString("initialResultMsg");

    public final StringPath ipAddress = createString("ipAddress");

    public final StringPath itemCode = createString("itemCode");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final StringPath orderId = createString("orderId");

    public final StringPath orderInfo = createString("orderInfo");

    public final NumberPath<Integer> pgNotificationSent = createNumber("pgNotificationSent", Integer.class);

    public final NumberPath<Double> recharge_amount = createNumber("recharge_amount", Double.class);

    public final StringPath redirectURL = createString("redirectURL");

    public final StringPath referenceId = createString("referenceId");

    public final DateTimePath<java.util.Date> requestTime = createDateTime("requestTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> responseTime = createDateTime("responseTime", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath trxType = createString("trxType");

    public QPaymentHistoryEntity(String variable) {
        super(PaymentHistoryEntity.class, forVariable(variable));
    }

    public QPaymentHistoryEntity(Path<? extends PaymentHistoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentHistoryEntity(PathMetadata metadata) {
        super(PaymentHistoryEntity.class, metadata);
    }

}

