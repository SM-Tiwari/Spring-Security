package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassOfServiceEntity is a Querydsl query type for ClassOfServiceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassOfServiceEntity extends EntityPathBase<ClassOfServiceEntity> {

    private static final long serialVersionUID = -1269052884L;

    public static final QClassOfServiceEntity classOfServiceEntity = new QClassOfServiceEntity("classOfServiceEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath displayName = createString("displayName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath name = createString("name");

    public QClassOfServiceEntity(String variable) {
        super(ClassOfServiceEntity.class, forVariable(variable));
    }

    public QClassOfServiceEntity(Path<? extends ClassOfServiceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassOfServiceEntity(PathMetadata metadata) {
        super(ClassOfServiceEntity.class, metadata);
    }

}

