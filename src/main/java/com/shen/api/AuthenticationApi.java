package com.shen.api;

import org.springframework.stereotype.Component;

import com.shen.controller.login.LoginResponse;
import com.shen.controller.login.StatusCode;

@Component
public class AuthenticationApi implements IAuthenticationApi {

	@Override
	public LoginResponse authenticate(String name, String password) {
		LoginResponse response = new LoginResponse();
		StatusCode statusCode = new StatusCode();
		if ("admin".equals(name) && "password".equals(password)) {
			statusCode.setValue(200);
		} else {
			statusCode.setValue(401);
		}
		response.setStatusCode(statusCode);
		return response;
	}

}
