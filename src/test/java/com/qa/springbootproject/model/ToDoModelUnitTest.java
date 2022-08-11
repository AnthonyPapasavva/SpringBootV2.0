package com.qa.springbootproject.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.springbootproject.ToDo;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ToDoModelUnitTest {

	// Equals Verifier -> Because we can't be bothered to test our boiler plate code
	// Hash and equals -> If you have an @ID tag it will fail.. this is why we
	// remove the ID tags from these when we generate these in our class
	// All tests will be void

	// ** FOR IMPORTS AND FUNCTIONALITY YOU NEED TO ADD THE EQUALS VERIFIER
	// DEPENDANCY IN POM XML **

	static ToDo testToDo;

	@BeforeAll
	public static void buildToDo() {
		System.out.println("Building To Do");
		testToDo = new ToDo(1L, "Complete SpringBoot project", "Pray for an extension before Friday end of day", false);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(ToDo.class).verify();
	}

//	@Test
//	public void constructors_Car_Car() {
//	Car carOne = new Car();
//	assertTrue(carOne instanceof Car == true);
//	Car carTwo = new Car(variables x4);
//	assertTrue(carTwo instanceof Car == true);
//	assertEquals("Mazda 2", catTwo.getModel());
//	assertEquals(4, catTwo.getWheels());
//	Car carOne = new Car();
//	assertTrue(carOne instanceof Car == true);
//	}

	// Here we take the code from the Car class toString method for testing purposes
	// while changing values to 'testCar.get'X'()'

	@Test
	public void toString_String_ToDoInstance() {
		String expecting = "ToDo [toDoId=" + testToDo.getToDoId() + ", toDoTitle=" + testToDo.getToDoTitle()
				+ ", toDoItem=" + testToDo.getToDoItem() + ", toDoComplete=" + testToDo.getToDoComplete() + "]";
		assertEquals(expecting, testToDo.toString());
	}
}