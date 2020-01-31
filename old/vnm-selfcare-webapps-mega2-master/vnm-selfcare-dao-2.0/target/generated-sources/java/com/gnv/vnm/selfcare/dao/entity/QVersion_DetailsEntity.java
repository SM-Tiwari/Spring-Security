package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVersion_DetailsEntity is a Querydsl query type for Version_DetailsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVersion_DetailsEntity extends EntityPathBase<Version_DetailsEntity> {

    private static final long serialVersionUID = 655495547L;

    public static final QVersion_DetailsEntity version_DetailsEntity = new QVersion_DetailsEntity("version_DetailsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath app_os = createString("app_os");

    public final StringPath app_os_version = createString("app_os_version");

    public final StringPath app_version = createString("app_version");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath devic_id = createString("devic_id");

    public final StringPath devic_modeil = createString("devic_modeil");

    public final StringPath devic_name = createString("devic_name");

    public final NumberPath<Integer> Id = createNumber("Id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath loginId = createString("loginId");

    public QVersion_DetailsEntity(String variable) {
        super(Version_DetailsEntity.class, forVariable(variable));
    }

    public QVersion_DetailsEntity(Path<? extends Version_DetailsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVersion_DetailsEntity(PathMetadata metadata) {
        super(Version_DetailsEntity.class, metadata);
    }

}

