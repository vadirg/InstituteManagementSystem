<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<script>
	function changePasswordCheck() {
		var flg = true;
		if ($("#password").val() == "") {
			$("#password").css("background", "red");
			flg = false;
		} else {
			$("#password").css("background", "white");
		}
		if ($("#newPassword").val() == "") {
			$("#newPassword").css("background", "red");
			flg = false;
		} else {
			$("#newPassword").css("background", "white");
		}
		if ($("#confirmPassword").val() == "") {
			$("#confirmPassword").css("background", "red");
			flg = false;
		} else {
			$("#confirmPassword").css("background", "white");
		}
		if ($("#confirmPassword").val() != $("#newPassword").val()) {
			$("#passwordError1").text(
					'New password and Confirm password do not match.!!!')
			$("#passwordError1").css("display", 'block');
			flg = false;
		}
		if ($("#confirmPassword").val() == $("#password").val()
				|| $("#confirmPassword").val() == $("#password").val()) {
			$("#passwordError1").text(
					'New password and old password should not match.!!!')
			$("#passwordError1").css("display", 'block');
			flg = false;
		}
		if (flg) {
			$("#changePasswordId").submit();
		} else {
			$("#passwordError").text('Enter all fields correctly.!!!')
			$("#passwordError").css("display", 'block');
		}
	}
</script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<form id="changePasswordId" action="chandgePassword.htm">
		<div align="center"><span class='mainTitle'>Change Password</span></div>
			<input type="hidden" value="<%=session.getAttribute("userName") %>" name="userName" />
			<table class="tableStyle" align="center">
				<tr>
					<td>Old Password</td>
					<td><input id='password' name='password' type="password" /></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input id='newPassword' name='newPassword' type="password" /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input id='confirmPassword' type="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" class="button" value="Change Password"
						onclick="changePasswordCheck();"></td>
				</tr>
			</table>
			<div align="center" id="passwordError1" style="display: none;"></div>
			<div align="center" id="passwordError2" style="display: none;"></div>
			<div align="center" id="passwordError" style="display: none;"></div>
			<c:if test="${status eq 'N'}">
				<center>
					<span>Old password does not match.!!!</span>
				</center>
			</c:if>
			<c:if test="${not empty change}">
				<center>
					<span>${change}</span>
				</center>
			</c:if>
		</form>
		<div id="footer" style="margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</div>
</body>
</html>