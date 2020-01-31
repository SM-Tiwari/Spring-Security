--game content
insert into game(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp,
display_name_en, display_name_vi, file_size, notes_en, notes_vi, preview_url, price,
name_en, name_vi, description_en, description_vi, source_url, status, game_cat_id)
values(game_seq.nextval, 'GAME_001', sysdate, 'system', 'system', sysdate,
'Mario', 'Mario', 3300, 'Game for Android only', 'Trò chơi chỉ dành cho máy Android','http://d.clix.vn/gmobi/mario/Mario_10102014.apk', 10000,
'Mario', 'Mario', 'Rescue princess with Mario', 'Cùng Mario giải cứu công chúa.', 'http://d.clix.vn/gmobi/mario/Mario_10102014.apk', 1, 1);

insert into game(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp,
display_name_en, display_name_vi, file_size, notes_en, notes_vi, preview_url, price,
name_en, name_vi, description_en, description_vi, source_url, status, game_cat_id)
values(game_seq.nextval, 'GAME_002', sysdate, 'system', 'system', sysdate,
'Catch Word', 'Đuổi hình bắt chữ', 27000, 'Game for Android only', 'Trò chơi chỉ dành cho máy Android','http://d.clix.vn/gmobi/batchu/BatChu_v4.5.apk', 15000,
'Catch Word', 'Đuổi hình bắt chữ', 'Try to catch words base on images', 'Cùng chơi đuổi hình bắt chữ xem ai giải đố nhanh nhất nào!',
'http://d.clix.vn/gmobi/batchu/BatChu_v4.5.apk', 1, 2);

insert into game(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp,
display_name_en, display_name_vi, file_size, notes_en, notes_vi, preview_url, price,
name_en, name_vi, description_en, description_vi, source_url, status, game_cat_id)
values(game_seq.nextval, 'GAME_003', sysdate, 'system', 'system', sysdate,
'USA Block Craft Exploration 3D', 'Xây tháp 3D', 33600, 'Game for Android only', 'Trò chơi chỉ dành cho máy Android',
'http://vmgame.vn/upload/game/12053/GameFile/150338_1_usa_block_craft_exploration_3d.apk', 10000,
'USA Block Craft Exploration 3D', 'Xây tháp 3D', 'Let''s build big America cities!', 'Hãy cố gắng xây dựng các tòa tháp càng cao càng tốt!',
'http://vmgame.vn/upload/game/12053/GameFile/150338_1_usa_block_craft_exploration_3d.apk', 1, 2);

insert into game(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp,
display_name_en, display_name_vi, file_size, notes_en, notes_vi, preview_url, price,
name_en, name_vi, description_en, description_vi, source_url, status, game_cat_id)
values(game_seq.nextval, 'GAME_004', sysdate, 'system', 'system', sysdate,
'Heroes of Loot', 'Biệt đội anh hùng', 25300, ' Game for IOS only', ' Trò chơi chỉ dành cho Iphone, Ipad ',
'https://vmgame.vn/upload/game/11357/GameFile/154335_Heroes_of_Loot.ipa', 10000,
'Heroes of Loot', 'Biệt đội anh hùng', 'Try to survise with your heroes', 'Cùng biệt đội anh hùng sống sót vượt qua từng cửa ải.',
'https://vmgame.vn/upload/game/11357/GameFile/154335_Heroes_of_Loot.ipa', 1, 1);

--movie contents
insert into movie(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp, status,
  name_en, name_vi, display_name_en, display_name_vi, description_en, description_vi,
  directors, actors, duration, release_date, movie_cat_id, price, preview_url, source_url)
