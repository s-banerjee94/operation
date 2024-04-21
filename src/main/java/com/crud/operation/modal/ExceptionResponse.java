package com.crud.operation.modal;

import java.time.LocalTime;

public class ExceptionResponse {
	private LocalTime localTime;
	private String message;
	private String details;

	public ExceptionResponse(LocalTime localTime, String message, String details) {
		super();
		this.localTime = localTime;
		this.message = message;
		this.details = details;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
