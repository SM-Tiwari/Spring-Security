/**
 * RootApplicationContext.java
 */
package com.gnv.vnm.selfcare.core;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author nandipinto
 *
 */

@Configuration
@ComponentScan(basePackages = "com.gnv.vnm.selfcare")
@PropertySources({ 
	@PropertySource("classpath:config/security-config.properties"),
	@PropertySource("classpath:config/app-config.properties"),
	@PropertySource("classpath:config/eposdb.properties"),
	@PropertySource("classpath:config/singleview-db.properties"),
	@PropertySource("classpath:config/selfcaredb.properties")
	})
@EnableScheduling
public class SharedApplicationConfig implements SchedulingConfigurer{

	static final int TASK_SCHEDULER_POOL_SIZE = 100;

	@Autowired Environment env;
	
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.annotation.SchedulingConfigurer#configureTasks(org.springframework.scheduling.config.ScheduledTaskRegistrar)
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskScheduler());
	}

	@Bean 
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "eposdbDataSource")
	public DataSource eposdbDataSource(){
		
		DataSource dataSource = new DataSource();
        PoolProperties p = new PoolProperties();
        p.setUrl(env.getProperty("datasource.eposdb.url"));
        p.setDriverClassName(env.getProperty("datasource.eposdb.driverclassname"));
        p.setUsername(env.getProperty("datasource.eposdb.username"));
        p.setPassword(env.getProperty("datasource.eposdb.password"));
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery(env.getProperty("datasource.eposdb.connectionvalidationsql", "SELECT 1 from DUAL"));
        p.setTestOnReturn(false);
        p.setValidationInterval(Long.parseLong(env.getProperty("datasource.eposdb.connpool.validationinterval", "30")) * 1000);
        p.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.timebetweenbvictionruns", "30")) * 1000);
        p.setMaxWait(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.maxwait", "10")) * 1000);
        p.setMinEvictableIdleTimeMillis(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.minevictableidletime", "30")) * 1000);
        
        p.setRemoveAbandonedTimeout(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.removeabandonedtimeout", "60"))); //in seconds

        p.setInitialSize(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.initialsize", "50")));
        p.setMaxActive(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.maxactive", "100")));
        p.setMinIdle(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.minidle", "10")));
        
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(env.getProperty("datasource.eposdb.connpool.interceptors"));
        
        dataSource.setPoolProperties(p);
		return dataSource;
	}
	
	@Bean(name = "eposDevDataSource")
	public DataSource eposDevDataSource() {
		DataSource dataSource = new DataSource();
        
		PoolProperties p = new PoolProperties();
        p.setDriverClassName(env.getProperty("datasource.eposdb.driverclassname"));
        
        p.setUrl(env.getProperty("datasource.eposdbdev.url"));
        p.setUsername(env.getProperty("datasource.eposdbdev.username"));
        p.setPassword(env.getProperty("datasource.eposdbdev.password"));
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery(env.getProperty("datasource.eposdb.connectionvalidationsql", "SELECT 1 from DUAL"));
        p.setTestOnReturn(false);
        p.setValidationInterval(Long.parseLong(env.getProperty("datasource.eposdb.connpool.validationinterval", "30")) * 1000);
        p.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.timebetweenbvictionruns", "30")) * 1000);
        p.setMaxWait(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.maxwait", "10")) * 1000);
        p.setMinEvictableIdleTimeMillis(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.minevictableidletime", "30")) * 1000);
        
        p.setRemoveAbandonedTimeout(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.removeabandonedtimeout", "60"))); //in seconds

        p.setInitialSize(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.initialsize", "50")));
        p.setMaxActive(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.maxactive", "100")));
        p.setMinIdle(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.minidle", "10")));
        
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(env.getProperty("datasource.eposdb.connpool.interceptors"));
        
        dataSource.setPoolProperties(p);
		return dataSource;	
	}
	
	@Bean(name = "eposVasDataSource")
	public DataSource eposVasDataSource() {
		DataSource dataSource = new DataSource();
        
		PoolProperties p = new PoolProperties();
        p.setDriverClassName(env.getProperty("datasource.eposdb.driverclassname"));
        
        p.setUrl(env.getProperty("datasource.eposdbvas.url"));
        p.setUsername(env.getProperty("datasource.eposdbvas.username"));
        p.setPassword(env.getProperty("datasource.eposdbvas.password"));
        p.setJmxEnabled(true);
        p.setTestWhileIdle(false);
        p.setTestOnBorrow(true);
        p.setValidationQuery(env.getProperty("datasource.eposdb.connectionvalidationsql", "SELECT 1 from DUAL"));
        p.setTestOnReturn(false);
        p.setValidationInterval(Long.parseLong(env.getProperty("datasource.eposdb.connpool.validationinterval", "30")) * 1000);
        p.setTimeBetweenEvictionRunsMillis(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.timebetweenbvictionruns", "30")) * 1000);
        p.setMaxWait(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.maxwait", "10")) * 1000);
        p.setMinEvictableIdleTimeMillis(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.minevictableidletime", "30")) * 1000);
        
        p.setRemoveAbandonedTimeout(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.removeabandonedtimeout", "60"))); //in seconds

        p.setInitialSize(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.initialsize", "50")));
        p.setMaxActive(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.maxactive", "100")));
        p.setMinIdle(Integer.parseInt(env.getProperty("datasource.eposdb.connpool.minidle", "10")));
        
        p.setLogAbandoned(true);
        p.setRemoveAbandoned(true);
        p.setJdbcInterceptors(env.getProperty("datasource.eposdb.connpool.interceptors"));
        
        dataSource.setPoolProperties(p);
		return dataSource;	
	}
	
	@Bean(destroyMethod = "shutdown")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setThreadNamePrefix("springTaskExecutor-");
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		return taskExecutor;
	}
	
    @Bean(destroyMethod = "shutdown")
    public TaskScheduler taskScheduler() {
    		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("springTaskScheduler-");
//        scheduler.setPoolSize(TASK_SCHEDULER_POOL_SIZE);
        scheduler.setWaitForTasksToCompleteOnShutdown(false);
		return scheduler;
    }

}
