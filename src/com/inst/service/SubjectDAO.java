package com.inst.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.inst.beans.Subject;

public class SubjectDAO {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<Subject> getSubjects(Subject subject) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Subject.class);
		criteria.add(Restrictions.eq("semester", subject.getSemester()));
		criteria.add(Restrictions.eq("subject_department", subject.getSubject_department()));
		try{
		List<Subject> subjects=hibernateTemplate.findByCriteria(criteria);
		return subjects;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
