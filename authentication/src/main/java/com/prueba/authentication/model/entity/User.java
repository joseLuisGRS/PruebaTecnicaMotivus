package com.prueba.authentication.model.entity;

import java.util.ArrayList;
import java.util.List;
import com.prueba.authentication.model.dto.UserInfoDto;

public class User {

	private long id;
	private String userName;
	private String password;
	private int active = 1;
	private List<Role> roles;
	private UserInfo userInfo;

	public User() {}
	
	public User(long id, String userName, String roles, String password, UserInfoDto userInfo, int active) {
		super();
		this.id = id;
		this.userName = userName;
		List<Role> newRoles = new ArrayList<>();
		for (String role : roles.split(",")) {
			newRoles.add(new Role(role, role));
		}
		this.roles = newRoles;
		this.password = password;
		this.userInfo = new UserInfo(userInfo.getAddress(), userInfo.getEmail());
		this.active =  active;
	}
	
	public User(long id, String userName, String roles, String password, UserInfoDto userInfo) {
		super();
		this.id = id;
		this.userName = userName;
		List<Role> newRoles = new ArrayList<>();
		for (String role : roles.split(",")) {
			newRoles.add(new Role(role, role));
		}
		this.roles = newRoles;
		this.password = password;
		this.userInfo = new UserInfo(userInfo.getAddress(), userInfo.getEmail());
	}
	
	public User(String userName, String roles, String password, UserInfoDto userInfo) {
		super();
		this.userName = userName;
		List<Role> newRoles = new ArrayList<>();
		for (String role : roles.split(",")) {
			newRoles.add(new Role(role, role));
		}
		this.roles = newRoles;
		this.password = password;
		this.userInfo = new UserInfo(userInfo.getAddress(), userInfo.getEmail());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
