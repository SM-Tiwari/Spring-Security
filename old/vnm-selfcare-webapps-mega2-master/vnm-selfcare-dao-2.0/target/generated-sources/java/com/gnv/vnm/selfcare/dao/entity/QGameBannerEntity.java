package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameBannerEntity is a Querydsl query type for GameBannerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameBannerEntity extends EntityPathBase<GameBannerEntity> {

    private static final long serialVersionUID = 1637053732L;

    public static final QGameBannerEntity gameBannerEntity = new QGameBannerEntity("gameBannerEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Integer> gameId = createNumber("gameId", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QGameBannerEntity(String variable) {
        super(GameBannerEntity.class, forVariable(variable));
    }

    public QGameBannerEntity(Path<? extends GameBannerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameBannerEntity(PathMetadata metadata) {
        super(GameBannerEntity.class, metadata);
    }

}

