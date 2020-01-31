/**
 * WebPortalAppConfig.java
 */
package com.gnv.vnm.selfcare.webportal.config;

import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.gnv.vnm.selfcare.core.security.SimplePasswordEncoder;

/**
 * @author nandipinto
 *
 */

@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAsync
@ComponentScan(basePackages = "com.gnv.vnm.selfcare.webportal")
public class WebPortalAppConfig extends WebMvcConfigurerAdapter {
	
	static final int TASK_SCHEDULER_POOL_SIZE = 100;

	private static final String MESSAGE_SOURCE 	= "/WEB-INF/i18n/messages";
	private static final String LABEL 			= "/WEB-INF/i18n/label";
	private static final String PAGE_CONTENT 	= "/WEB-INF/i18n/pagecontent";
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new SimplePasswordEncoder();
	}

	/*
    @Bean 
    public CharacterEncodingFilter characterEncodingFilter() { 
        CharacterEncodingFilter filter = new CharacterEncodingFilter(); 
        filter.setEncoding("UTF-8"); 
        filter.setForceEncoding(true); 
        return filter; 
    } 
    */
	
	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(MESSAGE_SOURCE, LABEL, PAGE_CONTENT);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(5);
		return messageSource;
	}

	@Bean
	public SessionLocaleResolver localeResolver() {
		/*
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setCookieName("selfcareLocaleCookie");
		resolver.setCookieMaxAge(60 * 60);
		*/
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("vi"));
		return localeResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		registry.addInterceptor(interceptor); //.addPathPatterns("/*");
	}

	@Bean
	public ViewResolver tilesViewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
		return tilesConfigurer;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
		super.configureMessageConverters(converters);
	}

	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setDefaultErrorView("ErrorPage");

		// TODO create ErrorPage(s)
		Properties exceptionMappings = new Properties();
		exceptionMappings.put("java.lang.Exception", "ErrorPage");
		exceptionMappings.put("java.lang.RuntimeException", "ErrorPage");

		exceptionResolver.setExceptionMappings(exceptionMappings);

		Properties statusCodes = new Properties();

		statusCodes.put("ErrorPage", "404");
		statusCodes.put("ErrorPage", "500");

		exceptionResolver.setStatusCodes(statusCodes);

		return exceptionResolver;
	}
	
	@Bean(name="multipartResolver")
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxUploadSize(10 * 1024 * 1024); //10MB
        return commonsMultipartResolver;
	}
	
	/*
    @Bean(destroyMethod = "shutdown")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("springTaskScheduler-");
        scheduler.setPoolSize(TASK_SCHEDULER_POOL_SIZE);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
		return scheduler;
    }
    */
}
