package com.getgroup.school.students;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * The Class Startup.
 * @author sayedhamed
 */
@SpringBootApplication(scanBasePackages = { "com.getgroup.school" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableMongoRepositories(basePackages = "com.getgroup.school.students.repository")
public class Startup {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(Startup.class);

		try {

			SpringApplication.run(Startup.class, args);

			logger.info("Application has started successfully");
			
		} catch (Exception e) {

			logger.error("Error occured while starting the application", e);
		}
	}

}

