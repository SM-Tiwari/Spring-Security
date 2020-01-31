package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubscriberDetailEntity is a Querydsl query type for SubscriberDetailEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubscriberDetailEntity extends EntityPathBase<SubscriberDetailEntity> {

    private static final long serialVersionUID = 1779836863L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubscriberDetailEntity subscriberDetailEntity = new QSubscriberDetailEntity("subscriberDetailEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath address3 = createString("address3");

    public final StringPath avatar = createString("avatar");

    public final DateTimePath<java.util.Date> birthDate = createDateTime("birthDate", java.util.Date.class);

    public final StringPath companyName = createString("companyName");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath fullName = createString("fullName");

    public final NumberPath<Integer> gender = createNumber("gender", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath occupation = createString("occupation");

    protected QSubscriberEntity subscriber;

    public final StringPath zipCode = createString("zipCode");

    public QSubscriberDetailEntity(String variable) {
        this(SubscriberDetailEntity.class, forVariable(variable), INITS);
    }

    public QSubscriberDetailEntity(Path<? extends SubscriberDetailEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubscriberDetailEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubscriberDetailEntity(PathMetadata metadata, PathInits inits) {
        this(SubscriberDetailEntity.class, metadata, inits);
    }

    public QSubscriberDetailEntity(Class<? extends SubscriberDetailEntity> type, PathMetadata metadata, PathInits inits) {
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

