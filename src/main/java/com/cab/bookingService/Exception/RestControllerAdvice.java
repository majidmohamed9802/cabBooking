package com.cab.bookingService.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> ExceptionHandler(Exception exception){
		
		ErrorInfo error = new ErrorInfo();	
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setErrorDate(LocalDateTime.now());
		error.setErrorMessage(exception.getMessage());	
		
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(CabException.class)
	public ResponseEntity<ErrorInfo> CabExceptionHandler(Exception exception){
		
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorDate(LocalDateTime.now());
		error.setErrorMessage(exception.getMessage());	
		
		return new ResponseEntity<ErrorInfo>(error,HttpStatus.NOT_FOUND);
}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
			
			String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(", "));
			errorInfo.setErrorMessage(errorMsg);
			errorInfo.setErrorDate(LocalDateTime.now());
			return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
		}
	
		
	}
	
	


