package com.inst.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "result")
@NamedQueries({ @NamedQuery(name = "SaveorUpdateInternalMarks", query = "update Result set marks=:marks,resultDate=:resultDate where resultId=:resultId") })
public class Result implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ResultId")
	private int resultId;

	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student student_result;

	@ManyToOne
	@JoinColumn(name = "SubjectCode")
	private Subject subject_result;

	@Column(name = "Semester")
	private String semester;

	@Column(name = "ResultDate")
	private Date resultDate;

	@Column(name = "Internal")
	private int internal;

	@Column(name = "Marks")
	private double marks;

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	
	public Student getStudent_result() {
		return student_result;
	}

	public void setStudent_result(Student student_result) {
		this.student_result = student_result;
	}

	public Subject getSubject_result() {
		return subject_result;
	}

	public void setSubject_result(Subject subject_result) {
		this.subject_result = subject_result;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Date getResultDate() {
		return resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public int getInternal() {
		return internal;
	}

	public void setInternal(int internal) {
		this.internal = internal;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

}
