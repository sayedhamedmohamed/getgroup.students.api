package com.getgroup.school.students.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import com.getgroup.school.students.services.HRUserDetailsService;

/**
 * The Class SecurityConfigurer.
 */
@Configuration
@EnableConfigurationProperties
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	/** The user details service. */
	@Autowired
	private HRUserDetailsService hrUserDetailsService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
	 * annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security",
				"/swagger-ui.html**", "/webjars/**", "/swagger-resources/configuration/ui").permitAll()
		.antMatchers(HttpMethod.GET, "/api/v1/students/all").permitAll()
        .antMatchers(HttpMethod.POST, "/api/v1/students").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/v1/students").hasRole("HR_ADMIN")
		.anyRequest().authenticated().and().httpBasic().and().sessionManagement().disable();
		http.cors().configurationSource(new CorsConfigurationSource() {

			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.addAllowedOrigin("*");
				config.setAllowCredentials(true);
				return config;
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(hrUserDetailsService);
	}

}
