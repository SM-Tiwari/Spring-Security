package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFattyRedeemEntity is a Querydsl query type for FattyRedeemEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFattyRedeemEntity extends EntityPathBase<FattyRedeemEntity> {

    private static final long serialVersionUID = -330785382L;

    public static final QFattyRedeemEntity fattyRedeemEntity = new QFattyRedeemEntity("fattyRedeemEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath fattyResponceMessage = createString("fattyResponceMessage");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final StringPath msisdn = createString("msisdn");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath userType = createString("userType");

    public final StringPath weight = createString("weight");

    public QFattyRedeemEntity(String variable) {
        super(FattyRedeemEntity.class, forVariable(variable));
    }

    public QFattyRedeemEntity(Path<? extends FattyRedeemEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFattyRedeemEntity(PathMetadata metadata) {
        super(FattyRedeemEntity.class, metadata);
    }

}

