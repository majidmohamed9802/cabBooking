package com.cab.bookingService.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorInfo {
	
	private String errorMessage;
	private Integer errorCode;
	private LocalDateTime errorDate;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public LocalDateTime getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(LocalDateTime errorDate) {
		this.errorDate = errorDate;
	}
	
	

}
