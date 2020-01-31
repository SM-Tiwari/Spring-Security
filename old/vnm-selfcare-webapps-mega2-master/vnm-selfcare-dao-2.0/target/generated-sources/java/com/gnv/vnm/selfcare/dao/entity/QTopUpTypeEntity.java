package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTopUpTypeEntity is a Querydsl query type for TopUpTypeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTopUpTypeEntity extends EntityPathBase<TopUpTypeEntity> {

    private static final long serialVersionUID = 2070197354L;

    public static final QTopUpTypeEntity topUpTypeEntity = new QTopUpTypeEntity("topUpTypeEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath displayNameEN = createString("displayNameEN");

    public final StringPath displayNameVI = createString("displayNameVI");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath name = createString("name");

    public QTopUpTypeEntity(String variable) {
        super(TopUpTypeEntity.class, forVariable(variable));
    }

    public QTopUpTypeEntity(Path<? extends TopUpTypeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTopUpTypeEntity(PathMetadata metadata) {
        super(TopUpTypeEntity.class, metadata);
    }

}

