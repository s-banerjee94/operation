package com.crud.operation.service.exception;

public class UserNotFondException extends RuntimeException {
	private String message;

	public UserNotFondException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
