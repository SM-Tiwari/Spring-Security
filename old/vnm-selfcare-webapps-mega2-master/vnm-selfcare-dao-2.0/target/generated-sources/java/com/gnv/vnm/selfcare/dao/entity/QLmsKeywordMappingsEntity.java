package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLmsKeywordMappingsEntity is a Querydsl query type for LmsKeywordMappingsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLmsKeywordMappingsEntity extends EntityPathBase<LmsKeywordMappingsEntity> {

    private static final long serialVersionUID = 1323326178L;

    public static final QLmsKeywordMappingsEntity lmsKeywordMappingsEntity = new QLmsKeywordMappingsEntity("lmsKeywordMappingsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath keyword = createString("keyword");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> unitAmount = createNumber("unitAmount", Integer.class);

    public QLmsKeywordMappingsEntity(String variable) {
        super(LmsKeywordMappingsEntity.class, forVariable(variable));
    }

    public QLmsKeywordMappingsEntity(Path<? extends LmsKeywordMappingsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLmsKeywordMappingsEntity(PathMetadata metadata) {
        super(LmsKeywordMappingsEntity.class, metadata);
    }

}

