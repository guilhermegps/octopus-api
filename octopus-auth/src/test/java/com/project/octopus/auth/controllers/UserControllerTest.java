package com.project.octopus.auth.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.project.octopus.auth.configs.AuthTestConfig;
import com.project.octopus.auth.domain.dtos.UserDto;
import com.project.octopus.auth.domain.entity.UserApp;
import com.project.octopus.auth.services.AuthService;
import com.project.octopus.auth.services.UserService;
import com.project.octopus.core.domain.enumerations.ProfileEnum;
import com.project.octopus.test.controllers.BaseCrudTestController;
import com.project.octopus.test.utils.RandomValueUtils;

import lombok.Getter;

@ContextConfiguration(classes = {AuthTestConfig.class})
class UserControllerTest extends BaseCrudTestController<UserApp, UserDto> {

	@Getter
    private final String url = "/user";
	
	@MockitoBean
	private AuthService authService;
	@Getter
	@MockitoBean
    private UserService service;
	
	@Test
    void create_200() throws Exception {
		for(var username : validUsernames()) {
			// given
			var sex = RandomValueUtils.headsOrTails() ? 'M' : 'F';
			var input = UserDto.builder()
					.username(username)
					.password(RandomValueUtils.randomString(10))
					.cpf("12345678909")
					.dtBirth(LocalDate.now().minusYears(RandomValueUtils.randomInt(15, 80)))
					.email("me@test.com")
					.name("Mario")
					.sex(sex)
					.profile(ProfileEnum.USER)
					.build();
			var expected = new UserDto();

			// when
			whenCreate(input, expected);
			
	        // then
	        var responseJson = mockMvc.perform(reqCreate(input))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$").isNotEmpty())
	    			.andReturn().getResponse().getContentAsString();
	        
	        var response = objectMapper.readValue(responseJson, UserDto.class);
	        assertThat(response)
		    	.usingRecursiveComparison()
		    	.ignoringFields("password")
		    	.isEqualTo(expected);
		}
    }
	
	private List<String> validUsernames(){
		return List.of("myusername", "guts123", "_mario_", "ana_banana");
	}
	
	private List<String> invalidUsernames(){
		return List.of("$uper", "youAreNotAlone", "ana.banana");
	}

}
