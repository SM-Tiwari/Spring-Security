package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppsCategoryEntity is a Querydsl query type for AppsCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppsCategoryEntity extends EntityPathBase<AppsCategoryEntity> {

    private static final long serialVersionUID = 806863542L;

    public static final QAppsCategoryEntity appsCategoryEntity = new QAppsCategoryEntity("appsCategoryEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath code = createString("code");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> displayOrder = createNumber("displayOrder", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final SetPath<AppsCategoryMetaDataEntity, QAppsCategoryMetaDataEntity> metadata = this.<AppsCategoryMetaDataEntity, QAppsCategoryMetaDataEntity>createSet("metadata", AppsCategoryMetaDataEntity.class, QAppsCategoryMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final NumberPath<Integer> parentCategoryId = createNumber("parentCategoryId", Integer.class);

    public QAppsCategoryEntity(String variable) {
        super(AppsCategoryEntity.class, forVariable(variable));
    }

    public QAppsCategoryEntity(Path<? extends AppsCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppsCategoryEntity(PathMetadata metadata) {
        super(AppsCategoryEntity.class, metadata);
    }

}

