package com.getgroup.school.students.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.getgroup.school.students.model.Student;

/**
 * The Interface StudentsRepository.
 * @author sayedhamed
 *
 */

//db.students.createIndex(name :1)
@Repository
public interface StudentsRepository extends CrudRepository<Student, String> {
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the student
	 */
	public Student findByName(String name);

}
