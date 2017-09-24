<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Student</title>

<script src="./JS/student.js"></script>

</head>
<body>
	<div class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<div align="center">
			<span class='mainTitle'>Search and Update Student Details</span>
		</div>
		<div class="searchPanel">
			<div class="search">
				<table
					style="width: 45%; display: inline-block; text-align: center; margin-left: 10%; margin-top: 2%;">
					<tbody>
						<tr>
							<td>Student ID</td>
							<td><input type="text" id="searchStudentId"
								name="searchStudentId"></td>
							<td>
								<button class="button" style="display: inline-block;"
									value="Search" onclick="searchStudentDetails();">Search</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div style="margin-top: 2%; text-align: center;">
			<label>${status}</label>
		</div>


		<div id="showDetails" style="display: none;">
			<form id='updateStudentId' action="updateStudent.htm" method="post">
				<div style="margin-top: 5%; border: 1px solid;">

					<table style="width: 100%; text-align: center;">
						<thead>
							<tr>
								<th colspan="2" style="width: 50%"></th>
								<th colspan="2" style="width: 50%"></th>
							</tr>
						</thead>
						<tbody>
							<tr style="display: none;">
								<td>Student ID</td>
								<td><input type="text" readonly="readonly" id="studentId"
									name="studentId"></td>
							</tr>
							<tr>
								<td>First Name</td>
								<td><input type="text" readonly="readonly" id="firstName"
									name="studentFirstName"></td>

								<td>Last Name</td>
								<td><input type="text" readonly="readonly" id="lastName"
									name="studentLastName"></td>
							</tr>
							<tr>
								<td>Father Name</td>
								<td><input type="text" readonly="readonly" id="fatherName"
									name="studentFatherName"></td>

								<td>Mother Name</td>
								<td><input type="text" readonly="readonly" id="motherName"
									name="studentMotherName"></td>
							</tr>
							<tr>
								<td>Department ID</td>
								<td><input type="text" readonly="readonly" id="deptId"
									name="deptId"></td>

								<td>Semester</td>
								<td><input type="text" readonly="readonly" id="semester"
									name="semester"></td>
							</tr>
							<tr>
								<td>Date Of Birth</td>
								<td><input type="text" readonly="readonly" id="dateOfBirth"
									class="datepickerField" name="studentDOB" value="MM/DD/YYYY"></td>

								<td>Date Of Admission</td>
								<td><input type="text" readonly="readonly"
									id="dateOfAdmission" class="datepickerField"
									name="dateOfAdmission" value="MM/DD/YYYY"></td>
							</tr>
						</tbody>
					</table>


				</div>
				<div style="float: right; margin-top: 1%;">
				<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<input type="button" class="button" value="Edit" onclick="editStudentDetails()" />
						<input type="button" class="button" value="Update" onclick="updateStudentDetails();" />
				</sec:authorize>
				</div>
			</form>
		</div>
		<div id="footer" style="margin-top: 3%;"><%@ include
				file="Footer.jsp"%></div>
	</div>
</body>
</html>