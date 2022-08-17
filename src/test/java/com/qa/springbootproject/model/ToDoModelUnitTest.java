package com.qa.springbootproject.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.springbootproject.domain.ToDo;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ToDoModelUnitTest {

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

	@Test
	public void toString_String_ToDoInstance() {
		String expecting = "ToDo [toDoId=" + testToDo.getToDoId() + ", toDoTitle=" + testToDo.getToDoTitle()
				+ ", toDoItem=" + testToDo.getToDoItem() + ", toDoComplete=" + testToDo.getToDoComplete() + "]";
		assertEquals(expecting, testToDo.toString());
	}
}