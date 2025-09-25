package com.project.octopus.auth.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.project.octopus.auth.configs.AuthTestConfig;
import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.auth.services.UserService;
import com.project.octopus.test.utils.RandomValueUtils;

import lombok.Getter;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {AuthTestConfig.class})
class UserControllerTest extends BaseTestController<UserApp, UserDto> {

	@Getter
    private final String url = "/user";
	
	@Autowired
    private MockMvc mockMvc;
	@MockitoBean
    private UserService service;
	
	@Test
    void testCreatePersonWithInvalidDto() throws Exception {
		var input = UserDto.builder()
				.username("")
				.password(RandomValueUtils.randomString(10))
				// MUST be ignored
				.code(RandomValueUtils.randomLong())
				.enabled(Boolean.FALSE)
				.build();

        mockMvc.perform(reqCreate(input))
				.andExpect(status().isOk())
    			.andExpect(jsonPath(".").value(IsNull.notNullValue(), UserDto.class))
    			.andExpect(jsonPath(".").value(input));
    }
	
	private List<String> validUsernames(){
		return List.of("myusername", "guts123", "_mario_", "ana_123", "AS");
	}
	
	private List<String> invalidUsernames(){
		return List.of("$uper", "youAreNotAlone");
	}

}
