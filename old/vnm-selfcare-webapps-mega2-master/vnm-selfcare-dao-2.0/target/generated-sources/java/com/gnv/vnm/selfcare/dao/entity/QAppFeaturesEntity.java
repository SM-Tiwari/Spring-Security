package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppFeaturesEntity is a Querydsl query type for AppFeaturesEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppFeaturesEntity extends EntityPathBase<AppFeaturesEntity> {

    private static final long serialVersionUID = 462263678L;

    public static final QAppFeaturesEntity appFeaturesEntity = new QAppFeaturesEntity("appFeaturesEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath featureName = createString("featureName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> statusForAndroid = createNumber("statusForAndroid", Integer.class);

    public final NumberPath<Integer> statusForIos = createNumber("statusForIos", Integer.class);

    public QAppFeaturesEntity(String variable) {
        super(AppFeaturesEntity.class, forVariable(variable));
    }

    public QAppFeaturesEntity(Path<? extends AppFeaturesEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppFeaturesEntity(PathMetadata metadata) {
        super(AppFeaturesEntity.class, metadata);
    }

}

