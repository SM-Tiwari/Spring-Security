/**
 * WebPortalUserDetailsService.java
 */
package com.gnv.vnm.selfcare.webportal.auth;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gnv.vnm.selfcare.core.enums.SubscriberStatus;
import com.gnv.vnm.selfcare.core.service.ApplicationConfigurationService;
import com.gnv.vnm.selfcare.core.utils.AppUtils;
import com.gnv.vnm.selfcare.core.utils.LoggingUtil;
import com.gnv.vnm.selfcare.dao.entity.QSubscriberEntity;
import com.gnv.vnm.selfcare.dao.entity.SubscriberEntity;
import com.gnv.vnm.selfcare.dao.repo.SubscriberRepository;
import com.gnv.vnm.selfcare.webportal.model.WebPortalUser;

/**
 * @author nandipinto
 *
 */

@Component("webPortalUserDetailsService")
public class WebPortalUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(WebPortalUserDetailsService.class);

	@Autowired
	private ApplicationConfigurationService applicationConfigurationService;

	@Autowired
	SubscriberRepository subscriberRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		username = AppUtils.removeCountryCode(username, applicationConfigurationService.getDefaultCountryCode());
		
		SubscriberEntity user = subscriberRepository.findOne(QSubscriberEntity.subscriberEntity.msisdn.eq(username).and(
				QSubscriberEntity.subscriberEntity.status.eq(SubscriberStatus.ACTIVE.ordinal())));

		LoggingUtil.debug(logger, "#loadUserByUsername >> looking up user with loginId " + username + ", found user= " + user);

		if (user == null) throw new UsernameNotFoundException(AuthMessages.USERNAME_NOT_FOUND);

		return new WebPortalUser(username, user.getCredential(), getGrantedAuthorities());
	}

	private List<GrantedAuthority> getGrantedAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(WebPortalUser.ROLE_SUBSCRIBER));

		return authorities;
	}
}
