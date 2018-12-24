package com.getgroup.school.students.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getgroup.school.students.constants.AppConstants;
import com.getgroup.school.students.constants.StudentStatusConstants;
import com.getgroup.school.students.exception.BadRequestException;
import com.getgroup.school.students.model.Student;
import com.getgroup.school.students.repository.StudentsRepository;

/**
 * The Class StudentService.
 * @author sayedhamed
 *
 */
@Service
public class StudentService implements StudentsServiceInterface {

	/** The students repository. */
	@Autowired
	private StudentsRepository studentsRepository;

	/* (non-Javadoc)
	 * @see com.getgroup.school.students.services.StudentsServiceInterface#register(com.getgroup.school.students.model.Student)
	 */
	@Override
	public void register(Student student) throws BadRequestException{

		Student currentStudent = studentsRepository.findByName(student.getName());

		if(currentStudent != null)
			throw new BadRequestException(AppConstants.STUDENT_ALREADY_EXISTS);

		if(!isValid(student))
			throw new BadRequestException(AppConstants.INVALID_STUDENT_DETAILS);

		student.setStatusId(StudentStatusConstants.PENDING_APPROVAL);

		studentsRepository.save(student);
	}

	/* (non-Javadoc)
	 * @see com.getgroup.school.students.services.StudentsServiceInterface#findAllStudents()
	 */
	@Override
	public List<Student> findAllStudents() {

		return (List<Student>) studentsRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.getgroup.school.students.services.StudentsServiceInterface#approveStudent(java.lang.String)
	 */
	@Override
	public void approveStudent(Student providedStudent) throws BadRequestException {

		Student currentStudent = studentsRepository.findByName(providedStudent.getName());

		if(currentStudent == null || !isValidforApproval(providedStudent))
			throw new BadRequestException(AppConstants.INVALID_INPUT_FOR_APPROVAL);

			currentStudent.setStatusId(providedStudent.getStatusId());

			studentsRepository.save(currentStudent);

	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid(Student student) {
		
		return (student.getName() != null && student.getAge() != null && student.getClassId() != null);
	}

	/**
	 * Checks if is valid for approval.
	 *
	 * @param student the student
	 * @return true, if is valid for approval
	 */
	public boolean isValidforApproval(Student student) {
		
		return (student.getName() != null && student.getStatusId() != null && (student.getStatusId() == StudentStatusConstants.ACCEPTED || student.getStatusId() == StudentStatusConstants.REJECTED));
	}
}
