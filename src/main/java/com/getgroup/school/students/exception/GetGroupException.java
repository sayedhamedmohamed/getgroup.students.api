package com.getgroup.school.students.exception;

/**
 * @author sayedhamed
 * The Class DarwinException.
 * version 1.0
 */
public class GetGroupException extends Exception {
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1;
    
    /** The message. */
    private final String message;
    
    /** The code. */
    private final Integer code;

    /**
     * Instantiates a new loan engine exception.
     * @param code the code
     * @param message the message
     */
    public GetGroupException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Gets the code.
     * @return the code
     */
    public Integer getCode() {
        return this.code;
    }
    
    /**
     * Gets exception message.
     * @return the message
     */

    @Override
    public String getMessage() {
        return this.message;
    }
}

