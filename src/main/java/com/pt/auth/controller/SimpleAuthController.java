package com.pt.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/verify-password")
@AllArgsConstructor
@Slf4j
public class SimpleAuthController {

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> verifyToken(@RequestParam("password") String password) {
		log.info("Received token ==> {}", password);
		if (null != password && password.equals("password")) {
			return new ResponseEntity<>("All good..happy journey..", HttpStatus.OK);
		}
		return new ResponseEntity<>("Not allowed Sir..", HttpStatus.FORBIDDEN);
	}

}
