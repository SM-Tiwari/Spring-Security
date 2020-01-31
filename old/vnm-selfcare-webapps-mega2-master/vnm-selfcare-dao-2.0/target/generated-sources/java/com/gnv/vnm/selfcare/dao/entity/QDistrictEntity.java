package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDistrictEntity is a Querydsl query type for DistrictEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDistrictEntity extends EntityPathBase<DistrictEntity> {

    private static final long serialVersionUID = -132337740L;

    public static final QDistrictEntity districtEntity = new QDistrictEntity("districtEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath district = createString("district");

    public final NumberPath<Integer> districtId = createNumber("districtId", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> provinceId = createNumber("provinceId", Integer.class);

    public QDistrictEntity(String variable) {
        super(DistrictEntity.class, forVariable(variable));
    }

    public QDistrictEntity(Path<? extends DistrictEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDistrictEntity(PathMetadata metadata) {
        super(DistrictEntity.class, metadata);
    }

}

