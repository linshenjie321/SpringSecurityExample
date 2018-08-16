package com.shen.api;

import com.shen.controller.login.LoginResponse;

public interface IAuthenticationApi {
	
	LoginResponse authenticate (String name, String password);

}
