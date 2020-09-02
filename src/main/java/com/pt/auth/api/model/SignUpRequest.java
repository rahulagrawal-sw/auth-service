package com.pt.auth.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SignUpRequest {
    private String email;
    private String password;
    @JsonProperty("returnSecureToken")
    private boolean returnSecureToken;
}
