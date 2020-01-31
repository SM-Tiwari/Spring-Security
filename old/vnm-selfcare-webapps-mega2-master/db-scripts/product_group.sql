insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE01', 1);

insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS01', 2);

insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA01', 3);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA02', 3);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA03', 3);

insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'COMBO01', 4);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'COMBO02', 4);

insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS01', 5);

insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS01', 6);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS02', 6);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS03', 6);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS04', 6);
insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, category_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS05', 6);


insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Super Talk', (select pg.id from product_group PG where pg.code = 'VOICE01') );
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Super Talk', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Super Talk', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Super Talk', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'VOICE01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'VOICE01'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'SMS Package', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'SMS Package', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'SMS Package', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'SMS Package', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'SMS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'SMS01'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Data Package 1', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Data Package 1', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Data Package 1', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Data Package 1', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'DATA01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'DATA01'));


insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Data Package 2', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Data Package 2', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Data Package 2', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Data Package 2', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'DATA02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'DATA02'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Data Package 3', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Data Package 3', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Data Package 3', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Data Package 3', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'DATA03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'DATA03'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Combo Package 1', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Combo Package 1', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Combo Package 1', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Combo Package 1', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'COMBO01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'COMBO01'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Combo Package 2', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Combo Package 2', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Combo Package 2', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Combo Package 2', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'COMBO02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'COMBO02'));


insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'VAS Package 01', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'VAS Package 01', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'VAS Package 01', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'VAS Package 01', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'VAS01'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'VAS01'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'VAS Package 02', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'VAS Package 02', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'VAS Package 02', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'VAS Package 02', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'VAS02'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'VAS02'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'VAS Package 03', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'VAS Package 03', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'VAS Package 03', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'VAS Package 03', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'VAS03'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'VAS03'));


insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'VAS Package 04', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'VAS Package 04', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'VAS Package 04', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'VAS Package 04', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'VAS04'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'VAS04'));

insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'VAS Package 05', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'VAS Package 05', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'VAS Package 05', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'VAS Package 05', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', (select pg.id from product_group PG where pg.code = 'VAS05'));
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', (select pg.id from product_group PG where pg.code = 'VAS05'));


insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_SMALL', '/prd/PizzaSim_small.jpg', 41);
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_MEDIUM', '/prd/PizzaSim_medium.jpg', 41);
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_LARGE', '/prd/PizzaSim_large.jpg', 41);
insert into product_group_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_group_id)
values(pgroup_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'IMAGE_XLARGE', '/prd/PizzaSim_xlarge.jpg', 41);
