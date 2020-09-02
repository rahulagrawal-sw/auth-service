package com.pt.auth.controller;

import com.pt.auth.api.model.SignUpRequest;
import com.pt.auth.api.model.SignUpResponse;
import com.pt.auth.api.proxy.FirebaseLoginProxy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1")
@AllArgsConstructor
@Slf4j
public class SignUpController {
    private FirebaseLoginProxy firebaseLoginProxy;

    @PostMapping(path = "/signUp", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SignUpResponse login(@RequestBody SignUpRequest signUpRequest) {
        log.info("Received request ==> {}", signUpRequest);
        return firebaseLoginProxy.signUp(signUpRequest);
    }
}
