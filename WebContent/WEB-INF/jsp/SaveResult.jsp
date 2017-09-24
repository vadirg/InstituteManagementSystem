<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Internal results</title>
<script src="./JS/result.js"></script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="saveResultsForm">
			<input type="hidden" id="saveOrUpdate" value="save"> <input
				id="resultId" type="hidden" value="" />
				<div align="center"><span class='mainTitle'>Save Result</span></div>
			<table class="tableStyle" align="center">
				<tr>
					<th><label>Semester</label></th>
					<th><label>Department</label></th>
					<th><label>Exam</label></th>
					<th><label>Date</label></th>
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
					<td><select id="exam">
							<option value="">Select</option>
							<option value="1">1st-Internal</option>
							<option value="2">2nd-Internal</option>
							<option value="3">3rd-Internal</option>
					</select></td>
					<td><input value="MM/DD/YYYY" id="examDate"
						class="datepickerField"></td>
					<td><div id="subjectCodeDiv">
							<select id="subjectCode">
								<option value="">Select</option>
							</select>
						</div></td>
				</tr>
			</table>
			<br>
			<table class="tableStyle" align="center">
				<tr>
					<th>Student Id</th>
					<th>Marks scored</th>
					<th>Save</th>
				</tr>
				<tr>
					<td><input type="text" id="studentId1" /></td>
					<td><input type="text" id="marks1" /></td>
					<td><input type="checkbox" id="chkBox1"
						onclick="saveOrUpdateResult(1);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row1" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId2" /></td>
					<td><input type="text" id="marks2" /></td>
					<td><input type="checkbox" id="chkBox2"
						onclick="saveOrUpdateResult(2);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row2" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId3" /></td>
					<td><input type="text" id="marks3" /></td>
					<td><input type="checkbox" id="chkBox3"
						onclick="saveOrUpdateResult(3);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row3" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId4" /></td>
					<td><input type="text" id="marks4" /></td>
					<td><input type="checkbox" id="chkBox4"
						onclick="saveOrUpdateResult(4);" /></td>
				</tr>
				<tr>
					<td colspan="3" id="row4" align="center"></td>
				</tr>
				<tr>
					<td><input type="text" id="studentId5" /></td>
					<td><input type="text" id="marks5" /></td>
					<td><input type="checkbox" id="chkBox5"
						onclick="saveOrUpdateResult(5);" /></td>
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