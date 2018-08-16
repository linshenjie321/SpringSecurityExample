package com.shen.controller.login;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.shen.api.IAuthenticationApi;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	IAuthenticationApi authenticationApi;
	
//	@Override
//	public UserDetails retrieveUser(String name, String password) {
//		String password = auth.getCredentials().toString();
//		UserDetails loadedUser = null;
//		try {
//			LoginResponse authenticationResponse = authenticationApi.authenticate(name, password);
//			if (authenticationResponse.getStatusCode().getValue() == 401) {
//				return new User("wrongUsername", "wrongPass", new ArrayList<GrantedAuthority>());
//			}
//			Principal principalFromRest = authenticationResponse.getBody();
//			Set<String> privilegesFromRest = new HashSet<>();
//			// fill in the privilegesFromRest from the Principal
//			String[] authoritiesAsArray = privilegesFromRest.toArray(new String[privilegesFromRest.size()]);
//			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authoritiesAsArray);
//			loadedUser = new User(name, password, authorities);
//		} catch (Exception ex) {
//			throw new AuthenticationServiceException("login failed due to an exception", ex);
//		}
//		return loadedUser;
//	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try {
			LoginResponse authenticationResponse = authenticationApi.authenticate(name, password);
			if (authenticationResponse.getStatusCode().getValue() == 401) {
				throw new AuthenticationServiceException("login failed due to an exception");
			}
			Principal principalFromRest = authenticationResponse.getBody();
			Set<String> privilegesFromRest = new HashSet<>();
			// fill in the privilegesFromRest from the Principal
			String[] authoritiesAsArray = privilegesFromRest.toArray(new String[privilegesFromRest.size()]);
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authoritiesAsArray);
			return new UsernamePasswordAuthenticationToken(name, password, authorities);
		} catch (Exception ex) {
			throw new AuthenticationServiceException("login failed due to an exception", ex);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

}
