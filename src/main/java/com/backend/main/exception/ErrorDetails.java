package com.backend.main.exception;

import java.time.LocalDateTime;

//Class/Bean for Custom exception structure
public class ErrorDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime localDateTime;
	private String errorMessage;
	private String errorInfo;
	
	public ErrorDetails(LocalDateTime localDateTime, String errorMessage, String errorInfo) {
		super();
		this.localDateTime = localDateTime;
		this.errorMessage = errorMessage;
		this.errorInfo = errorInfo;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorInfo() {
		return errorInfo;
	}
	

}
