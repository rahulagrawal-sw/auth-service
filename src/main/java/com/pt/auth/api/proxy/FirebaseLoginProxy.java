package com.pt.auth.api.proxy;

import com.pt.auth.api.model.SignUpResponse;
import com.pt.auth.api.model.SignUpRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pt.auth.api.model.LoginRequest;
import com.pt.auth.api.model.LoginResponse;

@FeignClient(name = "google-identity-toolkit", url = "https://identitytoolkit.googleapis.com")
public interface FirebaseLoginProxy {

    @PostMapping("/v1/accounts:signInWithPassword?key=AIzaSyCjJ8teeOj6MdiVcq3wAhu9ZNqZSHNsSQc")
    public LoginResponse login(@RequestBody LoginRequest loginRequest);

    @PostMapping("/v1/accounts:signUp?key=AIzaSyCjJ8teeOj6MdiVcq3wAhu9ZNqZSHNsSQc")
    SignUpResponse signUp(@RequestBody SignUpRequest loginRequest);
}