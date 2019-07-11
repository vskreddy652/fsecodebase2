package com.hackfse.giveaway.exception;

public class ReportException extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;
 
	public String getErrorMessage() {
		return errorMessage;
	}
	public ReportException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	public ReportException() {
		super();
	}
}
