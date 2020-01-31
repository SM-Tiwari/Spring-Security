package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransactionHistoryEntity is a Querydsl query type for TransactionHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTransactionHistoryEntity extends EntityPathBase<TransactionHistoryEntity> {

    private static final long serialVersionUID = -1851995588L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransactionHistoryEntity transactionHistoryEntity = new QTransactionHistoryEntity("transactionHistoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath clientAppId = createString("clientAppId");

    public final NumberPath<Integer> contentCategoryId = createNumber("contentCategoryId", Integer.class);

    public final StringPath contentCode = createString("contentCode");

    public final NumberPath<Integer> contentId = createNumber("contentId", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> paymentMethod = createNumber("paymentMethod", Integer.class);

    public final StringPath productCode = createString("productCode");

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    protected QSubscriberEntity subscriber;

    public final DateTimePath<java.util.Date> trxDate = createDateTime("trxDate", java.util.Date.class);

    public QTransactionHistoryEntity(String variable) {
        this(TransactionHistoryEntity.class, forVariable(variable), INITS);
    }

    public QTransactionHistoryEntity(Path<? extends TransactionHistoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransactionHistoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransactionHistoryEntity(PathMetadata metadata, PathInits inits) {
        this(TransactionHistoryEntity.class, metadata, inits);
    }

    public QTransactionHistoryEntity(Class<? extends TransactionHistoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subscriber = inits.isInitialized("subscriber") ? new QSubscriberEntity(forProperty("subscriber"), inits.get("subscriber")) : null;
    }

    public QSubscriberEntity subscriber() {
        if (subscriber == null) {
            subscriber = new QSubscriberEntity(forProperty("subscriber"));
        }
        return subscriber;
    }

}

