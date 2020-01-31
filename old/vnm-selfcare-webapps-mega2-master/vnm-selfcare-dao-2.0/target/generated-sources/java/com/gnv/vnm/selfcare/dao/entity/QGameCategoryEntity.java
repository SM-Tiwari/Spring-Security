package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameCategoryEntity is a Querydsl query type for GameCategoryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameCategoryEntity extends EntityPathBase<GameCategoryEntity> {

    private static final long serialVersionUID = -2099665866L;

    public static final QGameCategoryEntity gameCategoryEntity = new QGameCategoryEntity("gameCategoryEntity");

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

    public final SetPath<GameCategoryMetaDataEntity, QGameCategoryMetaDataEntity> metadata = this.<GameCategoryMetaDataEntity, QGameCategoryMetaDataEntity>createSet("metadata", GameCategoryMetaDataEntity.class, QGameCategoryMetaDataEntity.class, PathInits.DIRECT2);

    public final StringPath nameEN = createString("nameEN");

    public final StringPath nameVI = createString("nameVI");

    public final NumberPath<Integer> parentCategoryId = createNumber("parentCategoryId", Integer.class);

    public QGameCategoryEntity(String variable) {
        super(GameCategoryEntity.class, forVariable(variable));
    }

    public QGameCategoryEntity(Path<? extends GameCategoryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameCategoryEntity(PathMetadata metadata) {
        super(GameCategoryEntity.class, metadata);
    }

}

