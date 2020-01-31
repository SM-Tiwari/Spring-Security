package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovieCategoryEntity is a Querydsl query type for MovieCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovieCategoryEntity extends EntityPathBase<MovieCategoryEntity> {

    private static final long serialVersionUID = 366783758L;

    public static final QMovieCategoryEntity movieCategoryEntity = new QMovieCategoryEntity("movieCategoryEntity");

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

    public final SetPath<MovieCategoryMetaDataEntity, QMovieCategoryMetaDataEntity> metadata = this.<MovieCategoryMetaDataEntity, QMovieCategoryMetaDataEntity>createSet("metadata", MovieCategoryMetaDataEntity.class, QMovieCategoryMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final NumberPath<Integer> parentCategoryId = createNumber("parentCategoryId", Integer.class);

    public QMovieCategoryEntity(String variable) {
        super(MovieCategoryEntity.class, forVariable(variable));
    }

    public QMovieCategoryEntity(Path<? extends MovieCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovieCategoryEntity(PathMetadata metadata) {
        super(MovieCategoryEntity.class, metadata);
    }

}

