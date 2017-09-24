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
import com.inst.beans.Faculty;
import com.inst.beans.Users;
import com.inst.service.FacultyDAO;

@Controller
public class FacultyController {

	private FacultyDAO facultyDAO;

	public FacultyDAO getFacultyDAO() {
		return facultyDAO;
	}

	public void setFacultyDAO(FacultyDAO facultyDAO) {
		this.facultyDAO = facultyDAO;
	}

	@RequestMapping(value = "saveFaculty.htm")
	public String saveFaculty(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, Faculty faculty, Department dept) {
		try {
			faculty.setFaculty_department(dept);
			String status = this.facultyDAO.saveFaculty(faculty);
			if (status.equalsIgnoreCase("SUCCESS")) {
				model.addAttribute("status","Faculty registered successfully");
			} else {
				model.addAttribute("status","Faculty registration failed, contact admin for more informaiton");
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("status","Registration failed due to fatal error");
		}
		return "RegisterFaculty";

	}
	
	@RequestMapping(value="registerFaculty.htm", method=RequestMethod.GET)
	public String registerFaculty() {
		return "RegisterFaculty";
		
	}
	
	@RequestMapping(value="FacultyReportView.htm", method=RequestMethod.GET)
	public String facultyReport() {
		return "FacultyReport";
		
	}
	@RequestMapping(value="facultyReportAction.htm", method=RequestMethod.POST)
	public String getfacultyReport(ModelMap model, Department department) {
		
		try {
			List<Faculty> faculties = facultyDAO.getfacultyReport(department);
			if(faculties.size()>0 && faculties !=null){
				model.addAttribute("faculties", faculties);
			}else{
				model.addAttribute("status", "N");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FacultyReport";
		
	}
	

	@RequestMapping(value="chandgePasswordView.htm", method=RequestMethod.GET)
	public String changePasswordView() {
		return "ChangePassword";
		
	}
	
	@RequestMapping(value="chandgePassword.htm")
	public String createUserAction(ModelMap model,HttpServletRequest request,HttpServletResponse response,Users users) {
		
		String sucFail=this.facultyDAO.checkOldPassword(users);
		try{
		if(sucFail.equalsIgnoreCase("SUCCESS")){
			users.setPassword(request.getParameter("newPassword"));
				String suc=this.facultyDAO.changePassword(users);
				if(suc.equalsIgnoreCase("SUCCESS")){
					model.addAttribute("change","Password changed successfully");
				}else{
					model.addAttribute("change","User does not exists");
				}
		}else{
			model.addAttribute("status","N");
		}
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("change","User does not exists");
		}
			
		return "ChangePassword";
 
	}
	
	
	@RequestMapping(value="/searchFaculty.htm")
	@SuppressWarnings("unchecked")
	public void searchFaculty(HttpServletRequest request, HttpServletResponse response) {
		
		Faculty faculty = new Faculty();
		List<Faculty> facultyList = new ArrayList<Faculty>();
		JSONObject json = new JSONObject();
		
	try {	
		String facultyId = (String) request.getParameter("facultyId");
		faculty.setFacultyId(Integer.parseInt(facultyId));
		
		facultyList = this.facultyDAO.searchFaculty(faculty);
		
		if((facultyList != null) && (facultyList.size() > 0)) {
			
			for(int i=0; i < facultyList.size(); i++) {
				json.put("facultyId", facultyList.get(i).getFacultyId());
				json.put("facultyName", facultyList.get(i).getFacultyName());
				json.put("deptId", facultyList.get(i).getFaculty_department().getDeptId());
				json.put("qualification", facultyList.get(i).getQualification());
				json.put("designation", facultyList.get(i).getDesignation());
				
				String dob = formatDateField(facultyList.get(i).getFacultyDOB().toString());
				json.put("dateOfBirth", dob);
				
				String doa = formatDateField(facultyList.get(i).getFacultyDateOfJoining().toString());
				json.put("dateOfJoining", doa);
				
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
	
	
	@RequestMapping(value="SearchFaculty.htm", method=RequestMethod.GET)
	public String SearchFacultyView() {
		return "SearchFaculty";
		
	}
	
	
	@RequestMapping(value="/updateFaculty.htm")
	public String updateFaculty(ModelMap model, HttpServletRequest request,HttpServletResponse response, Faculty faculty, Department dept) {
	try {
		faculty.setFaculty_department(dept);
		String status = this.facultyDAO.updateFaculty(faculty);
		if(status.equalsIgnoreCase("success")) {
			model.addAttribute("status", "Faculty details updated successfully");
		}
		else {
			model.addAttribute("status", "Error occured while updating faculty details");
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		model.addAttribute("status", "Error occured while updating faculty details");
	}
		return "SearchFaculty";
		
	}
	
	
	public String formatDateField(String value) {
		String[] temp = value.split(" ");
		String[] data = temp[0].split("-");
		
		String year = data[0];
		String month = data[1];
		String date = data[2];
		
		String formatedDate = month + "/" + date + "/" + year;
		return formatedDate;
	};

}
