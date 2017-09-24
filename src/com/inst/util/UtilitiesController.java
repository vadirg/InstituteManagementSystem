package com.inst.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inst.beans.Department;
import com.inst.beans.Subject;
import com.inst.service.DepartmentDAO;
import com.inst.service.SubjectDAO;

@Controller
public class UtilitiesController {

	private DepartmentDAO departmentDAO;
	private SubjectDAO subjectDAO;

	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getDepartmentDetails.htm")
	public void getDepartmentDetails(HttpServletRequest request,HttpServletResponse response) {

		JSONObject json = new JSONObject();
		try {
		List<Department> departments = this.departmentDAO.getDepartments();
		if (departments != null) {
			for (int i = 0; i < departments.size(); i++) {
				json.put(departments.get(i).getDeptId(), departments.get(i)
						.getDepartmentName());
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "getSubjects.htm")
	public void getSubjects(HttpServletRequest request,HttpServletResponse response) {

		JSONObject json = new JSONObject();
		Subject subject=new Subject();
		try {
			subject.setSemester(request.getParameter("semester"));
			Department department=new Department();
			department.setDeptId(request.getParameter("deptId"));
			subject.setSubject_department(department);
		List<Subject> subjects = this.subjectDAO.getSubjects(subject);
		if (subjects != null) {
			for (int i = 0; i < subjects.size(); i++) {
				json.put(subjects.get(i).getSubjectCode(),subjects.get(i).getSubjectTitle());
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
