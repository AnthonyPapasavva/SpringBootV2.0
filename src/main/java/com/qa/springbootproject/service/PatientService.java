package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.Patient;
import com.qa.springbootproject.repo.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo repo;

	public PatientService() {

	}

	@Autowired
	public PatientService(PatientRepo repo) {
		this.repo = repo;
	}

	public Patient addPatient(Patient patient) {
		return this.repo.save(patient);
	}

	public List<Patient> addManyPatients(List<Patient> patients) {
		return this.repo.saveAll(patients);
	}

	public Patient findById(Long patientId) {
		Optional<Patient> existingPatient = this.repo.findById(patientId);
		if (existingPatient.get() instanceof Patient)
			return existingPatient.get();
		return null;
	}

	public List<Patient> readAllPatients() {
		return this.repo.findAll();
	}

	public Patient updatePatient(Patient updatePatient, Long patientId) {
		Optional<Patient> existingPatient = this.repo.findById(patientId);

		if (existingPatient.get() instanceof Patient) {
			Patient oldPatient = existingPatient.get();

			oldPatient.setPatientFN(updatePatient.getPatientFN());
			oldPatient.setPatientLN(updatePatient.getPatientLN());
			oldPatient.setAge(updatePatient.getAge());
			oldPatient.setContactInfo(updatePatient.getContactInfo());

			return this.repo.save(oldPatient);
		}
		return null;
	}

	public boolean deletePatient(Long patientId) {
		this.repo.deleteById(patientId);
		boolean exists = this.repo.existsById(patientId);
		return !exists;
	}

}
