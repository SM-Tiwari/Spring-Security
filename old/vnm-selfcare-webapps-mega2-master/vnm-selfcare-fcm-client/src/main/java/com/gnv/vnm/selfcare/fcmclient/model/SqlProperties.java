/**
 * May 18, 2018 5:39:16 PM
 */
package com.gnv.vnm.selfcare.fcmclient.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author nandipinto
 *
 */

@Component
@ConfigurationProperties(prefix = "fcmclient.sql")
public class SqlProperties {

	private String retrieveAllAppConfigSql;
	private String retrieveAllLmsConfigSql;
	private String lookupAppConfigValueSql;
	private String lookupLmsConfigValueSql;
	private String fetchMessagesSql;
	private String fetchMessageForUserSql;
	private String messageCountSql;
	private String updateSentCounterSql;
	private String retrieveFcmTokenSql;
	private String userLanguageSql;
	
	
	/**
	 * @return the retrieveAllAppConfigSql
	 */
	public String getRetrieveAllAppConfigSql() {
		return retrieveAllAppConfigSql;
	}
	/**
	 * @param retrieveAllAppConfigSql the retrieveAllAppConfigSql to set
	 */
	public void setRetrieveAllAppConfigSql(String retrieveAllAppConfigSql) {
		this.retrieveAllAppConfigSql = retrieveAllAppConfigSql;
	}
	/**
	 * @return the retrieveAllLmsConfigSql
	 */
	public String getRetrieveAllLmsConfigSql() {
		return retrieveAllLmsConfigSql;
	}
	/**
	 * @param retrieveAllLmsConfigSql the retrieveAllLmsConfigSql to set
	 */
	public void setRetrieveAllLmsConfigSql(String retrieveAllLmsConfigSql) {
		this.retrieveAllLmsConfigSql = retrieveAllLmsConfigSql;
	}
	/**
	 * @return the lookupAppConfigValueSql
	 */
	public String getLookupAppConfigValueSql() {
		return lookupAppConfigValueSql;
	}
	/**
	 * @param lookupAppConfigValueSql the lookupAppConfigValueSql to set
	 */
	public void setLookupAppConfigValueSql(String lookupAppConfigValueSql) {
		this.lookupAppConfigValueSql = lookupAppConfigValueSql;
	}
	/**
	 * @return the lookupLmsConfigValueSql
	 */
	public String getLookupLmsConfigValueSql() {
		return lookupLmsConfigValueSql;
	}
	/**
	 * @param lookupLmsConfigValueSql the lookupLmsConfigValueSql to set
	 */
	public void setLookupLmsConfigValueSql(String lookupLmsConfigValueSql) {
		this.lookupLmsConfigValueSql = lookupLmsConfigValueSql;
	}
	/**
	 * @return the fetchMessagesSql
	 */
	public String getFetchMessagesSql() {
		return fetchMessagesSql;
	}
	/**
	 * @param fetchMessagesSql the fetchMessagesSql to set
	 */
	public void setFetchMessagesSql(String fetchMessagesSql) {
		this.fetchMessagesSql = fetchMessagesSql;
	}
	/**
	 * @return the fetchMessageForUserSql
	 */
	public String getFetchMessageForUserSql() {
		return fetchMessageForUserSql;
	}
	/**
	 * @param fetchMessageForUserSql the fetchMessageForUserSql to set
	 */
	public void setFetchMessageForUserSql(String fetchMessageForUserSql) {
		this.fetchMessageForUserSql = fetchMessageForUserSql;
	}
	/**
	 * @return the messageCountSql
	 */
	public String getMessageCountSql() {
		return messageCountSql;
	}
	/**
	 * @param messageCountSql the messageCountSql to set
	 */
	public void setMessageCountSql(String messageCountSql) {
		this.messageCountSql = messageCountSql;
	}
	
	/**
	 * @return the updateSentCounterSql
	 */
	public String getUpdateSentCounterSql() {
		return updateSentCounterSql;
	}
	/**
	 * @param updateSentCounterSql the updateSentCounterSql to set
	 */
	public void setUpdateSentCounterSql(String updateSentCounterSql) {
		this.updateSentCounterSql = updateSentCounterSql;
	}
	/**
	 * @return the retrieveFcmTokenSql
	 */
	public String getRetrieveFcmTokenSql() {
		return retrieveFcmTokenSql;
	}
	/**
	 * @param retrieveFcmTokenSql the retrieveFcmTokenSql to set
	 */
	public void setRetrieveFcmTokenSql(String retrieveFcmTokenSql) {
		this.retrieveFcmTokenSql = retrieveFcmTokenSql;
	}
	/**
	 * @return the userLanguageSql
	 */
	public String getUserLanguageSql() {
		return userLanguageSql;
	}
	/**
	 * @param userLanguageSql the userLanguageSql to set
	 */
	public void setUserLanguageSql(String userLanguageSql) {
		this.userLanguageSql = userLanguageSql;
	}
	
	
}
