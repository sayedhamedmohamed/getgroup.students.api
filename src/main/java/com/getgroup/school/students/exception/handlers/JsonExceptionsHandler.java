package com.getgroup.school.students.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.getgroup.school.students.constants.AppConstants;
import com.getgroup.school.students.model.GetGroupResponse;

/**
 * The Class JsonExceptionsHandler.
 */
@RestControllerAdvice
public class JsonExceptionsHandler {

	/**
	 * Handle message not exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> handleMessageNotException(Exception ex, WebRequest request) {

		return new ResponseEntity<>(new GetGroupResponse(AppConstants.INVALID_REQUEST_FORMAT), HttpStatus.BAD_REQUEST);

	}
}