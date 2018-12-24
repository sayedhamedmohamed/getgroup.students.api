package com.getgroup.school.students.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class HRUser.
 */
@Document(collection = "hr_users")
@JsonInclude(Include.NON_NULL)
public class HRUser {

	/** The id. */
	@Id
	private String id;

	/** The admin user name. */
	private String adminUserName;

	/** The admin user email. */
	private String adminUserEmail;

	/** The password. */
	private String adminPassword;

	/** The roles. */
	private Set<String> roles;

	/**
	 * Instantiates a new admin user.
	 */
	public HRUser() {
	}

	/**
	 * Instantiates a new admin user.
	 *
	 * @param id the id
	 * @param adminUserName the admin user name
	 * @param adminPassword the admin password
	 */
	public HRUser(String id, String adminUserName, String adminPassword) {
		this.id = id;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
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
	 * Gets the admin user name.
	 *
	 * @return the admin user name
	 */
	public String getAdminUserName() {
		return adminUserName;
	}

	/**
	 * Sets the admin user name.
	 *
	 * @param adminUserName the new admin user name
	 */
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	/**
	 * Gets the admin password.
	 *
	 * @return the admin password
	 */
	public String getAdminPassword() {
		return adminPassword;
	}

	/**
	 * Sets the admin password.
	 *
	 * @param adminPassword the new admin password
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<String> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the admin user email.
	 *
	 * @return the admin user email
	 */
	public String getAdminUserEmail() {
		return adminUserEmail;
	}

	/**
	 * Sets the admin user email.
	 *
	 * @param adminUserEmail the new admin user email
	 */
	public void setAdminUserEmail(String adminUserEmail) {
		this.adminUserEmail = adminUserEmail;
	}

}
