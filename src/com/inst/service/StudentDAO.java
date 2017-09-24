package com.inst.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl.Subcriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.inst.beans.Attendance;
import com.inst.beans.Fees;
import com.inst.beans.Student;
import com.inst.util.Constants;

public class StudentDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public String saveStudent(Student student) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentId", student.getStudentId()));
		List<Student> studentList = new ArrayList<Student>();
		studentList = hibernateTemplate.findByCriteria(criteria);
		if (studentList.size() == 0) {
			try {
				hibernateTemplate.saveOrUpdate(student);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
			return Constants.SUCCESS;
		} else {
			return Constants.FAILURE;
		}

	}
	
	public int getSemester(Student student) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentId", student.getStudentId()));
		criteria.add(Restrictions.eq("semester",student.getSemester()));
		criteria.add(Restrictions.eq("department_student", student.getDepartment_student()));
		List<Student> studentList = null;
		studentList = hibernateTemplate.findByCriteria(criteria);
		return studentList.size();

	} 
	
	public List<Student> generateStudentReport(Student student) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("semester", student.getSemester()));
		criteria.add(Restrictions.eq("department_student", student.getDepartment_student()));
		List<Student> students=hibernateTemplate.findByCriteria(criteria);
		return students;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> searchStudent(Student student) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Student.class);
		criteria.add(Restrictions.eq("studentId", student.getStudentId()));
		List<Student> studentList = new ArrayList<Student>();
		studentList = hibernateTemplate.findByCriteria(criteria);
		return studentList;
	}
	
	
	
	public String updateStudent(Student student) throws Exception {
		try {
			hibernateTemplate.saveOrUpdate(student);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return Constants.SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public List<Fees> searchFee(Student student) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Fees.class);
		criteria.add(Restrictions.eq("student_fees", student));
		List<Fees> feesList = new ArrayList<Fees>();
		feesList = hibernateTemplate.findByCriteria(criteria);
		return feesList;
	}

	public void saveFees(Fees fees) throws Exception {
	
		try {
			hibernateTemplate.saveOrUpdate(fees);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}

}
