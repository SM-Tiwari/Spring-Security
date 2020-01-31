insert into content_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values(content_catv2_seq.nextval, sysdate, 'system', sysdate, 'system', 'MUSIC');

insert into content_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values(content_catv2_seq.nextval, sysdate, 'system', sysdate, 'system', 'MOVIE');

insert into content_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values(content_catv2_seq.nextval, sysdate, 'system', sysdate, 'system', 'GAMES');

insert into content_category_v2(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code)
values(content_catv2_seq.nextval, sysdate, 'system', sysdate, 'system', 'APPS');

--music
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Music', 0, (select id from content_category_v2 where code = 'MUSIC'));
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Nhạc', 0, (select id from content_category_v2 where code = 'MUSIC'));

--movie
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Movie', 1, (select id from content_category_v2 where code = 'MOVIE'));
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Phim', 1, (select id from content_category_v2 where code = 'MOVIE'));

--games
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Games', 2, (select id from content_category_v2 where code = 'GAMES'));
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Trò chơi', 2, (select id from content_category_v2 where code = 'GAMES'));

--apps
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Apps', 3, (select id from content_category_v2 where code = 'APPS'));
insert into content_cat_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, display_order, content_cat_id)
values(content_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Apps', 3, (select id from content_category_v2 where code = 'APPS'));
