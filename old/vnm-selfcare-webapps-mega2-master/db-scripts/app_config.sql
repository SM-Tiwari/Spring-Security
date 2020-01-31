--------------------------------------------------------
--  File created - Thursday-March-23-2017
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table APP_CONFIG
--------------------------------------------------------

  CREATE TABLE "SCUSER"."APP_CONFIG"
   (	"ID" NUMBER(10,0),
	"CREATE_TIMESTAMP" TIMESTAMP (6),
	"CREATED_BY" VARCHAR2(255 CHAR),
	"LAST_MODIFIED_BY" VARCHAR2(255 CHAR),
	"LAST_MODIFIED_TIMESTAMP" TIMESTAMP (6),
	"IS_FLAG" NUMBER(10,0),
	"NAME" VARCHAR2(255 CHAR),
	"VALUE" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SC_DATA" ;
REM INSERTING into SCUSER.APP_CONFIG
SET DEFINE OFF;
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('46','0','smpp.ton.sender','ALPHANUMERIC');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('47','0','smpp.ton.recipient','INTERNATIONAL');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('51','0','topup.notification.sms.enabled','true');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('1','1','otp.enabled','false');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('2','1','adapter.poolenabled','false');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('3','0','adapter.vasman.status.success','1');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('4','0','smpp.host','10.8.2.99');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('5','0','adapter.upcc.conn.reconnectinterval','45');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('6','0','adapter.upcc.conn.maxcount','10');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('7','0','adapter.rtbs.conn.ip','10.230.1.200');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('8','0','dateformat.default','dd-MM-yyyy');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('9','0','adapter.pool.maxtotal','50');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('10','0','otp.expirytime.minutes','5');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('11','0','language.default','vi');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('12','0','adapter.vasman.conn.username','vasccw');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('13','0','adapter.upcc.conn.port','8080');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('14','0','adapter.upcc.conn.username','Selfcare');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('15','0','adapter.vasman.cmdid.activate','1');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('16','1','smpp.enabled','true');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('17','0','adapter.vasman.conn.ip','10.8.13.32');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('18','0','adapter.rtbs.conn.port','80');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('19','1','adapter.simulated','false');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('20','0','dateformat.long','dd-MM-yyyy HH:mm:ss');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('21','0','adapter.rtbs.conn.wsdl','ccws/ccws.asmx?wsdl');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('22','0','adapter.rtbs.balancenames.voice','VOICE_ONNET;CALLME;1DAY_VOICE;VM18;VOICE_ONNET2;VOICE_ONNET3;VOICE_ANYNET;VOICE_IDD;');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('23','0','adapter.upcc.conn.ip','10.10.198.4');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('24','0','security.password.regex','^\S*(?=\S*[a-zA-Z])(?=\S*[0-9])\S{8,}$');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('25','0','smpp.bindtype','BIND_TX');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('26','0','adapter.rtbs.balancenames.main','Core;CURRENCY_ONNET;CURRENCY_ONNET3;PROMOTION;CURRENCY_ONNET2;PROMOTION_60;VB600_M;CURRENCY_NORTH;ONNET_VOICE;ANYNET_VOICE;CURRENCY_ANYNET;CURRENCY_ONNET4;CURRENCY_ONNET5;PROMOTION_KN5;CURRENCY_ONNET_KN5');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('27','0','security.password.minlength','8');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('28','0','adapter.pool.maxidle','10');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('29','0','adapter.vasman.conn.credential','vasccw4567');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('30','0','adapter.vasman.conn.port','8080');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('31','0','adapter.upcc.conn.timeout','10');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('32','0','prefixes.vnm.msisdn','092;018');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('33','0','adapter.vasman.conn.wsdl','WSVasManager/services/WSVasmanager?wsdl');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('34','0','adapter.vasman.cmdid.deactivate','3');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('35','0','adapter.rtbs.balancenames.sms','SMS_ONNET;ANYNET_SMS;1DAY_SMS');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('36','0','adapter.rtbs.conn.credential','ab123456');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('37','0','smpp.password','S3lFc@re');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('38','0','smpp.port','2775');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('39','0','smpp.username','selfcare');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('40','0','adapter.upcc.conn.sotimeout','10');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('41','0','smpp.reconnectinterval.secs','360');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('42','0','prefixes.vnm.imsi','45208');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('43','0','adapter.upcc.conn.credential','Vnm@2018');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('44','0','smpp.defaultsender','VNMSelfCare');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('45','0','adapter.rtbs.conn.username','VNM_CCW');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('48','0','imageserver.url','http://202.172.4.55/selfcareimgsvr');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('49','0','imageserver.imgdir','/images');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values ('50','0','imageserver.uploaddir','/app/apache-tomcat-api/webapps/selfcareimgsvr/images');

Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values(app_config_seq.nextval, 0, 'radius.host', '10.10.129.164');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values(app_config_seq.nextval, 0, 'radius.port', '667');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values(app_config_seq.nextval, 0, 'radius.username', 'cn=vmcp0003,o=radius');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values(app_config_seq.nextval, 0, 'radius.password', 'Vnmcp3');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values(app_config_seq.nextval, 0, 'radius.search.filter', 'framed-ip-address=*');
Insert into SCUSER.APP_CONFIG (ID,IS_FLAG,NAME,VALUE) values(app_config_seq.nextval, 0, 'radius.search.scope', 'SCOPE_SUBTREE');
--------------------------------------------------------
--  DDL for Index SYS_C0010068
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCUSER"."SYS_C0010068" ON "SCUSER"."APP_CONFIG" ("ID")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SC_DATA" ;
--------------------------------------------------------
--  DDL for Index UK_600CX4NFNGLHX0PQ9PITVPXUN
--------------------------------------------------------

  CREATE UNIQUE INDEX "SCUSER"."UK_600CX4NFNGLHX0PQ9PITVPXUN" ON "SCUSER"."APP_CONFIG" ("NAME")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SC_DATA" ;
--------------------------------------------------------
--  Constraints for Table APP_CONFIG
--------------------------------------------------------

  ALTER TABLE "SCUSER"."APP_CONFIG" ADD CONSTRAINT "UK_600CX4NFNGLHX0PQ9PITVPXUN" UNIQUE ("NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SC_DATA"  ENABLE;
  ALTER TABLE "SCUSER"."APP_CONFIG" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SC_DATA"  ENABLE;
  ALTER TABLE "SCUSER"."APP_CONFIG" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SCUSER"."APP_CONFIG" MODIFY ("LAST_MODIFIED_TIMESTAMP" NOT NULL ENABLE);
  ALTER TABLE "SCUSER"."APP_CONFIG" MODIFY ("LAST_MODIFIED_BY" NOT NULL ENABLE);
  ALTER TABLE "SCUSER"."APP_CONFIG" MODIFY ("CREATED_BY" NOT NULL ENABLE);
  ALTER TABLE "SCUSER"."APP_CONFIG" MODIFY ("CREATE_TIMESTAMP" NOT NULL ENABLE);
  ALTER TABLE "SCUSER"."APP_CONFIG" MODIFY ("ID" NOT NULL ENABLE);


  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'imageserver.imgdir.product', '/prod');
  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'imageserver.imgdir.content', '/content');
  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'imageserver.imgdir.avatar', '/avatar');

  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value) values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'imageserver.upload.dir', '/app/imageserver/images');

  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'image.avatar.height', '85');
  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'image.avatar.width', '85');

  insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'pagedlist.itemsperpage.avatar', '9');

  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.requesturl', 'http://10.8.2.164:19092/vnmbl/VNM/capturePayment');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.connectimeout', '10');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.username', 'selfcare');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.credential', 'selfcare');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.channelid', 'SELFCARE');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.mid', '938425');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.secretkey', '938425');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.language', 'E');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.datetimeformat', 'ddMMyyyy HH:mm:ss:SSS');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.callbackurl.api', 'http://10.8.8.31:8181/webapi/pg/callback');
  insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.callbackurl.web', 'http://10.8.8.31:8181/webapi/pg/callback');

insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.paymentdone.callbackurl', 'http://10.8.2.164:19091/VNPGUI/PGCallBackHandler');
insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.paymentdone.params', 'vpc_AdditionalData;vpc_Amount;vpc_BatchNo;vpc_Command;vpc_CurrencyCode;vpc_Locale;vpc_MerchTxnRef;vpc_Merchant;vpc_OrderInfo;vpc_ResponseCode;vpc_TransactionNo;vpc_Version;vpc_SecureHash');

insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'countrycode.default', '84');
insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pagedlist.itemsperpage.all', '9');


insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.napas.callbackurl', 'http://10.0.0.36:8080/merchant/status/callBackURL');
insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'pg.napas.cancelurl', 'http://202.172.4.55/webapi/pg/cancelPayment?orderId=');

insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'security.token.expirationinminutes', '1440');

insert into app_config values (app_config_seq.nextval, sysdate, 'system', 'system', sysdate, 0, 'product.hiddenlist.enabled', 'true');

--Loyalty Adapter configurations
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.conn.protocol', 'http');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.conn.ip', '10.8.13.31');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.conn.port', '8080');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.conn.username', 'vasepos');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.conn.credential', 'vasepos2345');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.conn.wsdl', '/LoyaltyWS/services/LoyaltyWS?wsdl');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.respcode.success', '1');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.respmsg.success', 'success');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'adapter.loyalty.logsoapmsg.enabled', 'true');


