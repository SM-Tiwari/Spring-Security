package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMicStatusEntity is a Querydsl query type for MicStatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMicStatusEntity extends EntityPathBase<MicStatusEntity> {

    private static final long serialVersionUID = 1360785433L;

    public static final QMicStatusEntity micStatusEntity = new QMicStatusEntity("micStatusEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

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

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath subscriberId = createString("subscriberId");

    public QMicStatusEntity(String variable) {
        super(MicStatusEntity.class, forVariable(variable));
    }

    public QMicStatusEntity(Path<? extends MicStatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMicStatusEntity(PathMetadata metadata) {
        super(MicStatusEntity.class, metadata);
    }

}

