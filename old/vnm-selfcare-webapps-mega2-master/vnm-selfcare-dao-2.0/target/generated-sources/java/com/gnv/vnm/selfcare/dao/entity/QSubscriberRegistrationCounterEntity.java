package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubscriberRegistrationCounterEntity is a Querydsl query type for SubscriberRegistrationCounterEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubscriberRegistrationCounterEntity extends EntityPathBase<SubscriberRegistrationCounterEntity> {

    private static final long serialVersionUID = -1900932485L;

    public static final QSubscriberRegistrationCounterEntity subscriberRegistrationCounterEntity = new QSubscriberRegistrationCounterEntity("subscriberRegistrationCounterEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath appSourceId = createString("appSourceId");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public QSubscriberRegistrationCounterEntity(String variable) {
        super(SubscriberRegistrationCounterEntity.class, forVariable(variable));
    }

    public QSubscriberRegistrationCounterEntity(Path<? extends SubscriberRegistrationCounterEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubscriberRegistrationCounterEntity(PathMetadata metadata) {
        super(SubscriberRegistrationCounterEntity.class, metadata);
    }

}

