package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameMetaDataEntity is a Querydsl query type for GameMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameMetaDataEntity extends EntityPathBase<GameMetaDataEntity> {

    private static final long serialVersionUID = 341906887L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameMetaDataEntity gameMetaDataEntity = new QGameMetaDataEntity("gameMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final NumberPath<Integer> displayOrder = _super.displayOrder;

    protected QGameEntity game;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final StringPath value = _super.value;

    public QGameMetaDataEntity(String variable) {
        this(GameMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QGameMetaDataEntity(Path<? extends GameMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(GameMetaDataEntity.class, metadata, inits);
    }

    public QGameMetaDataEntity(Class<? extends GameMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new QGameEntity(forProperty("game"), inits.get("game")) : null;
    }

    public QGameEntity game() {
        if (game == null) {
            game = new QGameEntity(forProperty("game"));
        }
        return game;
    }

}

