package com.inst.service;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.inst.beans.Department;
public class DepartmentDAO {

	private HibernateTemplate hibernateTemplate;  
	   
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
	}
	public List<Department> getDepartments() throws Exception {
		List<Department> departments;
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		try{
			departments=hibernateTemplate.findByCriteria(criteria);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}
		return departments;
	}

}
