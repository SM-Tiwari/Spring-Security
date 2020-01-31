insert into movie_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(movie_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'ACTION', null);
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Action', (select id from movie_category where code = 'ACTION'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Action', (select id from movie_category where code = 'ACTION'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Action Movie', (select id from movie_category where code = 'ACTION'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Action Movie', (select id from movie_category where code = 'ACTION'));

insert into movie_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(movie_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'HORROR', null);
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Horror', (select id from movie_category where code = 'HORROR'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Horror', (select id from movie_category where code = 'HORROR'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Horror Movie', (select id from movie_category where code = 'HORROR'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Horror Movie', (select id from movie_category where code = 'HORROR'));

insert into movie_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(movie_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'HOT', null);
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Hot', (select id from movie_category where code = 'HOT'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Hot', (select id from movie_category where code = 'HOT'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Hot Movie', (select id from movie_category where code = 'HOT'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Hot Movie', (select id from movie_category where code = 'HOT'));

insert into movie_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(movie_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'ANIMATION', null);
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Animation', (select id from movie_category where code = 'ANIMATION'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Animation', (select id from movie_category where code = 'ANIMATION'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Animation Movie', (select id from movie_category where code = 'ANIMATION'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Animation Movie', (select id from movie_category where code = 'ANIMATION'));

insert into movie_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(movie_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'DRAMA', null);
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Drama', (select id from movie_category where code = 'DRAMA'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Drama', (select id from movie_category where code = 'DRAMA'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Drama Movie', (select id from movie_category where code = 'DRAMA'));
insert into movie_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, movie_cat_id)
values(movie_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Drama Movie', (select id from movie_category where code = 'DRAMA'));


insert into music_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(music_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'LOVE_SONG', null);
insert into music_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, music_cat_id)
values(music_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Love Song', (select id from music_category where code = 'LOVE_SONG'));
insert into music_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, music_cat_id)
values(music_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Love Song', (select id from music_category where code = 'LOVE_SONG'));
insert into music_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, music_cat_id)
values(music_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Love Song', (select id from music_category where code = 'LOVE_SONG'));
insert into music_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, music_cat_id)
values(music_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Love Song', (select id from music_category where code = 'LOVE_SONG'));

insert into game_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(game_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'ACTION', null);
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Action', (select id from game_category where code = 'ACTION'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Action', (select id from game_category where code = 'ACTION'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Action Game', (select id from game_category where code = 'ACTION'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Action Game', (select id from game_category where code = 'ACTION'));

insert into game_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(game_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'PUZZLE', null);
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Puzzle', (select id from game_category where code = 'PUZZLE'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Puzzle', (select id from game_category where code = 'PUZZLE'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Puzzle Game', (select id from game_category where code = 'PUZZLE'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Puzzle Game', (select id from game_category where code = 'PUZZLE'));

insert into game_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(game_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'HOT', null);
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Hot', (select id from game_category where code = 'HOT'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Hot', (select id from game_category where code = 'HOT'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Hot Game', (select id from game_category where code = 'HOT'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Hot Game', (select id from game_category where code = 'HOT'));

insert into game_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(game_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'STRATEGY', null);
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Strategy', (select id from game_category where code = 'STRATEGY'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Strategy', (select id from game_category where code = 'STRATEGY'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Strategy Game', (select id from game_category where code = 'STRATEGY'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Strategy Game', (select id from game_category where code = 'STRATEGY'));

insert into game_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(game_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'RACE', null);
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Race', (select id from game_category where code = 'RACE'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Race', (select id from game_category where code = 'RACE'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Race Game', (select id from game_category where code = 'RACE'));
insert into game_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, game_cat_id)
values(game_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Race Game', (select id from game_category where code = 'RACE'));


insert into apps_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'HOT', null);
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Hot', (select id from apps_category where code = 'HOT'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Hot', (select id from apps_category where code = 'HOT'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Hot Apps', (select id from apps_category where code = 'HOT'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Hot Apps', (select id from apps_category where code = 'HOT'));

insert into apps_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(apps_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'MUSIC_AND_SOUND', null);
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Music and Sounds', (select id from apps_category where code = 'MUSIC_AND_SOUND'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Music and Sounds', (select id from apps_category where code = 'MUSIC_AND_SOUND'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Music and Sounds Apps', (select id from apps_category where code = 'MUSIC_AND_SOUND'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Music and Sounds Apps', (select id from apps_category where code = 'MUSIC_AND_SOUND'));

insert into apps_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(apps_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'PHOTOGRAPHY', null);
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Photography', (select id from apps_category where code = 'PHOTOGRAPHY'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Photography', (select id from apps_category where code = 'PHOTOGRAPHY'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Photography Apps', (select id from apps_category where code = 'PHOTOGRAPHY'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Photography Apps', (select id from apps_category where code = 'PHOTOGRAPHY'));

insert into apps_category(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, parent_cat_id)
values(apps_cat_seq.nextval, sysdate, 'system', sysdate, 'system', 'BOOKS', null);
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_EN', 'Books', (select id from apps_category where code = 'BOOKS'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'NAME_VI', 'Books', (select id from apps_category where code = 'BOOKS'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_EN', 'Books Apps', (select id from apps_category where code = 'BOOKS'));
insert into apps_category_metadata(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value, apps_cat_id)
values(apps_catmd_seq.nextval, sysdate, 'system', sysdate, 'system', 'DESCRIPTION_VI', 'Books Apps', (select id from apps_category where code = 'BOOKS'));
