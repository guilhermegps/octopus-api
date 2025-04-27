package com.project.octopus.core.commons.support;

import java.security.Principal;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.project.octopus.core.domain.dtos.SessionUser;

public class SessionContext {
	
	private SessionContext() {}

	public static SessionUser sessionUser() {
		return getSessionUser().orElseThrow();
	}
	
	public static Optional<SessionUser> getSessionUser() {
		Principal principal = SecurityContextHolder.getContext().getAuthentication();
		if(principal instanceof UsernamePasswordAuthenticationToken userPAToken) {
			var authenticated = userPAToken.isAuthenticated();
			
			if(authenticated)
				return Optional.of((SessionUser) userPAToken.getPrincipal());
		}
		
    	return Optional.empty();
    }

}
