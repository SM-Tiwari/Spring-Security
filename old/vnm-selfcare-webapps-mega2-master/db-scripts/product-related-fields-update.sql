update product_group pg
set pg.name_en = (select pgm.value from product_group_metadata pgm where pgm.name = 'NAME_EN'
and pgm.product_group_id = pg.id and rownum <= 1);

update product_group pg
set pg.name_vi = (select pgm.value from product_group_metadata pgm where pgm.name = 'NAME_VI'
and pgm.product_group_id = pg.id and rownum <= 1);

update product_group pg
set pg.description_en = (select pgm.value from product_group_metadata pgm where pgm.name = 'DESCRIPTION_EN'
and pgm.product_group_id = pg.id and rownum <= 1);

update product_group pg
set pg.DESCRIPTION_VI = (select pgm.value from product_group_metadata pgm where pgm.name = 'DESCRIPTION_VI'
and pgm.product_group_id = pg.id and rownum <= 1);

update product_group pg
set pg.default_image = (select pgm.value from product_group_metadata pgm where pgm.name = 'IMAGE_LARGE'
and pgm.product_group_id = pg.id and rownum <= 1);

update product_group pg
set pg.default_banner = (select pgm.value from product_group_metadata pgm where pgm.name = 'IMAGE_XLARGE'
and pgm.product_group_id = pg.id and rownum <= 1);


update product_category pc
set pc.name_en = (select pcm.value from product_cat_metadata pcm where pcm.name = 'NAME_EN'
and pcm.product_cat_id = pc.id and rownum <= 1);

update product_category pc
set pc.name_vi = (select pcm.value from product_cat_metadata pcm where pcm.name = 'NAME_VI'
and pcm.product_cat_id = pc.id and rownum <= 1);

update product_category pc
set pc.description_en = (select pcm.value from product_cat_metadata pcm where pcm.name = 'DESCRIPTION_EN'
and pcm.product_cat_id = pc.id and rownum <= 1);

update product_category pc
set pc.description_vi = (select pcm.value from product_cat_metadata pcm where pcm.name = 'DESCRIPTION_VI'
and pcm.product_cat_id = pc.id and rownum <= 1);

update product p
set p.default_image = (select pg.default_image from product_group pg where p.PROD_GROUP_ID = pg.id);

update product p
set p.default_banner = (select pg.default_banner from product_group pg where p.PROD_GROUP_ID = pg.id);
