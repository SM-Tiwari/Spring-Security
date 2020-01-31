package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubscriberEntity is a Querydsl query type for SubscriberEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubscriberEntity extends EntityPathBase<SubscriberEntity> {

    private static final long serialVersionUID = 2023923790L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubscriberEntity subscriberEntity = new QSubscriberEntity("subscriberEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> avatarId = createNumber("avatarId", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath credential = createString("credential");

    protected QSubscriberDetailEntity details;

    public final StringPath emailAddress = createString("emailAddress");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath imei = createString("imei");

    public final StringPath imsi = createString("imsi");

    public final StringPath languageCode = createString("languageCode");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final StringPath registerFrom = createString("registerFrom");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final SetPath<ContentSubscriptionEntity, QContentSubscriptionEntity> subscribedContents = this.<ContentSubscriptionEntity, QContentSubscriptionEntity>createSet("subscribedContents", ContentSubscriptionEntity.class, QContentSubscriptionEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QSubscriberEntity(String variable) {
        this(SubscriberEntity.class, forVariable(variable), INITS);
    }

    public QSubscriberEntity(Path<? extends SubscriberEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubscriberEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubscriberEntity(PathMetadata metadata, PathInits inits) {
        this(SubscriberEntity.class, metadata, inits);
    }

    public QSubscriberEntity(Class<? extends SubscriberEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.details = inits.isInitialized("details") ? new QSubscriberDetailEntity(forProperty("details"), inits.get("details")) : null;
    }

    public QSubscriberDetailEntity details() {
        if (details == null) {
            details = new QSubscriberDetailEntity(forProperty("details"));
        }
        return details;
    }

}

