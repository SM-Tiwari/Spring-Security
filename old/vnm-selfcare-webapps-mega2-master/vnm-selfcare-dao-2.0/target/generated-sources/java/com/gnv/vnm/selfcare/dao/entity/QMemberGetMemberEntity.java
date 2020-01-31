package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberGetMemberEntity is a Querydsl query type for MemberGetMemberEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberGetMemberEntity extends EntityPathBase<MemberGetMemberEntity> {

    private static final long serialVersionUID = 1082669974L;

    public static final QMemberGetMemberEntity memberGetMemberEntity = new QMemberGetMemberEntity("memberGetMemberEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> activatedFlag = createNumber("activatedFlag", Integer.class);

    public final DateTimePath<java.util.Date> activationDate = createDateTime("activationDate", java.util.Date.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath invidtedMsisdn = createString("invidtedMsisdn");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath msisdn = createString("msisdn");

    public QMemberGetMemberEntity(String variable) {
        super(MemberGetMemberEntity.class, forVariable(variable));
    }

    public QMemberGetMemberEntity(Path<? extends MemberGetMemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberGetMemberEntity(PathMetadata metadata) {
        super(MemberGetMemberEntity.class, metadata);
    }

}

