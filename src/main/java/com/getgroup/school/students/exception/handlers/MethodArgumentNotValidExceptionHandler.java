package com.getgroup.school.students.exception.handlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.getgroup.school.students.model.GetGroupResponse;

/**
 * The Class MethodArgumentNotValidExceptionHandler.
 * @author sayedhamed
 */
@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

	/**
	 * Handle message not exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMessageNotException(MethodArgumentNotValidException ex, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
		
		List<FieldError> fieldErrors = result.getFieldErrors();

		GetGroupResponse darwinResponse = new GetGroupResponse(fieldErrors.get(0).getDefaultMessage());

		return new ResponseEntity<>(darwinResponse, HttpStatus.BAD_REQUEST);

	}

}
