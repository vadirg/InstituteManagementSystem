package com.inst.beans;

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
@Table(name = "attendance")
@NamedQueries({ @NamedQuery(name = "SaveorUpdateAttendance", query = "update Attendance set numOfClassPerSem=:numOfClassPerSem,numOfClassAttend=:numOfClassAttend where attendanceId=:attendanceId") })
public class Attendance implements java.io.Serializable{
	
	@Id
	@GeneratedValue
	@Column(name = "AttendanceId")
	private int attendanceId;
	
	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	@ManyToOne
	@JoinColumn(name = "SubjectCode")
	private Subject subject_attendance;

	@ManyToOne
	@JoinColumn(name = "StudentId",insertable=true,updatable=true)
	private Student student_attendance;

	@Column(name = "Semester")
	private String semester;

	@Column(name = "NumOfClassAttend")
	private int numOfClassAttend;

	@Column(name = "NumOfClassPerSem")
	private int numOfClassPerSem;


	public Subject getSubject_attendance() {
		return subject_attendance;
	}

	public void setSubject_attendance(Subject subject_attendance) {
		this.subject_attendance = subject_attendance;
	}

	public Student getStudent_attendance() {
		return student_attendance;
	}

	public void setStudent_attendance(Student student_attendance) {
		this.student_attendance = student_attendance;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getNumOfClassAttend() {
		return numOfClassAttend;
	}

	public void setNumOfClassAttend(int numOfClassAttend) {
		this.numOfClassAttend = numOfClassAttend;
	}

	public int getNumOfClassPerSem() {
		return numOfClassPerSem;
	}

	public void setNumOfClassPerSem(int numOfClassPerSem) {
		this.numOfClassPerSem = numOfClassPerSem;
	}

}
