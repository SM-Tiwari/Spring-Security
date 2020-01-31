package com.gnv.vnm.selfcare.dao.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFattyItemMappingsEntity is a Querydsl query type for FattyItemMappingsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFattyItemMappingsEntity extends EntityPathBase<FattyItemMappingsEntity> {

    private static final long serialVersionUID = -1804850090L;

    public static final QFattyItemMappingsEntity fattyItemMappingsEntity = new QFattyItemMappingsEntity("fattyItemMappingsEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createTimestamp = _super.createTimestamp;

    public final StringPath displayNameEN = createString("displayNameEN");

    public final StringPath displayNameVI = createString("displayNameVI");

    public final NumberPath<Integer> fattyStatus = createNumber("fattyStatus", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath keyword = createString("keyword");

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedTime = _super.lastModifiedTime;

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final NumberPath<Integer> maxPoint = createNumber("maxPoint", Integer.class);

    public final StringPath messageEn = createString("messageEn");

    public final StringPath messageVi = createString("messageVi");

    public final NumberPath<Integer> minPoint = createNumber("minPoint", Integer.class);

    public final StringPath monsterImage = createString("monsterImage");

    public final NumberPath<Integer> monsterWeight = createNumber("monsterWeight", Integer.class);

    public final StringPath productName = createString("productName");

    public QFattyItemMappingsEntity(String variable) {
        super(FattyItemMappingsEntity.class, forVariable(variable));
    }

    public QFattyItemMappingsEntity(Path<? extends FattyItemMappingsEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFattyItemMappingsEntity(PathMetadata metadata) {
        super(FattyItemMappingsEntity.class, metadata);
    }

}

