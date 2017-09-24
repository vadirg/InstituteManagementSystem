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
@Table(name = "fees")
public class Fees implements java.io.Serializable{

	@Id
	@GeneratedValue
	@Column(name = "RecieptId")
	private int recieptId;

	@ManyToOne
	@JoinColumn(name = "StudentId")
	private Student student_fees;

	@Column(name = "RecieptDate")
	private Date recieptDate;

	@Column(name = "AcademicYear")
	private int academicYear;

	@Column(name = "AmountPaid")
	private double amountPaid;

	public int getRecieptId() {
		return recieptId;
	}

	public void setRecieptId(int recieptId) {
		this.recieptId = recieptId;
	}


	public Student getStudent_fees() {
		return student_fees;
	}

	public void setStudent_fees(Student student_fees) {
		this.student_fees = student_fees;
	}

	public Date getRecieptDate() {
		return recieptDate;
	}

	public void setRecieptDate(Date recieptDate) {
		this.recieptDate = recieptDate;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
}
