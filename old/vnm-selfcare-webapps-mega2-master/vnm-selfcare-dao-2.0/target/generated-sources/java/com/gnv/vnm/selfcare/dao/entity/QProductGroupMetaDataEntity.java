package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductGroupMetaDataEntity is a Querydsl query type for ProductGroupMetaDataEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductGroupMetaDataEntity extends EntityPathBase<ProductGroupMetaDataEntity> {

    private static final long serialVersionUID = 1525780773L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductGroupMetaDataEntity productGroupMetaDataEntity = new QProductGroupMetaDataEntity("productGroupMetaDataEntity");

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

    protected QProductGroupEntity productGroup;

    //inherited
    public final StringPath value = _super.value;

    public QProductGroupMetaDataEntity(String variable) {
        this(ProductGroupMetaDataEntity.class, forVariable(variable), INITS);
    }

    public QProductGroupMetaDataEntity(Path<? extends ProductGroupMetaDataEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductGroupMetaDataEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductGroupMetaDataEntity(PathMetadata metadata, PathInits inits) {
        this(ProductGroupMetaDataEntity.class, metadata, inits);
    }

    public QProductGroupMetaDataEntity(Class<? extends ProductGroupMetaDataEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productGroup = inits.isInitialized("productGroup") ? new QProductGroupEntity(forProperty("productGroup"), inits.get("productGroup")) : null;
    }

    public QProductGroupEntity productGroup() {
        if (productGroup == null) {
            productGroup = new QProductGroupEntity(forProperty("productGroup"));
        }
        return productGroup;
    }

}

