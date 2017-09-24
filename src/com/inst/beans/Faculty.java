package com.inst.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "faculty")
public class Faculty implements java.io.Serializable {
	@Id
	@GeneratedValue
	@Column(name = "FacultyId")
	private int facultyId;

	@Column(name = "FacultyName")
	private String facultyName;

	@Column(name = "Qualification")
	private String qualification;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "FacultyDOB")
	private Date facultyDOB;

	@Column(name = "DateOfJoining")
	private Date facultyDateOfJoining;

	@ManyToOne
	@JoinColumn(name = "DeptId")
	private Department faculty_department;

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public Department getFaculty_department() {
		return faculty_department;
	}

	public void setFaculty_department(Department faculty_department) {
		this.faculty_department = faculty_department;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getFacultyDOB() {
		return facultyDOB;
	}

	public void setFacultyDOB(Date facultyDOB) {
		this.facultyDOB = facultyDOB;
	}

	public Date getFacultyDateOfJoining() {
		return facultyDateOfJoining;
	}

	public void setFacultyDateOfJoining(Date facultyDateOfJoining) {
		this.facultyDateOfJoining = facultyDateOfJoining;
	}
}
