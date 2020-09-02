package com.pt.auth.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.util.ArrayMap;
import com.google.firebase.auth.FirebaseToken;

@JsonInclude(Include.NON_NULL)
public class FirebaseTokenHolder {

	private FirebaseToken token;

	public FirebaseTokenHolder(FirebaseToken token) {
		this.token = token;
	}

	@JsonProperty("email")
	public String getEmail() {
		return token.getEmail();
	}

	@JsonProperty("issuer")
	public String getIssuer() {
		return token.getIssuer();
	}

	@JsonProperty("name")
	public String getName() {
		return token.getName();
	}

	@JsonProperty("uid")
	public String getUid() {
		return token.getUid();
	}

	@JsonIgnore
	public String getGoogleId() {
		String userId = ((ArrayList<String>) ((ArrayMap) ((ArrayMap) token.getClaims().get("firebase"))
				.get("identities")).get("google.com")).get(0);

		return userId;
	}
}
