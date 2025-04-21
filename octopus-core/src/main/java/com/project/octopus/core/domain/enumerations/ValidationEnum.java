package com.project.octopus.core.domain.enumerations;

import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ValidationEnum {
	
	NOT_NULL("NotNull", "val.error.null_value", Object.class),
	NOT_EMPTY("NotEmpty", "val.error.empty_value", Object.class),
	NOT_BLANK("NotBlank", "val.error.empty_value", Object.class),
	SIZE_STRING("Size", "val.error.character_limit", String.class),
	SIZE_COLLECTION("Size", "val.error.collection_size", Collection.class),
	POSITIVE("Positive", "val.error.positive_number", Object.class),
	POSITIVE_ZERO("PositiveOrZero", "val.error.positive_or_zero", Object.class),
	DEFAULT("default", "val.error.invalid_field", Object.class);

	private String keyValidation;
	private String keyMessage;
	private Class<?> clazz;
	
	public static ValidationEnum getBy(String keyValidation, Class<?> clazz) {
		return List.of(values()).stream()
				.filter(k -> k.getKeyValidation().equals(keyValidation))
				.filter(c -> c.clazz.isAssignableFrom(clazz))
				.findAny()
				.orElse(DEFAULT);
	}

}
