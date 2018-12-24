package com.getgroup.school.students.constants;

/**
 * The Class AppConstants.
 */
/**
 * @author sayedhamed
 *
 */
public final class StudentStatusConstants {
	
	/**
	 * To avoid creating instance of StudentStatusConstants class.
	 */
	private StudentStatusConstants() {
		throw new IllegalStateException("StudentStatusConstants class are not meant to be instantiated.");
	}
	
	/** The Constant PENDING_APPROVAL. */
	public static final Integer PENDING_APPROVAL = 1;

	/** The Constant APPROVED. */
	public static final Integer ACCEPTED = 2;

	/** The Constant APPROVED. */
	public static final Integer REJECTED = 3;
}
