package com.pt.auth.api.advice;

import com.pt.auth.exception.CommonApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pt.auth.api.model.ErrorStatus;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { CommonApiError.class })
	protected ResponseEntity<Object> handleConflict(CommonApiError apiError, WebRequest request) {
		return handleExceptionInternal(apiError,
				new ErrorStatus().setHttpStatus(apiError.getStatus().value()).setMessage(apiError.getMessage()),
				new HttpHeaders(), apiError.getStatus(), request);
	}
}
