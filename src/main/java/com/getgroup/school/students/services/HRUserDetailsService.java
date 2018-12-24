package com.getgroup.school.students.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.getgroup.school.students.model.HRUser;
import com.getgroup.school.students.repository.HRAdminUserRepository;

@Component
public class HRUserDetailsService  implements UserDetailsService{
	  @Autowired
	  private HRAdminUserRepository repository;

	  @Override
	  public UserDetails loadUserByUsername(String username) {
	    HRUser user = repository.findByAdminUserName(username);

	    if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
	    StringBuilder roles = new StringBuilder();
	    for (String s : user.getRoles()) {
	        roles.append(s);
	    }

	    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(roles.toString()));

	    return new User(user.getAdminUserName(), user.getAdminPassword(), authorities);
	  }
	}