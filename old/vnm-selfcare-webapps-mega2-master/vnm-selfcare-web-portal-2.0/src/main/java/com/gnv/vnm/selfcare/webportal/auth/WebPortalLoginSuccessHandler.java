/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.gnv.vnm.selfcare.core.enums.ClientAppId;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.LoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.repo.LoginHistoryRepository;

/**
 * @author nandipinto
 *
 */

@Component
public class WebPortalLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler { //SimpleUrlAuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebPortalLoginSuccessHandler.class);
	
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	public WebPortalLoginSuccessHandler() {
		super.setDefaultTargetUrl("/secure/dashboard");
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		try {
			LoginHistoryEntity history = loginHistoryRepository.saveAndFlush(new LoginHistoryEntity(authentication.getName(), new Date(), request.getRemoteAddr(), ClientAppId.WEB_APP.name()));
			LoggingUtil.debug(logger, "#onAuthenticationSuccess --- creating login history for user= " + authentication.getName() + ", login_id= " + history.getId());
			request.getSession(true).setAttribute("LOGIN_ID", history.getId());
			request.getSession(true).setAttribute("MIC_SHOW_POPUP", "0");
			
			if ( request.getHeader("Referer") != null && request.getHeader("Referer").contains("bad_credentials")) {
//				LoggingUtil.debug(logger, "onAuthenticationSuccess --- coming from login fail page");
				super.setUseReferer(false);
				super.setAlwaysUseDefaultTargetUrl(true);
			} else {
				super.setUseReferer(true);
				super.setAlwaysUseDefaultTargetUrl(false);
			}
		} catch (Exception e) {
			logger.error("#onAuthenticationSuccess --- error saving login history!", e);
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

	
}
