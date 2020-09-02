package com.pt.auth.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class FirebaseAuthenticationProvider implements AuthenticationProvider {

//	@Autowired
//	@Qualifier(value = UserServiceImpl.NAME)
//	private UserDetailsService userService;

	public boolean supports(Class<?> authentication) {
		return (FirebaseAuthenticationToken.class.isAssignableFrom(authentication));
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			return null;
		}

		FirebaseAuthenticationToken authenticationToken = (FirebaseAuthenticationToken) authentication;
//		UserDetails details = userService.loadUserByUsername(authenticationToken.getName());
//		if (details == null) {
//			throw new FirebaseUserNotExistsException();
//		}

//		authenticationToken = new FirebaseAuthenticationToken(details, authentication.getCredentials(),
//				details.getAuthorities());

		return authenticationToken;
	}
}
