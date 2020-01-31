﻿insert into store(id, create_timestamp, created_by, last_modified_timestamp, last_modified_by, code, name, address, latitude, longitude, district, province) values(store_seq.nextval, sysdate, 'system', sysdate, 'system','602035457','CHDT vui nhieu','214-HA BAO 2-DA PHUOC','10.7341836','105.1284081','An Phu','An Giang');




UPDATE store t1
   SET (longitude, latitude) = (SELECT t2.latitude, t2.longitude
                         FROM store_20170921 t2
                        WHERE t1.id = t2.id)
 WHERE EXISTS (
    SELECT 1
      FROM store_20170921 t2
     WHERE t1.id = t2.id );