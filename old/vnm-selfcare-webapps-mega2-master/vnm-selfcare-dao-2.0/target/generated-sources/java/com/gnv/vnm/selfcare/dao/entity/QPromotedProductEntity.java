package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPromotedProductEntity is a Querydsl query type for PromotedProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPromotedProductEntity extends EntityPathBase<PromotedProductEntity> {

    private static final long serialVersionUID = 779871083L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPromotedProductEntity promotedProductEntity = new QPromotedProductEntity("promotedProductEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

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

    protected QProductEntity product;

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QPromotedProductEntity(String variable) {
        this(PromotedProductEntity.class, forVariable(variable), INITS);
    }

    public QPromotedProductEntity(Path<? extends PromotedProductEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPromotedProductEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPromotedProductEntity(PathMetadata metadata, PathInits inits) {
        this(PromotedProductEntity.class, metadata, inits);
    }

    public QPromotedProductEntity(Class<? extends PromotedProductEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProductEntity(forProperty("product"), inits.get("product")) : null;
    }

    public QProductEntity product() {
        if (product == null) {
            product = new QProductEntity(forProperty("product"));
        }
        return product;
    }

}