values(movie_seq.nextval, 'VID_001', sysdate, 'system', 'system', sysdate, 1,
  'Kong: Skull Island', 'Kong: Đảo Đầu Lâu', 'Kong: Skull Island', 'Kong: Đảo Đầu Lâu', 'Huge mokey vs troops', 'Cuộc chiến giữa khỉ đột khổng lồ và bộ binh Mỹ trên đất Việt Nam',
  'Jordan Vogt-Roberts', 'Tom Hiddleston, Samuel L Jacson, Brie Larson', 109, to_date('04-05-2017', 'DD-MM-YYYY'), 1, 1000,
  'http://113.185.0.85/74b055d4/58edd749/0/0/322/329751/329751_level_2.mp4', 'http://113.185.0.85/74b055d4/58edd749/0/0/322/329751/329751_level_2.mp4'
);

insert into movie(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp, status,
  name_en, name_vi, display_name_en, display_name_vi, description_en, description_vi,
  directors, actors, duration, release_date, movie_cat_id, price, preview_url, source_url)
values(movie_seq.nextval, 'VID_002', sysdate, 'system', 'system', sysdate, 1,
  'Split', 'Đa nhân cách', 'Split', 'Đa nhân cách', 'A story of a crazy man', 'Câu chuyện rùng rợn về kẻ đa nhân cách',
  'M. Night Shyamalan', 'James McAvoy', 117, to_date('04-05-2017', 'DD-MM-YYYY'), 2, 1000,
  'http://113.185.0.85/f52c12cd/58edd77b/0/0/322/329761/329761_level_2.mp4', 'http://113.185.0.85/f52c12cd/58edd77b/0/0/322/329761/329761_level_2.mp4'
);


insert into movie(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp, status,
  name_en, name_vi, display_name_en, display_name_vi, description_en, description_vi,
  directors, actors, duration, release_date, movie_cat_id, price, preview_url, source_url)
values(movie_seq.nextval, 'VID_003', sysdate, 'system', 'system', sysdate, 1,
  'Ronin', 'Đặc vụ Paris', 'Ronin', 'Đặc vụ Paris', 'A classic action movie', 'Bộ phim hành động về nhiệm vụ bí mật tại Paris',
  'John Frankenheimer', 'Robert De Niro', 122, to_date('04-05-1998', 'DD-MM-YYYY'), 1, 1000,
  'http://113.185.0.85/584a9f02/58ede50e/0/0/240/246595/246595_level_2.mp4 ', 'http://113.185.0.85/584a9f02/58ede50e/0/0/240/246595/246595_level_2.mp4 '
);


--music contents
set define off;

insert into music(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp, status,
  name_en, name_vi, display_name_en, display_name_vi, description_en, description_vi,
  album_name, artist_name, duration, format, music_cat_id, price, quality, preview_url, source_url)
values(music_seq.nextval, 'SONG_001', sysdate, 'system', 'system', sysdate, 1,
  'Marry You', 'Marry You', 'Marry You', 'Marry You',
  'Marry You is a song by American singer and songwriter Bruno Mars from his debut studio album, Doo-Wops &amp; Hooligans (2010).',
  'Marry You is a song by American singer and songwriter Bruno Mars from his debut studio album, Doo-Wops &amp; Hooligans (2010).',
  'Doo-Wops &amp; Hooligans', 'Bruno Mars', 0, 'mp3', 1, 1000, 128,
  'https://drive.google.com/open?id=0B14DU9n6VrDFckZsWjdvcVEwQWs', 'https://drive.google.com/open?id=0B14DU9n6VrDFckZsWjdvcVEwQWs'
);

insert into music(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp, status,
  name_en, name_vi, display_name_en, display_name_vi, description_en, description_vi,
  album_name, artist_name, duration, format, music_cat_id, price, quality, preview_url, source_url)
values(music_seq.nextval, 'SONG_002', sysdate, 'system', 'system', sysdate, 1,
  'Shape Of You', 'Shape Of You', 'Shape Of You', 'Shape Of You',
  'Shape of You is a song by English singer-songwriter Ed Sheeran',
  'Shape of You is a song by English singer-songwriter Ed Sheeran',
  'Shape of You', 'Ed Sheeran', 0, 'mp3', 1, 1000, 128,
  'https://drive.google.com/open?id=0B14DU9n6VrDFckZsWjdvcVEwQWs', 'https://drive.google.com/open?id=0B14DU9n6VrDFckZsWjdvcVEwQWs'
);

