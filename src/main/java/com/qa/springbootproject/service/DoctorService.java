package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.Doctor;
import com.qa.springbootproject.repo.DoctorRepo;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo repo;

	public DoctorService() {

	}

	@Autowired
	public DoctorService(DoctorRepo repo) {
		this.repo = repo;
	}

	public Doctor addDoctor(Doctor doctor) {
		return this.repo.save(doctor);
	}

	public List<Doctor> addManyDoctors(List<Doctor> doctors) {
		return this.repo.saveAll(doctors);
	}

	public Doctor findById(Long doctorId) {
		Optional<Doctor> existingDoctor = this.repo.findById(doctorId);
		if (existingDoctor.get() instanceof Doctor)
			return existingDoctor.get();
		return null;
	}

	public List<Doctor> readAllDoctors() {
		return this.repo.findAll();
	}

	public Doctor updateDoctor(Doctor updateDoctor, Long doctorId) {
		Optional<Doctor> existingDoctor = this.repo.findById(doctorId);

		if (existingDoctor.get() instanceof Doctor) {
			Doctor oldDoctor = existingDoctor.get();

			oldDoctor.setDoctorFN(updateDoctor.getDoctorFN());
			oldDoctor.setDoctorLN(updateDoctor.getDoctorLN());

			return this.repo.save(oldDoctor);
		}
		return null;
	}

	public boolean deleteDoctor(Long doctorId) {
		this.repo.deleteById(doctorId);
		boolean exists = this.repo.existsById(doctorId);
		return !exists;
	}
}
