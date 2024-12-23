package com.prueba.products.models.dto;

public class GenericExceptionDTO {

	private String techMessage;
	private String userMessage;
	private Integer exceptionCode;

	public GenericExceptionDTO(String techMessage, String userMessage) {
		super();
		this.techMessage = techMessage;
		this.userMessage = userMessage;
	}

	public GenericExceptionDTO(String techMessage, String userMessage, Integer exexceptionCode) {
		super();
		this.techMessage = techMessage;
		this.userMessage = userMessage;
		this.exceptionCode = exexceptionCode;
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
