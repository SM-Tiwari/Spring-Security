/**
 * GamifyTokenLoginAuthenticationFilter.java
 */
package com.gnv.vnm.selfcare.webportal.auth;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.gnv.vnm.selfcare.core.enums.SubscriberStatus;
import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.core.security.TokenProvider;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.QExtAuthTokenEntity;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.repo.ExtAuthTokenRepository;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;

/**
 * @author nandipinto
 *
 */
public class GamifyTokenLoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger logger = LoggerFactory.getLogger(GamifyTokenLoginAuthenticationFilter.class);
	
	private static final String HEADER_NAME = "SELFCARE-AUTH-TOKEN";
	private static final int TOKEN_COUNT	= 5;
	
	private TokenProvider tokenProvider = new TokenProvider();
	
	@Autowired private SubscriberRepository subscriberRepository;
	@Autowired private ExtAuthTokenRepository extAuthTokenRepository;
	@Autowired private ApplicationConfigurationService applicationConfigurationService;

	public GamifyTokenLoginAuthenticationFilter() {
		super(new AntPathRequestMatcher("/tokenLogin", "GET"));
		setAuthenticationManager(new AuthenticationManager() {
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return authentication;
			}
		});
		
		/*
		setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				String landingPage = request.getContextPath() + applicationConfigurationService.get("httptokenlogin.landingpage.gamify", "/dashboard").toString();
				response.sendRedirect(landingPage);
			}
		});
		*/
		
		setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
			
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {

				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			}
		});
	}

	private int getTokenExpirationTime(){
		return Integer.parseInt(applicationConfigurationService.get("security.token.expirationinminutes", "" + TokenProvider.EXPIRATION_MIN).toString());
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String token = request.getHeader(HEADER_NAME);
		LoggingUtil.debug(logger, "#attemptAuthentication --- token from header= " + token);
		
		if (token == null)  throw new AuthenticationServiceException("Expected HTTP header " + HEADER_NAME + " not found!");

		String[] components = tokenProvider.decodeAndDissectToken(token);
		if (components == null || components.length != TOKEN_COUNT) {
			throw new AuthenticationServiceException("Invalid token!");
		}
		
		String msisdn = components[0];
		String extAppId = components[1];
		String extSecretKey = components[2];
		Long timeInMillis = Long.parseLong(components[3]);
		String externalKey = components[4];   				//---> this produces incorrect result when running under Tomcat???
		
		LoggingUtil.debug(logger, "#attemptAuthentication --- userName= " + msisdn
				+ ", appId= " + extAppId
				+ ", secretKey= " + extSecretKey
				+ ", time= " + AppUtils.dateToString(new Date(timeInMillis), "yyyyMMdd HH:mm:ss") 
				+ ", token_key= " + externalKey);

		long count = 0;
		try {
			count = extAuthTokenRepository.count(QExtAuthTokenEntity.extAuthTokenEntity.extAppId.eq(extAppId)
					.and(QExtAuthTokenEntity.extAuthTokenEntity.secretKey.eq(extSecretKey)));
			
		} catch (Exception e) {
			logger.error("#attemptAuthentication --- error validating app_id (" + extAppId + ") to internal db!", e);
		}
		if (count == 0) throw new AuthenticationServiceException("Application ID could not be authenticated!"); 

		String expectedKey = "";
		try {
			expectedKey = tokenProvider.buildTokenKey(msisdn, extAppId, extSecretKey, timeInMillis);
		} catch (NoSuchAlgorithmException e) {
			logger.error("#attemptAuthentication --- " + e.getMessage());
		}

		LoggingUtil.debug(logger,"#attemptAuthentication --- expectedKey= " + expectedKey);

		if (!MessageDigest.isEqual(expectedKey.getBytes("UTF-8"), externalKey.getBytes("UTF-8"))) {
			throw new AuthenticationServiceException("Token could not be authenticated!");
		}

		long delta = (new Date().getTime() - new Date(timeInMillis).getTime()) / (1000 * 60);
		LoggingUtil.debug(logger,"#attemptAuthentication --- delta in minutes= " + delta);
		
		//if (delta > getTokenExpirationTime()) throw new AuthenticationServiceException("Token has expired!");
		
		LoggingUtil.debug(logger, "#attemptAuthentication --- userName from token= " + msisdn);

		if (msisdn == null)  throw new AuthenticationServiceException("Token validation error, User name not found!");
		
		if (!msisdn.startsWith("0")) msisdn = "0" + msisdn;

		SubscriberEntity user = subscriberRepository
				.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(msisdn)
						.and(QSubscriberEntity.subscriberEntity.status.eq(SubscriberStatus.ACTIVE.ordinal())));
		
		if (user != null){
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user.getMsisdn(), user.getCredential(), getGrantedAuthorities());
			authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
			Authentication authentication = this.getAuthenticationManager().authenticate(authRequest);
			
			return authentication;
		}else{
			throw new AuthenticationServiceException("User does not exist!");
		}
		
		/*
		try {
			tokenProvider.setExpiryTimeInMinutes(getTokenExpirationTime());
			
			userName = tokenProvider.getUserFromToken(token);
			
		} catch (NoSuchAlgorithmException e1) {
			throw new AuthenticationServiceException("Token authentication error!");
			
		} catch (UnsupportedEncodingException e){ 
			throw new AuthenticationServiceException("Token authentication error!");
			
		} catch (TokenExpiredException e) {
			throw new AuthenticationServiceException(e.getMessage());
		}
		*/
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(AuthConstants.ROLE_SUBSCRIBER));
		
		return authorities;
	}

}
