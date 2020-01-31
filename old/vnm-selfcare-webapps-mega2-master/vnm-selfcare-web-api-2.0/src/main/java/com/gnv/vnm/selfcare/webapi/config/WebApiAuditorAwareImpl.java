/**
 * Mar 31, 2015 10:08:59 AM
 */
package com.gnv.vnm.selfcare.webapi.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author  nandipinto
 * @version 1.0
 *
 */

@Component("auditorAwareImpl")
public class WebApiAuditorAwareImpl implements AuditorAware<String> {

	static final String DEFAULT_AUDITOR = "system";
	
	@Override
	public String getCurrentAuditor() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication == null || !authentication.isAuthenticated()) {
	      return DEFAULT_AUDITOR;
	    }
	    
	    Object obj = authentication.getPrincipal();
	    if (obj instanceof UserDetails){
	    	return ((UserDetails) obj).getUsername();
	    }
	    return DEFAULT_AUDITOR;
	}
}
