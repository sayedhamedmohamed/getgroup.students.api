package com.getgroup.school.students.model;

import java.io.Serializable;

/**
 * The Class GetGroupResponse.
 * @author sayedhamed
 *
 */
public class GetGroupResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** The error code. */
	private String code;

	/**
	 * Instantiates a new darwin response.
	 *
	 * @param code the code
	 */
	public GetGroupResponse(String code) {
		this.code = code;
	}

	/**
	 * Gets the status.
	 * @return the status
	 */
	public String getCode() {
		return code;
	}
}
