
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Institute Management</title>

<link rel="stylesheet" href="./CSS/jquery-ui.css" type="text/css">
<link rel="stylesheet" href="./CSS/Style.css" type="text/css">
<script src="./JS/jquery-1.9.1.js"></script>
<script src="./JS/jquery-ui.js"></script>
<script src="./JS/utilities.js"></script>

</head>
<body>

	<div>
		<div id="logo">
			<img src="./CSS/images/LOGO.jpg" height="100"
				style="margin-left: 5%;"><span
				style="align-self: center; float: right; font-family: Trebuchet MS; font-size: 40pt; margin-right: 12%;">Institute
				Management System</span>
		</div>
		<div id="wrap">
			<ul class="navbar">
				<li><a href="welcome">Home</a></li>
				<li><a href="#">Student</a>
					<ul>
						<sec:authorize ifAnyGranted="ROLE_ADMIN">
							<li><a href="RegisterStudent.htm">Student Registration</a></li>
						</sec:authorize>
						<li><a href="SearchStudent.htm">Search Student</a></li>
						<li><a href="studentReportView.htm">Students Report</a></li>
					</ul></li>
				<li><a href="#">Faculty</a>
					<ul>
						<sec:authorize ifAnyGranted="ROLE_ADMIN">
							<li><a href="registerFaculty.htm">Register Faculty</a></li>
						</sec:authorize>
						<li><a href="SearchFaculty.htm">Search Faculty </a></li>
						<li><a href="FacultyReportView.htm">Faculties Report</a></li>
					</ul></li>
				<li><a href="#">Attendance</a>
					<ul>
						<li><a href="saveAttendanceView.htm">Save Attendance</a></li>
						<li><a href="updateAttendanceView.htm">Update Attendance</a></li>
						<li><a href="generateAttendanceReportView.htm">Attendance
								Report</a></li>
					</ul></li>
				<li><a href="#">Result</a>
					<ul>
						<li><a href="saveResultsView.htm">Save Result</a></li>
						<li><a href="updateResultsView.htm">Update Result</a></li>
						<li><a href="generateResultReportView.htm">Result Report</a></li>
					</ul></li>
				<li><a href="Courses.htm">Courses</a></li>
				<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<li><a href="payFee.htm">Fees</a></li>
				</sec:authorize>
				<li><a href="#"><%=session.getAttribute("userName")%></a>
					<ul>
						<li><a href="chandgePasswordView.htm">Change Password</a></li>
						<li><a href="logout">Logout</a></li>
					</ul></li>
			</ul>
		</div>

	</div>
	<br>
</body>
</html>