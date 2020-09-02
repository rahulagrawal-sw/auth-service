package com.pt.auth.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.auth.model.FirebaseTokenHolder;
import com.pt.auth.service.FirebaseService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth/v1")
@AllArgsConstructor
@Slf4j
public class TokenVerificationController {

	private FirebaseService firebaseService;

	@GetMapping(path = "/verify-token", produces = MediaType.APPLICATION_JSON_VALUE)
	public FirebaseTokenHolder verifyToken(@RequestHeader("X-Authorization-Firebase") String token,
			HttpServletResponse response) {
		log.info("Received token ==> {}", token);
		FirebaseTokenHolder holder = firebaseService.parseToken(token);
		response.addHeader("MI-USER-ID", holder.getEmail());
		return holder;
	}

}
