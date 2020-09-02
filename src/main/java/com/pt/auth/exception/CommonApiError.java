package com.pt.auth.exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonApiError extends RuntimeException {

	private HttpStatus status;
	private String message;

	public static CommonApiError unauthorized() {
		return new CommonApiErrorBuilder().status(HttpStatus.UNAUTHORIZED)
				.message(HttpStatus.UNAUTHORIZED.getReasonPhrase()).build();
	}
}
