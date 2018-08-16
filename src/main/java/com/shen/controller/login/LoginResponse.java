package com.shen.controller.login;

import java.io.Serializable;
import java.security.Principal;

public class LoginResponse implements Serializable {

	private static final long serialVersionUID = -614082653304214886L;

	private StatusCode statusCode;

	private Principal body;

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	public Principal getBody() {
		return body;
	}

	public void setBody(Principal body) {
		this.body = body;
	}

}
