<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Faculty</title>
<script src="./JS/faculty.js"></script>
</head>
<body>
	<div class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<div align="center">
			<span class='mainTitle'>Search and Update faculty Details</span>
		</div>
		<div class="searchPanel">
			<div class="search">
				<table
					style="width: 45%; display: inline-block; text-align: center; margin-left: 10%; margin-top: 2%;">
					<tbody>
						<tr>
							<td>Faculty ID</td>
							<td><input type="text" id="searchFacultyId"
								name="searchFacultyId"></td>
							<td>
								<button class="button" style="display: inline-block;"
									value="Search" onclick="searchFacultyDetails();">Search</button>
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
			<form id='updateFaculty' action="updateFaculty.htm" method="post">
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
								<td>Faculty ID</td>
								<td><input type="text" readonly="readonly" id="facultyId"
									name="facultyId"></td>
							</tr>
							<tr>
								<td>Faculty Name</td>
								<td><input type="text" readonly="readonly" id="facultyName"
									name="facultyName"></td>

								<td>Department ID</td>
								<td><input type="text" readonly="readonly" id="deptId"
									name="deptId"></td>
							</tr>
							<tr>
								<td>Qualification</td>
								<td><input type="text" readonly="readonly"
									id="qualification" name="qualification"></td>

								<td>Designation</td>
								<td><input type="text" readonly="readonly" id="designation"
									name="designation"></td>
							</tr>
							<tr>
								<td>Date Of Birth</td>
								<td><input type="text" readonly="readonly" id="dateOfBirth"
									class="datepickerField" name="facultyDOB" value="MM/DD/YYYY"></td>

								<td>Date Of Joining</td>
								<td><input type="text" readonly="readonly"
									id="dateOfJoining" class="datepickerField"
									name="facultyDateOfJoining" value="MM/DD/YYYY"></td>
							</tr>
						</tbody>
					</table>


				</div>
				<sec:authorize ifAnyGranted="ROLE_ADMIN">
				<div style="float: right; margin-top: 1%;">
					<input type="button" class="button" value="Edit"
						onclick="editFacultyDetails()" /> <input type="button"
						class="button" value="Update" onclick="updateFacultyDetails();" />
				</div>
				</sec:authorize>
			</form>
		</div>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>