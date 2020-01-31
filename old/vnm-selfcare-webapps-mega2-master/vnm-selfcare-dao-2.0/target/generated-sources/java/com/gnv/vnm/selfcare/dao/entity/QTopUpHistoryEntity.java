package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTopUpHistoryEntity is a Querydsl query type for TopUpHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTopUpHistoryEntity extends EntityPathBase<TopUpHistoryEntity> {

    private static final long serialVersionUID = -1890160182L;

    public static final QTopUpHistoryEntity topUpHistoryEntity = new QTopUpHistoryEntity("topUpHistoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    public final StringPath channelId = createString("channelId");

    public final StringPath clientAppId = createString("clientAppId");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final NumberPath<Double> recharge_amount = createNumber("recharge_amount", Double.class);

    public final StringPath referrer = createString("referrer");

    public final StringPath refTrxId = createString("refTrxId");

    public final StringPath sessionId = createString("sessionId");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> timeStamp = createDateTime("timeStamp", java.util.Date.class);

    public final StringPath voucherCode = createString("voucherCode");

    public QTopUpHistoryEntity(String variable) {
        super(TopUpHistoryEntity.class, forVariable(variable));
    }

    public QTopUpHistoryEntity(Path<? extends TopUpHistoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTopUpHistoryEntity(PathMetadata metadata) {
        super(TopUpHistoryEntity.class, metadata);
    }

}

