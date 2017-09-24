<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance report</title>
<script src="./JS/attendance.js"></script>
</head>
<body>
	<div id="mainDiv" class="content-body">
	<div id="header"><%@ include file="Header.jsp" %></div>
		<form id="attendanceReportform" method="post"
			action="generateAttendanceReport.htm">
			<div align="center"><span class='mainTitle'>Attendance Report</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<th>Semester</th>
					<th>Department</th>
					<th>Subject</th>
				</tr>
				<tr>
					<td><select id="semester" name="semester">
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
					<td><select id="deptId" name="deptId" onchange="getSubjects();">
							<option value="">-Select-</option>
					</select></td>
					<td><div id="subjectCodeDiv">
							<select id="subjectCode" name="subjectCode">
								<option value="">-Select-</option>
							</select>
						</div></td>
						
				</tr>
				<tr>
					<td colspan="3" align="center"><br><input type="button" class="button"
						value="Generate Report" onclick="validateReportFields();" /></td>
				</tr>
			</table>
			<br>
			<c:if test="${not empty attendances}">
				<c:forEach varStatus="count" items="${attendances}" var="attndList">
					<c:if test='${count.last}'>
						<table class="tableStyle" border="1" align="center">
							<tr>
								<th>Semester</th>
								<th>Subject</th>
							</tr>
							<tr>
								<td>${attndList.semester}</td>
								<td>${attndList.subject_attendance.subjectTitle}</td>
							</tr>
						</table>
						<br>
					</c:if>
				</c:forEach>
				<table class="tableStyle" align="center" border="1">
					<tr>
						<th>Student Id</th>
						<th>No of Class Conducted</th>
						<th>No of Class attended</th>
					</tr>
					<c:forEach var="attList" items="${attendances}">
						<tr>
							<td>${attList.student_attendance.studentId}</td>
							<td>${attList.numOfClassPerSem}</td>
							<td>${attList.numOfClassAttend}</td>
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