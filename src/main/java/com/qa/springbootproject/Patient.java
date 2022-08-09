package com.qa.springbootproject;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;

	@Column(name = "First_Name")
	@Size(min = 1, max = 20)
	@NotNull
	private String patientFN;

	@Column(name = "Last_Name")
	@Size(min = 1, max = 40)
	@NotNull
	private String patientLN;

	@Column(name = "Age")
	@Min(0)
	@Max(100)
	private int age;

	@Column(name = "Contact_Information")
	private Long contactInfo;

	@Autowired
	public Patient() {
	}

	@Autowired
	public Patient(String patientFN, String patientLN, int age, Long contactInfo) {
		this.patientFN = patientFN;
		this.patientLN = patientLN;
		this.age = age;
		this.contactInfo = contactInfo;
	}

	@Autowired
	public Patient(Long patientId, String patientFN, String patientLN, int age, Long contactInfo) {
		this.patientId = patientId;
		this.patientFN = patientFN;
		this.patientLN = patientLN;
		this.age = age;
		this.contactInfo = contactInfo;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientFN() {
		return patientFN;
	}

	public void setPatientFN(String patientFN) {
		this.patientFN = patientFN;
	}

	public String getPatientLN() {
		return patientLN;
	}

	public void setPatientLN(String patientLN) {
		this.patientLN = patientLN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(Long contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, contactInfo, patientFN, patientLN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return age == other.age && Objects.equals(contactInfo, other.contactInfo)
				&& Objects.equals(patientFN, other.patientFN) && Objects.equals(patientLN, other.patientLN);
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientFN=" + patientFN + ", patientLN=" + patientLN + ", age="
				+ age + ", contactInfo=" + contactInfo + "]";
	}

}
