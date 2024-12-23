package com.prueba.products.exceptions;

public class GenericException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private String techMessage;
	private String userMessage;
	private Integer exceptionCode;
	
	public GenericException() {
		super();
	}
	
	public GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public GenericException(String message) {
		super(message);
	}
	
	public GenericException(Throwable cause) {
		super(cause);
	}
	
	public GenericException(String techMessage, String userMessage) {
		super(techMessage);
		this.techMessage = techMessage;
		this.userMessage = userMessage;
	}
	
	public GenericException(String techMessage, String userMessage, Integer exceptionCode) {
		super(techMessage);
		this.techMessage = techMessage;
		this.userMessage = userMessage;
		this.exceptionCode = exceptionCode;
	}
	
	public String getTechMessage() {
		return techMessage;
	}
	
	public void setTechMessage(String techMessage) {
		this.techMessage = techMessage;
	}
	
	public String getUserMessage() {
		return userMessage;
	}
	
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	
	public Integer getExceptionCode() {
		return exceptionCode;
	}
	
	public void setExceptionCode(Integer exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
}
