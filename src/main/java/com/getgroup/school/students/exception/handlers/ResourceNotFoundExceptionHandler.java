package com.getgroup.school.students.exception.handlers;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.getgroup.school.students.model.GetGroupResponse;

/**
 * The Class ResourceNotFoundException.
 * @author sayedhamed
 */
@RestControllerAdvice
public class ResourceNotFoundExceptionHandler {

	/**
	 * Handle project not found exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleProjectNotFoundException(ResourceNotFoundException ex) {

		GetGroupResponse darwinResponse = new GetGroupResponse(ex.getMessage());

		return new ResponseEntity<>(darwinResponse, HttpStatus.NOT_FOUND);
	}
}