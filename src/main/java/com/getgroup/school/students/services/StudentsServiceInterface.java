package com.getgroup.school.students.services;

import java.util.List;

import com.getgroup.school.students.exception.BadRequestException;
import com.getgroup.school.students.model.Student;

/**
 * The Interface StudentsServiceInterface.
 * @author sayedhamed
 *
 */
public interface StudentsServiceInterface {
	
	/**
	 * Register.
	 *
	 * @param student the student
	 * @throws BadRequestException the bad request exception
	 */
	public void register(Student student) throws BadRequestException;
	
	/**
	 * Find all students.
	 *
	 * @return the list
	 */
	public List<Student> findAllStudents();
	
	/**
	 * Approve student.
	 *
	 * @param studentId the student id
	 */
	public void approveStudent(Student student) throws BadRequestException;

}
