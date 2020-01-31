package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSimOperatorEntity is a Querydsl query type for SimOperatorEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimOperatorEntity extends EntityPathBase<SimOperatorEntity> {

    private static final long serialVersionUID = -1593049893L;

    public static final QSimOperatorEntity simOperatorEntity = new QSimOperatorEntity("simOperatorEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> operatorId = createNumber("operatorId", Integer.class);

    public final StringPath operatorName = createString("operatorName");

    public final NumberPath<Integer> operatorStatus = createNumber("operatorStatus", Integer.class);

    public QSimOperatorEntity(String variable) {
        super(SimOperatorEntity.class, forVariable(variable));
    }

    public QSimOperatorEntity(Path<? extends SimOperatorEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimOperatorEntity(PathMetadata metadata) {
        super(SimOperatorEntity.class, metadata);
    }

}

