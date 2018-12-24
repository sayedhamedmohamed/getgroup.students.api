package com.getgroup.school.students.exception;

/**
 *@author Marwa
 * The Class BadRequestException.
 * version 1.0
 */
public class BadRequestException extends GetGroupException {
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1;

    /**
     * Instantiates a new bad request exception.
     */
    public BadRequestException() {
        super(400, "The request is invalid");
    }

    /**
     * Instantiates a new bad request exception.
     * @param message the message
     */
    public BadRequestException(String message) {
        super(400, message);
    }
}

