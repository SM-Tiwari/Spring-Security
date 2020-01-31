/**
 * ApplicationConfigurationService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.Hashtable;

/**
 * @author nandipinto
 *
 */
public interface ApplicationConfigurationService {

	Hashtable<String, Object> loadAll();
	
	Object get(String key, Object defaultValue);
	  
	Object get(String key, Object defaultValue, boolean forceRefresh);  
	
	void reload();
	
	void update(String key, Object value);
	
	void update(Hashtable<String, Object> hashTable);
	
	String getDefaultCountryCode();
	
	String getDefaultLanguageCode();
	
}
