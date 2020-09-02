package com.pt.auth.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

	private String uid;
	private String name;
	private String email;
	private boolean isEmailVerified;
	private String issuer;
	private String picture;
}
