/**
 * 
 */
package com.gnv.vnm.selfcare.webportal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.gnv.vnm.selfcare.core.security.AuthConstants;

/**
 * @author nandipinto
 *
 */

@Controller
public class InstantLoginController extends WebPortalBaseController{

	@PostMapping(value = "/ilogin")
	public ResponseEntity<?> ilogin(String username, String password, HttpServletRequest request) {

		boolean auth = subscriberManagementService.instantLogin(username, password);
		if (auth) {
			Authentication authentication = new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		return new ResponseEntity<>(auth ? "1":"0", HttpStatus.OK);
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(AuthConstants.ROLE_SUBSCRIBER));
		
		return authorities;
	}
}
