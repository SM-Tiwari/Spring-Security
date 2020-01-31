package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLmsItemMappingsEntity is a Querydsl query type for LmsItemMappingsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLmsItemMappingsEntity extends EntityPathBase<LmsItemMappingsEntity> {

    private static final long serialVersionUID = 1714134602L;

    public static final QLmsItemMappingsEntity lmsItemMappingsEntity = new QLmsItemMappingsEntity("lmsItemMappingsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath displayNameEN = createString("displayNameEN");

    public final StringPath displayNameVI = createString("displayNameVI");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath keyword = createString("keyword");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final StringPath monsterImage = createString("monsterImage");

    public final NumberPath<Integer> monsterWeight = createNumber("monsterWeight", Integer.class);

    public final StringPath productName = createString("productName");

    public QLmsItemMappingsEntity(String variable) {
        super(LmsItemMappingsEntity.class, forVariable(variable));
    }

    public QLmsItemMappingsEntity(Path<? extends LmsItemMappingsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLmsItemMappingsEntity(PathMetadata metadata) {
        super(LmsItemMappingsEntity.class, metadata);
    }

}

