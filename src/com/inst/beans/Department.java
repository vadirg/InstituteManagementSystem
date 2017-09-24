package com.inst.beans;

import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "department")
public class Department implements java.io.Serializable {

	@Id
	@Column(name = "DeptId")
	private String deptId;

	@Column(name = "DeptName")
	private String departmentName;

	@OneToMany(mappedBy = "faculty_department")
	private Set<Faculty> faculty;

	@OneToMany(mappedBy = "subject_department")
	private Set<Subject> subject;

	@OneToMany(mappedBy = "department_student")
	private Set<Student> student;

	public Set<Subject> getSubject() {
		return subject;
	}

	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Faculty> getFaculty() {
		return faculty;
	}

	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

}
