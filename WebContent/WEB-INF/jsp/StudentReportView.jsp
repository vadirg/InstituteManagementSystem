<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Report</title>
<script src="./JS/student.js"></script>
<script>
	function validateSem() {
		var flag = true;

		if ($("#semester").val() == "") {
			flag = false;
			$("#semester").css("background", "red");
			alert("Please Select Semester");
		} else {
			$("#semester").css("background", "white");
		}
		if ($("#deptId").val() == "") {
			flag = false;
			$("#deptId").css("background", "red");
			alert('Please select department');
		} else {
			$("#deptId").css("background", "white");
		}
		if (flag) {
			$("#studentReportId").submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="studentReportId" action="studentReportAction.htm"
			method="post">
			<div align="center"><span class='mainTitle'>Student Report</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<th><label>Semester</label></th>
					<th>Department</th>
				</tr>
				<tr>
					<td align="center"><select id="semester" name="semester">
							<option value="">-Select-</option>
							<option value=1>1st sem</option>
							<option value=2>2nd sem</option>
							<option value=3>3rd sem</option>
							<option value=4>4th sem</option>
							<option value=5>5th sem</option>
							<option value=6>6th sem</option>
							<option value=7>7th sem</option>
							<option value=8>8th sem</option>
					</select></td>
					<td align="center"><select id="deptId" name="deptId">
					
							<option value="">-Select-</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="reportButton"
						type="button" class="button" value="Generate Report" onclick="validateSem();" /></td>
				</tr>
			</table>
			<br>
			<c:if test="${not empty students}">
				<c:forEach varStatus="count" items="${students}" var="stdList">
					<c:if test='${count.last}'>
						<table class="tableStyle" border="1" align="center">
							<tr>
								<th>Department</th>
								<th>Semester</th>
							</tr>
							<tr>
								<td>${stdList.department_student.deptId}</td>
								<td>${stdList.semester}</td>
							</tr>
						</table>
						<br>
					</c:if>
				</c:forEach>
				<table class="tableStyle" align="center" border="1">
					<tr>
						<th>Student Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Father Name</th>
						<th>Mother Name</th>
						<th>Date Of Birth</th>
					</tr>
					<c:forEach var="studentList" items="${students}">
						<tr>
							<td>${studentList.studentId}</td>
							<td>${studentList.studentFirstName}</td>
							<td>${studentList.studentLastName}</td>
							<td>${studentList.studentFatherName}</td>
							<td>${studentList.studentMotherName}</td>
							<td><fmt:formatDate type="date" value="${studentList.studentDOB}"></fmt:formatDate></td>
							
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${status eq 'N'}">
				<center>
					<label>No records found</label>
				</center>
			</c:if>
		</form>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>