package com.prueba.authentication.model.dto;

public class UserInfoDto {

	private String address;
	private String email;
	
	public UserInfoDto() {}
	
	public UserInfoDto(String address, String email) {
		super();
		this.address = address;
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
