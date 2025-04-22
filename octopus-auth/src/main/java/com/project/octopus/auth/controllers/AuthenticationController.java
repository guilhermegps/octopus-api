package com.project.octopus.auth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.octopus.auth.domain.dtos.AccessTokenDto;
import com.project.octopus.auth.domain.dtos.LoginDto;
import com.project.octopus.auth.services.AuthService;
import com.project.octopus.auth.services.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthService service;
	private final JwtService jwtService;
	
	@PostMapping
    public ResponseEntity<AccessTokenDto> authenticate(@RequestBody LoginDto loginUserDto) {
        var authenticatedUser = service.authenticate(loginUserDto);
        var tokenDto = jwtService.generateToken(authenticatedUser);

        return ResponseEntity.ok(tokenDto);
    }

}
