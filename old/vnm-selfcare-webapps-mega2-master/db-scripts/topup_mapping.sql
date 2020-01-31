insert into topup_type (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type_name, display_name_en, display_name_vi)
values(topup_type_seq.nextval, sysdate, 'system', sysdate, 'system', 'CCWS_non_voucher', 'Bank', 'Bank');

insert into topup_type (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type_name, display_name_en, display_name_vi)
values(topup_type_seq.nextval, sysdate, 'system', sysdate, 'system', 'VOUCHER', 'Scratch Card', 'Mã nạp tiền');

insert into topup_type (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type_name, display_name_en, display_name_vi)
values(topup_type_seq.nextval, sysdate, 'system', sysdate, 'system', 'ETOPUP', 'Bank', 'Bank');

insert into topup_type (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type_name, display_name_en, display_name_vi)
values(topup_type_seq.nextval, sysdate, 'system', sysdate, 'system', 'CCWS_non_voucher_VMS', 'Scratch Card', 'Mã nạp tiền');

insert into topup_type (id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, type_name, display_name_en, display_name_vi)
values(topup_type_seq.nextval, sysdate, 'system', sysdate, 'system', 'CCWS_non_voucher_VMS ETOPUP', 'Bank', 'Bank');



update topup_type set display_name_en='Bank', display_name_vi='Ngân hàng' where type_name='BalanceOnly';
update topup_type set display_name_en='eTopup', display_name_vi='Nạp tiền điện tử' where type_name='CCWS_non_voucher';
update topup_type set display_name_en='Scratch Card', display_name_vi='Thẻ cào' where type_name='CCWS_non_voucher_VMS';
update topup_type set display_name_en='eTopup', display_name_vi='Nạp tiền điện tử' where type_name='CCWS_non_voucher_VMS_ETOPUP';
update topup_type set display_name_en='Scratch Card', display_name_vi='Thẻ cào' where type_name='CCWS_voucher';
update topup_type set display_name_en='eTopup', display_name_vi='Nạp tiền điện tử' where type_name='ETOPUP';
update topup_type set display_name_en='Bank', display_name_vi='Ngân hàng' where type_name='MTRPAYMENT_GATEWAY';
update topup_type set display_name_en='Scratch Card', display_name_vi='Thẻ cào' where type_name='USSD';
update topup_type set display_name_en='Scratch Card', display_name_vi='Thẻ cào' where type_name='VOUCHER';
