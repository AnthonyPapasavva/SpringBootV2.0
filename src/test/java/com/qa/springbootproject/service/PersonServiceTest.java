package com.qa.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.springbootproject.repo.PersonRepo;

public class PersonServiceTest {

	@Autowired
	private PersonService service;

	@MockBean
	private PersonRepo repo;

//	@Test
//	public void createPerson_ValidPerson_SavePerson() {
//		Person savePerson = new Person("Andrew Slator");
//		Person repoPerson = new Person(1L, "Harry Cope");
//
//		Mockito.when(this.service.addPerson(savePerson)).thenReturn(repoPerson);
//
//		assertEquals(repoPerson, this.service.addPerson(savePerson));
//
//		Mockito.verify(this.repo, Mockito.times(1)).save(savePerson);
//	}
//
//	@Test
//	public void updatePerson_ValidPerson_UpdatePerson() {
//
//		Long testPersonId = 1L;
//		Person updatePerson = new Person("Anthony Papasavva");
//
//		Optional<Person> mockOutputValid = Optional.ofNullable(new Person(1L, "Anthony Papasavva"));
//		Person expectedOutput = new Person(1L, "Anthony Papasavva");
//
//		Mockito.when(this.repo.findById(testPersonId)).thenReturn(mockOutputValid);
//		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);
//
//		assertEquals(expectedOutput, this.service.updatePerson(expectedOutput, 1L));
//
//		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
//		Mockito.verify(this.repo, Mockito.times(1)).findById(testPersonId);
//
//	}
}
