/**
 * GamifyTokenLoginSuccessHandler.java
 */
package com.gnv.vnm.selfcare.webportal.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.LoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.repo.LoginHistoryRepository;

/**
 * @author nandipinto
 *
 */

public class GamifyTokenLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GamifyTokenLoginSuccessHandler.class);
	
	private LoginHistoryRepository loginHistoryRepository;
	private String landingPage;
	
	public GamifyTokenLoginSuccessHandler(String landingPage, LoginHistoryRepository loginHistoryRepository){
		this.landingPage = landingPage;
		this.loginHistoryRepository = loginHistoryRepository;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String location = request.getContextPath()  + landingPage;
//		response.sendRedirect(request.getContextPath()  + landingPage);

		//TODO
		try {
			LoginHistoryEntity history = loginHistoryRepository.saveAndFlush(new LoginHistoryEntity(authentication.getName(), new Date(), request.getRemoteAddr(), ClientAppId.WEB_APP.name()));
			LoggingUtil.debug(logger, "#onAuthenticationSuccess --- creating login history for user= " + authentication.getName() + ", login_id= " + history.getId());
			request.getSession(true).setAttribute("LOGIN_ID", history.getId());
			
		} catch (Exception e) {
			logger.error("#onAuthenticationSuccess --- error saving login history!", e);
		}

        if (isUrlAbsolute(location)) {
        		response.sendRedirect(location);
        
        } else {
        		String finalurl = fixForScheme(getPrefix(request) + location);
            LoggingUtil.debug(logger, "#finalURL --- " + finalurl);

            response.sendRedirect(finalurl);
        }
        
	}
	
	public boolean isUrlAbsolute(String url) {
        String lowercaseurl = url.toLowerCase();
        if (lowercaseurl.startsWith("http") == true) {
            return true;
        } else {
            return false;
        }
    }
 
    public String fixForScheme(String url) {
        //alter the url here if you were to change the scheme
        return url;
    }
 
    public String getPrefix(HttpServletRequest request) {
        StringBuffer str = request.getRequestURL();
        String url = str.toString();
        String uri = request.getRequestURI();
        int offset = url.indexOf(uri);
        String prefix_t = url.substring(0, offset);
        return prefix_t;
    }

}
