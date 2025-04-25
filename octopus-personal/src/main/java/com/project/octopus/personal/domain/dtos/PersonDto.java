package com.project.octopus.personal.domain.dtos;

import java.time.LocalDate;

import com.project.octopus.core.domain.base.BaseDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class PersonDto extends BaseDto {

	@NotBlank
	@Size(max =  100, min = 4)
	private String name;

	@NotBlank
	@Size(max =  11, min = 11)
	private String cpf;

	@NotNull
	private LocalDate dtBirth;

	private Character sex;

	@NotBlank
	@Size(max =  50, min = 5)
	private String email;

}