---gamify configurations
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
    values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.gamify.url.getmonsters', 'http://10.8.1.117/api/getMonster.php');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
    values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.gamify.url.redeembymonster', 'http://10.8.1.117/api/redeemByMonster.php');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
    values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.gamify.connecttimeout', '15');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
    values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.gamify.sockettimeout', '15');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'httptokenlogin.landingpage.gamify', '/profile');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'httptokenlogin.landingpage.mobileapp', '/topuphistory');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'adapter.radius.ipaddr.regex', '10\.2[0|1]\d\.\d{1,3}\.\d{1,3}');


insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'recaptcha.sitekey', '6Lcl4BYUAAAAAJ7pqFM2XxVs5jiCQwcnTwCDpm2z');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'recaptcha.secretkey', '6Lcl4BYUAAAAADMMbgqnrYZZ2bBRQHqVSm30nOLW');

---member get member
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'membergetmember.rewardpoint.sender', '10');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'membergetmember.rewardpoint.invited', '10');


---phone number regex
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'phonenumber.regex', '((018)|(092))[0-9]{7,8}');


--topup with scratchcard
--\d{12,16}
--^\d{4}-?\d{4}-?\d{4}$
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 1, 'topup.scratchcard.regex', '^\d{4}-?\d{4}-?\d{4}$');


insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.accesscode','V1IE3TN5AM4OBI6L7E8');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.merchantid','VIETNAMOBILE');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.user','querydr');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.password','vietnamobile@123');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.secretkey','AF0EAFF75EA44DB0AAE472BE55177CC9');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.querydr.command','queryDR');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.querydr.version','2.2');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.querydr.url','https://payment.napas.com.vn/gateway/vpcdps');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
    values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.trxtimeout.seconds','300');

insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
        values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'napas.querydr.intervalseconds','30');


--- CONFIGS FOR SELF PACKAGE
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'adapter.loyalty.pointmultiplier', '5');


--contact us settings
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'contactus.phoneno.en', '0922366366');
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'contactus.phoneno.vi', '0922789789');
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'contactus.email.addr', 'cskh@vietnamobile.com.vn');
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
  values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'contactus.email.subject', 'Self Care');


--pg refund payment prod env
insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value)
      values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'pg.refundurl','http://10.6.22.113:19092/vnmbl/VNM/refundPayment');

--pg refund payment env
--insert into app_config(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, is_flag, name, value) values (app_config_seq.nextval, sysdate, 'system', sysdate, 'system', 0, 'pg.refundurl','http://10.8.2.165:19092/vnmbl/VNM/refundPayment');
