package com.getgroup.school.students.constants;

/**
 * The Class AppConstants.
 * @author sayedhamed
 *
 */
public final class AppConstants {
	
	/**
	 * To avoid creating instance of AppConstants class.
	 */
	private AppConstants() {
		throw new IllegalStateException("AppConstants class are not meant to be instantiated.");
	}
	
	/** The Constant INVALID_REQUEST_FORMAT. */
	public static final String INVALID_REQUEST_FORMAT = "505";

	/** The Constant INVALID_STUDENT_DETAILS. */
	public static final String INVALID_STUDENT_DETAILS = "506";

	/** The Constant STUDENT_ALREADY_EXISTS. */
	public static final String STUDENT_ALREADY_EXISTS = "507";

	/** The Constant INVALID_INPUT_FOR_APPROVAL. */
	public static final String INVALID_INPUT_FOR_APPROVAL = "508";
}
