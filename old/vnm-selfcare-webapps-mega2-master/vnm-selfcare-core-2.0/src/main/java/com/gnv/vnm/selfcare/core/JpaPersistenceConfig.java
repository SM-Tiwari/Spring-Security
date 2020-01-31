/**
 * JpaPersistenceConfig.java
 */
package com.gnv.vnm.selfcare.core;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author nandipinto
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@EnableJpaRepositories(basePackages = "com.gnv.vnm.selfcare.dao.repo")
public class JpaPersistenceConfig implements TransactionManagementConfigurer{
	
	static final String ENTITY_PKG = "com.gnv.vnm.selfcare.dao.entity";
	static final String PERSISTENCE_UNIT_NAME = "selfcare-jpa";

	@Autowired 
	private Environment env;

	@Override
	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		// transactionManager.setEntityManagerFactory(entityManagerFactory().getNativeEntityManagerFactory());
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(selfcareDataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(ENTITY_PKG);
		entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

		String dialect = env.getProperty("datasource.selfcare.hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		String hbm2ddlAuto = env.getProperty("datasource.selfcare.hibernate.hbm2ddl.auto", "update");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect);
		jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, hbm2ddlAuto);
		
		//fix for this warning message from Hibernate: JDBC Connection to reset not identical to originally prepared Connection
		//"hibernate.connection.release_mode" should be set to "on_close"
		jpaProperties.put(org.hibernate.cfg.Environment.RELEASE_CONNECTIONS, "on_close"); 
		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(selfcareDataSource()).buildSessionFactory();
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean(name = "selfcareDataSource")
	public DataSource selfcareDataSource(){
		DataSource dataSource = new DataSource();
		
        PoolProperties p = new PoolProperties();
        p.setUrl(env.getRequiredProperty("datasource.selfcare.url"));
        p.setDriverClassName(env.getRequiredProperty("datasource.selfcare.driverclassname"));
        p.setUsername(env.getRequiredProperty("datasource.selfcare.username"));
        p.setPassword(env.getRequiredProperty("datasource.selfcare.password"));
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery(env.getProperty("datasource.selfcare.connectionvalidationsql", "SELECT 1 from DUAL"));
        p.setTestOnReturn(false);

        long validationInterval = Long.parseLong(env.getProperty("datasource.selfcare.connpool.validationinterval", "0"));
        int timeBetweenEviction = Integer.parseInt(env.getProperty("datasource.selfcare.connpool.timebetweenbvictionruns", "0"));
        int maxWait = Integer.parseInt(env.getProperty("datasource.selfcare.connpool.maxwait", "0"));
        int minEvictableIdleTime = Integer.parseInt(env.getProperty("datasource.selfcare.connpool.minevictableidletime", "30"));
        int removeAbandonedTimeout = Integer.parseInt(env.getProperty("datasource.selfcare.connpool.removeabandonedtimeout", "60"));
        	
        if (validationInterval > 0) p.setValidationInterval(validationInterval * 1000);
        if (timeBetweenEviction > 0) p.setTimeBetweenEvictionRunsMillis(timeBetweenEviction * 1000);
        if (maxWait > 0) p.setMaxWait(maxWait * 1000);
        if (minEvictableIdleTime > 0) p.setMinEvictableIdleTimeMillis(minEvictableIdleTime * 1000);
        
        if (removeAbandonedTimeout > 0) p.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        
        p.setInitialSize(Integer.parseInt(env.getProperty("datasource.selfcare.connpool.initialsize", "50")));
        p.setMaxActive(Integer.parseInt(env.getProperty("datasource.selfcare.connpool.maxactive", "100")));
        p.setMinIdle(Integer.parseInt(env.getProperty("datasource.selfcare.connpool.minidle", "10")));
        
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(env.getProperty("datasource.selfcare.connpool.interceptors"));
        
        dataSource.setPoolProperties(p);
        
		return dataSource;
	}
}
