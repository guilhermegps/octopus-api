package com.project.octopus.auth.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.auth.services.UserService;
import com.project.octopus.core.commons.support.SessionContext;
import com.project.octopus.core.controllers.base.BaseCRUDController;
import com.project.octopus.core.domain.dtos.SessionUser;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController extends BaseCRUDController<UserApp, UserDto> {

	@Getter
    private final UserService service;

	@PreAuthorize("hasAnyAuthority('ADM', 'USER')")
    @GetMapping
    public ResponseEntity<SessionUser> sessionUser() {
    	var user = SessionContext.sessionUser();
        return toResponse(user, SessionUser.class);
    }

    @PreAuthorize("hasAuthority('ADM')")
    @GetMapping("list/all")
    public ResponseEntity<List<UserDto>> listAll() {
    	var list = service.findAll();
        return toResponse(list);
    }

    @PreAuthorize("hasAuthority('ADM')")
    @GetMapping("{cod}")
    public ResponseEntity<UserDto> detail(@PathVariable Long cod) {
        return super.toDetail(cod);
    }

    @PreAuthorize("hasAuthority('ADM')")
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid final UserDto input) {
        return super.toCreate(input);
    }

    @PreAuthorize("hasAuthority('ADM')")
    @PutMapping("{cod}")
    public ResponseEntity<String> update(@PathVariable Long cod, 
    		@RequestBody @Valid final UserDto input) {
        return super.toUpdate(cod, input);
    }

    @PreAuthorize("hasAuthority('ADM')")
    @DeleteMapping("{cod}")
    public ResponseEntity<String> disable(@PathVariable Long cod) {
        return super.toDisable(cod);
    }
}
