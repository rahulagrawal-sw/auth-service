package com.pt.auth.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginResponse {

	private String kind;
	private String localId;
	private String email;
	private String displayName;
	private String idToken;
	private boolean registered;
	private String refreshToken;
	private String expiresIn;
}
