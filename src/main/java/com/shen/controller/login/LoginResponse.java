package com.shen.controller.login;

import java.io.Serializable;
import java.util.List;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = -614082653304214886L;

	private StatusCode statusCode;
	
	private List<String> entitlements;

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public List<String> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(List<String> entitlements) {
		this.entitlements = entitlements;
	}

}
