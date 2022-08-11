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
import com.qa.springbootproject.ToDo;
import com.qa.springbootproject.service.ToDoService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class ToDoControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private ToDoService service;

	@Test
	public void createToDoTest() throws Exception {
		ToDo testToDo = new ToDo("Get Haircut", "Whatever details the user wants to put", true);
		String testToDoAsJSON = this.mapper.writeValueAsString(testToDo);

		Mockito.when(this.service.addToDo(testToDo)).thenReturn(testToDo);

		mvc.perform(post("/localhost:8085/createToDo").content(testToDoAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(content().json(testToDoAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).addToDo(testToDo);
	}
}