package com.cab.bookingService.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> ExceptionHandler(Exception exception){
		
		ErrorInfo error = new ErrorInfo();	
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorDate(LocalDate.now());
		error.setErrorMessage(exception.getMessage());	
		
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(CabException.class)
	public ResponseEntity<ErrorInfo> CabExceptionHandler(Exception exception){
		
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorDate(LocalDate.now());
		error.setErrorMessage(exception.getMessage());	
		
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
		
	}
	
	

}
