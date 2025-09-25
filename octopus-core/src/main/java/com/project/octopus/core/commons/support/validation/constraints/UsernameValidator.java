package com.project.octopus.core.commons.support.validation.constraints;

import com.project.octopus.core.commons.support.validation.constraints.interfaces.Username;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {
	private String pattern;

	@Override
	public void initialize(Username constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value!=null && value.matches(pattern);
	}

}
