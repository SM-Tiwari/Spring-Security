SQL> desc self_pkg_price_map;
 Name					   Null?    Type
 ----------------------------------------- -------- ----------------------------
 ID					   NOT NULL NUMBER(10)
 CREATE_TIMESTAMP			   NOT NULL TIMESTAMP(6)
 CREATED_BY				   NOT NULL VARCHAR2(255 CHAR)
 LAST_MODIFIED_BY			   NOT NULL VARCHAR2(255 CHAR)
 LAST_MODIFIED_TIMESTAMP		   NOT NULL TIMESTAMP(6)
 CYCLE						    NUMBER(10)
 MAX_AMOUNT					    NUMBER(10)
 MIN_AMOUNT					    NUMBER(10)
 NORMAL_PRICE					    NUMBER
 PRICE						    NUMBER(38,2)
 TYPE					   NOT NULL VARCHAR2(20 CHAR)

SQL> select cycle, type, min_amount, max_amount, normal_price, price from self_pkg_price_map where type = 'DATA' and cycle = 2;

     CYCLE TYPE 		MIN_AMOUNT MAX_AMOUNT NORMAL_PRICE	PRICE
---------- -------------------- ---------- ---------- ------------ ----------
	 2 DATA 		       500	  999	    256000	15000
	 2 DATA 		      1000	 1499	    512000	30000
	 2 DATA 		      1500	 1999	    768000	45000
	 2 DATA 		      2000	 2499	   1024000	60000
	 2 DATA 		      2500	 2999	   1280000	70000
	 2 DATA 		      3000	 3499	   1536000	80000
	 2 DATA 		      3500	 3999	   1792000	90000
	 2 DATA 		      4000	 4499	   2048000     100000
	 2 DATA 		      4500	 4999	   2304000     107500
	 2 DATA 		      5000	 5499	   2560000     115000
	 2 DATA 		      5500	 5999	   2816000     122500

     CYCLE TYPE 		MIN_AMOUNT MAX_AMOUNT NORMAL_PRICE	PRICE
---------- -------------------- ---------- ---------- ------------ ----------
	 2 DATA 		      6000	 6499	   3072000     130000
	 2 DATA 		      6500	 6999	   3328000     135000
	 2 DATA 		      7000	 7499	   3584000     140000
	 2 DATA 		      7500	 7999	   3840000     145000
	 2 DATA 		      8000	 8499	   4096000     150000
	 2 DATA 		      8500	 8999	   4352000     155000
	 2 DATA 		      9000	 9499	   4608000     160000
	 2 DATA 		      9500	 9999	   4864000     165000
	 2 DATA 		     10000	10000	   5120000     170000

20 rows selected.

SQL> update self_pkg_price_map set normal_price = 512 where type = 'DATA' and cycle = 2;

20 rows updated.

SQL> commit;

Commit complete.

SQL>
