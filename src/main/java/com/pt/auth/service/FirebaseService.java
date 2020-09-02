package com.pt.auth.service;

import com.pt.auth.exception.CommonApiError;
import com.pt.auth.exception.FirebaseTokenInvalidException;
import com.pt.auth.parser.FirebaseParser;
import com.pt.auth.provider.FirebaseAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.pt.auth.api.model.LoginRequest;
import com.pt.auth.model.FirebaseTokenHolder;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FirebaseService {

	private FirebaseParser firebaseParser;
	private FirebaseAuth firebaseAuth;

	public FirebaseTokenHolder parseToken(String idToken) {
		try {
			FirebaseTokenHolder holder = firebaseParser.parseToken(idToken);
			String userName = holder.getEmail();
			Authentication auth = new FirebaseAuthenticationToken(userName, holder);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return holder;
		} catch (FirebaseTokenInvalidException e) {
			throw CommonApiError.unauthorized();
		}
	}
	
	public void login(LoginRequest loginRequest) {
		try {
			UserRecord userByEmail = firebaseAuth.getUserByEmail(loginRequest.getEmail());
		} catch (FirebaseAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
