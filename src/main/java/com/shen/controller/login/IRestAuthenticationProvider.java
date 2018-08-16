package com.shen.controller.login;

import org.springframework.security.core.userdetails.UserDetails;

public interface IRestAuthenticationProvider {
	
//	UserDetails retrieveUser(String name, UsernamePasswordAuthenticationToken auth);
	UserDetails retrieveUser(String name, String password);

}
