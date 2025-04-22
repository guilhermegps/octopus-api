package com.project.octopus.auth.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.auth.domain.mappers.UserMapper;
import com.project.octopus.auth.repositories.UserRepository;
import com.project.octopus.core.services.base.BaseCRUDService;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Validated
@Service
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class UserService extends BaseCRUDService<UserApp, UserDto> {

	@Getter
	private final UserRepository repository;
	@Getter
	private final UserMapper mapper;
	@Getter
	private String entityName = "User";
	
	@Lazy
	private final PasswordEncoder pdEncoder;
	
	public Optional<UserApp> findByUsername(String login) {
		return repository.findOneByUsernameAndEnabled(login, Boolean.TRUE);
	}
	
	@Override
	public UserApp create(@NotNull UserDto input) {
		input.setPassword(pdEncoder.encode(input.getPassword()));
		
		return super.create(input);
	}
	
	@Override
	public UserApp update(@NotNull Long code, @NotNull UserDto input) {
		var passwd = input.getPassword();
		if(StringUtils.isNotBlank(passwd))
			input.setPassword(pdEncoder.encode(passwd));
		
		return super.update(code, input);
	}

}
