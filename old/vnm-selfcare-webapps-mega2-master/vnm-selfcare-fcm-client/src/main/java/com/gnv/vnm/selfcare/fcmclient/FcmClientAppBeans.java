/**
 * 
 */
package com.gnv.vnm.selfcare.fcmclient;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author nandipinto
 *
 */

@Configuration
public class FcmClientAppBeans implements SchedulingConfigurer{
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskScheduler());
	}
	
	@Bean(destroyMethod = "shutdown")
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("fcmClientScheduler-");
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		scheduler.initialize();
		return scheduler;
	}

	@Bean("dataSource")
	@ConfigurationProperties(prefix = "fcmclient.db")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

}
