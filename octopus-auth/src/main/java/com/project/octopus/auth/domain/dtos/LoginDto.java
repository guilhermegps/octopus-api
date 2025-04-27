package com.project.octopus.auth.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class LoginDto {
	
	private String username;
	private String password;

}
