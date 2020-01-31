package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QContentSubscriptionEntity is a Querydsl query type for ContentSubscriptionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContentSubscriptionEntity extends EntityPathBase<ContentSubscriptionEntity> {

    private static final long serialVersionUID = -1829846730L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QContentSubscriptionEntity contentSubscriptionEntity = new QContentSubscriptionEntity("contentSubscriptionEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> contentCategoryId = createNumber("contentCategoryId", Integer.class);

    public final NumberPath<Integer> contentId = createNumber("contentId", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> expDate = createDateTime("expDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    protected QSubscriberEntity subscriber;

    public final DateTimePath<java.util.Date> unregisterDate = createDateTime("unregisterDate", java.util.Date.class);

    public QContentSubscriptionEntity(String variable) {
        this(ContentSubscriptionEntity.class, forVariable(variable), INITS);
    }

    public QContentSubscriptionEntity(Path<? extends ContentSubscriptionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QContentSubscriptionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QContentSubscriptionEntity(PathMetadata metadata, PathInits inits) {
        this(ContentSubscriptionEntity.class, metadata, inits);
    }

    public QContentSubscriptionEntity(Class<? extends ContentSubscriptionEntity> type, PathMetadata metadata, PathInits inits) {
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

