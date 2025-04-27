package com.project.octopus.auth.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.auth.domain.mappers.UserMapper;
import com.project.octopus.auth.repositories.UserRepository;
import com.project.octopus.core.events.publishers.PersonEventPublisher;
import com.project.octopus.core.services.base.BaseCRUDService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
	private final PersonEventPublisher personEventPublisher;
	
	public Optional<UserApp> findByUsername(String username) {
		return repository.findOneByUsernameAndEnabled(username, Boolean.TRUE);
	}
	
	@Override
	@Transactional
	public UserApp create(@NotNull @Valid UserDto input) {
		findByUsername(input.getUsername())
			.ifPresent(p -> uniqueFieldEx("username"));
		
		input.setPassword(pdEncoder.encode(input.getPassword()));

		var personId = personEventPublisher.createPerson(mapper.convertToEvent(input));
		var entity = mapper.convert(input);
		entity.setId(null);
		entity.setEnabled(Boolean.TRUE);
		entity.setPersonId(personId);
		
		return repository.save(entity);
	}
	
	@Override
	@Transactional
	public UserApp update(@NotNull Long code, @NotNull @Valid UserDto input) {
		var passwd = input.getPassword();
		if(StringUtils.isNotBlank(passwd))
			input.setPassword(pdEncoder.encode(passwd));

		var entity = findByCode(code);
		personEventPublisher.updatePerson(entity.getPersonId(), mapper.convertToEvent(input));
		
		var upEntity = getMapper().convert(input);
		BeanUtils.copyProperties(upEntity, entity, "id", "code", "enabled", "personId");
		
		return getRepository().save(entity);
	}

}
