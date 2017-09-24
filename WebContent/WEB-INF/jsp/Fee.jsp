<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fees</title>
<script>
	function validateFeeInput() {
		if ($("studentId").val() == "") {
			$("studentId").css("background", "red");
			alert("Please  enter student Id");
		} else {
			$("studentId").css("background", "white");
			var tempUrl = "?studentId=" + $('#studentId').val();

			$
					.ajax({
						url : "searchFee.htm" + tempUrl,
						type : 'GET',
						dataType : 'json',
						contentType : 'application/json',
						success : function(data) {

							if (data.noRecord == "Y") {
								$("#noRecord").html("No records found.!!! ");
								$("#noRecord").show();
							} else {
								$("#showDetails").show();
								$.each(data, function(key, value) {
									$("#" + key).html(value);
									$("#" + key).val(value);
								});
							}
						},
						error : function() {
							$("#noRecord")
									.html(
											"Error occured, contact your admin more info.!!! ");
						}

					});
		}
	}

	function payAmt() {
		$("#noRecord").hide();
		var flg = true;
		if ($("#studentId").val() == "") {
			$("#studentId").css("backgrond", "red");
			flg = false;
		} else {
			$("#studentId").css("backgrond", "red");
		}
		if ($("#academicYear").val() == "") {
			$("#academicYear").css("backgrond", "red");
			flg = false;
		} else {
			$("#academicYear").css("backgrond", "white");
		}
		if ($("#date").val() == "MM/DD/YYYY" ||$("#date").val() == "") {
			$("#date").css("backgrond", "red");
			flg = false;
		} else {
			$("#date").css("backgrond", "white");
		}
		if ($("#amt").val() == "") {
			$("#amt").css("backgrond", "red");
			flg = false;
		} else {
			$("#amt").css("backgrond", "white");
		}

		if (flg) {

			var tempUrl = "?studentId=" + $('#studentId').val() + "&recieptId="
					+ $('#recieptId').val() + "&recieptDate=" + $('#date').val()
					+ "&academicYear=" + $('#academicYear').val() + "&amt="
					+ $('#amt').val();

			
					$.ajax({
						url : "payFees.htm" + tempUrl,
						type : 'GET',
						dataType : 'json',
						contentType : 'application/json',
						success : function(data) {

							if (data.noRecord == "Y") {
								$("#noRecord")
										.html(
												"Payment failed due to severe error, Contact admin for more information.!!! ");
								$("#noRecord").show();
							} else {
								$("#noRecord").html("Payment successful.!!! ");
								$("#noRecord").show();
							}
						},
						error : function() {
							$("#noRecord")
									.html(
											"Error occured, contact your admin more info.!!! ");
						}

					});

		} else {
			alert("Please enter all details correctly, highlighed with red colour");
		}
	}
</script>
</head>
<body>
	<div id="mainDiv" class="content-body">
		<div id="header"><%@ include file="Header.jsp"%></div>
		<table class="tableStyle" align="center" style="margin-top: 35px">
			<tr>
				<th>Student Id</th>
				<td><input type="text" id="studentId"></td>
				<td><input type="button" value="Search" class="button"
					onclick="validateFeeInput();"></td>
			</tr>
		</table>
		<br>
		<div id="showDetails" style="display: none;">
			<table border="1" class="tableStyle" align="center">
				<tr>
					<td>Student Name</td>
					<td><span id="stdName"></span></td>
				</tr>
				<tr>
					<td>Semester</td>
					<td><span id="semester"></span></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><span id=deptId></span></td>
				</tr>
				<tr>
					<td>Reciept Id :<input readonly="readonly" value=""
						id="recieptId" name="recieptId"></td>
					<td>Date :<input value="MM/DD/YYYY" class="datepickerField"
						type="text" id="date" name="date" /></td>
				</tr>
				<tr>
					<td>Academic year :<input type="text" id="academicYear"
						name="academicYear" maxlength="4"/></td>
					<td>Amount Paid : <input type="text" id="amt" name="amt" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button"
						value="Pay" class="button" onclick="payAmt();" /></td>
				</tr>
			</table>
		</div>
		<center>
			<span id="noRecord" style="text-decoration: blink; display: none;"></span>
		</center>
		<div id="footer" style="margin-top: 3%;"><%@ include
				file="Footer.jsp"%></div>
	</div>
</body>
</html>