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

import com.inst.beans.Attendance;
import com.inst.util.Constants;

public class AttendanceDAO {
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public String saveAttendance(Attendance attendance) {

		DetachedCriteria criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.eq("student_attendance",attendance.getStudent_attendance()));
		criteria.add(Restrictions.eq("subject_attendance", attendance.getSubject_attendance()));
		criteria.add(Restrictions.eq("semester", attendance.getStudent_attendance().getSemester()));
		List<Attendance> attendances = hibernateTemplate.findByCriteria(criteria);
		if (attendances.size() == 0) {
			hibernateTemplate.save(attendance);
			return Constants.SUCCESS;
		} else {
			return Constants.FAILURE;
		}

	}

	public String updateAttendance(final Attendance attendance) {
	try{
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.getNamedQuery("SaveorUpdateAttendance");
				query.setParameter("attendanceId", attendance.getAttendanceId());
				query.setParameter("numOfClassAttend", attendance.getNumOfClassAttend());
				query.setParameter("numOfClassPerSem", attendance.getNumOfClassPerSem());
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

	public Attendance getStudentAttendance(Attendance attendance) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.eq("student_attendance",
				attendance.getStudent_attendance()));
		criteria.add(Restrictions.eq("subject_attendance", attendance.getSubject_attendance()));
		criteria.add(Restrictions.eq("semester", attendance.getStudent_attendance().getSemester()));
		List<Attendance> attendances = hibernateTemplate.findByCriteria(criteria);
		if (attendances.size() > 0) {
			return attendances.get(0);
		} else {
			return null;
		}

	}

	public List<Attendance> generateAttendanceReport(Attendance attendance) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Attendance.class);
		criteria.add(Restrictions.eq("semester", attendance.getSemester()));
		criteria.add(Restrictions.eq("subject_attendance", attendance.getSubject_attendance()));
		List<Attendance> attendances=hibernateTemplate.findByCriteria(criteria);
		return attendances;
	}
}
