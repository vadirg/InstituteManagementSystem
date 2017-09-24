package com.inst.beans;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="student")
public class Student implements java.io.Serializable{

	@Id
	@Column(name="StudentId")
	private String studentId;
	
	@Column(name="StudentFirstName")
	private String studentFirstName;
	
	@Column(name="StudentLastName")
	private String studentLastName;
	
	@Column(name="StudentFatherName")
	private String studentFatherName;
	
	@Column(name="StudentMotherName")
	private String studentMotherName;
	
	@Column(name="StudentDOB")
	private Date studentDOB;
	
	@ManyToOne
	@JoinColumn(name="DeptId")
	private Department department_student;
	
	@OneToMany(mappedBy="student_attendance")
	private Set<Attendance> attendance;
	
	@OneToMany(mappedBy="student_fees")
	private List<Fees> Fees;
	
	@OneToMany(mappedBy="student_result")
	private Set<Result> result;
	
	@Column(name="Semester")
	private String semester;
	
	@Column(name="DateOfAdmission")
	private Date dateOfAdmission;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentFatherName() {
		return studentFatherName;
	}
	public void setStudentFatherName(String studentFatherName) {
		this.studentFatherName = studentFatherName;
	}
	public String getStudentMotherName() {
		return studentMotherName;
	}
	public void setStudentMotherName(String studentMotherName) {
		this.studentMotherName = studentMotherName;
	}

	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public Department getDepartment_student() {
		return department_student;
	}
	public void setDepartment_student(Department department_student) {
		this.department_student = department_student;
	}
	public Set<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}
	public List<Fees> getFees() {
		return Fees;
	}
	public void setFees(List<Fees> fees) {
		Fees = fees;
	}
	public Set<Result> getResult() {
		return result;
	}
	public void setResult(Set<Result> result) {
		this.result = result;
	}

	
}
