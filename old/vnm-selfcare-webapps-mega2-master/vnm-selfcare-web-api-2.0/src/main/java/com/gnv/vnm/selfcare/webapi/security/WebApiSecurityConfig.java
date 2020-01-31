/**
 * Mar 12, 2018 5:49:52 PM
 */
package com.gnv.vnm.selfcare.webapi.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.gnv.vnm.selfcare.core.security.SelfCareUserDetailsService;
import com.gnv.vnm.selfcare.core.security.SimplePasswordEncoder;

/**
 * @author nandipinto
 *
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SelfCareUserDetailsService userDetailsService;
	@Autowired
	SimplePasswordEncoder passwordEncoder;
	
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
	*/
    
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
    
    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}
	
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
        	.csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/home**").permitAll()
           /* .antMatchers("/getVnmVersion/**").permitAll()
            .antMatchers("/autosigninwithip**").permitAll()
            .antMatchers("/login**").permitAll()
            .antMatchers("/register**").permitAll()
            .antMatchers("/validatenumbers**").permitAll()
            .antMatchers("/activate/**").permitAll()
            .antMatchers("/subscriberexists/**").permitAll()
            .antMatchers("/getotp/**").permitAll()
            .antMatchers("/isvalidotp/**").permitAll()
            .antMatchers("/sendsms/**").permitAll()
            .antMatchers("/store/**").permitAll()
            .antMatchers("/product/**").permitAll()
            .antMatchers("/content/**").permitAll()
            .antMatchers("/sysconfig/**").permitAll()
            .antMatchers("/pg/**").permitAll()
            .antMatchers("/updatetoken**").permitAll()
            .antMatchers("/getAllOperatorPrefix**").permitAll()
            .antMatchers("/pushedcampaign/unreadcount/**").permitAll() //
            .antMatchers("/pushedcampaign/setreadall/**").permitAll()*/
            .anyRequest().authenticated();
                
        security.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        security.headers().cacheControl();
    }
    
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedMethods(Arrays.asList("POST, PUT, GET, OPTIONS, DELETE"));

		configuration.addAllowedOrigin("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
