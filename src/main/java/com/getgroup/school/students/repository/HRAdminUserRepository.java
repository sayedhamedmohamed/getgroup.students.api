package com.getgroup.school.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.getgroup.school.students.model.HRUser;

/**
 * The Interface UserRepository.
 */
@Repository
public interface HRAdminUserRepository extends MongoRepository<HRUser, String> {
	
	/**
	 * Find by admin user name.
	 *
	 * @param userName the user name
	 * @return the admin user
	 */
	HRUser findByAdminUserName(String userName);

	/**
	 * Find by admin user email.
	 *
	 * @param adminUserEmail the admin user email
	 * @return the admin user
	 */
	HRUser findByAdminUserEmail(String adminUserEmail);

}
