package com.coffeemaster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author adil
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DatabaseUpdateFailureException extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	public DatabaseUpdateFailureException(String message) {
		super(message);
	}

}
