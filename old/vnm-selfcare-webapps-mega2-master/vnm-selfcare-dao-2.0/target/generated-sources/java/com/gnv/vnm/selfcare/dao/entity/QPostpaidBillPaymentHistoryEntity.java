package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPostpaidBillPaymentHistoryEntity is a Querydsl query type for PostpaidBillPaymentHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPostpaidBillPaymentHistoryEntity extends EntityPathBase<PostpaidBillPaymentHistoryEntity> {

    private static final long serialVersionUID = 2002588487L;

    public static final QPostpaidBillPaymentHistoryEntity postpaidBillPaymentHistoryEntity = new QPostpaidBillPaymentHistoryEntity("postpaidBillPaymentHistoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final StringPath channelId = createString("channelId");

    public final StringPath clientAppId = createString("clientAppId");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath invoiceNo = createString("invoiceNo");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final StringPath refTrxId = createString("refTrxId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> timeStamp = createDateTime("timeStamp", java.util.Date.class);

    public final StringPath trxType = createString("trxType");

    public final StringPath voucherCode = createString("voucherCode");

    public QPostpaidBillPaymentHistoryEntity(String variable) {
        super(PostpaidBillPaymentHistoryEntity.class, forVariable(variable));
    }

    public QPostpaidBillPaymentHistoryEntity(Path<? extends PostpaidBillPaymentHistoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostpaidBillPaymentHistoryEntity(PathMetadata metadata) {
        super(PostpaidBillPaymentHistoryEntity.class, metadata);
    }

}

