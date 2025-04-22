package com.project.octopus.core.domain.dtos;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.octopus.core.domain.enumerations.ProfileEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SessionUser implements UserDetails {
	
	private static final long serialVersionUID = 4314997572307165971L;

	private String password;
	private List<GrantedAuthority> authorities;
	
	private UUID idUser;
	private String username;
	private String cpf;
	
	private ProfileEnum profile;
}
