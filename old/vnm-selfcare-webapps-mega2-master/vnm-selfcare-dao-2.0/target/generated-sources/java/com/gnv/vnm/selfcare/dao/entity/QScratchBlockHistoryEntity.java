package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QScratchBlockHistoryEntity is a Querydsl query type for ScratchBlockHistoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QScratchBlockHistoryEntity extends EntityPathBase<ScratchBlockHistoryEntity> {

    private static final long serialVersionUID = -301412319L;

    public static final QScratchBlockHistoryEntity scratchBlockHistoryEntity = new QScratchBlockHistoryEntity("scratchBlockHistoryEntity");

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

    public final StringPath statusMessage = createString("statusMessage");

    public final StringPath timeStamp = createString("timeStamp");

    public QScratchBlockHistoryEntity(String variable) {
        super(ScratchBlockHistoryEntity.class, forVariable(variable));
    }

    public QScratchBlockHistoryEntity(Path<? extends ScratchBlockHistoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QScratchBlockHistoryEntity(PathMetadata metadata) {
        super(ScratchBlockHistoryEntity.class, metadata);
    }

}

