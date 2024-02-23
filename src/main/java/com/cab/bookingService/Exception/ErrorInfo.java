package com.cab.bookingService.Exception;

import java.time.LocalDate;

public class ErrorInfo {
	
	private String errorMessage;
	private Integer errorCode;
	private LocalDate errorDate;
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
	public LocalDate getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(LocalDate errorDate) {
		this.errorDate = errorDate;
	}
	
	

}
