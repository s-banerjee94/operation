package com.crud.operation.controller;

import java.time.LocalTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.crud.operation.modal.ExceptionResponse;
import com.crud.operation.service.exception.UserNotFondException;

@RestControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> userNotFoundException(Exception excp, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), excp.getMessage(),
				request.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(UserNotFondException.class)
	public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFondException excp, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), excp.getMessage(),
				request.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionResponse> dataInegrityException(DataIntegrityViolationException excp,
			WebRequest request) {
		Throwable throwable = excp.getCause();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ExceptionResponse(LocalTime.now(), throwable.getMessage(), request.getDescription(false)));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponse> httpMessageNotReadableException(HttpMessageNotReadableException excp,
			WebRequest request) {
		Throwable throwable = excp.getCause();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ExceptionResponse(LocalTime.now(), throwable.getMessage(), request.getDescription(false)));
	}

}
