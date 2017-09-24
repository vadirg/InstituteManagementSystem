<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Student</title>
<script src="./JS/student.js"></script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id='registerStudent' action="saveStudent.htm" method="post">
		<div align="center"><span class='mainTitle' style="font: 16pt; text-decoration: blink;">Register Student</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<td><label>StudentId</label></td>
					<td><input type="text" id="studentId" name="studentId"></input></td>
				</tr>
				<tr>
					<td><label>First Name</label></td>
					<td><input type="text" id="firstName" name="studentFirstName"></input></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><input type="text" id="lastName" name="studentLastName"></input></td>
				</tr>
				<tr>
					<td><label>Semester</label></td>
					<td><select id="semester" name="semester">
							<option value=1>1st sem</option>
							<option value=2>2nd sem</option>
							<option value=3>3rd sem</option>
							<option value=4>4th sem</option>
							<option value=5>5th sem</option>
							<option value=6>6th sem</option>
							<option value=7>7th sem</option>
							<option value=8>8th sem</option>
					</select></td>
				</tr>
				<tr>
					<td><label>DeptId</label></td>
					<td><select id="deptId" name="deptId">
							<option value="">-Select-</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Father Name</label></td>
					<td><input type="text" id="fatherName"
						name="studentFatherName"></input></td>
				</tr>
				<tr>
					<td><label>Mother Name</label></td>
					<td><input type="text" id="motherName"
						name="studentMotherName"></input></td>
				</tr>
				<tr>
					<td><label>Date Of Birth</label></td>
					<td><input type="text" id="dateOfBirth"
						class="datepickerField" name="studentDOB" value="MM/DD/YYYY"></input></td>
				</tr>
				<tr>
					<td><label>Date Of Admission</label></td>
					<td><input type="text" id="dateOfAdmission"
						class="datepickerField" name="dateOfAdmission" value="MM/DD/YYYY"></input></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br>
					<input type="button" class="button" id='regButton' value="Register"
						onclick="validateStudentDetails();" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br>
					<label>${status}</label></td>
				</tr>
			</table>
		</form>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>