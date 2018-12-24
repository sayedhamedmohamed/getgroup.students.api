package com.getgroup.school.students.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
 * The Class ApproveStudentMockTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApproveStudentMockTest {

	/** The mock mvc. */
	private MockMvc mockMvc;

	/** The controller. */
	@Autowired
	private StudentsController controller;

	/** The gson. */
	@Autowired
	private Gson gson;

	/** The approved student. */
	private Student approvedStudent = new Student("Sayed Hamed", null, null, 2);

	/** The mongo template. */
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	/**
	 * Contex loads.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	/**
	 * Test approved student.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testApprovedStudent() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/students").content(gson.toJson(approvedStudent))
				.contentType(MediaType.APPLICATION_JSON);

		MockHttpServletResponse response = mockMvc.perform(requestBuilder).andReturn().getResponse();

		assertEquals(200, response.getStatus());

		mongoTemplate.remove(Query.query(Criteria.where("name").is(approvedStudent.getName())), Student.class);	
	}
}