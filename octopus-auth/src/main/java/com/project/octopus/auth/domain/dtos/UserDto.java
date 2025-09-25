package com.project.octopus.auth.domain.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.project.octopus.core.commons.support.validation.constraints.interfaces.Username;
import com.project.octopus.core.domain.base.BaseDto;
import com.project.octopus.core.domain.enumerations.ProfileEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {

	@Username
	@NotBlank
	@Size(max =  50, min = 3)
	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotBlank
	@Size(max = 30, min = 6)
	private String password;

	@NotNull
	private ProfileEnum profile;
	
	// Personal data

	@NotBlank
	@Size(max =  100, min = 4)
	private String name;

	@NotBlank
	@Size(max =  11, min = 11)
	private String cpf;

	@Email
	@NotBlank
	@Size(max =  50, min = 5)
	private String email;

	@Past
	@NotNull
	private LocalDate dtBirth;

	private Character sex;

}
