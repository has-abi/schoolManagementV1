package com.sm.schoolManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.RESET_CONTENT)
public class EmptyElementException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyElementException(String message) {
		super(message);
	}
	
}
