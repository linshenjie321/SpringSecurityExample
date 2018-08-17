package com.shen.api;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.shen.controller.login.LoginResponse;
import com.shen.controller.login.StatusCode;

@Component
public class AuthenticationApi implements IAuthenticationApi {

	@Override
	public LoginResponse authenticate(String name, String password) {
		Users users = new Users();
		Map<String, List<String>> userMap = users.getUserMap();
		LoginResponse response = new LoginResponse();
		StatusCode statusCode = new StatusCode();
		if (("admin".equals(name) || "homeUser".equals(name) || "regularUser".equals(name)) && "password".equals(password)) {
			statusCode.setValue(200);
			response.setEntitlements(userMap.get(name));
		} else {
			statusCode.setValue(401);
		}
		response.setStatusCode(statusCode);
		return response;
	}

}
