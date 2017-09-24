package com.inst.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inst.beans.Fees;
import com.inst.beans.Student;
import com.inst.service.StudentDAO;

@Controller
public class FeesController {
	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@RequestMapping(value = "payFee.htm", method = RequestMethod.GET)
	public String payFeeView() {
		return "Fee";
	}

	@RequestMapping(value = "searchFee.htm", method = RequestMethod.GET)
	public void searchFee(HttpServletRequest request,HttpServletResponse response) {
		
		Student student=new Student();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		student.setStudentId(request.getParameter("studentId"));
		try {
			List<Student> list=this.studentDAO.searchStudent(student);
			if(list.size()!=0){
				JSONObject json=new JSONObject();
				json.put("noRecord", "N");
				json.put("stdName", list.get(0).getStudentFirstName()+" "+list.get(0).getStudentLastName());
				json.put("semester", list.get(0).getSemester());
				json.put("deptId",list.get(0).getDepartment_student().getDepartmentName());
				List<Fees> feeList=this.studentDAO.searchFee(student);
				if(feeList.size()!=0){
					String date= feeList.get(0).getRecieptDate().toString();
					String[] dateArr=date.split(" ");
					json.put("recieptId", feeList.get(0).getRecieptId());
					json.put("date",dateArr[0]);
					json.put("academicYear",feeList.get(0).getAcademicYear());
					json.put("amt", feeList.get(0).getAmountPaid());
				}
				response.getWriter().write(json.toString());
			}else{
				JSONObject json=new JSONObject();
				json.put("noRecord", "Y");
				response.getWriter().write(json.toString());
			}
		} catch (Exception e) {
			try {
				e.printStackTrace();
				JSONObject json=new JSONObject();
				json.put("noRecord", "Y");
				response.getWriter().write(json.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping(value = "payFees.htm", method = RequestMethod.GET)
	public void payFees(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		Student student=new Student();
		Fees fees=new Fees();
		student.setStudentId(request.getParameter("studentId"));
		fees.setStudent_fees(student);
		if(!request.getParameter("recieptId").isEmpty()){
			fees.setRecieptId(Integer.parseInt(request.getParameter("recieptId")));
		}
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(request.getParameter("recieptDate"));
		Date date = new Date();
		try {
			date = dateFormat.parse(request.getParameter("recieptDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fees.setRecieptDate(date);
		fees.setAcademicYear(Integer.parseInt(request.getParameter("academicYear")));
		fees.setAmountPaid(Double.parseDouble(request.getParameter("amt")));
		try {
			this.studentDAO.saveFees(fees);
			JSONObject json=new JSONObject();
			json.put("noRecord", "N");
			response.getWriter().write(json.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject json=new JSONObject();
			json.put("noRecord", "Y");
			try {
				response.getWriter().write(json.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
