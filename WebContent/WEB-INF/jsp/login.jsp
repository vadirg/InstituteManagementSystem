<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

.tableStyleLogin {
	align-self: center;
	border: 1px solid;
	height: 26%;
	margin-left: 341px;
	margin-top: 110px;
	padding: 3%;
	width: 29%;
}
</style>
<link rel="stylesheet" href="./CSS/Style.css" type="text/css">
</head>
<body onload='document.f.j_username.focus();'>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
		<div class="content-body">
		<div id="logo">
			<img src="./CSS/images/LOGO.jpg" height="100"><span
				style="align-self: center; float: left; font-family: Trebuchet MS; font-size: 40pt; margin-bottom: -54%; padding-left: 16%;">Institute
				Management System</span>
		</div>
		
			<table class="tableStyleLogin">
			<tr><th colspan="2"><div align="center"><span class='mainTitle'>Login</span></div></th></tr>
				<tr>
					<td>User:</td>
					<td><input type='text' name='j_username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password' /></td>
				</tr>
				<tr>
					<td><input name="submit" type="submit" class="button"
						value="Login" /></td>
					<td colspan='2'><input name="reset" type="reset"
						class="button" /></td>
				</tr>
			</table>
		</div>
		<div id="footer" style="margin-left: 10%; margin-top: 3%;"><%@ include file="Footer.jsp"%></div>
	</form>
</body>
</html>