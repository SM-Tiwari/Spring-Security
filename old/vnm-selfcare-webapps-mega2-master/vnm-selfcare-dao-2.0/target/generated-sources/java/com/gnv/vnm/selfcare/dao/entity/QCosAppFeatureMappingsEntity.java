package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCosAppFeatureMappingsEntity is a Querydsl query type for CosAppFeatureMappingsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCosAppFeatureMappingsEntity extends EntityPathBase<CosAppFeatureMappingsEntity> {

    private static final long serialVersionUID = 1341180289L;

    public static final QCosAppFeatureMappingsEntity cosAppFeatureMappingsEntity = new QCosAppFeatureMappingsEntity("cosAppFeatureMappingsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath cosName = createString("cosName");

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath disabledFeatureName = createString("disabledFeatureName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public QCosAppFeatureMappingsEntity(String variable) {
        super(CosAppFeatureMappingsEntity.class, forVariable(variable));
    }

    public QCosAppFeatureMappingsEntity(Path<? extends CosAppFeatureMappingsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCosAppFeatureMappingsEntity(PathMetadata metadata) {
        super(CosAppFeatureMappingsEntity.class, metadata);
    }

}

