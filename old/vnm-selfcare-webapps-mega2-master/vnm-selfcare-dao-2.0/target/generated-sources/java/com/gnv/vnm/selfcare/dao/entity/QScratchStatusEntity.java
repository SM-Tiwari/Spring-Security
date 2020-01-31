package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QScratchStatusEntity is a Querydsl query type for ScratchStatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QScratchStatusEntity extends EntityPathBase<ScratchStatusEntity> {

    private static final long serialVersionUID = 1213424076L;

    public static final QScratchStatusEntity scratchStatusEntity = new QScratchStatusEntity("scratchStatusEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

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

    public final StringPath msisdn = createString("msisdn");

    public final StringPath status = createString("status");

    public final StringPath timeStamp = createString("timeStamp");

    public QScratchStatusEntity(String variable) {
        super(ScratchStatusEntity.class, forVariable(variable));
    }

    public QScratchStatusEntity(Path<? extends ScratchStatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScratchStatusEntity(PathMetadata metadata) {
        super(ScratchStatusEntity.class, metadata);
    }

}

