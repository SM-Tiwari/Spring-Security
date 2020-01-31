package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppsBannerEntity is a Querydsl query type for AppsBannerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppsBannerEntity extends EntityPathBase<AppsBannerEntity> {

    private static final long serialVersionUID = 214381476L;

    public static final QAppsBannerEntity appsBannerEntity = new QAppsBannerEntity("appsBannerEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> appsId = createNumber("appsId", Integer.class);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QAppsBannerEntity(String variable) {
        super(AppsBannerEntity.class, forVariable(variable));
    }

    public QAppsBannerEntity(Path<? extends AppsBannerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppsBannerEntity(PathMetadata metadata) {
        super(AppsBannerEntity.class, metadata);
    }

}

