package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductSubscriptionEntity is a Querydsl query type for ProductSubscriptionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductSubscriptionEntity extends EntityPathBase<ProductSubscriptionEntity> {

    private static final long serialVersionUID = -187144148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductSubscriptionEntity productSubscriptionEntity = new QProductSubscriptionEntity("productSubscriptionEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

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

    protected QProductEntity product;

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    protected QSubscriberEntity subscriber;

    public final DateTimePath<java.util.Date> unregisterDate = createDateTime("unregisterDate", java.util.Date.class);

    public QProductSubscriptionEntity(String variable) {
        this(ProductSubscriptionEntity.class, forVariable(variable), INITS);
    }

    public QProductSubscriptionEntity(Path<? extends ProductSubscriptionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductSubscriptionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductSubscriptionEntity(PathMetadata metadata, PathInits inits) {
        this(ProductSubscriptionEntity.class, metadata, inits);
    }

    public QProductSubscriptionEntity(Class<? extends ProductSubscriptionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProductEntity(forProperty("product"), inits.get("product")) : null;
        this.subscriber = inits.isInitialized("subscriber") ? new QSubscriberEntity(forProperty("subscriber"), inits.get("subscriber")) : null;
    }

    public QProductEntity product() {
        if (product == null) {
            product = new QProductEntity(forProperty("product"));
        }
        return product;
    }

    public QSubscriberEntity subscriber() {
        if (subscriber == null) {
            subscriber = new QSubscriberEntity(forProperty("subscriber"));
        }
        return subscriber;
    }

}

