-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '1000009', 2000, 1, (select pg.id from product_group PG where pg.code = 'VOICE01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Super Talk', (select p.id from product_v2 p where p.code = '1000009'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Super Talk', (select p.id from product_v2 p where p.code = '1000009' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Super Talk', (select p.id from product_v2 p where p.code = '1000009'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Super Talk', (select p.id from product_v2 p where p.code = '1000009'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'Super Talk', (select p.id from product_v2 p where p.code = '1000009'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'Super Talk', (select p.id from product_v2 p where p.code = '1000009'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126907', 5000, 1, (select pg.id from product_group PG where pg.code = 'VOICE01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Maxi Talk', (select p.id from product_v2 p where p.code = '126907'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Maxi Talk', (select p.id from product_v2 p where p.code = '126907' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Voice Package Daily', (select p.id from product_v2 p where p.code = '126907'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Voice Package Daily', (select p.id from product_v2 p where p.code = '126907'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'Voice Package Daily', (select p.id from product_v2 p where p.code = '126907'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'Voice Package Daily', (select p.id from product_v2 p where p.code = '126907'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126917', 2500, 1, (select pg.id from product_group PG where pg.code = 'SMS01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Max SMS', (select p.id from product_v2 p where p.code = '126917'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Max SMS', (select p.id from product_v2 p where p.code = '126917' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'SMS Package Daily', (select p.id from product_v2 p where p.code = '126917'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'SMS Package Daily', (select p.id from product_v2 p where p.code = '126917'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'SMS Package Daily', (select p.id from product_v2 p where p.code = '126917'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'SMS Package Daily', (select p.id from product_v2 p where p.code = '126917'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '128101', 3000, 1, (select pg.id from product_group PG where pg.code = 'COMBO01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'U2 Package', (select p.id from product_v2 p where p.code = '128101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'U2 Package', (select p.id from product_v2 p where p.code = '128101' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'U2 Package', (select p.id from product_v2 p where p.code = '128101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'U2 Package', (select p.id from product_v2 p where p.code = '128101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'U2 Package', (select p.id from product_v2 p where p.code = '128101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'U2 Package', (select p.id from product_v2 p where p.code = '128101'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126301', 30000, 1, (select pg.id from product_group PG where pg.code = 'COMBO01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'KN5 Combo', (select p.id from product_v2 p where p.code = '126301'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'KN5 Combo', (select p.id from product_v2 p where p.code = '126301' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'KN5 Combo', (select p.id from product_v2 p where p.code = '126301'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'KN5 Combo', (select p.id from product_v2 p where p.code = '126301'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'KN5 Combo', (select p.id from product_v2 p where p.code = '126301'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'KN5 Combo', (select p.id from product_v2 p where p.code = '126301'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '125961', 2000, 1, (select pg.id from product_group PG where pg.code = 'COMBO01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Thach Sanh Student Daily', (select p.id from product_v2 p where p.code = '125961'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Thach Sanh Student Daily', (select p.id from product_v2 p where p.code = '125961' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Thach Sanh Student Daily', (select p.id from product_v2 p where p.code = '125961'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Thach Sanh Student Daily', (select p.id from product_v2 p where p.code = '125961'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'Thach Sanh Student Daily', (select p.id from product_v2 p where p.code = '125961'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'Thach Sanh Student Daily', (select p.id from product_v2 p where p.code = '125961'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '128752', 20000, 1, (select pg.id from product_group PG where pg.code = 'VOICE01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'PIZZA Voice Onnet Day pack', (select p.id from product_v2 p where p.code = '128752'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'PIZZA Voice Onnet Day pack', (select p.id from product_v2 p where p.code = '128752' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'PIZZA Voice Onnet Day pack', (select p.id from product_v2 p where p.code = '128752'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'PIZZA Voice Onnet Day pack', (select p.id from product_v2 p where p.code = '128752'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'PIZZA Voice Onnet Day pack', (select p.id from product_v2 p where p.code = '128752'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'PIZZA Voice Onnet Day pack', (select p.id from product_v2 p where p.code = '128752'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '128753', 15000, 1, (select pg.id from product_group PG where pg.code = 'VOICE01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'PIZZA Voice Onnet Night  pack', (select p.id from product_v2 p where p.code = '128753'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'PIZZA Voice Onnet Night  pack', (select p.id from product_v2 p where p.code = '128753' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'PIZZA Voice Onnet Night  pack', (select p.id from product_v2 p where p.code = '128753'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'PIZZA Voice Onnet Night  pack', (select p.id from product_v2 p where p.code = '128753'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'PIZZA Voice Onnet Night  pack', (select p.id from product_v2 p where p.code = '128753'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'PIZZA Voice Onnet Night  pack', (select p.id from product_v2 p where p.code = '128753'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '128754', 10000, 1, (select pg.id from product_group PG where pg.code = 'SMS01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'PIZZA Onnet SMS pack', (select p.id from product_v2 p where p.code = '128754'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'PIZZA Onnet SMS pack', (select p.id from product_v2 p where p.code = '128754' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'PIZZA Onnet SMS pack', (select p.id from product_v2 p where p.code = '128754'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'PIZZA Onnet SMS pack', (select p.id from product_v2 p where p.code = '128754'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'PIZZA Onnet SMS pack', (select p.id from product_v2 p where p.code = '128754'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'PIZZA Onnet SMS pack', (select p.id from product_v2 p where p.code = '128754'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '13992', 40000, 1, (select pg.id from product_group PG where pg.code = 'DATA01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'D40 Data Package', (select p.id from product_v2 p where p.code = '13992'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'D40 Data Package', (select p.id from product_v2 p where p.code = '13992' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'D40 Data Package', (select p.id from product_v2 p where p.code = '13992'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'D40 Data Package', (select p.id from product_v2 p where p.code = '13992'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'D40 Data Package', (select p.id from product_v2 p where p.code = '13992'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'D40 Data Package', (select p.id from product_v2 p where p.code = '13992'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '14222', 80000, 1, (select pg.id from product_group PG where pg.code = 'DATA01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'D80 Data Package', (select p.id from product_v2 p where p.code = '14222'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'D80 Data Package', (select p.id from product_v2 p where p.code = '14222' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'D80 Data Package', (select p.id from product_v2 p where p.code = '14222'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'D80 Data Package', (select p.id from product_v2 p where p.code = '14222'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'D80 Data Package', (select p.id from product_v2 p where p.code = '14222'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'D80 Data Package', (select p.id from product_v2 p where p.code = '14222'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '25101', 125000, 1, (select pg.id from product_group PG where pg.code = 'DATA01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'D125 Data Package', (select p.id from product_v2 p where p.code = '25101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'D125 Data Package', (select p.id from product_v2 p where p.code = '25101' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'D125 Data Package', (select p.id from product_v2 p where p.code = '25101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'D125 Data Package', (select p.id from product_v2 p where p.code = '25101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'D125 Data Package', (select p.id from product_v2 p where p.code = '25101'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'D125 Data Package', (select p.id from product_v2 p where p.code = '25101'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '125528', 3000, 1, (select pg.id from product_group PG where pg.code = 'DATA01'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'D3 Data Package', (select p.id from product_v2 p where p.code = '125528'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'D3 Data Package', (select p.id from product_v2 p where p.code = '125528' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'D3 Data Package', (select p.id from product_v2 p where p.code = '125528'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'D3 Data Package', (select p.id from product_v2 p where p.code = '125528'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'D3 Data Package', (select p.id from product_v2 p where p.code = '125528'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'D3 Data Package', (select p.id from product_v2 p where p.code = '125528'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '127895', 35000, 1, (select pg.id from product_group PG where pg.code = 'DATA02'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'M35 Data Package', (select p.id from product_v2 p where p.code = '127895'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'M35 Data Package', (select p.id from product_v2 p where p.code = '127895' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'M35 Data Package', (select p.id from product_v2 p where p.code = '127895'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'M35 Data Package', (select p.id from product_v2 p where p.code = '127895'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'M35 Data Package', (select p.id from product_v2 p where p.code = '127895'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'M35 Data Package', (select p.id from product_v2 p where p.code = '127895'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '127896', 50000, 1, (select pg.id from product_group PG where pg.code = 'DATA02'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'M50 Data Package', (select p.id from product_v2 p where p.code = '127896'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'M50 Data Package', (select p.id from product_v2 p where p.code = '127896' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'M50 Data Package', (select p.id from product_v2 p where p.code = '127896'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'M50 Data Package', (select p.id from product_v2 p where p.code = '127896'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'M50 Data Package', (select p.id from product_v2 p where p.code = '127896'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'M50 Data Package', (select p.id from product_v2 p where p.code = '127896'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '127897', 90000, 1, (select pg.id from product_group PG where pg.code = 'DATA02'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'M90 Data Package', (select p.id from product_v2 p where p.code = '127897'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'M90 Data Package', (select p.id from product_v2 p where p.code = '127897' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'M90 Data Package', (select p.id from product_v2 p where p.code = '127897'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'M90 Data Package', (select p.id from product_v2 p where p.code = '127897'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'M90 Data Package', (select p.id from product_v2 p where p.code = '127897'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'M90 Data Package', (select p.id from product_v2 p where p.code = '127897'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126141', 15000, 1, (select pg.id from product_group PG where pg.code = 'DATA03'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'F15 Data Package', (select p.id from product_v2 p where p.code = '126141'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'F15 Data Package', (select p.id from product_v2 p where p.code = '126141' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'F15 Data Package', (select p.id from product_v2 p where p.code = '126141'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'F15 Data Package', (select p.id from product_v2 p where p.code = '126141'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'F15 Data Package', (select p.id from product_v2 p where p.code = '126141'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'F15 Data Package', (select p.id from product_v2 p where p.code = '126141'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126192', 50000, 1, (select pg.id from product_group PG where pg.code = 'DATA03'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'F50 Data Package', (select p.id from product_v2 p where p.code = '126192'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'F50 Data Package', (select p.id from product_v2 p where p.code = '126192' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'F50 Data Package', (select p.id from product_v2 p where p.code = '126192'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'F50 Data Package', (select p.id from product_v2 p where p.code = '126192'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'F50 Data Package', (select p.id from product_v2 p where p.code = '126192'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'F50 Data Package', (select p.id from product_v2 p where p.code = '126192'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126246', 90000, 1, (select pg.id from product_group PG where pg.code = 'DATA03'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'F90 Data Package', (select p.id from product_v2 p where p.code = '126246'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'F90 Data Package', (select p.id from product_v2 p where p.code = '126246' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'F90 Data Package', (select p.id from product_v2 p where p.code = '126246'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'F90 Data Package', (select p.id from product_v2 p where p.code = '126246'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'F90 Data Package', (select p.id from product_v2 p where p.code = '126246'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'F90 Data Package', (select p.id from product_v2 p where p.code = '126246'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '126441', 10000, 1, (select pg.id from product_group PG where pg.code = 'DATA04'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'E10 Data Package', (select p.id from product_v2 p where p.code = '126441'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'E10 Data Package', (select p.id from product_v2 p where p.code = '126441' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'E10 Data Package', (select p.id from product_v2 p where p.code = '126441'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'E10 Data Package', (select p.id from product_v2 p where p.code = '126441'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'E10 Data Package', (select p.id from product_v2 p where p.code = '126441'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'E10 Data Package', (select p.id from product_v2 p where p.code = '126441'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '128070', 20000, 1, (select pg.id from product_group PG where pg.code = 'DATA04'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'E20 Data Package', (select p.id from product_v2 p where p.code = '128070'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'E20 Data Package', (select p.id from product_v2 p where p.code = '128070' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'E20 Data Package', (select p.id from product_v2 p where p.code = '128070'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'E20 Data Package', (select p.id from product_v2 p where p.code = '128070'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'E20 Data Package', (select p.id from product_v2 p where p.code = '128070'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'E20 Data Package', (select p.id from product_v2 p where p.code = '128070'));

-- product
insert into product_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, price, status, prod_group_id)
values(product_v2_seq.nextval, sysdate, 'system', sysdate, 'system', '128071', 30000, 1, (select pg.id from product_group PG where pg.code = 'DATA04'));
-- product metadata
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'E30 Data Package', (select p.id from product_v2 p where p.code = '128071'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'E30 Data Package', (select p.id from product_v2 p where p.code = '128071' ));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'E30 Data Package', (select p.id from product_v2 p where p.code = '128071'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'E30 Data Package', (select p.id from product_v2 p where p.code = '128071'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_EN', 'E30 Data Package', (select p.id from product_v2 p where p.code = '128071'));
insert into product_metadata_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_id)
values(product_md_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DETAILS_VI', 'E30 Data Package', (select p.id from product_v2 p where p.code = '128071'));

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '125528'), '1GB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '127880'), '2GB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '127881'), '4GB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '127882'), '6GB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '127883'), '10GB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '127884'), '20GB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '126465'), 'Unlimited');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '126441'), '400MB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
    values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '128070'), '800MB');

insert into product_metadata(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, name, product_id, value)
        values(product_md_seq.nextval, sysdate, 'system', 'system', sysdate, 'QUOTA', (select id from product where code = '128071'), '1.6GB');


update product set default_title = 'D3' where code = '125528';
update product set default_title = 'M40' where code = '127880';
update product set default_title = 'M70' where code = '127881';
update product set default_title = 'M90' where code = '127882';
update product set default_title = 'M125' where code = '127883';
update product set default_title = 'M200' where code = '127884';
update product set default_title = 'Facebook' where code = '126465';
update product set default_title = 'E10' where code = '126441';
update product set default_title = 'E20' where code = '128070';
update product set default_title = 'E30' where code = '128071';

update product set default_title = 'MOOV_D' where code = '128241';
update product set default_title = 'MOOV_W' where code = '128242';
update product set default_title = 'MOOV_M' where code = '128243';
update product set default_title = 'MOOV_PZAC' where code = '128436';
update product set default_title = 'MOOV_PZAR' where code = '128599';
update product set default_title = 'MOOV_DATA' where code = '128621';
update product set default_title = 'MOOV_7' where code = '129561';
update product set default_title = 'VOICEMAIL' where code = '1000007';
update product set default_title = 'CRBT' where code = '1000010';
update product set default_title = 'MCA' where code = '20000120';
update product set default_title = 'MCAB' where code = '20000140';
update product set default_title = 'VOICEIM' where code = '20000221';
update product set default_title = 'CBS' where code = '20000223';
update product set default_title = 'CBSVIP' where code = '20000224';
update product set default_title = 'AUTO_SMS' where code = '20000263';

update product set default_title = 'MAXITALK' where code = '126873';
update product set default_title = 'Super Talk' where code = '1000009';
update product set default_title = 'MAXSMS' where code = '126917';


insert into product_purchase_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, product_code, buyable_product_code)
values (ppm_seq.nextval, sysdate, 'system', sysdate, 'system', '127880', '127881');
insert into product_purchase_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, product_code, buyable_product_code)
values (ppm_seq.nextval, sysdate, 'system', sysdate, 'system', '127880', '127882');
insert into product_purchase_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, product_code, buyable_product_code)
values (ppm_seq.nextval, sysdate, 'system', sysdate, 'system', '127880', '127884');

--hidden products (E* products)
insert into hidden_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, product_id)
values(hidden_prod_seq.nextval, sysdate, 'system', 'system', sysdate, 54);
insert into hidden_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, product_id)
values(hidden_prod_seq.nextval, sysdate, 'system', 'system', sysdate, 55);
insert into hidden_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, product_id)
values(hidden_prod_seq.nextval, sysdate, 'system', 'system', sysdate, 56);


--addon packages

alter table product add (bal_disp_opt number(10,0) default 0, DASHBOARD_VISIBLE number(10,0) default 1, QUOTA varchar2(255));

insert into product_group(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, description_en, description_vi, is_visible, category_id)
values(pgroup_seq.nextval, sysdate, 'system', sysdate, 'system', 'ADD_ON', 'ADD_ON','ADD_ON', 0, (select id from product_category where code = 'DATA') );

--UnlimitM
insert into product(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, ext_code, ext_product_name, name_en, name_vi,
price, status, is_visible, bal_disp_opt, DASHBOARD_VISIBLE, prod_group_id)
values(product_seq.nextval, sysdate, 'system', sysdate, 'system', 'UnlimitM', 'UnlimitM', 'UnlimitM', 'UnlimitM', 'Dữ liệu không giới hạn',
0, 1, 1, 1, 0, (select pg.id from product_group PG where pg.code = 'ADD_ON'));


--GAPIT30
insert into product(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, ext_code, ext_product_name, name_en, name_vi,
price, status, is_visible, bal_disp_opt, DASHBOARD_VISIBLE, prod_group_id)
values(product_seq.nextval, sysdate, 'system', sysdate, 'system', 'GAPIT30', 'GAPIT30', 'GAPIT30', 'GAPIT30', 'GAPIT30',
0, 1, 1, 1, 0, (select pg.id from product_group PG where pg.code = 'ADD_ON'));

update product set  DASHBOARD_VISIBLE = 1 where code != 'UnlimitM' and code != 'GAPIT30'
and prod_group_id in (select id from product_group where code like 'DATA%');
