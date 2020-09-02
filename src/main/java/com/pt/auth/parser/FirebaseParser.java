package com.pt.auth.parser;

import com.pt.auth.exception.FirebaseTokenInvalidException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.pt.auth.model.FirebaseTokenHolder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class FirebaseParser {

	private FirebaseAuth firebaseAuth;

	public FirebaseTokenHolder parseToken(String idToken) {
		if (StringUtils.isBlank(idToken)) {
			throw new IllegalArgumentException("FirebaseTokenBlank");
		}
		try {
			log.info("Verification started");
			// FirebaseApp appInstance = FirebaseApp.getInstance();
			FirebaseToken authTask = firebaseAuth.verifyIdToken(idToken);
			log.info("Verification done");
			return new FirebaseTokenHolder(authTask);
		} catch (Exception e) {
			throw new FirebaseTokenInvalidException(e.getMessage());
		}
	}
}
