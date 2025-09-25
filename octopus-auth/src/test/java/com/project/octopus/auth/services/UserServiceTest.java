package com.project.octopus.auth.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.auth.domain.mappers.UserMapper;
import com.project.octopus.auth.repositories.UserRepository;
import com.project.octopus.core.events.publishers.PersonEventPublisher;
import com.project.octopus.test.utils.RandomValueUtils;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository repository;
	@Mock
	private UserMapper mapper;
	@Mock
	private PasswordEncoder pdEncoder;
	@Mock
	private PersonEventPublisher personEventPublisher;

	@InjectMocks
	private UserService service;
	
	@Test
    void findByUsername_success() {
		// given
		var username = "myuser";
		var user = UserApp.builder()
				.username(username)
				.build();
		
		// when
        when(repository.findOneByUsernameAndEnabled(username, Boolean.TRUE)).thenReturn(Optional.of(user));
        var result = service.findByUsername(username);
        
        // then
        assertThat(result)
        	.isNotEmpty()
        	.hasValue(user);
    }
	
	@Test
    void create_success() {
		// given
		var username = "myuser";
		var personId = UUID.randomUUID();
		var dto = UserDto.builder()
				.username(username)
				.password(RandomValueUtils.randomString(10))
				// MUST be ignored
				.code(RandomValueUtils.randomLong())
				.enabled(Boolean.FALSE)
				.build();
		
		// when
        when(repository.findOneByUsernameAndEnabled(username, Boolean.TRUE)).thenReturn(Optional.empty());
        when(pdEncoder.encode(anyString())).thenReturn("encodedPasswd");
        when(personEventPublisher.createPerson(any())).thenReturn(personId);
        when(mapper.convert(dto)).thenReturn(new UserApp());
        when(repository.save(any(UserApp.class))).thenAnswer(i -> (UserApp) i.getArguments()[0]);
        UserApp result = service.create(dto);
		
        // then
        assertNotNull(result);
        assertNull(result.getCode());
        assertEquals(Boolean.TRUE, result.getEnabled());
        assertEquals(personId, result.getPersonId());
	}

}
