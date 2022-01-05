package com.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.common.ApiResponse;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(value = { CartNotFoundException.class })
	protected ResponseEntity<ApiResponse> handleConflict(CartNotFoundException ex) {
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
