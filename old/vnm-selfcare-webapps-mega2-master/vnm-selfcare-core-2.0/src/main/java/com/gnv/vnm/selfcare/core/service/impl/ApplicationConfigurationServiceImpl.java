/**
 * ApplicationConfigurationServiceImpl.java
 */
package com.gnv.vnm.selfcare.core.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.gnv.vnm.selfcare.core.AppDefaultValues;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.AppConfigEntity;
import com.gnv.vnm.selfcare.dao.entity.QAppConfigEntity;
import com.gnv.vnm.selfcare.dao.repo.AppConfigRepository;

/**
 * @author nandipinto
 *
 */

@Service("applicationConfigurationService")
public class ApplicationConfigurationServiceImpl implements ApplicationConfigurationService {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationConfigurationServiceImpl.class);
	
	private static final String DEFAULT_APP_CONFIG = "config/app-config.properties";

	@Autowired
	private AppConfigRepository appConfigRepository;
	private Hashtable<String, Object> configs = new Hashtable<>();
	
	@PostConstruct
	public void initService() throws Exception{
		loadAll();
	}
	
	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#loadAll()
	 */
	@Override
	public Hashtable<String, Object> loadAll() {
		//try loading application configuration from database...
		long count = appConfigRepository.count();
		if (count == 0){
			//this should only happen when application run for the first time
			//load default configuration from properties file and populate its contents to DB
			InputStream input = null;
			try {
				LoggingUtil.debug(logger, "Loading application config from properties file...");
				
				input = getClass().getClassLoader().getResourceAsStream(DEFAULT_APP_CONFIG);
				Properties p = new Properties();
				p.load(input);
				
				LoggingUtil.debug(logger, "Loaded application config from properties file= " + p);
				
				Enumeration<?> keys = p.keys();
				List<AppConfigEntity> list = new ArrayList<>();
				while (keys.hasMoreElements()){
					String key = (String) keys.nextElement();
					String value = p.getProperty(key, "");
					configs.put(key, value);
					
					int flag = value.equalsIgnoreCase("false") || value.equalsIgnoreCase("true") ? 1:0;
					list.add(new AppConfigEntity(key, value, flag));
				}
				appConfigRepository.save(list);
			} catch (Exception e) {
				logger.error("#initiate >> error loading default application configuration from properties file!", e);
			} finally{
				if (input != null){
					try {
						input.close();
					} catch (Exception e2) {}
				}
			}
		}else{
			//populate the hash table with values from DB
			configs.clear();
			Iterable<AppConfigEntity> list = appConfigRepository.findAll(QAppConfigEntity.appConfigEntity.name.asc());
			for (AppConfigEntity c:list){
				configs.put(c.getName(), c.getValue() != null ? c.getValue():""); //Hashtable does not allow Null keys or values
			}
		}
		return configs;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#getValue(java.lang.String)
	 */
	@Override
	public Object get(String key, Object defaultValue) {
		Object value = configs.get(key);
		return value != null ? value : defaultValue;
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#reload()
	 */
	@Override
	@Scheduled(fixedDelayString = "${app.config.reloadinterval:300000}")
	public void reload() {
		loadAll();
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public void update(String key, Object value) {
		if (key == null || value == null) return;
		
		if (configs == null) configs = new Hashtable<>(); //this should not happen
		
		try {
			configs.put(key, value);
			//update configuration on database as well
			AppConfigEntity config = appConfigRepository.findOne(QAppConfigEntity.appConfigEntity.name.eq(key));
			if (config != null){
				config.setValue(value.toString());
				appConfigRepository.saveAndFlush(config);
			}
		} catch (Exception e) {
			logger.error("#update >> error updating application config= " + key, e);
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#update(java.util.Hashtable)
	 */
	@Override
	public void update(Hashtable<String, Object> hashTable) {
		if (hashTable == null || hashTable.isEmpty()) return;
		
		Properties p = new Properties();
		Enumeration<String> keys = hashTable.keys();
		while (keys.hasMoreElements()){
			String key = keys.nextElement();
			Object value = hashTable.get(key);
			update(key, value);
		}

		//TODO update properties file as well?
		OutputStream out = null;
		try {
			String configLocation = getClass().getClassLoader().getResource(DEFAULT_APP_CONFIG).getFile();
			if (configLocation != null){
				out = new FileOutputStream(configLocation);
				p.store(out, "#this is default application configuration, last updated on " + new Date());
			}
		} catch (Exception e) {
			logger.error("#update >> error occured when storing default application configuration!", e);
		} finally{
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#getDefaultCountryCode()
	 */
	@Override
	public String getDefaultCountryCode() {
		return this.get("countrycode.default", AppDefaultValues.COUNTRY_CODE).toString();
	}

	/* (non-Javadoc)
	 * @see com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService#getDefaultLanguageCode()
	 */
	@Override
	public String getDefaultLanguageCode() {
		return this.get("language.default", AppDefaultValues.LANGUAGE_VIETNAMESE).toString();
	}

	
	@Override
	public Object get(String key, Object defaultValue, boolean forceRefresh) {
		Object value = null;
		if (forceRefresh) {
			try {
				AppConfigEntity config = appConfigRepository.findOne(QAppConfigEntity.appConfigEntity.name.eq(key));
				value = config != null ? config.getValue() : null;
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			value = configs.get(key);
		}
		return value != null ? value : defaultValue;
	}
	
}
