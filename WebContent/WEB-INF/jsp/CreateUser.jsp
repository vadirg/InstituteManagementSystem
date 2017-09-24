<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
<link rel="stylesheet" href="./CSS/jquery-ui.css" type="text/css">
<script src="./JS/jquery-1.9.1.js"></script>
<script src="./JS/jquery-ui.js"></script>
<script>
function checkUnAndPsw(){
	var flg=true;
	if($('#userName').val()==''){
		$('#userName').css('background','red');
		flg=false;
	}else{
		$('#userName').css('background','white');
	}
	if($('#password').val()==''){
		$('#password').css('background','red');
		flg=false;
	}else{
		$('#password').css('background','white');
	}
	if(flg){
		$('#createUserForm').submit();
	}else{
		alert('Enter username and password before submitting');
	}
}
</script>
</head>
<body>
<div id="mainDiv">
<form id="createUserForm" action='createUser.htm'>

<table align="center">
<tr>
<th colspan="2">
Create User
</th>
</tr>
<tr>
<td>User Name</td><td><input type="text" name="userName" id="userName"/></td>
</tr>
<tr>
<td>Password</td><td><input type="text" name="password" id='password'></td>
</tr>
<tr><td colspan="2"><input type="button" class="button" value="Create User" onclick="checkUnAndPsw();"></td></tr>
</table>
<div align="center"></div>
</form>
</div>
</body>
</html>