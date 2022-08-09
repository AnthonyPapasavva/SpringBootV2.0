package com.qa.springbootproject;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;

	@Column(name = "First_Name")
	@Size(min = 1, max = 20)
	@NotNull
	private String doctorFN;

	@Column(name = "Last_Name")
	@Size(min = 1, max = 40)
	@NotNull
	private String doctorLN;

	@Autowired
	public Doctor() {
	}

	@Autowired
	public Doctor(String doctorFN, String doctorLN) {
		this.doctorFN = doctorFN;
		this.doctorLN = doctorLN;
	}

	@Autowired
	public Doctor(Long doctorId, String doctorFN, String doctorLN) {
		this.doctorId = doctorId;
		this.doctorFN = doctorFN;
		this.doctorLN = doctorLN;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorFN() {
		return doctorFN;
	}

	public void setDoctorFN(String doctorFN) {
		this.doctorFN = doctorFN;
	}

	public String getDoctorLN() {
		return doctorLN;
	}

	public void setDoctorLN(String doctorLN) {
		this.doctorLN = doctorLN;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctorFN, doctorLN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(doctorFN, other.doctorFN) && Objects.equals(doctorLN, other.doctorLN);
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorFN=" + doctorFN + ", doctorLN=" + doctorLN + "]";
	}

}
