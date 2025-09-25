package com.project.octopus.core.commons.support.validation.constraints.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.project.octopus.core.commons.support.validation.constraints.UsernameValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UsernameValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface Username {

	String message() default "{val.error.invalid_username}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String pattern() default "^[a-z0-9_]+$";
	
}
