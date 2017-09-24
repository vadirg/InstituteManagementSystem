package com.inst.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inst.beans.Department;
import com.inst.beans.Student;
import com.inst.service.StudentDAO;

@Controller
public class StudentController {

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@RequestMapping(value="/saveStudent.htm")
	public String saveStudent(ModelMap model,HttpServletRequest request,HttpServletResponse response
			,Student student,Department dept){
		
	try{	
		if(student.getStudentId()==null){
			throw new Exception();
		}
		student.setDepartment_student(dept);
		String status=this.studentDAO.saveStudent(student);
		if(status.equalsIgnoreCase("success")){
			model.addAttribute("status", "Student registered successfully");
		}else{
			model.addAttribute("status", "Student Id is already present, try with new Id");
		}
	}catch(Exception e){
		e.printStackTrace();
		model.addAttribute("status", "Error occured while regestering student details");
	}
		return "RegisterStudent";
		
	}
	
	@RequestMapping(value="RegisterStudent.htm",method=RequestMethod.GET)
	public String RegisterStudentView(){
		return "RegisterStudent";
		
	}
	@RequestMapping(value="studentReportView.htm",method=RequestMethod.GET)
	public String StudentReportView(){
		return "StudentReportView";
		
	}
	
	@RequestMapping(value="studentReportAction.htm",method=RequestMethod.POST)
	public String StudentReport(ModelMap model,Student student, Department department){
		try{
		student.setDepartment_student(department);
		List<Student> students = studentDAO.generateStudentReport(student);
		
		if(students.size()>0 && students !=null){
			model.addAttribute("students", students);
		}else{
			model.addAttribute("status", "N");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "StudentReportView";
	}
	
	@RequestMapping(value="/searchStudent.htm")
	@SuppressWarnings("unchecked")
	public void searchStudent(HttpServletRequest request, HttpServletResponse response) {
		
		Student student = new Student();
		List<Student> studentList = new ArrayList<Student>();
		JSONObject json = new JSONObject();
		
	try {	
		String studentId = (String) request.getParameter("studentId");
		student.setStudentId(studentId);
		
		studentList = this.studentDAO.searchStudent(student);
		
		if((studentList != null) && (studentList.size() > 0)) {
			
			for(int i=0; i < studentList.size(); i++) {
				json.put("studentId", studentList.get(i).getStudentId());
				json.put("firstName", studentList.get(i).getStudentFirstName());
				json.put("lastName", studentList.get(i).getStudentLastName());
				json.put("fatherName", studentList.get(i).getStudentFatherName());
				json.put("motherName", studentList.get(i).getStudentMotherName());
				json.put("deptId", studentList.get(i).getDepartment_student().getDeptId());
				json.put("semester", studentList.get(i).getSemester());
				
				String dob = formatDateField(studentList.get(i).getStudentDOB().toString());
				json.put("dateOfBirth", dob);
				
				String doa = formatDateField(studentList.get(i).getDateOfAdmission().toString());
				json.put("dateOfAdmission", doa);
				
			}
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	
	@RequestMapping(value="/updateStudent.htm")
	public String updateStudent(ModelMap model, HttpServletRequest request,HttpServletResponse response, Student student, Department dept) {
		System.out.println(student.getStudentId());
	try {	
		if(student.getStudentId()==null){
			throw new Exception();
		}
		student.setDepartment_student(dept);
		String status = this.studentDAO.updateStudent(student);
		if(status.equalsIgnoreCase("success")) {
			model.addAttribute("status", "Student details updated successfully");
		}
		else {
			model.addAttribute("status", "Error occured while updating student details");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		model.addAttribute("status", "Error occured while updating student details");
	}
		return "SearchStudent";
		
	}
	
	
	@RequestMapping(value="SearchStudent.htm",method=RequestMethod.GET)
	public String SearchStudentView(){
		return "SearchStudent";	
	}
	
	
	public String formatDateField(String value) {
		String[] temp = value.split(" ");
		String[] data = temp[0].split("-");
		
		String year = data[0];
		String month = data[1];
		String date = data[2];
		
		String formatedDate = month + "/" + date + "/" + year;
		return formatedDate;
	}
}
