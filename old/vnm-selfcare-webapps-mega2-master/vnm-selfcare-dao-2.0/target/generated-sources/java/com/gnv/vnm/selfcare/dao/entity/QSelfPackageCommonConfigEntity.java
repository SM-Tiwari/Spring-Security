package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelfPackageCommonConfigEntity is a Querydsl query type for SelfPackageCommonConfigEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSelfPackageCommonConfigEntity extends EntityPathBase<SelfPackageCommonConfigEntity> {

    private static final long serialVersionUID = -945385657L;

    public static final QSelfPackageCommonConfigEntity selfPackageCommonConfigEntity = new QSelfPackageCommonConfigEntity("selfPackageCommonConfigEntity");

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

    public final StringPath name = createString("name");

    public final StringPath value = createString("value");

    public QSelfPackageCommonConfigEntity(String variable) {
        super(SelfPackageCommonConfigEntity.class, forVariable(variable));
    }

    public QSelfPackageCommonConfigEntity(Path<? extends SelfPackageCommonConfigEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelfPackageCommonConfigEntity(PathMetadata metadata) {
        super(SelfPackageCommonConfigEntity.class, metadata);
    }

}

