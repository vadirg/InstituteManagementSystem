package com.inst.beans;

import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;


@Entity
@Table(name="subject")
public class Subject implements java.io.Serializable{

	@Id
	@Column(name="SubjectCode")
	private String subjectCode;
	
	@Column(name="SubjectTitle")
	private String subjectTitle;
	
	@Column(name="Semester")
	private String semester;
	
	@ManyToOne
	@JoinColumn(name="DeptId")
	private  Department subject_department;
	
	@OneToMany(mappedBy="subject_attendance")
	private Set<Attendance> attendance;
	
	@OneToMany(mappedBy="subject_result")
	private Set<Result> result;
	
	
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public Department getSubject_department() {
		return subject_department;
	}
	public void setSubject_department(Department subject_department) {
		this.subject_department = subject_department;
	}
	public Set<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(Set<Attendance> attendance) {
		this.attendance = attendance;
	}
	public Set<Result> getResult() {
		return result;
	}
	public void setResult(Set<Result> result) {
		this.result = result;
	}

	
}
