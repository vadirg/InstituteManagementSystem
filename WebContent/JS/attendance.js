function saveOrUpdateAttendance(row) {

	if (document.getElementById("chkBox" + row).checked) {
		var flg = true;
		if ($("#semester").val() == "") {
			$("#semester").css("background", 'red');
			flg = flg && false;
		} else {
			$("#semester").css("background", 'white');
		}
		if ($("#deptId").val() == "") {
			$("#deptId").css("background", 'red');
			flg = flg && false;
		} else {
			$("#deptId").css("background", 'white');
		}
		if ($("#numOfClassAttend" + row).val() == "") {
			$("#numOfClassAttend" + row).css("background", 'red');
			flg = flg && false;
		} else {
			$("#numOfClassAttend" + row).css("background", 'white');
		}
		if ($("#numOfClassConducted" + row).val() == "" || $("#examDate").val() == "MM/DD/YYYY") {
			$("#numOfClassConducted" + row).css("background", 'red');
			flg = flg && false;
		} else {
			$("#numOfClassConducted" + row).css("background", 'white');
		}
		if ($("#subjectCode").val() == "") {
			$("#subjectCode").css("background", 'red');
			flg = flg && false;
		} else {
			$("#subjectCode").css("background", 'white');
		}
		if ($("#studentId" + row).val() == "") {
			$("#studentId" + row).css("background", 'red');
			flg = flg && false;
		} else {
			$("#studentId" + row).css("background", 'white');
		}
		if (flg) {

			var tmpUrl = "?semester=" + $("#semester").val();
			tmpUrl = tmpUrl + "&numOfClassConducted="
					+ $("#numOfClassConducted" + row).val() + "&subjectCode="
					+ $("#subjectCode").val() + "&studentId="
					+ $("#studentId" + row).val() + "&numOfClassAttend="
					+ $("#numOfClassAttend" + row).val() + "&saveOrUpdate="
					+ $("#saveOrUpdate").val() + "&attendanceId="
					+ $("#attendanceId").val() + "&deptId="+$("#deptId").val();

			$.ajax({
				url : "saveOrUpdateAttendance.htm" + tmpUrl,
				type : 'GET',
				dataType : 'text',
				contentType : 'application/text',
				success : function(data) {
					$("#row" + row).html("<label>" + data + "</label>");
				},
				error : function() {

				}

			});

		} else {
			alert("Please choose valid data for the fields highlighted with red mark");
			resetDetails();
			return;
		}

	}
}

function resetDetails(){
	for(var i=1;i<=5;i++){
		document.getElementById("chkBox" + row).checked=false;
		$("#row"+i).html("");
	}
}

function searchAttendance() {

	var flg = true;
	if ($("#semester").val() == "") {
		$("#semester").css("background", 'red');
		flg = flg && false;
	} else {
		$("#semester").css("background", 'white');
	}
	if ($("#subjectCode").val() == "") {
		$("#subjectCode").css("background", 'red');
		flg = flg && false;
	} else {
		$("#subjectCode").css("background", 'white');
	}
	if ($("#studentId").val() == "") {
		$("#studentId").css("background", 'red');
		flg = flg && false;
	} else {
		$("#studentId").css("background", 'white');
	}
	if (flg) {
		var tmpUrl = "?semester=" + $("#semester").val();
		tmpUrl = tmpUrl + "&subjectCode="
				+ $("#subjectCode").val() + "&studentId="
				+ $("#studentId").val();
		$.ajax({
			url : "searchAttendance.htm" + tmpUrl,
			type : 'GET',
			dataType : 'text',
			contentType : 'application/text',
			success : function(data) {
				if (data == "NOT") {
					$("#noRecordsSpan").css("display", "block");
					$("#attendanceTable").css("display", "none");
				} else {
					var resp = data.split("|");
					$("#numOfClassAttend").val(resp[1]);
					$("#attendanceId").val(resp[0]);
					$("#numOfClassConduct").val(resp[2]);
					$("#attendanceTable").css("display", "block");
					$("#noRecordsSpan").css("display", "none");
				}
			},
			error : function() {

			}

		});
	} else {
		alert("Please choose valid data for the fields highlighted with red mark");
		return;
	}

}

function enableUpdateButton() {
	$("#updateResultButton").removeAttr("disabled");
}

function UpdateAttendance() {

	var flg = false;
	if ($("#numOfClassAttend").val() <= $("#numOfClassConduct").val()) {
		flg = true;
	} else {
		alert("Number of class attended must be less than Number Of Class Conducted");
		return;
	}
	if (flg) {

		var tmpUrl = "?attendanceId=" + $("#attendanceId").val();
		tmpUrl = tmpUrl + "&numOfClassAttend=" + $("#numOfClassAttend").val() + "&numOfClassConducted="
				+ $("#numOfClassConduct").val() + "&saveOrUpdate="
				+ $("#saveOrUpdate").val();

		$.ajax({
			url : "saveOrUpdateAttendance.htm" + tmpUrl,
			type : 'GET',
			dataType : 'text',
			contentType : 'application/text',
			success : function(data) {
				$("#row").html("<label>" + data + "</label>");
			},
			error : function() {

			}

		});

	} else {
		alert("Please choose valid data for the fields highlighted with red mark");
		return;
	}

}

function validateReportFields(){
	var flg=true;
	if($("#semester").val()==""){
		$("#semester").css("background","red");
		flg=flg&&false;
	}else{
		$("#semester").css("background","white");
	}
	if($("#subjectCode").val()==""){
		$("#subjectCode").css("background","red");
		flg=flg&&false;
	}else{
		$("#subjectCode").css("background","white");
	}
	if ($("#deptId").val() == "") {
		flag = false;
		$("#deptId").css("background", "red");
		alert('Please select department Code');
	} else {
		$("#deptId").css("background", "white");
	}
	if(flg){
		$("#attendanceReportform").submit();
	}else{
		alert('Please choose valid data for the fields highlighted with red mark');
	}
}