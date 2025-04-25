package com.project.octopus.personal.domain.dtos;

import com.project.octopus.core.domain.base.BaseDto;

import jakarta.validation.constraints.NotBlank;
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
public class PhoneDto extends BaseDto {

	@NotBlank
	@Size(max =  30, min = 7)
	private String number;

}
