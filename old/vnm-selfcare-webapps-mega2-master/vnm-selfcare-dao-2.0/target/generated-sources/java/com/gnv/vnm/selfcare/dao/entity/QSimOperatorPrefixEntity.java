package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSimOperatorPrefixEntity is a Querydsl query type for SimOperatorPrefixEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimOperatorPrefixEntity extends EntityPathBase<SimOperatorPrefixEntity> {

    private static final long serialVersionUID = -1147319283L;

    public static final QSimOperatorPrefixEntity simOperatorPrefixEntity = new QSimOperatorPrefixEntity("simOperatorPrefixEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath newPrefix = createString("newPrefix");

    public final StringPath oldPrefix = createString("oldPrefix");

    public final NumberPath<Integer> operatorId = createNumber("operatorId", Integer.class);

    public final NumberPath<Integer> operatorPrefixStatus = createNumber("operatorPrefixStatus", Integer.class);

    public final StringPath simOperatorName = createString("simOperatorName");

    public QSimOperatorPrefixEntity(String variable) {
        super(SimOperatorPrefixEntity.class, forVariable(variable));
    }

    public QSimOperatorPrefixEntity(Path<? extends SimOperatorPrefixEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimOperatorPrefixEntity(PathMetadata metadata) {
        super(SimOperatorPrefixEntity.class, metadata);
    }

}

