package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameCategoryMetaDataEntity is a Querydsl query type for GameCategoryMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameCategoryMetaDataEntity extends EntityPathBase<GameCategoryMetaDataEntity> {

    private static final long serialVersionUID = -1582660251L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameCategoryMetaDataEntity gameCategoryMetaDataEntity = new QGameCategoryMetaDataEntity("gameCategoryMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

    protected QGameCategoryEntity category;

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

    public QGameCategoryMetaDataEntity(String variable) {
        this(GameCategoryMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QGameCategoryMetaDataEntity(Path<? extends GameCategoryMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameCategoryMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameCategoryMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(GameCategoryMetaDataEntity.class, metadata, inits);
    }

    public QGameCategoryMetaDataEntity(Class<? extends GameCategoryMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QGameCategoryEntity(forProperty("category")) : null;
    }

    public QGameCategoryEntity category() {
        if (category == null) {
            category = new QGameCategoryEntity(forProperty("category"));
        }
        return category;
    }

}

