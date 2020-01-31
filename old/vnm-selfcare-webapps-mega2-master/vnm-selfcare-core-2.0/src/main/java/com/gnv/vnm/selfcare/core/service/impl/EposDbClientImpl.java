/**
 * EPOSDBClient.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.enums.SubscriptionStatus;
import com.gnv.vnm.selfcare.core.model.PackageSubscription;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.service.EposDbClient;
import com.gnv.vnm.selfcare.core.service.ProductManagementService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;

/**
 * @author nandipinto
 *
 */

@Service("eposDbClient")
public class EposDbClientImpl implements EposDbClient {
	
	private static final Logger logger = LoggerFactory.getLogger(EposDbClientImpl.class);
	
	private static final String SQL_RESOURCE = "config/sql.properties";
	private static final String TARGET_ENV_TEST = "test";
	private static final String TARGET_ENV_PROD = "prod";

	@Autowired
	Environment env;
	
	@Autowired 
	@Qualifier("eposdbDataSource")
	private DataSource eposdbDataSource;

	//In UAT environment, this class needs to run query to two different databases.
	@Autowired 
	@Qualifier("eposDevDataSource")
	private DataSource eposDevDataSource;

	@Autowired 
	@Qualifier("eposVasDataSource")
	private DataSource eposVasDataSource;

	@Autowired
	private ProductManagementService productManagementService;

	private Properties sqlSrc = new Properties();
	private JdbcTemplate eposJdbc = null;
	private JdbcTemplate eposJdbcDev = null;
	private JdbcTemplate eposVasJdbcDev = null;
	
	private String targetEnv = TARGET_ENV_TEST;
	