insert into music(id, code, create_timestamp, created_by, last_modified_by, last_modified_timestamp, status,
  name_en, name_vi, display_name_en, display_name_vi, description_en, description_vi,
  album_name, artist_name, duration, format, music_cat_id, price, quality, preview_url, source_url)
values(music_seq.nextval, 'SONG_003', sysdate, 'system', 'system', sysdate, 1,
  'Happy', 'Happy', 'Happy', 'Happy',
  'Happy is a song written, produced, and performed by American singer and record producer Pharrell Williams, from the Despicable Me 2 soundtrack album.',
  'Happy is a song written, produced, and performed by American singer and record producer Pharrell Williams, from the Despicable Me 2 soundtrack album.',
  'Despicable Me 2', 'Pharrell Williams', 0, 'mp3', 1, 1000, 128,
  'https://drive.google.com/open?id=0B14DU9n6VrDFckZsWjdvcVEwQWs', 'https://drive.google.com/open?id=0B14DU9n6VrDFckZsWjdvcVEwQWs'
);

select id, display_name_en, default_icon, default_image from movie;
update movie set default_icon = '/content/movie/kong_182x268px.jpeg', default_image = '/content/movie/kong-skull-island-poster_1536x711px.jpeg' where id = 9;
update movie set default_icon = '/content/movie/kong_182x268px.jpeg', default_image = '/content/movie/split_464x344px.jpeg' where id = 10;
update movie set default_icon = '/content/movie/ronin_292x432px.jpeg', default_image = '/content/movie/ronin_1000x1426px.jpeg' where id = 11;


select id, display_name_en, default_icon, default_image from music;
update music set default_icon = '/content/music/bruno_mars_marry_you_335x446px.jpeg', default_image = '/content/music/bruno_mars_marryyou_953x935px.jpeg' where id = 1;
update music set default_icon = '/content/music/shape_of_you_300x300px.jpeg', default_image = '/content/music/shape_of_you_630x630px.jpeg' where id = 2;
update music set default_icon = '/content/music/happy_pharerel_williams_212x300px.jpeg', default_image = '/content/music/happy_pharerel_williams_640x639px.jpeg' where id = 3;


select id, display_name_en, default_icon, default_image from game;
update game set default_icon = '/content/game/mario_230x230px.png', default_image = '/content/game/mario_230x230px.png' where id = 2;
update game set default_icon = '/content/game/catchword_194x224px.png', default_image = '/content/game/catchword_194x224px.png' where id = 3;
update game set default_icon = '/content/game/block_craft_201x199px.png', default_image = '/content/game/block_craft_201x199px.png' where id = 4;
update game set default_icon = '/content/game/heroes_of_loot_203x201px.png', default_image = '/content/game/heroes_of_loot_203x201px.png' where id = 5;


    insert into movie_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, movie_id, status)
    values(movie_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 9, 1);
    insert into movie_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, movie_id, status)
    values(movie_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 10, 1);
    insert into movie_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, movie_id, status)
    values(movie_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 11, 1);


    insert into music_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, music_id, status)
    values(music_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 1, 1);
    insert into music_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, music_id, status)
    values(music_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 2, 1);


    insert into apps_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, apps_id, status)
    values(apps_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 2, 1);
    insert into apps_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, apps_id, status)
    values(apps_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 3, 1);
    insert into apps_banner(id, create_timestamp, created_by, last_modified_by, last_modified_timestamp, start_date, end_date, apps_id, status)
    values(apps_banner_seq.nextval, sysdate,'system', 'system', sysdate, sysdate, sysdate + 60, 5, 1);
