<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save New Attendance</title>
<script src="./JS/attendance.js"></script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="saveAttedanceForm">
			<input type="hidden" id="saveOrUpdate" value="save"> <input
				id="attendanceId" type="hidden" value="" />
				<div align="center"><span class='mainTitle'>Save Attendance</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<th><label>Semester</label></th>
					<th>Department</th>
					<th><label>Subject Code</label></th>
				</tr>
				<tr>
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
					<td><select id="deptId" name="deptId"
						onchange="getSubjects();">
							<option value="">-Select-</option>
					</select></td>
					<td><div id="subjectCodeDiv">
							<select id="subjectCode">
								<option value="">-Select-</option>
							</select>
						</div></td>
				</tr>
			</table>
			<br>
			<table class="tableStyle" align="center">
				<tr>
					<th>Student Id</th>
					<th>Number Of Class Attended</th>
					<th>Number Of Class Conducted</th>
					<th>Save</th>
				</tr>
				<tr>
					<td><input type="text" id="studentId1" /></td>
					<td><input type="text" id="numOfClassAttend1" /></td>
					<td><input type="text" id="numOfClassConducted1" /></td>
					<td><input type="checkbox" id="chkBox1"
						onclick="saveOrUpdateAttendance(1);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row1" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId2" /></td>
					<td><input type="text" id="numOfClassAttend2" /></td>
					<td><input type="text" id="numOfClassConducted2" /></td>
					<td><input type="checkbox" id="chkBox2"
						onclick="saveOrUpdateAttendance(2);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row2" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId3" /></td>
					<td><input type="text" id="numOfClassAttend3" /></td>
					<td><input type="text" id="numOfClassConducted3" /></td>
					<td><input type="checkbox" id="chkBox3"
						onclick="saveOrUpdateAttendance(3);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row3" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId4" /></td>
					<td><input type="text" id="numOfClassAttend4" /></td>
					<td><input type="text" id="numOfClassConducted4" /></td>
					<td><input type="checkbox" id="chkBox4"
						onclick="saveOrUpdateAttendance(4);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row4" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId5" /></td>
					<td><input type="text" id="numOfClassAttend5" /></td>
					<td><input type="text" id="numOfClassConducted5" /></td>
					<td><input type="checkbox" id="chkBox5"
						onclick="saveOrUpdateAttendance(5);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row5" align="center"></td>
				</tr>
			</table>
			<center>
				<input type="reset" class="button" value="Reset" onclick="resetDetails();" />
			</center>
		</form>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>