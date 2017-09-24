<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Report</title>
<script src="./JS/student.js"></script>
<script>
	function validateDept() {
		if ($("#deptId").val() == "") {
			flag = false;
			$("#deptId").css("background", "red");
			alert('Please select department');
		} else {
			$("#deptId").css("background", "white");
			$("#facultyReportId").submit();
		}
	}
</script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="facultyReportId" action="facultyReportAction.htm"
			method="post">
			<div align="center"><span class='mainTitle'>Faculty Report</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<th>Department</th>
					<td><select id="deptId" name="deptId">
							<option value="">-Select-</option>
					</select></td>
					<td align="center"><input id="reportButton" type="button" class="button"
						value="Generate Report" onclick="validateDept();" /></td>
				</tr>
			</table>
			<br>
			<c:if test="${not empty faculties}">
				<c:forEach varStatus="count" items="${faculties}" var="fctList">
					<c:if test='${count.last}'>
						<table class="tableStyle" border="1" align="center">
							<tr>
								<th>Department</th>
								<td>${fctList.faculty_department.deptId}</td>
							</tr>
						</table>
						<br>
					</c:if>
				</c:forEach>
				<table class="tableStyle" align="center" border="1">
					<tr>
						<th>Faculty Id</th>
						<th>Faculty Name</th>
						<th>Qualification</th>
						<th>Designation</th>
						<th>DOB</th>
						<th>DOJ</th>
					</tr>
					<c:forEach var="facultyList" items="${faculties}">
						<tr>
							<td>${facultyList.facultyId}</td>
							<td>${facultyList.facultyName}</td>
							<td>${facultyList.qualification}</td>
							<td>${facultyList.designation}</td>
							<td><fmt:formatDate type="date" value="${facultyList.facultyDOB}"></fmt:formatDate></td>
							<td><fmt:formatDate type="date" value="${facultyList.facultyDateOfJoining}"></fmt:formatDate></td>
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