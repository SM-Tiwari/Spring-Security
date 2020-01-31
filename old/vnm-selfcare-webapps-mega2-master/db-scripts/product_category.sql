
insert into product_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values (pcat_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE');
insert into product_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values (pcat_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS');
insert into product_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values (pcat_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA');
insert into product_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values (pcat_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'COMBO');
insert into product_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values (pcat_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'INT_ROAMING');

insert into product_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values (pcat_v2_seq.nextval, sysdate, 'system', sysdate, 'system', 'VAS');


/*
	NAME_,
	DESCRIPTION_,
	ICON_SMALL,
	ICON_MEDIUM,
	ICON_LARGE,
	ICON_XLARGE,
	IMAGE_SMALL,
	IMAGE_MEDIUM,
	IMAGE_LARGE,
	IMAGE_XLARGE
*/

-- product category metadata -- name and description
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Voice', 1);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Gọi', 1);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'SMS', 2);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Tin nhắn', 2);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Data', 3);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Dữ liệu', 3);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Combo', 4);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Combo', 4);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Roaming', 5);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Roaming', 5);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'VAS', 6);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'VAS', 6);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Voice', 1);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Gọi', 1);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'SMS', 2);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Tin nhắn', 2);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Data', 3);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Dữ liệu', 3);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Combo', 4);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Combo', 4);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'International Roaming', 5);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'International Roaming', 5);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Value Added Services', 6);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Value Added Services', 6);

-- product category metadata -- icons
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/Phone_Filled_50.png', 1);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/Phone_Filled_100.png', 1);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/Phone_Filled_100.png', 1);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/Message_50.png', 2);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/Message_100.png', 2);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/Message_100.png', 2);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/Email_Filled_50.png', 3);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/Email_Filled_100.png', 3);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/Email_Filled_100.png', 3);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/GiftBW_50.png', 4);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/GiftBW_100.png', 4);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/GiftBW_100.png', 4);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/Globe_50.png', 5);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/Globe_100.png', 5);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/Globe_100.png', 5);

insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_SMALL', '/icons/Paper_Plane1_50.png', 6);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_MEDIUM', '/icons/Paper_Plane1_100.png', 6);
insert into product_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, product_cat_id)
values(prodcat_md_seq.nextval, sysdate, 'system', sysdate, 'system', 'ICON_LARGE', '/icons/Paper_Plane1_100.png', 6);
