package com.project.octopus.core.domain.dtos.event;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonEvent {
	
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
