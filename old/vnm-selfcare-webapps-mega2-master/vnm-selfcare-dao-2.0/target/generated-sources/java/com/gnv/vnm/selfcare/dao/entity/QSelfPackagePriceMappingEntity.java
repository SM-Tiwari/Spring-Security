package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelfPackagePriceMappingEntity is a Querydsl query type for SelfPackagePriceMappingEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSelfPackagePriceMappingEntity extends EntityPathBase<SelfPackagePriceMappingEntity> {

    private static final long serialVersionUID = 1126265727L;

    public static final QSelfPackagePriceMappingEntity selfPackagePriceMappingEntity = new QSelfPackagePriceMappingEntity("selfPackagePriceMappingEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> cycle = createNumber("cycle", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> maxAmount = createNumber("maxAmount", Integer.class);

    public final NumberPath<Integer> minAmount = createNumber("minAmount", Integer.class);

    public final NumberPath<java.math.BigDecimal> normalPrice = createNumber("normalPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final StringPath type = createString("type");

    public QSelfPackagePriceMappingEntity(String variable) {
        super(SelfPackagePriceMappingEntity.class, forVariable(variable));
    }

    public QSelfPackagePriceMappingEntity(Path<? extends SelfPackagePriceMappingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelfPackagePriceMappingEntity(PathMetadata metadata) {
        super(SelfPackagePriceMappingEntity.class, metadata);
    }

}

