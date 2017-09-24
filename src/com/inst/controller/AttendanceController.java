package com.inst.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inst.beans.Attendance;
import com.inst.beans.Department;
import com.inst.beans.Student;
import com.inst.beans.Subject;
import com.inst.service.AttendanceDAO;
import com.inst.service.StudentDAO;

@Controller
public class AttendanceController {

	private AttendanceDAO attendanceDAO;
	
	public void setAttendanceDAO(AttendanceDAO attendanceDAO) {
		this.attendanceDAO = attendanceDAO;
	}

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@RequestMapping(value = "saveAttendanceView.htm")
	public String saveResultsView() {
		return "SaveAttendance";
	}

	@RequestMapping(value = "updateAttendanceView.htm")
	public String updateResultsView() {
		return "SearchAndupdateAttendance";
	}

	@RequestMapping(value = "saveOrUpdateAttendance.htm")
	public void saveOrUpdateResult(HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		Attendance attendance = new Attendance();
		
		attendance.setNumOfClassAttend(Integer.parseInt(request.getParameter("numOfClassAttend")));
		attendance.setNumOfClassPerSem(Integer.parseInt(request.getParameter("numOfClassConducted")));
		try {

			
			String status = "failure";
			if (request.getParameter("saveOrUpdate").equalsIgnoreCase("SAVE")) {
				Subject subject = new Subject();
				Student student = new Student();
				Department dept=new Department();
				student.setStudentId(request.getParameter("studentId"));
				dept.setDeptId(request.getParameter("deptId"));
				student.setDepartment_student(dept);
				student.setSemester(request.getParameter("semester"));
				subject.setSubjectCode(request.getParameter("subjectCode"));
				attendance.setSemester(request.getParameter("semester"));
				
				if (this.studentDAO.getSemester(student) == 0) {
					response.getWriter().write("Student details are incorrect, Verify and try again");
					return;
				}
				
				attendance.setSubject_attendance(subject);
				attendance.setStudent_attendance(student);
				status = attendanceDAO.saveAttendance(attendance);

				if (status.equalsIgnoreCase("SUCCESS")) {
					response.getWriter().write("Attendance saved successfully");
				} else {
					response.getWriter().write("Attendance already exits for this studentId");
				}

			} else if (request.getParameter("saveOrUpdate").equalsIgnoreCase("UPDATE")) {
				attendance.setAttendanceId(Integer.parseInt(request.getParameter("attendanceId")));
				status = attendanceDAO.updateAttendance(attendance);
				if (status.equalsIgnoreCase("SUCCESS")) {
					response.getWriter().write("Attendance updated successfully");
				} else {
					response.getWriter().write("Error occured while updating the Attendance");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().write("Error occured while updating the Attendance");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	@RequestMapping(value = "searchAttendance.htm")
	public void searchAttendance(HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		Student student = new Student();
		
		Subject subject = new Subject();
		student.setStudentId(request.getParameter("studentId"));
		subject.setSubjectCode(request.getParameter("subjectCode"));
		student.setSemester(request.getParameter("semester"));
		Attendance attendance = new Attendance();
		attendance.setStudent_attendance(student);
		attendance.setSubject_attendance(subject);
		try {
			Attendance searchResult = attendanceDAO.getStudentAttendance(attendance);
			if (searchResult != null) {

				response.getWriter().write(
						searchResult.getAttendanceId() + "|"
								+ searchResult.getNumOfClassAttend()  + "|" + searchResult.getNumOfClassPerSem());

			} else {
				response.getWriter().write("NOT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "generateAttendanceReportView.htm")
	public String generateAttendanceReportView() {
		return "AttendanceReport";
	}

	
	@RequestMapping(value="generateAttendanceReport.htm")
	public String attendanceReport(ModelMap model,HttpServletRequest request,HttpServletResponse response,Subject subject, Department  detDepartment) {
		
		try{
			Attendance attendance=new Attendance();
			attendance.setSemester(subject.getSemester());
			attendance.setSubject_attendance(subject);
			List<Attendance> attendances=this.attendanceDAO.generateAttendanceReport(attendance);
			if(attendances.size()>0 && attendance !=null){
				model.addAttribute("attendances", attendances);
			}else{
				model.addAttribute("status", "N");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "AttendanceReport";
		
	}
}
