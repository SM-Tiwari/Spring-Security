-- default product categories
insert into product_category values(prod_cat_seq.nextval, sysdate, 'system', 'system', sysdate, 'Voice Product Package', 'VOICE');
insert into product_category values(prod_cat_seq.nextval, sysdate, 'system', 'system', sysdate, 'SMS Product Package', 'SMS');
insert into product_category values(prod_cat_seq.nextval, sysdate, 'system', 'system', sysdate, 'Data Product Package', 'DATA');
insert into product_category values(prod_cat_seq.nextval, sysdate, 'system', 'system', sysdate, 'Combo Product Package', 'COMBO');

-- startup products
insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 1, '126907', 'Voice Package Daily', 'Maxi Talk', 'Maxi Talk', 5000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 2, '126917', 'SMS Package Daily', 'Max SMS', 'Max SMS', 2500, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '125528', 'D3 Data Package', 'D3 Data Package', 'D3 Data Package', 3000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '13392', 'D40 Data Package', 'D40 Data Package', 'D40 Data Package', 40000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '127895', 'M35 Data Package', 'M35 Data Package', 'M35 Data Package', 35000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '127896', 'M50 Data Package', 'M50 Data Package', 'M50 Data Package', 50000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '127897', 'M90 Data Package', 'M90 Data Package', 'M90 Data Package', 90000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '126441', 'E10 Data Package', 'E10 Data Package', 'E10 Data Package', 10000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '128070', 'E20 Data Package', 'E20 Data Package', 'E20 Data Package', 20000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '128071', 'E30 Data Package', 'E30 Data Package', 'E30 Data Package', 30000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 4, '128101', 'U2 package', 'U2 package', 'U2 package', 3000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 4, '126301', 'KN5 Combo', 'KN5 Combo', 'KN5 Combo', 30000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 1, '20000100', 'SMS roaming', 'SMS roaming', 'SMS roaming', 50000, 1, sysdate-30, sysdate+30);

insert into product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, category_id, code, description, display_name, name, price, status, valid_from_date, valid_to_date)
values(product_seq.nextval, sysdate, 'system', 'system', sysdate, 3, '1000006', 'International Prepaid (Voice & SMS) Roaming', 'International Prepaid (Voice & SMS) Roaming', 'International Prepaid (Voice & SMS) Roaming', 200000, 1, sysdate-30, sysdate+30);

-- promoted products for displaying banner
insert into promoted_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, product_id, status) 
	values(promoted_prod_seq.nextval, sysdate, 'system', 'system', sysdate, sysdate-30, sysdate + 30, 1, 1);
insert into promoted_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, product_id, status) 
  values(promoted_prod_seq.nextval, sysdate, 'system', 'system', sysdate, sysdate-30, sysdate + 30, 2, 1);
insert into promoted_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, product_id, status) 
  values(promoted_prod_seq.nextval, sysdate, 'system', 'system', sysdate, sysdate-30, sysdate + 30, 5, 1);
insert into promoted_product(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, product_id, status) 
  values(promoted_prod_seq.nextval, sysdate, 'system', 'system', sysdate, sysdate-30, sysdate + 30, 12, 1);

-- image server config
insert into app_config values(app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'imageserver.url', 'http://localhost:8181/selfcareimgsvr');
insert into app_config values(app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'imageserver.imgdir', '/images');
insert into app_config values(app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'imageserver.uploaddir', '/app/apache-tomcat-api/webapps/selfcareimgsvr/images');


