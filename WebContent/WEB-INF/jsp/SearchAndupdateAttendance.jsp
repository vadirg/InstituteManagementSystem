<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search And Update Result</title>
<script src="./JS/attendance.js"></script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="searchDetails">
			<input type="hidden" id="saveOrUpdate" value="update">
			<div align="center"><span class='mainTitle'>Search And Update Attendance</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<td><label>Student Id</label></td>
					<td><input value="" id="studentId" type="text"></td>
				</tr>
				<tr>
					<td><label>Semester</label></td>
					<td><select id="semester">
							<option value="">Select</option>
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
					<td><label>Department</label></td>
					<td><select id="deptId" name="deptId"
						onchange="getSubjects();">
							<option value="">-Select-</option>
					</select></td>
				</tr>
				<tr>
					<td><label>Subject Code</label></td>
					<td><div id="subjectCodeDiv">
							<select id="subjectCode">
								<option value="">-Select-</option>
							</select>
						</div></td>
				</tr>
				<tr>
					<td align="right"><input type="reset" class="button" value="Reset" /></td>
					<td colspan="2" align="left"><input value="Search"
						type="button" class="button" onclick="searchAttendance();" /></td>
				</tr>
			</table>
		</form>
		<br>
		<input id="attendanceId" type="hidden" value="" />
		<div id="attendanceTable" align="center" style="display: none;">
			<table class="tableStyle"  align="center">
				<tr>
					<td><label>Number Of Classes Conducted</label></td>
					<td><input type="text" value="" id="numOfClassAttend"
						onchange="enableUpdateButton();"></td>
				</tr>
				<tr>
					<td><label>Number Of Classes Attended</label></td>
					<td><input type="text" value="" id="numOfClassConduct"
						onchange="enableUpdateButton();"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input id="updateResultButton"
						type="button" class="button" value="Update Result" disabled="disabled"
						onclick="UpdateAttendance();" /></td>
				</tr>
			</table>
		</div>
		<center>
			<span id="noRecordsSpan" style="display: none;">No records
				found for this Student Id</span>
		</center>
		<center>
			<span id="row"></span>
		</center>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>