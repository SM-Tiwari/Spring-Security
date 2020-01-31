insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 1);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 3);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 5);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 7);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 11);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 13);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 19);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 30, 1, 21);


select a.id from product a where a.prod_group_id in (select id from product_group where category_id = 6);

insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 92);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 86);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 99);


select a.id from product a where a.prod_group_id in (select id from product_group where category_id = 6) and a.is_visible = 1;

insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 53);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 8);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 7);

select product_id from promoted_product
where product_id in (select a.id from product a where a.prod_group_id in (select id from product_group where category_id = 6));


select a.id from product a where a.prod_group_id in (select id from product_group where category_id = 3) and a.is_visible = 1;

insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 67);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 74);
insert into PROMOTED_PRODUCT (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, start_date, end_date, status, product_id)
values (promoted_prod_seq.nextval, sysdate, 'system', sysdate, 'system', sysdate, sysdate + 90, 1, 10);
