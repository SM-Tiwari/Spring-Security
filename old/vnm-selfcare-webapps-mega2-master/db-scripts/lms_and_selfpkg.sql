-- lms keyword
insert into lms_keyword_mapping(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, keyword, unit_amount)
values (lms_keyword_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS', 20);

insert into lms_keyword_mapping(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, keyword, unit_amount)
values (lms_keyword_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE', 10);

insert into lms_keyword_mapping(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, keyword, unit_amount)
values (lms_keyword_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 100);

insert into lms_keyword_mapping(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, keyword, unit_amount)
values (lms_keyword_seq.nextval, sysdate, 'system', sysdate, 'system', 'CASHBACK', 5000);


--self Package
insert into self_pkg_balance_name(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, desc_en, desc_vi)
values (selfpkg_balname_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 'Data', 'Data');

insert into self_pkg_balance_name(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, desc_en, desc_vi)
values (selfpkg_balname_seq.nextval, sysdate, 'system', sysdate, 'system', 'DYNAMIC_OFFNET_VOICE', 'Voice Offnet', 'Voice Offnet');

insert into self_pkg_balance_name(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, desc_en, desc_vi)
values (selfpkg_balname_seq.nextval, sysdate, 'system', sysdate, 'system', 'DYNAMIC_ONNET_VOICE', 'Voice Onnet', 'Voice Onnet');

insert into self_pkg_balance_name(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, desc_en, desc_vi)
values (selfpkg_balname_seq.nextval, sysdate, 'system', sysdate, 'system', 'DYNAMIC_OFFNET_SMS', 'Offnet SMS', 'Offnet SMS');

insert into self_pkg_balance_name(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, desc_en, desc_vi)
values (selfpkg_balname_seq.nextval, sysdate, 'system', sysdate, 'system', 'DYNAMIC_ONNET_SMS', 'Onnet SMS', 'Onnet SMS');

insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_DAILY_INCR_VALUE','25');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_DAILY_MAX_VALUE','500');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_WEEKLY_INCR_VALUE','50');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_WEEKLY_MAX_VALUE','1000');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_MONTHLY_INCR_VALUE','100');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_MONTHLY_MAX_VALUE','2000');

insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
    values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DAYS_DAILY','1');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
    values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DAYS_WEEKLY','7');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
    values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DAYS_MONTHLY','30');




insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_DAILY_INCR_VALUE','25');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_DAILY_MAX_VALUE','500');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_WEEKLY_INCR_VALUE','50');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_WEEKLY_MAX_VALUE','1000');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_MONTHLY_INCR_VALUE','100');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_MONTHLY_MAX_VALUE','2000');

insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA_DAILY_INCR_VALUE','100');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA_DAILY_MAX_VALUE','1000');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA_WEEKLY_INCR_VALUE','200');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA_WEEKLY_MAX_VALUE','3000');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA_MONTHLY_INCR_VALUE','500');
insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA_MONTHLY_MAX_VALUE','10000');

insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'MULTIPLIER_VND','10000');

insert into self_pkg_common_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, name, value)
  values (selfpkg_config_seq.nextval, sysdate, 'system', sysdate, 'system', 'PACKAGE_ID','2045');

--price map
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 500, 999, 15000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1000, 1499, 30000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1500, 1999, 45000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2000, 2499, 60000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2500, 2999, 70000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 3000, 3499, 80000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 3500, 3999, 90000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 4000, 4499, 100000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 4500, 4999, 107500, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 5000, 5499, 115000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 5500, 5999, 122500, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 6000, 6499, 130000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 6500, 6999, 135000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 7000, 7499, 140000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 7500, 7999, 145000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 8000, 8499, 150000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 8500, 8999, 155000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 9000, 9499, 160000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 9500, 90499, 165000, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 95000, 100000, 17000, 2);

--weekly
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 200, 399, 4000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 400, 599, 8000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 600, 799, 12000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 800, 999, 16000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1000, 1199, 20000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1200, 1399, 23000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1400, 1599, 26000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1600, 1799, 29000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1800, 1999, 32000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2000, 2199, 34000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2200, 2399, 36000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2400, 2599, 38000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2600, 2799, 40000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 2800, 2999, 42000, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 3000, 100000, 44000, 1);


--daily
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 100, 199, 1000, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 200, 299, 1500, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 300, 399, 2000, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 400, 499, 2500, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 500, 599, 3000, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 600, 699, 3500, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 700, 799, 4000, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 800, 899, 4500, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 900, 999, 4750, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'DATA', 1000, 100000, 5000, 0);

--VOICE monthly
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 1, 30, 990, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 31, 100, 680, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 101, 10000, 500, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 1, 30, 1200, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 31, 100, 990, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 101, 10000, 680, 2);

--voice weekly
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 1, 50, 990, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 51, 100000, 680, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 1, 50, 1200, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 51, 100000, 990, 1);

--voice daily
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 1, 50, 990, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_ONNET', 51, 100000, 680, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 1, 50, 1200, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOICE_OFFNET', 51, 100000, 990, 0);


--SMS monthly

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 1, 30, 250, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 31, 100, 200, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 101, 10000, 150, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_OFFNET', 1, 30, 300, 2);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_OFFNET', 31, 100000, 250, 2);

--SMS weekly
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 1, 50, 250, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 51, 100000, 200, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_OFFNET', 1, 50, 300, 1);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_OFFNET', 51, 100000, 250, 1);

--SMS daily
insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 1, 50, 250, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_ONNET', 51, 100000, 200, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_OFFNET', 1, 50, 300, 0);

insert into self_pkg_price_map(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type, min_amount, max_amount, price, cycle)
values (selfpkg_pricemap_seq.nextval, sysdate, 'system', sysdate, 'system', 'SMS_OFFNET', 51, 100000, 250, 0);
