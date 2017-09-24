package com.inst.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.inst.beans.Department;
import com.inst.beans.Faculty;
import com.inst.beans.Result;
import com.inst.beans.Student;
import com.inst.beans.Users;
import com.inst.util.Constants;

public class FacultyDAO {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public String saveFaculty(Faculty faculty) throws Exception {
		try {

			hibernateTemplate.saveOrUpdate(faculty);

			return Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public List<Faculty> getfacultyReport(Department department)
			throws Exception {
		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(Faculty.class);
			criteria.add(Restrictions.eq("faculty_department", department));
			List<Faculty> faculties = hibernateTemplate
					.findByCriteria(criteria);
			return faculties;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public String changePassword(final Users users) {
		try {
			hibernateTemplate.execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.getNamedQuery("changePassword");
					query.setParameter("userName", users.getUserName());
					query.setParameter("password", users.getPassword());
					query.executeUpdate();
					return null;
				}
			});
			return Constants.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FAILURE;
		}
	}

	public String checkOldPassword(Users users) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
		criteria.add(Restrictions.eq("userName", users.getUserName()));
		List<Users> usersLst = hibernateTemplate.findByCriteria(criteria);
		if (usersLst.size() != 0 && usersLst != null) {
			if (usersLst.get(0).getPassword().equals(users.getPassword())) {
				return Constants.SUCCESS;
			} else {
				return Constants.FAILURE;
			}

		}
			return Constants.FAILURE;
	}
	
	@SuppressWarnings("unchecked")
	public List<Faculty> searchFaculty(Faculty faculty) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Faculty.class);
		criteria.add(Restrictions.eq("facultyId", faculty.getFacultyId()));
		List<Faculty> facultyList =  hibernateTemplate.findByCriteria(criteria);
		return facultyList;
	}
	
	
	public String updateFaculty(Faculty faculty) throws Exception {
		try {
			hibernateTemplate.saveOrUpdate(faculty);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return Constants.SUCCESS;
	}

}
