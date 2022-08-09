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

import com.qa.springbootproject.Doctor;
import com.qa.springbootproject.service.DoctorService;

@RestController
@RequestMapping("/homedoc")
public class DoctorController {

	@Autowired
	DoctorService service;

	@PostMapping("/createDoctor")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
		Doctor createDoctor = service.addDoctor(doctor);
		return new ResponseEntity<Doctor>(createDoctor, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<Doctor>> getDoctors() {
		List<Doctor> doctorData = service.readAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctorData, HttpStatus.OK);
	}

	// May need to change the {id} to respective doctorId in controllers **
	@PutMapping("/updateDoctor/{id}")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Long doctorId) {
		Doctor updateDoctor = service.updateDoctor(doctor, doctorId);
		return new ResponseEntity<Doctor>(updateDoctor, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/deleteDoctor/{id}")
	public ResponseEntity<Boolean> deleteDoctor(@PathVariable Long doctorId) {
		Boolean deletedDoctor = service.deleteDoctor(doctorId);
		return (deletedDoctor) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}
