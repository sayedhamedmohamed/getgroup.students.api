package com.getgroup.school.students.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.getgroup.school.students.controller.StudentsController;
import com.getgroup.school.students.model.Student;
import com.google.gson.Gson;
// TODO: Auto-generated Javadoc
/**
 * The Class AddStudentMockTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddStudentMockTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The controller. */
	@Autowired
	private StudentsController controller;

	/** The gson. */
	@Autowired
	private Gson gson;

	/** The student. */
	private Student student = new Student("Sayed Hamed" , 20, 1, 1);

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() { 
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	/**
	 * Test register student.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testRegisterStudent() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/students").content(gson.toJson(student))
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(201, response.getStatus());
	}

	/**
	 * Test all student.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testAllStudent() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/students/all");

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(200, response.getStatus());
	}
}