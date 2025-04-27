package com.project.octopus.core.domain.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public class BaseDto {

	@JsonProperty(access = Access.READ_ONLY)
	protected Long code;
	@JsonProperty(access = Access.READ_ONLY)
	protected Boolean enabled;
}
