<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Faculty</title>
<script src="./JS/faculty.js"></script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="registerFaculty" action="saveFaculty.htm" method="post">
		<div align="center"><span class='mainTitle'>Register Faculty</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<td><label>Faculty Name</label></td>
					<td><input type="text" id="facultyName" name="facultyName" /></td>
				</tr>
				<tr>
					<td><label>Qualification</label></td>
					<td><input type="text" id="qualification" name="qualification"></td>
				</tr>
				<tr>
					<td><label>Designation</label></td>
					<td><select id="designation" name="designation">
							<option value="ASSTPROF">Assistant Professor</option>
							<option value="LECT">Lecturer</option>
							<option value="HOD">Head Of Dept</option>
							<option value="PROF">Professor</option>
							<option value="PRIN">Principal</option>
							<option value="CLRK">Clerk</option>
							<option value="LABATND">Lab Attender</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Date Of Birth</label></td>
					<td><input type="text" id="facultyDOB" name="facultyDOB"
						class="datepickerField" /></td>
				</tr>
				<tr>
					<td><label>Date Of joining</label></td>
					<td><input type="text" id="facultyDateOfJoining"
						name="facultyDateOfJoining" class="datepickerField" /></td>
				</tr>
				<tr>
					<td><label>Department</label></td>
					<td><select id="deptId" name="deptId">
							<option value="">-Select-</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><br>
					<input type="button" class="button" value="Register"
						onclick="facultyDataValidation();" /></td>
				</tr>
				<tr>
					<td colspan="2"><label>${status}</label></td>
				</tr>
			</table>
		</form>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>