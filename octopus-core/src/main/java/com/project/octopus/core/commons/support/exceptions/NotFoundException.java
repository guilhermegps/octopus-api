package com.project.octopus.core.commons.support.exceptions;

import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends NoSuchElementException {

	private static final long serialVersionUID = -9031632391815734130L;
	
	private String entityName;
	private Long code;

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Exception e) {
		super(message, e);
	}

}
