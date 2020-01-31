package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLmsConfigEntity is a Querydsl query type for LmsConfigEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLmsConfigEntity extends EntityPathBase<LmsConfigEntity> {

    private static final long serialVersionUID = -168162380L;

    public static final QLmsConfigEntity lmsConfigEntity = new QLmsConfigEntity("lmsConfigEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath name = createString("name");

    public final StringPath value = createString("value");

    public QLmsConfigEntity(String variable) {
        super(LmsConfigEntity.class, forVariable(variable));
    }

    public QLmsConfigEntity(Path<? extends LmsConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLmsConfigEntity(PathMetadata metadata) {
        super(LmsConfigEntity.class, metadata);
    }

}

