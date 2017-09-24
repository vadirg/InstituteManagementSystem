package com.inst.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inst.beans.Department;
import com.inst.beans.Result;
import com.inst.beans.ResultReport;
import com.inst.beans.Student;
import com.inst.beans.Subject;
import com.inst.service.ResultDAO;
import com.inst.service.StudentDAO;

@Controller
public class ResultController {
	private ResultDAO resultDAO;
	private StudentDAO studentDAO;

	public void setResultDAO(ResultDAO resultDAO) {
		this.resultDAO = resultDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@RequestMapping(value = "saveResultsView.htm")
	public String saveResultsView() {
		return "SaveResult";
	}

	@RequestMapping(value = "updateResultsView.htm")
	public String updateResultsView() {
		return "SearchAndUpdateResult";
	}

	@RequestMapping(value = "saveOrUpdateResult.htm")
	public void saveOrUpdateResult(HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		Student student = new Student();
		Result result = new Result();
		Subject subject = new Subject();
		Department dept=new Department();
		student.setStudentId(request.getParameter("studentId"));
		student.setSemester(request.getParameter("semester"));
		dept.setDeptId(request.getParameter("deptId"));
		student.setDepartment_student(dept);
		subject.setSubjectCode(request.getParameter("subjectCode"));
		result.setStudent_result(student);
		result.setSubject_result(subject);
		result.setInternal(Integer.parseInt(request.getParameter("exam")));
		result.setMarks(Double.parseDouble(request.getParameter("marks")));
		try {

			if (this.studentDAO.getSemester(student) == 0) {
				response.getWriter().write(
						"Student details are incorrect, Verify and try again");
				return;
			}
			result.setSemester(request.getParameter("semester"));
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println(request.getParameter("examDate"));
			Date exmDate = dateFormat.parse(request.getParameter("examDate"));
			result.setResultDate(exmDate);
			String status = "failure";
			if (request.getParameter("saveOrUpdate").equalsIgnoreCase("SAVE")) {
				status = this.resultDAO.saveResult(result);

				if (status.equalsIgnoreCase("SUCCESS")) {
					response.getWriter().write("Result saved successfully");
				} else {
					response.getWriter().write(
							"Result already exits for this studentId");
				}

			} else if (request.getParameter("saveOrUpdate").equalsIgnoreCase(
					"UPDATE")) {
				result.setResultId(Integer.parseInt(request
						.getParameter("resultId")));
				status = this.resultDAO.updateResult(result);
				if (status.equalsIgnoreCase("SUCCESS")) {
					response.getWriter().write("Result update successfully");
				} else {
					response.getWriter().write(
							"Error occured while updating the result");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "searchResult.htm")
	public void searchResult(HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text");
		Student student = new Student();
		Result result = new Result();
		Subject subject = new Subject();
		student.setStudentId(request.getParameter("studentId"));
		result.setSemester(request.getParameter("semester"));
		subject.setSubjectCode(request.getParameter("subjectCode"));
		result.setStudent_result(student);
		result.setSubject_result(subject);
		result.setInternal(Integer.parseInt(request.getParameter("exam")));
		try {
			Result searchResult = this.resultDAO.getStudentResult(result);
			if (searchResult != null) {

				response.getWriter().write(
						searchResult.getResultId() + "|"
								+ searchResult.getMarks());

			} else {
				response.getWriter().write("NOT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "generateResultReportView.htm")
	public String generateResultReportView() {
		return "ResultReportView";
	}

	@RequestMapping(value = "generateResultReportAction.htm")
	public String generateResultReport(ModelMap model, Subject subject) {
		try {
			List<Result> results = this.resultDAO
					.getStudentResultReport(subject);
			List<ResultReport> resultReports = new ArrayList<ResultReport>();
			if (results.size() != 0 && results != null) {

				for (int i = 0; i < results.size(); i++) {
					String studentIds = "";
					String studentNames = "";
					double ia1 = 0;
					double ia2 = 0;
					double ia3 = 0;
					double avg = 0;
					double max1 = 0;
					double max2 = 0;
					ResultReport resultReportBean = new ResultReport();
					String StudId = results.get(i).getStudent_result()
							.getStudentId();
					for (int j = 0; j < results.size(); j++) {
						if (results.get(j).getStudent_result().getStudentId()
								.equalsIgnoreCase(StudId)
								&& !results.get(j).getStudent_result()
										.getStudentId()
										.equalsIgnoreCase("DONE")) {
							if (results.get(j).getInternal() == 1) {

								ia1 = results.get(j).getMarks();
								studentIds = results.get(j).getStudent_result()
										.getStudentId();
								studentNames = results.get(j)
										.getStudent_result()
										.getStudentFirstName()
										+ " "
										+ results.get(j).getStudent_result()
												.getStudentLastName();

							} else if (results.get(j).getInternal() == 2) {

								ia2 = results.get(j).getMarks();

							} else {

								ia3 = results.get(j).getMarks();
							}
						}

					}
					if (!studentIds.equalsIgnoreCase("")) {
						resultReportBean.setStudentId(studentIds);
						resultReportBean.setStudentName(studentNames);
						resultReportBean.setIa1(ia1);
						resultReportBean.setIa2(ia2);
						resultReportBean.setIa3(ia3);
						if (ia1 >= ia2 && ia1 >= ia3) {
							max1 = ia1;
							if (ia2 >= ia3) {
								max2 = ia2;
							} else {
								max2 = ia3;
							}

						} else if (ia2 >= ia1 && ia2 >= ia3) {
							max1 = ia2;
							if (ia1 >= ia3) {
								max2 = ia1;
							} else {
								max2 = ia3;
							}
						} else if (ia3 >= ia1 && ia3 >= ia2) {
							max1 = ia3;
							if (ia1 >= ia2) {
								max2 = ia1;
							} else {
								max2 = ia2;
							}
						}
						avg = (max1 + max2) * 0.5;
						resultReportBean.setAvg(avg);
						resultReports.add(resultReportBean);
					}
					results.get(i).getStudent_result().setStudentId("DONE");
				}

			} else {
				model.addAttribute("status", 'N');
			}
			Set<ResultReport> resultReportSet = new HashSet<ResultReport>();
			for (int i = 0; i < resultReports.size(); i++) {
				resultReportSet.add(resultReports.get(i));
			}

			Iterator<ResultReport> iterator = resultReportSet.iterator();
			List<ResultReport> resultReportList = new ArrayList<ResultReport>();
			while (iterator.hasNext()) {
				resultReportList.add(iterator.next());
			}
			model.addAttribute("subject", results.get(0).getSubject_result()
					.getSubjectTitle());
			model.addAttribute("semester", results.get(0).getSemester());
			model.addAttribute("resultReportList", resultReportList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("status", 'N');
		}
		return "ResultReportView";

	}

}
