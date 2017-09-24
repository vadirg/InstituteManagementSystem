package com.inst.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.inst.beans.Result;
import com.inst.beans.Subject;
import com.inst.util.Constants;

public class ResultDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public String saveResult(Result result) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Result.class);
		criteria.add(Restrictions.eq("student_result",
				result.getStudent_result()));
		criteria.add(Restrictions.eq("subject_result", result.getSubject_result() ));
		criteria.add(Restrictions.eq("semester", result.getSemester()));
		criteria.add(Restrictions.eq("internal", result.getInternal()));
		List<Result> results = hibernateTemplate.findByCriteria(criteria);
		if (results.size() == 0) {
			hibernateTemplate.save(result);
			return Constants.SUCCESS;
		} else {
			return Constants.FAILURE;
		}

	}

	public String updateResult(final Result result) {
	try{
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("SaveorUpdateInternalMarks");
				query.setParameter("marks", result.getMarks());
				query.setParameter("resultDate", result.getResultDate());
				query.setParameter("resultId", result.getResultId());
				query.executeUpdate();
				return null;
			}
		});
		return Constants.SUCCESS;
	}catch(Exception e){
		e.printStackTrace();
		return Constants.FAILURE;
	}
	}

	public Result getStudentResult(Result result) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Result.class);
		criteria.add(Restrictions.eq("student_result",result.getStudent_result()));
		criteria.add(Restrictions.eq("subject_result",result.getSubject_result()));
		criteria.add(Restrictions.eq("semester", result.getSemester()));
		criteria.add(Restrictions.eq("internal", result.getInternal()));
		List<Result> results = hibernateTemplate.findByCriteria(criteria);
		if (results.size() > 0) {
			return results.get(0);
		} else {
			return null;
		}

	}
	
	public List<Result> getStudentResultReport(Subject subject) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Result.class);
		criteria.add(Restrictions.eq("semester",subject.getSemester()));
		criteria.add(Restrictions.eq("subject_result",subject));
		List<Result> results = hibernateTemplate.findByCriteria(criteria);
		if (results.size() > 0) {
			return results;
		} else {
			return null;
		}

	}
	

}
