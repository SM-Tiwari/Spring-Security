package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductChangeMappingEntity is a Querydsl query type for ProductChangeMappingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductChangeMappingEntity extends EntityPathBase<ProductChangeMappingEntity> {

    private static final long serialVersionUID = 506593589L;

    public static final QProductChangeMappingEntity productChangeMappingEntity = new QProductChangeMappingEntity("productChangeMappingEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath buyableProductCode = createString("buyableProductCode");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath productCode = createString("productCode");

    public QProductChangeMappingEntity(String variable) {
        super(ProductChangeMappingEntity.class, forVariable(variable));
    }

    public QProductChangeMappingEntity(Path<? extends ProductChangeMappingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductChangeMappingEntity(PathMetadata metadata) {
        super(ProductChangeMappingEntity.class, metadata);
    }

}

