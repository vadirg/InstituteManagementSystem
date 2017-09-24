<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Report</title>
<script>
	function validateResReport() {
		var flag = true;

		if ($("#semester").val() == "") {
			flag = false;
			$("#semester").css("background", "red");
			alert("Please Select Semester");
		} else {
			$("#semester").css("background", "white");
		}
		if ($("#subjectCode").val() == "") {
			flag = false;
			$("#subjectCode").css("background", "red");
			alert('Please select subject Code');
		} else {
			$("#subjectCode").css("background", "white");
		}
		if ($("#deptId").val() == "") {
			flag = false;
			$("#deptId").css("background", "red");
			alert('Please select department Code');
		} else {
			$("#deptId").css("background", "white");
		}
		if (flag) {
			$("#ResultReportId").submit();
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="ResultReportId" action="generateResultReportAction.htm"
			method="post">
			<div align="center"><span class='mainTitle'>Result Report</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<th><label>Semester</label></th>
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
					<td colspan="3" align="center"><input type="button" class="button"
						value="Generate Report" onclick="validateResReport();"></td>
				</tr>
			</table>
			<br> <br>
			
			<c:if test="${not empty resultReportList}">
				<table class="tableStyle" align="center" border="1">
					<tr>
						<th>Semester</th>
						<th>Subject</th>
					</tr>
					<tr>
						<td>${semester}</td>
						<td>${subject}</td>
					</tr>
					<tr>
						<th>Student Id</th>
						<th>Name</th>
						<th>Internal 1</th>
						<th>Internal 2</th>
						<th>Internal 3</th>
						<th>Avg</th>
					</tr>
					<c:forEach items="${resultReportList}" var='lists'>
						<tr>
							<td>${lists.studentId}</td>
							<td>${lists.studentName}</td>
							<td>${lists.ia1}</td>
							<td>${lists.ia2}</td>
							<td>${lists.ia3}</td>
							<td>${lists.avg}</td>
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