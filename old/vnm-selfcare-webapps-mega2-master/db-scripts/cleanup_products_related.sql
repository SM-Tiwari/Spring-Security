
delete from product_metadata where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'SMS')
  )
);

delete from product_subscription where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'SMS')
  )
);

delete from promoted_product where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'SMS')
  )
);

delete from product_metadata where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'SMS')
  )
);

delete from product_subscription where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'SMS')
  )
);

delete from transaction_history where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'SMS')
  )
);

delete from product where prod_group_id in (
  select id from product_group where category_id = (select id from product_category where code = 'SMS')
);
delete from product_group_metadata where product_group_id in(
  select id from product_group where category_id = (select id from product_category where code = 'SMS')
);
delete from product_group where category_id = (select id from product_category where code = 'SMS');
delete from product_cat_metadata where product_cat_id = (select id from product_category where code = 'SMS');
delete from product_category where code = 'SMS';

delete from product_metadata where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'COMBO')
  )
);

delete from product_subscription where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'COMBO')
  )
);

delete from promoted_product where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'COMBO')
  )
);

delete from product where prod_group_id in (
  select id from product_group where category_id = (select id from product_category where code = 'COMBO')
);
delete from product_group_metadata where product_group_id in(
  select id from product_group where category_id = (select id from product_category where code = 'COMBO')
);
delete from product_group where category_id = (select id from product_category where code = 'COMBO');
delete from product_cat_metadata where product_cat_id = (select id from product_category where code = 'COMBO');
delete from product_category where code = 'COMBO';


delete from product_metadata where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'INT_ROAMING')
  )
);

delete from product_subscription where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'INT_ROAMING')
  )
);

delete from promoted_product where product_id in(
  select id from product where prod_group_id in (
    select id from product_group where category_id = (select id from product_category where code = 'INT_ROAMING')
  )
);

delete from product where prod_group_id in (
  select id from product_group where category_id = (select id from product_category where code = 'INT_ROAMING')
);
delete from product_group_metadata where product_group_id in(
  select id from product_group where category_id = (select id from product_category where code = 'INT_ROAMING')
);
delete from product_group where category_id = (select id from product_category where code = 'INT_ROAMING');
delete from product_cat_metadata where product_cat_id = (select id from product_category where code = 'INT_ROAMING');
delete from product_category where code = 'INT_ROAMING';


delete from product_metadata where product_id in (select id from product where code in ('1000009xxx', '125528xxx') );
delete from product_subscription where product_id in (select id from product where code in ('1000009xxx', '125528xxx') );
delete from promoted_product where product_id in (select id from product where code in ('1000009xxx', '125528xxx') );
delete from transaction_history where product_id in (select id from product where code in ('1000009xxx', '125528xxx') );
delete from product where code in ('1000009xxx', '125528xxx');


    SELECT c.owner,
           a.table_name,
           a.column_name,
           a.constraint_name,
           C.R_CONSTRAINT_NAME
    FROM ALL_CONS_COLUMNS A, ALL_CONSTRAINTS C
    where A.CONSTRAINT_NAME = C.CONSTRAINT_NAME
      and C.CONSTRAINT_TYPE = 'R'
    order by a.table_name;
