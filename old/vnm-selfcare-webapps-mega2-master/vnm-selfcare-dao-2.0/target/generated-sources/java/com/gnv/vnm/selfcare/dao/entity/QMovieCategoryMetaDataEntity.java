package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovieCategoryMetaDataEntity is a Querydsl query type for MovieCategoryMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMovieCategoryMetaDataEntity extends EntityPathBase<MovieCategoryMetaDataEntity> {

    private static final long serialVersionUID = -1092405699L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMovieCategoryMetaDataEntity movieCategoryMetaDataEntity = new QMovieCategoryMetaDataEntity("movieCategoryMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

    protected QMovieCategoryEntity category;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final NumberPath<Integer> displayOrder = _super.displayOrder;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath value = _super.value;

    public QMovieCategoryMetaDataEntity(String variable) {
        this(MovieCategoryMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QMovieCategoryMetaDataEntity(Path<? extends MovieCategoryMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMovieCategoryMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMovieCategoryMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(MovieCategoryMetaDataEntity.class, metadata, inits);
    }

    public QMovieCategoryMetaDataEntity(Class<? extends MovieCategoryMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QMovieCategoryEntity(forProperty("category")) : null;
    }

    public QMovieCategoryEntity category() {
        if (category == null) {
            category = new QMovieCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

