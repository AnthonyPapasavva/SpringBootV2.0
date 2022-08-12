package com.qa.springbootproject.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.qa.springbootproject.domain.Person;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PersonModelUnitTest {

	static Person testPerson;

	@BeforeAll
	public static void buildPerson() {
		System.out.println("Building Person");
		testPerson = new Person("Anthony Papasavva");
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Person.class).verify();
	}

	@Test
	public void toString_String_PersonInstance() {
		String expecting = "Person [personId=" + testPerson.getPersonId() + ", username=" + testPerson.getUsername()
				+ "]";
		assertEquals(expecting, testPerson.toString());
	}
}