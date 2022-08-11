package com.qa.springbootproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springbootproject.ToDo;
import com.qa.springbootproject.repo.ToDoRepo;

@SpringBootTest
public class ToDoServiceUnitTest {

	// check what you've @autowired
	// This test is autowired -> we don't have normal control -> instead Spring is
	// in control

	@Autowired
	private ToDoService service;

	@MockBean
	private ToDoRepo repo;

	// When we save we don't add an ID
	@Test
	public void createToDo_ValidToDo_SaveToDo() {
		ToDo saveToDo = new ToDo("Complete SpringBoot project", "Pray for an extension before Friday end of day",
				false);
		ToDo repoToDo = new ToDo(1L, "Complete SpringBoot project", "Pray for an extension before Friday end of day",
				false);

		// Mockito is a mocking tool -- Dependancy Injection Tool
		// When I save something into my car it should return my repo car
		// 'Automation Testing'
		Mockito.when(this.service.addToDo(saveToDo)).thenReturn(repoToDo);

		assertEquals(repoToDo, this.service.addToDo(saveToDo));

		Mockito.verify(this.repo, Mockito.times(1)).save(saveToDo);
	}

	@Test
	public void updateToDo_ValidToDo_UpdateToDo() {

//		Car car = this.repo.save(saveCar);
//		System.out.println(this.repo.save(saveCar));

		Long testId = 1L;
//		Car saveCar = new Car(4, "Red", "Ferrari", "Lightning McQueen");
		ToDo updateToDo = new ToDo("Go to the gym", "After work, aim for 4-5 times a week", false);

		Optional<ToDo> mockOutputValid = Optional
				.ofNullable(new ToDo(1L, "Take out trash", "Blue bin goes out on Sunday", true));
		ToDo expectedOutput = new ToDo(1L, "Take out trash", "Blue bin goes out on Sunday", true);

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
//		Mockito.when(mockOutputValid.get().setWheels(updateCar.getWheels()))
//				.thenReturn(mockOutputValid.get().getWheels());
//		Mockito.when(mockOutputValid.get().setColour(updateCar.getColour()))
//				.thenReturn(mockOutputValid.get().getColour());
//		Mockito.when(mockOutputValid.get().setModel(updateCar.getModel())).thenReturn(mockOutputValid.get().getModel());
//		Mockito.when(mockOutputValid.get().setName(updateCar.getName())).thenReturn(mockOutputValid.get().getName());
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateToDo(expectedOutput, 1L));

		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);

	}
}
