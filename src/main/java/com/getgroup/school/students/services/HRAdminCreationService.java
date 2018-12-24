package com.getgroup.school.students.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getgroup.school.students.model.HRUser;
import com.getgroup.school.students.repository.HRAdminUserRepository;


@Service
public class HRAdminCreationService {

	@Autowired
	private HRAdminUserRepository hrAdminUserRepository;

	private static final String CONSTANT = "HRadmin";
	
	@PostConstruct
	private void init() {
		
		if (hrAdminUserRepository.findByAdminUserName(CONSTANT) == null) {
			
			HRUser adminUser = new HRUser();
			
			adminUser.setAdminUserEmail(CONSTANT+"@getgroup.com");
			
			adminUser.setAdminUserName(CONSTANT);
			
			Set<String> roles = new HashSet<>();
			
			roles.add("ROLE_HR_ADMIN");
			
			adminUser.setRoles(roles);
			
			adminUser.setAdminPassword(CONSTANT);

			hrAdminUserRepository.save(adminUser);
		}
	}
}
