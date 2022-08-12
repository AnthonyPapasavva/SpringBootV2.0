package com.qa.springbootproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springbootproject.domain.ToDo;
import com.qa.springbootproject.repo.ToDoRepo;

@SpringBootTest
public class ToDoServiceUnitTest {

	@Autowired
	private ToDoService service;

	@MockBean
	private ToDoRepo repo;

	@Test
	public void createToDo_ValidToDo_SaveToDo() {
		ToDo saveToDo = new ToDo("Complete SpringBoot project", "Pray for an extension before Friday end of day",
				false);
		ToDo repoToDo = new ToDo(1L, "Complete SpringBoot project", "Pray for an extension before Friday end of day",
				false);

		Mockito.when(this.service.addToDo(saveToDo)).thenReturn(repoToDo);

		assertEquals(repoToDo, this.service.addToDo(saveToDo));

		Mockito.verify(this.repo, Mockito.times(1)).save(saveToDo);
	}

	@Test
	public void updateToDo_ValidToDo_UpdateToDo() {

		Long testId = 1L;
		ToDo updateToDo = new ToDo("Go to the gym", "After work, aim for 4-5 times a week", false);

		Optional<ToDo> mockOutputValid = Optional
				.ofNullable(new ToDo(1L, "Take out trash", "Blue bin goes out on Sunday", true));
		ToDo expectedOutput = new ToDo(1L, "Take out trash", "Blue bin goes out on Sunday", true);

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateToDo(expectedOutput, 1L));

		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);

	}
}
