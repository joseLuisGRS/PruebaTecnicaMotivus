package com.prueba.authentication.model.entity;

public class UserInfo {

	private long id;	
	private String address;
	private String email;

	public UserInfo() {}
	
	public UserInfo(long id, String address, String email) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
	}
	
	public UserInfo(String address, String email) {
		super();
		this.address = address;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
