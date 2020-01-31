package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVersionUpdateEntity is a Querydsl query type for VersionUpdateEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVersionUpdateEntity extends EntityPathBase<VersionUpdateEntity> {

    private static final long serialVersionUID = -1293804991L;

    public static final QVersionUpdateEntity versionUpdateEntity = new QVersionUpdateEntity("versionUpdateEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath appUpdateURL = createString("appUpdateURL");

    public final StringPath bundleIdentifier = createString("bundleIdentifier");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath currentVersion = createString("currentVersion");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath isMandatory = createString("isMandatory");

    public final StringPath isUpdate = createString("isUpdate");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath osType = createString("osType");

    public final StringPath updateVersion = createString("updateVersion");

    public QVersionUpdateEntity(String variable) {
        super(VersionUpdateEntity.class, forVariable(variable));
    }

    public QVersionUpdateEntity(Path<? extends VersionUpdateEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVersionUpdateEntity(PathMetadata metadata) {
        super(VersionUpdateEntity.class, metadata);
    }

}

