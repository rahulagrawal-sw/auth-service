package com.pt.auth.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.auth.api.model.LoginRequest;
import com.pt.auth.api.model.LoginResponse;
import com.pt.auth.api.proxy.FirebaseLoginProxy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth/v1")
@AllArgsConstructor
@Slf4j
public class LoginController {

	private FirebaseLoginProxy firebaseLoginProxy;
	
	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {
		log.info("Received request ==> {}", loginRequest);
		return firebaseLoginProxy.login(loginRequest);
	}

}
