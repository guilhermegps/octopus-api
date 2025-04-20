package com.project.octopus.core.commons.support.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 709186497255683723L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Exception e) {
		super(message, e);
	}

}
