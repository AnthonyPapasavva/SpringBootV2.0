package com.qa.springbootproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.qa.springbootproject.domain.ToDo;
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
		ToDo testToDo = new ToDo(1L, "Get Haircut", "Whatever details the user wants to put", false);
		String testToDoAsJSON = this.mapper.writeValueAsString(testToDo);

		Mockito.when(this.service.addToDo(testToDo)).thenReturn(testToDo);

		mvc.perform(post("/todo/createToDo").content(testToDoAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(content().json(testToDoAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).addToDo(testToDo);
	}

	@Test
	public void readAllToDoTest() throws Exception {
		List<ToDo> testToDo = new ArrayList<>();
		testToDo.add(new ToDo(1L, "Get Haircut", "Whatever details the user wants to put", false));
		String testToDoAsJSON = this.mapper.writeValueAsString(testToDo);

		Mockito.when(this.service.readAllToDos()).thenReturn(testToDo);

		mvc.perform(get("/todo/read").content(testToDoAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(testToDoAsJSON));

		Mockito.verify(this.service, Mockito.times(1)).readAllToDos();
	}

	@Test
	public void updateToDoTest() throws Exception {
		ToDo testToDo = new ToDo(1L, "Get Haircut", "Whatever details the user wants to put", false);
		String testToDoAsJSON = this.mapper.writeValueAsString(testToDo);

		Mockito.when(this.service.updateToDo(testToDo, testToDo.getToDoId())).thenReturn(testToDo);

		mvc.perform(patch("/todo/updateToDo/{toDoId}" + testToDo.getToDoId()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(testToDoAsJSON));
	}

	@Test
	public void deleteToDoTest() throws Exception {
		ToDo testToDo = new ToDo(1L, "Get Haircut", "Whatever details the user wants to put", false);
		String testToDoAsJSON = this.mapper.writeValueAsString(testToDo.getToDoId());

		Mockito.when(this.service.deleteToDo(testToDo.getToDoId())).thenReturn(true);

		mvc.perform(delete("/todo/deleteToDo/{toDoId}" + testToDoAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}