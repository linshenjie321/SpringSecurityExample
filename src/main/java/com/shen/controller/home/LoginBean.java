package com.shen.controller.home;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class LoginBean implements Serializable {

	private static final long serialVersionUID = 4259350572068597415L;
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
