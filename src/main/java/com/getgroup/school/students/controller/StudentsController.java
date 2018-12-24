package com.getgroup.school.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getgroup.school.students.exception.BadRequestException;
import com.getgroup.school.students.model.Student;
import com.getgroup.school.students.services.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class StudentsController.
 * @author sayedhamed
 */
@Api(tags = { "Operations pertaining to getgroup students" })
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 400, message = "Failure") })
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class StudentsController {

	/** The student service. */
	@Autowired
	private StudentService studentService;

	/**
	 * Register student.
	 *
	 * @param student the student
	 * @return the response entity
	 * @throws BadRequestException the bad request exception
	 */
	@ApiOperation(notes = "code = 505, message = Invalid request format" + "\n" + 
			"code = 506, message = Invalid student details" + "\n" + 
			"code = 507, message = student already exists "
			, value = "This API is used to get register a given student.")
	@PostMapping(value = "/students", consumes = { "application/json" })
	protected ResponseEntity<Object> registerStudent(@Validated @RequestBody Student student) throws BadRequestException {

		studentService.register(student);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	/**
	 * Gets the all students.
	 *
	 * @param student the student
	 * @return the all students
	 */
	@ApiOperation(value = "This API is used to get all students.")
	@GetMapping(value = "/students/all")
	protected ResponseEntity<List<Student>> getAllStudents() {

		List<Student> studentList = studentService.findAllStudents();

		return new ResponseEntity<>(studentList, HttpStatus.OK);
	}

	/**
	 * Approve student.
	 *
	 * @param studentId the student id
	 * @return the response entity
	 * @throws BadRequestException 
	 */
	@ApiOperation(notes="code = 508, message = Invalid input data for approval"
			, value = "This API is used to get accept/reject a given student.")
	@PreAuthorize("hasAnyRole('HR_ADMIN')")
	@PutMapping(value = "/students", consumes = { "application/json" })
	protected ResponseEntity<Object> approveStudent(@Validated @RequestBody Student student) throws BadRequestException{

		studentService.approveStudent(student);

		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
