/**
 * Mar 12, 2018 8:53:10 PM
 */
package com.gnv.vnm.selfcare.webapi.security;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gnv.vnm.selfcare.core.security.AuthConstants;
import com.gnv.vnm.selfcare.core.security.SelfCareUser;
import com.gnv.vnm.selfcare.core.security.SelfCareUserDetailsService;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

/**
 * @author nandipinto
 *
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Autowired
	private SelfCareUserDetailsService userDetailsService;
	@Autowired
	private ApplicationConfigurationService applicationConfigService;

	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("path is ---="+request.getRequestURI().substring(request.getContextPath().length()));
		System.out.println("---------------------------" + request.getHeader(AuthConstants.JWT_HEADER_NAME));
		String header = request.getHeader(AuthConstants.JWT_HEADER_NAME);
		LoggingUtil.debug(logger, "#doFilterInternal --- filtering request from remote host= " + request.getRemoteAddr()
				+ ", auth_header= " + header);

		String username = null;
		String authToken = null;
		if (header != null && header.startsWith(AuthConstants.JWT_PREFIX)) {
			authToken = header.replace(AuthConstants.JWT_PREFIX, "");
			try {
				username = getJwtTokenUtil().getUsernameFromToken(authToken);
				System.out.println("  User Name ===" + username);
			} catch (IllegalArgumentException e) {
				System.out.println("------------" + e);
				logger.error("an error occured during getting username from token", e);
			} catch (ExpiredJwtException e) {
				System.out.println("++++" + e);
				logger.warn("the token is expired and not valid anymore", e);
			} catch (SignatureException e) {
				System.out.println("=======" + e);
				logger.error("Authentication Failed. Username or Password not valid.");
			}
		} else {
			logger.warn("Authentication header not found, rejecting request.");
		}

		LoggingUtil.debug(logger, "#doFilterInternal --- user name from token= " + username + ", current auth obj= "
				+ SecurityContextHolder.getContext().getAuthentication());
		if (username != null) {

			if (SecurityContextHolder.getContext().getAuthentication() == null) {
				if (getJwtTokenUtil().validateToken(authToken, username)) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());

					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					logger.info("User " + username + " is authenticated, setting security context.");

					SecurityContextHolder.getContext().setAuthentication(authentication);

					response.setHeader(AuthConstants.JWT_HEADER_NAME, getJwtTokenUtil().refreshToken(authToken));
				}
			}
		} else {
			if ((header != null) && (header.startsWith(AuthConstants.JWT_PREFIX))) {
				String token = header.replace(AuthConstants.JWT_PREFIX, "");
				/*
				 * Base64 decode .
				 */
				byte[] decoded = Base64.getMimeDecoder().decode(token);
				String tokenWithTime = new String(decoded);
				if (tokenWithTime.contains("@")) {
					boolean requestTimeStatus = false;
					String[] tokenAndRequestTimeArray = tokenWithTime.split("@");
					/*
					 * get token from request .
					 */
					token = tokenAndRequestTimeArray[0];
					/*
					 * get timeInMiliSecound from request .
					 */
					if (tokenAndRequestTimeArray[1] != null) {
						/*
						 * based on request Time and current Time check status .
						 * If requestTime is greater then current time then request is valid otherwise request is not valid
						 * we increase one minute from request Time.
						 */
						requestTimeStatus = checkRequestTimeStatus(Long.parseLong(tokenAndRequestTimeArray[1].trim()));
					}
					boolean tokenIsValid = checkGuestUserAccessToken(token);
					System.out.println("token Valid Status:::"+tokenIsValid+" requestTimeStatus ::"+requestTimeStatus);
					if (tokenIsValid && requestTimeStatus) {
						jwtAuthenticationForGuest(request);
						response.setHeader(AuthConstants.JWT_HEADER_NAME,request.getHeader(AuthConstants.JWT_HEADER_NAME));
					}
				}
			}
		}

		filterChain.doFilter(request, response);
	}

	private JwtTokenUtil getJwtTokenUtil() {
		if (jwtTokenUtil == null) {
			String issuer = applicationConfigService.get("security.token.issuer", AuthConstants.JWT_ISSUER).toString();
			String signature = applicationConfigService.get("security.token.signature", AuthConstants.JWT_SIGNATURE)
					.toString();
			long expiration = Long.parseLong(applicationConfigService
					.get("security.token.expirationinminutes", AuthConstants.TOKEN_VALIDITY_IN_MINUTES).toString());

			jwtTokenUtil = new JwtTokenUtil(issuer, signature, expiration * 60 * 60 * 1000);
		}

		return jwtTokenUtil;
	}

	/**
	 * This Method used for guest user Authentication
	 * 
	 * @param HttpServletRequest
	 */
	public void jwtAuthenticationForGuest(HttpServletRequest request) {
		logger.info("In JwtAuthenticationFilter jwtAuthenticationForGuest method call");
		try {
			String authToken = AuthConstants.GUEST_USER_TOKEN.replace(AuthConstants.JWT_PREFIX, "");
			String username = getJwtTokenUtil().getUsernameFromToken(authToken);
			if (SecurityContextHolder.getContext().getAuthentication() == null) {
				if (getJwtTokenUtil().validateTokenWithOutExpireds(authToken, username)) {
					UserDetails userDetails = userDetailsService.loadGuestByUserName(username,
							AuthConstants.GUEST_USER_CREDINTIAL);

					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					logger.info("User " + username + " is authenticated, setting security context.");

					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * This method used for check guest user token based on token
	 * 
	 * @param headerToken
	 * @return {@link Boolean}
	 */
	public boolean checkGuestUserAccessToken(String token) {
		boolean status = false;
		try {
			String[] tokens = {"byB1WXVE285JAHAW","JCm6qdXfBMXaHHuF","TgEPLTi1g7PzwrYz","aKtzlBrc7mFQ8Da4",
	                "NFeUfKz5kXb936ac","Xe1PhZdGOWTw4Wmp","2fadIysa6bRse22H" };
			for (int index = 0; index < tokens.length; index++) {
				if (tokens[index].toUpperCase().trim().equalsIgnoreCase(token.toUpperCase().trim())) {
					status = true;
					return status;
				}
			}
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		return status;
	}

	/**
	 * check request time status based on currentTime and request time .
	 * 
	 * @param requestTime
	 */
	public boolean checkRequestTimeStatus(long requestTime) {
		boolean requestTimeStatus = false;
		try {
			long currentTimeInMiliSecounds = AuthConstants.getCurrentTimeInMiliSecounds();
			System.out.println("current Time Is ::"+currentTimeInMiliSecounds+" request time :::"+requestTime);
			requestTime = requestTime + AuthConstants.MILISECOUNDS_IN_ONE_MINUTE*5;
			System.out.println("request increase  Time one minute  ::"+requestTime);
			if (requestTime >= currentTimeInMiliSecounds) {
				requestTimeStatus = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return requestTimeStatus;
	}
}
