package com.project.octopus.auth.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    void testFindByUsername() {
		// given
		var username = RandomValueUtils.randomString(50);
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

}
