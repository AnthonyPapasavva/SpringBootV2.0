package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.Patient;
import com.qa.springbootproject.service.PatientService;

@RestController
@RequestMapping("/homepat")
public class PatientController {

	@Autowired
	PatientService service;

	@PostMapping("/createPatient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient createPatient = service.addPatient(patient);
		return new ResponseEntity<Patient>(createPatient, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Patient>> getPatients() {
		List<Patient> patientData = service.readAllPatients();
		return new ResponseEntity<List<Patient>>(patientData, HttpStatus.OK);
	}

	// May need to change the {id} to respective patientId in controllers **
	@PutMapping("/updatePatient/{id}")
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable Long patientId) {
		Patient updatePatient = service.updatePatient(patient, patientId);
		return new ResponseEntity<Patient>(updatePatient, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable Long patientId) {
		Boolean deletedPatient = service.deletePatient(patientId);
		return (deletedPatient) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}
