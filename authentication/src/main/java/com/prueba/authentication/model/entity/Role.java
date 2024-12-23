package com.prueba.authentication.model.entity;

public class Role {

	private long id;
	private String rolName;
	private String roleDescription;
	
	public Role() {}
	
	public Role(String rolName, String description) {
		super();
		this.rolName = rolName;
		this.roleDescription = description;
	}
	
	public Role(long id, String rolName, String description) {
		super();
		this.id = id;
		this.rolName = rolName;
		this.roleDescription = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}
