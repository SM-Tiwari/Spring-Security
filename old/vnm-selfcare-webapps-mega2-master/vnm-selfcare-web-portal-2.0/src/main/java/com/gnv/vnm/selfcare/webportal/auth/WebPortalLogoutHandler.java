/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.auth;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.LoginHistoryEntity;
import com.gnv.vnm.selfcare.dao.repo.LoginHistoryRepository;

/**
 * @author nandipinto
 *
 */

@Component
public class WebPortalLogoutHandler extends SimpleUrlLogoutSuccessHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(WebPortalLogoutHandler.class);
	
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		if (authentication == null) return;
		
		try {
			
			HttpSession session = request.getSession(false);
			Object loginId = session.getAttribute("LOGIN_ID");
			LoggingUtil.debug(logger, "#onLogoutSuccess --- updating login_history with ID= " + loginId + ", user= " + authentication.getName());
			
			if (loginId != null) {
				LoginHistoryEntity history = loginHistoryRepository.findOne((Integer)loginId);
				if (history != null) {
					history.setLogoutTime(new Date());
					
					loginHistoryRepository.save(history);
				}
			}
			//clear authentication
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(null);
			
			//invalidate http session
			session.invalidate();
			
		} catch (Exception e) {
			logger.error("#onLogoutSuccess --- error updating login_history!", e);
		}
		super.onLogoutSuccess(request, response, authentication);
	}

}
