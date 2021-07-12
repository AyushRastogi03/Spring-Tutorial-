package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler; 

@ControllerAdvice
public class CustomerRestExceptionHandler {
      
	// add an exception handler 
	 
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse>
	handleException(CustomerNotFoundException ex){
		
		// create CustomerErrorResponse
		
		CustomerErrorResponse error = new  CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),System.currentTimeMillis());
		return  new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// add another exception handler ---- to catch any exception 

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse>
	handleException(Exception ex){
		
		// create CustomerErrorResponse
		// in place of ex.getMessage() have added custom mssage 
		CustomerErrorResponse error = new  CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Entered Value is not customerId",System.currentTimeMillis());
		return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
