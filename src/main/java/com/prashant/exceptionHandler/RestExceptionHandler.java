package com.prashant.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prashant.exception.NotFoundException;
import com.prashant.response.ResponseDetails;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ResponseDetails> handleNotFoundException(NotFoundException exception) {
		ResponseDetails response = new ResponseDetails();
		response.setMessage(exception.getMessage());
		response.setSuccess(false);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDetails> handleException(Exception exception) {
		ResponseDetails response = new ResponseDetails();
		response.setMessage(exception.getMessage());
		response.setSuccess(false);
		return new ResponseEntity<ResponseDetails>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
