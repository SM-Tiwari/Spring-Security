/**
 * SelfCareUser.java
 */
package com.gnv.vnm.selfcare.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.gnv.vnm.selfcare.core.model.SubscriberProfile;

/**
 * @author nandipinto
 *
 */
public class SelfCareUser extends User {

	private static final long serialVersionUID = -1300983497539014456L;
	
	private SubscriberProfile profile;
	
	public SelfCareUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public SelfCareUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
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

	public static List<GrantedAuthority> getGrantedAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(AuthConstants.ROLE_SUBSCRIBER));

		return authorities;
	}
}
