package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductMetaDataEntity is a Querydsl query type for ProductMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductMetaDataEntity extends EntityPathBase<ProductMetaDataEntity> {

    private static final long serialVersionUID = 2106349278L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductMetaDataEntity productMetaDataEntity = new QProductMetaDataEntity("productMetaDataEntity");

    public final QMetaDataEntity _super = new QMetaDataEntity(this);

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

    protected QProductEntity product;

    //inherited
    public final StringPath value = _super.value;

    public QProductMetaDataEntity(String variable) {
        this(ProductMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QProductMetaDataEntity(Path<? extends ProductMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(ProductMetaDataEntity.class, metadata, inits);
    }

    public QProductMetaDataEntity(Class<? extends ProductMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
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

