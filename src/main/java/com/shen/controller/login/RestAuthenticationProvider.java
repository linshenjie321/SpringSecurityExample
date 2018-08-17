package com.shen.controller.login;

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
import org.springframework.stereotype.Component;

import com.shen.api.IAuthenticationApi;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	IAuthenticationApi authenticationApi;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("inside RestAuthenticationProvider.authenticate(), name = " + name + " and password = " + password);
        try {
			LoginResponse authenticationResponse = authenticationApi.authenticate(name, password);
			System.out.println("authenticationResponse.getStatusCode().getValue() = " + authenticationResponse.getStatusCode().getValue());
			if (authenticationResponse.getStatusCode().getValue() == 401) {
				throw new AuthenticationServiceException("login failed due to an exception");
			}
			List<String> privilegesFromRest = authenticationResponse.getEntitlements();
			// fill in the privilegesFromRest from the Principal
			String[] authoritiesAsArray = privilegesFromRest.toArray(new String[privilegesFromRest.size()]);
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(authoritiesAsArray);
			System.out.println("retrieve authorities for " + name);
			System.out.println(authorities.toString());
			return new UsernamePasswordAuthenticationToken(name, password, authorities);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AuthenticationServiceException("login failed due to an exception", ex);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
		          UsernamePasswordAuthenticationToken.class);
	}

}
