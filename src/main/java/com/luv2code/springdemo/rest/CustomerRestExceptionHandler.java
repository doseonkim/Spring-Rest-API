package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> ExceptionHandler(CustomerNotFoundException ex) {
		CustomErrorResponse error = new CustomErrorResponse(
				HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> ExceptionHandler(Exception ex) {
		CustomErrorResponse error = new CustomErrorResponse(
				HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
