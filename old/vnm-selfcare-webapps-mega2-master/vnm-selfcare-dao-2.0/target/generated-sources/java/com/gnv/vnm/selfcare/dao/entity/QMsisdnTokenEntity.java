package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMsisdnTokenEntity is a Querydsl query type for MsisdnTokenEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMsisdnTokenEntity extends EntityPathBase<MsisdnTokenEntity> {

    private static final long serialVersionUID = -804565121L;

    public static final QMsisdnTokenEntity msisdnTokenEntity = new QMsisdnTokenEntity("msisdnTokenEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ipAddress = createString("ipAddress");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public final StringPath token = createString("token");

    public QMsisdnTokenEntity(String variable) {
        super(MsisdnTokenEntity.class, forVariable(variable));
    }

    public QMsisdnTokenEntity(Path<? extends MsisdnTokenEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMsisdnTokenEntity(PathMetadata metadata) {
        super(MsisdnTokenEntity.class, metadata);
    }

}