	@PostConstruct
	public void initService() throws Exception{
		InputStream input = null;
		try {
			input = this.getClass().getClassLoader().getResourceAsStream(SQL_RESOURCE);
			sqlSrc.load(input);
			
		} catch (Exception e) {
			logger.error("#initiate >> error reading SQL resource file!", e);
		} finally{
			if (input != null){
				try {
					input.close();
				} catch (Exception e2) {}
			}
		}
		
		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			eposJdbc = new JdbcTemplate(eposdbDataSource);
		} else {
			eposJdbcDev = new JdbcTemplate(eposDevDataSource);
			eposVasJdbcDev = new JdbcTemplate(eposVasDataSource);
		}
	}

	private List<PackageSubscription> getSubscribedPackages(String subscriberId, final String langCode, JdbcTemplate jdbcTemplate) {
		
		final String defaultSql = "select b.isdn, b.registerdate, b.expirationdate, b.unregisterdate, b.status, "
				+ "a.productid, a.title, a.description, a.content, a.price "
				+ "from owner_sdp2.productentry a, owner_sdp2.subscriberproduct b "
				+ "where b.unregisterdate is null and b.status = 1 and a.productid = b.productid and b.isdn= ?";
	
		final String sql = sqlSrc.getProperty("sql.epos.getsubscribedpackages", defaultSql);
		
		List<PackageSubscription> result = new ArrayList<>();

		try {
			List<PackageSubscription> list = jdbcTemplate.query(sql,
					new String[] {
							AppUtils.prependCountryCodeToMsisdn(subscriberId, AppDefaultValues.COUNTRY_CODE) },
					new RowMapper<PackageSubscription>() {

				@Override
				public PackageSubscription mapRow(ResultSet rs, int rowNum) throws SQLException {
					Date startDate = rs.getDate("registerdate");
					Date expDate = rs.getDate("expirationdate");
					Date endDate = rs.getDate("expirationdate"); //unregisterdate
					Object productId = rs.getObject("productid");

					PackageSubscription subscription = new PackageSubscription();
					subscription.setEndDate(endDate);
					subscription.setEndDateAsString(AppUtils.dateToString(endDate, AppDefaultValues.DATE_TIME_FORMAT));
					subscription.setExpDate(expDate);
					subscription.setExpDateAsString(AppUtils.dateToString(expDate, AppDefaultValues.DATE_TIME_FORMAT));
					
					subscription.setStartDate(startDate);
					subscription.setStartDateAsString(AppUtils.dateToString(startDate, AppDefaultValues.DATE_TIME_FORMAT));
					subscription.setStatus(SubscriptionStatus.ACTIVE);

					Product product = productManagementService.getProductDetailsByCode(productId.toString(), langCode);
					//update 20170527 --- ammended on 20170715
					//only add products that exist on both self-care and eposdb <?>
					if (product != null){
						subscription.setProduct(product);
						
					}else{
						logger.error(String.format("#getSubscribedPackages -- product %s does not exist in internal DB!", productId.toString()));
						product = new Product();
						product.setCode(rs.getString("productid"));
						product.setName(rs.getString("title"));
						product.setDescription(rs.getString("description"));
						
						subscription.setProduct(product);
					}
					return subscription;
				}
				
			});
			
			if (list != null){
				for (PackageSubscription ps : list){
					if (ps != null) result.add(ps);
				}
			}
			
		} catch (Exception e) {
			logger.error(String.format("#getSubscribedPackages >> error occured when retrieving subscribed packages for subscriber= %s from OSSDB", subscriberId), e);
		}
		return result;
	}
	
	@Override
	public List<PackageSubscription> getSubscribedPackages(String subscriberId, final String langCode) {

		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			return getSubscribedPackages(subscriberId, langCode, eposJdbc);
		} else {
			return getSubscribedPackages(subscriberId, langCode, eposVasJdbcDev);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.EposDbClient#getSubscribedPackages(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<PackageSubscription> getSubscribedPackages(String subscriberId, String categoryCode, String langCode) {

		List<PackageSubscription> result = new ArrayList<>();
		
		List<PackageSubscription> list = getSubscribedPackages(subscriberId, langCode);
		for (PackageSubscription ps : list){
			if (ps.getProduct().getCategoryCode().equalsIgnoreCase(categoryCode)) result.add(ps);
		}
		return result;
	}

	private PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId, final String langCode, JdbcTemplate jdbcTemplate) {
		final String defaultSql = "select b.isdn, b.registerdate, b.expirationdate, b.unregisterdate, b.status, a.productid, a.title, a.description, a.content, a.price "
				+ "from owner_sdp2.productentry a, owner_sdp2.subscriberproduct b where a.productid = b.productid and b.isdn=? and b.productid = ?";
		
		final String sql = sqlSrc.getProperty("sql.epos.getpackagedetails", defaultSql);
		
		PackageSubscription subscription = null;
		try {
			
			List<PackageSubscription> list = jdbcTemplate.query(sql, 
					new String[]{ AppUtils.prependCountryCodeToMsisdn(subscriberId, AppDefaultValues.COUNTRY_CODE), packageId }, 
					new RowMapper<PackageSubscription>() {

				@Override
				public PackageSubscription mapRow(ResultSet rs, int rowNum) throws SQLException {
					Date startDate = rs.getDate("registerdate");
					Date expDate = rs.getDate("expirationdate");
					Date endDate = rs.getDate("unregisterdate");
					Object productId = rs.getObject("productid");
					int status = rs.getInt("status");
					
					PackageSubscription subscription = new PackageSubscription();
					subscription.setEndDate(endDate);
					subscription.setEndDateAsString(AppUtils.dateToString(endDate, AppDefaultValues.DATE_TIME_FORMAT));
					subscription.setExpDate(expDate);
					subscription.setExpDateAsString(AppUtils.dateToString(expDate, AppDefaultValues.DATE_TIME_FORMAT));
					
					subscription.setStartDate(startDate);
					subscription.setStartDateAsString(AppUtils.dateToString(startDate, AppDefaultValues.DATE_TIME_FORMAT));
					
					if (status == SubscriptionStatus.ACTIVE.ordinal() || endDate == null){
						subscription.setStatus(SubscriptionStatus.ACTIVE);
					}else{
						subscription.setStatus(SubscriptionStatus.EXPIRED);
					}

					Product product = productManagementService.getProductDetailsByCode(productId.toString(), langCode);
					//update 20170527 --- ammended on 20170715
					//only add products that exist on both self-care and eposdb
					if (product != null){
						subscription.setProduct(product);
					
					}else{
						logger.error(String.format("#getSubscribedPackages -- product %s does not exist in internal DB!", productId.toString()));
						product = new Product();
						product.setCode(rs.getString("productid"));
						product.setName(rs.getString("title"));
						product.setDescription(rs.getString("description"));
						
						subscription.setProduct(product);
					}
					return subscription;
				}
			});
			
			if (list != null && list.size() > 0){
				subscription = list.get(0);
			}
			
		} catch (Exception e) {
			logger.error("#getPackageSubscriptionDetails -- error occured when retrieving package subscription details from OSSDB", e);
		}
		return subscription;
	}
	
	@Override
	public PackageSubscription getPackageSubscriptionDetails(String subscriberId, String packageId, final String langCode) {
		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			return getPackageSubscriptionDetails(subscriberId, packageId, langCode, eposJdbc);
		} else {
			return getPackageSubscriptionDetails(subscriberId, packageId, langCode, eposVasJdbcDev);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.EposDbClient#getPackageSubscriptionStatus(java.lang.String, java.lang.String)
	 */
	@Override
	public SubscriptionStatus getPackageSubscriptionStatus(String subscriberId, String packageId) {
		PackageSubscription pkg = getPackageSubscriptionDetails(subscriberId, packageId, null);
		return pkg != null ? pkg.getStatus() : SubscriptionStatus.INACTIVE;
	}

	private SubscriberType getSubscriberType(String msisdn, JdbcTemplate jdbcTemplate) {
		int count = 0;
		try {
			count = jdbcTemplate.queryForObject(sqlSrc.getProperty("sql.epos.getsubscribertype", 
					"select count(1) from epos2.mc_subscriber a where  a.mdn = ? and a.status = 1"), 
					new String[]{ msisdn }, Integer.class);
			
		} catch (Exception e) {
			logger.error("#getSubscriberType >> error querying subscriber type for MSISDN= " + msisdn, e);
		}
		//From Vu Van Kien: if record count > 0 then that is EPOS/prepaid type else record count = 0 that is  Post paid type
		return count > 0 ? SubscriberType.PREPAID:SubscriberType.POSTPAID;
	}
	
	@Override
	public SubscriberType getSubscriberType(String msisdn) {
		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			return getSubscriberType(msisdn, eposJdbc);
		} else {
			return getSubscriberType(msisdn, eposJdbcDev);
		}
	}
	
	private String lookupIMSI(String msisdn, JdbcTemplate jdbcTemplate) {
		try {
			List<String> list= jdbcTemplate.query(sqlSrc.getProperty("sql.epos.lookupimsi", "select a.imsi from epos2.mc_subscriber a where a.mdn = ?"), 
					new String[]{ msisdn }, new RowMapper<String>(){

						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							return rs.getString(1);
						}
				
			});
			
			if (list != null && list.size() > 0) return list.get(0);
			
		} catch (Exception e) {
			logger.error("#lookupIMSI >> error querying IMSI for MSISDN= " + msisdn, e);
		}

		return null;
	}

	@Override
	public String lookupIMSI(String msisdn) {
		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			return lookupIMSI(msisdn, eposJdbc);
		} else {
			return lookupIMSI(msisdn, eposJdbcDev);
		}
	}

	private String lookupMSISDN(String imsi, JdbcTemplate jdbcTemplate) {
		
		String _defSql = "select '84'|| substr(b.mdn,2) as mdn from nms2.stock_sim a, epos2.mc_subscriber b where a.serial=b.serial and a.imsi = ?";
		try {
			
			return jdbcTemplate.queryForObject(sqlSrc.getProperty("sql.epos.lookupmsisdn", _defSql), new String[]{ imsi }, String.class);
			
		} catch (EmptyResultDataAccessException e) {
			logger.error("#lookupMSISDN >> MSISDN not found for IMSI= " + imsi);
		} catch (Exception e){
			logger.error("#lookupMSISDN >> error occured when querying MSISDN for IMSI= " + imsi, e);
		}
		return null;	
	}
	
	@Override
	public String lookupMSISDN(String imsi) {
		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			return lookupMSISDN(imsi, eposJdbc);
		} else {
			return lookupMSISDN(imsi, eposJdbcDev);
		}
	}

	private String getSubscriberName(String msisdn, JdbcTemplate jdbcTemplate) {
		String _defSql = "select b.full_name from epos2.mc_subscriber a, epos2.mc_customer b where  a.mdn = ? and a.status = 1 and a.customer_id = b.customer_id";
		
		try {
			
			return jdbcTemplate.queryForObject(sqlSrc.getProperty("sql.epos.getsubscribername", _defSql), new String[]{ msisdn }, String.class);
			
		} catch (EmptyResultDataAccessException e) {
			logger.error("#getSubscriberName >> MSISDN not registered= " + msisdn);
		} catch (Exception e){
			logger.error("#getSubscriberName >> error occured when querying full_name for MSISDN= " + msisdn, e);
		}
		return null;
		
	}
	
	@Override
	public String getSubscriberName(String msisdn) {
		targetEnv = env.getProperty("datasource.eposdb.targetenv", TARGET_ENV_PROD);	
		
		if (targetEnv.equalsIgnoreCase(TARGET_ENV_PROD)) {
			return getSubscriberName(msisdn, eposJdbc);
		} else {
			return getSubscriberName(msisdn, eposJdbcDev);
		}
	}

}
