package com.project.octopus.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.auth.domain.dtos.LoginDto;
import com.project.octopus.core.domain.dtos.SessionUser;
import com.project.octopus.core.domain.enumerations.EventTypeEnum;
import com.project.octopus.core.domain.enumerations.ProfileEnum;
import com.project.octopus.core.services.EventService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Validated
@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	protected final EventService eventService;

	public SessionUser authenticate(@NotNull LoginDto input) {
		var username = input.getUsername();
		try {
			authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, input.getPasswd()));
		} catch(BadCredentialsException e) {
        	eventIn(username, EventTypeEnum.AUTHENTICATION_FAIL, "log.alert.authentication_failed", username);
			throw e;
		}

		eventIn(username, EventTypeEnum.AUTHENTICATION, "log.alert.authenticated", username);
		
		return userAuth(username).orElseThrow();
	}
	
	public Optional<SessionUser> userAuth(String username) {
		var opt = userService.findByUsername(username);
		
		return opt.map(u -> {
				var profile = ProfileEnum.valueOf(u.getProfile().getId());
				var authorities = List.of(profile.name()).toArray(new String[0]);
			
				return SessionUser.builder()
						.idUser(u.getId())
				        .username(u.getUsername())
				        .password(u.getPassword())
				        .authorities(AuthorityUtils.createAuthorityList(authorities))
				        .profile(profile)
				        .build();
			});
	}
	
    public void eventIn(String username, EventTypeEnum type, String keyMsg, Object... params) {
		userService.findByUsername(username)
				.ifPresent(u -> eventService.register(type, userService.getMessages().get(keyMsg, params), u.getId()));
	}

}
