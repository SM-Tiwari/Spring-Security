/**
 * WebPortalSecurityConfig.java
 */
package com.gnv.vnm.selfcare.webportal.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gnv.vnm.selfcare.core.security.SelfCareUserDetailsService;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.dao.repo.LoginHistoryRepository;
import com.gnv.vnm.selfcare.webportal.auth.GamifyTokenLoginAuthenticationFilter;
import com.gnv.vnm.selfcare.webportal.auth.GamifyTokenLoginSuccessHandler;
import com.gnv.vnm.selfcare.webportal.auth.WebPortalLoginSuccessHandler;
import com.gnv.vnm.selfcare.webportal.auth.WebPortalLogoutHandler;

/**
 * @author nandipinto
 *
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebPortalSecurityConfig extends GlobalAuthenticationConfigurerAdapter {

	@Configuration
    @Order(1)
	public static class GamifyTokenLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Autowired ApplicationConfigurationService applicationConfigurationService;
		@Autowired WebPortalLogoutHandler webPortalogoutSuccessHandler;
		@Autowired LoginHistoryRepository loginHistoryRepository;

		@Autowired
		Environment env;

		public boolean requiresSecuredChannel() {
			try {
				return Boolean.parseBoolean(env.getProperty("app.requirehttps", "false"));
			} catch (Exception e) {
				return false;
			}
		}

		/* (non-Javadoc)
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
		 */
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/static/**");
			web.ignoring().antMatchers("/images/**");
		}

		/* (non-Javadoc)
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
		 */
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.addFilterBefore(gamifyTokenLoginAuthenticationFilter(), 
					UsernamePasswordAuthenticationFilter.class).exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {

					@Override
					public void commence(HttpServletRequest request, HttpServletResponse response,
							AuthenticationException authException) throws IOException, ServletException {

						 response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
					}
				}).accessDeniedPage("/denied");

			http.csrf().disable();
			http.formLogin().disable();

			if (requiresSecuredChannel()) {
				http.requiresChannel().anyRequest().requiresSecure();
			}

			http.antMatcher("/tokenLogin**")
				.authorizeRequests()
					.antMatchers("/*").permitAll()
					.antMatchers("/getotp/**").permitAll()
					.antMatchers("/denied**").permitAll()
					.antMatchers("/lp/**").permitAll()
					.antMatchers("/secure/**").fullyAuthenticated()
					.and()
				.logout().logoutUrl("/logout").permitAll()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/login")
					.logoutSuccessHandler(webPortalogoutSuccessHandler)
					.clearAuthentication(true)
					.and().exceptionHandling().accessDeniedPage("/denied");
		}

		@Bean
		public GamifyTokenLoginAuthenticationFilter gamifyTokenLoginAuthenticationFilter() throws Exception{
			String landingPage = applicationConfigurationService.get("httptokenlogin.landingpage.gamify", "/secure/dashboard").toString();
			GamifyTokenLoginSuccessHandler gamifyTokenLoginSuccessHandler = new GamifyTokenLoginSuccessHandler(landingPage, loginHistoryRepository);

			GamifyTokenLoginAuthenticationFilter gamifyTokenLoginAuthenticationFilter = new GamifyTokenLoginAuthenticationFilter();
			gamifyTokenLoginAuthenticationFilter.setAuthenticationSuccessHandler(gamifyTokenLoginSuccessHandler);

			return gamifyTokenLoginAuthenticationFilter;
		}

	}

	@Configuration
    @Order(2)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Autowired
//		WebPortalUserDetailsService webPortalUserDetailsService;
		SelfCareUserDetailsService userDetailService;
		@Autowired
		Environment env;
		@Autowired
		PasswordEncoder passwordEncoder;
		
		@Autowired
		WebPortalLoginSuccessHandler webPortalLoginSuccessHandler;
		@Autowired
		WebPortalLogoutHandler webPortalogoutSuccessHandler;
		
		public boolean requiresSecuredChannel() {
			try {
				return Boolean.parseBoolean(env.getProperty("app.requirehttps", "false"));
			} catch (Exception e) {
				return false;
			}
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
		}

		/* (non-Javadoc)
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
		 */
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/static/**");
			web.ignoring().antMatchers("/images/**");
		}

		/* (non-Javadoc)
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
		 */
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http.sessionManagement()
				.invalidSessionUrl("/")
				.sessionAuthenticationErrorUrl("/login?error=session_expired");
//				.maximumSessions(1)
//				.expiredUrl("/login?error=session_expired");

//			http.headers().frameOptions().sameOrigin().cacheControl();
			http.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000); //1yr
			
			if (requiresSecuredChannel()) {
				http.requiresChannel().anyRequest().requiresSecure();
			}

			http.authorizeRequests()
					.antMatchers("/*").permitAll()
					.antMatchers("/login**").permitAll()
					.antMatchers("/shop/**").permitAll()
					.antMatchers("/lp/**").permitAll()
					.antMatchers("/store/**").permitAll()
					.antMatchers("/secure/**").fullyAuthenticated()
					.and()
				.formLogin()
					.loginPage("/login").permitAll()
					.loginProcessingUrl("/login").failureUrl("/login?error=bad_credentials")
					.defaultSuccessUrl("/secure/dashboard")
					.successHandler(webPortalLoginSuccessHandler) //TODO
					.and()
				.logout().logoutUrl("/logout").permitAll()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/")
					.invalidateHttpSession(false)	//session will be invalidated by LogoutHandler
					.logoutSuccessHandler(webPortalogoutSuccessHandler)
					.and().exceptionHandling().accessDeniedPage("/denied");
		}
		
		/*
		@Bean
		public AuthenticationSuccessHandler authenticationSuccessHandler() {
			SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler = new SavedRequestAwareAuthenticationSuccessHandler();
			authenticationSuccessHandler.setUseReferer(true);
			authenticationSuccessHandler.setDefaultTargetUrl("/secure/dashboard");
			authenticationSuccessHandler.setAlwaysUseDefaultTargetUrl(true);
			return authenticationSuccessHandler;
		}
		*/
	}
}
