package com.pt.auth.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ErrorStatus {

	private int httpStatus;
	private String message;
}
