package com.getgroup.school.students.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Student.
 * @author sayedhamed
 *
 */
@Document(collection = "students")
@JsonInclude(Include.NON_NULL)
public class Student implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	private String id;
	
	/** The name. */
	@Field("name")
	private String name;

	/** The age. */
	@Field("age")
	private Integer age;

	/** The class id. */
	@Field("class_id")
	private Integer classId;

	/** The status id. */
	@Field("status_id")
	private Integer statusId;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param name the name
	 * @param age the age
	 * @param classId the class id
	 * @param statusId the status id
	 */
	public Student(String name, Integer age, Integer classId, Integer statusId) {
		this.name = name;
		this.age = age;
		this.classId = classId;
		this.statusId = statusId;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the class id
	 */
	public Integer getClassId() {
		return classId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
}
