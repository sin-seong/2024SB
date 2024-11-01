package com.sin.sb1101.handler.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomPageException extends RuntimeException {
	
	private HttpStatus status;

	public CustomPageException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	
	
}
