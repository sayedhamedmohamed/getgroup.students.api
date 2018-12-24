package com.getgroup.school.students.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.getgroup.school.students.exception.BadRequestException;
import com.getgroup.school.students.model.GetGroupResponse;

/**
 * The Class BadRequestExceptionHandling.
 * @author sayedhamed
 *
 */
@RestControllerAdvice
public class BadRequestExceptionHandler {

	/**
	 * Handle bad request exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {

		GetGroupResponse darwinResponse = new GetGroupResponse(ex.getMessage());

		return new ResponseEntity<>(darwinResponse, HttpStatus.BAD_REQUEST);
	}
}
