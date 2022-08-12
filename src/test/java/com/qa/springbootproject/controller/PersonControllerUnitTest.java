package com.qa.springbootproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.springbootproject.domain.Person;
import com.qa.springbootproject.service.PersonService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PersonControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private PersonService service;

	@Test
	public void createPersonTest() throws Exception {
		Person testPerson = new Person("Anthony Papasavva");
		String testPersonAsJSON = this.mapper.writeValueAsString(testPerson);

		Mockito.when(this.service.addPerson(testPerson)).thenReturn(testPerson);

		mvc.perform(post("/home/createPerson").content(testPersonAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(content().json(testPersonAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).addPerson(testPerson);
	}
}
