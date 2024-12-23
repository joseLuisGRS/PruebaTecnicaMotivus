package com.prueba.authentication.model.dto;

public class UserDto {

	private String userName;
	private String roles;
	private String password;
	private UserInfoDto userInfo;
	
	public UserDto() {
		super();
	}

	public UserDto(String userName, String roles, String password, UserInfoDto userInfo) {
		super();
		this.userName = userName;
		this.roles = roles;
		this.password = password;
		this.userInfo = userInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfoDto getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDto userInfo) {
		this.userInfo = userInfo;
	}
		
}
