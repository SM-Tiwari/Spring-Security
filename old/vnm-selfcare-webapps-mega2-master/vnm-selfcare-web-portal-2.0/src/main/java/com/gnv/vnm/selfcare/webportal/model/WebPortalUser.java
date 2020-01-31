/**
 * WebPortalUser.java
 */
package com.gnv.vnm.selfcare.webportal.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.gnv.vnm.selfcare.core.model.SubscriberProfile;

/**
 * @author nandipinto
 *
 */
public class WebPortalUser extends User {

	private static final long serialVersionUID = -1300983497539014456L;
	
	public static final String ROLE_SUBSCRIBER = "ROLE_SUSCRIBER";

	private SubscriberProfile profile;
	
	public WebPortalUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public WebPortalUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	/**
	 * @return the profile
	 */
	public SubscriberProfile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(SubscriberProfile profile) {
		this.profile = profile;
	}

	
}
